# Use the official Eclipse Temurin JDK 17 with the Jammy release as the base image
FROM eclipse-temurin:17-jdk-jammy as base

# Set the working directory inside the container to /app
WORKDIR /app

# Copy the .mvn directory (used by Maven for configuration) from the local project to the container
COPY ../.mvn .mvn

# Copy the Maven wrapper script (mvnw), the project's POM file (pom.xml), and the root directory to the container
COPY ../mvnw pom.xml ./

# Resolve project dependencies using Maven
RUN ./mvnw dependency:resolve

# Copy the source code from the local project to the container
COPY ../src ./src

# Create a new stage named "development" based on the "base" stage
FROM base as development

# Define the default command to run the Spring Boot application in development mode
CMD ["./mvnw", "spring-boot:run", "-Dspring-boot.run.profiles=mysql", "-Dspring-boot.run.jvmArguments='-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:8000'"]

# Create a new stage named "build" based on the "base" stage
FROM base as build

# Build the Spring Boot application and create a JAR file
RUN ./mvnw package

# Create a new stage named "production" based on the official Eclipse Temurin JRE 17 with the Jammy release
FROM eclipse-temurin:17-jre-jammy as production

# Expose port 8080 for the Spring Boot application
EXPOSE 8080

# Copy the JAR file from the "build" stage to the production stage
COPY --from=build /app/target/LogisticsStatusTrackingWebsite-0.0.1-SNAPSHOT.jar /LogisticsStatusTrackingWebsite.jar

# Set the command to run the Spring Boot application in production mode
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/LogisticsStatusTrackingWebsite.jar"]
