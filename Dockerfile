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

# Compilar el proyecto
RUN gradle build

# Etapa 2: Generar la imagen final
FROM openjdk:21-jdk

# Crear un directorio para la aplicación
WORKDIR /app

# Copiar el JAR generado desde la etapa de construcción
COPY --from=build /home/gradle/boot-run/build/libs/boot-run-0.0.1-SNAPSHOT.jar /app/boot-run.jar

# Exponer el puerto en el que la aplicación escucha
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/boot-run.jar"]
