/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.repository.remote.responses.lookupresponse


import com.google.gson.annotations.SerializedName

data class Def(
    @SerializedName("pos")
    val pos: String,
    @SerializedName("text")
    val text: String,
    @SerializedName("tr")
    val tr: List<Tr>,
    @SerializedName("ts")
    val ts: String
)