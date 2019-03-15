package uk.co.spltech.secume.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uk.co.spltech.secume.R
import uk.co.spltech.secume.ui.base.DisposableFragment
import uk.co.spltech.secume.ui.home.fragment.HomeFragment

class CalendarFragment : DisposableFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_calendar, container, false)
        return view
    }

    companion object {
        fun newInstance() = CalendarFragment()
    }
}
