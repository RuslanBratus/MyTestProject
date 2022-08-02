package com.example.mytestproject.ui.fragments.main.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mytestproject.ui.fragments.main.viewmodel.models.Person
import com.example.mytestproject.ui.fragments.main.viewmodel.parsers.PersonJsonParser

class MainViewModel(context : Context) : ViewModel() {
    var mPersons : MutableLiveData<List<Person>> = MutableLiveData()
    val persons get() = mPersons

    init {
        mPersons.value = PersonJsonParser.getJsonObjects(context = context)
    }


    fun updateListUsers(context: Context) {
        mPersons.value = PersonJsonParser.getJsonObjects(context = context)
    }
}