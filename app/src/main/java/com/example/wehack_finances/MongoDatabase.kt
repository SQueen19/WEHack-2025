
package com.example.wehack_finances

// In MongoDatabase.kt
import android.os.AsyncTask
import android.provider.DocumentsContract

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import androidx.appcompat.app.AppCompatActivity
import org.bson.Document
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
//...other imports
/*
private const val databaseKey = "mongodb+srv://<sydamani1513>:<h5G2TScq43uhvvbM>@cluster0.56ongae.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0"
class MongoDatabase: AppCompatActivity() {


        private val CONNECTION_STRING = databaseKey
        private val mongoClient: MongoClient = MongoClients.create(CONNECTION_STRING)
        private val database: MongoDatabase = mongoClient.getDatabase("cluster0")

        fun findDocuments(collectionName: String) {
            val collection: MongoCollection<Document> = database.getCollection(collectionName)
            for (doc in collection.find()) {
                println(doc.toJson())
            }
        }
        fun insertDocument(collectionName: String, document: Document) {
            val collection: MongoCollection<Document> = database.getCollection(collectionName)
            collection.insertOne(document)
        }



}
*/