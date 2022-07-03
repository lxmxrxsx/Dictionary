package com.example.dictionary.feature_dictionary.data.local

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dictionary.feature_dictionary.data.local.entity.WordInfoEntity
import com.example.dictionary.feature_dictionary.data.util.GsonParser
import com.google.gson.Gson

@Database(
    entities = [WordInfoEntity::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase: RoomDatabase() {
    abstract val dao: WordInfoDao

    companion object{
        private const val DB_NAME = "words_DB"

        fun create(application: Application): WordInfoDatabase{
            return Room.databaseBuilder(
                application,
                WordInfoDatabase::class.java,
                DB_NAME
            )
                .addTypeConverter(Converters(GsonParser(Gson())))
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}