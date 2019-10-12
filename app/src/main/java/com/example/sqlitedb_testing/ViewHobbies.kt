package com.example.sqlitedb_testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class ViewHobbies : AppCompatActivity() {

    internal lateinit var db: DBHelper
    internal var firstHobby:List<Hobby> = ArrayList<Hobby>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_hobbies)

        db = DBHelper(context = this)
        refreshData()

    }

    private fun refreshData() {
        firstHobby = db.AllHobby
        val adapter = ListHobbyAdapter(this,firstHobby,editText)
        list_hobbies.adapter = adapter

    }
}
