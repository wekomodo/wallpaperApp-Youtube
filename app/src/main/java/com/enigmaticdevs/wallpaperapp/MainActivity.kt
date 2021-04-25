package com.enigmaticdevs.wallpaperapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.enigmaticdevs.wallpaperapp.adapters.ViewPagerAdapter
import com.enigmaticdevs.wallpaperapp.databinding.ActivityMainBinding
import com.enigmaticdevs.wallpaperapp.fragments.Category
import com.enigmaticdevs.wallpaperapp.fragments.Home
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tabLayoutId.tabRippleColor = null
        val adapter = ViewPagerAdapter(this)
        binding.viewpagerId.offscreenPageLimit = 2
        val tableNames = arrayOf("Home","Category")
        adapter.addFragment(Home(),tableNames[0])
        adapter.addFragment(Category(),tableNames[1])
        binding.viewpagerId.adapter = adapter
        TabLayoutMediator(binding.tabLayoutId,binding.viewpagerId) { tab ,position ->
            tab.text = tableNames[position]
            binding.viewpagerId.setCurrentItem(tab.position,true)
        }.attach()

    }
}