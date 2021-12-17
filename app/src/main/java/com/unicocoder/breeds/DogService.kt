package com.unicocoder.breeds

import retrofit2.Response
import retrofit2.http.GET

interface DogService {
    @GET(Constants.RANDOM_URL)
    suspend fun getDog(): Response<DogResponse>
}