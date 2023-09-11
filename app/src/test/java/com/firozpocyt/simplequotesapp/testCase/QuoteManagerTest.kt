package com.firozpocyt.simplequotesapp.testCase

import android.content.Context
import android.content.res.AssetManager
import com.firozpocyt.simplequotesapp.Quote
import org.junit.Assert.*

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.doReturn
import org.mockito.MockitoAnnotations

class QuoteManagerTest {

    @Mock
    lateinit var context: Context

    @Mock
    lateinit var assetManager: AssetManager

    @Before
    fun setUp() {
        MockitoAnnotations.openMocks(this)

    }

    @Test
    fun test() {
        val inputStream = QuoteManagerTest::class.java.getResourceAsStream("/quotes.json")
        doReturn(assetManager).`when`(context).assets
        Mockito.`when`(context.assets.open(anyString())).thenReturn(inputStream)

        val sut = QuoteManager()
        sut.populateQuoteFromAssets(context, "")
        val quote = sut.getCurrentQuote()
        Assert.assertEquals("Well begun is half done.", quote.text)
    }

    @After
    fun tearDown() {
    }
}