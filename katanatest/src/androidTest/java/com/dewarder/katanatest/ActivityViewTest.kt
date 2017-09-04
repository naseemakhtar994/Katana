package com.dewarder.katanatest

import android.support.test.rule.ActivityTestRule
import org.junit.Rule

class ActivityViewTest : BaseViewTest() {

    @get:Rule
    val activityRule = ActivityTestRule<TestViewActivity>(TestViewActivity::class.java)

    override fun getTestableView(): TestableView {
        return activityRule.activity
    }
}