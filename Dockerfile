# Usando a imagem oficial do OpenJDK como base
FROM openjdk:17 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo pom.xml, o wrapper do Maven e o diretório .mvn para a imagem
COPY pom.xml .
COPY mvnw .
COPY .mvn ./.mvn
COPY src ./src

# Concede permissão de execução ao script mvnw
RUN chmod +x mvnw

# Executa o Maven para compilar a aplicação
RUN ./mvnw clean package -DskipTests

# Usando uma nova imagem para rodar a aplicação
FROM openjdk:17

# Define o diretório de trabalho
WORKDIR /app

# Copia o jar gerado da imagem de build
COPY --from=build /app/target/*.jar app.jar

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
