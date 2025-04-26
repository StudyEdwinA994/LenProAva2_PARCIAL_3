# Imagen con java17.
FROM openjdk:17-jdk-slim

# Directorio de trabajo dentro del contenedor.
WORKDIR /app

COPY target/asignaturas-servicio-0.0.1-SNAPSHOT.jar asignaturas-servicio.jar

# Puerto del microservicio.
EXPOSE 8082

# Ejecuta al iniciar el contenedor.
ENTRYPOINT ["java", "-jar", "asignaturas-servicio.jar"]
