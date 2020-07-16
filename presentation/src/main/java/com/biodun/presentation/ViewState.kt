package com.biodun.presentation

import com.biodun.core.result.Failure

sealed class ViewState <T> {
    class Loading<T> : ViewState<T>()
    class Success<T>(val data: T) : ViewState<T>()
    class Error<T>(val error: Failure) : ViewState<T>()
}
