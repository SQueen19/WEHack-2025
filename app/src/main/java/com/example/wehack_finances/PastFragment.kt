package com.example.wehack_finances

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment

import android.view.LayoutInflater
import android.view.View
//import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PastFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PastFragment : Fragment() {
   // private val sharedViewModel: SharedDataViewModel by activityViewModels()
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var list:TextView
    private lateinit var total:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =inflater.inflate(R.layout.fragment_past, container, false)
        val customer = arguments?.getParcelable<account>("Account")

        total = view.findViewById<TextView>(R.id.textView6)
        total.text = "Total Earned: $${customer!!.earnings}"
        list = view.findViewById<TextView>(R.id.listTextView)
        for(i in 0..customer!!.array.size) {
            list.append("Day $i :  ${customer.array[i]}\n")
        }
        return view
    }


}