package com.example.apicall.retrofitpostapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apicall.R

class AdpterItemPostRetrofit(
    val retrofitPostAPi: retrofitPostAPi,
    val list: ArrayList<ProductItem>?,
//    val m1: Double?
) :
    RecyclerView.Adapter<AdpterItemPostRetrofit.ViewData>() {
    class ViewData(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt1 = itemView.findViewById<TextView>(R.id.txt1)
        var des = itemView.findViewById<TextView>(R.id.des)
        var title = itemView.findViewById<TextView>(R.id.title)
        var id = itemView.findViewById<TextView>(R.id.id)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {

        var view =
            LayoutInflater.from(retrofitPostAPi).inflate(R.layout.postproductitem, parent, false)
        return ViewData(view)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {

        holder.txt1.text = list!![position].price.toString()
        holder.title.text = list!![position].description.toString()
        holder.des.text = list!![position].title.toString()
        holder.id.text = list!![position].id.toString()

    }

    override fun getItemCount(): Int {
        return list!!.size
    }
}