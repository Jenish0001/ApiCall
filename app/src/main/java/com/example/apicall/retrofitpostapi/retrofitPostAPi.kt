package com.example.apicall.retrofitpostapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apicall.R
import com.example.apicall.retrofitgetapi.apiInterface
import com.example.apicall.retrofitgetapi.apiclient.Companion.postRetrofit
import com.example.apicall.retrofitgetapi.apiclient.Companion.postRetrofitProduct
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class retrofitPostAPi : AppCompatActivity() {

    lateinit var twoButton: Button
    var list = arrayListOf<ProductItem>()
    var listfil = arrayListOf<ProductItem>()
    lateinit var rvviewpostretrofit: RecyclerView
    lateinit var oneButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_post_api)

        rvviewpostretrofit = findViewById<RecyclerView>(R.id.rvviewpostretrofit)
        oneButton = findViewById<Button>(R.id.oneButton)
        twoButton = findViewById<Button>(R.id.twoButton)

        productapicalling()

        oneButton.setOnClickListener {
            filterone(0.000,100.000)
        }
        twoButton.setOnClickListener {
            filterone(100.00,200.000)
        }


//        creatuserApipost("jenish@gmail.com", "dobariya")


    }

    private fun filterone(d: Double, d1: Double) {

        var i = 0
        Log.e("TAG", "filterone: $list")

        while (i < list.size) {
            var price = list[i].price!!.toDouble()

            if (price >= d && price <= d1) {
                listfil.add(list[i])
            }
            i++
        }
        setuprv(listfil)

    }


    fun creatuserApipost(email: String, password: String) {

        var apiInterface = postRetrofit().create(apiInterface::class.java)
        apiInterface.postdata(email, password).enqueue(object : Callback<Model> {
            override fun onResponse(
                call: Call<Model>,
                response: Response<Model>
            ) {
                Toast.makeText(this@retrofitPostAPi, "${response.body()}", Toast.LENGTH_SHORT)
                    .show()
                Log.e("TAG", "onResponse: ${response.body()}")
            }

            override fun onFailure(call: Call<Model>, t: Throwable) {
                Log.e("TAG", "onFailure: ${t.message}")
            }
        })
    }

    fun productapicalling() {


        var apiInterface = postRetrofitProduct().create(apiInterface::class.java)
        apiInterface.postProductdata().enqueue(object : Callback<List<ProductItem>> {
            override fun onResponse(
                call: Call<List<ProductItem>>,
                response: Response<List<ProductItem>>
            ) {
                list = response.body() as ArrayList<ProductItem>
//                var p=
                Log.e("TAG", "onResponse: ${list.get(0).price}")
                setuprv(list)
            }

            override fun onFailure(call: Call<List<ProductItem>>, t: Throwable) {


                Log.e("TAG", "onResponse: ${t.message}")

            }
        })


    }

    private fun setuprv(list: ArrayList<ProductItem>?) {

        var adpter = AdpterItemPostRetrofit(this, list)
        var liner = LinearLayoutManager(this)
        rvviewpostretrofit.adapter = adpter
        rvviewpostretrofit.layoutManager = liner


    }

}
