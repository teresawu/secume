package uk.co.spltech.secume

import android.app.Application
import org.koin.android.ext.android.startKoin
import uk.co.spltech.secume.di.coreModule
import uk.co.spltech.secume.di.networkModule
import uk.co.spltech.secume.di.repositoryModule
import uk.co.spltech.secume.di.viewModelModule

class SecumeApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(
            this,
            listOf(coreModule, networkModule, repositoryModule, viewModelModule),
            loadPropertiesFromFile = true
        )
    }
}
