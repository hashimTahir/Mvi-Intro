package com.hashim.dictionaryapp.repository.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.hashim.dictionaryapp.api.RetrofitService
import com.hashim.dictionaryapp.ui.main.state.MainViewState
import com.hashim.dictionaryapp.utils.DataState
import com.hashim.dictionaryapp.utils.GenericApiRes
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(
    private val hRetrofitService: RetrofitService,
    private val key: String
) : RemoteRepo {

    override fun hSearchWord(query: String)
            : LiveData<DataState<MainViewState>> {

        return Transformations.switchMap(
            hRetrofitService.hSearchWord(
                key = key,
                wordLookup = query
            )
        ) { apiResponse ->
            object : LiveData<DataState<MainViewState>>() {
                override fun onActive() {
                    super.onActive()
                    when (apiResponse) {
                        is GenericApiRes.ErrorRes -> {
                            value = DataState.hError(
                                apiResponse.errorMessage
                            )
                        }
                        is GenericApiRes.SuccessRes -> {
                            value = DataState.hData(
                                message = null,
                                data = MainViewState(
                                    hSearchRes = apiResponse.body
                                )
                            )
                        }
                        is GenericApiRes.EmptyRes -> {
                            value = DataState.hError(
                                errorMessage = "Http 304"
                            )
                        }
                    }
                }
            }

        }
    }
}