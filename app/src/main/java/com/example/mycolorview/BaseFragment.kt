package com.example.mycolorview

import android.content.ClipData
import android.content.ClipDescription
import android.os.Bundle
import android.view.DragEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import kotlinx.android.synthetic.main.castom_toast.*

abstract class BaseFragment<B: ViewBinding> : Fragment() {
     lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getBinding(),container, false)
        return binding.root

    }

    fun castomToast() {
        Toast(context).apply {
            duration = Toast.LENGTH_SHORT
            view = layoutInflater.inflate(R.layout.castom_toast, clToast)
            show()
        }
    }
    fun dragDrop(it:View, text: String) {
        it.setOnLongClickListener {
            val clipText = text
            val item = ClipData.Item(clipText)
            val mimeType = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeType, item)
            val dragShadowBiulder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBiulder, it,0)
            it.visibility = View.INVISIBLE
            true
        }
    }
    fun dragListner(): Any {
        val dragListner = View.OnDragListener { view, event ->
            when(event.action){
                DragEvent.ACTION_DRAG_STARTED -> {
                    event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                    view.invalidate()
                    true
                }
                DragEvent.ACTION_DRAG_LOCATION -> true
                DragEvent.ACTION_DRAG_EXITED -> {
                    view.invalidate()
                    true
                }
                DragEvent.ACTION_DROP -> {
                    val item = event.clipData.getItemAt(0)
                    val dragData = item.text
                    Toast.makeText(context, dragData, Toast.LENGTH_SHORT).show()
                    view.invalidate()
                    val v = event.localState as View
                    val owner = v.parent as ViewGroup
                    owner.removeView(v)
                    val distination = view as LinearLayout
                    distination.addView(v)
                    v.visibility = View.VISIBLE
                    true
                }
                DragEvent.ACTION_DRAG_ENDED -> {
                    view.invalidate()
                    true
                }
                else -> {
                    false
                }
            }
        }
        return dragListner
    }
    abstract fun getBinding(): Int

}


