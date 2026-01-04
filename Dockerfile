# Dockerfile
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copier le premier fichier JAR trouvé
COPY target/*.jar app.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "app.jar"]