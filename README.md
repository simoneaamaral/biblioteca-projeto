# Projeto Biblioteca

Este é um sistema web para gerenciar uma biblioteca, que permite cadastro, visualização, exclusão e alteração de livros. O sistema inclui autenticação de usuários com permissões diferenciadas para usuários logados e não logados.

## Funcionalidades

- Cadastro de livros
- Listagem de livros
- Atualização de livros
- Exclusão de livros
- Cadastro de usuários
- Login de usuários
- Diferenciação de permissões para usuários logados e não logados

## Tecnologias Utilizadas

- Java
- Hibernate
- Jakarta Servlet
- PostgreSQL
- Maven

## Estrutura do Projeto

- `com.projeto.projetobiblioteca.DAO`: Contém as classes DAO (`LivroDAO` e `UsuarioDAO`) para gerenciamento das operações CRUD com o banco de dados.
- `com.projeto.projetobiblioteca.Model`: Contém as classes de modelo (`Livro` e `Usuario`).
- `com.projeto.projetobiblioteca.Servlet`: Contém os servlets (`CadastroServlet`, `LoginServlet`, `HomeServlet`, `LivroServlet`) para a interação com o usuário.
- `com.projeto.projetobiblioteca.Util`: Contém a classe `HibernateUtil` para configuração do Hibernate.

## Configuração do Projeto

### Pré-requisitos

- JDK 11 ou superior
- Servidor de Aplicação (Apache Tomcat ou similar)
- Maven
- PostgreSQL

## Colaboradores

Este projeto foi desenvolvido por:

- [Simone Amaral](https://github.com/simoneaamaral)
- [Shellcya Habiakel](https://github.com/Shellcya)

