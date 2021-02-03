/*
 * Copyright (c) 2021/  1/ 31.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.ui.main.state

import com.hashim.dictionaryapp.repository.remote.responses.lanresponse.LangRes
import com.hashim.dictionaryapp.repository.remote.responses.lookupresponse.LookUpResponse


/*Whatever is required in the view is packaged togater in a single classs.
* it holds all the data objects in view.*/
data class MainViewState(
    var hLangRes: LangRes?= null,
    var hLookUpResponse: LookUpResponse?= null,

    )
