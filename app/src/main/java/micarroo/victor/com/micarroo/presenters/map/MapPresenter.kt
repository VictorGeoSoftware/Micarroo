package micarroo.victor.com.micarroo.presenters.map

/**
 * Created by victorpalmacarrasco on 27/12/17.
 *
 */
interface MapPresenter {
    fun setView(mapView:MapView)
//    fun requestAddressListByTypedKey(typedKey: String)
//    fun requestAddressByCoordinates(latitude: Long, longitude: Long)
    fun onDestroy()
}