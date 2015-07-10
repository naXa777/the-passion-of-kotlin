package by.naxa.thepassionofkotlin.network.request

import by.naxa.thepassionofkotlin.model.Student
import by.naxa.thepassionofkotlin.network.api.TheUniversityAPI
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest

/**
 * Created on 7/10/2015.
 * @author phomal
 */
class GetListStudentSpiceRequest : RetrofitSpiceRequest<List<Student>, TheUniversityAPI.StudentAPI>(
        javaClass<List<Student>>(), javaClass<TheUniversityAPI.StudentAPI>()) {

    override fun loadDataFromNetwork(): List<Student>? {
        return getService().getList()
    }

}