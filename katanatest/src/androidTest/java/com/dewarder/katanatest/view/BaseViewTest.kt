package com.dewarder.katanatest.view

import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.dewarder.katanatest.NO_VIEW1
import com.dewarder.katanatest.NO_VIEW2
import com.dewarder.katanatest.get
import com.dewarder.katanatest.view.TestableView
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.junit.runner.RunWith
import java.lang.reflect.InvocationTargetException
import kotlin.reflect.KProperty

@RunWith(AndroidJUnit4::class)
abstract class BaseViewTest {

    @get:Rule
    val exceptionRule = ExpectedException.none();

    lateinit var component: Any

    lateinit var viewRequiredExist: KProperty<View>
    lateinit var viewRequiredAbsent: KProperty<View>
    lateinit var viewOptionalExist: KProperty<View?>
    lateinit var viewOptionalAbsent: KProperty<View?>

    lateinit var textViewRequiredCorrect: KProperty<TextView>
    lateinit var textViewRequiredIncorrect: KProperty<LinearLayout>
    lateinit var textViewOptionalCorrect: KProperty<TextView?>
    lateinit var textViewOptionalIncorrect: KProperty<LinearLayout?>

    lateinit var viewsRequiredExist: KProperty<List<View>>
    lateinit var viewsRequiredAbsent: KProperty<List<View>>
    lateinit var viewsOptionalExist: KProperty<List<View?>>
    lateinit var viewsOptionalAbsent: KProperty<List<View?>>
    lateinit var viewsRequiredFirstExistSecondAbsent: KProperty<List<View>>
    lateinit var viewsOptionalFirstExistSecondAbsent: KProperty<List<View?>>

    lateinit var viewsRequiredExistCorrect: KProperty<List<TextView>>
    lateinit var viewsRequiredExistIncorrect: KProperty<List<TextView>>
    lateinit var viewsRequiredExistFirstViewSecondTextViewCorrect: KProperty<List<View>>
    lateinit var viewsOptionalExistCorrect: KProperty<List<TextView?>>
    lateinit var viewsOptionalExistIncorrect: KProperty<List<TextView?>>
    lateinit var viewsOptionalExistFirstViewSecondTextViewCorrect: KProperty<List<View?>>

    abstract fun getTestableView(): TestableView

    @Before
    fun init() {
        getTestableView().let {
            component = it

            viewRequiredExist = it::viewRequiredExist
            viewRequiredAbsent = it::viewRequiredAbsent
            viewOptionalExist = it::viewOptionalExist
            viewOptionalAbsent = it::viewOptionalAbsent

            textViewRequiredCorrect = it::textViewRequiredCorrect
            textViewRequiredIncorrect = it::textViewRequiredIncorrect
            textViewOptionalCorrect = it::textViewOptionalCorrect
            textViewOptionalIncorrect = it::textViewOptionalIncorrect

            viewsRequiredExist = it::viewsRequiredExist
            viewsRequiredAbsent = it::viewsRequiredAbsent
            viewsOptionalExist = it::viewsOptionalExist
            viewsOptionalAbsent = it::viewsOptionalAbsent
            viewsRequiredFirstExistSecondAbsent = it::viewsRequiredFirstExistSecondAbsent
            viewsOptionalFirstExistSecondAbsent = it::viewsOptionalFirstExistSecondAbsent

            viewsRequiredExistCorrect = it::viewsRequiredExistCorrect
            viewsRequiredExistIncorrect = it::viewsRequiredExistIncorrect
            viewsRequiredExistFirstViewSecondTextViewCorrect = it::viewsRequiredExistFirstViewSecondTextViewCorrect
            viewsOptionalExistCorrect = it::viewsOptionalExistCorrect
            viewsOptionalExistIncorrect = it::viewsOptionalExistIncorrect
            viewsOptionalExistFirstViewSecondTextViewCorrect = it::viewsOptionalExistFirstViewSecondTextViewCorrect
        }
    }

