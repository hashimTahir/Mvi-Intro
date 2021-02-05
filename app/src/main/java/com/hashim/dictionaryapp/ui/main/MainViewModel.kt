/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.hashim.dictionaryapp.repository.remote.responses.lookupresponse.SearchRes
import com.hashim.dictionaryapp.ui.main.state.MainStateEvent
import com.hashim.dictionaryapp.ui.main.state.MainStateEvent.GetSearchWordEvent
import com.hashim.dictionaryapp.ui.main.state.MainStateEvent.None
import com.hashim.dictionaryapp.ui.main.state.MainViewState
import com.hashim.dictionaryapp.utils.AbsentLiveData

class MainViewModel : ViewModel() {

    /*Events fired from the view by users interactions*/
    private val _hMainStateEvent = MutableLiveData<MainStateEvent>()


    /*Data setter for the view packged into a single object*/
    private val _hMainViewState = MutableLiveData<MainViewState>()
    public val hMainViewState: LiveData<MainViewState>
        get() = _hMainViewState


    val hDataState: LiveData<MainViewState> = Transformations
        .switchMap(_hMainStateEvent) {
            it?.let { mainStateEvent ->
                hHandleStateEvent(mainStateEvent)
            }
        }

    init {

    }

    private fun hHandleStateEvent(stateEvent: MainStateEvent): LiveData<MainViewState> {
        when (stateEvent) {
            is GetSearchWordEvent -> {
                return AbsentLiveData.create()
            }

            is None -> {
                return AbsentLiveData.create()
            }
        }
    }


    fun hSetSearchResData(searchRes: SearchRes) {
        var hUpdate = hGetCurrentViewStateOrNew()
        hUpdate.hSearchRes = searchRes
        _hMainViewState.value = hUpdate

    }


    fun hGetCurrentViewStateOrNew(): MainViewState {
        val hValue = hMainViewState.value?.let {
            it
        } ?: MainViewState()
        return hValue
    }

    fun hSetStateEvent(mainStateEvent: MainStateEvent) {
        _hMainStateEvent.value = mainStateEvent
    }
}