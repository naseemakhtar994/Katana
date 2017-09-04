package com.dewarder.katanatest

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

interface TestableView {

    val viewRequiredExist: View
    val viewRequiredAbsent: View
    val viewOptionalExist: View?
    val viewOptionalAbsent: View?

    val textViewRequiredCorrect: TextView
    val textViewRequiredIncorrect: LinearLayout
    val textViewOptionalCorrect: TextView?
    val textViewOptionalIncorrect: LinearLayout?

    val viewsRequiredExist: List<View>
    val viewsRequiredAbsent: List<View>
    val viewsOptionalExist: List<View?>
    val viewsOptionalAbsent: List<View?>
    val viewsRequiredFirstExistSecondAbsent: List<View>
    val viewsOptionalFirstExistSecondAbsent: List<View?>

    val viewsRequiredExistCorrect: List<TextView>
    val viewsRequiredExistIncorrect: List<TextView>
    val viewsRequiredExistFirstViewSecondTextViewCorrect: List<View>
    val viewsOptionalExistCorrect: List<TextView?>
    val viewsOptionalExistIncorrect: List<TextView?>
    val viewsOptionalExistFirstViewSecondTextViewCorrect: List<View?>
}