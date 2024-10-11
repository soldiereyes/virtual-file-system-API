FROM openjdk:17 AS build

WORKDIR /app

COPY pom.xml .
COPY mvnw .
COPY .mvn ./.mvn
COPY src ./src

RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

FROM openjdk:17

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
