FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 9999
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/uol-products-service-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
