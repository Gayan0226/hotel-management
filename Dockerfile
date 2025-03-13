
FROM openjdk:17
WORKDIR /app
COPY target/hotel-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app.jar"]
