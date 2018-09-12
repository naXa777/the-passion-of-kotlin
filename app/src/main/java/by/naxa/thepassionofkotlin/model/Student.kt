package by.naxa.thepassionofkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Student data class.
 * Created on 7/10/2015.
 * @author phomal
 */
public data class Student(@Expose @SerializedName("id") val gId: Long,
                          @Expose var name: String,
                          @Expose var gender : Gender = Gender.UNKNOWN,
                          @Expose var birthday: Date,
                          @Expose var phone: String,
                          @Expose var faculty: Faculty) {

    @Expose var rates: List<Int> = ArrayList()

    class ResultList(val results: List<Student>)

}
