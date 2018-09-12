package by.naxa.thepassionofkotlin.network.api

import by.naxa.thepassionofkotlin.model.Faculty
import by.naxa.thepassionofkotlin.model.Student
import retrofit.http.GET
import retrofit.http.Path

/**
 * Created on 7/10/2015.
 * @author phomal
 */
interface TheUniversityAPI {

    interface FacultyAPI {
        @GET("/faculty/list/rest")
        fun getList(): List<Faculty>

        @GET("/faculty/{id}/rest")
        fun get(@Path("id") id : Long): Faculty
    }

    interface StudentAPI {
        @GET("/student/list/rest")
        fun getList(): List<Student>

        @GET("/student/{id}/rest")
        fun get(@Path("id") id : Long): Student
    }

}