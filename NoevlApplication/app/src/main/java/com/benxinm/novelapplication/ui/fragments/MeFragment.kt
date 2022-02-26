package com.benxinm.novelapplication.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

import com.benxinm.novelapplication.bean.User
import com.benxinm.novelapplication.ui.activities.LoginActivity
import kotlinx.android.synthetic.main.me.*


class MeFragment: Fragment() {
    companion object{
        private var thisAccount:String?=null
        private var thisUid:String?=null
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(com.benxinm.noevlapplication.R.layout.me,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (thisAccount!=null&&thisUid!=null){
            uid.text="uid:${thisUid}"
            account.text="用户名:${thisAccount}"
        }
        loginOrRegister.setOnClickListener {
            val intent=Intent(this.context, LoginActivity::class.java)
            this.startActivityForResult(intent,2)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            2->if(resultCode== AppCompatActivity.RESULT_OK){
                val returnedUser=data?.getParcelableExtra<User>("user_return")
                if (returnedUser!=null){
                    thisUid=returnedUser.id.toString()
                    thisAccount=returnedUser.account
                    uid.text="uid:${thisUid}"
                    account.text="用户名:${thisAccount}"
                }
            }
        }
    }
}