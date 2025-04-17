package com.example.wehack_finances

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FutureFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("DEPRECATION")
class FutureFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mark:TextView
    private lateinit var task:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_future, container, false)
        mark = view.findViewById<TextView>(R.id.moneyGoal)
        task = view.findViewById<TextView>(R.id.textView5)
        val customer = arguments?.getParcelable<account>("Account")
        if (customer != null) {
            while(customer.earnings>customer.goal){
                customer.goal = customer.goal*2
            }
        }
        mark.text = "$" + customer!!.goal.toString()
        task.text = "Only $" + (customer.goal-customer.earnings).toString() + " away!"


    return view
    }

}