# Depend on Java 8
FROM openjdk:8u222-jdk
# Copy current jar to container folder path:/
ADD demo-spring-docker-0.0.1-SNAPSHOT.jar /demo-spring-docker-0.0.1-SNAPSHOT.jar
# Build container process
RUN bash -c 'touch /demo-spring-docker-0.0.1-SNAPSHOT.jar'
# Expose port
EXPOSE 8080
# When container start, run the command
ENTRYPOINT ["java", "-jar","/demo-spring-docker-0.0.1-SNAPSHOT.jar"]
MAINTAINER Vipcube
