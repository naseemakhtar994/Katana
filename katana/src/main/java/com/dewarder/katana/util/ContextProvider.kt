package com.dewarder.katana.util

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.content.Context
import android.view.View

import android.support.v4.app.Fragment as SupportFragment

/**
 * Native
 */
internal val android.view.View.contextProvider: () -> android.content.Context
    inline get() = this::getContext

internal val Activity.contextProvider: () -> Context
    inline get() = { this }

internal val Fragment.contextProvider: () -> Context
    inline get() = this::getContext

internal val Dialog.contextProvider: () -> Context
    inline get() = this::getContext

/**
 * Support
 */
internal val SupportFragment.contextProvider: () -> Context
    inline get() = this::getContext