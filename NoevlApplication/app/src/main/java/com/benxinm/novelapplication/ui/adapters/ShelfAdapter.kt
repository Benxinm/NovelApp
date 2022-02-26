package com.benxinm.novelapplication.ui.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.benxinm.noevlapplication.R
import com.benxinm.novelapplication.bean.BookTransporter
import com.benxinm.novelapplication.data.entity.CollectionEntity
import com.benxinm.novelapplication.ui.activities.ContentActivity
import com.bumptech.glide.Glide

class ShelfAdapter(val collectionList: List<CollectionEntity>,val shelfFragment: Fragment):
    RecyclerView.Adapter<ShelfAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val bookCover:ImageView=view.findViewById(R.id.shelf_bookCover)
        val bookName:TextView=view.findViewById(R.id.shelf_bookName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.shelf_item,parent,false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val collection=collectionList[position]
        val ref=collection.coverRef
        Glide.with(shelfFragment).load("http://benxinm.5gzvip.91tunnel.com/${ref}").into(holder.bookCover)
        holder.bookName.text=collection.name
        holder.itemView.setOnClickListener {
            val content=shelfFragment.context
            val intent= Intent(content,ContentActivity::class.java)
            val bookTransporter= BookTransporter(collection.bid,collection.name,collection.coverRef)
            intent.putExtra("book",bookTransporter)
            content!!.startActivity(intent)
        }
    }
    override fun getItemCount(): Int=collectionList.size
}