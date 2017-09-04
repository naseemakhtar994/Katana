package com.dewarder.katanatest.dimen

import android.support.test.rule.ActivityTestRule
import org.junit.Rule

class ActivityDimenTest : BaseDimenTest() {

    @get:Rule
    val activityRule = ActivityTestRule<TestDimenActivity>(TestDimenActivity::class.java)

    override fun getTestableDimen(): TestableDimen {
        return activityRule.activity
    }
}