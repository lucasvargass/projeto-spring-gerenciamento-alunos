# 📚 Gerenciamento de Alunos

API REST desenvolvida com **Spring Boot** e **Java 21** para gerenciamento de alunos, com operações de CRUD (Create, Read, Update, Delete) persistidas em banco de dados **PostgreSQL** via **Spring Data JPA**.

> Projeto de estudo focado em arquitetura backend com Spring Boot, evoluindo para um modelo de microsserviços.

---

## 🚀 Tecnologias utilizadas

- **Java 21**
- **Spring Boot 4.0.6**
- **Spring Web (MVC)**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **JUnit / Spring Boot Test**

---

## 🗂️ Estrutura do projeto

```
src/main/java/com/lucasvargasdev/gerenciamento_alunos/
├── GerenciamentoAlunosApplication.java   # Classe principal (entry point)
├── controller/
│   └── AlunoController.java              # Endpoints REST
├── service/
│   └── AlunoService.java                 # Regras de negócio
├── repository/
│   └── AlunoRepository.java              # Acesso a dados (JPA)
└── model/
    └── Aluno.java                        # Entidade Aluno
```

---

## 🧩 Modelo de dados (`Aluno`)

| Campo            | Tipo     | Descrição                  |
|-------------------|----------|-----------------------------|
| `id`              | Long     | Identificador único (auto-gerado) |
| `nome`            | String   | Nome do aluno                |
| `dataNascimento`  | Date     | Data de nascimento           |
| `matricula`       | String   | Número de matrícula          |

---

## 📡 Endpoints da API

A API expõe os recursos em `/alunos`:

| Método | Endpoint        | Descrição                          |
|--------|-----------------|--------------------------------------|
| `GET`    | `/alunos`       | Lista todos os alunos cadastrados   |
| `GET`    | `/alunos/{id}`  | Busca um aluno pelo ID               |
| `POST`   | `/alunos`       | Cria um novo aluno                   |
| `PUT`    | `/alunos/{id}`  | Atualiza os dados de um aluno        |
| `DELETE` | `/alunos/{id}`  | Remove um aluno pelo ID              |

### Exemplo de requisição (POST)

```json
{
  "nome": "Lucas Vargas",
  "dataNascimento": "2000-05-10",
  "matricula": "2025001"
}
```

---

## ⚙️ Configuração

As configurações de conexão com o banco de dados estão em `src/main/resources/application.properties`:

```properties
spring.application.name=gerenciamento-alunos
server.port: 8080

spring.datasource.url:jdbc:postgresql://localhost:5432/test
spring.datasource.username:postgres
spring.datasource.password:postgresql

spring.jpa.hibernate.ddl-auto:update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

> ⚠️ Antes de executar o projeto, crie um banco de dados PostgreSQL chamado `test` (ou ajuste o nome no `application.properties`) e atualize usuário/senha conforme seu ambiente.

---

## ▶️ Como executar o projeto

### Pré-requisitos
- Java 21 instalado
- PostgreSQL em execução
- Maven (ou utilize o Maven Wrapper incluído no projeto)

### Passos

1. Clone o repositório:
```bash
git clone https://github.com/lucasvargass/projeto-spring-gerenciamento-alunos.git
cd projeto-spring-gerenciamento-alunos
```

2. Configure o banco de dados PostgreSQL no `application.properties`.

3. Execute a aplicação com o Maven Wrapper:

```bash
./mvnw spring-boot:run
```

No Windows:
```bash
mvnw.cmd spring-boot:run
```

4. A API estará disponível em:
```
http://localhost:8080/alunos
```

---

## 🧪 Testes

O projeto conta com uma estrutura inicial de testes utilizando **JUnit** e **Spring Boot Test**, podendo ser executados com:

```bash
./mvnw test
```

---

## 🗺️ Roadmap / Próximos passos

- [ ] Adicionar validações nos campos da entidade `Aluno` (Bean Validation)
- [ ] Implementar tratamento global de exceções (ex: aluno não encontrado)
- [ ] Adicionar DTOs para separar a camada de API da entidade JPA
- [ ] Documentar a API com Swagger/OpenAPI
- [ ] Escrever testes unitários e de integração para `service` e `controller`
- [ ] Evoluir a arquitetura para microsserviços

---

## 👨‍💻 Autor

Desenvolvido por **Lucas Vargas** como projeto de estudo em desenvolvimento backend com Java e Spring Boot.

- GitHub: [@lucasvargass](https://github.com/lucasvargass)
