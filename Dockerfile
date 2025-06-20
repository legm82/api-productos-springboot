# Imagen base de Java 17
FROM eclipse-temurin:17-jdk

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR al contenedor
COPY target/primerapractica-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto por defecto de Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]

FROM eclipse-temurin:17-jdk-alpine
COPY target/primerapractica-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

