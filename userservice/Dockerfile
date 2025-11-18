# Use Java 21 runtime
FROM eclipse-temurin:21-jdk

# Workdir inside container
WORKDIR /app

# Copy built jar from target folder
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# App port
EXPOSE 8083

# Run Spring Boot
ENTRYPOINT ["java","-jar","/app/app.jar"]
