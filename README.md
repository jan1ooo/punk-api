## Back-end 💻

### Foi utilizado
- Spring Boot
- Gradle
- Spring Data
- Punk API
- H2
- Spring Security
- JWT
- Postman
- Java 17
### Instruções

- Baixar/clonar o projeto;

- Use o IntelliJ para executar a aplicação

### 1° Passo é se registrar
Preencha o username e a password.
```sh
POST http://localhost:8080/auth/register
```
```sh
{
    "username": "",
    "password": ""
}
```

![Registrar2](https://user-images.githubusercontent.com/95763551/270189521-d379d8f5-a40e-4ee6-a279-8c38dbcdc9c2.jpg)


### 2° Passo é fazer o login
Preencha com o mesmo username e password que acabou de criar, você receberá um token como resposta, esse token vai ser a sua autenticação para acessar todos os endpoints, então é necessário copia-lo.
```sh
POST http://localhost:8080/auth/login
```
```sh
{
    "username": "",
    "password": ""
}
```
![Login1](https://user-images.githubusercontent.com/95763551/270189871-cdb11b3d-c8d3-4bae-bde8-8b7eaa3a460a.jpg)

## Acessando endpoints
Todos os endpoints são protegidos.
- Para acessar é necessário ter efetuado o login e recebido o token.
- Vá para a aba Authorization, o tipo do token é Bearer Token e cole o token recebido.
  
![Authorization](https://user-images.githubusercontent.com/95763551/270491055-a0d9f808-11d9-49a1-8769-f29a90a5fb48.jpg)
Todos os endpoins irão partir desse endereço
- Acessando ele sem filtro, trará apenas as 25 primeiras cervejas.
```sh
GET http://localhost:8080/api/beers
```
Buscar cervejas com páginação.
- O page=1 mostra a página que você quer olhar.
- O per_page=80 é a quantidade de cervejas que mostrará por página.
- O limite por página é de 80 cervejas
```sh
GET http://localhost:8080/api/beers/page=1&per_page=80
```
Buscar cerveja por id.
- id=325 recebe o id da cerveja.
- Só existem 325 cervejas.
```sh
GET http://localhost:8080/api/beers/id=325
```

Buscar cerveja de forma aletatória.
- Toda requisição retorna uma cerveja de forma aleatória.
```sh
GET http://localhost:8080/api/beers/random
```

Filtros.
- Todos os filtros são opcionais e sem eles a API retornará apenas as cervejas em ordem crescente de seu ID.
- Para acresentar um filtro, basta preencher o nome dele junto do valor na frente.
- Para vários filtros, necessário acrescentar um _&_ após cada filtro.
```sh
GET http://localhost:8080/api/beers/{FILTRO}
```
Ex:
- Retorna as cervejas que foram fabricadas antes de 11-2012
```sh
GET http://localhost:8080/api/beers/brewed_before=11-2012
```
- Retorna as cervejas que foram fabricadas antes de 11-2012 que contém ABV maior que o número fornecido
```sh
GET http://localhost:8080/api/beers/brewed_before=11-2012&abv_gt=6
```
# A lista de todos os filtros que podem ser utilizados
![Filters](https://user-images.githubusercontent.com/95763551/270489629-d0c04d17-5c15-4d14-b5ca-7c7f9468c48a.jpg)


