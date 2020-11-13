package com.ozimos.android_styling_exercise.api

import retrofit2.Call
import retrofit2.http.GET

interface ProductServices {
    @GET("products")
    fun getAllProducts(): Call<List<ProductModel>>

}