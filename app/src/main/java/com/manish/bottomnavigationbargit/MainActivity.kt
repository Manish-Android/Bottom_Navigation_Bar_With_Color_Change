package com.manish.bottomnavigationbargit

import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.manish.bottomnavigationbargit.fragment.PageFourFragment
import com.manish.bottomnavigationbargit.fragment.PageOneFragment
import com.manish.bottomnavigationbargit.fragment.PageThreeFragment
import com.manish.bottomnavigationbargit.fragment.PageTwoFragment

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var pageOneFrag: Fragment
    private lateinit var pageTwoFrag: Fragment
    private lateinit var pageThreeFrag: Fragment
    private lateinit var pageFourFrag: Fragment

    private var currentPageId: Int = R.id.page_1

    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.bottom_navigation)



        setIndicatorColor(R.color.red)



        pageOneFrag = PageOneFragment()
        pageTwoFrag = PageTwoFragment()
        pageThreeFrag = PageThreeFragment()
        pageFourFrag = PageFourFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, pageOneFrag)
            .commit()


        bottomNavigation.setOnItemSelectedListener { item ->
            val fragmentTransaction = supportFragmentManager.beginTransaction()

            when (item.itemId) {
                R.id.page_1 -> {
                    fragmentTransaction.replace(R.id.container, pageOneFrag)
                }
                R.id.page_2 -> {
                    fragmentTransaction.replace(R.id.container, pageTwoFrag)
                }
                R.id.page_3 -> {
                    fragmentTransaction.replace(R.id.container, pageThreeFrag)
                }
                else -> {
                    fragmentTransaction.replace(R.id.container, pageFourFrag)
                }
            }

            fragmentTransaction.commit()
            currentPageId = item.itemId
            true
        }
    }

    override fun onBackPressed() {
        if (currentPageId != R.id.page_1) {
            bottomNavigation.selectedItemId = R.id.page_1
        } else {
            super.onBackPressed()
        }
    }

    fun setIndicatorColor(colorResId: Int) {
        val colorStateList = ColorStateList.valueOf(ContextCompat.getColor(this, colorResId))
        bottomNavigation.itemActiveIndicatorColor = colorStateList.withAlpha(50)
        bottomNavigation.setBackgroundColor(ContextCompat.getColor(this, colorResId))
        bottomNavigation.background.alpha = 20
        bottomNavigation.itemRippleColor = colorStateList.withAlpha(40)
        window.statusBarColor = ContextCompat.getColor(this, colorResId)

    }

}
