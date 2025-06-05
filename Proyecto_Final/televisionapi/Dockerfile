FROM eclipse-temurin:17-jdk-alpine
LABEL author.1="Antonio Jair Garcia Vargas" \
      author.2="Ariadna Gochi Gutierrez"
WORKDIR /app
COPY ./target/televisionapi-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8080
CMD ["java", "-jar", "./app.jar"]