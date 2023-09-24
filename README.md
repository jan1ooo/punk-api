## Back-end 💻

### 1° Passo é se registrar 
Acesse o endereço _/auth/register_ e preencha o username e password no JSON.

![Registrar](https://user-images.githubusercontent.com/95763551/270189438-6526e94e-6182-4a8e-ba32-85b7001052b1.jpg)

Após preencher o JSON, envie a requisição POST, caso concluído, receberá um mensagem de confirmação.

![Registrar2](https://user-images.githubusercontent.com/95763551/270189521-d379d8f5-a40e-4ee6-a279-8c38dbcdc9c2.jpg)

Se tentar enviar o mesmo JSON mais de uma vez, acontece um erro pois não é permitido criar mais de um usuário com o mesmo username

![Regisrar3](https://user-images.githubusercontent.com/95763551/270189586-c44e3adb-bb56-44a2-85bb-289bc6057158.jpg)

### 2° Passo é fazer o login
Acesse o endereço _/auth/login_ e preencha o JSON com o mesmo username e password registrado no 1° passo.

![Login](https://user-images.githubusercontent.com/95763551/270189836-e6f933e0-5ad6-4833-afa9-a27d8899c036.jpg)

Após enviar a requisição POST e o username e password estarem certos, irá retornar um toke e com este token, você irá conseguir acessar os endpoints da aplicação.

![Login1](https://user-images.githubusercontent.com/95763551/270189871-cdb11b3d-c8d3-4bae-bde8-8b7eaa3a460a.jpg)
