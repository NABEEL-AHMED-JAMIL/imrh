# Start with a base image containing Java runtime
# using the same jdk which al-ready install in docker
FROM jenkins/jenkins:2.289.1-jdk11
# Add Maintainer Info
LABEL maintainer="nabeel.amd93@gmail.com"
# Add a volume pointing to /tmp
VOLUME /tmp
# Make 8080 available to the world outside this container
EXPOSE 9200
# The application's jar file
ARG JAR_FILE=/target/imrh-0.0.1-SNAPSHOT.jar
# Add the application jar to the container
ADD ${JAR_FILE} app.jar
# Run the jar file
ENTRYPOINT ["java", "-Dfile.encoding=UTF-8", "-jar", "app.jar"]