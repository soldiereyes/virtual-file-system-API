# Virtual File System - Backend

Este projeto é o backend de um sistema de arquivos virtuais. Ele fornece uma API REST que permite operações CRUD (Create, Read, Update, Delete) em diretórios e arquivos virtuais. O backend é implementado em **Java** com **Spring Boot** e utiliza **MySQL** como banco de dados relacional.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **MySQL**
- **Docker**

## Funcionalidades

- CRUD de Diretórios
- CRUD de Arquivos
- Estrutura hierárquica de diretórios e arquivos
- Integração com banco de dados MySQL

## Requisitos

Antes de rodar o projeto, você precisará ter instalado:

- **Docker** e **Docker Compose**
- **JDK 17**

## Configuração do Projeto

### 1. Clonar o Repositório

Clone este repositório em sua máquina local utilizando git clone 

### 2. Rodar o Projeto com Docker

Navegue até a pasta do projeto e utilize o Docker Compose para subir a aplicação e o banco de dados. Execute os seguintes comandos:

docker-compose up --build 

Se preferir docker-compose up mysql e docker-compose up api para acompanhar os logs separadamente

### 4. Verificar o Funcionamento

Acesse a API:
**localhost:8080/api/directories**

Utilize o método POST para testar uma requisição: Json de exemplo -  
  {
    "name": "Nirvana",
    "parent": null
  }

