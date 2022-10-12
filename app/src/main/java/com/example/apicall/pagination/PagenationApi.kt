package com.example.apicall.pagination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apicall.R
import com.example.apicall.retrofitgetapi.apiInterface
import com.example.apicall.retrofitgetapi.apiclient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PagenationApi : AppCompatActivity() {

    private var i: Int = 1
    private lateinit var rvview: RecyclerView
    var list = arrayListOf<PagenationModelItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pagenation_api)

        rvview = findViewById<RecyclerView>(R.id.rvview)


        rvview.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                Log.e("TAG", "onScrolled: ")
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val linearLayoutManager = rvview.layoutManager as LinearLayoutManager
                val pos = linearLayoutManager.findLastVisibleItemPosition()
                val num: Int = rvview.adapter!!.itemCount

                Log.e("TAG", "onScrolled: $pos")
                if (pos == num - 1) {
                    i++
                    apiPagenation("$i")
                }


            }
        })
        apiPagenation("$i")

        setrv(list)

    }

    private fun apiPagenation(s: String) {

        var apiInterface = apiclient.getRetrofitDataPagination().create(apiInterface::class.java)

        apiInterface.getnewsdataPaganation(s).enqueue(object :
            Callback<List<PagenationModelItem>> {
            override fun onResponse(
                call: Call<List<PagenationModelItem>>,
                response: Response<List<PagenationModelItem>>
            ) {
                list.addAll(response.body() as ArrayList<PagenationModelItem>)
                Log.e("TAG", "onResponse: $list")
                setrv(list)

            }

            override fun onFailure(call: Call<List<PagenationModelItem>>, t: Throwable) {

            }
        })

    }

    fun setrv(list: ArrayList<PagenationModelItem>) {

        var adpter = PagenationApiAdpter(this, list)
        var linearLayoutManager = LinearLayoutManager(this)
        rvview.adapter = adpter
        rvview.layoutManager = linearLayoutManager

    }

}