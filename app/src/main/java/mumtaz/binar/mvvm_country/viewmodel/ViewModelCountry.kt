package mumtaz.binar.mvvm_country.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mumtaz.binar.mvvm_country.model.GetAllCountryResponseItem
import mumtaz.binar.mvvm_country.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelCountry : ViewModel(){

    lateinit var liveDataCountry : MutableLiveData<List<GetAllCountryResponseItem>>

    init {
        liveDataCountry = MutableLiveData()
    }

    fun getLDCountry(): MutableLiveData<List<GetAllCountryResponseItem>>{
        return liveDataCountry
    }

    fun getDataCountry(){
        ApiClient.instance.getAllData()
            .enqueue(object : Callback<List<GetAllCountryResponseItem>>{
                override fun onResponse(
                    call: Call<List<GetAllCountryResponseItem>>,
                    response: Response<List<GetAllCountryResponseItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataCountry.postValue(response.body())
                    }else{
                        liveDataCountry.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetAllCountryResponseItem>>, t: Throwable) {
                    liveDataCountry.postValue(null)
                }

            })
    }
}