package micarroo.victor.com.micarroo.presenters.map

import android.content.Context
import android.util.AndroidException
import android.util.Log
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import micarroo.victor.com.micarroo.BuildConfig
import micarroo.victor.com.micarroo.MainApplication
import micarroo.victor.com.micarroo.network.GmsRequest
import micarroo.victor.com.micarroo.network.response.GmsResponse
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by victorpalmacarrasco on 1/1/18.
 *
 */
class MapInteractorImpl(context: Context): MapInteractor {
    @Inject lateinit var gmsRequest:GmsRequest
    private var disposableAddressTypedKey:Disposable? = null
    private var disposableAddressCoordinates:Disposable? = null

    init {
        (context as MainApplication).component.inject(this)
    }


    // ---------------------------------------------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------ INTERACTOR IMPLEMENTATION ------------------------------------------------------------
    override fun requestAddressListByTypedKey(typedKey: String, requestListener: MapInteractor.RequestListener) {
        val params = getParamsHashMap()
        params.put("address", typedKey)

        disposableAddressTypedKey = gmsRequest.getAddressByCoordinates(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            t: Response<GmsResponse> ->
                            Log.i("MiCarroo", "MapInteractorImpl - requestAddressListByTypedKey - Response :: $t")
                        },
                        {
                            error ->
                            Log.i("MiCarroo", "MapInteractorImpl - requestAddressListByTypedKey - error :: $error")
                            requestListener.onAddressListUnavailable()
                        }
                )
    }

    override fun requestAddressByCoordinates(latitude: Long, longitude: Long, requestListener: MapInteractor.RequestListener):
            Pair<GmsResponse?, String?> {

        val params = getParamsHashMap()
        params.put("latlng", "$latitude,$longitude")

        val call:Call<GmsResponse> = gmsRequest.getAddressByCoordinatesTest(params)

        return try {
            val response: Response<GmsResponse> = call.execute()

            if (response.isSuccessful) {
                Pair(response.body(), null)
            } else {
                Pair(null, "Unsuccessful response")
            }
        } catch (error:Exception) {
            Pair(null, error.localizedMessage)
        }

//        disposableAddressCoordinates = gmsRequest.getAddressByCoordinates(params)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                        {
//                            t: Response<GmsResponse> ->
//                            Log.i("MiCarroo", "MapInteractorImpl - requestAddressListByTypedKey - Response :: $t")
//                            return@subscribe Pair(t, null)
//                        },
//                        {
//                            error ->
//                            Log.i("MiCarroo", "MapInteractorImpl - requestAddressListByTypedKey - error :: $error")
//                            requestListener.onAddressListUnavailable()
//                            return@subscribe Pair(null, error)
//                        }
//                )
    }

    override fun disposeRequest() {
        disposableAddressTypedKey?.dispose()
        disposableAddressCoordinates?.dispose()
    }


    // ---------------------------------------------------------------------------------------------------------------------------------------------------
    // ------------------------------------------------------------ METHODS AND RUNNABLES ----------------------------------------------------------------
    private fun getParamsHashMap(): HashMap<String, String> {
        val params: HashMap<String, String> = HashMap()
        params.put("key", BuildConfig.GMS_API_KEY)
        return params
    }
}