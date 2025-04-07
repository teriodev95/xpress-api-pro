package com.example.model;

import io.micronaut.serde.annotation.Serdeable;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Serdeable
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UsuarioID")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido_Paterno")
    private String apellidoPaterno;

    @Column(name = "Apellido_Materno")
    private String apellidoMaterno;

    @Column(name = "Tipo")
    private String tipo;

    @Column(name = "Pin")
    private Integer pin;

    @Column(name = "Usuario")
    private String usuario;

    @Column(name = "Puede_verificar_asignaciones")
    private Boolean puedeVerificarAsignaciones;

    @Column(name = "Puede_cobrar")
    private Boolean puedeCobrar;

    @Column(name = "Status")
    private Boolean status;

    @Column(name = "Gerencia")
    private String gerencia;

    @Column(name = "Agencia")
    private String agencia;

    @Column(name = "Fecha_ingreso")
    private LocalDateTime fechaIngreso;

    @Column(name = "Telegram_id")
    private String telegramId;

    @Column(name = "Numero_celular")
    private String numeroCelular;

    @Column(name = "Created_at")
    private LocalDateTime createdAt;

    @Column(name = "Updated_at")
    private LocalDateTime updatedAt;

    // Constructor por defecto requerido por JPA
    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getPuedeVerificarAsignaciones() {
        return puedeVerificarAsignaciones;
    }

    public void setPuedeVerificarAsignaciones(Boolean puedeVerificarAsignaciones) {
        this.puedeVerificarAsignaciones = puedeVerificarAsignaciones;
    }

    public Boolean getPuedeCobrar() {
        return puedeCobrar;
    }

    public void setPuedeCobrar(Boolean puedeCobrar) {
        this.puedeCobrar = puedeCobrar;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getTelegramId() {
        return telegramId;
    }

    public void setTelegramId(String telegramId) {
        this.telegramId = telegramId;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
} 