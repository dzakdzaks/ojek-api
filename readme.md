# Ojek Spring Boot Kotlin API

## Base url

```
https://ojek-api.herokuapp.com/api/v1
```

## Table endpoints

### User Role
| Name                | Endpoint            | Method | Token | Body and response                 |
|---------------------|---------------------|--------|-------|-----------------------------------|
| Create User Role    | `/user-role/create` | `POST` | yes   | [example](#user-role---create)    |
| Get User Role By Id | `/user-role/{id}`   | `GET`  | yes   | [example](#user-role---get-by-id) |

### Customer
| Name               | Endpoint             | Method | Token | Body and response                |
|--------------------|----------------------|--------|-------|----------------------------------|
| Register Customer  | `/customer/register` | `POST` | no    | [example](#customer---register)  |
| Login Customer     | `/customer/login`    | `POST` | no    | [example](#customer---login)     |
| Get Customer By Id | `/customer`          | `GET`  | yes   | [example](#customer---get-by-id) |

### Driver
| Name             | Endpoint           | Method | Token | Body and response              |
|------------------|--------------------|--------|-------|--------------------------------|
| Register Driver  | `/driver/register` | `POST` | no    | [example](#driver---register)  |
| Login Driver     | `/driver/login`    | `POST` | no    | [example](#driver---login)     |
| Get Driver By Id | `/driver`          | `GET`  | yes   | [example](#driver---get-by-id) |


## Run on localhost
- Run `./gradlew bootRun`
- Then access to `http://localhost:8000`

## Postman collection
Import file [OJEK.postman_collection.json](https://github.com/dzakdzaks/ojek-api/blob/master/OJEK.postman_collection.json) to your postman, and setup  your environment collection.

---

## User Role Examples

### User Role - Create

```
POST /user-role/create
HEADER Authorization eyJhbGciOiJIUzI1NiJ9......
```

Body

```json
{
  "name": "Driver"
}
```
Response

```json
{
  "status": true,
  "message": "success",
  "data": true
}
```

### User Role - Get By Id

```
GET /user-role/62b969541cedfa6d5aca29fe
HEADER Authorization eyJhbGciOiJIUzI1NiJ9......
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "id": "62b969541cedfa6d5aca29fe",
    "name": "Customer"
  }
}
```

---

## Customer Examples

### Customer - Register

```
POST /customer/register
```
Body

```json
{
  "username":"jaki",
  "password":"1234"
}
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": true
}
```

### Customer - Login

```
POST /customer/login
```

Body

```json
{
  "username":"jaki",
  "password":"1234"
}
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiJ9......",
    "user": {
      "id": "62ba82f19f9f7d7f71a5d4b4",
      "username": "jaki",
      "role": {
        "id": "62b969541cedfa6d5aca29fe",
        "name": "Customer"
      },
      "createdDate": "2022-06-27T10:35:29.588+00:00",
      "updatedDate": "2022-06-27T10:35:29.588+00:00"
    }
  }
}
```

### Customer - Get By Id

```
GET /customer
HEADER Authorization eyJhbGciOiJIUzI1NiJ9......
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "id": "62ba809079342905dcf2a78a",
    "username": "jaki",
    "role": {
      "id": "62b969541cedfa6d5aca29fe",
      "name": "Customer"
    },
    "createdDate": "2022-06-27T10:35:29.588+00:00",
    "updatedDate": "2022-06-27T10:35:29.588+00:00"
  }
}
```

---

## Driver Examples

### Driver - Register

```
POST /driver/register
```
Body

```json
{
  "username":"dzaky",
  "password":"1234"
}
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": true
}
```

### Driver - Login

```
POST /driver/login
```

Body

```json
{
  "username":"dzaky",
  "password":"1234"
}
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "token": "eyJhbGciOiJIUzI1NiJ9......",
    "user": {
      "id": "62ba84cc9f9f7d7f71a5d4b6",
      "username": "dzaky",
      "role": {
        "id": "62b969941cedfa6d5aca2a00",
        "name": "Driver"
      },
      "createdDate": "2022-06-27T10:39:48.420+00:00",
      "updatedDate": "2022-06-27T10:39:48.420+00:00"
    }
  }
}
```

### Driver - Get By Id

```
GET /driver
HEADER Authorization eyJhbGciOiJIUzI1NiJ9......
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "id": "62ba85269f9f7d7f71a5d4b7",
    "username": "dzaky",
    "role": {
      "id": "62b969941cedfa6d5aca2a00",
      "name": "Driver"
    },
    "createdDate": "2022-06-27T10:39:48.420+00:00",
    "updatedDate": "2022-06-27T10:39:48.420+00:00"
  }
}
```

