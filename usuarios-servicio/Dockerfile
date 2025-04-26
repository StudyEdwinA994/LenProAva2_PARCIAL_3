FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/usuarios-servicio-0.0.1-SNAPSHOT.jar usuarios-servicio.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "usuarios-servicio.jar"]