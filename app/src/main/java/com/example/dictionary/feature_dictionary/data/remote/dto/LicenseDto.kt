package com.example.dictionary.feature_dictionary.data.remote.dto

import com.example.dictionary.feature_dictionary.domain.model.License

data class LicenseDto(
    val name: String,
    val url: String
){
    fun toLicense() = License(
        name = name,
        url = url
    )
}