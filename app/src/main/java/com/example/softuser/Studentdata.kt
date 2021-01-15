package com.example.softuser

import com.example.softuser.model.Student

class Studentdata private constructor(){
    var list=ArrayList<Student>()
    fun List():ArrayList<Student>{
        return list
    }

    companion object{
        private val data=Studentdata()
        fun get():Studentdata{
            return data
        }
    }
}