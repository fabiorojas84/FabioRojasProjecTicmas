package com.curso.android.app.practica.proyectoticmasdam

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.proyectoticmasdam.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.junit.After

import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel(Application())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
    @Test
    fun mainViewModel_CheckInitialValueInput1() = runTest {
        val value = viewModel.comparator.value?.input1
        assertEquals(null, value)
    }
    @Test
    fun mainViewModel_CheckInitialValueInput2() = runTest {
        val value = viewModel.comparator.value?.input1
        assertEquals(null, value)
    }
    @Test
    fun mainViewModel_TestComparatorChainI1() = runTest {
        launch {
            viewModel.comparatorChain()
        }
        advanceUntilIdle()
        val value = viewModel.comparator.value?.input1
        assertEquals(null, value)
    }
    @Test
    fun mainViewModel_TestComparatorChainI2() = runTest {
        launch {
            viewModel.comparatorChain()
        }
        advanceUntilIdle()
        val value = viewModel.comparator.value?.input2
        assertEquals(null, value)
    }
    @Test
    fun mainViewModel_TestVerifyChainI1() = runTest {
        launch {
            viewModel.verifyChain()
        }
        advanceUntilIdle()
        val value = viewModel.comparator.value?.input1
        assertEquals(null, value)
    }
    @Test
    fun mainViewModel_TestVerifyChainI2() = runTest {
        launch {
            viewModel.verifyChain()
        }
        advanceUntilIdle()
        val value = viewModel.comparator.value?.input2
        assertEquals(null, value)
    }
    @Test
    fun testComparatorChainWithInvalidInput1() = runTest {

        viewModel.input1.postValue("primary")
        launch {
            viewModel.verifyChain()
        }
        advanceUntilIdle()
        val value = viewModel.comparator.value?.input1
        assertEquals(null, value)
    }
    @Test
    fun testComparatorChainWithInvalidInput2() = runTest {

        viewModel.input2.postValue("primary")
        launch {
            viewModel.verifyChain()
        }
        advanceUntilIdle()
        val value = viewModel.comparator.value?.input2
        assertEquals(null, value)
    }
    @Test
    fun testComparatorChainWithValidInput1() = runTest {

        viewModel.input1.postValue("primary")
        viewModel.input2.postValue("secondary")
        launch {
            viewModel.verifyChain()
        }
        advanceUntilIdle()
        val value = viewModel.comparator.value?.input1
        assertEquals("primary", value)
    }
    @Test
    fun testComparatorChainWithValidInput2() = runTest {

        viewModel.input1.postValue("primary")
        viewModel.input2.postValue("secondary")
        launch {
            viewModel.verifyChain()
        }
        advanceUntilIdle()
        val value = viewModel.comparator.value?.input2
        assertEquals("secondary", value)
    }
    @Test
    fun testComparatorChainWithBlankInput1() = runTest {

        viewModel.input1.postValue("     ")
        viewModel.input2.postValue("secondary")
        launch {
            viewModel.verifyChain()
        }
        advanceUntilIdle()
        val value = viewModel.comparator.value?.input1
        assertEquals(null, value)
    }
    @Test
    fun testComparatorChainWithBlankInput2() = runTest {

        viewModel.input1.postValue("primary")
        viewModel.input2.postValue("      ")
        launch {
            viewModel.verifyChain()
        }
        advanceUntilIdle()
        val value = viewModel.comparator.value?.input2
        assertEquals(null, value)
    }
    @Test
    fun testComparatorChainWithCharacterInput1() = runTest {

        viewModel.input1.postValue("#")
        viewModel.input2.postValue("primary")
        launch {
            viewModel.verifyChain()
        }
        advanceUntilIdle()
        val value = viewModel.comparator.value?.input1
        assertEquals(null, value)
    }
    @Test
    fun testComparatorChainWithCharacterInput2() = runTest {

        viewModel.input1.postValue("primary")
        viewModel.input2.postValue("p#rimary")
        launch {
            viewModel.verifyChain()
        }
        advanceUntilIdle()
        val value = viewModel.comparator.value?.input2
        assertEquals(null, value)
    }
}