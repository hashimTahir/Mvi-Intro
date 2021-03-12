/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.repository.remote

import androidx.lifecycle.LiveData
import com.hashim.dictionaryapp.ui.main.state.MainViewState

interface RemoteRepo {

     fun hSearchWord(
        query: String,
    ): LiveData<MainViewState>
}