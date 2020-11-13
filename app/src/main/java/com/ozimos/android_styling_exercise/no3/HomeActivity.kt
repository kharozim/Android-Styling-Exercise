package com.ozimos.android_styling_exercise.no3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ozimos.android_styling_exercise.adapter.ProductAdapter
import com.ozimos.android_styling_exercise.api.ProductClient
import com.ozimos.android_styling_exercise.api.ProductModel
import com.ozimos.android_styling_exercise.databinding.ActivityHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }
    private val adapter by lazy { ProductAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvProduct.adapter = adapter

        ProductClient.service.getAllProducts().enqueue(object : Callback<List<ProductModel>> {
            override fun onResponse(
                call: Call<List<ProductModel>>,
                response: Response<List<ProductModel>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let { adapter.setData(it) }
                } else {
                    Toast.makeText(this@HomeActivity, response.message(), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ProductModel>>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(this@HomeActivity, t.message, Toast.LENGTH_SHORT).show()

            }

        })
    }
}