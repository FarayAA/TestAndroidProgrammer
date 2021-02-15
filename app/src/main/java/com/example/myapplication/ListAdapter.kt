package com.example.myapplication

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.ResponseList
import retrofit2.Callback

class ListAdapter (private val produkList: List<ResponseList>): RecyclerView.Adapter<ListAdapter.MyHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListAdapter.MyHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_produk,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: ListAdapter.MyHolder, position: Int) {
        Log.d("Response","List Count :${produkList.size} ")
        return holder.bind(produkList[position])
    }

    class MyHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var tTitle = itemView.findViewById<TextView>(R.id.title)
        fun bind(produk: ResponseList){
            tTitle.text = produk.title
        }

    }

    override fun getItemCount(): Int {
        return produkList.size
    }

}