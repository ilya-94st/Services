package com.example.mycolorview

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.example.mycolorview.databinding.FragmentMenuBinding


class MenuFragment : BaseFragment<FragmentMenuBinding>(){
    lateinit var taggle: ActionBarDrawerToggle
    override fun getBinding() = R.layout.fragment_menu
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        taggle = ActionBarDrawerToggle(context as Activity,binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(taggle)
        taggle.syncState()
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
binding.navigation.setNavigationItemSelectedListener {
    when(it.itemId){
        R.id.menu1 -> Toast.makeText(context, "1", Toast.LENGTH_SHORT).show()
        R.id.menu2 -> Toast.makeText(context, "2", Toast.LENGTH_SHORT).show()
        R.id.menu3 -> Toast.makeText(context, "3", Toast.LENGTH_SHORT).show()
    }
    true
}
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (taggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}