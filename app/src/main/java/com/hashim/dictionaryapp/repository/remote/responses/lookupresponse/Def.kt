/*
 * Copyright (c) 2021/  2/ 5.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.repository.remote.responses.lookupresponse


import com.google.gson.annotations.SerializedName

data class Def(
    @SerializedName("sseq")
    val sseq: List<List<List<Any>>>
)