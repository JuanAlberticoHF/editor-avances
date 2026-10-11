# Etapa 1: Construcción (Build)
FROM eclipse-temurin:21-jdk-alpine AS builder
WORKDIR /app

# Copiar el wrapper de Maven y el archivo de configuración
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Dar permisos de ejecución al wrapper
RUN chmod +x ./mvnw

# Descargar las dependencias de Maven
RUN ./mvnw dependency:go-offline

# Copiar el código fuente del proyecto
COPY src ./src

# Compilar y empaquetar la aplicación saltando las pruebas
RUN ./mvnw package -Dmaven.test.skip=true

# Etapa 2: Ejecución (Runtime)
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Copiar únicamente el archivo .jar generado en la etapa de construcción
COPY --from=builder /app/target/editor-avances-1.0.2-RELEASE.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]