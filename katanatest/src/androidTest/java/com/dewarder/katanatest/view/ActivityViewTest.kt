package com.dewarder.katanatest.view

import android.support.test.rule.ActivityTestRule
import com.dewarder.katanatest.view.BaseViewTest
import com.dewarder.katanatest.view.TestViewActivity
import com.dewarder.katanatest.view.TestableView
import org.junit.Rule

class ActivityViewTest : BaseViewTest() {

    @get:Rule
    val activityRule = ActivityTestRule<TestViewActivity>(TestViewActivity::class.java)

    override fun getTestableView(): TestableView {
        return activityRule.activity
    }
}