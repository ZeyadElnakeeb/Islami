package com.example.islamy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islamy.databinding.ActivityMainBinding
import com.example.islamy.fragments.HadethFragment
import com.example.islamy.fragments.QuranFragment
import com.example.islamy.fragments.RadioFragment
import com.example.islamy.fragments.SebhaFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        replaceFragment(QuranFragment())

binding.bottomNavView.setOnItemSelectedListener {view->

    when(view.itemId){

        R.id.quran->replaceFragment(QuranFragment())
        R.id.hadeth->replaceFragment(HadethFragment())
        R.id.sebha->replaceFragment(SebhaFragment())
        R.id.radio->replaceFragment(RadioFragment())

        else->{

        }

    }
    true



}
    }

    private fun replaceFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view,fragment)
            .commit()


    }

}