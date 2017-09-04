package com.dewarder.katanatest

import android.os.Bundle
import android.support.test.rule.ActivityTestRule
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import org.junit.Rule

class FragmentViewTest : BaseViewTest() {

    class Activity : AppCompatActivity() {

        lateinit var fragment: TestViewFragment

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            val container = FrameLayout(this).apply {
                id = R.id.action_container
            }
            setContentView(container)
            fragment = TestViewFragment()

            fragmentManager.beginTransaction()
                    .replace(R.id.action_container, fragment)
                    .commit()
        }
    }

    @get:Rule
    val activityRule = ActivityTestRule<Activity>(Activity::class.java)

    override fun getTestableView(): TestableView {
        return activityRule.activity.fragment
    }
}