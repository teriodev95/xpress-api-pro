package com.example.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.HttpResponse;
import io.micronaut.transaction.annotation.Transactional;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("/test-db")
public class DatabaseTestController {

    private final DataSource dataSource;

    @Inject
    public DatabaseTestController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Get("/connection")
    @Transactional
    public HttpResponse<?> testConnection() {
        Map<String, Object> response = new HashMap<>();
        
        try (Connection connection = dataSource.getConnection()) {
            response.put("connectionSuccess", true);
            response.put("databaseName", connection.getCatalog());
            response.put("databaseUrl", connection.getMetaData().getURL());
            response.put("databaseProduct", connection.getMetaData().getDatabaseProductName());
            response.put("databaseVersion", connection.getMetaData().getDatabaseProductVersion());
            return HttpResponse.ok(response);
        } catch (SQLException e) {
            response.put("connectionSuccess", false);
            response.put("errorMessage", e.getMessage());
            return HttpResponse.serverError(response);
        }
    }
    
    @Get("/tables")
    @Transactional
    public HttpResponse<?> listTables() {
        Map<String, Object> response = new HashMap<>();
        
        try (Connection connection = dataSource.getConnection();
             ResultSet tables = connection.getMetaData().getTables(null, null, "%", new String[]{"TABLE"})) {
            
            Map<String, Object> tablesList = new HashMap<>();
            int count = 0;
            
            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                tablesList.put("table_" + count, tableName);
                count++;
            }
            
            response.put("connectionSuccess", true);
            response.put("tablesCount", count);
            response.put("tables", tablesList);
            
            return HttpResponse.ok(response);
        } catch (SQLException e) {
            response.put("connectionSuccess", false);
            response.put("errorMessage", e.getMessage());
            return HttpResponse.serverError(response);
        }
    }
    
    @Get("/check-usuarios")
    @Transactional
    public HttpResponse<?> checkUsuariosTable() {
        Map<String, Object> response = new HashMap<>();
        
        try (Connection connection = dataSource.getConnection()) {
            // Comprobar si la tabla existe
            boolean tableExists = false;
            try (ResultSet tables = connection.getMetaData().getTables(null, null, "usuarios", null)) {
                tableExists = tables.next();
            }
            
            response.put("tableExists", tableExists);
            
            if (tableExists) {
                // Obtener información sobre las columnas de la tabla
                List<Map<String, Object>> columns = new ArrayList<>();
                try (ResultSet columnsRs = connection.getMetaData().getColumns(null, null, "usuarios", null)) {
                    while (columnsRs.next()) {
                        Map<String, Object> column = new HashMap<>();
                        column.put("name", columnsRs.getString("COLUMN_NAME"));
                        column.put("type", columnsRs.getString("TYPE_NAME"));
                        column.put("size", columnsRs.getInt("COLUMN_SIZE"));
                        column.put("nullable", columnsRs.getBoolean("IS_NULLABLE"));
                        columns.add(column);
                    }
                }
                response.put("columns", columns);
                
                // Contar registros
                try (PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM usuarios");
                     ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        response.put("rowCount", rs.getInt(1));
                    }
                }
                
                // Obtener una muestra de datos si hay registros
                try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuarios LIMIT 5");
                     ResultSet rs = stmt.executeQuery()) {
                    
                    List<Map<String, Object>> sampleData = new ArrayList<>();
                    while (rs.next()) {
                        Map<String, Object> row = new HashMap<>();
                        for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                            String columnName = rs.getMetaData().getColumnName(i);
                            Object value = rs.getObject(i);
                            row.put(columnName, value);
                        }
                        sampleData.add(row);
                    }
                    
                    if (!sampleData.isEmpty()) {
                        response.put("sampleData", sampleData);
                    }
                }
            }
            
            return HttpResponse.ok(response);
        } catch (SQLException e) {
            response.put("success", false);
            response.put("errorMessage", e.getMessage());
            return HttpResponse.serverError(response);
        }
    }
} 