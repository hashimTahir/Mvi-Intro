/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.network.responses.lookupresponse


import com.google.gson.annotations.SerializedName

data class Tr(
    @SerializedName("asp")
    val asp: String,
    @SerializedName("ex")
    val ex: List<Ex>,
    @SerializedName("gen")
    val gen: String,
    @SerializedName("mean")
    val mean: List<Mean>,
    @SerializedName("pos")
    val pos: String,
    @SerializedName("syn")
    val syn: List<Syn>,
    @SerializedName("text")
    val text: String
)