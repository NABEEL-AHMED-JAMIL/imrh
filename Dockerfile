# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine
# Add Maintainer Info
LABEL maintainer="twaalkattan@gmail.com"
# Add a volume pointing to /tmp
VOLUME /tmp
# Make 8080 available to the world outside this container
EXPOSE 9200
# The application's jar file
ARG JAR_FILE=/target/datacenter-0.0.1-SNAPSHOT.jar
# Add the application jar to the container
ADD ${JAR_FILE} app.jar
# Run the jar file
ENTRYPOINT ["java", "-Dfile.encoding=UTF-8", "-jar", "app.jar"]