package com.example.mytestproject.ui.fragments.main.viewmodel.parsers

import android.content.Context
import android.util.Log
import com.example.mytestproject.ui.fragments.main.viewmodel.models.Date
import com.example.mytestproject.ui.fragments.main.viewmodel.models.Location
import com.example.mytestproject.ui.fragments.main.viewmodel.models.Person
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader


class PersonJsonParser {

    companion object {
        private val mPersons  = mutableListOf<Person>()
        public val persons get() = mPersons


        private fun readText(context: Context, resId: Int): String {



            val mInputStream: InputStream = context.resources.openRawResource(resId)
            val mBufferedReader = BufferedReader(InputStreamReader(mInputStream))
            val mStringBuilder = StringBuilder()
            var mText: String?
            while (mBufferedReader.readLine().also { mText = it } != null ) {
                    mStringBuilder.append(mText)
                    mStringBuilder.append("\n")
            }

            return mStringBuilder.toString()

        }


        fun convert(context: Context) : Person {

            val rawId: Int = context.resources.getIdentifier("people_data_one_person", "raw", context.packageName)

            val jsonText: String = readText(context = context, rawId)


            val jsonRoot = JSONObject(jsonText)


            val _id = jsonRoot.getString("_id")
            Log.i("json", "_id = $_id")
            val name = jsonRoot.getString("name")
            Log.i("json", "name = $name")
            val gender = jsonRoot.getString("gender")
            Log.i("json", "gender = $gender")
            val about = jsonRoot.getString("about")
            Log.i("json", "about = $about")
            val picture = jsonRoot.getString("picture")
            Log.i("json", "picture = $picture")


            val jsonBirthDate = jsonRoot.getJSONObject("birth")
            val birthDate = jsonBirthDate.getString("date")
            Log.i("json", "birthDate = $birthDate")

            val jsonLocation = jsonBirthDate.getJSONObject("location")
            val birthLocationName = jsonLocation.getString("name")
            Log.i("json", "birthLocationName = $birthLocationName")
            val birthLocationLatitudeDate = jsonLocation.getDouble("latitude")
            Log.i("json", "birthLocationLatitudeDate = $birthLocationLatitudeDate")
            val birthLocationLongitude = jsonLocation.getDouble("longitude")
            Log.i("json", "birthLocationLongitude = $birthLocationLongitude")


            var deathDateObject : Date? = null


            try {
                val jsonDeath = jsonRoot.getJSONObject("death")
                Log.i("json", "jsonDeath = $jsonDeath")

                var deathDate = jsonDeath.getString("date")
                Log.i("json", "deathDate = $deathDate")

                val jsonDeathLocation = jsonDeath.getJSONObject("location")
                Log.i("json", "jsonDeathLocation = $jsonDeathLocation")

                val deathLocationName = jsonDeathLocation.getString("name")
                Log.i("json", "deathLocationName = $deathLocationName")

                val deathLocationLatitude = jsonDeathLocation.getDouble("latitude")
                Log.i("json", "deathLocationLatitude = $deathLocationLatitude")
                val deathLocationLongitude = jsonDeathLocation.getDouble("longitude")
                Log.i("json", "deathLocationLongitude = $deathLocationLongitude")

                deathDateObject = Date(date =  deathDate,
                    Location(
                        name = deathLocationName,
                        latitude =  deathLocationLatitude,
                        longitude =  deathLocationLongitude
                    )
                )

            }

            catch (e : Exception) {}




            return Person(_id = _id, name = name, gender = gender, about = about, picture = picture,
                birth = Date(date = birthDate,
                    location = Location(
                        name =  birthLocationName,
                        latitude = birthLocationLatitudeDate,
                        longitude = birthLocationLongitude
                    )
                ),
                death = deathDateObject
            )
        }


        fun readPersons(context: Context): String {
            val rawId: Int = context.resources.getIdentifier("people_data", "raw", context.packageName)

            val mInputStream: InputStream = context.resources.openRawResource(rawId)
            val mBufferedReader = BufferedReader(InputStreamReader(mInputStream))
            val mStringBuilder = StringBuilder()
            var mText: String?
            while (mBufferedReader.readLine().also { mText = it } != null ) {
                if (mText!!.trim() != "[" || mText!!.trim() != "[" ) {
                    if (mText!!.trim() == "{") {
                        mPersons.add(convertToPerson(mStringBuilder.toString()))
                        mStringBuilder.clear()
                    }
                    mStringBuilder.append(mText)
                    mStringBuilder.append("\n")
                }


                Log.i("jsong", "readed text from json = $mStringBuilder")


            }

            return mStringBuilder.toString()
        }

        private fun convertToPerson(personJsonText: String) : Person {


            val jsonRoot = JSONObject(personJsonText)


            val id = jsonRoot.getString("_id")
            Log.i("json", "_id = $id")
            val name = jsonRoot.getString("name")
            Log.i("json", "name = $name")
            val gender = jsonRoot.getString("gender")
            Log.i("json", "gender = $gender")
            val about = jsonRoot.getString("about")
            Log.i("json", "about = $about")
            val picture = jsonRoot.getString("picture")
            Log.i("json", "picture = $picture")


            val jsonBirthDate = jsonRoot.getJSONObject("birth")
            val birthDate = jsonBirthDate.getString("date")
            Log.i("json", "birthDate = $birthDate")

            val jsonLocation = jsonBirthDate.getJSONObject("location")
            val birthLocationName = jsonLocation.getString("name")
            Log.i("json", "birthLocationName = $birthLocationName")
            val birthLocationLatitudeDate = jsonLocation.getDouble("latitude")
            Log.i("json", "birthLocationLatitudeDate = $birthLocationLatitudeDate")
            val birthLocationLongitude = jsonLocation.getDouble("longitude")
            Log.i("json", "birthLocationLongitude = $birthLocationLongitude")


            var deathDateObject : Date? = null


            try {
                val jsonDeath = jsonRoot.getJSONObject("death")
                Log.i("json", "jsonDeath = $jsonDeath")

                var deathDate = jsonDeath.getString("date")
                Log.i("json", "deathDate = $deathDate")

                val jsonDeathLocation = jsonDeath.getJSONObject("location")
                Log.i("json", "jsonDeathLocation = $jsonDeathLocation")

                val deathLocationName = jsonDeathLocation.getString("name")
                Log.i("json", "deathLocationName = $deathLocationName")

                val deathLocationLatitude = jsonDeathLocation.getDouble("latitude")
                Log.i("json", "deathLocationLatitude = $deathLocationLatitude")
                val deathLocationLongitude = jsonDeathLocation.getDouble("longitude")
                Log.i("json", "deathLocationLongitude = $deathLocationLongitude")

                deathDateObject = Date(date =  deathDate,
                    Location(
                        name = deathLocationName,
                        latitude =  deathLocationLatitude,
                        longitude =  deathLocationLongitude
                    )
                )

            }

            catch (e : Exception) {}




            return Person(_id = id, name = name, gender = gender, about = about, picture = picture,
                birth = Date(date = birthDate,
                    location = Location(
                        name =  birthLocationName,
                        latitude = birthLocationLatitudeDate,
                        longitude = birthLocationLongitude
                    )
                ),
                death = deathDateObject)

        }
    }
}