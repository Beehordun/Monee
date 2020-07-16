package com.biodun.core.result

sealed class Failure {
    object NotFoundFailure: Failure()
    object ServerFailure: Failure()
    object TimeoutFailure: Failure()
    object NoInternetFailure: Failure()
}
