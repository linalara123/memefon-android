package com.demoapp.memefon.data

import com.demoapp.memefon.data.models.MemefonResponse
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream

@ActivityRetainedScoped
class MemefonLocalDataSource @Inject constructor() : MemefonDataSource {
    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun loadData(): MemefonResponse {
        return withContext(Dispatchers.IO) {
            return@withContext Json.decodeFromStream(
                MemefonResponse.serializer(),
                javaClass.classLoader?.getResourceAsStream(PATH_FILE_)!!
            )
        }
    }

    companion object {
        internal const val PATH_FILE_ = "res/raw/data_memefon.json"
    }
}