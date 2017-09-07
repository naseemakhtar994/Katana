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

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.FrameLayout
import com.dewarder.katana.view

class MainActivity : AppCompatActivity() {

    private val container: FrameLayout by view(R.id.container)
    private val button: Button by view(R.id.button)
    private val mainScreen = MainScreen()

    private var transitionState = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainScreen.init(container)
        button.setOnClickListener {
            if (transitionState) {
                mainScreen.startTransition()
            } else {
                mainScreen.revertTransition()
            }
            transitionState = !transitionState
        }
    }
}