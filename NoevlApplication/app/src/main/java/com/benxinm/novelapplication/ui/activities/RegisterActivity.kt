package com.benxinm.novelapplication.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.benxinm.noevlapplication.R
import com.benxinm.novelapplication.service.impl.UserServiceImpl
import com.benxinm.novelapplication.utils.StatusCode
import com.hjq.toast.ToastUtils
import kotlinx.android.synthetic.main.activity_register.*


class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        registerExecutor.setOnClickListener {
            val account=registerAccount.text.toString()
            val psd=registerPsd.text.toString()
            val psdRepeat=registerPsdRepeat.text.toString()
            if(psd==psdRepeat && UserServiceImpl.register(account,psd)== StatusCode.RESULT_FAIL){
                val intent=Intent()
                intent.putExtra("StatusCode", StatusCode.RESULT_OK)
                setResult(RESULT_OK,intent)
                finish()
            }else if(psd!=psdRepeat ){
                ToastUtils.show("两次输入的密码不同哦~")
            }else{
                ToastUtils.show("注册失败~")
            }
        }
    }
}