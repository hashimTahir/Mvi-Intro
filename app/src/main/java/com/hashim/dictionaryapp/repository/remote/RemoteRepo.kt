/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.repository.remote

interface RemoteRepo {
    suspend fun hGetLanguages()

    suspend fun hGetLookUp(
        lang: String,
        query: String,
    )
}