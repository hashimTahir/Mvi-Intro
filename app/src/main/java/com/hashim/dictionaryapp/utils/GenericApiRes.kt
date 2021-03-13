/*
 * Copyright (c) 2021/  2/ 5.  Created by Hashim Tahir
 */

package com.hashim.dictionaryapp.utils

import retrofit2.Response
import timber.log.Timber

sealed class GenericApiRes<T> {

    class EmptyRes<T> : GenericApiRes<T>()

    data class SuccessRes<T>(val body: T) : GenericApiRes<T>() {}

    data class ErrorRes<T>(val errorMessage: String) : GenericApiRes<T>()
    companion object {


        fun <T> create(error: Throwable): ErrorRes<T> {
            return ErrorRes(error.message ?: "unknown error")
        }

        fun <T> create(response: Response<T>): GenericApiRes<T> {

            Timber.d("GenericApiResponse: response: ${response}")
            Timber.d("GenericApiResponse: raw: ${response.raw()}")
            Timber.d("GenericApiResponse: headers: ${response.headers()}")
            Timber.d("GenericApiResponse: message: ${response.message()}")

            if (response.isSuccessful) {
                val body = response.body()
                if (body == null || response.code() == 204) {
                    return EmptyRes()
                } else if (response.code() == 401) {
                    return ErrorRes("401 Unauthorized. Token may be invalid.")
                } else {
                    return SuccessRes(body = body)
                }
            } else {
                val msg = response.errorBody()?.string()
                val errorMsg = if (msg.isNullOrEmpty()) {
                    response.message()
                } else {
                    msg
                }
                return ErrorRes(errorMsg ?: "unknown error")
            }
        }
    }

}