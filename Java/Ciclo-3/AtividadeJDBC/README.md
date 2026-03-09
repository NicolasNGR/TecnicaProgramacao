# Sistema de Gestão de Tarefas (JDBC)

Projeto desenvolvido para a disciplina **Técnicas de Programação**.

O sistema consiste em um **gerenciador de tarefas em Java**, utilizando **JDBC para persistência de dados** e **SQLite como banco de dados**.  
A interação com o usuário ocorre através de um **menu no console**.

---

# Tecnologias utilizadas

- Java
- JDBC
- SQLite
- Programação Orientada a Objetos
- Git e GitHub

---

# Estrutura do projeto

```
src
├── Model
│   Categoria.java
│   Tarefa.java
│
├── DAO
│   Conexao.java
│   CategoriaDAO.java
│   TarefaDAO.java
│
├── View
│   MenuConsole.java
│
└── Main.java
```

---

# Padrão de organização

O projeto foi organizado utilizando uma separação em camadas:

### Model
Responsável por representar as **entidades do sistema**.

Exemplo:

- Categoria
- Tarefa

---

### DAO (Data Access Object)

Responsável pela **comunicação com o banco de dados**.

Contém operações como:

- Inserir dados
- Buscar dados
- Atualizar dados
- Excluir dados

---

### View

Responsável pela **interface com o usuário**.

Neste projeto foi utilizado um **menu no console** para interação.

---

# Funcionalidades do sistema

O sistema permite:

- Criar categorias
- Criar tarefas
- Listar tarefas
- Editar tarefas
- Excluir tarefas
- Marcar tarefas como concluídas
- Filtrar tarefas por categoria
- Filtrar tarefas por status

---

# Banco de dados

O sistema utiliza **SQLite**.

O banco é criado automaticamente ao executar o programa.

Arquivo gerado:

```
tarefas.db
```

Tabelas criadas automaticamente:

- categorias
- tarefas

---

# Como executar o projeto

1. Baixar o driver JDBC do SQLite
2. Adicionar o arquivo `.jar` no **Build Path** do projeto
3. Executar a classe:

```
Main.java
```

---

# Exemplo do menu do sistema

```
===== GESTÃO DE TAREFAS =====

1 - Cadastrar categoria
2 - Cadastrar tarefa
3 - Listar todas as tarefas
4 - Editar tarefa
5 - Marcar tarefa como concluída
6 - Excluir tarefa
7 - Filtrar por categoria
8 - Filtrar por status
0 - Sair
```

---

# Objetivo do projeto

Este projeto foi desenvolvido com o objetivo de praticar:

- Programação Orientada a Objetos
- Uso de JDBC
- Conexão com banco de dados
- Organização de projetos em camadas

---

# Autor

Projeto desenvolvido por **Nicolas** para fins acadêmicos.
