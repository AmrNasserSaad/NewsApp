package com.example.newsapp.domain.manger

import kotlinx.coroutines.flow.Flow

interface LocalUserManger {

    suspend fun saveAppMangerEntry()

    fun readAppMangerEntry() : Flow<Boolean>
}