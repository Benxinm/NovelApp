package com.benxinm.novelapplication.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.benxinm.noevlapplication.R
import com.benxinm.novelapplication.bean.Book
import com.benxinm.novelapplication.bean.BookTransporter
import com.benxinm.novelapplication.data.dao.ContentDao
import com.benxinm.novelapplication.data.database.AppDatabase
import com.benxinm.novelapplication.data.entity.CollectionEntity
import com.benxinm.novelapplication.data.entity.ContentEntity
import com.benxinm.novelapplication.service.impl.ContentServiceImpl
import com.benxinm.novelapplication.utils.ParameterRecorder
import com.benxinm.novelapplication.utils.StatusCode
import com.hjq.toast.ToastUtils
import kotlinx.android.synthetic.main.activity_content.*
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class ContentActivity : AppCompatActivity() {

    var bid:String?=null
    var thisName:String?=null
    var coverRef:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)
        val contentDao=AppDatabase.getDatabase(this).contentDao()
        val book=intent.getParcelableExtra<BookTransporter>("book")
        setAllParameter(book!!)
        val bookId=bid
        val bookName=thisName
        if (bookId!=null&&bookName!=null){
            contentBookName.text=bookName
            if (check(bookId,contentDao)==StatusCode.RESULT_OK){
                contentBook.text=getContent(bookId,contentDao)
            }else{
                contentBook.text=ContentServiceImpl.getContent(bookId)
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater:MenuInflater=menuInflater
        inflater.inflate(R.menu.menu_content,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.download->{
                downloadContent()
                true
            }
            R.id.collection->{
                addCollection()
                true
            }
            else->super.onOptionsItemSelected(item)
        }
    }
    private fun downloadContent(){
        val contentDao=AppDatabase.getDatabase(this).contentDao()
        thread {
            if (contentDao.checkExist(bid!!)==1){
                ToastUtils.show("已经下载过了哦~")
            }else{
                val contentEntity=ContentEntity(bid!!,contentBook.text.toString())
                contentDao.download(contentEntity)
            }
        }
    }
    fun check(bookId:String, contentDao: ContentDao):Int {
        var tempCode=StatusCode.RESULT_FAIL
        lifecycleScope.launch {
            val count= contentDao.checkExist(bookId)
            if (count == 1) {
                tempCode=StatusCode.RESULT_OK
            }
        }
        return tempCode
    }
    fun getContent(bookId: String,  contentDao: ContentDao):String{
        var content:String?=null
        lifecycleScope.launch {
            content=contentDao.getContentById(bookId).content
        }
        return content!!
    }
    fun addCollection(){
        val collectionDao=AppDatabase.getDatabase(this).collectionDao()
        collectionDao.addCollections(CollectionEntity(ParameterRecorder.uid.toString(),bid!!,thisName!!,coverRef!!))
    }
    private fun setAllParameter(book: BookTransporter){
        bid=book.id
        thisName=book.name
        coverRef=book.coverRef
    }
}