package com.example.wehack_finances

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _customer = MutableLiveData<account?>()
    val customer: LiveData<account?> = _customer

    fun setCustomer(newCustomer: account) {
        _customer.value = newCustomer
    }

    fun updateCustomer(updatedCustomer: account){
        _customer.value = updatedCustomer
    }


}