package by.naxa.thepassionofkotlin.network.request

import by.naxa.thepassionofkotlin.model.Student
import by.naxa.thepassionofkotlin.network.api.TheUniversityAPI
import com.octo.android.robospice.request.retrofit.RetrofitSpiceRequest

/**
 * Created on 7/10/2015.
 * @author phomal
 */
class GetListStudentSpiceRequest : RetrofitSpiceRequest<Student.ResultList, TheUniversityAPI.StudentAPI>(
        Student.ResultList::class.java, TheUniversityAPI.StudentAPI::class.java) {

    override fun loadDataFromNetwork(): Student.ResultList {
        return Student.ResultList(getService().getList())
    }

}