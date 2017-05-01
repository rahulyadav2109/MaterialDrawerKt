package co.zsmb.materialdrawerktexample.originalactivities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import co.zsmb.materialdrawerkt.builders.drawer
import co.zsmb.materialdrawerkt.draweritems.badgeable.primaryItem
import co.zsmb.materialdrawerkt.draweritems.badgeable.secondaryItem
import co.zsmb.materialdrawerkt.draweritems.sectionHeader
import com.mikepenz.fontawesome_typeface_library.FontAwesome
import com.mikepenz.materialdrawer.Drawer
import kotlinx.android.synthetic.main.activity_sample_custom_container_dark_toolbar.*

class CustomContainerActivity : AppCompatActivity() {

    private lateinit var result: Drawer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(co.zsmb.materialdrawerktexample.R.layout.activity_sample_custom_container_dark_toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(false)

        result = drawer {
            savedInstance = savedInstanceState
            toolbar = this@CustomContainerActivity.toolbar
            actionBarDrawerToggleAnimated = true
            displayBelowStatusBar = false
            rootViewRes = co.zsmb.materialdrawerktexample.R.id.drawer_container

            primaryItem(co.zsmb.materialdrawerktexample.R.string.drawer_item_home) { iicon = FontAwesome.Icon.faw_home }
            primaryItem(co.zsmb.materialdrawerktexample.R.string.drawer_item_free_play) { iicon = FontAwesome.Icon.faw_gamepad }
            primaryItem(co.zsmb.materialdrawerktexample.R.string.drawer_item_custom) { iicon = FontAwesome.Icon.faw_eye }
            sectionHeader(co.zsmb.materialdrawerktexample.R.string.drawer_item_section_header)
            secondaryItem(co.zsmb.materialdrawerktexample.R.string.drawer_item_settings) { iicon = FontAwesome.Icon.faw_cog }
            secondaryItem(co.zsmb.materialdrawerktexample.R.string.drawer_item_help) { iicon = FontAwesome.Icon.faw_question }
            secondaryItem(co.zsmb.materialdrawerktexample.R.string.drawer_item_open_source) { iicon = FontAwesome.Icon.faw_github }
            secondaryItem(co.zsmb.materialdrawerktexample.R.string.drawer_item_contact) { iicon = FontAwesome.Icon.faw_bullhorn }
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        result.saveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    override fun onBackPressed() {
        if (result.isDrawerOpen)
            result.closeDrawer()
        else
            super.onBackPressed()
    }

}