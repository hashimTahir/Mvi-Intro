package com.hashim.dictionaryapp.repository.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.hashim.dictionaryapp.api.RetrofitService
import com.hashim.dictionaryapp.ui.main.state.MainViewState
import com.hashim.dictionaryapp.utils.GenericApiRes
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(
    private val hRetrofitService: RetrofitService,
    private val key: String
) : RemoteRepo {

    override  fun hSearchWord(query: String): LiveData<MainViewState> {
        return Transformations.switchMap(
            hRetrofitService.hSearchWord(
                key = key,
                wordLookup = query
            )
        ) { apiResponse ->
            object : LiveData<MainViewState>() {
                override fun onActive() {
                    super.onActive()
                    when (apiResponse) {
                        is GenericApiRes.SuccessRes -> {
                            value = MainViewState(
                                hSearchRes = apiResponse.body
                            )
                        }
                        is GenericApiRes.ErrorRes -> {
                            value = MainViewState()
                        }
                        is GenericApiRes.EmptyRes -> {
                            value = MainViewState()
                        }
                    }
                }
            }
        }
    }

}