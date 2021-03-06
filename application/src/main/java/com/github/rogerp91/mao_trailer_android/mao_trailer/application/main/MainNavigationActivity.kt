package com.github.rogerp91.mao_trailer_android.mao_trailer.application.main

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.github.rogerp91.mao_trailer_android.mao_trailer.application.R
import com.github.rogerp91.mao_trailer_android.mao_trailer.application.databinding.AppActivityMainNavigationBinding
import com.github.rogerp91.mao_trailer_android.mao_trailer.application.navigation.BottomNavigationPositionHandler
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainNavigationActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: AppActivityMainNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AppActivityMainNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        navView.apply {
            menu.getItem(0).isChecked = true
            setOnItemSelectedListener(this@MainNavigationActivity)
        }
        findNavigationPositionById(R.id.navigation_movie)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        findNavigationPositionById(item.itemId)
        return true
    }

    private fun findNavigationPositionById(itemId: Int) {
        val bottomNavigationPositionConfig = BottomNavigationPositionHandler.buildConfig()
        val bottomNavigationPosition = bottomNavigationPositionConfig.find(itemId)
        bottomNavigationPosition?.let {
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_activity_main, it.fragment()).commit()
        }
    }
}
