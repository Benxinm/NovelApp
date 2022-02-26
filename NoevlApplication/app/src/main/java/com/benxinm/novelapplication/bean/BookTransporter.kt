package com.benxinm.novelapplication.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class BookTransporter(val id:String,val name:String,val coverRef:String): Parcelable {
}