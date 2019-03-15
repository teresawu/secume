package uk.co.spltech.secume.ui.signup

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_signup.*
import uk.co.spltech.secume.R
import uk.co.spltech.secume.ui.base.DisposableActivity
import uk.co.spltech.secume.ui.home.HomeActivity


class SignupActivity(override val contentView: Int = R.layout.activity_signup) : DisposableActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        textSkip.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}
