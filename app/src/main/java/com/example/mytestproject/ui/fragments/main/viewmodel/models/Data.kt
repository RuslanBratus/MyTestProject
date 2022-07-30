package com.example.mytestproject.ui.fragments.main.viewmodel.models

import java.lang.StringBuilder


//@TODO Change date String to date type
data class Date(val date : String,
                val location: Location){
    @Override
    override fun toString(): String {
        val mStringBuilder = StringBuilder()
        mStringBuilder.append("\n date:" + this.date)
        mStringBuilder.append("\n location: {" + this.date)
        mStringBuilder.append("\n }")
        return mStringBuilder.toString()
    }
}

data class Location (var name : String,
                     var latitude : Double,
                     var longitude : Double){
    @Override
    override fun toString(): String {
        val mStringBuilder = StringBuilder()
        mStringBuilder.append("\n name:" + this.name)
        mStringBuilder.append("\n latitude:" + this.latitude)
        mStringBuilder.append("\n longitude:" + this.longitude)

        return mStringBuilder.toString()
    }
}


//@TODO Change gender String to enum/static value/const value from array type
data class Person(val _id : String,
                  var name : String,
                  var gender : String,
                  var about : String,
                  var picture : String,
                  val birth : Date,
                  var death : Date? = null) {

    @Override
    override fun toString(): String {
        val mStringBuilder = StringBuilder()
        mStringBuilder.append("{")
        mStringBuilder.append("\n _id:" + this._id)
        mStringBuilder.append(",\n name:" + this.name)
        mStringBuilder.append(",\n gender:" + this.gender)
        mStringBuilder.append(",\n about:" + this.about)
        mStringBuilder.append(",\n picture:" + this.picture)
        mStringBuilder.append(",\n birth: {" + this.birth)
        mStringBuilder.append(",\n }")
        if (this.death != null) {
            mStringBuilder.append(",\n death: {" + this.death)
            mStringBuilder.append(",\n }")
        }
        mStringBuilder.append("}")

        return mStringBuilder.toString()
    }
}

//{
//    "_id": "60c8a1328398946bdbdfda20",
//    "name": "Berger Hebert",
//    "gender": "male",
//    "about": "Minim culpa veniam amet cillum. Laboris sint dolor ullamco exercitation occaecat esse laboris voluptate voluptate ut sint veniam reprehenderit. Commodo anim exercitation commodo in enim fugiat cillum enim officia id officia dolor. Commodo dolore do nulla quis voluptate reprehenderit.\r\n",
//    "picture": "",
//    "birth": {
//    "date": "1953-03-07T01:04:08 -02:00",
//    "location": {
//    "name": "Azerbaijan, Needmore",
//    "latitude": 36.773748,
//    "longitude": -36.690845
//},
//    "death": {
//    "date": "2010-08-04T12:03:25 -03:00",
//    "location": {
//    "name": "Czech Republic, Lemoyne",
//    "latitude": -80.25033,
//    "longitude": -106.165028
//}
//}
//}
//},
