package com.example.mycolorview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycolorview.databinding.FragmentServiseBinding
import kotlinx.coroutines.*

class ServiseFragment : BaseFragment<FragmentServiseBinding>() {
    override fun getBinding() = R.layout.fragment_servise
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlobalScope.launch(Dispatchers.IO) {
            withContext(Dispatchers.Main){
                binding.textCorntine.text = getNetwork()
            }
        }
binding.start.setOnClickListener {
    Intent(context as Activity, MyService::class.java).also {
        activity?.startService(it)
        binding.text.text = "Start service"
    }
}
        binding.stop.setOnClickListener {
            Intent(context as Activity, MyService::class.java).also {
                activity?.stopService(it)
                binding.text.text = "Stop servises"
            }
        }
        binding.buttonSave.setOnClickListener {
            Intent(context as Activity, MyService::class.java).also {
             val dataString = binding.editTextTextPersonName.text.toString()
                it.putExtra("EXTRA_DATA", dataString)
                activity?.startService(it)
            }
        }
    }
suspend fun getNetwork(): String {
    delay(3000)
    return "Get network"
}
}