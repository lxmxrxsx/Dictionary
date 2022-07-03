package com.example.dictionary.feature_dictionary.di

import org.koin.core.module.Module

val appModule: List<Module> = listOf(dataModule, presentationModule)