package com.example.roomdatabase.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

//ViewModel provides data to the UI in a lifecycle aware manner that survives configuration changes
class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val readAlData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAlData = repository.readAllData
    }

    fun addUser(user: User){
        viewModelScope.launch {
            repository.addUser(user)
        }
    }
}