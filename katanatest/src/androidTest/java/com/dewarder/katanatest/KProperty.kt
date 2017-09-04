package com.dewarder.katanatest

import java.lang.reflect.InvocationTargetException
import kotlin.reflect.KProperty

fun <R> KProperty<R>.get(): R {
    return try {
        call()
    } catch (e: InvocationTargetException) {
        val cause = e.cause
        if (cause != null) {
            throw cause
        } else {
            throw e
        }
    }
}