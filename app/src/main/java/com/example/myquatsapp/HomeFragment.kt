package com.example.myquatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myquatsapp.Quotes_Adapter
import com.example.myquatsapp.R
import com.example.myquatsapp.databinding.FragmentHomeBinding
import com.example.myquatsapp.model_class

lateinit var homeBinding: FragmentHomeBinding

var quotesmodel_class = ArrayList<model_class>()
class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    homeBinding = FragmentHomeBinding.inflate(inflater,container,false)

        val quotes = arrayOf(
            "Mistakes are a great educatorwhen one is honest enough to admit them and willing to learn from them",
            "It’s okay to be angry It’s never okay to be cruel Don’t audit life Show up and make the most of it now",
            "Worrying won’t stop the bad stuff from happening It just stops you from enjoying the good",
            "Envy is a waste of time You already have all you need",
            "Most obstacles melt away when you decide to walk boldly through them",
            "The difference between who you are and what you want to be is what you do There is always " ,
            "always something to be thankful for Your mind is a powerful thing When you fill it with positive thoughts your life will start to change",
            "Forgive yourself for accepting less than you deserved But don’t do it again",
            "Maturity is not when we start speaking big things It is when we start understanding small things",
            "It’s easy to hate It takes strength to be kind",
            "Being honest may not get you a lot of friends but it’ll always get you the right ones."
        )


        for (i in quotes.indices){
            val quotes = model_class(quotes[i],id,false)
            quotesmodel_class.add(quotes)
        }

        val adapter = Quotes_Adapter(requireContext(), quotesmodel_class) // Adapeter : Note the Corrected Adapter Name
                val layoutManager = GridLayoutManager(requireContext(),1)

        homeBinding.rvdata.layoutManager= layoutManager
        homeBinding.rvdata.adapter = adapter




         return homeBinding.root
}
}