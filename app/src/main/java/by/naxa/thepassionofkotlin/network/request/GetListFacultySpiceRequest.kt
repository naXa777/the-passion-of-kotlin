package by.naxa.thepassionofkotlin.network.request

import by.naxa.thepassionofkotlin.model.Faculty
import by.naxa.thepassionofkotlin.network.api.TheUniversityAPI
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest

/**
 * Created on 7/10/2015.
 * @author phomal
 */
class GetListFacultySpiceRequest : RetrofitSpiceRequest<Faculty.ResultList, TheUniversityAPI.FacultyAPI>(
        Faculty.ResultList::class.java, TheUniversityAPI.FacultyAPI::class.java) {

    override fun loadDataFromNetwork(): Faculty.ResultList {
        return Faculty.ResultList(service.getList())
    }

}