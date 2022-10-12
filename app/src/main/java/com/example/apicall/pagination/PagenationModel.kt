package com.example.apicall.pagination

import com.google.gson.annotations.SerializedName

data class PagenationModel(

	@field:SerializedName("PagenationModel")
	val pagenationModel: List<PagenationModelItem?>? = null
)

data class PagenationModelItem(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("postId")
	val postId: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
