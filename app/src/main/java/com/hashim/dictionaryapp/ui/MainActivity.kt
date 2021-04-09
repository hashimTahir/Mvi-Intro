/*
 * Copyright (c) 2021/  1/ 30.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.hashim.dictionaryapp.R
import com.hashim.dictionaryapp.databinding.ActivityMainBinding
import com.hashim.dictionaryapp.ui.main.DataStateListener
import com.hashim.dictionaryapp.utils.DataState
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), DataStateListener {
    private lateinit var hActivityMainBinding: ActivityMainBinding

    private lateinit var hNavHostFragments: NavHostFragment

    private lateinit var hNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(hActivityMainBinding.root)

        hInitNavView()
    }


    private fun hInitNavView() {
        hNavHostFragments = supportFragmentManager
            .findFragmentById(R.id.hMainFragmentContainerV) as NavHostFragment
        hNavController = hNavHostFragments.navController

        hNavController.setGraph(R.navigation.main_nav)
    }

    override fun hOnDataStateChanged(dataState: DataState<*>?) {
        Timber.d("hOnDataStateChanged Listener Called")
        dataState?.let {
            hShowProgressBar(it.hLoading)

            it.hMessage?.let { hShowToast(it) }

        }
    }

    private fun hShowToast(message: String) {
        Timber.d("Showing toast")
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun hShowProgressBar(isVisible: Boolean) {
        when (isVisible) {
            true -> {
                hActivityMainBinding.hProgressbar.visibility = View.VISIBLE
            }
            false -> {
                hActivityMainBinding.hProgressbar.visibility = View.GONE
            }

        }


    }

}