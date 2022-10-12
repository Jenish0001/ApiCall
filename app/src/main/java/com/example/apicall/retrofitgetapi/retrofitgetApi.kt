package com.example.apicall.retrofitgetapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apicall.R
import com.example.apicall.retrofitgetapi.apiclient.Companion.getRetrofit
import com.example.apicall.retrofitgetapi.apiclient.Companion.getRetrofitData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class retrofitgetApi : AppCompatActivity() {
    var list = listOf<ArticlesItem?>()
    var list1 = listOf<DataItem?>()
    lateinit var rvview: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofitget_api)
        rvview = findViewById<RecyclerView>(R.id.rvview)

//        getnews("us", "business")

        getnewsData()

    }

    private fun getnews(country: String, categry: String) {

        var apiInterface = getRetrofit().create(apiInterface::class.java)

        apiInterface.getnews(country, categry, "9e41272f5ec1439c9a0692b57ca606ba")
            .enqueue(object : Callback<Newsmodel> {
                override fun onResponse(call: Call<Newsmodel>, response: Response<Newsmodel>) {
                    Log.e("TAG", "onResponse: ${response.body()}")

                    var newsmodel = response.body()
                    list = newsmodel?.articles!!

                    setuprv()
                }


                override fun onFailure(call: Call<Newsmodel>, t: Throwable) {
                    Log.e("TAG", "onFailure: ${t.message}")
                }


            })


    }


    private fun getnewsData() {

        var apiInterface = getRetrofitData().create(apiInterface::class.java)

        apiInterface.getnewsdata("Nation", "Population")
            .enqueue(object : Callback<Data> {
                override fun onResponse(call: Call<Data>, response: Response<Data>) {
                    Log.e("TAG", "onResponse: ${response.body()}")

                    var newsmodeldata = response.body()
                    list1 = newsmodeldata!!.data!!

                    setuprv()
                }


                override fun onFailure(call: Call<Data>, t: Throwable) {
                    Log.e("TAG", "onFailure: ${t.message}")
                }


            })
    }

    private fun setuprv() {

        var myAdpter = AdpterRetrofitGet(this, list)
        var lm = LinearLayoutManager(this)
        rvview.adapter = myAdpter
        rvview.layoutManager = lm

    }

}