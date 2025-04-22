package swasi.android.network

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query
import swasi.android.model.MovieResponse
import swasi.android.model.PopularTvShowResponse

/**
 * Created by Sibaprasad Mohanty on 11/03/2023.
 * siba.x.prasad@gmail.com
 */

interface MovieDbApiService {

    @GET("tv/popular?")
    suspend fun getPopularTvShows(page: Int): ResponseBody

    @GET("tv/popular")
    suspend fun getPopularTvShowsByFlow(
        @Query("api_key") apiKey: String = RestConfig.API_TOKEN,
        @Query("language") language: String = RestConfig.LANGUAGE,
        @Query("page") page: Int
    ): PopularTvShowResponse

    // https://api.themoviedb.org/3/movie/popular?
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = RestConfig.API_TOKEN,
        @Query("language") language: String = RestConfig.LANGUAGE
    ): MovieResponse

    @GET("upcoming")
    suspend fun getUpComingMovies(
        @Query("api_key") apiKey: String = RestConfig.API_TOKEN
    ): MovieResponse

}