package com.example.newsapptask.data

import androidx.room.TypeConverter
import com.example.newsapptask.model.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}