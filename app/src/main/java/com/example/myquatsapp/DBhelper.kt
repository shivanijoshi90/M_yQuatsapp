package com.example.myquatsapp

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBhelper(context: Context): SQLiteOpenHelper(context,"Quotes",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {

         val query = "CREATE TABLE Quotes(id INTEGER PRIMARY KEY AUTOINCREMENT,Quotespi TEXT)"

        db!!.apply {
          execSQL(query)

        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
    fun addQuotes(modal: model_class){
        val db = readableDatabase
        val cn = ContentValues()

        cn.put("quotes",modal.quotes)


        db.insert("Quotes",null,cn)
    }
    @SuppressLint("Range")
    fun getQuotes():ArrayList<model_class>{
        var db = readableDatabase
        var query = "SELECT * FROM Quotes"
        var cursor = db.rawQuery(query,null)
        var detail = ArrayList<model_class>()
        if (cursor.moveToFirst()){
            do {
                var id = cursor.getString(cursor.getColumnIndex("id"))
                var quotes= cursor.getString(cursor.getColumnIndex("quotes"))

                var model = model_class(quotes,0,false)
                detail.add(model)
            }while (cursor.moveToNext())
        }
        return detail
    }



}