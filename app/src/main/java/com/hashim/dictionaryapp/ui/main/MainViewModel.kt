/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.hashim.dictionaryapp.repository.remote.responses.lanresponse.LangRes
import com.hashim.dictionaryapp.repository.remote.responses.lookupresponse.LookUpResponse
import com.hashim.dictionaryapp.ui.main.state.MainStateEvent
import com.hashim.dictionaryapp.ui.main.state.MainStateEvent.*
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
            is GetLanguagesEvent -> {
                return AbsentLiveData.create()
            }
            is GetLookUpEvent -> {
                return AbsentLiveData.create()
            }
            is None -> {
                return AbsentLiveData.create()
            }
        }
    }


    fun hSetLookUpData(lookUpResponse: LookUpResponse) {
        var hUpdate = hGetCurrentViewStateOrNew()
        hUpdate.hLookUpResponse = lookUpResponse
        _hMainViewState.value = hUpdate

    }

    fun hSetLangData(langRes: LangRes) {
        var hUpdate = hGetCurrentViewStateOrNew()
        hUpdate.hLangRes = langRes
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