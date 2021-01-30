/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.network.responses.lookupresponse


import com.google.gson.annotations.SerializedName

data class Ex(
    @SerializedName("text")
    val text: String,
    @SerializedName("tr")
    val tr: List<TrX>
)