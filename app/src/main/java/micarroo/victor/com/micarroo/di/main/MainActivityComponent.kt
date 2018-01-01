package micarroo.victor.com.micarroo.di.main

import dagger.Subcomponent
import micarroo.victor.com.micarroo.MainActivity
import javax.inject.Singleton

/**
 * Created by victorpalmacarrasco on 1/1/18.
 * ${APP_NAME}
 */

@Singleton
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}