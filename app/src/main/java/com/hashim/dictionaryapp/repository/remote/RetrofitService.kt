/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.repository.remote

import com.hashim.dictionaryapp.repository.remote.responses.lookupresponse.SearchRes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {


    @GET("sd3/json/{wordLookup}")
    suspend fun hSearchWord(
        @Path("wordLookup") wordLookup: String,
        @Query("key") key: String
    ): Response<SearchRes>
}