FROM openjdk:8-jdk-alpine
EXPOSE 8090
RUN mkdir -p /app/
ADD target/starwars-0.0.1-SNAPSHOT.jar /app/starwars-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/starwars-0.0.1-SNAPSHOT.jar"]