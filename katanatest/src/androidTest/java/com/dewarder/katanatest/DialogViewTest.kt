package com.dewarder.katanatest

import android.os.Bundle
import android.support.test.rule.ActivityTestRule
import android.support.v7.app.AppCompatActivity
import org.junit.Rule

class DialogViewTest : BaseViewTest() {

    class Activity : AppCompatActivity() {

        lateinit var dialog: TestViewDialog

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            dialog = TestViewDialog(this)
            dialog.show()
        }
    }

    @get:Rule
    val activityRule = ActivityTestRule<Activity>(Activity::class.java)

    override fun getTestableView(): TestableView {
        return activityRule.activity.dialog
    }
}