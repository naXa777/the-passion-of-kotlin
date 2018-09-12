package by.naxa.thepassionofkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import by.naxa.thepassionofkotlin.adapter.StudentRecyclerAdapter
import by.naxa.thepassionofkotlin.model.Student
import by.naxa.thepassionofkotlin.network.request.GetListStudentSpiceRequest
import by.naxa.thepassionofkotlin.network.service.TheUniversityAPISpiceService
import com.octo.android.robospice.SpiceManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.verbose

public class MainActivity : AppCompatActivity(), AnkoLogger {

    val mSpiceMgr : SpiceManager = SpiceManager(TheUniversityAPISpiceService::class.java)

    var mAdapter = StudentRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUp()
        verbose("::onCreate()")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.getItemId()

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        super.onStart()
        mSpiceMgr.start(this)
    }

    override fun onStop() {
        super.onStop()
        mSpiceMgr.shouldStop()
    }

    fun getServiceSpiceManager(): SpiceManager {
        return mSpiceMgr
    }

    private fun setUp() {
        setSupportActionBar(toolbar)
        toolbar.setTitle("Students")

        mainRecyclerView.setLayoutManager(createLayoutManager())
        mainRecyclerView.setAdapter(mAdapter)
        mainSwipeRefreshLayout.setOnRefreshListener{
            refreshContent()
            mainSwipeRefreshLayout.setRefreshing(false)
        }
    }

    private fun refreshContent() {
        mAdapter = StudentRecyclerAdapter(GetListStudentSpiceRequest().loadDataFromNetwork().results as MutableList<Student>)
        mainRecyclerView.setAdapter(mAdapter)
    }

    private fun createLayoutManager(): RecyclerView.LayoutManager {
        return LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}
