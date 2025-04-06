package com.example.wehack_finances

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var submit: Button
private lateinit var entery: EditText
private lateinit var earned: TextView
/**
 * A simple [Fragment] subclass.
 * Use the [PresentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PresentFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        val view= inflater.inflate(R.layout.fragment_present, container, false)
        submit = view.findViewById<Button>(R.id.submitButton)
        entery = view.findViewById<EditText>(R.id.amountEdit)
        earned = view.findViewById<TextView>(R.id.earningsTextView)
        var money=0
        val customer = arguments?.getParcelable<account>("Account")
        if (customer != null) {
            submit.setOnClickListener {

                money += entery.text.toString().toInt()
                customer.earnings += money
                earned.text = "New earnings: $money"
                entery.text.clear()

            }
        }
        return view
    }





}