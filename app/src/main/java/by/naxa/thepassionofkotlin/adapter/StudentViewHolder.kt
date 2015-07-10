package by.naxa.thepassionofkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import by.naxa.thepassionofkotlin.R
import com.yoavst.kotlin.findView

/**
 * Created on 7/10/2015.
 * @author phomal
 */
public class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.findView<TextView>(R.id.tvStudentName)
    val tvFaculty = itemView.findView<TextView>(R.id.tvStudentFaculty)
}