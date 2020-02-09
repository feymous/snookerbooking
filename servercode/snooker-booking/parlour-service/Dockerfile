#
# Build stage
#
FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/parlour-service/src
COPY pom.xml /home/parlour-service
RUN mvn -f /home/parlour-service/pom.xml clean package

#
# Package stage
#
FROM openjdk:11-jre-slim
COPY --from=build /home/parlour-service/target/parlour-service-0.0.1-SNAPSHOT.jar /usr/local/lib/parlour-service.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/parlour-service.jar"]