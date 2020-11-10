FROM openjdk:latest
COPY ./target/newSem-1.0-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "newSem-1.0-SNAPSHOT-jar-with-dependencies.jar"]