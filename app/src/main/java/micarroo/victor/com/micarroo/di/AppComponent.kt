package micarroo.victor.com.micarroo.di

import android.app.Application
import dagger.Component
import micarroo.victor.com.micarroo.di.main.MainActivityComponent
import micarroo.victor.com.micarroo.di.main.MainActivityModule
import micarroo.victor.com.micarroo.presenters.map.MapInteractorImpl
import javax.inject.Singleton

/**
 * Created by victorpalmacarrasco on 1/1/18.
 *
 */

@Singleton
@Component(modules = [AppModule::class, PresenterModule::class, NetworkModule::class])
interface AppComponent {
    fun inject(application: Application)
    fun inject(mapInteractorImpl: MapInteractorImpl)
    fun plus(mainActivityModule: MainActivityModule): MainActivityComponent
}