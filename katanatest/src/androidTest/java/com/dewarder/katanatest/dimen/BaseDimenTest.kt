package com.dewarder.katanatest.dimen

import android.content.res.Resources
import com.dewarder.katanatest.get
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import kotlin.reflect.KProperty

abstract class BaseDimenTest {

    @get:Rule
    val exceptionRule = ExpectedException.none();

    lateinit var component: Any

    lateinit var dimenRequiredExist: KProperty<Float>
    lateinit var dimenRequiredAbsent: KProperty<Float>
    lateinit var dimenOptionalExist: KProperty<Float?>
    lateinit var dimenOptionalAbsent: KProperty<Float?>

    abstract fun getTestableDimen(): TestableDimen

    @Before
    fun init() {
        getTestableDimen().let {
            dimenRequiredExist = it::dimenRequiredExist
            dimenRequiredAbsent = it::dimenRequiredAbsent
            dimenOptionalExist = it::dimenOptionalExist
            dimenOptionalAbsent = it::dimenOptionalAbsent
        }
    }

    @Test
    fun testOneRequiredDimenExist() {
        dimenRequiredExist.get()
    }

    @Test
    fun testOneRequiredDimenAbsent() {
        exceptionRule.expect(Resources.NotFoundException::class.java)
        dimenRequiredAbsent.get()
    }

    @Test
    fun testOneOptionalDimenExist() {
        assertNotNull(dimenOptionalExist.get())
    }

    @Test
    fun testOneOptionalDimenAbsent() {
        assertNull(dimenOptionalAbsent.get())
    }
}