    @Test
    fun testOneRequiredViewExist() {
        viewRequiredExist.call()
    }

    @Test
    fun testOneRequiredViewAbsent() {
        exceptionRule.expect(IllegalStateException::class.java)
        viewRequiredAbsent.get()
    }

    @Test
    fun testOneOptionalViewExist() {
        assertNotNull(viewOptionalExist.get())
    }

    @Test
    fun testOneOptionalViewNotExist() {
        assertNull(viewOptionalAbsent.get())
    }

    @Test
    fun testOneRequiredViewExistAndCorrectClass() {
        assertTrue(textViewRequiredCorrect.get() is TextView)
    }

    @Test
    fun testOneRequiredViewExistAndIncorrectClass() {
        exceptionRule.expect(ClassCastException::class.java)
        assertFalse(textViewRequiredIncorrect.get() is LinearLayout)
    }

    @Test
    fun testOneOptionalViewExistAndCorrectClass() {
        assertNotNull(textViewOptionalCorrect.get())
        assertTrue(textViewOptionalCorrect.get() is TextView)
    }

    @Test
    fun testOneOptionalViewExistAndIncorrectClass() {
        exceptionRule.expect(ClassCastException::class.java)
        assertFalse(textViewOptionalIncorrect.get() is LinearLayout)
    }

    @Test
    fun testManyRequiredViewAllExist() {
        val size = viewsRequiredExist.get().filterNotNull().size
        assertEquals(size, 2)
    }

    @Test
    fun testManyRequiredViewAllAbsent() {
        exceptionRule.expect(IllegalStateException::class.java)
        exceptionRule.expectMessage(component::class.java.simpleName)
        exceptionRule.expectMessage(NO_VIEW1.toString())
        exceptionRule.expectMessage(NO_VIEW2.toString())
        exceptionRule.expectMessage(viewsRequiredAbsent.name)
        viewsRequiredAbsent.get()
    }

    @Test
    fun testManyOptionalViewAllExist() {
        val size = viewsOptionalExist.get().filterNotNull().size
        assertEquals(size, 2)
    }

    @Test
    fun testManyOptionalViewAllAbsent() {
        val size = viewsOptionalAbsent.get().size
        assertEquals(size, 2)
        val nonNullSize = viewsOptionalAbsent.get().filterNotNull().size
        assertEquals(nonNullSize, 0)
    }

    @Test
    fun testManyRequiredFirstExistSecondAbsent() {
        exceptionRule.expect(IllegalStateException::class.java)
        exceptionRule.expectMessage(component::class.java.simpleName)
        exceptionRule.expectMessage(NO_VIEW1.toString())
        exceptionRule.expectMessage(viewsRequiredFirstExistSecondAbsent.name)
        viewsRequiredFirstExistSecondAbsent.get()
    }

    @Test
    fun testManyOptionalFirstExistSecondAbsent() {
        val viewList = viewsOptionalFirstExistSecondAbsent.get()
        assertEquals(viewList.size, 2)
        assertNotNull(viewList.first())
        assertNull(viewList.last())
    }

    @Test
    fun testManyRequiredAllExistAndCorrectClass() {
        val viewList = viewsRequiredExistCorrect.get()
        assertEquals(viewList.size, 2)
        assertEquals(viewList.filterIsInstance<TextView>().size, 2)
    }

    @Test
    fun testManyRequiredAllExistAndIncorrectClass() {
        exceptionRule.expect(ClassCastException::class.java)
        viewsRequiredExistIncorrect.get()
    }

    @Test
    fun testManyRequiredAllDifferentClassCorrect() {
        val viewList = viewsOptionalExistFirstViewSecondTextViewCorrect.get()
        assertEquals(viewList.size, 2)
        assertTrue(viewList.first() is View)
        assertTrue(viewList.last() is TextView)
    }
}
