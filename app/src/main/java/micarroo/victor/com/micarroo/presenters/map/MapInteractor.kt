package micarroo.victor.com.micarroo.presenters.map

import micarroo.victor.com.micarroo.network.response.GmsResponse
import retrofit2.Response

/**
 * Created by victorpalmacarrasco on 1/1/18.
 *
 */
interface MapInteractor {
    fun requestAddressListByTypedKey(typedKey: String, requestListener: RequestListener)
    fun requestAddressByCoordinates(latitude: Long, longitude: Long, requestListener: RequestListener): Pair<GmsResponse?, String?>
    fun disposeRequest()

    interface RequestListener {
        fun onAddressAvailable(address:String)
        fun onAddressUnavailable()
        fun onAddressListAvailable(addressList:ArrayList<String>)
        fun onAddressListUnavailable()
    }
}