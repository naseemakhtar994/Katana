@file:Suppress("UNCHECKED_CAST")

package com.dewarder.katana.util

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.view.View
import com.dewarder.katana.ViewFinder
import com.dewarder.katana.ViewFinderProvider
import kotlin.reflect.KProperty
import android.support.v4.app.Fragment as SupportFragment

/**
 * Native
 */
internal fun <V : View> View.viewProvider(property: KProperty<*>): ViewFinder<V>
    = { findViewById(it) as? V }

internal fun <V : View> Activity.viewProvider(property: KProperty<*>): ViewFinder<V>
    = { findViewById(it) as? V }

internal fun <V : View> Fragment.viewProvider(property: KProperty<*>): ViewFinder<V>
    = { ensureFragmentView(this, property).findViewById(it) as? V }

internal fun <V : View> Dialog.viewProvider(property: KProperty<*>): ViewFinder<V>
    = { findViewById(it) as? V }


/**
 * Support
 */
internal fun <V : View> android.support.v4.app.Fragment.viewProvider(property: KProperty<*>): ViewFinder<V>
    = { ensureFragmentView(this, property).findViewById(it) as? V }

/**
 * ViewFinderProvider
 */
internal fun <V : View> ViewFinderProvider.genericViewFinder(property: KProperty<*>): ViewFinder<V>
    = { provideViewFinder().invoke(it) as? V }