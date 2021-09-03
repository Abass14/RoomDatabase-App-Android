package com.example.roomdatabase.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


//Data Access Object : Contains methods for accessing the database. We execute all database queries here
@Dao
interface UserDao {

    //function to add users
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUsers(user: User)

    //function to read user data
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>
}