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

package com.dewarder.katanatest.dimen

import android.support.v7.app.AppCompatActivity
import com.dewarder.katana.DimensionType
import com.dewarder.katana.dimen
import com.dewarder.katana.dimenOptional
import com.dewarder.katanatest.NO_DIMEN1
import com.dewarder.katanatest.R

class TestDimenActivity : AppCompatActivity(), TestableDimen {

    override val dimenRequiredExist by dimen(R.dimen.test_dimen_8dp)
    override val dimenRequiredAbsent by dimen(NO_DIMEN1)
    override val dimenOptionalExist by dimenOptional(R.dimen.test_dimen_8dp)
    override val dimenOptionalAbsent by dimenOptional(NO_DIMEN1)

    override val dimenRequiredExistPx by dimen(R.dimen.test_dimen_8px, DimensionType.PX)
    override val dimenRequiredExistDp by dimen(R.dimen.test_dimen_8dp, DimensionType.DP)
    override val dimenRequiredExistSp by dimen(R.dimen.test_dimen_8sp, DimensionType.SP)
    override val dimenOptionalExistPx by dimen(R.dimen.test_dimen_8px, DimensionType.PX)
    override val dimenOptionalExistDp by dimen(R.dimen.test_dimen_8dp, DimensionType.DP)
    override val dimenOptionalExistSp by dimen(R.dimen.test_dimen_8sp, DimensionType.SP)
}