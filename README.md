# 📚 Proyecto Edwin Alzate - Sistema Educativo Microservicios.

Este proyecto fue desarrollado con **Spring Boot**, **Java 17**, **Spring Cloud** y **MySQL**, el cual busca gestionar el sistema educativo de una manera distribuida utilizando la arquitectura de **microservicios**.

## 🚀 **Tecnologías Utilizadas**
- **Java 17** 
- **Spring Boot 3.4.4** 
- **Spring Data JPA** 
- **Spring Cloud** 
- **MySQL** 
- **Maven** 
- **JUnit 5** 
- **Mockito** 
- **GitHub Actions** (CI/CD) 

## 🏗️ **Estructura del Proyecto**
El repositorio creado está organizado por microservicios, cada uno con su propia base de datos, controladores, servicios y lógica de negocio:

- **usuarios-servicio**: Gestión de estudiantes y docentes
- **asignaturas-servicio**: CRUD de materias 
- **matriculas-servicio**: Registro de estudiantes en materias 

## 📁 **Estructura del Repositorio**
/sistema-educativo-microservicios-proyectoU<br>
/usuarios-servicio<br>
/asignaturas-servicio<br>
/matriculas-servicio<br>

## 🌍 **Visión General del Sistema**
Este sistema está diseñado para ser **modular** y **escalable**, permitiendo que cada uno de los microservicio sea independiente y gestionado de forma autónoma. La comunicacion entre microservicios sera usando Feign Client y Spring Cloud, lo cual permitira gestionar la matricula del estudiante, la asignacion de materias y la autenticacion de usuario.

## 🧪 Pruebas Unitarias
El proyecto incluye pruebas unitarias y de integración para cada microservicio, utilizando JUnit 5 y Mockito. Esto garantizara que cada parte del sistema funcione correctamente y que las dependencias sean simuladas de forma adecuada durante cada una de las pruebas.

## 🔐 Seguridad
Los microservicios del proyecto están protegidos utilizando Spring Security y JWT para la autenticación y autorización de usuarios. Solo las personas autenticadas pueden usar los endpoints.

## 📈 Monitorizacion
Se implementaron herramientas de monitorización con Spring Boot Actuator, lo que permite ver métricas de rendimiento, estado de los servicios y salud del sistema.

## 🐳 Despliegue (Docker)
Cada uno de los microservicios tiene su propio archivo Dockerfile lo que permite que todo el sistema se orqueste usando Docker Compose para facilitar el despliegue en un entorno distribuido.

## 💬 Datos Personales
Estudiante: Edwin Leonardo Alzate Avendaño<br>
Correo electrónico: Edwin.alzate.8913@miremington.edu.co<br>
Asignatura: Lenguaje de programación avanzado 2 - 2503B04G1G2<br>
Docente: Martha Nicolasa Amaya Becerra<br>
Repositorio: https://github.com/StudyEdwinA994/sistema-educativo-microservicios-proyectoU<br>