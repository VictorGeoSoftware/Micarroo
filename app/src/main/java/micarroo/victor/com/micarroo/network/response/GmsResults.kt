package micarroo.victor.com.micarroo.network.response

import micarroo.victor.com.micarroo.data.AddressComponent
import micarroo.victor.com.micarroo.data.Geometry

/**
 * Created by victorpalmacarrasco on 1/1/18.
 * ${APP_NAME}
 */
data class GmsResults(val address_components: ArrayList<AddressComponent>,
                      val formatted_address: String,
                      val geometry:Geometry,
                      val place_id:String,
                      val types:ArrayList<String>)