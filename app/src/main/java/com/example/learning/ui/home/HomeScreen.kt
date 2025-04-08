package com.example.learning.ui.home

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.fragment.app.Fragment
import com.example.learning.R
import eightbitlab.com.blurview.BlurView


class HomeScreen : Fragment() {

    var radius: Float =1f
    lateinit var blurView: BlurView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_home_screen, container, false)
        blurView = view.findViewById(R.id.blurView)
        val decorView: View? = activity?.window?.decorView;
        val rootView: ViewGroup? = decorView?.findViewById(android.R.id.content)
        val windowBackground: Drawable? = decorView?.background;
        rootView?.let {
            blurView.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
            blurView.setClipToOutline(true);
            blurView.setupWith(it).setFrameClearDrawable(windowBackground)
                .setBlurRadius(radius)
        }
        // Inflate the layout for this fragment
        return view
    }

}