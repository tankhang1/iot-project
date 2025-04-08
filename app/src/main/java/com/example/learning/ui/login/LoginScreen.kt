package com.example.learning.ui.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.learning.R
import com.example.learning.ui.components.Header


class LoginScreen : Fragment() {

    lateinit var loginHeader: Header
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_login_screen, container, false)
        loginHeader = view.findViewById(R.id.login_header)
        onGoBack()
        return view
    }

   private fun onGoBack() {
        val backBtn: ImageView = loginHeader.findViewById(R.id.header_left_button)

        backBtn.setOnClickListener {
            Log.d("Login Screen", "Go Back")
            findNavController().navigateUp()
        }
    }
}