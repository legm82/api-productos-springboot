# Etapa 1: Build
FROM eclipse-temurin:17-jdk as builder

WORKDIR /app

COPY . .

# Asegura que mvnw tenga permisos
RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

# Etapa 2: Runtime
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Solo copiamos el .jar compilado, nada más
COPY --from=builder /app/target/primerapractica-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
