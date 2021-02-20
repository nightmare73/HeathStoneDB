package com.malibin.hearthstone.db.data.dao

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import com.google.common.truth.Truth.assertThat
import com.malibin.hearthstone.db.MainCoroutineExtension
import com.malibin.hearthstone.db.data.db.HearthStoneDataBase
import com.malibin.hearthstone.db.data.entity.metadata.CardSet
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.asExecutor
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.extension.RegisterExtension
import java.text.SimpleDateFormat

/**
 * Created By Malibin
 * on 2월 20, 2021
 */

@ExperimentalCoroutinesApi
class MetaDataDaoTest {

    companion object {
        @JvmField
        @RegisterExtension
        val coroutineExtension = MainCoroutineExtension()
    }

    private lateinit var metaDataDao: MetaDataDao

    @BeforeEach
    fun dao_초기화() {
        metaDataDao = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().context,
            HearthStoneDataBase::class.java
        ).setTransactionExecutor(CardsDaoTest.coroutineExtension.testDispatcher.asExecutor())
            .setQueryExecutor(CardsDaoTest.coroutineExtension.testDispatcher.asExecutor())
            .build()
            .metaDataDao()
    }

    @Test
    @DisplayName("카드 세트의 삽입 조회를 할 수 있다.")
    fun cardSetsTest() = coroutineExtension.runBlockingTest {
        // given
        val cardSet = CardSet(
            id = 1463,
            slug = "수습 악마사냥꾼",
            name = "demonhunter-initiate",
            releaseDate = SimpleDateFormat("yyyy-MM-dd").parse("2020-04-08"),
            type = "base",
            collectibleCount = 20,
        )
        val cardSets = listOf(cardSet)

        // when
        metaDataDao.insertCardSets(cardSets)

        // then
        val retrieveCardSets = metaDataDao.getCardSets()
        assertAll(
            { assertThat(retrieveCardSets).hasSize(cardSets.size) },
            { assertThat(retrieveCardSets).containsExactlyElementsIn(cardSets) },
        )
    }
}
