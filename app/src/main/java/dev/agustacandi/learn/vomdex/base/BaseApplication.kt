package dev.agustacandi.learn.vomdex.base

import android.app.Application
import dev.agustacandi.learn.core.utils.ConstVal
import dev.agustacandi.learn.vomdex.di.useCaseModule
import dev.agustacandi.learn.vomdex.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val koinModules = mutableListOf(useCaseModule, viewModelModule)
        koinModules.addAll(ConstVal.coreModules)

        startKoin {
            androidContext(this@BaseApplication)
            modules(
                koinModules
            )
        }
    }
}