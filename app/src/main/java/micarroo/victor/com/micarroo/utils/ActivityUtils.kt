package micarroo.victor.com.micarroo.utils

import android.app.Activity
import micarroo.victor.com.micarroo.MainApplication

/**
 * Created by victorpalmacarrasco on 1/1/18.
 * ${APP_NAME}
 */
class ActivityUtils {
    val Activity.app: MainApplication
        get() = application as MainApplication

}