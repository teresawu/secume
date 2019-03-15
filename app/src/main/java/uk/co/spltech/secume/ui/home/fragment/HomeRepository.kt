package uk.co.spltech.secume.ui.home.fragment

import io.reactivex.Single
import uk.co.spltech.secume.api.ApiService
import uk.co.spltech.secume.model.NewsList
import uk.co.spltech.secume.util.SchedulerProvider

class HomeRepository(
    private val schedulerProvider: SchedulerProvider,
    private val apiService: ApiService
) {

    fun getNews(): Single<NewsList> = getItemFromApi()

    private fun getItemFromApi(): Single<NewsList> {
        return apiService.getNews(1, 20)
            .compose(schedulerProvider.getSchedulersForSingle())
            .flatMap {
                return@flatMap Single.just(it)
            }
    }
}