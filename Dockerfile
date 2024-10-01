FROM maven:latest

WORKDIR /app

COPY pom.xml /app/

COPY . /app/

RUN mvn package

# Run the main class from the built JAR
CMD ["java", "-jar", "target/SportLogger.jar"]
