# API de estudiantes

## Correcciones

- URL de PostgreSQL: se cambió `jdbc:postgres:` por `jdbc:postgresql:`.
- Identificador de Estudiante: se cambió `long Id` por `Long id`, que permite
  usar null antes de guardar una entidad nueva.
- Se eliminó el método setId vacío. Lombok (@Data) genera ahora el setter que
  asigna el valor al campo.
- Se agregó @PostMapping al método guardar para atender POST /api/estudiantes.

## Ejecutar en Windows

1. Descomprimir y abrir la carpeta que contiene pom.xml en IntelliJ.
2. Usar un JDK 21 o superior y recargar el proyecto Maven.
3. Iniciar PostgreSQL. En application.properties, comprobar el puerto 5432,
   el usuario, la contraseña y el nombre de la base de datos.
   Se conservaron los valores originales de usuario y contraseña.
4. Si no existe la base de datos, ejecutar en pgAdmin, conectado a postgres:

   ```sql
   CREATE DATABASE "api-estudiantes";
   ```

   Si ya existe, no volver a crearla. Hibernate actualizará las tablas según
   las entidades gracias a spring.jpa.hibernate.ddl-auto=update.
5. Ejecutar ApiEstudiantesApplication desde IntelliJ, o desde PowerShell
   dentro de la carpeta del proyecto:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

## Comprobar la API

Con el servidor iniciado, abrir en el navegador:

http://localhost:8080/api/estudiantes

Si no hay registros, debe responder []. La ruta raíz / no tiene controlador.

Para guardar desde Postman:

- Método: POST
- URL: http://localhost:8080/api/estudiantes
- Body: raw, JSON (Content-Type: application/json)

```json
{
  "nombre": "Rolando",
  "apellido": "Mayorga",
  "carrera": "Ingeniería de Sistemas"
}
```

Se espera HTTP 201 y el estudiante con su identificador generado. Volver a
consultar GET /api/estudiantes para comprobar que aparece.

## Verificación realizada

Se revisaron los archivos fuente y la configuración. No se pudo verificar la
compilación ni el arranque en este entorno: solo dispone de Java 17 y el
proyecto requiere Java 21 o superior. Tampoco se dispone de tu servidor local
de PostgreSQL. Las respuestas anteriores son los resultados esperados al
probarlo en tu equipo.
