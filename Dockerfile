# Start with a simple Java 17 runtime environment.
FROM openjdk:17-jdk-slim

# Set the working directory inside the container.
WORKDIR /app

# Copy our single, pre-built JAR file into the container.
# The source is the target directory inside our build context.
# The destination is 'app.jar' inside the container.
COPY target/user-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the service listens on.
EXPOSE 8081

# The command to run the application when the container starts.
ENTRYPOINT ["java","-jar","app.jar"]