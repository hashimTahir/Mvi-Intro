package com.hashim.dictionaryapp.repository.remote

import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(
    private val hRetrofitService: RetrofitService,
    private val key: String
) : RemoteRepo {
    override suspend fun hGetLanguages() {
        hRetrofitService.hGetLanguages(key = key)
    }

    override suspend fun hGetLookUp(lang: String, query: String) {
        hRetrofitService.hGetLookUp(
            key = key,
            lang = lang,
            query = query
        )
    }

}