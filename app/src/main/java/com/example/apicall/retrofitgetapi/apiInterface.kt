package com.example.apicall.retrofitgetapi


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface apiInterface {

    @GET("top-headlines")
    fun getnews(@Query("country") country:String,@Query("category") category:String,@Query("apikey") apiKey:String):Call<Newsmodel>


}