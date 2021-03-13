package com.hashim.dictionaryapp.repository.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hashim.dictionaryapp.api.RetrofitService
import com.hashim.dictionaryapp.repository.remote.responses.lookupresponse.SearchRes
import com.hashim.dictionaryapp.ui.main.state.MainViewState
import com.hashim.dictionaryapp.utils.GenericApiRes
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(
    private val hRetrofitService: RetrofitService,
    private val key: String
) : RemoteRepo {

    override suspend fun hSearchWord(query: String): LiveData<MainViewState> {

        val hMutableLiveData = MutableLiveData<MainViewState>()

        var hGenericResponse: GenericApiRes<SearchRes>

        val hSearchWord = hRetrofitService.hSearchWord(
            key = key,
            wordLookup = query
        )

        try {
            hGenericResponse = GenericApiRes.create(hSearchWord)
        } catch (e: Exception) {
            hGenericResponse = GenericApiRes.create(e)
        }


        when (hGenericResponse) {
            is GenericApiRes.EmptyRes -> {
                hMutableLiveData.value = MainViewState()
            }
            is GenericApiRes.SuccessRes -> {
                hMutableLiveData.value = MainViewState(
                    hSearchRes = hGenericResponse.body
                )
            }
            is GenericApiRes.ErrorRes -> {
                hMutableLiveData.value = MainViewState()
            }
        }

        return hMutableLiveData
    }
}