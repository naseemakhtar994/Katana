package com.dewarder.katanatest.dimen

import android.content.res.Resources
import com.dewarder.katanatest.get
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import kotlin.reflect.KProperty

abstract class BaseDimenTest {

    @get:Rule
    val exceptionRule = ExpectedException.none();

    private lateinit var dimenRequiredExist: KProperty<Float>
    private lateinit var dimenRequiredAbsent: KProperty<Float>
    private lateinit var dimenOptionalExist: KProperty<Float?>
    private lateinit var dimenOptionalAbsent: KProperty<Float?>

    private lateinit var dimenRequiredExistPx: KProperty<Float>
    private lateinit var dimenRequiredExistDp: KProperty<Float>
    private lateinit var dimenRequiredExistSp: KProperty<Float>
    private lateinit var dimenOptionalExistPx: KProperty<Float?>
    private lateinit var dimenOptionalExistDp: KProperty<Float?>
    private lateinit var dimenOptionalExistSp: KProperty<Float?>

    abstract fun getTestableDimen(): TestableDimen

    @Before
    fun init() {
        getTestableDimen().let {
            dimenRequiredExist = it::dimenRequiredExist
            dimenRequiredAbsent = it::dimenRequiredAbsent
            dimenOptionalExist = it::dimenOptionalExist
            dimenOptionalAbsent = it::dimenOptionalAbsent

            dimenRequiredExistPx = it::dimenRequiredExistPx
            dimenRequiredExistDp = it::dimenRequiredExistDp
            dimenRequiredExistSp = it::dimenRequiredExistSp
            dimenOptionalExistPx = it::dimenOptionalExistPx
            dimenOptionalExistDp = it::dimenOptionalExistDp
            dimenOptionalExistSp = it::dimenOptionalExistSp
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

    @Test
    fun testOneRequiredDimenExistCorrectValues() {
        assertEquals(dimenRequiredExistPx.get(), 8f)
        assertEquals(dimenRequiredExistDp.get(), 8f)
        assertEquals(dimenRequiredExistSp.get(), 8f)
    }

    @Test
    fun testOneOptionalDimenExistCorrectValues() {
        assertNotNull(dimenRequiredExistPx.get())
        assertEquals(dimenRequiredExistPx.get(), 8f)

        assertNotNull(dimenRequiredExistDp.get())
        assertEquals(dimenRequiredExistDp.get(), 8f)

        assertNotNull(dimenRequiredExistSp.get())
        assertEquals(dimenRequiredExistSp.get(), 8f)
    }

}