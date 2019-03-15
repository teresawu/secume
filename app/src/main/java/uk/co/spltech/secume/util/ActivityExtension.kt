package uk.co.spltech.secume.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import uk.co.spltech.secume.R

/**
 * Replace Fragment
 */
fun AppCompatActivity.replaceHomeFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().replace(R.id.containerLayout, fragment).addToBackStack(null)
        .commit()
}

/**
 * Add Fragment to Activity
 */
fun AppCompatActivity.addHomeFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().add(R.id.containerLayout, fragment).addToBackStack(null).commit()
}