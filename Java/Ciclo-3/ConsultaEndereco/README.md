# Consulta de Endereço por CEP (Java)

Aplicação desenvolvida em **Java** que realiza consultas de endereço utilizando a **API ViaCEP** e mantém um histórico das pesquisas realizadas utilizando um `ArrayList`.

O sistema funciona em **modo console** e permite buscar, armazenar e gerenciar endereços consultados.

---

# Objetivo

Este projeto foi desenvolvido para praticar conceitos fundamentais da linguagem Java, incluindo:

- Consumo de APIs REST
- Programação Orientada a Objetos
- Estruturas de repetição (`while`)
- Estruturas condicionais (`switch case`)
- Estrutura de dados (`ArrayList`)
- Manipulação de dados em memória

---

# Funcionalidades

O sistema oferece três funcionalidades principais:

### 1 - Buscar endereço por CEP

- Consulta um endereço utilizando a API **ViaCEP**
- Verifica se o CEP já foi consultado anteriormente
- Caso já exista no histórico, retorna o endereço armazenado
- Caso não exista, realiza a consulta na API e adiciona ao histórico

---

### 2 - Excluir endereço da lista

Permite remover um endereço armazenado no histórico de consultas.

---

### 3 - Histórico de consultas

Exibe todos os endereços pesquisados durante a execução do sistema.

---

# Tecnologias Utilizadas

- Java
- Eclipse IDE
- API ViaCEP
- HTTPURLConnection
- ArrayList

---

# Estrutura do Projeto

```
src
│
├── model
│   └── Endereco.java
│
├── service
│   └── ViaCepService.java
│
└── Main.java
```

### model

Contém as classes que representam os dados do sistema.

### service

Contém as classes responsáveis por consumir serviços externos.

### Main

Classe principal responsável pela execução do programa e controle do menu.

---

# Menu do Sistema

Ao executar o programa, o usuário verá o seguinte menu:

```
===== MENU =====

1 - Buscar endereço
2 - Excluir endereço
3 - Histórico
0 - Sair
```

---

# Exemplo de Consulta

Entrada:

```
Digite o CEP: 01001000
```

Resultado:

```
CEP: 01001-000
Logradouro: Praça da Sé
Bairro: Sé
Cidade: São Paulo
UF: SP
```

---

# API Utilizada

ViaCEP

https://viacep.com.br

Exemplo de requisição:

```
https://viacep.com.br/ws/01001000/json/
```

---

# Como Executar

1. Importar o projeto no **Eclipse**
2. Executar a classe:

```
Main.java
```

---

# Autor

Projeto desenvolvido por **Nicolas** para fins acadêmicos utilizando **Java e consumo de APIs REST**.
