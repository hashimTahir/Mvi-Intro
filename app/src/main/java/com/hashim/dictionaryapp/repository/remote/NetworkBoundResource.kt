/*
 * Copyright (c) 2021/  3/ 13.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.repository.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.hashim.dictionaryapp.utils.DataState
import com.hashim.dictionaryapp.utils.GenericApiRes
import com.hashim.dictionaryapp.utils.GenericApiRes.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class NetworkBoundResource<ResponseObject, ViewStateType> {
    protected val hResult = MediatorLiveData<DataState<ViewStateType>>()


    /*Difference between Mutable live data and mediatorLive data is
    * One can set and observe the mutable live data.
    * but mediatorLivedata can be set, observed and changed.
    * */

    init {
        hResult.value = DataState.hLoading(true)
        GlobalScope.launch(IO) {
            delay(1000)

            withContext(Main) {
                val hApiResponse = hCreateCall()

                hResult.addSource(hApiResponse) { genericApiResponse ->
                    hResult.removeSource(hApiResponse)

                    hHandleNetworkCall(genericApiResponse)
                }
            }

        }
    }

    private fun hHandleNetworkCall(genericApiResponse: GenericApiRes<ResponseObject>?) {

        when (genericApiResponse) {
            is ErrorRes -> {
                hOnError(genericApiResponse.errorMessage)
            }
            is SuccessRes -> {
                hOnDataSuccess(genericApiResponse)
            }
            is EmptyRes -> {
                hOnError("Http 304")
            }
        }
    }

    abstract fun hOnDataSuccess(body: SuccessRes<ResponseObject>)


    fun hOnError(error: String) {
        hResult.value = DataState.hError(
            errorMessage = error
        )
    }


    abstract fun hCreateCall(): LiveData<GenericApiRes<ResponseObject>>

    fun hToLiveData(): LiveData<DataState<ViewStateType>> {
        return hResult as LiveData<DataState<ViewStateType>>
    }
}