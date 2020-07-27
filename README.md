

# Wenance: core-middleware

## Index

+ [Introduction](#introduccion)
+ [Api Reference](#apireference)
+ [Tests](#tests) 
  + [Unit](#unitarios) 
  + [Functional](#funcional)



<a name="introduccion"></a>
## Introducción
The trx-ae  project is a module that is in charge of depositing and withdrawing money from an account.

<a name="apireference"></a>
## API Reference
The project path to access services is *** http://localhost:8080/trx ***.

### Available services

Services that you can use to test create a new transaction and show trx historic.

|URL|Descriptions|Http Methods|
|---|---|---|
|http://localhost:8080/trx/new|Resource to generate a new transactions|POST|
|http://localhost:8080/trx/historic|Shows the transaction history|GET|


### Json Example for new trx:  
```
{
    "account": {
        "id": "4WXFODBV4CCVL",
        "balance": 2000.0,
        "accountType": "DEBT"
    },
    "amount": 100.0,
    "transactionType":"DEPOSIT"
} 
```

<a name="tests"></a>
## Tests
The project has Unit Tests. They will be detailed below:

<a name="unitarios"></a>
### Unitarios: 
The unit tests are inside the folder: src/test/java
In it you will find a package for each model that is tested.
To run the tests run the command: mvn test

