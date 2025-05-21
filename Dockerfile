FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/sucursal-0.0.1-SNAPSHOT.jar sucursal-api.jar
ENTRYPOINT ["java", "-jar", "/app/sucursal-api.jar"]
