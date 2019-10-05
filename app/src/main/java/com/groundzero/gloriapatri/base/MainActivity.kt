package com.groundzero.gloriapatri.base

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.groundzero.gloriapatri.R
import com.groundzero.gloriapatri.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasAndroidInjector, MainActivityListener,
    NavigationView.OnNavigationItemSelectedListener, ToolbarInflater, ProgressBarCallback {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navController: NavController

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.activity = this
        drawerLayout = binding.drawerLayout
        navigation_view.setNavigationItemSelectedListener(this)
        navController = findNavController(R.id.nav_controller)
        binding.navigationView.setupWithNavController(navController)
    }

    override fun addViewToolbar(buttonsLayout: LinearLayout) {
        toolbar_layout.addView(buttonsLayout)
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun openDrawer(): View.OnClickListener =
        View.OnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {

            R.id.alarmListFragment -> navController.navigate(R.id.alarmListFragment)
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun changeVisibility(isVisible: Boolean) {
        main_progress_bar.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}