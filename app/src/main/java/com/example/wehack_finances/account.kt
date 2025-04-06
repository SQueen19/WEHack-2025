package com.example.wehack_finances
import androidx.room.Entity
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class account (
    val email: String,
    val password:String,
    var goal: Int,
    var earnings: Int,
    val array: MutableList<Int>
) :Parcelable{

}