package com.example.wehack_finances

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.text.InputFilter
import android.text.Spanned
import android.text.TextWatcher
import androidx.lifecycle.lifecycleScope
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.room.util.copy

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [PresentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@Suppress("DEPRECATION")
class PresentFragment : Fragment() {
    private lateinit var submit: Button
    private lateinit var entery: EditText
    private lateinit var earned: TextView
    private var customer: account? = null
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
//    private val sharedViewModel: SharedViewModel by activityViewModels()

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
        Log.d("PresentFragment", "View loaded: ${view.findViewById<Button>(R.id.submitButton)}")




        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        submit = view.findViewById<Button>(R.id.submitButton)
        entery = view.findViewById<EditText>(R.id.amountEdit)
        entery.inputType = android.text.InputType.TYPE_CLASS_NUMBER or android.text.InputType.TYPE_NUMBER_FLAG_DECIMAL
        earned = view.findViewById<TextView>(R.id.earningsTextView)
        customer = arguments?.getParcelable<account>("Account")
        Log.d("PresentFragment", "Customer: $customer")  // Add this line
        Log.d("PresentFragment", "Submit Button View: $submit")
        setNumericInputFilter(entery)
        setNumericTextWatcher(entery)
        submit.setOnClickListener {
            var money:Int?=0
            Log.d("SubmitTest", "It was clicked")
            Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
            if (customer != null) {
                //Log.d("PresentFragment", "Customer in onClick: $customer")
                money = entery.text.toString().toIntOrNull()
                if(money!=null){
                    customer!!.earnings += money!!
                    earned.text = "New earnings: ${customer!!.earnings}"
                    entery.text.clear()
                }
                //Option 1: If you want to update the earnings in the ViewModel and let it handle updating observers:
                /*sharedViewModel.customer?.let {
                    val updatedCustomer = it.copy(earnings = it.earnings + money)
                    sharedViewModel.updateCustomer(updatedCustomer)  //This will notify any observers (e.g., other fragments, activity)
                }*/


            }
        }
    }

    fun setNumericInputFilter(editText: EditText) {
        editText.filters = arrayOf(object : InputFilter {
            override fun filter(
                source: CharSequence?,
                start: Int,
                end: Int,
                dest: Spanned?,
                dstart: Int,
                dend: Int
            ): CharSequence? {
                if (source.isNullOrEmpty()) {
                    return null // Allow deletion
                }
                val filteredStringBuilder = StringBuilder()
                for (i in source.indices) {
                    val character = source[i]
                    if (character.isDigit() || character == '.') {  // Allow digits and decimal
                        if(character == '.' && dest?.contains('.') == true){
                            continue //Prevent multiple decimals
                        }
                        filteredStringBuilder.append(character)
                    }
                }
                return if (filteredStringBuilder.length == source.length) {
                    null // Accept the original input
                } else {
                    filteredStringBuilder.toString() // Replace with filtered input
                }
            }
        })
    }



    fun setNumericTextWatcher(editText: EditText) {
        editText.addTextChangedListener(object : TextWatcher {
            private var previousValue = ""

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                previousValue = s.toString()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                //Optional: Add formatting here, like thousand separators
            }

            override fun afterTextChanged(editable: Editable?) {
                val text = editable.toString()
                if (text.isEmpty()) {
                    return // Allow empty input
                }
                if (!isValidNumber(text)) {
                    editable?.apply {
                        replace(0, length, previousValue)
                        // Optional: Show an error message to the user, e.g., using a Toast or a helper text view
                        // editText.error = "Invalid number format"
                    }
                }
            }

            private fun isValidNumber(text: String): Boolean {
                return try {
                    text.toDouble() // Or text.toInt() if you need integers
                    true
                } catch (e: NumberFormatException) {
                    false
                }
            }
        })
    }










}