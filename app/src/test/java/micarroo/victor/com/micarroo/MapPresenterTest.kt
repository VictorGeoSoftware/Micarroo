package micarroo.victor.com.micarroo

import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.nhaarman.mockito_kotlin.whenever
import micarroo.victor.com.micarroo.presenters.map.MapInteractor
import micarroo.victor.com.micarroo.presenters.map.MapPresenter
import micarroo.victor.com.micarroo.presenters.map.MapPresenterImpl
import micarroo.victor.com.micarroo.presenters.map.MapView
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import com.google.gson.JsonParser



/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MapPresenterTest {
    @Mock lateinit var mapView: MapView
    @Mock lateinit var requestListener: MapInteractor.RequestListener
    @Mock lateinit var mapInteractor: MapInteractor
    @Mock lateinit var context: Context
    lateinit var mapPresenter: MapPresenter

    lateinit var addressProvidingLatLong:JsonObject

    private val mockJsonResponse:String = """{
   "results" : [
      {
         "address_components" : [
            {
               "long_name" : "277",
               "short_name" : "277",
               "types" : [ "street_number" ]
            },
            {
               "long_name" : "Bedford Avenue",
               "short_name" : "Bedford Ave",
               "types" : [ "route" ]
            },
            {
               "long_name" : "Williamsburg",
               "short_name" : "Williamsburg",
               "types" : [ "neighborhood", "political" ]
            },
            {
               "long_name" : "Brooklyn",
               "short_name" : "Brooklyn",
               "types" : [ "sublocality", "political" ]
            },
            {
               "long_name" : "Kings",
               "short_name" : "Kings",
               "types" : [ "administrative_area_level_2", "political" ]
            },
            {
               "long_name" : "New York",
               "short_name" : "NY",
               "types" : [ "administrative_area_level_1", "political" ]
            },
            {
               "long_name" : "United States",
               "short_name" : "US",
               "types" : [ "country", "political" ]
            },
            {
               "long_name" : "11211",
               "short_name" : "11211",
               "types" : [ "postal_code" ]
            }
         ],
         "formatted_address" : "277 Bedford Avenue, Brooklyn, NY 11211, USA",
         "geometry" : {
            "location" : {
               "lat" : 40.714232,
               "lng" : -73.9612889
            },
            "location_type" : "ROOFTOP",
            "viewport" : {
               "northeast" : {
                  "lat" : 40.7155809802915,
                  "lng" : -73.9599399197085
               },
               "southwest" : {
                  "lat" : 40.7128830197085,
                  "lng" : -73.96263788029151
               }
            }
         },
         "place_id" : "ChIJd8BlQ2BZwokRAFUEcm_qrcA",
         "types" : [ "street_address" ]
      }
   ],
   "status" : "OK"
}"""


    // ----------------------------------------------------------------------------------------------------------------
    // --------------------------------------------- NO TESTING FUNCTIONS ---------------------------------------------
    private fun createMockedPresenter():MapPresenter {
        val presenter = MapPresenterImpl(context)
        presenter.mapView = mapView
        return presenter
    }


    // ----------------------------------------------------------------------------------------------------------------
    // --------------------------------------------- TESTING METHODS --------------------------------------------------
    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        mapPresenter = createMockedPresenter()

        val jsonParser = JsonParser()
        addressProvidingLatLong = jsonParser.parse(mockJsonResponse) as JsonObject

        // TODO :: 1º .- pasar addressProvidingLatLong a Objeto GmsResponse y terminar el rsto del test
        // TODO :: 2º .- mirar otro tutorial TDD para contrastar!
    }

    @Test
    fun `my app have to ask for an address providing latitude and longitude`() {
        val latitude: Long = 40.714224.toLong()
        val longitude: Long = (-73.961452).toLong()

        whenever(mapInteractor.requestAddressByCoordinates(latitude, longitude, requestListener)).thenReturn(Pair(addressProvidingLatLong, null))
    }
}
