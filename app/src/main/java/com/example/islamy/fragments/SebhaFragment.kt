package com.example.islamy.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation

import com.example.islamy.databinding.FragmentQuranBinding
import com.example.islamy.databinding.FragmentSebhaBinding


class SebhaFragment : Fragment() {

    private var sebhaBinding: FragmentSebhaBinding? = null
    private val homeBinding get() = sebhaBinding!!

    private var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        sebhaBinding = FragmentSebhaBinding.inflate(inflater,container,false)
        val view  = homeBinding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animationImageView()

    }

    private fun animationImageView() {
         val rotateAnimation = RotateAnimation(0f, 10f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)
        rotateAnimation.duration = 300 // Adjust the duration as needed
        sebhaBinding!!.showCounter.text= "0"
        sebhaBinding?.bodyOfSebha?.setOnClickListener{

            sebhaBinding?.bodyOfSebha?.startAnimation(rotateAnimation)

            counter++
            sebhaBinding!!.showCounter.text=counter.toString()

            if (  sebhaBinding!!.showCounter.text == "33"){
                sebhaBinding!!.showTasbeha.text="الحمد للة"
            }else if (sebhaBinding!!.showCounter.text == "66"){
                sebhaBinding!!.showTasbeha.text="الله اكبر"
            }else if (sebhaBinding!!.showCounter.text == "99"){
                sebhaBinding!!.showTasbeha.text="لا الة الا اللة"
            }else if (sebhaBinding!!.showCounter.text == "100"){
                sebhaBinding!!.showTasbeha.text="سبحان الله"
                counter = 0
                sebhaBinding!!.showCounter.text == "0"
                counter++
                sebhaBinding!!.showCounter.text=counter.toString()

            }



        }






    }

}