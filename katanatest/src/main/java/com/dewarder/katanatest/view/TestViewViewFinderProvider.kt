package com.dewarder.katanatest.view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.dewarder.katana.*
import com.dewarder.katanatest.NO_VIEW1
import com.dewarder.katanatest.NO_VIEW2
import com.dewarder.katanatest.R

class TestViewViewFinderProvider(val view: View) : ViewFinderProvider, TestableView {

    override val viewRequiredExist: View by view(R.id.test_view1)
    override val viewRequiredAbsent: View by view(NO_VIEW1)
    override val viewOptionalExist: View? by viewOptional(R.id.test_view1)
    override val viewOptionalAbsent: View? by viewOptional(NO_VIEW1)

    override val textViewRequiredCorrect: TextView by view(R.id.test_text_view1)
    override val textViewRequiredIncorrect: LinearLayout by view(R.id.test_text_view1)
    override val textViewOptionalCorrect: TextView? by viewOptional(R.id.test_text_view1)
    override val textViewOptionalIncorrect: LinearLayout? by viewOptional(R.id.test_text_view1)

    override val viewsRequiredExist: List<View> by views(R.id.test_view1, R.id.test_view2)
    override val viewsRequiredAbsent: List<View> by views(NO_VIEW1, NO_VIEW2)
    override val viewsOptionalExist: List<View?> by viewsOptional(R.id.test_view1, R.id.test_view2)
    override val viewsOptionalAbsent: List<View?> by viewsOptional(NO_VIEW1, NO_VIEW2)
    override val viewsRequiredFirstExistSecondAbsent: List<View> by views(R.id.test_view1, NO_VIEW1)
    override val viewsOptionalFirstExistSecondAbsent: List<View?> by viewsOptional(R.id.test_view1, NO_VIEW1)

    override val viewsRequiredExistCorrect: List<TextView> by views(R.id.test_text_view1, R.id.test_text_view2)
    override val viewsRequiredExistIncorrect: List<TextView> by views(R.id.test_text_view1, R.id.test_view1)
    override val viewsRequiredExistFirstViewSecondTextViewCorrect: List<View> by views(R.id.test_view1, R.id.test_text_view1)
    override val viewsOptionalExistCorrect: List<TextView?> by viewsOptional(R.id.test_text_view1, R.id.test_text_view2)
    override val viewsOptionalExistIncorrect: List<TextView?> by viewsOptional(R.id.test_text_view1, R.id.test_view1)
    override val viewsOptionalExistFirstViewSecondTextViewCorrect: List<View?> by viewsOptional(R.id.test_view1, R.id.test_text_view1)

    override fun provideViewFinder(): ViewFinder<View>
            = view::findViewById
}