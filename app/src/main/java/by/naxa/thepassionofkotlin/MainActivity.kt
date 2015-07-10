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
import com.yoavst.kotlin.v
import de.greenrobot.event.EventBus
import kotlinx.android.synthetic.activity_main.mainRecyclerView
import kotlinx.android.synthetic.activity_main.mainSwipeRefreshLayout
import kotlinx.android.synthetic.activity_main.toolbar
import kotlin.properties.Delegates

public class MainActivity : AppCompatActivity() {

    val mSpiceMgr : SpiceManager = SpiceManager(javaClass<TheUniversityAPISpiceService>())

    var mAdapter = StudentRecyclerAdapter();

    override fun onCreate(savedInstanceState: Bundle?) {
        super<AppCompatActivity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUp()
        v("::onCreate()")
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

    override fun onResume() {
        super<AppCompatActivity>.onResume()
        EventBus.getDefault().register(this)
        v("::onResume()")
    }

    override fun onPause() {
        super<AppCompatActivity>.onPause()
        EventBus.getDefault().unregister(this)
        v("::onPause()")
    }

    override fun onStart() {
        super<AppCompatActivity>.onStart()
        mSpiceMgr.start(this)
    }

    override fun onStop() {
        super<AppCompatActivity>.onStop()
        mSpiceMgr.shouldStop()
    }

    fun getServiceSpiceManager(): SpiceManager {
        return mSpiceMgr
    }

    private fun setUp() {
        setSupportActionBar(toolbar)
        toolbar.setTitle("Students")

        mainRecyclerView.setLayoutManager(createLayoutManager());
        mainRecyclerView.setAdapter(mAdapter)
        mainSwipeRefreshLayout.setOnRefreshListener{
            refreshContent()
            mainSwipeRefreshLayout.setRefreshing(false);
        }
    }

    private fun refreshContent() {
        mAdapter = StudentRecyclerAdapter(GetListStudentSpiceRequest().loadDataFromNetwork())
        mainRecyclerView.setAdapter(mAdapter);
    }

    private fun createLayoutManager(): RecyclerView.LayoutManager {
        return LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

}
