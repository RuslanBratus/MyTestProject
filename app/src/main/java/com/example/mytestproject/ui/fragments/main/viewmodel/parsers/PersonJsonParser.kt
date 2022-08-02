package com.example.mytestproject.ui.fragments.main.viewmodel.parsers

import android.content.Context
import android.util.Log
import com.example.mytestproject.ui.fragments.main.viewmodel.models.Person
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader


class PersonJsonParser {


    companion object {
        private val allPersonsJson = "people_data"
        private var mPersons  = mutableListOf<Person>()
        val persons get() = mPersons


        fun getJsonObjects(context: Context) : List<Person>{


            val rawId: Int = context.resources.getIdentifier(allPersonsJson, "raw", context.packageName)
            val mInputStream: InputStream = context.resources.openRawResource(rawId)
            val mBufferedReader = BufferedReader(InputStreamReader(mInputStream))

            val persons: MutableList<Person> = Gson().fromJson(mBufferedReader, object : TypeToken<List<Person?>?>() {}.type)

            Log.i("personJson", "persons = $persons")
            mPersons = persons
            return mPersons
        }


    }
}