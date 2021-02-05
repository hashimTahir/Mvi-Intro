/*
 * Copyright (c) 2021/  2/ 5.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.repository.remote.responses.lookupresponse


import com.google.gson.annotations.SerializedName

data class Hwi(
    @SerializedName("hw")
    val hw: String,
    @SerializedName("prs")
    val prs: List<Pr>
)