package com.example.mycolorview

import android.content.ClipData
import android.content.ClipDescription
import android.os.Bundle
import android.view.DragEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mycolorview.databinding.FragmentDragDropBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class DragDropFragment : BaseFragment<FragmentDragDropBinding>(){
    override fun getBinding() = R.layout.fragment_drag_drop
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.llbottom.setOnDragListener(dragListner() as View.OnDragListener?)
        binding.lltop.setOnDragListener(dragListner() as View.OnDragListener?)
        dragDrop(binding.drop, "Просто текст")
    }
}