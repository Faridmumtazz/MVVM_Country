package mumtaz.binar.mvvm_country.network

import mumtaz.binar.mvvm_country.model.GetAllCountryResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("all")
    fun getAllData(
    ) : Call<List<GetAllCountryResponseItem>>
}