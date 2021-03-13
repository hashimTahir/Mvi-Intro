package com.hashim.dictionaryapp.repository.remote

import androidx.lifecycle.LiveData
import com.hashim.dictionaryapp.api.RetrofitService
import com.hashim.dictionaryapp.repository.remote.responses.lookupresponse.SearchRes
import com.hashim.dictionaryapp.ui.main.state.MainViewState
import com.hashim.dictionaryapp.utils.DataState
import com.hashim.dictionaryapp.utils.GenericApiRes
import retrofit2.Response
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(
    private val hRetrofitService: RetrofitService,
    private val key: String
) : RemoteRepo {

    override fun hSearchWord(query: String)
            : LiveData<DataState<MainViewState>> {

        return object : NetworkBoundResource<SearchRes, MainViewState>() {
            override fun hOnDataSuccess(response: GenericApiRes.SuccessRes<SearchRes>) {
                hResult.value = DataState.hData(
                    message = null,
                    data = MainViewState(
                        hSearchRes = response.body
                    )
                )
            }

            override fun hCreateCall(): LiveData<GenericApiRes<SearchRes>> {
                return hRetrofitService.hSearchWord(
                    wordLookup = query,
                    key = key
                )
            }

        }.hToLiveData()
    }
}