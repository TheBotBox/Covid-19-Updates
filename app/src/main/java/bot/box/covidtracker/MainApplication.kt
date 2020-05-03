package bot.box.covidtracker

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import bot.box.covidtracker.di.koinApplicationModule
import bot.box.covidtracker.di.koinNetworkModule
import bot.box.covidtracker.di.koinViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : MultiDexApplication() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(base)
    }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MainApplication)
            modules(
                listOf(
                    koinNetworkModule,
                    koinApplicationModule,
                    koinViewModel
                )
            )
        }
    }
}