package com.example.sqlitedb_testing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T





class MainActivity : AppCompatActivity() {

    internal lateinit var myDB: DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myDB = DBHelper(this);
        buttonAdd.setOnClickListener(){
            val newName:String = editTextFirstName.text.toString()
            val newSecondName:String = editTextSecondName.text.toString()
            val info:String = editText4.text.toString()
            val newHobby = editText.text.toString()
            if (editText.length() !== 0) {
                AddData(newName,newSecondName,info,newHobby)
                editText.setText("")
            } else {
                Toast.makeText(
                    this@MainActivity,
                    "You must put something in the text field!",
                    Toast.LENGTH_LONG
                ).show()
            }
        }


        buttonView.setOnClickListener(){
            val intent = Intent(this, ViewListContents::class.java)
            startActivity(intent)
        }


    }

    fun AddData(newEntry1: String,newEntry2: String,newEntry3: String,newEntry4: String) {

        val insertData = myDB.addData(newEntry1,newEntry2,newEntry3,newEntry4)

        if (insertData == true) {
            Toast.makeText(this, "Data Successfully Inserted!", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Something went wrong :(.", Toast.LENGTH_LONG).show()
        }
    }
}
