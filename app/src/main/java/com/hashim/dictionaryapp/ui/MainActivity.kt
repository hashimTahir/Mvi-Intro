/*
 * Copyright (c) 2021/  1/ 30.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.hashim.dictionaryapp.R
import com.hashim.dictionaryapp.databinding.ActivityMainBinding
import com.hashim.dictionaryapp.repository.remote.RemoteRepo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var hActivityMainBinding: ActivityMainBinding

    private lateinit var hNavHostFragments: NavHostFragment

    private lateinit var hNavController: NavController


    @Inject
    lateinit var hRepo: RemoteRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(hActivityMainBinding.root)

        hInitNavView()
        hSetupListeners()

        hTestApi()
    }

    private fun hTestApi() {

        CoroutineScope(IO).launch {
            hRepo.hSearchWord(query = "hello")
        }
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