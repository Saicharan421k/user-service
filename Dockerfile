# Start with a simple Java 17 runtime environment.
FROM openjdk:17-jdk-slim

# Set the working directory inside the container.
WORKDIR /app

# --- THE CANNOT-FAIL CHANGE ---
# Copy the JAR file directly from the build context root.
COPY user-service-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the service listens on.
EXPOSE 8081

# The command to run the application when the container starts.
ENTRYPOINT ["java","-jar","app.jar"]