FROM openjdk:17
VOLUME /tmp
ADD target/petproject-0.0.1-SNAPSHOT.jar petproject-backend-docker.jar
ENTRYPOINT [ "java", "-jar", "/petproject-backend-docker.jar" ]