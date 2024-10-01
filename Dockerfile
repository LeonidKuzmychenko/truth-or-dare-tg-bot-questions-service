FROM gradle:8.10.0-jdk17-alpine AS builder
COPY src /app/src
COPY build.gradle /app/
COPY settings.gradle /app/
RUN  cd /app && (gradle bootJar --no-daemon --console=plain || return 0)

FROM openjdk:17-alpine
COPY --from=builder /app/build/libs/*.jar ./project.jar
EXPOSE 1212
ENTRYPOINT ["java", "-jar", "/project.jar"]