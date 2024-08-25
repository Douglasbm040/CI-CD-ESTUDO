# Etapa 1: Construir a aplicação Angular
FROM node:16 AS builder

# Define o diretório de trabalho
WORKDIR /app

# Copia o package.json e o package-lock.json (se existir) para instalar as dependências
COPY ./frontend/saude-nao-tem-pressa/package*.json ./
RUN npm install

# Copia o restante dos arquivos da aplicação
COPY ./frontend/saude-nao-tem-pressa .

# Instala o Angular CLI globalmente
RUN npm install @angular/cli -g

# Cria a build da aplicação
RUN ng build --prod

# Etapa 2: Servir a aplicação com um servidor web (por exemplo, Nginx)
FROM nginx:alpine

# Copia os arquivos de build para o diretório do nginx
COPY --from=builder /app/dist/ /usr/share/nginx/html

# Exponha a porta em que o nginx está ouvindo
EXPOSE 80

# Comando para iniciar o nginx
CMD ["nginx", "-g", "daemon off;"]
