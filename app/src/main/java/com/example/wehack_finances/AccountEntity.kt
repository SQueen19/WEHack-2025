package com.example.wehack_finances
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bank_table")

data class AccountEntity(
    @PrimaryKey val email: String,
    val password: String,
    val earnings: Double,
    val goal: Double,
    val array: List<Int>
)