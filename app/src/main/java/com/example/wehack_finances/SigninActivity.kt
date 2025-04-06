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
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch

var bank = mutableListOf<account>()
class SigninActivity: AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    private lateinit var button:Button
    private lateinit var email:EditText
    private lateinit var password:EditText
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)



        button = findViewById<Button>(R.id.button)
        email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        password = findViewById<EditText>(R.id.editTextTextPassword)


        button.setOnClickListener {
            var p: account? = null
            for (i in bank) {
                if (i.email == email.text.toString() && i.password == password.text.toString()) {
                    p=i;
                }
            }
            if(p==null){
                p = account(email.text.toString(),password.text.toString(),100,0, mutableListOf<Int>())
                bank.add(p)
            }



            val intent =Intent(this@SigninActivity,MainActivity::class.java)
            intent.putExtra("Account",p)
            startActivity(intent)
            //val result=Intent();
            //setResult(Activity.RESULT_OK,result)

            //database work

            finish()


        }
    }


}