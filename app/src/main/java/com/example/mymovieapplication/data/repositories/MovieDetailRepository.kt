package com.example.mymovieapplication.data.repositories

import MovieDetail
import com.example.mymovieapplication.data.network.ApiInterface
import com.example.mymovieapplication.data.network.SafeApiRequest


class MovieDetailRepository(
    private val api: ApiInterface
) : SafeApiRequest() {

    suspend fun getMovieDetail(
        title: String,
        apiKey: String
    ): MovieDetail {

        return apiRequest { api.getMovieDetailData(title, apiKey) }
    }


}