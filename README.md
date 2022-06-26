
<h1 align="center"> Spring boot API Sequence Alticci</h1>
<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=v1.0.0%20FINALIZADO&color=GREEN&style=for-the-badge"/>
</p>

## Tabela de conteúdos 

* [Descrição](#----descrição)
* [:hammer: Funcionalidades do projeto](#hammer-funcionalidades-do-projeto)
* [ 🛠️ Rodando o projeto](#%EF%B8%8F-rodando-o-projeto)
* [☔ Testes](#-testes)
* [✔️ Tecnologias utilizadas](#%EF%B8%8F-tecnologias-utilizadas)

<h4 align="center"> 
   Descrição
</h4>
<p>  O projeto tem como objetivo a prática do desenvolvimento com Spring Boot, para criação de APIs Rest, e com Junit, para testes unitários. O que o projeto se proponhe a fazer é, receber um valor e então retornar o seu representante na sequencia de alticci.</p>

## :hammer: Funcionalidades do projeto
<p>O projeto pode ser rodado em qualquer máquina com o maven e o java 11 instalados, assim as referências a url se referem a url do usuário que está rodando o projeto.
O projeto possui um Swagger embarcado para a realização de teste, acessível em: url/swagger-ui.html
</p>

- `Funcionalidade 1`: [POST] url/alticci

  - Request:
    ```
    url/alticci/{index}
    ```
  - Response:
  
    - 201:
      ```
      {
        "valueOriginal": int,
        "valueRetrived": int
      }
      ```
    - 400:
      ```
        {
        "solicited": int,
        "mensagem": "string"
      }
      ```
     - 500:
        ```
        NO BODY
        ```

## 🛠️ Rodando o projeto

Partindo do pressuposto que o java e o maven já encontram se instalados, além disso a porta 8080 não pode estar em uso,
para rodar o projeto é necessário baixa-lo,
```
git clone https://github.com/tiagoj61/SpringAlticci.git
``` 
navegar até a pasta do projeto e rodar o seguinte comando:
```
mvn spring-boot:run
```
assim será possível utilizar as funcionalidades descritas acima.

Ainda é possível rodar o projeto fazendo o download do zip e rodando através do comando:
```
mvnw spring-boot:run
```

## ☔ Testes

Os teste do sistema são executados através do comando ‘mvn test’ e a resposta é exibida no console.

O sistema abrange uma gama de testes unitários tão grande quanto possível, porém sempre é possível que existam teste não mapeados, no package de testes é possível encontrar os teste que abrangem o package de bo, facade e controller, que são os principais pacotes de funcionalidades da aplicação.

Assim foram mapeados as seguintes exceptions para os cenários fora do esperado no sistema, são eles:

  SolicitedValueNegativeException.java
  
    → Para cenários onde o index não atende ao requisito de ser positivo

## ✔️ Tecnologias utilizadas

- ``Maven 3.8.6``
- ``Java 11``
- ``Spring Boot 2.7.1``
- ``Junit 5``
- ``Spring Fox``
