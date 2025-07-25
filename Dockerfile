FROM openjdk:21-jdk-slim

WORKDIR /storybubbles_spring

COPY target/storybubbles_spring-0.0.1-SNAPSHOT.jar storybubbles_spring.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "storybubbles_spring.jar", "--spring.profiles.active=prod"]
