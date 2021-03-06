package by.naxa.thepassionofkotlin.network.request

import by.naxa.thepassionofkotlin.model.Student
import by.naxa.thepassionofkotlin.network.api.TheUniversityAPI
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest

/**
 * Created on 7/10/2015.
 * @author phomal
 */
class GetStudentSpiceRequest(val id : Long) :
        RetrofitSpiceRequest<Student, TheUniversityAPI.StudentAPI>(
                Student::class.java, TheUniversityAPI.StudentAPI::class.java) {

    override fun loadDataFromNetwork(): Student? {
        return service.get(id)
    }

}