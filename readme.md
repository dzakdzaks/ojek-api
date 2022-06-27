# Note Spring Boot Kotlin API

## Base url

```
https://note-springboot-kotlin.herokuapp.com/
```

## Table endpoints
### Note

| Name                       | Endpoint                                                    | Method   | Body and response                 |
| -------------------------- | ----------------------------------------------------------- | -------- |-----------------------------------|
| Get Note By ID                   | `/v1/note/{id}`                                   | `GET`   | [example](#note---get-note-by-id) |
| Get Notes                      | `/v1/note`                                      | `GET`   | [example](#note---get-notes)      |
| Add Note         | `/v1/note`                                            | `POST`    | [example](#note---add-note)       |
| Update Note               | `/v1/note/{id}`                                        | `PUT`    | [example](#note---update-note)    |
| Delete Note          | `/v1/note/{id}`                  | `DELETE`    | [example](#note---delete-note)    |

## Run on localhost
- Run `./gradlew bootRun`
- Then access to `http://localhost:8003`

## Postman collection
Import file [note-springboot-kotlin.postman_collection.json](https://github.com/dzakdzaks/note-springboot-kotlin/blob/master/note-springboot-kotlin.postman_collection.json) to your postman, and setup  your environment collection.

---

## Note Examples
### Note - Get Note By Id

```
GET /v1/note/62b1524bd0db143a3a80ae46
```
Response

```json
{
    "status": 200,
    "message": "Get Note Success",
    "data": {
        "id": "62b1524bd0db143a3a80ae46",
        "content": "note 1",
        "createdDate": "2022-06-21T05:08:27.033+00:00",
        "updatedDate": "2022-06-21T05:08:27.033+00:00"
    }
}
```

### Note - Get Notes

```
POST /v1/note
```

Response

```json
{
    "status": 200,
    "message": "Get Notes Success",
    "data": [
        {
            "id": "62b1524bd0db143a3a80ae46",
            "content": "note 1",
            "createdDate": "2022-06-21T05:08:27.033+00:00",
            "updatedDate": "2022-06-21T05:08:27.033+00:00"
        },
        {
            "id": "62b15a302e74cd6dfb74235a",
            "content": "note 2",
            "createdDate": "2022-06-21T05:42:08.057+00:00",
            "updatedDate": "2022-06-21T05:42:08.057+00:00"
        },
        {
            "id": "62b15a342e74cd6dfb74235b",
            "content": "note 3",
            "createdDate": "2022-06-21T05:42:12.322+00:00",
            "updatedDate": "2022-06-21T05:42:12.322+00:00"
        }
    ]
}
```

### Note - Add Note

```
POST /v1/note
```
Body

```json
{
    "content":"note 3"
}
```

Response

```json
{
    "status": 200,
    "message": "Add Note Success",
    "data": {
        "id": "62b15a342e74cd6dfb74235b",
        "content": "note 3",
        "createdDate": "2022-06-21T05:42:12.322+00:00",
        "updatedDate": "2022-06-21T05:42:12.322+00:00"
    }
}
```

### Note - Update Note

```
PUT /v1/note
```

Body

```json
{
    "content":"note 2 updated"
}
```

Response

```json
{
    "status": 200,
    "message": "Update Note Success",
    "data": {
        "id": "62b15a302e74cd6dfb74235a",
        "content": "note 2 updated",
        "createdDate": "2022-06-21T05:42:08.057+00:00",
        "updatedDate": "2022-06-21T05:45:59.325+00:00"
    }
}
```

### Note - Delete Note

```
GET /v1/note/62b15a302e74cd6dfb74235a
```

Response

```json
{
    "status": 200,
    "message": "note 2 updated Deleted",
    "data": null
}
```
