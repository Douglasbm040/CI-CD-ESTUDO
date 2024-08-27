# Etapa 1: Construir a aplicação Angular
FROM node:18-alpine AS builder

# Define o diretório de trabalho
WORKDIR /app

# Copia o restante dos arquivos da aplicação
COPY ./frontend/saude-nao-tem-pressa .

# Instala o Angular CLI como dependência local
RUN npm install
RUN npm install @angular/cli@ -g
EXPOSE 4200

CMD ["ng", "serve", "--host", "0.0.0.0"]

