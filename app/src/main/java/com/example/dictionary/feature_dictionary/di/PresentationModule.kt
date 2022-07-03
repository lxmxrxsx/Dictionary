package com.example.dictionary.feature_dictionary.di

import com.example.dictionary.feature_dictionary.presentation.WordInfoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module{
    viewModel { WordInfoViewModel(get()) }
}