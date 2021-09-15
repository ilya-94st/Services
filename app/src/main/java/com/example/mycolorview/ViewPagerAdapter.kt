package com.example.mycolorview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.castom_toast.view.imageView


class ViewPagerAdapter(val list: List<Int>): RecyclerView.Adapter<ViewPagerAdapter.ViewPagerHolder>() {
    inner class ViewPagerHolder(itemView:View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_pager, parent, false)
        return ViewPagerHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerHolder, position: Int) {
        val item = list[position]
        holder.itemView.imageView.setImageResource(item)
    }

    override fun getItemCount(): Int {
       return list.size
    }

}