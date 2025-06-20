FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia todo el proyecto al contenedor
COPY . .

# Compila el proyecto usando Maven
RUN ./mvnw clean package -DskipTests

# Expone el puerto
EXPOSE 8080

# Ejecuta el JAR resultante
ENTRYPOINT ["java", "-jar", "target/primerapractica-0.0.1-SNAPSHOT.jar"]
