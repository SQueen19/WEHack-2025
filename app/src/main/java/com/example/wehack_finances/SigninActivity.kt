package com.example.wehack_finances

import android.accounts.Account
import android.os.Bundle
import android.app.Activity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import android.annotation.SuppressLint
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.EditText
//import androidx.compose.ui.semantics.password
//import androidx.compose.ui.semantics.text
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.example.wehack_finances.ApplicationDatabase.Companion.getDatabase
//import com.example.wehack_finances.ApplicationDatabase.Companion.getDatabase
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.Firebase
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database
import kotlinx.coroutines.launch


class SigninActivity: AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var button:Button
    private lateinit var emailText:EditText
    private lateinit var passwordText:EditText
    private lateinit var newAccount :account
    private lateinit var banks: MutableList<account>

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)



        button = findViewById<Button>(R.id.button)
        emailText = findViewById<EditText>(R.id.editTextTextEmailAddress)
        passwordText = findViewById<EditText>(R.id.editTextTextPassword)
        banks = mutableListOf()
        //val database = Firebase.database
        //val reference = FirebaseDatabase.getInstance()
        //var myRef = reference.getReference()
        //myRef.setValue("Hello, World!")
       // myRef.setValue("Hello, World!")
        //bankDao = getDatabase(applicationContext).userDao()

        button.setOnClickListener {

                val email = emailText.text.toString()
                val password = passwordText.text.toString()

                // Retrieve account from database based on email

              // myRef = database.getReference("accounts")

                 newAccount= account(email, password,100.1,0.0)
                banks.add(newAccount)

            //myRef.setValue(newAccount)
            //myRef.push().setValue(newAccount)



            val intent = Intent(this@SigninActivity, MainActivity::class.java)
            intent.putExtra("Account", newAccount)
            startActivity(intent)
            finish()
        }


    }




}

