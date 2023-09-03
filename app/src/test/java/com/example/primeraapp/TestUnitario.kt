package com.example.primeraapp


import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertNotEquals

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TestUnitario {

    private lateinit var viewModel: MainveiwModel

    @get:Rule
    val instantTaskRule= InstantTaskExecutorRule()
    private val dispatcher=StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel= MainveiwModel()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun MainveiwModel_Checking()= runBlockingTest {
        val value=viewModel.result.value?.resultant?:""
        assertEquals("",value)
    }
    @Test
    fun MainveiwModel_operacion()= runTest {
        launch {
            viewModel.iguales("texto", "texto3")
        }
    advanceUntilIdle()
        val value=viewModel.result.value?.resultant
        assertNotEquals("",value)
    }


}