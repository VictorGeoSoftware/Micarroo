package micarroo.victor.com.micarroo.di

import android.content.Context
import dagger.Module
import dagger.Provides
import micarroo.victor.com.micarroo.presenters.map.MapPresenter
import micarroo.victor.com.micarroo.presenters.map.MapPresenterImpl
import javax.inject.Singleton

/**
 * Created by victorpalmacarrasco on 1/1/18.
 */

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideMapPresenter(context: Context): MapPresenter = MapPresenterImpl(context)
}