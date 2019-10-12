package com.example.sqlitedb_testing

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VER) {
    companion object {
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "PERSHOBBY.db"

        private val TABLE_NAME = "Hobby"
        private val COL_HOBBY = "Hobby"
    }
    override fun onCreate(db: SQLiteDatabase?) {

        val CREATE_TABLE_QUERY: String = ("CREATE TABLE $TABLE_NAME ( $COL_HOBBY TEXT )")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    val AllHobby:List<Hobby>
    get(){

        val firstHobby = ArrayList<Hobby>()
        val selectQuerry = "SELECT * FROM $TABLE_NAME"
        val db:SQLiteDatabase = this.writableDatabase
        //db.execSQL("delete from "+ TABLE_NAME);
        val cursor = db.rawQuery(selectQuerry,null)
        cursor.moveToFirst();
        while(!cursor.isAfterLast()) {
            val person = Hobby()
            person.hobby = cursor.getString(cursor.getColumnIndex(COL_HOBBY))
            firstHobby.add(person)
            cursor.moveToNext()
        }
        db.close()
            return firstHobby
    }

    fun addHobby(hobby:Hobby){
        val db:SQLiteDatabase = this.writableDatabase
        val values = ContentValues()
        values.put(COL_HOBBY,hobby.hobby)

        db.insert(TABLE_NAME,null,values)
        db.close()
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