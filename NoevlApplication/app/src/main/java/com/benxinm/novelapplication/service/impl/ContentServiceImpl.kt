package com.benxinm.novelapplication.service.impl

import android.util.JsonReader
import com.benxinm.novelapplication.bean.Content
import com.benxinm.novelapplication.service.ContentService
import com.benxinm.novelapplication.utils.ServiceCreator
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object ContentServiceImpl {
    val contentService=ServiceCreator.create(ContentService::class.java)

    fun getContent(id:String):String?{
        var content:Content?=null
        val call= contentService.getContent(id)
        GlobalScope.launch {
            content=call.execute().body()
        }
        Thread.sleep(2000)
        return content?.tx
    }
}