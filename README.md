# Loja de Perfumes - CRUD REST (Spring Boot + MySQL)

Aplicação de exemplo para o Projeto Integrador: instalação e uso de um SGBD **MySQL** com um backend **Spring Boot** expondo uma API REST.

## Tecnologias
- Java 17, Spring Boot 3, Spring Data JPA
- MySQL 8
- OpenAPI/Swagger UI

## Banco de Dados
Execute no MySQL:
```sql
CREATE DATABASE loja_perfumes;
CREATE USER 'admin'@'%' IDENTIFIED BY '12354';
GRANT ALL PRIVILEGES ON loja_perfumes.* TO 'admin'@'%';
FLUSH PRIVILEGES;
```

> Se preferir, ajuste `application.properties` para sua configuração.

## Executando
```bash
mvn spring-boot:run
```
API: `http://localhost:8080/perfumes`  
Swagger UI: `http://localhost:8080/swagger-ui.html`

## Exemplos de chamadas
Criar:
```bash
curl -X POST http://localhost:8080/perfumes -H "Content-Type: application/json" -d '{"nome":"Sauvage","marca":"Dior","preco":799.90}'
```
Listar:
```bash
curl http://localhost:8080/perfumes
```
Atualizar:
```bash
curl -X PUT http://localhost:8080/perfumes/1 -H "Content-Type: application/json" -d '{"nome":"Sauvage Elixir","marca":"Dior","preco":899.90}'
```
Deletar:
```bash
curl -X DELETE http://localhost:8080/perfumes/1
```
