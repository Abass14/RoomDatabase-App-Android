package com.example.roomdatabase.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomdatabase.R
import com.example.roomdatabase.data.User
import com.example.roomdatabase.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {
    //initializing viewmodel
    lateinit var viewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
        view.addBtn.setOnClickListener {
            addDataToDatabase()
        }
        return view
    }

    private fun addDataToDatabase() {
        val firstName = firstName.text.toString()
        val lastName = lastName.text.toString()
        val age = age.text

        if (checkFields(firstName, lastName, age)){
            //create user
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))
            viewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully Added", Toast.LENGTH_SHORT).show()
            //Navigate back to list Fragment
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Make sure to fill all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkFields(firstName: String, lastName: String, age: Editable) : Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && TextUtils.isEmpty(age))
    }


}