package com.example.wehack_finances

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "bank_table")
data class account (

    var email: String = "",
    var password:String = "",
    var goal: Double = 0.0,
    var earnings: Double = 0.0
   // var array: MutableList<Int> = mutableListOf()
):Parcelable{
    lateinit var array: MutableList<Int>

    init {
        array = mutableListOf() // Initialize in the init block
    }
}


