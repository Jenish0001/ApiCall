package com.example.apicall.retrofitpostapi

import com.google.gson.annotations.SerializedName

data class Model(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("email")
	val email: String? = null

)
