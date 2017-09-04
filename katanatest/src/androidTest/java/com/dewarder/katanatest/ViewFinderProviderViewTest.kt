package com.dewarder.katanatest

import android.os.Bundle
import android.support.test.rule.ActivityTestRule
import android.support.v7.app.AppCompatActivity
import org.junit.Rule

class ViewFinderProviderViewTest : BaseViewTest() {

    class Activity : AppCompatActivity() {

        lateinit var viewFinderProvider: TestViewViewFinderProvider

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val view = TestViewView(this)
            viewFinderProvider = TestViewViewFinderProvider(view)
            setContentView(view)
        }
    }

    @get:Rule
    val activityRule = ActivityTestRule<Activity>(Activity::class.java)

    override fun getTestableView(): TestableView {
        return activityRule.activity.viewFinderProvider
    }
}