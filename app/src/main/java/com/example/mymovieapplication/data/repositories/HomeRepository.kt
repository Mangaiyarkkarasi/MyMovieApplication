package com.example.mymovieapplication.data.repositories

import SearchResults
import com.example.mymovieapplication.data.network.ApiInterface
import com.example.mymovieapplication.data.network.SafeApiRequest

class HomeRepository(
    private val api: ApiInterface
) : SafeApiRequest() {

    suspend fun getMovies(
        searchTitle: String,
        apiKey: String,
        pageIndex: Int
    ): SearchResults {

        return apiRequest { api.getSearchResultData(searchTitle, apiKey, pageIndex) }
    }


}