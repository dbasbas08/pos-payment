## POS Payment Test Project

POS Ecommerce payment test project using GraphQL and Kotlin

### Built With

* Kotlin
* GraphQL
* PostgreSQL
* Spring Boot
* Spring Data JPA

### Instructions

Clone the repo

```
git clone https://github.com/dbasbas08/pos-payment.git
```

Build the project

```
./gradlew build
```

Start up docker

```
docker compose up
```

Start up server

```
./gradlew bootRun
```

Accessing the API

```
http://localhost:8080/graphiql
```

### Sample payload


### Mutation

* Create payment


```
mutation (
    $price: String!,
    $price_modifier: Float!,
    $payment_method: PaymentMethod!,
    $datetime: String!
) {
  createPayment(
      price: $price
      price_modifier: $price_modifier
      payment_method: $payment_method
      datetime: $datetime
  ) {
    final_price
    points
  }
}
```

GraphQL Variables

```
{
  "price": "100",
  "price_modifier": 0.95,
  "payment_method": "MASTERCARD",
  "datetime": "2022-09-01T00:00:00Z"
}
```

### Query

```
query (
    $startDateTime: String!,
    $endDateTime: String!
) {
  sales (
      startDateTime: $startDateTime,
      endDateTime: $endDateTime
  ) {
    points
    sales
    datetime
  }
}
```

GraphQL Variables

```
{
  "startDateTime": "2022-09-01T00:00:00Z",
  "endDateTime": "2022-09-01T23:00:01Z"
}
```

