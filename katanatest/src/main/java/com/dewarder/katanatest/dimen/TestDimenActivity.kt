package com.dewarder.katanatest.dimen

import android.support.v7.app.AppCompatActivity
import com.dewarder.katana.dimen
import com.dewarder.katana.dimenOptional
import com.dewarder.katanatest.NO_DIMEN1
import com.dewarder.katanatest.R

class TestDimenActivity : AppCompatActivity(), TestableDimen {

    override val dimenRequiredExist by dimen(R.dimen.test_dimen_8dp)
    override val dimenRequiredAbsent by dimen(NO_DIMEN1)
    override val dimenOptionalExist by dimenOptional(R.dimen.test_dimen_8dp)
    override val dimenOptionalAbsent by dimenOptional(NO_DIMEN1)
}