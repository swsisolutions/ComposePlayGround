package com.swasi.domain.moviedb

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

const val BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w500"

@Parcelize
data class PopularTvShowResponse(
    @SerializedName("page") var page: Int? = null,
    @SerializedName("results") var results: ArrayList<ItemResult> = arrayListOf(),
    @SerializedName("total_pages") var totalPages: Int? = null,
    @SerializedName("total_results") var totalResults: Int? = null
) : Parcelable

@Parcelize
data class ItemResult(
    @SerializedName("backdrop_path") var backdropPath: String? = null,
    @SerializedName("first_air_date") var firstAirDate: String? = null,
    @SerializedName("genre_ids") var genreIds: ArrayList<Int> = arrayListOf(),
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("origin_country") var originCountry: ArrayList<String> = arrayListOf(),
    @SerializedName("original_language") var originalLanguage: String? = null,
    @SerializedName("original_name") var originalName: String? = null,
    @SerializedName("overview") var overview: String? = null,
    @SerializedName("popularity") var popularity: Double? = null,
    @SerializedName("poster_path") var posterPath: String? = null,
    @SerializedName("vote_average") var voteAverage: Double? = null,
    @SerializedName("vote_count") var voteCount: Int? = null
) : Parcelable {
    var fullImageUrl = "$BASE_IMAGE_URL${posterPath}"
}