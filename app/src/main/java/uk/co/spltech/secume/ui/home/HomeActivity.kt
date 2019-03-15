package uk.co.spltech.secume.ui.home

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.view_tool_bar.*
import uk.co.spltech.secume.R
import uk.co.spltech.secume.ui.base.DisposableActivity
import uk.co.spltech.secume.ui.fragment.CalendarFragment
import uk.co.spltech.secume.ui.fragment.NewsFragment
import uk.co.spltech.secume.ui.fragment.VideoFragment
import uk.co.spltech.secume.ui.home.fragment.HomeFragment
import uk.co.spltech.secume.util.addHomeFragment
import uk.co.spltech.secume.util.replaceHomeFragment

class HomeActivity(override val contentView: Int = R.layout.activity_home) : DisposableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addHomeFragment(HomeFragment.newInstance())
        navigationView.setOnNavigationItemSelectedListener {
            showPrimaryFragment(it.itemId)
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun showPrimaryFragment(menuId: Int) {
        when (menuId) {
            R.id.navigationHome -> {
                replaceHomeFragment(HomeFragment.newInstance())
                toolbarTitle.text = getString(R.string.toolbar_home)
            }

            R.id.navigationCalendar -> {
                replaceHomeFragment(CalendarFragment.newInstance())
                toolbarTitle.text = getString(R.string.toolbar_calendar)
            }

            R.id.navigationVideo -> {
                replaceHomeFragment(VideoFragment.newInstance())
                toolbarTitle.text = getString(R.string.toolbar_video)
            }

            R.id.navigationNews -> {
                replaceHomeFragment(NewsFragment.newInstance())
                toolbarTitle.text = getString(R.string.toolbar_news)
            }
        }
    }
}
