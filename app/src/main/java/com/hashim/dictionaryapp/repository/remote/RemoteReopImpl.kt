package com.hashim.dictionaryapp.repository.remote

import com.hashim.dictionaryapp.repository.remote.responses.lanresponse.LangRes
import com.hashim.dictionaryapp.repository.remote.responses.lookupresponse.LookUpResponse
import retrofit2.Response

class RemoteReopImpl : RemoteRepo {
    override suspend fun hGetLanguages(key: String): Response<LangRes> {
        TODO("Not yet implemented")
    }

    override suspend fun hGetLookUp(
        key: String,
        lang: String,
        query: String
    ): Response<LookUpResponse> {
        TODO("Not yet implemented")
    }
}