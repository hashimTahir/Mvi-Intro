/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.network

import com.hashim.dictionaryapp.network.responses.lanresponse.LangRes
import com.hashim.dictionaryapp.network.responses.lookupresponse.LookUpResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface DictionaryRetrofitService {
    @GET("dicservice.json/getLangs")
    suspend fun hGetLanguages(
        @Query("key") key: String,
    ): LangRes

    @GET("dicservice.json/lookup")
    suspend fun hGetLookUp(
        @Header("key") key: String,
        @Query("lang") lang: String,
        @Query("text") query: String,
    ): LookUpResponse
}