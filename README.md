#API Spec
##Authentication
All api mush use this authentication

Request
- Header
- X-Api-key: "your secret api key"
##Creaate Product
Request
- Method : POST
- Endpoint : `/api/products`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body : 
```json
{
  "id" : "string, unique",
  "name" : "string",
  "price" : "long",
  "quantity" :"integer"
}
```
- Response :
```json
{
  "code": "number",
  "status" : "string",
  "data" : {
        "id" : "string, unique",
        "name" : "string",
        "price" : "long",
        "quantity" :"integer",
        "createdAt" : "date"
  }
 
}
```

##Get Product
Request
- Method : GET
- Endpoint : `/api/products/{id_products}`
- Header :
    - Accept: application/json
- Response :
```json
{
  "code": "number",
  "status" : "string",
  "data" : {
    "id" : "string, unique",
    "name" : "string",
    "price" : "long",
    "quantity" :"integer",
    "createdAt" : "date"
  }

}
```
##Update Product
Request
- Method : PUT
- Endpoint : `/api/products/{id_products}`
- Header :
    - Content-Type: application/json
    - Accept: application/json
- Body :
```json
{
  
  "name" : "string",
  "price" : "long",
  "quantity" :"integer"
}
```
- Response :
```json
{
  "code": "number",
  "status" : "string",
  "data" : {
    "id" : "string, unique",
    "name" : "string",
    "price" : "long",
    "quantity" :"integer",
    "createdAt" : "date"
  }

}
```

##List Product
Request
- Method : GET
- Endpoint : `/api/products`
- Header :
    - Accept: application/json
- Response :
- Query Param
  - size : number,
  - page : number
```json
{
  "code": "number",
  "status" : "string",
  "data" : [
        {
            "id" : "string, unique",
            "name" : "string",
            "price" : "long",
            "quantity" :"integer",
            "createdAt" : "date"
        },
        {
          "id" : "string, unique",
          "name" : "string",
          "price" : "long",
          "quantity" :"integer",
          "createdAt" : "date"
      }
    ]
}
```
##Delete Product

Request
- Method : DELETE
- Endpoint : `/api/products/{id_products}`
- Header :
    - Accept: application/json
- Response :
```json
{
  "code": "number",
  "status": "string"
}
```