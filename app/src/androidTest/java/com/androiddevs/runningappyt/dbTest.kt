package com.androiddevs.runningappyt

import android.graphics.Bitmap
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.androiddevs.runningappyt.db.Run
import com.androiddevs.runningappyt.db.RunDAO
import com.androiddevs.runningappyt.db.RunningDatabase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class dbTest {

    private lateinit var database: RunningDatabase
    private lateinit var dao: RunDAO

    @Before
    fun setupDB(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            RunningDatabase::class.java
        ).allowMainThreadQueries().build()
        dao =database.getRunDao()
    }
    @After
    fun closeDB(){
        database.close()
    }

    @Test
    fun insertIntoDB()= runBlocking{

        val runItem = Run(Bitmap.createBitmap(10,10, Bitmap.Config.ARGB_8888),0L,0f,0,0L,0,false)

        dao.insertRun(runItem)

        assert(dao.getAllRunsSortedByAvgSpeed().value?.contains(runItem)== true)
    }

    @Test
    fun deleteFromDB()= runBlocking{

        val runItem = Run(Bitmap.createBitmap(10,10, Bitmap.Config.ARGB_8888),0L,0f,0,0L,0,false)

        dao.insertRun(runItem)

        dao.deleteRun(runItem)

        assert(dao.getAllRunsSortedByAvgSpeed().value == null)
    }
}