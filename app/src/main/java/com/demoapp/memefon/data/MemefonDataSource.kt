package com.demoapp.memefon.data

import com.demoapp.memefon.data.models.MemefonResponse

interface MemefonDataSource {
    suspend fun loadData(): MemefonResponse
}