package com.example.pertemuan11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pertemuan11.databinding.ActivityMainBinding
import com.example.pertemuan11.model.Data
import com.example.pertemuan11.model.Users
import com.example.pertemuan11.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var bitcoinAdapter: BitcoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvBitcoin.layoutManager = LinearLayoutManager(this@MainActivity)

        bitcoinAdapter = BitcoinAdapter(emptyList<Data>())
        binding.rvBitcoin.adapter = bitcoinAdapter

        val apiService = ApiClient.getInstance()

        apiService.getAllUser().enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) {
                    val modelHero = response.body()
                    val heroo = modelHero?.data ?: emptyList()
                    bitcoinAdapter.setDataHero(heroo)
                }
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error Connection",
                    Toast.LENGTH_LONG).show()
            }
        })
    }
}