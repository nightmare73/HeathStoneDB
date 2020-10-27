package com.malibin.hearthstone.db.presentation.initial

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.malibin.hearthstone.db.databinding.ActivityInitialDataBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InitialDataActivity : AppCompatActivity() {

    private val initialDataViewModel: InitialDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityInitialDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO : 이전에 와이파이인지 물어보고 데이터 다운받는 다이얼로그 만들기.
        initialDataViewModel.load()
    }
}