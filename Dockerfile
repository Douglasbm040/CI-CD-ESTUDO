# Etapa 1: Construir a aplicação
FROM maven:3.8.6-eclipse-temurin-17-alpine AS builder

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo de configuração do Maven e os arquivos de código-fonte para o contêiner
COPY ./demo/pom.xml .
COPY ./demo/src ./src

# Compila o projeto e gera o arquivo JAR
RUN mvn clean package -DskipTests

# Etapa 2: Configurar o contêiner para rodar a aplicação
FROM eclipse-temurin:17-jdk-alpine

# Define o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copia o arquivo JAR gerado na etapa de build para a imagem final
COPY --from=builder /app/target/*.jar app.jar

# Exponha a porta que o Spring Boot vai rodar (geralmente 8080)
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
