package com.malibin.hearthstone.db.presentation.initial

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.malibin.hearthstone.db.R
import com.malibin.hearthstone.db.databinding.ActivityInitialDataBinding
import com.malibin.hearthstone.db.presentation.card.CardsActivity
import dagger.hilt.android.AndroidEntryPoint

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

        binding.button.setOnClickListener {
            startActivity(Intent(this, CardsActivity::class.java))
        }
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

//    override fun onDestroy() {
//        super.onDestroy()
//        CoroutineScope(Dispatchers.IO).launch {
//            initialDataViewModel.deleteAllTempFunction()
//            Log.d("Malibin Debug", "All Data Deleted")
//        }
//    }
}
