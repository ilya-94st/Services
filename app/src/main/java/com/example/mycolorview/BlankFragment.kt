package com.example.mycolorview

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.mycolorview.databinding.FragmentBlankBinding
import com.google.android.material.snackbar.Snackbar


class BlankFragment: BaseFragment<FragmentBlankBinding>() {
    override fun getBinding() = R.layout.fragment_blank
    private val RECORD_REQUEST_CODE = 101



    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment_to_viewPagerFragment2)
        }
        binding.buttonMenu.setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment_to_menuFragment)
        }
        binding.button3.setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment_to_notificationFragment)
        }
        binding.button4.setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment_to_serviseFragment)
        }
        binding.buttonDropDrog.setOnClickListener {
            findNavController().navigate(R.id.action_blankFragment_to_dragDropFragment)
        }
    }
}