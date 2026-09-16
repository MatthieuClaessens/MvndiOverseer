FROM eclipse-temurin:21-jdk AS build
WORKDIR /app

COPY backend .

RUN ./gradlew clean bootJar -x test

RUN echo "=== Files in build/libs/ ==="
RUN ls -la /app/build/libs/
RUN echo "=== End list ==="


FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

RUN echo "=== Files in /app/ ==="
RUN ls -la
RUN echo "=== End list ==="

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]