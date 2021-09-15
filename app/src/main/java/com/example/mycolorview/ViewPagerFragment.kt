package com.example.mycolorview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.mycolorview.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator


class ViewPagerFragment : BaseFragment<FragmentViewPagerBinding>() {
    override fun getBinding() = R.layout.fragment_view_pager
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list  = listOf<Int>(R.drawable.cat, R.drawable.coin)
        val viewPagerAdapter = ViewPagerAdapter(list)
        binding.viewPager2.adapter = viewPagerAdapter


        TabLayoutMediator(binding.tablayot, binding.viewPager2) {
            tab, position ->
            tab.text = "TAB ${position +1 }"
        }.attach()
    }
}