# Depend on Java
FROM adoptopenjdk/openjdk11:jdk-11.0.13_8-alpine-slim
# Copy current jar to container folder path:/
ADD demo-spring-api-1.0.0-SNAPSHOT.jar /demo-spring-api-1.0.0-SNAPSHOT.jar
# Build container process
RUN bash -c 'touch /demo-spring-api-1.0.0-SNAPSHOT.jar'
# Expose port
EXPOSE 8080
# When container start, run the command
ENTRYPOINT ["java", "-jar","/demo-spring-api-1.0.0-SNAPSHOT.jar"]
MAINTAINER Vipcube
