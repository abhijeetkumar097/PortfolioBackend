# --- Stage 1: Build ---
    FROM eclipse-temurin:21-jdk-alpine AS build

    WORKDIR /app
    
    COPY . .
    
    # Make Maven wrapper executable and build the project
    RUN chmod +x mvnw && ./mvnw clean package -DskipTests
    
    # --- Stage 2: Runtime ---
    FROM eclipse-temurin:21-jdk-alpine
    
    WORKDIR /app
    
    # Copy only the built JAR
    COPY --from=build /app/target/*.jar app.jar
    
    EXPOSE 8081
    
    # Run the Spring Boot application
    CMD ["java", "-jar", "app.jar"]
    