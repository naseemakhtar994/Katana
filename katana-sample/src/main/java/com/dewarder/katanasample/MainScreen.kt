/*
 * Copyright (C) 2017 Artem Glugovsky
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.dewarder.katanasample

import android.animation.ValueAnimator
import android.content.Context
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import com.dewarder.katana.*

class MainScreen : ViewFinderProvider, ContextProvider {

    private lateinit var context: Context
    private lateinit var rootView: View

    private val elementContainer: FrameLayout by view(R.id.element_container)
    private val elementLabel: TextView by view(R.id.element_label)

    private val elementContainerStartSize by dimen(R.dimen.element_container_size_start)
    private val elementContainerEndSize by dimen(R.dimen.element_container_size_end)
    private val elementLabelStartTextSize by dimen(R.dimen.element_label_text_size_start, DimensionType.SP)
    private val elementLabelEndTextSize by dimen(R.dimen.element_label_text_size_end, DimensionType.SP)

    fun init(container: View) {
        context = container.context.applicationContext
        rootView = container
    }

    fun startTransition() {
        createAnimator(state = false).start()
    }

    fun revertTransition() {
        createAnimator(state = true).start()
    }

    private fun createAnimator(state: Boolean): ValueAnimator {
        val fromContainerSize: Float
        val fromLabelTextSize: Float
        val toContainerSize: Float
        val toLabelTextSize: Float

        if (state) {
            fromContainerSize = elementContainerEndSize
            fromLabelTextSize = elementLabelEndTextSize
            toContainerSize = elementContainerStartSize
            toLabelTextSize = elementLabelStartTextSize
        } else {
            fromContainerSize = elementContainerStartSize
            fromLabelTextSize = elementLabelStartTextSize
            toContainerSize = elementContainerEndSize
            toLabelTextSize = elementLabelEndTextSize
        }

        return ValueAnimator.ofFloat(0f, 1f).apply {
            addUpdateListener {
                val progress = it.animatedValue as Float

                val size = toContainerSize + (fromContainerSize - toContainerSize) * progress
                elementContainer.layoutParams.apply {
                    width = size.toInt()
                    height = size.toInt()
                }
                elementContainer.requestLayout()
            }
        }
    }

    override fun provideViewFinder() = rootView::findViewById

    override fun provideContext() = context
}