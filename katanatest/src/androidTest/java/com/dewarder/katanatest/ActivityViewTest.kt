package com.dewarder.katanatest

import android.support.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule

class ActivityViewTest : BaseViewTest() {

    @get:Rule
    val activityRule = ActivityTestRule<TestViewActivity>(TestViewActivity::class.java)

    @Before
    fun init() {
        activityRule.activity.let {
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