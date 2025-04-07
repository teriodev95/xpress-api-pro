# Micronaut Demo API

Proyecto de demostración utilizando Micronaut para la creación de una API RESTful.

## Funcionalidades

- Gestión de usuarios (CRUD)
- Endpoints para pruebas de base de datos
- Despliegue automatizado a través de GitHub Actions

## Endpoints Principales

- `/usuarios` - Gestión de usuarios
- `/test-db` - Pruebas de conexión a base de datos

## Configuración de Despliegue Automatizado

Este proyecto utiliza GitHub Actions para automatizar el proceso de compilación y despliegue en un servidor remoto.

### Requisitos

1. Configurar los siguientes secretos en GitHub:
   - `SERVER_HOST`: Dirección IP o nombre de dominio del servidor
   - `SERVER_PORT`: Puerto SSH del servidor (normalmente 22)
   - `SERVER_USERNAME`: Usuario SSH del servidor
   - `SERVER_PASSWORD`: Contraseña SSH del servidor

### Proceso de Despliegue

El flujo de trabajo realiza los siguientes pasos:

1. Compila la aplicación con Maven
2. Ejecuta pruebas automatizadas
3. Sube el archivo JAR como un artefacto
4. Se conecta al servidor remoto mediante SSH
5. Transfiere el archivo JAR al servidor
6. Reinicia el servicio en el servidor

### Despliegue Manual

El flujo de trabajo también puede ser ejecutado manualmente desde la pestaña "Actions" en GitHub.

## Desarrollo Local

Para ejecutar el proyecto localmente:

```bash
./mvnw mn:run
```

## Colección de Postman

Se incluye una colección de Postman (`micronaut-demo-collection.json`) para probar todos los endpoints disponibles.

## Micronaut 4.8.0 Documentation

- [User Guide](https://docs.micronaut.io/4.8.0/guide/index.html)
- [API Reference](https://docs.micronaut.io/4.8.0/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/4.8.0/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)

---

- [Micronaut Maven Plugin documentation](https://micronaut-projects.github.io/micronaut-maven-plugin/latest/)

## Feature maven-enforcer-plugin documentation

- [https://maven.apache.org/enforcer/maven-enforcer-plugin/](https://maven.apache.org/enforcer/maven-enforcer-plugin/)

## Feature serialization-jackson documentation

- [Micronaut Serialization Jackson Core documentation](https://micronaut-projects.github.io/micronaut-serialization/latest/guide/)

## Feature micronaut-aot documentation

- [Micronaut AOT documentation](https://micronaut-projects.github.io/micronaut-aot/latest/guide/)


