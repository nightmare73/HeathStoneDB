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

        deployWarningDialog()
    }

    private fun deployWarningDialog() {
        InitialWarningDialog(this).apply {
            setOnOkClickListener { initialDataViewModel.load() }
        }.show()
    }
}
