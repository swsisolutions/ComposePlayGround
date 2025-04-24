package com.swasi.ui.common


import androidx.compose.runtime.Immutable
@Immutable
sealed class Resource<out T> {

    /**
     * Represents the initial state or a state where no operation has started yet.
     */
   // data object Idle : Resource<Nothing>() // Or use class if you need constructor params

    /**
     * Represents the loading state, optionally holding progress information.
     */
    data object Loading : Resource<Nothing>() // Often, Loading doesn't need data

    // If you need progress in Loading:
    // data class Loading<T>(val progress: Float? = null) : Resource<T>()

    /**
     * Represents the success state, holding the fetched data.
     * @param data The successfully fetched data of type T.
     */
    data class Success<out T>(val data: T) : Resource<T>()

    /**
     * Represents the error state, holding an error message and optionally a throwable.
     * @param message A user-friendly error message.
     * @param throwable The exception/throwable that caused the error (optional, for logging/debugging).
     */
    data class Error(
        val message: String,
        val throwable: Throwable? = null
    ) : Resource<Nothing>() // Error typically doesn't hold data of type T
}