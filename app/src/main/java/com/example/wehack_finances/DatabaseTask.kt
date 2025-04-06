package com.example.wehack_finances

import android.os.AsyncTask
import android.util.Log

import org.bson.Document
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import androidx.appcompat.app.AppCompatActivity
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
/*
class DatabaseTask : AsyncTask<Void, Void, Void>() {
    override fun doInBackground(vararg params: Void?): Void? {
        val dbHelper = MongoDatabase()
        dbHelper.insertDocument("costumer", Document("first_name", "Alice"))
        dbHelper.findDocuments("catagory")
        return null
    }
}
// To execute the task
//DatabaseTask().execute()*/