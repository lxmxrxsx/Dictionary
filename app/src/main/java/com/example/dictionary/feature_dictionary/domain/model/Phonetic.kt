package com.example.dictionary.feature_dictionary.domain.model

data class Phonetic (
    val audio: String,
    val license: License,
    val sourceUrl: String,
    val text: String
)