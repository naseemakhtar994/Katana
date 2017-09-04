package com.dewarder.katanatest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.dewarder.katana.view
import com.dewarder.katana.viewOptional
import com.dewarder.katana.views
import com.dewarder.katana.viewsOptional

class TestViewActivity : AppCompatActivity() {

    val viewRequiredExist: View by view(R.id.test_view1)
    val viewRequiredAbsent: View by view(NO_VIEW1)
    val viewOptionalExist: View? by viewOptional(R.id.test_view1)
    val viewOptionalAbsent: View? by viewOptional(NO_VIEW1)

    val textViewRequiredCorrect: TextView by view(R.id.test_text_view1)
    val textViewRequiredIncorrect: LinearLayout by view(R.id.test_text_view1)
    val textViewOptionalCorrect: TextView? by viewOptional(R.id.test_text_view1)
    val textViewOptionalIncorrect: LinearLayout? by viewOptional(R.id.test_text_view1)

    val viewsRequiredExist: List<View> by views(R.id.test_view1, R.id.test_view2)
    val viewsRequiredAbsent: List<View> by views(NO_VIEW1, NO_VIEW2)
    val viewsOptionalExist: List<View?> by viewsOptional(R.id.test_view1, R.id.test_view2)
    val viewsOptionalAbsent: List<View?> by viewsOptional(NO_VIEW1, NO_VIEW2)
    val viewsRequiredFirstExistSecondAbsent: List<View> by views(R.id.test_view1, NO_VIEW1)
    val viewsOptionalFirstExistSecondAbsent: List<View?> by viewsOptional(R.id.test_view1, NO_VIEW1)

    val viewsRequiredExistCorrect: List<TextView> by views(R.id.test_text_view1, R.id.test_text_view2)
    val viewsRequiredExistIncorrect: List<TextView> by views(R.id.test_text_view1, R.id.test_view1)
    val viewsRequiredExistFirstViewSecondTextViewCorrect: List<View> by views(R.id.test_view1, R.id.test_text_view1)
    val viewsOptionalExistCorrect: List<TextView?> by viewsOptional(R.id.test_text_view1, R.id.test_text_view2)
    val viewsOptionalExistIncorrect: List<TextView?> by viewsOptional(R.id.test_text_view1, R.id.test_view1)
    val viewsOptionalExistFirstViewSecondTextViewCorrect: List<View?> by viewsOptional(R.id.test_view1, R.id.test_text_view1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_view)
    }

    companion object {

        const val NO_VIEW1 = 0
        const val NO_VIEW2 = 1
    }
}
