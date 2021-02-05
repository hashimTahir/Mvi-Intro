package com.hashim.dictionaryapp.repository.remote

import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(
    private val hRetrofitService: RetrofitService,
    private val key: String
) : RemoteRepo {

    override suspend fun hSearchWord(query: String) {
        hRetrofitService.hSearchWord(
            key = key,
            wordLookup = query
        )
    }

}