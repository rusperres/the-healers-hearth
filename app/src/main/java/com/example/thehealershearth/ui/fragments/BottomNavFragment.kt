package com.example.thehealershearth.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.thehealershearth.R
import androidx.fragment.app.Fragment
import com.example.thehealershearth.ui.MenuGrimoireActivity
import com.example.thehealershearth.ui.BrewCustomizationActivity
import com.example.thehealershearth.ui.BrewRecommendationsActivity
import com.example.thehealershearth.ui.OrderHistoryActivity
import com.example.thehealershearth.ui.OrderPickupActivity

class BottomNavFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bottom_nav, container, false)
        val bottomNavAction = { clazz: Class<*> ->
            val intent = Intent(requireContext(), clazz)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            requireActivity().overridePendingTransition(0, 0)
        }

        val bottomNav = view.findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_grimoire -> {
                    bottomNavAction(MenuGrimoireActivity::class.java)
                    true
                }
                R.id.nav_recommend -> {
                    bottomNavAction(BrewRecommendationsActivity::class.java)
                    true
                }
                R.id.nav_order -> {
                    bottomNavAction(OrderPickupActivity::class.java)
                    true
                }
                R.id.nav_history -> {
                    bottomNavAction(OrderHistoryActivity::class.java)
                    true
                }
                else -> false
            }
        }

        val fabBrew = view.findViewById<View>(R.id.fabBrew)
        fabBrew.setOnClickListener {
            bottomNavAction(BrewCustomizationActivity::class.java)
        }

        return view
    }
}