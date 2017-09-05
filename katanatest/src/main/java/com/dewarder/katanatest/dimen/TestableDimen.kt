package com.dewarder.katanatest.dimen

interface TestableDimen {

    val dimenRequiredExist: Float
    val dimenRequiredAbsent: Float
    val dimenOptionalExist: Float?
    val dimenOptionalAbsent: Float?

    val dimenRequiredExistPx: Float
    val dimenRequiredExistDp: Float
    val dimenRequiredExistSp: Float
    val dimenOptionalExistPx: Float?
    val dimenOptionalExistDp: Float?
    val dimenOptionalExistSp: Float?
}