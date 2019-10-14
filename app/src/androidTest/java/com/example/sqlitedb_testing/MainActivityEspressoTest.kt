package com.example.sqlitedb_testing

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import java.util.*

class MainActivityEspressoTest {

    @Rule
    @JvmField var activityTestRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun testRandomNumberInput(){
        Espresso.onView(ViewMatchers.withId(R.id.editText)).perform(ViewActions.typeText(Random().nextInt().toString()))
    }

    @Test
    fun testRandomNumberInputClick(){
        Espresso.onView(ViewMatchers.withId(R.id.editText)).perform(ViewActions.typeText(Random().nextInt().toString()))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.buttonAdd)).perform(ViewActions.click())
    }

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }
}