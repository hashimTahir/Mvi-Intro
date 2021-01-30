/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.network.responses.lookupresponse


import com.google.gson.annotations.SerializedName

data class Syn(
    @SerializedName("asp")
    val asp: String,
    @SerializedName("gen")
    val gen: String,
    @SerializedName("pos")
    val pos: String,
    @SerializedName("text")
    val text: String
)