package com.example.apicall.retrofitpostapi

import com.google.gson.annotations.SerializedName

data class Product(

	@field:SerializedName("Product")
	val product: List<ProductItem?>? = null
)

data class Rating(

	@field:SerializedName("rate")
	val rate: Double? = null,

	@field:SerializedName("count")
	val count: Int? = null
)

data class ProductItem(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("price")
	val price: Double? = null,

	@field:SerializedName("rating")
	val rating: Rating? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("category")
	val category: String? = null
)
