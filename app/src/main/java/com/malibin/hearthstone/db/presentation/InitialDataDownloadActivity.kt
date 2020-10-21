package com.malibin.hearthstone.db.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.malibin.hearthstone.db.data.service.BlizzardOAuthService
import com.malibin.hearthstone.db.data.service.BlizzardService
import com.malibin.hearthstone.db.databinding.ActivityInitialDataDownloadBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InitialDataDownloadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityInitialDataDownloadBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val oAuthService: BlizzardOAuthService = Retrofit.Builder()
            .baseUrl(BlizzardOAuthService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BlizzardOAuthService::class.java)

        val blizzardService: BlizzardService = Retrofit.Builder()
            .baseUrl(BlizzardService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BlizzardService::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val token = oAuthService.requestOAuthToken().accessToken
            val metadata = blizzardService.getMetaData(token)
            println(metadata)
        }
    }
}
