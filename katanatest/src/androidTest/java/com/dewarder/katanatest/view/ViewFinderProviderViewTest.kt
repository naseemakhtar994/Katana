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

package com.dewarder.katanatest.view

import android.os.Bundle
import android.support.test.rule.ActivityTestRule
import android.support.v7.app.AppCompatActivity
import com.dewarder.katanatest.view.BaseViewTest
import com.dewarder.katanatest.view.TestViewView
import com.dewarder.katanatest.view.TestViewViewFinderProvider
import com.dewarder.katanatest.view.TestableView
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