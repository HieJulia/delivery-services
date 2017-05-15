# delivery-services

## Motivação
Este projeto tem por objetivo prover uma API REST para integração de gerenciamento de entregas.
A arquitetura do projeto tem a finalidade de tem alta disponilidade e performance.

O serviço foi desenvolvido utilizando Spring Boot por ser a forma mais fácil e rápida de se criar um microserviço. Para armazenamento das informações foi escolhido o banco de dados NoSQL Cassandra, por este oferecer uma alta disponibilidade e a facilidade de fazer a replicação dos dados nos nós do cluster.
Para desacoplar a dependência do banco de dados, as operações que fazem alguma atualização na base são enviadas para um fila no RabbitMQ, e então um consumidor atualiza a base, outro consumidor atualiza o cache no Redis. Nas operações de consulta primeiramente vamos ao cache.

## Pontos Melhoria
Tornar nosso microservico reativo, utilizando a stack do Netflix OSS. Afim de termos mais recursos para escalarmos nosso serviço, como load balance, circuit braker, descoberta de novos serviços dinamicamente, entre outros.
Outra melhoria é construirmos outro microserviço de gerenciamento de Token e utilizarmos no serviço de entrega, para tornar nossa API mais segura.

## Execução
Para executar o projeto devemos ter as seguintes dependências no ambiente:
Cassandra 3.X, Redis 3.X, Maven 3.X, RabbitMQ 3.6.X

1) Inicializar e criar KEYSPACE no cassandra

```javascript
CREATE KEYSPACE IF NOT EXISTS delivery WITH replication = {'class':'SimpleStrategy', 'replication_factor':1}


CREATE TABLE IF NOT EXISTS  delivery.deliveryOrder (

    orderId uuid,

    type varchar,

    description varchar,

    address varchar,

    quantity int,

    total double,

    status varchar,

    primary key((orderId))

);

```

2) Inicializar o RabbitMQ
3) Inicializar o Redis
4) Fazer clone do projeto
5) Fazer build
```javascript
mvn clean install
```
6) Inicializar o projeto a partir do diretório
```javascript
java - jar target/delivery-services-0.0.1-SNAPSHOT.jar
```




