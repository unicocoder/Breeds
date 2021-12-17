package com.unicocoder.breeds

import com.google.gson.annotations.SerializedName

data class DogResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
