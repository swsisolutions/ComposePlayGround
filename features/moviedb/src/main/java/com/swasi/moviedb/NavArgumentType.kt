package com.swasi.moviedb

import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import com.swasi.domain.moviedb.MovieData


class NavArgumentType : NavType<MovieData>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): MovieData? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): MovieData {
        return Gson().fromJson(value, MovieData::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: MovieData) {
        bundle.putParcelable(key, value)
    }

    override val name: String = "MovieData"
}