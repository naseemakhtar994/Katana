package com.dewarder.katana

import android.content.Context

interface ContextProvider {

    fun provideContext(): Context
}