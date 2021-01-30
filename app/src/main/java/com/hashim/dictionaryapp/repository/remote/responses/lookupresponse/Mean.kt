/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.repository.remote.responses.lookupresponse


import com.google.gson.annotations.SerializedName

data class Mean(
    @SerializedName("text")
    val text: String
)