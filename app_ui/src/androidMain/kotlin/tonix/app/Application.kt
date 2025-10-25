package tonix.app

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level
import tonix.app.di.appModules
import tonix.app.koin.initKoin

class Application: Application() {
    override fun onCreate() {
        super.onCreate()
        setupKoin()
    }

    private fun setupKoin() = initKoin(
        modules = appModules,
        platformCallback = {
            androidContext(this@Application)
            androidLogger(level = Level.ERROR)
        }
    )
}