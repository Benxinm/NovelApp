package com.benxinm.novelapplication.bean

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class User (val id:Int,val account:String,val psd:String): Parcelable {
}