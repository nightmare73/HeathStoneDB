package com.malibin.hearthstone.db.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.malibin.hearthstone.db.data.service.BlizzardOAuthService
import com.malibin.hearthstone.db.data.service.BlizzardService
import com.malibin.hearthstone.db.databinding.ActivityInitialDataDownloadBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class InitialDataDownloadActivity : AppCompatActivity() {

    @Inject
    lateinit var oAuthService: BlizzardOAuthService

    @Inject
    lateinit var blizzardService: BlizzardService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityInitialDataDownloadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val token = oAuthService.requestOAuthToken().accessToken
            val metadata = blizzardService.getMetaData(token)
            println(metadata)
        }
    }
}
