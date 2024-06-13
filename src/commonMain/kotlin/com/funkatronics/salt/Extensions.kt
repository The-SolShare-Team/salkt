package com.funkatronics.salt

import com.solana.salt.TweetNaclFast

fun ByteArray.isOnCurve() = TweetNaclFast.isOnCurve(this)