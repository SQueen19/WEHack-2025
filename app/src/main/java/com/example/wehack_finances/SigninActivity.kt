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
import com.example.wehack_finances.ApplicationDatabase.Companion.getDatabase
//import com.example.wehack_finances.ApplicationDatabase.Companion.getDatabase
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch


class SigninActivity: AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var button:Button
    private lateinit var emailText:EditText
    private lateinit var passwordText:EditText
    private lateinit var bankDao:AccountDao

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)



        button = findViewById<Button>(R.id.button)
        emailText = findViewById<EditText>(R.id.editTextTextEmailAddress)
        passwordText = findViewById<EditText>(R.id.editTextTextPassword)

        bankDao = getDatabase(applicationContext).userDao()

        button.setOnClickListener {
            lifecycleScope.launch {
                val email = emailText.text.toString()
                val password = passwordText.text.toString()

                // Retrieve account from database based on email
                val db = ApplicationDatabase.getDatabase(applicationContext)
                val dao = db.userDao()

                val account = dao.getAccountByEmail(email)


                if (account != null) {
                    // Verify password (compare hashed passwords)
                    if (passwordText.text.toString() == account.password )
                    { // Replace with your hashing logic
                        navigateToMainActivity(account(email, password, account.earnings))
                    } else {
                        // Password incorrect - show error message (not implemented here)
                    }
                } else {
                    // Account not found - create a new account
                    // (In a real app, you'd likely have a separate registration flow)
                    val hashedPassword = passwordText.text.toString() // Replace with your hashing logic
                    val newAccount =
                        account(email = email, password = hashedPassword, goal = 100.0, earnings = 0.0)
                    dao.insert(newAccount)
                    navigateToMainActivity(newAccount)
                }
            }
        }


    }


    private fun navigateToMainActivity(a: account) {

            val intent = Intent(this@SigninActivity, MainActivity::class.java)
            intent.putExtra("Account", a)
            startActivity(intent)
            finish() // Finish SigninActivity after successful sign-in/registration
        }

}

