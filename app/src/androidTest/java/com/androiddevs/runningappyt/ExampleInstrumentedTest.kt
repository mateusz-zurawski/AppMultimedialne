package com.androiddevs.runningappyt

import android.graphics.Bitmap
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.androiddevs.runningappyt.db.Run
import com.androiddevs.runningappyt.db.RunDAO
import com.androiddevs.runningappyt.db.RunningDatabase
import kotlinx.coroutines.runBlocking
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
@SmallTest
class ExampleInstrumentedTest {


//    @Test
//    fun useAppContext() {
//        // Context of the app under test.
//        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
//        assertEquals("com.androiddevs.runningappyt", appContext.packageName)
//    }

    private lateinit var database:RunningDatabase
    private lateinit var dao: RunDAO
    @Before
    fun test(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            RunningDatabase::class.java
        ).allowMainThreadQueries().build()
        dao =database.getRunDao()
    }
    @After
    fun test2(){
        database.close()
    }

    @Test
    fun insert2()= runBlocking{
        val runItem = Run(Bitmap.createBitmap(10,10,Bitmap.Config.ARGB_8888),0L,0f,0,0L,0,false)

        dao.insertRun(runItem)

        assert(dao.getAllRunsSortedByAvgSpeed().value?.contains(runItem)== true)
    }
}
