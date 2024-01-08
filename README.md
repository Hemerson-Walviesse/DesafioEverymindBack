# DesafioEverymindBack
 CRUD SpringBoot

Descrição do Projeto
Este é um projeto CRUD desenvolvido em Spring Boot, com operações básicas de criação, leitura, atualização e exclusão de produtos. Além disso, inclui uma parte frontend, que será detalhada em outro arquivo.

Tecnologias Utilizadas
Spring Boot: Framework Java para desenvolvimento rápido de aplicações.
Swagger: Ferramenta para facilitar a documentação e teste de requisições da API.
Hibernate: Framework ORM para mapeamento objeto-relacional.
MySQL: Sistema de gerenciamento de banco de dados relacional.
Maven: Ferramenta de automação e gerenciamento de projetos Java.
Pré-requisitos
Certifique-se de ter as seguintes ferramentas instaladas em sua máquina:

JDK 17: Download e instalação
Maven: Download e instalação
Configuração do Banco de Dados
O projeto utiliza o MySQL como banco de dados. Certifique-se de ter um servidor MySQL em execução.
Configure as credenciais do banco de dados no arquivo application.properties.

spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

Executando o Projeto
Clone o repositório para sua máquina.
Abra o terminal na pasta do projeto.
Execute o seguinte comando para compilar e executar o projeto:
mvn spring-boot:run

Acesse a documentação Swagger para testar as requisições: http://localhost:8080/swagger-ui/
Frontend
A parte frontend deste projeto está localizada em outro arquivo. Consulte esse arquivo para obter informações sobre como executar e interagir com o frontend.
