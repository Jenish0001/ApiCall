package com.example.apicall.retrofitgetapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.apicall.R

class AdpterRetrofitGet(val retrofitgetApi: retrofitgetApi, val list: List<ArticlesItem?>) :
    RecyclerView.Adapter<AdpterRetrofitGet.viewData>() {

    class viewData(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var img_news = itemView.findViewById<CardView>(R.id.img_news)
        var img_newscv = itemView.findViewById<ImageView>(R.id.img_newscv)
        var txt_title = itemView.findViewById<TextView>(R.id.txt_title)
        var txt_title_name = itemView.findViewById<TextView>(R.id.txt_title_name)
        var txt_subtitle = itemView.findViewById<TextView>(R.id.txt_subtitle)
//        val layout: ShimmerLayout = itemView.findViewById(R.id.simmerEffact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewData {

        var view =
            LayoutInflater.from(retrofitgetApi).inflate(R.layout.retrofitgetitem, parent, false)
        return viewData(view)

    }

    override fun onBindViewHolder(holder: viewData, position: Int) {

        var img = list[position]?.urlToImage

        holder.txt_subtitle.text = list[position]?.description
        Glide.with(retrofitgetApi).load(img).centerCrop().into(holder.img_newscv)
        holder.txt_title.text = list[position]?.title
        holder.txt_title_name.text = list[position]?.source!!.name


    }

    override fun getItemCount(): Int {
        return list.size
    }

}
