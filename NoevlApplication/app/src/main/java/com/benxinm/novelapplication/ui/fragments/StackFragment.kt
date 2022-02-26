package com.benxinm.novelapplication.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.benxinm.noevlapplication.R
import com.benxinm.novelapplication.bean.Book
import com.benxinm.novelapplication.bean.User
import com.benxinm.novelapplication.service.impl.BookServiceImpl
import com.benxinm.novelapplication.ui.adapters.BookStackAdapter
import kotlinx.android.synthetic.main.stack.*
import java.util.Locale.filter

class StackFragment: Fragment() {
    private var list = mutableListOf<Book>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.stack,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager=LinearLayoutManager(this.context)
        bookStack.layoutManager=layoutManager
        val bookList= BookServiceImpl.getAllBook()
        if (bookList!=null){
            bookStack.adapter=BookStackAdapter(bookList,this)
            list=bookList as MutableList<Book>
        }
        searchView.setOnQueryTextListener (object :SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(keyWord:String): Boolean {
                return false
            }
            override fun onQueryTextChange(keyWord:String): Boolean {
                val filterList= filter(keyWord)
                bookStack.adapter=BookStackAdapter(filterList,this@StackFragment)
                return false
            }
        })
    }
    private fun filter(keyWord: String): List<Book> {
        val filterList = mutableListOf<Book>()
        for (l in list) {
            for (word in keyWord.toCharArray()){
                if(l.name.toCharArray().contains(word)) {
                    filterList.add(l)
                    break
                }
            }
        }
        return filterList
    }
}