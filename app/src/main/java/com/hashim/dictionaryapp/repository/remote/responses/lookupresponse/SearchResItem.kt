/*
 * Copyright (c) 2021/  2/ 5.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.repository.remote.responses.lookupresponse


import com.google.gson.annotations.SerializedName

data class SearchResItem(
    @SerializedName("def")
    val def: List<Def>,
    @SerializedName("et")
    val et: List<List<String>>,
    @SerializedName("fl")
    val fl: String,
    @SerializedName("hwi")
    val hwi: Hwi,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("shortdef")
    val shortdef: List<String>
)