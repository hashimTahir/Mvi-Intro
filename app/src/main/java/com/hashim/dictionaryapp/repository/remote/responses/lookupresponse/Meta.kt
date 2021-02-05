/*
 * Copyright (c) 2021/  2/ 5.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.repository.remote.responses.lookupresponse


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("id")
    val id: String,
    @SerializedName("offensive")
    val offensive: Boolean,
    @SerializedName("section")
    val section: String,
    @SerializedName("src")
    val src: String,
    @SerializedName("stems")
    val stems: List<String>,
    @SerializedName("uuid")
    val uuid: String
)