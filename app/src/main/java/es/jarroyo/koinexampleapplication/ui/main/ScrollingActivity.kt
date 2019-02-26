package es.jarroyo.koinexampleapplication.ui.main

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import es.jarroyo.koinexampleapplication.R
import es.jarroyo.koinexampleapplication.data.Response
import es.jarroyo.koinexampleapplication.ui.viewModel.data.*
import kotlinx.android.synthetic.main.activity_scrolling.*
import kotlinx.android.synthetic.main.content_scrolling.*
import org.koin.android.viewmodel.ext.android.viewModel

class ScrollingActivity : AppCompatActivity() {
    val getDataViewModel: GetDataViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        observeGetDataViewModel()
        getDataViewModel.getData()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /****************************************************************************
     * OBSERVER
     ***************************************************************************/
    /** GET DATA **/
    private fun observeGetDataViewModel() {
        getDataViewModel.dataLiveData.observe(this, dataObserver)
    }

    private val dataObserver = Observer<GetDataState> { state ->
        state?.let {
            when (state) {
                is SuccessGetDataState -> {
                    val response = it.response as Response.Success
                    activity_scrolling_tv.text = response.data
                }
                is LoadingGetDataState -> {
                    Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
                }
                is ErrorGetDataState -> {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
