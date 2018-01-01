package micarroo.victor.com.micarroo

import android.app.Application
import micarroo.victor.com.micarroo.di.AppComponent
import micarroo.victor.com.micarroo.di.AppModule
import micarroo.victor.com.micarroo.di.DaggerAppComponent

/**
 * Created by victorpalmacarrasco on 1/1/18.
 *
 */
class MainApplication: Application() {

    val component:AppComponent by lazy {
        DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }


    override fun onCreate() {
        super.onCreate()
        component.inject(this)
    }
}