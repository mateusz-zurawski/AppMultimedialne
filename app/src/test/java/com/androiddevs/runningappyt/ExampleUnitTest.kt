package com.androiddevs.runningappyt

import androidx.core.text.set
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.androiddevs.runningappyt.ui.MainActivity
import com.androiddevs.runningappyt.ui.fragments.SettingsFragment
import kotlinx.android.synthetic.main.fragment_setup.*
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
    @Test
    fun add_correct_weight(){

        assertEquals(4, 2 + 2)
    }
}
