# Build stage
FROM gradle:jdk17 AS build
WORKDIR /app
COPY . .
# Garantir que o wrapper Gradle tenha permissões de execução e construir o projeto
RUN chmod +x ./gradlew && ./gradlew build

# Execution stage
FROM openjdk:17-jdk-alpine AS runner
WORKDIR /app
# Copiar o JAR gerado na fase de build para o estágio de execução
COPY --from=build /app/build/libs/*.jar app.jar
# Comando para rodar o aplicativo
CMD ["java", "-jar", "app.jar"]
