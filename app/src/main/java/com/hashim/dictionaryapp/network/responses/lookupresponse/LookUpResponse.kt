/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.network.responses.lookupresponse


import com.google.gson.annotations.SerializedName

data class LookUpResponse(
    @SerializedName("def")
    val def: List<Def>,
    @SerializedName("head")
    val head: Head
)