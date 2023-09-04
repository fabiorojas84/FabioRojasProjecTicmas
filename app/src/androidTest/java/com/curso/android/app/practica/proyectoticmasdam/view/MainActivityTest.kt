package com.curso.android.app.practica.proyectoticmasdam.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.proyectoticmasdam.R
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_comparatorCompareTextNull() {
        Espresso.onView(
            ViewMatchers.withId(R.id.comparator_button)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.text_response)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(R.string.string_vacio)
            )
        )
    }

    @Test
    fun mainActivity_comparatorCompareContentCharacters() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text_1)
        ).perform(
            ViewActions.typeText("#")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.text_2)
        ).perform(
            ViewActions.typeText("text")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.comparator_button)
        ).perform(
            ViewActions.pressBack()
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.text_response)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(R.string.string_especial)
            )
        )
    }
    @Test
    fun mainActivity_comparatorCompareContentBlankI1() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text_1)
        ).perform(
            ViewActions.typeText("   ")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.text_2)
        ).perform(
            ViewActions.typeText("text")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.comparator_button)
        ).perform(
            ViewActions.pressBack()
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.text_response)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(R.string.string_vacio)
            )
        )
    }
    @Test
    fun mainActivity_comparatorCompareContentBlankI2() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text_1)
        ).perform(
            ViewActions.typeText("text")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.text_2)
        ).perform(
            ViewActions.typeText("   ")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.comparator_button)
        ).perform(
            ViewActions.pressBack()
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.text_response)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(R.string.string_vacio)
            )
        )
    }
    @Test
    fun mainActivity_comparatorCompareContentTextDifferent() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text_1)
        ).perform(
            ViewActions.typeText("primary")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.text_2)
        ).perform(
            ViewActions.typeText("secondary")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.comparator_button)
        ).perform(
            ViewActions.pressBack()
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.text_response)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(R.string.string_distintos)
            )
        )
    }
    @Test
    fun mainActivity_comparatorCompareContentTextEqualsCase() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text_1)
        ).perform(
            ViewActions.typeText("PRIMARY")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.text_2)
        ).perform(
            ViewActions.typeText("primary")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.comparator_button)
        ).perform(
            ViewActions.pressBack()
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.text_response)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(R.string.string_iguales)
            )
        )
    }
    @Test
    fun mainActivity_comparatorCompareContentTextEquals() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text_1)
        ).perform(
            ViewActions.typeText("primary")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.text_2)
        ).perform(
            ViewActions.typeText("primary")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.comparator_button)
        ).perform(
            ViewActions.pressBack()
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.text_response)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(R.string.string_iguales)
            )
        )
    }
    @Test
    fun mainActivity_comparatorCompareContentTextBlankSpace() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text_1)
        ).perform(
            ViewActions.typeText("   primary   ")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.text_2)
        ).perform(
            ViewActions.typeText("primary")
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.comparator_button)
        ).perform(
            ViewActions.pressBack()
        ).perform(
            ViewActions.click()
        )
        Espresso.onView(
            ViewMatchers.withId(R.id.text_response)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText(R.string.string_iguales)
            )
        )
    }

}