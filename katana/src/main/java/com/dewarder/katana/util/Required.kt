package com.dewarder.katana.util

import kotlin.reflect.KProperty

class Required<R, T>(
        private val init: (KProperty<*>) -> T) : LazyDelegate<R, T>() {

    override fun initializeValue(ref: R, property: KProperty<*>) = init(property)
}