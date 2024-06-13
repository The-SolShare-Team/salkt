package com.funkatronics.salt

import com.funkatronics.encoders.Base58
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsOnCurveTests {
    @Test
    fun `isOnCurve returns true for known on curve address`() {
        // given
        val address = Base58.decode("7aGCrjwMFDLq92oeSwfADozP7RNk5Rkqoz2ESFUZAT3b")

        // when
        val isOnCurve = TweetNaclFast.isOnCurve(address)

        //
        assertTrue { isOnCurve }
    }

    @Test
    fun `isOnCurve returns false for known off curve address`() {
        // given
        val address = Base58.decode("46GZzzetjCURsdFPb7rcnspbEMnCBXe9kpjrsZAkKb6X")

        // when
        val isOnCurve = TweetNaclFast.isOnCurve(address)

        //
        assertFalse { isOnCurve }
    }
}