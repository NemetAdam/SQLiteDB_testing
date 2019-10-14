package com.example.sqlitedb_testing

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class ViewListContents: AppCompatActivity() {

    internal lateinit var myDB: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_hobbies)

        var list = this.findViewById<ListView>(R.id.listView)
        myDB = DBHelper(this)

        val theList = ArrayList<String?>()
        val data = myDB.getListContents()
        if (data.count === 0) {
            Toast.makeText(this, "There are no contents in this list!", Toast.LENGTH_LONG).show()
        } else {
            while (data.moveToNext()) {
              theList.add("Name: " + data.getString(1)+ "\nSurname: " + data.getString(2) + "\nInfo: " + data.getString(3) + "\nHobby: " +data.getString(4))
      //          theList.add(data.getString(1))
//               theList.add(data.getString(3))
//                theList.add(data.getString(4))
                val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, theList)
                list.adapter = listAdapter
                Toast.makeText(this, data.count.toString()+"ROWWWSSSSS", Toast.LENGTH_LONG).show()
            }
        }

    }
}