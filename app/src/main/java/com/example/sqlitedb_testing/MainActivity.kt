package com.example.sqlitedb_testing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    internal lateinit var db: DBHelper
    internal var firstHobby:List<Hobby> = ArrayList<Hobby>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = DBHelper(context = this)
        refreshData()

        buttonAdd.setOnClickListener(){
            val hobby = Hobby(editText.text.toString())
            db.addHobby(hobby)
            refreshData()
        }

        /*
        buttonView.setOnClickListener(){
            val intent = Intent(this, ViewHobbies::class.java)
            startActivity(intent)
        }

         */
    }

    private fun refreshData() {
        firstHobby = db.AllHobby
        val adapter = ListHobbyAdapter(this,firstHobby,editText)
        list_hobbies.adapter = adapter

    }
}
