package com.example.apicall.volleygetapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.apicall.R
import java.util.ArrayList

class volleygetapi : AppCompatActivity() {
    lateinit var rvview: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volleygetapi)

        volleyapiget()

        blinding()
    }

    private fun blinding() {


        rvview = findViewById<RecyclerView>(R.id.rvview)
    }

    private fun volleyapiget() {

        var getapi = "https://jsonplaceholder.typicode.com/posts"
        var jsonArrayRequest = JsonArrayRequest(Request.Method.GET, getapi, null,
            { response ->
            Log.e("TAG", "volleyapiget: $response")
            var i = 0;
            var list = arrayListOf<volleyget>()

            while (i < response.length()) {
                var userId = response.getJSONObject(i).getString("userId")
                var id = response.getJSONObject(i).getString("id")
                var title = response.getJSONObject(i).getString("title")
                var body = response.getJSONObject(i).getString("body")

                var m1 = volleyget(userId, id, title, body)
                list.add(m1)
                i++
            }
            setuprv(list)
        }, { error ->
            Log.e("TAG", "volleyapiget: ${error}")
        })
        var requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(jsonArrayRequest)

    }

    private fun setuprv(list: ArrayList<volleyget>) {

        var adpter = adptervolleyget(this, list)
        var layout = LinearLayoutManager(this)
        rvview.adapter = adpter
        rvview.layoutManager = layout


    }


}
