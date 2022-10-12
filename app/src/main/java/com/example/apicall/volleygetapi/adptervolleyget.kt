package com.example.apicall.volleygetapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apicall.R
import java.util.ArrayList

class adptervolleyget(val volleygetapi: volleygetapi, val list: ArrayList<volleyget>) :
    RecyclerView.Adapter<adptervolleyget.viewData>() {

    class viewData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var f_userID = itemView.findViewById<TextView>(R.id.f_userID)
        var f_id = itemView.findViewById<TextView>(R.id.f_id)
        var f_title = itemView.findViewById<TextView>(R.id.f_title)
        var f_body = itemView.findViewById<TextView>(R.id.f_body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewData {

        var view = LayoutInflater.from(volleygetapi).inflate(R.layout.itemvollyget, parent, false)
        return viewData(view)
    }

    override fun onBindViewHolder(holder: viewData, position: Int) {
        holder.f_userID.text = list[position].userId
        holder.f_id.text = list[position].id
        holder.f_title.text = list[position].title
        holder.f_body.text = list[position].body

    }

    override fun getItemCount(): Int {
        return list.size

    }

}