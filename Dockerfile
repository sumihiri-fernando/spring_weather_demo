FROM ubuntu:latest
LABEL authors="sumih"

ENTRYPOINT ["top", "-b"]

#
FROM openjdk:21-jdk


WORKDIR /app


COPY mvnw .
COPY .mvn .mvn


COPY pom.xml .
COPY src src


RUN ./mvnw package -DskipTests -e


CMD ["java", "-jar", "target/2024_users_api-0.0.1-SNAPSHOT.jar"]