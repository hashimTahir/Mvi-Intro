/*
 * Copyright (c) 2021/  3/ 17.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.ui.main

import com.hashim.dictionaryapp.utils.DataState

interface DataStateListener {
    fun hOnDataStateChanged(dataState: DataState<*>?)
}