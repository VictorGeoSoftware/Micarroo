package micarroo.victor.com.micarroo

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import micarroo.victor.com.micarroo.di.main.MainActivityModule
import micarroo.victor.com.micarroo.presenters.map.MapView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback, View.OnClickListener, MapView {
    val component by lazy { app.component.plus(MainActivityModule(this)) }
    lateinit var mapFragment:SupportMapFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        component.inject(this)

        mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


    }



    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------- USER INTERFACE ------------------------------------------------------------------------
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onClick(p0: View?) {

    }



    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------- MENU INTERFACE ------------------------------------------------------------------------
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }



    // ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------- MAP INTERFACE ---------------------------------------------------------------------------
    override fun onMapReady(p0: GoogleMap?) {
        Log.i("Micarroo", "MainActivity - onMapReady")
    }


    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------- MAP VIEW INTERFACE ------------------------------------------------------------------------
    override fun onAddressReturned(address: String) {

    }

    override fun onAddressKo() {

    }

    override fun onAddressListReturned(address: ArrayList<String>) {

    }

    override fun onAddressListKo() {

    }



    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------
    // --------------------------------------------------------------------------- METHODS AND EXTENSIONS ----------------------------------------------------------------
    val Activity.app: MainApplication
        get() = application as MainApplication
}
