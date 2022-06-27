package com.dzakdzaks.ojekapi.database

import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo
import org.springframework.stereotype.Component

@Component
class DatabaseComponent {
    val database: MongoDatabase by lazy {
        val dbUrl = System.getenv("DATABASE_URL")
        KMongo.createClient(dbUrl).getDatabase("ojek")
    }
}