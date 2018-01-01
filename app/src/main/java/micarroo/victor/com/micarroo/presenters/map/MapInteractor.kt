package micarroo.victor.com.micarroo.presenters.map

/**
 * Created by victorpalmacarrasco on 1/1/18.
 *
 */
interface MapInteractor {
    fun requestAddressListByTypedKey(typedKey: String, requestListener: RequestListener)
    fun requestAddressByCoordinates(latitude: Long, longitude: Long, requestListener: RequestListener)
    fun disposeRequest()

    interface RequestListener {
        fun onAddressAvailable(address:String)
        fun onAddressUnavailable()
        fun onAddressListAvailable(addressList:ArrayList<String>)
        fun onAddressListUnavailable()
    }
}