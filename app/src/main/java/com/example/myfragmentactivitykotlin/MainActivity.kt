package com.example.myfragmentactivitykotlin

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.tabs.TabLayout
import androidx.fragment.app.Fragment as Fragment1


class MainActivity : AppCompatActivity() {

    var tabLayout: TabLayout? = null
    var frameLayout: FrameLayout? = null
    var fragment: Fragment1? = null
    var fragmentManager: FragmentManager? = null
    var fragmentTransaction: FragmentTransaction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        frameLayout = findViewById<FrameLayout>(R.id.frameLayout)

        fragment = Fragment1()
        fragmentManager = supportFragmentManager
        fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction!!.replace(R.id.frameLayout, fragment)
        fragmentTransaction!!.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        fragmentTransaction!!.commit()
        //adding listener for tab select
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                // creating cases for fragment
                when (tab.position) {
                    0 -> fragment = fragment1_fragment()
                    1 -> fragment = fragment2_fragment()

                }
                val fm = supportFragmentManager
                val ft = fm.beginTransaction()
                ft.replace(R.id.frameLayout, fragment)
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                ft.commit()
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

    }

    private fun fragment1_fragment() {

    }
    private fun fragment2_fragment(): Fragment1? {

    }
}