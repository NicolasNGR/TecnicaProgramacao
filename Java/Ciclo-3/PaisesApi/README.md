# PaisesApi

Aplicação Spring Boot + Thymeleaf que consome a API pública REST Countries.

## Requisitos
- Java 17+
- Maven 3.9+

## Como executar
```bash
mvn spring-boot:run
```

Acesse:
- http://localhost:8080/paises

## Funcionalidades
- formulário para digitar o nome de um país em inglês
- consumo do endpoint `https://restcountries.com/v3.1/name/{nome}`
- exibição de nome comum, nome oficial, capital, região, sub-região, população, área, idiomas e bandeira
