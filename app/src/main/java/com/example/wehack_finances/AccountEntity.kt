package com.example.wehack_finances
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "accounts")

data class AccountEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val email: String,
    val password: String,
    val earnings: Double,
    val goal: Double,
    val array: List<Int>

)