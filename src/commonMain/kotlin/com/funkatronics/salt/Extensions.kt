package com.funkatronics.salt

fun ByteArray.isOnCurve() = TweetNaclFast.isOnCurve(this)