package com.example.dictionary.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionary.feature_dictionary.data.util.JsonParser
import com.example.dictionary.feature_dictionary.domain.model.Meaning
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromMeaningsJson(json: String) : List<Meaning>
    = jsonParser.fromJson<ArrayList<Meaning>>(
        json,
        object : TypeToken<ArrayList<Meaning>>(){}.type
    ) ?: emptyList()

    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>): String
    = jsonParser.toJson(
        meanings,
        object : TypeToken<ArrayList<Meaning>>(){}.type
    ) ?: "[]"

    @TypeConverter
    fun fromStringsJson(json: String) : List<String>
            = jsonParser.fromJson<ArrayList<String>>(
        json,
        object : TypeToken<ArrayList<String>>(){}.type
    ) ?: emptyList()

    @TypeConverter
    fun toStringsJson(strings: List<String>): String
            = jsonParser.toJson(
        strings,
        object : TypeToken<ArrayList<String>>(){}.type
    ) ?: "[]"

}