package com.example.learning.ui.home

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.learning.R
import com.example.learning.ui.components.Button
import eightbitlab.com.blurview.BlurView

class HomeScreen : Fragment() {

    var radius: Float = 1f
    lateinit var blurView: BlurView
    lateinit var startedBtn: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout and bind views
        val view: View = inflater.inflate(R.layout.fragment_home_screen, container, false)
        blurView = view.findViewById(R.id.blurView)
        startedBtn = view.findViewById(R.id.startedButton)

        // Apply blur effect
        applyBlurEffect()
        startedBtn.bringToFront()
        // Set button click listener for navigation
        startedBtn.setOnClickListener {
           Log.d("Home Screen","Click start button")
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }

        return view
    }

    private fun applyBlurEffect() {
        val decorView: View? = activity?.window?.decorView
        val rootView: ViewGroup? = decorView?.findViewById(android.R.id.content)
        val windowBackground: Drawable? = decorView?.background
        rootView?.let {
            blurView.setOutlineProvider(ViewOutlineProvider.BACKGROUND)
            blurView.setClipToOutline(true)
            blurView.setupWith(it).setFrameClearDrawable(windowBackground)
                .setBlurRadius(radius)
        }
    }
}
