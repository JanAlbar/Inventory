FROM openjdk:17-jdk-slim
WORKDIR /inventory
COPY target/inventory-0.0.1-SNAPSHOT.jar inventory.jar
ENTRYPOINT ["java", "-jar", "inventory.jar"]