package com.example.apicall.pagination

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apicall.R
import com.example.apicall.retrofitgetapi.AdpterRetrofitGet
import com.example.apicall.retrofitpostapi.ProductItem

class PagenationApiAdpter(val pagenationApi: PagenationApi, val list: ArrayList<PagenationModelItem>) :
    RecyclerView.Adapter<PagenationApiAdpter.viewData>() {

    class viewData(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtview = itemView.findViewById<TextView>(R.id.txtview)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewData {
        var view =
            LayoutInflater.from(pagenationApi).inflate(R.layout.pagenationitemview, parent, false)
        return viewData(view)
    }

    override fun onBindViewHolder(holder: viewData, position: Int) {

        holder.txtview.setText(list[position].id.toString())

    }

    override fun getItemCount(): Int {
        return list.size
    }


}
