<h1 align="center">ESTACIONAMENTO</h1>
<p align="center">Teste backend java - Fcamara</p>



## Requisito para executar

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
   * [Git](https://git-scm.com), 
   * [jdk 1.8 ou posterior](https://www.oracle.com/technetwork/pt/java/javase/downloads/index.html)
   * [Postman](https://www.postman.com/)
   * [Chrome](tinyurl.com/1towppvy) ou o navegador de sua preferencia.
   * [sts 4](https://spring.io/tools).
   * [MySql](https://dev.mysql.com/downloads/mysql/)  


## Download do projeto
```bash
# Clone este repositório
$ git clone https://github.com/sergiobsilva2505/backend-test-java.git
```


## Iniciando o projeto

Após ter clonado o projeto para sua máquina, basta fazer o import no STS como "existing maven project" e aguardar o STS fazer toda a configuração. Terminada a configuração é só rodar o projeto.


```bash
# Banco de Dados
> Criar no seu MySql uma base de dados com o nome "estacionamento".
> No arquivo "main => resources => application.properties" configurar usuário e senha.
> Executar o projeto pela primeira vez.
> Tudo ok? Então voltar no arquivo "application.properties" e mudar o valor da propriedade "spring.jpa.hibernate.ddl-auto" para "none".
> Apagar todo o conteudo contido no método "public void run(String... args) throws Exception " da classe "EstacionamentoApplication.java" que está em SRC => MAIN => JAVA . 
> Seguir com os testes. 
```

## Modelagem dos dados
Para visualizar o diagrama de classes desenvolvido para este projeto [CLIQUE AQUI](https://tinyurl.com/1820px3n). 


## Rotas das requisições Http.

Documentação com todas as rotas e json's necessários para testes [aqui](https://documenter.getpostman.com/view/8466840/TW77h3rs). 
Logado em seu Postman clique em "run in postman" e ele baixará as rotas para a sua aplicação.


##  Tecnologias

- [Java 8](https://docs.oracle.com/javase/8/docs/api/)
- [Spring](https://spring.io/)
- [Hibernate](http://hibernate.org/)
- [Mysql](https://www.mysql.com/)