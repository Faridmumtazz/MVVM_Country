package mumtaz.binar.mvvm_country.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import mumtaz.binar.mvvm_country.R
import mumtaz.binar.mvvm_country.adapter.AdapterCountry
import mumtaz.binar.mvvm_country.viewmodel.ViewModelCountry

class MainActivity : AppCompatActivity() {

    lateinit var countryadapter : AdapterCountry
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countryadapter = AdapterCountry()

        rv_country.layoutManager = LinearLayoutManager(this)
        rv_country.adapter = countryadapter


        initViewModel()
    }

    fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(ViewModelCountry::class.java)
        viewModel.getLDCountry().observe(this, Observer {
            if (it != null){
                countryadapter.setCountryList(it)
                countryadapter.notifyDataSetChanged()
            }
        })
        viewModel.getDataCountry()
    }
}