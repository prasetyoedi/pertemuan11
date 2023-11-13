package com.example.pertemuan11.model

import com.google.gson.annotations.SerializedName

data class Data(
//    harus ada ketika mau menggunakan API
    @SerializedName("id")
    val bitcoinId:Int,
    @SerializedName("accountcode")
    val bitcoinCode:String,
    @SerializedName("accountname")
    val bitcoinName:String,
    @SerializedName("logo")
    val bitcoinLogo:String
)
