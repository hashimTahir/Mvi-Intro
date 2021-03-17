/*
 * Copyright (c) 2021/  1/ 30.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hashim.dictionaryapp.databinding.FragmentMainBinding
import timber.log.Timber


class MainFragment : Fragment() {

    private lateinit var hFragmentMainBinding: FragmentMainBinding
    private lateinit var hDataStateListener: DataStateListener
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        hFragmentMainBinding = FragmentMainBinding.inflate(
            layoutInflater,
            container,
            false
        )
        return hFragmentMainBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            hDataStateListener = context as DataStateListener

        } catch (e: ClassCastException) {
            Timber.d("$context must implement DataStateListener")
        }
    }
}