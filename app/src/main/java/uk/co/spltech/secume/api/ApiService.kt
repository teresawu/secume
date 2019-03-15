package uk.co.spltech.secume.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import uk.co.spltech.secume.model.NewsList

interface ApiService {
    @GET("everything?q=movies&apiKey=079dac74a5f94ebdb990ecf61c8854b7")
    fun getNews(@Query("page") page: Int, @Query("pageSize") pageSize: Int): Single<NewsList>
}