/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.repository.remote

import com.hashim.dictionaryapp.repository.remote.responses.lookupresponse.LookUpResponse
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitService {

    @GET("dicservice.json/getLangs")
    suspend fun hGetLanguages(
        @Query("key") key: String,
    ): ResponseBody
    @GET("dicservice.json/lookup")
    suspend fun hGetLookUp(
        @Header("key") key: String,
        @Query("lang") lang: String,
        @Query("text") query: String,
    ): Response<LookUpResponse>
}