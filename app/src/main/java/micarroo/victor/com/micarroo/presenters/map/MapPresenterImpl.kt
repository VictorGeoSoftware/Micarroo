package micarroo.victor.com.micarroo.presenters.map

import android.content.Context

/**
 * Created by victorpalmacarrasco on 27/12/17.
 *
 */

class MapPresenterImpl(context: Context): MapPresenter, MapInteractor.RequestListener {
    var mapView:MapView? = null
    var mapInteractor:MapInteractor = MapInteractorImpl(context)


    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------- PRESENTER INTERFACE -------------------------------------------------------------------
    override fun setView(mapView: MapView) {
        this.mapView = mapView
    }

    override fun onDestroy() {
        mapInteractor.disposeRequest()
        mapView = null
    }


    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------- INTERACTOR IMPLEMENTATION--------------------------------------------------------------
    override fun onAddressAvailable(address: String) {
        mapView?.onAddressReturned(address)
    }

    override fun onAddressUnavailable() {
        mapView?.onAddressKo()
    }

    override fun onAddressListAvailable(addressList: ArrayList<String>) {
        mapView?.onAddressListReturned(addressList)
    }

    override fun onAddressListUnavailable() {
        mapView?.onAddressListKo()
    }
}