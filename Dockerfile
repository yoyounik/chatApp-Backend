# Build stage
FROM amd64/openjdk:21-jdk-slim AS build
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests


# Package stage
FROM amd64/openjdk:21-jdk-slim
WORKDIR /app
COPY --from=build /app/target/chat-app-backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]