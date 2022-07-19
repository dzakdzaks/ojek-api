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

### Location
| Name             | Endpoint                                                                                   | Method | Token | Body and response              |
|------------------|--------------------------------------------------------------------------------------------|--------|-------|--------------------------------|
| Search Location  | `/location/search?name={name}&coordinate={coordinate}&limit={limit}`                       | `GET`  | no    | [example](#location---search)  |
| Reserve Location | `/location/reserve?coordinate={coordinate}`                                                | `GET`  | no    | [example](#location---reserve) |
| Routes Location  | `/location/routes?transportMode={transportMode}&origin={origin}&destination={destination}` | `GET`  | no    | [example](#location---routes)  |


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
---

## Location Examples

### Location - Search

```
GET /location/search?name=Masjid Almuhajirin&coordinate=-6.3064797,106.962724&limit=2
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": [
    {
      "name": "Masjid al-Muhajirin (Masjid Almuhajirin)",
      "address": {
        "city": "Bekasi Kota",
        "country": "Indonesia",
        "distric": "Jatiasih"
      },
      "coordinate": {
        "latitude": -6.30797,
        "longitude": 106.96394
      }
    },
    {
      "name": "Masjid al Muhajirin",
      "address": {
        "city": "Bekasi Kota",
        "country": "Indonesia",
        "distric": "Jatiasih"
      },
      "coordinate": {
        "latitude": -6.27818,
        "longitude": 106.94894
      }
    }
  ]
}
```

### Location - Reserve

```
GET /location/reserve?coordinate=-6.3064797,106.962724
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "name": "4, Jalan Garuda, Bekasi Kota 17424, Indonesia",
    "address": {
      "city": "Bekasi Kota",
      "country": "Indonesia",
      "distric": "Jatiasih"
    },
    "coordinate": {
      "latitude": -6.30645,
      "longitude": 106.96269
    }
  }
}
```

### Location - Routes

```
GET /location/routes?transportMode=scooter&origin=-6.3064797,106.962724&destination=-6.3057918,106.9570109
```

Response

```json
{
  "status": true,
  "message": "success",
  "data": {
    "route": [
      {
        "latitude": -6.306388,
        "longitude": 106.962729
      },
      {
        "latitude": -6.30637,
        "longitude": 106.96237
      },
      {
        "latitude": -6.30638,
        "longitude": 106.9621
      },
      {
        "latitude": -6.3064,
        "longitude": 106.96187
      },
      {
        "latitude": -6.30641,
        "longitude": 106.96176
      },
      {
        "latitude": -6.30642,
        "longitude": 106.96169
      },
      {
        "latitude": -6.30644,
        "longitude": 106.96161
      },
      {
        "latitude": -6.30648,
        "longitude": 106.96143
      },
      {
        "latitude": -6.3065,
        "longitude": 106.96129
      },
      {
        "latitude": -6.30653,
        "longitude": 106.96117
      },
      {
        "latitude": -6.30654,
        "longitude": 106.96104
      },
      {
        "latitude": -6.30652,
        "longitude": 106.96066
      },
      {
        "latitude": -6.30648,
        "longitude": 106.96054
      },
      {
        "latitude": -6.30648,
        "longitude": 106.96029
      },
      {
        "latitude": -6.30642,
        "longitude": 106.96005
      },
      {
        "latitude": -6.30636,
        "longitude": 106.95984
      },
      {
        "latitude": -6.30629,
        "longitude": 106.9597
      },
      {
        "latitude": -6.3062,
        "longitude": 106.9596
      },
      {
        "latitude": -6.30611,
        "longitude": 106.95948
      },
      {
        "latitude": -6.30605,
        "longitude": 106.95936
      },
      {
        "latitude": -6.30601,
        "longitude": 106.95923
      },
      {
        "latitude": -6.30598,
        "longitude": 106.95905
      },
      {
        "latitude": -6.30592,
        "longitude": 106.95847
      },
      {
        "latitude": -6.30589,
        "longitude": 106.95832
      },
      {
        "latitude": -6.30647,
        "longitude": 106.95811
      },
      {
        "latitude": -6.30624,
        "longitude": 106.95752
      },
      {
        "latitude": -6.30614,
        "longitude": 106.95724
      },
      {
        "latitude": -6.306031,
        "longitude": 106.956926
      }
    ]
  }
}
```

---

