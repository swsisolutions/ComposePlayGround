package com.swasi.sideeffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember


/**
 * SideEffect: publish Compose state to non-Compose code
 */

@Composable
fun sideEffectExample(user: SideEffectUser): FirebaseAnalytics {

    val analytics: FirebaseAnalytics = remember {
        FirebaseAnalytics()
    }

    // On every successful composition, update FirebaseAnalytics with
    // the userType from the current User, ensuring that future analytics
    // events have this metadata attached
    SideEffect {
        analytics.setUserProperty("userType", "SuperUser")
    }
    return analytics
}


data class SideEffectUser(val name: String)

class FirebaseAnalytics {
    val analyticsHashmap = mutableMapOf<String, String>()
    fun setUserProperty(name: String, type: String) {
        analyticsHashmap.put(name, type)
    }
}