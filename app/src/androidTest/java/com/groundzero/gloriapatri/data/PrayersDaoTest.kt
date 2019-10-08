package com.groundzero.gloriapatri.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.groundzero.gloriapatri.base.BaseDao
import com.groundzero.gloriapatri.features.prayers.data.Prayer
import com.groundzero.gloriapatri.features.prayers.data.PrayersDao
import com.groundzero.gloriapatri.utils.observeOnce
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PrayersDaoTest : BaseDao() {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    private lateinit var livePrayers: LiveData<List<Prayer>>
    private lateinit var prayer: Prayer
    private lateinit var prayers: List<Prayer>

    private lateinit var dao: PrayersDao

    @Before
    fun setup() {
        dao = persistenceDatabase.getPrayersDao()
        prayer = Prayer(1, "a", "b", "c", "d")
        prayers = mutableListOf(prayer)
    }

    @After
    fun teardown() {
        persistenceDatabase.close()
    }

    @Test
    fun liveData_has_one_item_equals_true() {
        runBlocking {
            dao.insertAll(prayers)
            livePrayers = dao.getPrayers()

            livePrayers.observeOnce {
                assertEquals(1, it.size)
            }
        }
    }

    @Test
    fun single_item_is_fetched_equals_true() {
        runBlocking {
            dao.insertAll(prayers)
            prayers = dao.getPrayersPerTag(prayer.tag)
            assertEquals(prayer.id, prayers[0].id)
        }
    }
}