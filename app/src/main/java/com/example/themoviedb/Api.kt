package com.example.themoviedb

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("tv/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String = Constants.APIKEY,
        @Query("page") page: Int
    ): Call<GetMoviesResponse>

}