# delivery-services

## Motivação
Este projeto tem por objetivo prover uma API REST para integração de gerenciamento de entregas.
A arquitetura do projeto tem a finalidade de tem alta disponilidade e performance.

O serviço foi desenvolvido utilizando Spring Boot por ser a forma mais fácil e rápida de se criar um microserviço. Para armazenamento das informações foi escolhido o banco de dados NoSQL MongoDB, por este oferecer uma boa disponibilidade
Para desacoplar a dependência do banco de dados, as operações que fazem alguma atualização na base são enviadas para um fila no RabbitMQ, e então um consumidor atualiza a base, outro consumidor atualiza o cache no Redis. Nas operações de consulta primeiramente vamos ao cache.

A documentação da API está sendo disponibilizada no swagger.

http://localhost:8080/api/swagger-ui.html


## Pontos Melhoria
Tornar nosso microserviço reativo, utilizando a stack do Netflix OSS ou projeto Spring Cloud que encapsula este, afim de termos mais recursos para escalarmos nosso serviço, como load balance, circuit braker, descoberta de novos serviços dinamicamente, entre outros.
Outra melhoria é construirmos outro microserviço de gerenciamento de Token ou Shared Key Authentication, e utilizarmos no serviço de entrega, para tornar nossa API REST segura.

## Execução
O projeto está sendo disponibilizado em um container Docker.
As dependências do projeto estão sendo providas pelo docker compose.

1) Fazer o clone do projeto
2) Executar o shell na raiz do projeto, build.sh







