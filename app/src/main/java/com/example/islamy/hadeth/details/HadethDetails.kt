package com.example.islamy.hadeth.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamy.R
import com.example.islamy.databinding.ActivityHadethDetailsBinding
import com.example.islamy.databinding.ActivitySuarDetailsBinding

class HadethDetails : AppCompatActivity() {
    private lateinit var binding: ActivityHadethDetailsBinding
    lateinit var title:String
lateinit var contant:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backArrow.setOnClickListener{
            finish()
        }
readFileName()

        var bundel:Bundle?=intent.extras
        var names= bundel?.getString("numOfHadeth")



        binding.numberOfHadeth.text=names
        binding.hadethDetails.text= contant




    }

    private fun readFileName() {

        var fileContant= applicationContext.assets?.open("hadeth.txt")?.bufferedReader().use {
            it?.readText()
        }
        if (fileContant==null) return;
        var ahadethContant = fileContant.trim().split("#")
        ahadethContant.forEach { singelHadethContant->

             title=singelHadethContant.trim().substringBefore("\n")
             contant=singelHadethContant.trim().substringAfter("\n")



        }

    }

}