# Etapa 1: Compilación
FROM gradle:8.10.2-jdk21-alpine AS build

# Establecer el directorio de trabajo
WORKDIR /home/gradle

# Copiar el archivo settings.gradle del proyecto raíz
COPY settings.gradle .

# Copiar todos los módulos del proyecto
COPY application/ application/
COPY boot-run/ boot-run/
COPY domain/ domain/
COPY infrastructure/ infrastructure/

# Limpiar el cache de Gradle para reducir el tamaño de la imagen intermedia
RUN gradle build --no-daemon && \
    rm -rf /home/gradle/.gradle /home/gradle/.m2 /root/.gradle /root/.m2

# Etapa 2: Generar la imagen final con JRE
FROM eclipse-temurin:21-jre

# Crear un directorio para la aplicación
WORKDIR /app

# Copiar el JAR generado desde la etapa de construcción
COPY --from=build /home/gradle/boot-run/build/libs/boot-run-0.0.1-SNAPSHOT.jar /app/boot-run.jar

# Exponer el puerto en el que la aplicación escucha
EXPOSE 8080

# Establecer una variable de entorno para minimizar el uso de memoria en contenedores pequeños
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/boot-run.jar"]
