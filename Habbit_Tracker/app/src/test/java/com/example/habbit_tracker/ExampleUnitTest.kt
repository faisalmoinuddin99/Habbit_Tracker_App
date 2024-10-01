package com.example.habbit_tracker

import org.junit.Test

import org.junit.Assert.*
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @org.junit.jupiter.api.Test
    fun addition_isCorrect() {
        assertEquals(5, 3 + 2)
    }

    @org.junit.jupiter.api.Test
    fun printHello(){
        println("Hello")
        assertEquals("Hello","Hello")

    }
    @BeforeEach
    fun sayMyName(){
        println("Say My Name")
    }
    @org.junit.jupiter.api.Test
    fun printMyName(){
        println("Hello faisal")
    }


}
