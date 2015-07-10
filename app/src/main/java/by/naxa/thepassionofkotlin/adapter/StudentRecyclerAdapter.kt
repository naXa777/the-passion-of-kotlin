package by.naxa.thepassionofkotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import by.naxa.thepassionofkotlin.model.Student

/**
 * Created on 7/10/2015.
 * @author phomal
 */
public data class StudentRecyclerAdapter() : RecyclerView.Adapter<StudentViewHolder>() {

    public interface OnClickEvent {
        /**
         * Event triggered when you click on a item of the adapter
         * @param v        view
         * @param position position on the array
         */
        public fun onClick(v: View, position: Int)
    }

    private var mData: MutableList<Student> = arrayListOf<Student>();
    private var mOnClickEvent: OnClickEvent? = null
    private var mRecyclerView: RecyclerView? = null

    public constructor(list : List<Student>?) : this() {
        if (list != null)
            mData.addAll(list)
    }

    override fun getItemCount(): Int = mData.size()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): StudentViewHolder? {
        throw UnsupportedOperationException()
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            v -> mOnClickEvent?.onClick(v, position)
        }
    }

    public fun addItem(item: Student, position: Int) {
        mData.add(position, item)
        notifyItemInserted(position)
    }

    public fun removeItem(item: Student) {
        val position = mData.indexOf(item)
        if (position < 0)
            return
        mData.remove(item)
        notifyItemRemoved(position)
    }

}