FROM openjdk:17
EXPOSE 9090
ADD target/TestApp-0.0.1.jar TestApp-0.0.1.jar
ENTRYPOINT ["java", "-jar", "TestApp-0.0.1.jar"]