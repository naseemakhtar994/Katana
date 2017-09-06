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

package com.dewarder.katana

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.IdRes
import android.view.View
import com.dewarder.katana.util.*
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

import android.support.v4.app.Fragment as SupportFragment

/**
 * View
 */
fun <V : View> View.view(@IdRes id: Int): ReadOnlyProperty<View, V>
    = requiredView(this, this::viewProvider, id)

fun <V : View> View.viewOptional(@IdRes id: Int): ReadOnlyProperty<View, V?>
    = optionalView(this::viewProvider, id)

fun <V : View> View.views(vararg @IdRes ids: Int): ReadOnlyProperty<View, List<V>>
    = requiredViews(this, this::viewProvider, ids)

fun <V : View> View.viewsOptional(vararg @IdRes ids: Int): ReadOnlyProperty<View, List<V?>>
    = optionalViews(this::viewProvider, ids)


/**
 * Activity
 */
fun <V : View> Activity.view(@IdRes id: Int): ReadOnlyProperty<Activity, V>
    = requiredView(this, this::viewProvider, id)

fun <V : View> Activity.viewOptional(@IdRes id: Int): ReadOnlyProperty<Activity, V?>
    = optionalView(this::viewProvider, id)

fun <V : View> Activity.views(vararg @IdRes ids: Int): ReadOnlyProperty<Activity, List<V>>
    = requiredViews(this, this::viewProvider, ids)

fun <V : View> Activity.viewsOptional(vararg @IdRes ids: Int): ReadOnlyProperty<Activity, List<V?>>
    = optionalViews(this::viewProvider, ids)


/**
 * Fragment
 */
fun <V : View> Fragment.view(@IdRes id: Int): ReadOnlyProperty<Fragment, V>
    = requiredView(this, this::viewProvider, id)

fun <V : View> Fragment.viewOptional(@IdRes id: Int): ReadOnlyProperty<Fragment, V?>
    = optionalView(this::viewProvider, id)

fun <V : View> Fragment.views(vararg @IdRes ids: Int): ReadOnlyProperty<Fragment, List<V>>
    = requiredViews(this, this::viewProvider, ids)

fun <V : View> Fragment.viewsOptional(vararg @IdRes ids: Int): ReadOnlyProperty<Fragment, List<V?>>
    = optionalViews(this::viewProvider, ids)


/**
 * Dialog
 */
fun <V : View> Dialog.view(@IdRes id: Int): ReadOnlyProperty<Dialog, V>
    = requiredView(this, this::viewProvider, id)

fun <V : View> Dialog.viewOptional(@IdRes id: Int): ReadOnlyProperty<Dialog, V?>
    = optionalView(this::viewProvider, id)

fun <V : View> Dialog.views(vararg @IdRes ids: Int): ReadOnlyProperty<Dialog, List<V>>
    = requiredViews(this, this::viewProvider, ids)

fun <V : View> Dialog.viewsOptional(vararg @IdRes ids: Int): ReadOnlyProperty<Dialog, List<V?>>
    = optionalViews(this::viewProvider, ids)


/**
 * SupportFragment
 */
fun <V : View> SupportFragment.view(@IdRes id: Int): ReadOnlyProperty<SupportFragment, V>
    = requiredView(this, this::viewProvider, id)

fun <V : View> SupportFragment.viewOptional(@IdRes id: Int): ReadOnlyProperty<SupportFragment, V?>
    = optionalView(this::viewProvider, id)

fun <V : View> SupportFragment.views(vararg @IdRes ids: Int): ReadOnlyProperty<SupportFragment, List<V>>
    = requiredViews(this, this::viewProvider, ids)

fun <V : View> SupportFragment.viewsOptional(vararg @IdRes ids: Int): ReadOnlyProperty<SupportFragment, List<V?>>
    = optionalViews(this::viewProvider, ids)

/**
 * ViewFinderProvider
 */
fun <V : View> ViewFinderProvider.view(@IdRes id: Int): ReadOnlyProperty<ViewFinderProvider, V>
    = requiredView(this, this::genericViewFinder, id)

fun <V : View> ViewFinderProvider.viewOptional(@IdRes id: Int): ReadOnlyProperty<ViewFinderProvider, V?>
    = optionalView(this::genericViewFinder, id)

fun <V : View> ViewFinderProvider.views(vararg @IdRes ids: Int): ReadOnlyProperty<ViewFinderProvider, List<V>>
    = requiredViews(this, this::genericViewFinder, ids)

fun <V : View> ViewFinderProvider.viewsOptional(vararg @IdRes ids: Int): ReadOnlyProperty<ViewFinderProvider, List<V?>>
    = optionalViews(this::genericViewFinder, ids)

/**
 * Getters
 */
private inline fun <V : View> requiredView(component: Any,
                                           crossinline finder: (KProperty<*>) -> ViewFinder<V>,
                                           @IdRes id: Int): ReadOnlyProperty<Any, V> {

    return Required { property -> finder(property).invoke(id) ?: defaultViewAbsence(component, id, property) }
}

private inline fun <V : View> optionalView(crossinline finder: (KProperty<*>) -> ViewFinder<V>,
                                           @IdRes id: Int): ReadOnlyProperty<Any, V?> {

    return Required { property -> finder(property).invoke(id) }
}

private inline fun <V : View> requiredViews(component: Any,
                                            crossinline finder: (KProperty<*>) -> ViewFinder<V>,
                                            @IdRes ids: IntArray): ReadOnlyProperty<Any, List<V>> {

    return Required { property ->
        val viewProvider = finder(property)
        ids.map { id -> viewProvider.invoke(id) ?: findAbsentViewsAndThrow(component, viewProvider, ids, property) }
    }
}

private inline fun <V : View> optionalViews(crossinline finder: (KProperty<*>) -> ViewFinder<V>,
                                            @IdRes ids: IntArray): ReadOnlyProperty<Any, List<V?>> {
    return Required { property ->
        val viewProvider = finder(property)
        ids.map { id -> viewProvider.invoke(id) }
    }
}

private inline fun findAbsentViewsAndThrow(component: Any,
                                           viewFinder: ViewFinder<View>,
                                           ids: IntArray,
                                           property: KProperty<*>): Nothing {

    val absentIds = ids.filter { id -> viewFinder.invoke(id) == null }
    defaultViewsAbsence(component, absentIds, property)
}