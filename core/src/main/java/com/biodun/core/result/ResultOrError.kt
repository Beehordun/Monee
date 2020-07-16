package com.biodun.core.result

sealed class ResultOrError<out L, out R> {

    data class Error<out L>(val a: L) : ResultOrError<L, Nothing>()

    data class Result<out R>(val b: R) : ResultOrError<Nothing, R>()

    fun <L> error(a: L) = Error(a)

    fun <R> result(b: R) = Result(b)

    fun fold(fnL: (L) -> Any, fnR: (R) -> Any): Any =
        when (this) {
            is Error -> fnL(a)
            is Result -> fnR(b)
        }
}

fun <A, B, C> ((A) -> B).c(f: (B) -> C): (A) -> C = {
    f(this(it))
}

fun <T, L, R> ResultOrError<L, R>.flatMap(fn: (R) -> ResultOrError<L, T>): ResultOrError<L, T> =
    when (this) {
        is ResultOrError.Error -> ResultOrError.Error(a)
        is ResultOrError.Result -> fn(b)
    }

fun <T, L, R> ResultOrError<L, R>.map(fn: (R) -> (T)): ResultOrError<L, T> =
    this.flatMap(fn.c(::result))

fun <L, R> ResultOrError<L, R>.getOrElse(value: R): R =
    when (this) {
        is ResultOrError.Error -> value
        is ResultOrError.Result -> b
    }
