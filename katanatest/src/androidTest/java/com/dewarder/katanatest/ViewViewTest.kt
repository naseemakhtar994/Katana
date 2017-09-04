package com.dewarder.katanatest

import android.os.Bundle
import android.support.test.rule.ActivityTestRule
import android.support.v7.app.AppCompatActivity
import org.junit.Before
import org.junit.Rule

class ViewViewTest : BaseViewTest() {

    class Activity : AppCompatActivity() {

        lateinit var view: TestViewView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            view = TestViewView(this)
            setContentView(view)
        }
    }

    @get:Rule
    val activityRule = ActivityTestRule<Activity>(Activity::class.java)

    @Before
    fun init() {
        activityRule.activity.view.let {
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
}