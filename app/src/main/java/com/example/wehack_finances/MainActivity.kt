package com.example.wehack_finances

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
//import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.launch

private const val API_URL =""

class MainActivity : AppCompatActivity() {
    var customer= intent.getParcelableExtra<account>("Account") as account
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val fragmentManager: FragmentManager = supportFragmentManager
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
        val person = intent.getParcelableExtra<account>("Account")

        val toggleFragment = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        //val recyclerView: RecyclerView = findViewById(R.
        val fragment2: Fragment = PastFragment()
        val fragment1: Fragment = PresentFragment()
        val fragment3: Fragment = FutureFragment()
        toggleFragment.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.action_past -> fragment = fragment2
                R.id.action_present -> fragment = fragment1
                R.id.action_future -> fragment = fragment3
            }
            val bundle = Bundle()
            bundle.putParcelable("Account", person)
            fragment.arguments = bundle
            fragmentManager.beginTransaction().replace(R.id.rlContainer, fragment).commit()
            true
        }
        fragmentManager.beginTransaction().replace(R.id.rlContainer, fragment1).commit()



    }

}