package com.dewarder.katanatest

import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ActivityViewTest {

    @get:Rule
    val activityRule = ActivityTestRule<TestViewActivity>(TestViewActivity::class.java)

    @get:Rule
    val exceptionRule = ExpectedException.none();

    @Test
    fun testOneRequiredViewExist() {
        activityRule.activity.viewRequiredExist
    }

    @Test
    fun testOneRequiredViewAbsent() {
        exceptionRule.expect(IllegalStateException::class.java)
        activityRule.activity.viewRequiredAbsent
    }

    @Test
    fun testOneOptionalViewExist() {
        assertNotNull(activityRule.activity.viewOptionalExist)
    }

    @Test
    fun testOneOptionalViewNotExist() {
        assertNull(activityRule.activity.viewOptionalAbsent)
    }

    @Test
    fun testOneRequiredViewExistAndCorrectClass() {
        assertTrue(activityRule.activity.textViewRequiredCorrect is TextView)
    }

    @Test
    fun testOneRequiredViewExistAndIncorrectClass() {
        exceptionRule.expect(ClassCastException::class.java)
        assertFalse(activityRule.activity.textViewRequiredIncorrect is LinearLayout)
    }

    @Test
    fun testOneOptionalViewExistAndCorrectClass() {
        assertNotNull(activityRule.activity.textViewOptionalCorrect)
        assertTrue(activityRule.activity.textViewOptionalCorrect is TextView)
    }

    @Test
    fun testOneOptionalViewExistAndIncorrectClass() {
        exceptionRule.expect(ClassCastException::class.java)
        assertFalse(activityRule.activity.textViewOptionalIncorrect is LinearLayout)
    }

    @Test
    fun testManyRequiredViewAllExist() {
        val size = activityRule.activity.viewsRequiredExist.filterNotNull().size
        assertEquals(size, 2)
    }

    @Test
    fun testManyRequiredViewAllAbsent() {
        exceptionRule.expect(IllegalStateException::class.java)
        exceptionRule.expectMessage(TestViewActivity::class.java.simpleName)
        exceptionRule.expectMessage(TestViewActivity.NO_VIEW1.toString())
        exceptionRule.expectMessage(TestViewActivity.NO_VIEW2.toString())
        exceptionRule.expectMessage(activityRule.activity::viewsRequiredAbsent.name)
        activityRule.activity.viewsRequiredAbsent
    }

    @Test
    fun testManyOptionalViewAllExist() {
        val size = activityRule.activity.viewsOptionalExist.filterNotNull().size
        assertEquals(size, 2)
    }

    @Test
    fun testManyOptionalViewAllAbsent() {
        val size = activityRule.activity.viewsOptionalAbsent.size
        assertEquals(size, 2)
        val nonNullSize = activityRule.activity.viewsOptionalAbsent.filterNotNull().size
        assertEquals(nonNullSize, 0)
    }

    @Test
    fun testManyRequiredFirstExistSecondAbsent() {
        exceptionRule.expect(IllegalStateException::class.java)
        exceptionRule.expectMessage(TestViewActivity::class.java.simpleName)
        exceptionRule.expectMessage(TestViewActivity.NO_VIEW1.toString())
        exceptionRule.expectMessage(activityRule.activity::viewsRequiredFirstExistSecondAbsent.name)
        activityRule.activity.viewsRequiredFirstExistSecondAbsent
    }

    @Test
    fun testManyOptionalFirstExistSecondAbsent() {
        val viewList = activityRule.activity.viewsOptionalFirstExistSecondAbsent
        assertEquals(viewList.size, 2)
        assertNotNull(viewList.first())
        assertNull(viewList.last())
    }

    @Test
    fun testManyRequiredAllExistAndCorrectClass() {
        val viewList = activityRule.activity.viewsRequiredExistCorrect
        assertEquals(viewList.size, 2)
        assertEquals(viewList.filterIsInstance<TextView>().size, 2)
    }

    @Test
    fun testManyRequiredAllExistAndIncorrectClass() {
        exceptionRule.expect(ClassCastException::class.java)
        activityRule.activity.viewsRequiredExistIncorrect
    }

    @Test
    fun testManyRequiredAllDifferentClassCorrect() {
        val viewList = activityRule.activity.viewsOptionalExistFirstViewSecondTextViewCorrect
        assertEquals(viewList.size, 2)
        assertTrue(viewList.first() is View)
        assertTrue(viewList.last() is TextView)
    }
}
