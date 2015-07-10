package by.naxa.thepassionofkotlin.network.request

import by.naxa.thepassionofkotlin.model.Faculty
import by.naxa.thepassionofkotlin.network.api.TheUniversityAPI
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest

/**
 * Created on 7/10/2015.
 * @author phomal
 */
class GetListFacultySpiceRequest : RetrofitSpiceRequest<List<Faculty>, TheUniversityAPI.FacultyAPI>(
        javaClass<List<Faculty>>(), javaClass<TheUniversityAPI.FacultyAPI>()) {

    override fun loadDataFromNetwork(): List<Faculty>? {
        return getService().getList()
    }

}