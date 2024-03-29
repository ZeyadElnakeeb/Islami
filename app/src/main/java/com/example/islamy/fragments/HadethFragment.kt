package com.example.islamy.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.islamy.Adapter.Adapter
import com.example.islamy.databinding.FragmentHadethBinding
import com.example.islamy.hadeth.details.HadethDetails


class HadethFragment : Fragment() {

    private var hadethBinding: FragmentHadethBinding? = null
    private val homeBinding get() = hadethBinding!!

    lateinit var adapter:Adapter

    var ahadeth = listOf<String>("الحديث الاول","الحديث الثاني","الحديث الثالث","الحديث الرابع","الحديث الخامس","الحديث السادس","الحديث السابع","الحديث الثامن","الحديث التاسع","الحديث العاشر"
    ,"الحديث الحادي عشر","الحديث الثاني عشر","الحديث الثالث عشر","الحديث الرابع عشر","الحديث الخامس عشر","الحديث السادس عشر","الحديث السابع عشر","الحديث الثامن عشر","الحديث التاسع عشر","الحديث العشرون"
    ,"الحديث الحادي و العشرون","الحديث الثاني و العشرون","الحديث الثالث و العشرون","الحديث الرابع و العشرون","الحديث الخامس و العشرون","الحديث السادس و العشرون","الحديث السابع و العشرون","الحديث الثامن و العشرون","الحديث التاسع و العشرون","الحديث الثلاثون"
    ,"الحديث الواحد و الثلاثون","الحديث الثاني و الثلاثون","الحديث الثالث و الثلاثون","الحديث الرابع و الثلاثون","الحديث الخامس و الثلاثون","الحديث السادس و الثلاثون","الحديث السابع و الثلاثون","الحديث الثامن و الثلاثون","الحديث التاسع و الثلاثون","الحديث الاربعون"
    ,"الحديث الواحد و الاربعون","الحديث الثاني و الاربعون","الحديث الثالث و الاربعون","الحديث الرابع و الاربعون","الحديث الخامس و الاربعون","الحديث السادس و الاربعون","الحديث السابع و الاربعون","الحديث الثامن و الاربعون","الحديث التاسع و الاربعون","الحديث الخمسون")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        hadethBinding = FragmentHadethBinding.inflate(inflater,container,false)
        val view  = homeBinding.root
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            adapter=Adapter(ahadeth)
        adapter.onItemClick=object : Adapter.SetOnItemClickListener{
            override fun onClick(position: Int, item: String) {
             var intent=Intent(requireContext(),HadethDetails::class.java)
                intent.putExtra("nameOfHadeth",ahadeth[position])
                intent.putExtra("hadethDetalis","h${position+1}.txt")
             startActivity(intent)

            }

        }



           hadethBinding?.hadethNameRv?.adapter =adapter

    }


}









