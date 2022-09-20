<h1 align="center">
    TODO List
</h1>

<h4 align="center">
    Utilizando Java juntamente com Framework Spring Boot, foi realizado o desenvolvimento de uma API Rest
</h4>

<p align="center">
    <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/felipe-abreu/todo-list">
    <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/felipe-abreu/todo-list">
    <img alt="Repository size" src="https://img.shields.io/github/repo-size/Felipe-Abreu/todo-list">
    <a href="https://github.com/Felipe-Abreu/todo-list/commits/master">
        <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/felipe-abreu/todo-list">
    </a>
    <a href="https://github.com/Felipe-Abreu/todo-list/issues">
        <img alt="Repository issues" src="https://img.shields.io/github/issues/Felipe-Abreu/todo-list">
    </a>
    <img alt="License" src="https://img.shields.io/badge/license-MIT-yellowgreen">
</p>

## :information_source: Informações do projeto

Esse projeto foi utilizado com as seguintes tecnologias:

- Framework Spring Boot 2.7.2;
- Gradlew;
- Java 11;
- IDE Intellij;
- MySQL 8;
- Docker.

Para a execução do projeto é necessário ter docker instalado na máquina e o java na versão do projeto.
</br>
Foi Utilizado Docker para facilidade e praticidade ao se usar o banco de dados.
<br>

## 📓 Requisitos do projeto

Usuario<br>
- email
- senha
- admin ou não

Lista TODO<br>
- data e hora de criação
- descrição
- prazo
- status
- data e hora que foi finalizada
- data e hora da edição
- pode editar prazo e descrição quando o status for diferente de finalizado

Usuário pode ver todos os itens dele<br>
Informar status de atrasado

Administrador ve toda a lista contendo usuário que criou<br>
Filtrar os que estão atrasados

## :computer: Pontos de Melhoria

Durante o desenvolvimente me deparei com as seguintes dificuldade e que encontrei que poderiam ser pontos de melhoria:

- Na IDE Intellij juntamente com a instalação via flatpk do linux, não consegui executar corretamente o docker, utilizando Visual Studio Code, foi possível executar sem problema;
- Melhoria na utilização das roles para conseguir a parametrização correta do tipos de usuário;
- Melhoria no método GET para se consultar somente alguns campos do BD;
- Implementação de testes unitários;
- Tratamento de erros HTTP.

---
Feito por Felipe Abreu :wave: [Venha me conhecer um pouco mais!](https://www.linkedin.com/in/felipe-abreu)
