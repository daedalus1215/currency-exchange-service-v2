FROM openjdk:17-jdk-slim
EXPOSE 8000
COPY currency-exchange-service-1.0.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]