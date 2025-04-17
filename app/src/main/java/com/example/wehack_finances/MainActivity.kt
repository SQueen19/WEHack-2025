package com.example.wehack_finances

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.util.Log
//import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
//import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch

private const val API_URL =""

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
   // private val sharedViewModel: SharedViewModel by viewModels()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val intent: Intent? = getIntent()
        var person:account? = null
        if (intent != null) {
            person = intent.getParcelableExtra("Account")
            if (person == null){
                val intent = Intent(this@MainActivity, SigninActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
               // if (appRequiresInitialData) {
                    //      // Show a user-friendly message and optionally finish activity
                    //      Toast.makeText(this, "App requires data. Please launch correctly.", Toast.LENGTH_LONG).show()
                    //      finish()
                    //  }
                //sharedViewModel.setCustomer(person)

            }

        }
        val fragmentManager: FragmentManager = supportFragmentManager
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        //val person = intent.getParcelableExtra<account>("Account")

        val toggleFragment = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        //val recyclerView: RecyclerView = findViewById(R.
        val fragment2: Fragment = PastFragment()
        val fragment1: Fragment = PresentFragment()

        val fragment3: Fragment = FutureFragment()
       toggleFragment.setOnItemSelectedListener { item ->
           val bundle = Bundle().apply {
               putParcelable("Account", person)
           }

           val fragment: Fragment = when (item.itemId) {
               R.id.action_past -> PastFragment().apply {arguments = bundle}
               R.id.action_present -> PresentFragment().apply { arguments = bundle }
               R.id.action_future -> FutureFragment().apply {arguments = bundle}
               else -> PresentFragment().apply { arguments = bundle }
           }

           Log.d("CreatingFragment", "Switching to: ${item.itemId} with account: $person")
           fragmentManager.beginTransaction()
               .replace(R.id.rlContainer, fragment)
               .commit()

           true
       }

       // Initial fragment load
       val initialFragment = PresentFragment().apply {
           arguments = Bundle().apply {
               putParcelable("Account", person)
           }
       }

       fragmentManager.beginTransaction()
           .replace(R.id.rlContainer, initialFragment)
           .commit()
   }



   }