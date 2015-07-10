package by.naxa.thepassionofkotlin.network.request

import by.naxa.thepassionofkotlin.model.Faculty
import by.naxa.thepassionofkotlin.network.api.TheUniversityAPI
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest

/**
 * Created on 7/10/2015.
 * @author phomal
 */
class GetFacultySpiceRequest(val id : Long) :
        RetrofitSpiceRequest<Faculty, TheUniversityAPI.FacultyAPI>(
                javaClass<Faculty>(), javaClass<TheUniversityAPI.FacultyAPI>()) {

    override fun loadDataFromNetwork(): Faculty? {
        return getService().get(id)
    }

}