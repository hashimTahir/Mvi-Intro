/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.ui.main.state


/*State Event are Intent that are fired from View Towards the ViewModel*/
sealed class MainStateEvent {
    class GetSearchWordEvent(val wordText: String) : MainStateEvent()

    class None : MainStateEvent()
}
