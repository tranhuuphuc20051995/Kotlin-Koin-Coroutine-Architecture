package com.tranhuuphuc.kotlinkoincoroutinemvvm.models

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by TranHuuPhuc on 3/25/19.
 */
@Entity
@Parcelize
class Movie : Parcelable, Comparable<Movie> {
    @PrimaryKey
    @SerializedName("id")
    var id: Int? = null
    @SerializedName("genre_ids")
    var genreIds: List<Int>? = null
    @SerializedName("adult")
    var adult: Boolean? = null
    @SerializedName("backdrop_path")
    var backdropPath: String? = null
        get() = "http://image.tmdb.org/t/p/original/" + field!!
    @SerializedName("belongs_to_collection")
    var belongsToCollection: BelongsToCollection? = null
    @SerializedName("budget")
    var budget: Int? = null
    @SerializedName("genres")
    var genres: List<Genre>? = null
    @SerializedName("homepage")
    var homepage: String? = null
    @SerializedName("imdb_id")
    var imdbId: String? = null
    @SerializedName("original_language")
    var originalLanguage: String? = null
    @SerializedName("original_title")
    var originalTitle: String? = null
    @SerializedName("overview")
    var overview: String? = null
    @SerializedName("popularity")
    var popularity: Double? = null
    @SerializedName("poster_path")
    var posterPath: String? = null
        get() = "http://image.tmdb.org/t/p/original/" + field!!
    @SerializedName("production_companies")
    var productionCompanies: List<ProductionCompany>? = null
    @SerializedName("production_countries")
    var productionCountries: List<ProductionCountry>? = null
    @SerializedName("release_date")
    var releaseDate: String? = null
    @SerializedName("revenue")
    var revenue: Int? = null
    @SerializedName("runtime")
    var runtime: Int? = null
    @SerializedName("spoken_languages")
    var spokenLanguages: List<SpokenLanguage>? = null
    @SerializedName("status")
    var status: String? = null
    @SerializedName("tagline")
    var tagline: String? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("video")
    var video: Boolean? = null
    @SerializedName("vote_average")
    var voteAverage: Double? = null
    @SerializedName("vote_count")
    var voteCount: Int? = null

    init {
        genreIds = ArrayList()
        genres = ArrayList()
        productionCompanies = ArrayList()
        productionCountries = ArrayList()
        spokenLanguages = ArrayList()
    }

    override fun compareTo(other: Movie): Int {
        val compare = other as Movie
        return if (compare.title == this.title && compare.runtime == this.runtime && compare.id == this.id) {
            0
        } else 1
    }

    override fun equals(obj: Any?): Boolean {
        if (obj === this) {
            return true
        }
        val movie = obj as Movie?
        return movie!!.id === this.id
    }

    companion object {

        var DIFF_CALLBACK: DiffUtil.ItemCallback<Movie> = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }
}
