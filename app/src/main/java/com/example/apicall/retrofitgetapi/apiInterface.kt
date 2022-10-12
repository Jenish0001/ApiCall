package com.example.apicall.retrofitgetapi

import com.example.apicall.pagination.PagenationModel
import com.example.apicall.pagination.PagenationModelItem
import com.example.apicall.retrofitpostapi.Model
import com.example.apicall.retrofitpostapi.Product
import com.example.apicall.retrofitpostapi.ProductItem
import retrofit2.Call
import retrofit2.http.*

interface apiInterface {

    @GET("top-headlines")
    fun getnews(@Query("country") country:String,@Query("category") category:String,@Query("apikey") apiKey:String):Call<Newsmodel>


    @FormUrlEncoded
    @POST("users")
    fun postdata(@Field("name")name:String, @Field("job")job:String):Call<Model>


    @GET("products")
    fun postProductdata():Call<List<ProductItem>>

    @GET("data")
    fun getnewsdata(@Query("drilldowns") country:String,@Query("measures") category:String):Call<Data>


//    pagenation
    @GET("comments")
    fun getnewsdataPaganation(@Query("postId") postid:String):Call<List<PagenationModelItem>>


}
//https://datausa.io/api/data?drilldowns=Nation&measures=Population