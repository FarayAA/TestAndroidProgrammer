package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.ResponseList
import com.example.myapplication.network.ApiCall
import com.example.myapplication.network.ApiInterface
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    
    private var adapter: ListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadGson()
    }

    private fun loadGson() {
        var apiInterface: ApiInterface = ApiCall.buildService(ApiInterface::class.java)
        var call = apiInterface.getlist()
        call.enqueue(object : Callback<List<ResponseList>>{
            override fun onResponse(
                call: Call<List<ResponseList>>,
                response: Response<List<ResponseList>>)
            {
                Log.d("Response","onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val listproduk = response.body()!!
                    Log.d("Response","listproduk size : ${listproduk.size}")
                    val recyclerContacts = findViewById(R.id.rv_list) as RecyclerView
                    recyclerContacts.adapter = adapter
                    recyclerContacts.layoutManager = LinearLayoutManager(this@MainActivity)
                }else{
                    Toast.makeText(this@MainActivity,"Gagal ${response.message()}",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ResponseList>>, t: Throwable?) {
                Toast.makeText(this@MainActivity,"Gagal $t",Toast.LENGTH_SHORT).show()
            }

        })
    }

}