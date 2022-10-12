package com.example.apicall.retrofitgetapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class apiclient {

    companion object {

        var BASE_URL = "https://newsapi.org/v2/"

        fun getRetrofit(): Retrofit {

            var retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit

        }

        var BASE_API="https://reqres.in/api/"
        fun postRetrofit() :Retrofit
        {
            var retrofit =Retrofit.Builder().baseUrl(BASE_API).addConverterFactory(GsonConverterFactory.create()).build()
            return  retrofit
        }

        var BASE_APIP="https://fakestoreapi.com/"
        fun postRetrofitProduct() :Retrofit
        {

            var retrofit =Retrofit.Builder().baseUrl(BASE_APIP).addConverterFactory(GsonConverterFactory.create()).build()
            return  retrofit

        }

        var BASE_URLDATA = "https://datausa.io/api/"

        fun getRetrofitData(): Retrofit {

            var retrofit = Retrofit.Builder()
                .baseUrl(BASE_URLDATA)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }


//         pagination api
        var BASE_URLDATAPAGE = "https://jsonplaceholder.typicode.com/"

        fun getRetrofitDataPagination(): Retrofit {

            var retrofit = Retrofit.Builder()
                .baseUrl(BASE_URLDATAPAGE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit
        }


    }
}
// website link ===========================
//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9e4127noX9aiLCw6QqH7sL2whiwSP8rVwo24a
//token numbe===================
//9e4127noX9aiLCw6QqH7sL2whiwSP8rVwo24a