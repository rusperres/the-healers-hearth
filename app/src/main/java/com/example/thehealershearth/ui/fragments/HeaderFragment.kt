package com.example.thehealershearth.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.thehealershearth.R

class HeaderFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_header, container, false)

        view.findViewById<ImageView>(R.id.btnLogoutHeader).setOnClickListener {
            val logoutFragment = LogoutFragment()
            logoutFragment.show(requireActivity().supportFragmentManager, "logout_dialog")
        }

        return view
    }
}