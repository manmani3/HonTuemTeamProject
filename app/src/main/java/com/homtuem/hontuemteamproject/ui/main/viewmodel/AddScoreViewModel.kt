package com.homtuem.hontuemteamproject.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import com.homtuem.hontuemteamproject.ui.main.repository.ScoreRepository

class AddScoreViewModel : ViewModel() {
    lateinit var mRepository : ScoreRepository

    fun getPlayerList() : List<String>? = arrayListOf("정현", "선광", "기범", "승호", "요람")
}