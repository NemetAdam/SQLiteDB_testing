package com.example.sqlitedb_testing

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VER) {
    companion object {
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "PERSHOBBY.db"

        private val TABLE_NAME = "Hobby"
        private val COL_1 = "ID"
        private val COL_2 = "Hobby"
    }
    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_TABLE_QUERY: String = ("CREATE TABLE $TABLE_NAME ( ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_2 TEXT )")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    fun addData(item1:String): Boolean{
        val db:SQLiteDatabase = this.writableDatabase
        val values = ContentValues()
        values.put(COL_2,item1)

        var result: Long = db.insert(TABLE_NAME,null,values)

        //db.execSQL("delete from "+ TABLE_NAME);

        return !result.equals(-1)


    }
    fun getListContents(): Cursor {
        val db = this.writableDatabase
        return db.rawQuery("SELECT * FROM $TABLE_NAME", null)
    }


    /*
    fun updateHobby(hobby:Hobby):Int{
        val db:SQLiteDatabase = this.writableDatabase
        val values = ContentValues()
        values.put(COL_HOBBY,hobby.hobby)

        return db.update(TABLE_NAME,values, "$COL_ID=?", arrayOf(hobby.id.toString()))

    }
*/
    /*
    fun deleteHobby(hobby:Hobby){
        val db:SQLiteDatabase = this.writableDatabase

        db.delete(TABLE_NAME, "$COL_ID=?", arrayOf(hobby.id.toString()))
        db.close()

    }
    */

}