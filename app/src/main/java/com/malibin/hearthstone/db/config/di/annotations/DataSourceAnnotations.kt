package com.malibin.hearthstone.db.config.di.annotations

import javax.inject.Qualifier

/**
 * Created By Malibin
 * on 2월 11, 2021
 */

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BlizzardAuthLocal

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BlizzardAuthRemote
