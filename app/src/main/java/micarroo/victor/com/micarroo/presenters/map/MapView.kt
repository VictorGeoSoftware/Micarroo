package micarroo.victor.com.micarroo.presenters.map

/**
* Created by victorpalmacarrasco on 27/12/17.
* ${APP_NAME}
*/
interface MapView {
    fun onAddressReturned(address:String)
    fun onAddressKo()
    fun onAddressListReturned(address:ArrayList<String>)
    fun onAddressListKo()
}