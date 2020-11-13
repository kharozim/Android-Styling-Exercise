package com.ozimos.android_styling_exercise.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ProductClient {

    const val BASE_URL = "https://fakestoreapi.com/"

    private val gson: Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    val service: ProductServices by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        retrofit.create(ProductServices::class.java)
    }


}
