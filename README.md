# Virtual File System - Backend

Este projeto é o backend de um sistema de arquivos virtuais. Ele fornece uma API REST que permite operações CRUD (Create, Read, Update, Delete) em diretórios e arquivos virtuais. O backend é implementado em **Java** com **Spring Boot** e utiliza **MySQL** como banco de dados relacional.

Arquitetura SPA + API RESTful (Single Page Application com API Backend)

Aqui estão os principais detalhes dessa arquitetura:

    Single Page Application (SPA):
        O frontend é construído como uma SPA usando React, onde a aplicação roda inteiramente no navegador.
        Todo o conteúdo e as interações do usuário são gerenciados pelo JavaScript, com uma única página carregada inicialmente, e subsequentes mudanças de interface acontecem sem recarregar a página.
        A comunicação com o servidor é feita via chamadas HTTP (AJAX), como fetch ou axios, e o servidor retorna apenas os dados em JSON.

    API RESTful (Backend):
        O backend é implementado com Spring Boot, fornecendo uma API RESTful.
        A API expõe endpoints para operações CRUD (Create, Read, Update, Delete) e outros serviços, respondendo com dados no formato JSON.
        Não há renderização de páginas HTML no servidor. O backend apenas processa lógica de negócios e fornece dados.

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

Navegue até a pasta do projeto e utilize o Docker Compose para buidar e subir a aplicação e o banco de dados. Execute os seguintes comandos:
**docker-compose up --build**  - para buildar o projeto, e 

**docker-compose up mysql**  || 
**docker-compose up api** 
 
 em terminais distintos para acompanhar os logs separadamente.

### 3. Verificar o Funcionamento

Acesse a API:
**localhost:8080/api/directories**

Utilize o método POST para testar uma requisição: Json de exemplo -  
  {
    "name": "Nirvana",
    "parent": null
  }

