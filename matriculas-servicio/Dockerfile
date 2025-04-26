FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/matriculas-servicio-0.0.1-SNAPSHOT.jar matriculas-servicio.jar

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "matriculas-servicio.jar"]