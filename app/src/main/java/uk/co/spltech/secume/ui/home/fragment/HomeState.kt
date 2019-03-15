package uk.co.spltech.secume.ui.home.fragment

import uk.co.spltech.secume.model.NewsList

data class HomeState(
    var loading: Boolean = true,
    var loaded: Boolean = false,
    var error: Boolean = false,
    var newsList: NewsList = NewsList()
)