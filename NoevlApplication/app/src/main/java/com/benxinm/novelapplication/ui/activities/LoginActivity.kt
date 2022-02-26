package com.benxinm.novelapplication.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.benxinm.noevlapplication.R
import com.benxinm.novelapplication.service.impl.UserServiceImpl
import com.benxinm.novelapplication.utils.ParameterRecorder
import com.benxinm.novelapplication.utils.StatusCode
import com.hjq.toast.ToastUtils
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    companion object{
        private var thisUid:Int?=null
        private var ifChecked=false
        private var thisAccount:String?=null
        private var thisPsd:String?=null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        if (ifChecked){
            rememberUser.isChecked=true
            loginAc.setText(thisAccount)
            loginPsd.setText(thisPsd)
        }
        registerIn.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivityForResult(intent,1)
        }
        login.setOnClickListener {
            val ac= loginAc.text.toString()
            val psd=loginPsd.text.toString()
            val user= UserServiceImpl.login(ac,psd)
            thisUid=user?.id
            if (user==null) {
                ToastUtils.show("登录失败")
            }else{
                ToastUtils.show("登录成功")
                ParameterRecorder.uid=user.id
                if(rememberUser.isChecked){
                    ifChecked=true
                    thisAccount=user.account
                    thisPsd=psd
                }else{
                    ifChecked=false
                }
                val intent=Intent()
                intent.putExtra("user_return",user)
                setResult(RESULT_OK,intent)
                finish()
            }
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode){
            1->if (resultCode== RESULT_OK){
                val code=data?.getIntExtra("StatusCode", StatusCode.RESULT_FAIL)
                if (code== StatusCode.RESULT_OK){
                    ToastUtils.show("注册成功！请登录")
                }else{
                    ToastUtils.show("注册失败！请重新注册")
                }
            }
        }
    }
}