package com.example.roomdatabase.data

import androidx.lifecycle.LiveData


// A repository is a class that abstract access to multiple data sources
class UserRepository(val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUsers(user)
    }
}