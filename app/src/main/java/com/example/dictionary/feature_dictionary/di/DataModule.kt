package com.example.dictionary.feature_dictionary.di

import com.example.dictionary.feature_dictionary.data.local.WordInfoDatabase
import com.example.dictionary.feature_dictionary.data.remote.RetrofitConfig
import com.example.dictionary.feature_dictionary.data.repository.WordInfoRepositoryImpl
import com.example.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import com.example.dictionary.feature_dictionary.domain.use_case.GetWordInfo
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {
    single { RetrofitConfig.service }
    single { WordInfoDatabase.create(androidApplication()) }
    single { GetWordInfo(get()) }

    factory<WordInfoRepository> { WordInfoRepositoryImpl(get(),get()) }
}
