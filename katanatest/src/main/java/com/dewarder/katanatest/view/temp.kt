package com.dewarder.katanatest.view

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.dewarder.katana.*
import com.dewarder.katanatest.view.TestableView

class TestViewViewFinderProvider(val view: android.view.View) : com.dewarder.katana.ViewFinderProvider, com.dewarder.katanatest.view.TestableView {

    override val viewRequiredExist: android.view.View by view(com.dewarder.katanatest.R.id.test_view1)
    override val viewRequiredAbsent: android.view.View by view(com.dewarder.katanatest.NO_VIEW1)
    override val viewOptionalExist: android.view.View? by viewOptional(com.dewarder.katanatest.R.id.test_view1)
    override val viewOptionalAbsent: android.view.View? by viewOptional(com.dewarder.katanatest.NO_VIEW1)

    override val textViewRequiredCorrect: android.widget.TextView by view(com.dewarder.katanatest.R.id.test_text_view1)
    override val textViewRequiredIncorrect: android.widget.LinearLayout by view(com.dewarder.katanatest.R.id.test_text_view1)
    override val textViewOptionalCorrect: android.widget.TextView? by viewOptional(com.dewarder.katanatest.R.id.test_text_view1)
    override val textViewOptionalIncorrect: android.widget.LinearLayout? by viewOptional(com.dewarder.katanatest.R.id.test_text_view1)

    override val viewsRequiredExist: List<android.view.View> by views(com.dewarder.katanatest.R.id.test_view1, com.dewarder.katanatest.R.id.test_view2)
    override val viewsRequiredAbsent: List<android.view.View> by views(com.dewarder.katanatest.NO_VIEW1, com.dewarder.katanatest.NO_VIEW2)
    override val viewsOptionalExist: List<android.view.View?> by viewsOptional(com.dewarder.katanatest.R.id.test_view1, com.dewarder.katanatest.R.id.test_view2)
    override val viewsOptionalAbsent: List<android.view.View?> by viewsOptional(com.dewarder.katanatest.NO_VIEW1, com.dewarder.katanatest.NO_VIEW2)
    override val viewsRequiredFirstExistSecondAbsent: List<android.view.View> by views(com.dewarder.katanatest.R.id.test_view1, com.dewarder.katanatest.NO_VIEW1)
    override val viewsOptionalFirstExistSecondAbsent: List<android.view.View?> by viewsOptional(com.dewarder.katanatest.R.id.test_view1, com.dewarder.katanatest.NO_VIEW1)

    override val viewsRequiredExistCorrect: List<android.widget.TextView> by views(com.dewarder.katanatest.R.id.test_text_view1, com.dewarder.katanatest.R.id.test_text_view2)
    override val viewsRequiredExistIncorrect: List<android.widget.TextView> by views(com.dewarder.katanatest.R.id.test_text_view1, com.dewarder.katanatest.R.id.test_view1)
    override val viewsRequiredExistFirstViewSecondTextViewCorrect: List<android.view.View> by views(com.dewarder.katanatest.R.id.test_view1, com.dewarder.katanatest.R.id.test_text_view1)
    override val viewsOptionalExistCorrect: List<android.widget.TextView?> by viewsOptional(com.dewarder.katanatest.R.id.test_text_view1, com.dewarder.katanatest.R.id.test_text_view2)
    override val viewsOptionalExistIncorrect: List<android.widget.TextView?> by viewsOptional(com.dewarder.katanatest.R.id.test_text_view1, com.dewarder.katanatest.R.id.test_view1)
    override val viewsOptionalExistFirstViewSecondTextViewCorrect: List<android.view.View?> by viewsOptional(com.dewarder.katanatest.R.id.test_view1, com.dewarder.katanatest.R.id.test_text_view1)

    override fun provideViewFinder(): com.dewarder.katana.ViewFinder<android.view.View> {
        return view::findViewById
    }
}