package com.malibin.hearthstone.db.data.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.malibin.hearthstone.db.InstantTaskExecutorExtension
import com.malibin.hearthstone.db.MainCoroutineRule
import com.malibin.hearthstone.db.data.db.HearthStoneDataBase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.RegisterExtension

/**
 * Created By Malibin
 * on 2월 18, 2021
 */

@ExtendWith( InstantTaskExecutorExtension::class)
@ExperimentalCoroutinesApi
class CardsDaoTest {

//    companion object {
//        @JvmField
//        @RegisterExtension
//        val coroutineRule = MainCoroutineRule()
//    }
//    @get:Rule
//    val coroutineRule = MainCoroutineRule()
//
//    @get:Rule
//    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var cardsDao: CardsDao

    @BeforeEach
    fun dao_initialize() {
        cardsDao = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            HearthStoneDataBase::class.java
        ).build()
            .cardsDao()
    }

    @Test
    @DisplayName("카드 Id로 카드 한 장 조회가 가능하다")
    fun 카드Id로_카드_한_장_조회가_가능하다() = runBlockingTest {
        // given
        cardsDao.insertCards(listOf(리로이젠킨스))
        val 리로이젠킨스_카드id = 559

        // when
        val card = cardsDao.fetchCard(리로이젠킨스_카드id)

        // then
        assertThat(card).isEqualTo(리로이젠킨스)
    }

    @Test
    @DisplayName("존재하지 않는 카드 id로 조회하면 null을 반환한다.")
    fun 존재하지_않는_카드_id로_조회하면_null_리턴() = runBlockingTest {
        // given
        cardsDao.insertCards(listOf(리로이젠킨스))
        val 존재하지않는_id = 0

        // when
        val card = cardsDao.fetchCard(존재하지않는_id)

        // then
        assertThat(card).isNull()
    }
}
