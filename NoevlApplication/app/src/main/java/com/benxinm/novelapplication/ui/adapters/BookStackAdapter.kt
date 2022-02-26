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
import com.benxinm.novelapplication.bean.Book
import com.benxinm.novelapplication.bean.BookTransporter
import com.benxinm.novelapplication.ui.activities.ContentActivity
import com.bumptech.glide.Glide

class BookStackAdapter(val bookList: List<Book>,val stackFragment: Fragment):
    RecyclerView.Adapter<BookStackAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val bookCover:ImageView=view.findViewById(R.id.bookCover)
        val bookName:TextView=view.findViewById(R.id.bookName)
        val bookAuthor:TextView=view.findViewById(R.id.authorName)
        val remark:TextView=view.findViewById(R.id.remark)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.book_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book=bookList[position]
        val ref=book.coverRef
        Glide.with(stackFragment).load("http://benxinm.5gzvip.91tunnel.com/${ref}").into(holder.bookCover)
        holder.bookAuthor.text=book.author
        holder.remark.text=book.remark
        holder.bookName.text=book.name
        holder.itemView.setOnClickListener{
            val content=stackFragment.context
            val intent= Intent(content,ContentActivity::class.java)
            val bookTransporter=BookTransporter(book.id,book.name,book.coverRef)
            intent.putExtra("book",bookTransporter)
            content!!.startActivity(intent)
        }
    }
    override fun getItemCount()=bookList.size
}