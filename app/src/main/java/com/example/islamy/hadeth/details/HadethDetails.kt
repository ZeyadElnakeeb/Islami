package com.example.islamy.hadeth.details

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.islamy.R
import com.example.islamy.databinding.ActivityHadethDetailsBinding
import com.example.islamy.databinding.ActivitySuarDetailsBinding
import java.io.BufferedReader
import java.io.InputStreamReader

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

        var bundel:Bundle?=intent.extras
        var names= bundel?.getString("nameOfHadeth")
        var detailsHadeth= bundel?.getString("hadethDetalis")

        val fileContent = readAssetFile(this, "$detailsHadeth")
        binding.numberOfHadeth.text=names
        binding.hadethDetails.text=fileContent



    }


    fun readAssetFile(context: Context, fileName: String): String {
        val assetManager = context.assets
        val inputStream = assetManager.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        return String(buffer, Charsets.UTF_8)
    }


    }

