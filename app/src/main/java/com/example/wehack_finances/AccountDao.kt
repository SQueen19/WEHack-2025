package com.example.wehack_finances

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AccountDao {
    @Query("SELECT * FROM  bank_table")
    fun getAll(): Flow<List< AccountEntity>>

    @Query("SELECT email, password, earnings, array, goal FROM bank_table WHERE email = :email LIMIT 1")
    suspend fun getAccountByEmail(email: String):  account?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(a:  account)

}