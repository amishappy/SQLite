package com.example.sqlite.Adepter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import com.example.sqlite.Model.Person
import com.example.sqlite.R
import kotlinx.android.synthetic.main.row_layout.view.*

class ListPersonAdepter (internal var activity: Activity,
                         internal var lstPerson:List<Person>,
                         internal var edt_id:EditText,
                         internal var edt_name:EditText,
                         internal var edt_email:EditText):BaseAdapter() {

    internal var Inflater:LayoutInflater

    init {
        Inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, converView: View?, parent: ViewGroup?): View {
        val rowView:View
        rowView = Inflater.inflate(R.layout.row_layout,null)
        rowView.txt_row_id.text = lstPerson[position].id.toString()
        rowView.txt_name.text = lstPerson[position].name.toString()
        rowView.txt_email.text = lstPerson[position].email.toString()

        //Event
        rowView.setOnClickListener {
            edt_id.setText(rowView.txt_row_id.text.toString())
            edt_name.setText(rowView.txt_name.text.toString())
            edt_email.setText(rowView.txt_email.text.toString())
        }
        return rowView
    }

    override fun getItem(position: Int): Any {
        return lstPerson[position]
    }

    override fun getItemId(position: Int): Long {
        return lstPerson[position].id.toLong()
    }

    override fun getCount(): Int {
        return lstPerson.size
    }
}