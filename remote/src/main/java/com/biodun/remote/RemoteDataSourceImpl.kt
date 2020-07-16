package com.biodun.remote

import com.biodun.core.result.Failure
import com.biodun.core.result.ResultOrError.Result
import com.biodun.core.result.ResultOrError
import com.biodun.core.result.Failure.NotFoundFailure
import com.biodun.data.model.CardInfoModel
import com.biodun.data.remote.RemoteDataSource
import retrofit2.HttpException
import java.io.InterruptedIOException
import java.net.UnknownHostException
import javax.inject.Inject

const val NOT_FOUND = 404

class RemoteDataSourceImpl @Inject constructor(private val moneeApi: MoneeApi) : RemoteDataSource {

    override suspend fun getCardInfo(cardNumber: String): ResultOrError<Failure, CardInfoModel> {
        return try {
            Result(moneeApi.getCardInfo(cardNumber))
        } catch (exception: HttpException) {
            when (exception.code()) {
                NOT_FOUND -> ResultOrError.Error(NotFoundFailure)
                else -> ResultOrError.Error(Failure.ServerFailure)
            }
        } catch (exception: UnknownHostException) {
            ResultOrError.Error(Failure.NoInternetFailure)
        } catch (exception: InterruptedIOException) {
            ResultOrError.Error(Failure.TimeoutFailure)
        }
    }
}
