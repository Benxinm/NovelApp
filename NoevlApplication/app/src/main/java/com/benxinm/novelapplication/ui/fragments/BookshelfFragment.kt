package com.benxinm.novelapplication.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.benxinm.noevlapplication.R
import com.benxinm.novelapplication.data.database.AppDatabase
import com.benxinm.novelapplication.data.entity.CollectionEntity
import com.benxinm.novelapplication.ui.adapters.ShelfAdapter
import com.benxinm.novelapplication.utils.ParameterRecorder
import kotlinx.android.synthetic.main.bookshelf.*
import kotlinx.android.synthetic.main.stack.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BookshelfFragment:Fragment() {
    private var list = listOf<CollectionEntity>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.bookshelf,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager= LinearLayoutManager(this.context)
        shelfRecycler.layoutManager=layoutManager
        val collectionDao=AppDatabase.getDatabase(this.context!!).collectionDao()
        if (ParameterRecorder.uid!=-1){
            runBlocking {
                launch {
                    list=collectionDao.getAllCollections(ParameterRecorder.uid.toString())
                }
            }
        }
        shelfRecycler.adapter= ShelfAdapter(list,this)
    }
}