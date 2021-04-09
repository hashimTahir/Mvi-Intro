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
import androidx.fragment.app.viewModels
import com.hashim.dictionaryapp.databinding.FragmentMainBinding
import com.hashim.dictionaryapp.ui.main.state.MainStateEvent
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var hFragmentMainBinding: FragmentMainBinding
    private lateinit var hDataStateListener: DataStateListener
    private val hMainViewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        hFragmentMainBinding = FragmentMainBinding.inflate(
            layoutInflater,
            container,
            false
        )
        return hFragmentMainBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hSetupListeners()

        hSubscribeObservers()
    }


    private fun hSubscribeObservers() {
        /*Data comming in from the repository*/
        hMainViewModel.hDataState.observe(viewLifecycleOwner) { dataState ->
            hDataStateListener.hOnDataStateChanged(dataState)

            dataState.hData?.let { mainViewState ->
                mainViewState.hSearchRes?.let {
                    hMainViewModel.hSetSearchResData(it)
                }
            }
        }

        hMainViewModel.hMainViewState.observe(viewLifecycleOwner) { mainViewState ->
            mainViewState.hSearchRes?.let {
                hFragmentMainBinding.hMeaningTv.text = it.toString()
            }
        }
    }


    private fun hSetupListeners() {
        hFragmentMainBinding.hMeaningB.setOnClickListener {
            hMainViewModel.hSetStateEvent(
                MainStateEvent.GetSearchWordEvent(
                    hFragmentMainBinding.hEnterWordEt.text.toString()
                )
            )
        }
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