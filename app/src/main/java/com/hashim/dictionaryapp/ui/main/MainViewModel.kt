/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hashim.dictionaryapp.ui.main.state.MainStateEvent
import com.hashim.dictionaryapp.ui.main.state.MainViewState

class MainViewModel : ViewModel() {

    /*Events fired from the view by users interactions*/
    private val _hMainStateEvent = MutableLiveData<MainStateEvent>()
    private val hMainStateEvent: LiveData<MainStateEvent>
        get() = _hMainStateEvent


    /*Data setter for the view packged into a single object*/
    private val _hMainViewState = MutableLiveData<MainViewState>()
    public val hMainViewState: LiveData<MainViewState>
        get() = _hMainViewState


    init {

    }
}