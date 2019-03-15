package uk.co.spltech.secume.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.koin.android.ext.android.inject
import uk.co.spltech.secume.R
import uk.co.spltech.secume.ui.base.DisposableFragment
import uk.co.spltech.secume.util.createLayoutManager

class HomeFragment : DisposableFragment() {

    private val homeViewModel: HomeViewModel by inject()
    private val homeAdapter by lazy { HomeAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        view.homeRecyclerView.layoutManager = createLayoutManager()
        view.homeRecyclerView.adapter = homeAdapter
        lifecycle.addObserver(homeViewModel)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        add(homeViewModel.stateSubject.subscribeBy(
            onNext = ::onStateUpdate,
            onError = {
                setErrorUI()
            }
        ))
    }

    private fun onStateUpdate(state: HomeState) {
        if (state.loading) {
            progressBar.visibility = View.VISIBLE
            txtError.visibility = View.GONE
        } else if (state.loaded) {
            homeRecyclerView.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            txtError.visibility = View.GONE
            homeAdapter.newsList = state.newsList.articles
        } else if (state.error) setErrorUI()
    }

    private fun setErrorUI() {
        progressBar.visibility = View.GONE
        txtError.visibility = View.VISIBLE
        homeRecyclerView.visibility = View.GONE
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}
