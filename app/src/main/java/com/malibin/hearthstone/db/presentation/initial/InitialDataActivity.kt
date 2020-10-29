package com.malibin.hearthstone.db.presentation.initial

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.malibin.hearthstone.db.R
import com.malibin.hearthstone.db.databinding.ActivityInitialDataBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class InitialDataActivity : AppCompatActivity() {

    private val initialDataViewModel: InitialDataViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityInitialDataBinding.inflate(layoutInflater)
        binding.viewModel = initialDataViewModel
        binding.lifecycleOwner = this
        setContentView(binding.root)

        subscribeLoadingState(binding)
        deployWarningDialog()
    }

    private fun deployWarningDialog() {
        InitialWarningDialog(this).apply {
            setOnOkClickListener { initialDataViewModel.load(); dismiss() }
        }.show()
    }

    private fun subscribeLoadingState(binding: ActivityInitialDataBinding) {
        initialDataViewModel.isMetaDataLoadFinished.observe(this) { isFinished ->
            if (isFinished) binding.loadingState.setText(R.string.card_downloading)
        }
        initialDataViewModel.isCardsLoadFinished.observe(this) { isFinished ->
            if (isFinished) binding.loadingState.setText(R.string.download_complete)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        CoroutineScope(Dispatchers.IO).launch {
            initialDataViewModel.deleteAllTempFunction()
            Log.d("Malibin Debug", "All Data Deleted")
        }
    }
}
