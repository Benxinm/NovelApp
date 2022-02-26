package com.benxinm.novelapplication.service.impl

import android.util.Log
import com.benxinm.novelapplication.bean.User
import com.benxinm.novelapplication.service.UserService
import com.benxinm.novelapplication.utils.ServiceCreator
import com.benxinm.novelapplication.utils.StatusCode
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback

object UserServiceImpl {

    val userService= ServiceCreator.create(UserService::class.java)

    fun register(account:String,psd:String):Int{
        var code= StatusCode.RESULT_FAIL
        userService.registerUser(account,psd).enqueue(object :Callback<Int>{
            override fun onResponse(call: Call<Int>, response: Response<Int>){
                code=response.code()
                Log.d("StatusCode",code.toString())
            }
            override fun onFailure(call: Call<Int>, t: Throwable) {
                t.printStackTrace()
            }
        })
        return code
    }
    fun login(account: String,psd: String): User? {
        var user: User?=null
        val call= userService.login(account,psd)
        GlobalScope.launch {
            val userMap=call.execute().body()
            val gson=Gson()
            if (userMap!=null){
                val keys= userMap.keys
                for (key in keys){
                    if (key== StatusCode.RESULT_OK){
                        user=gson.fromJson(userMap.get(key), User::class.java)
                    }
                }
            }
        }
        Thread.sleep(500)
        return user
    }
}


