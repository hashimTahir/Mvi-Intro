/*
 * Copyright (c) 2021/  1/ 30.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.hashim.dictionaryapp.R
import com.hashim.dictionaryapp.databinding.ActivityMainBinding
import com.hashim.dictionaryapp.repository.remote.RemoteRepo
import com.hashim.dictionaryapp.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var hActivityMainBinding: ActivityMainBinding

    private lateinit var hNavHostFragments: NavHostFragment

    private lateinit var hNavController: NavController

    lateinit var hMainViewModel: MainViewModel


    @Inject
    lateinit var hRepo: RemoteRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(hActivityMainBinding.root)

        hMainViewModel = ViewModelProvider(this)
            .get(MainViewModel::class.java)

        hInitNavView()
        hSetupListeners()

        hSubscribeObserver()

    }

    private fun hSubscribeObserver() {
        /*Data comming in from the repository*/
        hMainViewModel.hDataState.observe(this) { mainViewState ->
            Timber.d("DataState is ${mainViewState}")
            mainViewState.hLangRes?.let {
//                Data here

                hMainViewModel.hSetLangData(it)
            }
            mainViewState.hLookUpResponse?.let {
                //                Data here
                hMainViewModel.hSetLookUpData(it)
            }
        }

        hMainViewModel.hMainViewState.observe(this) { mainViewState ->
            mainViewState.hLookUpResponse?.let {
                Timber.d("Setting the Data to the view")
            }

            mainViewState.hLangRes?.let {
                Timber.d("Setting the Data to the view")
            }

        }
    }

    private fun hTestApi() {

    }

    private fun hSetupListeners() {
        hActivityMainBinding.hBottomNav.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.hDailyWords -> {
                    Timber.d("Daily Words")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.hWordsQuiz -> {
                    Timber.d("hWordsQuiz")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.hHistory -> {
                    Timber.d("hHistory")
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.hExit -> {
                    Timber.d("hExit")
                    return@setOnNavigationItemSelectedListener true
                }
                else ->
                    return@setOnNavigationItemSelectedListener false
            }
        }
    }

    private fun hInitNavView() {
        hNavHostFragments = supportFragmentManager
            .findFragmentById(R.id.hMainFragmentContainerV) as NavHostFragment
        hNavController = hNavHostFragments.navController

        hNavController.setGraph(R.navigation.main_nav)
        NavigationUI.setupWithNavController(hActivityMainBinding.hBottomNav, hNavController)
    }

}