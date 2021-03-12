/*
 * Copyright (c) 2021/  2/ 5.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.api

import androidx.lifecycle.LiveData
import com.hashim.dictionaryapp.repository.remote.responses.lookupresponse.SearchRes
import com.hashim.dictionaryapp.utils.GenericApiRes
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RetrofitService {


    @GET("sd3/json/{wordLookup}")
     fun hSearchWord(
        @Path("wordLookup") wordLookup: String,
        @Query("key") key: String
    ): LiveData<GenericApiRes<SearchRes>>
}