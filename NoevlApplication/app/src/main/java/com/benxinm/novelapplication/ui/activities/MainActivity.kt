package com.benxinm.novelapplication.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.benxinm.noevlapplication.R
import com.benxinm.novelapplication.bean.User
import com.benxinm.novelapplication.data.database.AppDatabase
import com.benxinm.novelapplication.ui.fragments.BookshelfFragment
import com.benxinm.novelapplication.ui.fragments.MainFragment
import com.benxinm.novelapplication.ui.fragments.MeFragment
import com.benxinm.novelapplication.ui.fragments.StackFragment
import com.hjq.toast.ToastUtils
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.me.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ToastUtils.init(this.application)
        ToastUtils.setGravity(600)
        val icon1: RelativeLayout =icon1
        val icon2:RelativeLayout=icon2
        val icon3:RelativeLayout=icon3
        val image1: ImageView =iconimage1
        val image2:ImageView=iconimage2
        val image3:ImageView=iconimage3
        replaceFragment(MainFragment())
        icon1.setOnClickListener{
            image1.setImageResource(R.drawable.bookshelf_bottom_selected)
            image2.setImageResource(R.drawable.stack_bottom_normal)
            image3.setImageResource(R.drawable.me_bottom_normal)
            replaceFragment(BookshelfFragment())
        }
        icon2.setOnClickListener{
            image1.setImageResource(R.drawable.bookshelf_bottom_normal)
            image2.setImageResource(R.drawable.stack_bottom_selected)
            image3.setImageResource(R.drawable.me_bottom_normal)
            replaceFragment(StackFragment())
        }

        icon3.setOnClickListener{
            image1.setImageResource(R.drawable.bookshelf_bottom_normal)
            image2.setImageResource(R.drawable.stack_bottom_normal)
            image3.setImageResource(R.drawable.me_bottom_selected)
            replaceFragment(MeFragment())
        }
    }
    private fun replaceFragment(fragment: Fragment){
        val fragmentManager=supportFragmentManager
        val transaction=fragmentManager.beginTransaction()
        transaction.replace(R.id.frag,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}