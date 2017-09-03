package com.dewarder.katana

import android.view.View

interface ViewFinderProvider {

    fun provideViewFinder(): ViewFinder<View>
}