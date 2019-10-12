package com.example.sqlitedb_testing

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import kotlinx.android.synthetic.main.row_layout.view.*

class ListHobbyAdapter(internal var activity:Activity,
                       internal var firstHobby:List<Hobby>,

                       internal var edit_hobby:EditText):BaseAdapter() {

    internal var inflater:LayoutInflater

    init{
        inflater=activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView:View
        rowView = inflater.inflate(R.layout.row_layout,null)

        rowView.textRowHobby.text = firstHobby[position].hobby
        return rowView
    }

    override fun getItem(position: Int): Any {
        return firstHobby[position]
    }

    override fun getItemId(position: Int): Long {
        return firstHobby[position].hobby!!.toLong()
    }

    override fun getCount(): Int {
        return firstHobby.size
    }
}