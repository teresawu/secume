package uk.co.spltech.secume.ui.home.fragment

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.OnLifecycleEvent
import io.reactivex.subjects.BehaviorSubject
import uk.co.spltech.secume.ui.base.DisposingViewModel

class HomeViewModel(val homeRepository: HomeRepository) : DisposingViewModel() {

    val stateSubject: BehaviorSubject<HomeState> = BehaviorSubject.create()

    val homeState = HomeState()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun getChannel() {
        add(homeRepository.getNews()
            .doOnSubscribe {
                stateSubject.onNext(homeState.copy(loading = true, loaded = false, error = false))
            }
            .map {
                stateSubject.onNext(homeState.copy(loading = false, loaded = true, error = false, newsList = it))
            }
            .onErrorReturn {
                stateSubject.onNext(homeState.copy(loading = false, loaded = false, error = true))
            }
            .subscribe()
        )
    }
}
