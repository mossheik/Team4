FROM gradle:7.4.2-jdk8 as build
WORKDIR /workspace/app
COPY build.gradle .
COPY src src
RUN gradle bootJar

FROM openjdk:8-jdk-alpine
ARG JARLOC=/workspace/app/build/libs
COPY --from=build ${JARLOC}/app-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 55544
ENTRYPOINT ["java", "-jar", "app.jar"]
