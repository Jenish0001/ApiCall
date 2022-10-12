package com.example.apicall.volleypostapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.apicall.R

class volleypostApi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_volleypost_api)

        volleypost("varsal", "sotware")
    }

    private fun volleypost(name: String, job: String) {
        var api = "https://reqres.in/api/users"
        var stringRequset = object : StringRequest(Method.POST, api, { res ->
            Log.e("TAG", "volleypost: $res")
        },
            { error ->
                Log.e("TAG", "volleypost: $error")
            }) {
            override fun getParams(): MutableMap<String, String>? {

                var map = HashMap<String, String>()
                map.put("name", name)
                map.put("job", job)

                return map

            }
        }
        var requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequset)

    }
}