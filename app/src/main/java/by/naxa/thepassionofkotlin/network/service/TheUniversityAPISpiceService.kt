package by.naxa.thepassionofkotlin.network.service

import by.naxa.thepassionofkotlin.network.api.TheUniversityAPI
import com.google.gson.GsonBuilder
import com.octo.android.robospice.retrofit.RetrofitGsonSpiceService
import retrofit.RestAdapter
import retrofit.converter.Converter
import retrofit.converter.GsonConverter

/**
 * Created on 7/10/2015.
 * @author phomal
 */
class TheUniversityAPISpiceService : RetrofitGsonSpiceService() {

    override fun getServerUrl(): String? {
        return "http://192.168.1.16:8080/university"
    }

    override fun createRestAdapterBuilder(): RestAdapter.Builder? {
        val builder = super.createRestAdapterBuilder()
        builder.setLogLevel(RestAdapter.LogLevel.FULL)
        return builder
    }

    override fun onCreate() {
        super.onCreate()
        addRetrofitInterface(TheUniversityAPI::class.java)
    }

    override fun createConverter(): Converter? {
        return GsonConverter( GsonBuilder()
                .setDateFormat("dd/MM/yyyy")
                .excludeFieldsWithoutExposeAnnotation()
                .create() )
    }
}