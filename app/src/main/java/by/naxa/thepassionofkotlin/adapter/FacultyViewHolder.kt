package by.naxa.thepassionofkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import by.naxa.thepassionofkotlin.R

/**
 * Created on 7/10/2015.
 * @author phomal
 */
public class FacultyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvName = itemView.findViewById<TextView>(R.id.tvFacultyName)
}