package by.naxa.thepassionofkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

/**
 * Faculty data class.
 * Created on 7/10/2015.
 * @author phomal
 */
public data class Faculty(@Expose @SerializedName("id") val gId: Long,
                          @Expose var name: String) {

    var students: List<Student> = ArrayList()

    class ResultList(val results: List<Faculty>? = null)

}
