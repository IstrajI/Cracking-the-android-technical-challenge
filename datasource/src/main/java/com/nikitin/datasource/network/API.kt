package com.nikitin.datasource.network

import com.nikitin.datasource.search.remote.model.ResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface API {
    @Headers("Content-Type: application/json")
    @GET("search/repositories")
    suspend fun makeGet(
        @Query("q") name: String
    ): Response<ResponseModel>
}