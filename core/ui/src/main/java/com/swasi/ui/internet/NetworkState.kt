package com.swasi.ui.internet

sealed class NetworkState {
    object Connected : NetworkState()
    object Disconnected : NetworkState()
}
