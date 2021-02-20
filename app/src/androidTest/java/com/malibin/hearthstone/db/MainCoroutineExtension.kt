package com.malibin.hearthstone.db

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.extension.AfterEachCallback
import org.junit.jupiter.api.extension.BeforeEachCallback
import org.junit.jupiter.api.extension.ExtensionContext

/**
 * Created By Malibin
 * on 2월 18, 2021
 */

@ExperimentalCoroutinesApi
class MainCoroutineExtension(
    val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher(),
) : BeforeEachCallback, AfterEachCallback,
    TestCoroutineScope by TestCoroutineScope(testDispatcher) {

    fun runBlockingTest(
        block: suspend TestCoroutineScope.() -> Unit
    ) = testDispatcher.runBlockingTest(block)

    override fun beforeEach(context: ExtensionContext?) {
        Dispatchers.setMain(testDispatcher)
    }

    override fun afterEach(context: ExtensionContext?) {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}
