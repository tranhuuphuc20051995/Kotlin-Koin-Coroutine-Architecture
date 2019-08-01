package com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.converters

import androidx.room.TypeConverter
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.tranhuuphuc.kotlinkoincoroutinemvvm.databases.models.*

/**
 * Created by TranHuuPhuc on 2019-08-02.
 */
class MovieConverter {
    private val gson = GsonBuilder().create()

    @TypeConverter
    fun belongsToCollectionToString(belongsToCollection: BelongsToCollection?): String? {
        return belongsToCollection?.let { gson.toJson(belongsToCollection) }
    }

    @TypeConverter
    fun genreIdsToJsonString(genreIds: List<Int>?): String? {
        return genreIds?.let { gson.toJson(genreIds) }
    }

    @TypeConverter
    fun genresToJsonString(genres: List<Genre>?): String? {
        return genres?.let { gson.toJson(genres) }
    }

    @TypeConverter
    fun productionCompanyListToJsonString(listProductionCompany: List<ProductionCompany>?): String? {
        return listProductionCompany?.let { gson.toJson(listProductionCompany) }
    }

    @TypeConverter
    fun productionCountryListToJsonString(listProductionCountry: List<ProductionCountry>?): String? {
        return listProductionCountry?.let { gson.toJson(listProductionCountry) }
    }

    @TypeConverter
    fun spokenLanguagesToJsonString(spokenLanguages: List<SpokenLanguage>?): String? {
        return spokenLanguages?.let { gson.toJson(spokenLanguages) }
    }

    @TypeConverter
    fun jsonStringToBelongsToCollection(json: String?): BelongsToCollection? {
        return json?.let { gson.fromJson(json, object : TypeToken<BelongsToCollection>() {}.type) }
    }

    @TypeConverter
    fun jsonStringToGenreIds(json: String?): List<Int>? {
        return json?.let { gson.fromJson(json, object : TypeToken<List<Int>>() {}.type) }
    }

    @TypeConverter
    fun jsonStringToGenres(json: String?): List<Genre>? {
        return json?.let { gson.fromJson(json, object : TypeToken<List<Genre>>() {}.type) }
    }

    @TypeConverter
    fun jsonStringToProductionCompanies(json: String?): List<ProductionCompany>? {
        return json?.let { gson.fromJson(json, object : TypeToken<List<ProductionCompany>>() {}.type) }
    }

    @TypeConverter
    fun jsonStringToProductionCountries(json: String?): List<ProductionCountry>? {
        return json?.let { gson.fromJson(json, object : TypeToken<List<ProductionCountry>>() {}.type) }
    }

    @TypeConverter
    fun jsonStringToSpokenLanguages(json: String?): List<SpokenLanguage>? {
        return json?.let { gson.fromJson(json, object : TypeToken<List<SpokenLanguage>>() {}.type) }
    }
}