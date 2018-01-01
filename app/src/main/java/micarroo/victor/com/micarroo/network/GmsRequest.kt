package micarroo.victor.com.micarroo.network

import com.google.gson.JsonObject
import io.reactivex.Observable
import micarroo.victor.com.micarroo.network.response.GmsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap


/**
 * Created by victorpalmacarrasco on 1/1/18.
 * ${APP_NAME}
 */
interface GmsRequest {
    @Headers("Content-Type: application/json;charset=UTF-8")

    @GET("/maps/api/geocode/json")
    fun getAddressByCoordinates(@QueryMap params: HashMap<String, String>): Observable<Response<GmsResponse>>
}