package com.example.islamy.sura.detals

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.islamy.R
import com.example.islamy.databinding.ActivityMainBinding
import com.example.islamy.databinding.ActivitySuarDetailsBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class SuarDetails : AppCompatActivity() {
    private lateinit var binding: ActivitySuarDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuarDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.backArrow.setOnClickListener{
            finish()
        }


        var bundel:Bundle?=intent.extras
        var names= bundel?.getString("nameOfSura")
        var detailsSura= bundel?.getString("details")
        binding.suarName.text=names

        val fileContent = readFromAssets(this, "$detailsSura")

        binding.suraDetails.text= fileContent.toString()



    }
    fun readFromAssets(context: Context, fileName: String): List<String> {
        val lines = mutableListOf<String>()
        try {
            // Open the file from the assets directory
            val inputStream = context.assets.open(fileName)
            val reader = BufferedReader(InputStreamReader(inputStream))

            var line: String?
            var lineNumber = 1 // Start counting from line 1
            while (reader.readLine().also { line = it } != null) {
                lines.add(" $line ($lineNumber) ")
                //
                lineNumber++
            }
            reader.close()
        } catch (e: Exception) {
            e.printStackTrace()
            // Handle error if any
        }
        return lines
    }




}