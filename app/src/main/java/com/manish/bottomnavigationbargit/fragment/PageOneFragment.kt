package com.manish.bottomnavigationbargit.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.manish.bottomnavigationbargit.MainActivity
import com.manish.bottomnavigationbargit.R


class PageOneFragment : Fragment() {

    lateinit var buttonRed : ImageView
    lateinit var buttonGreen : ImageView
    lateinit var buttonBlue : ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_page_one, container, false)
        buttonRed = view.findViewById(R.id.buttonRed)
        buttonGreen = view.findViewById(R.id.buttonGreen)
        buttonBlue = view.findViewById(R.id.buttonBlue)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonRed.setOnClickListener {
            (activity as? MainActivity)?.setIndicatorColor(R.color.red)
        }

        buttonGreen.setOnClickListener {
            (activity as? MainActivity)?.setIndicatorColor(R.color.green)
        }

        buttonBlue.setOnClickListener {
            (activity as? MainActivity)?.setIndicatorColor(R.color.blue)
        }
    }

}