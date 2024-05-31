package com.example.myquatsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myquatsapp.databinding.FragmentSaveBinding

lateinit var bindingSaveFragment: FragmentSaveBinding
var savaList = ArrayList<model_class>()

class SaveFragment : Fragment() {

    lateinit var db: DBhelper


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingSaveFragment =  FragmentSaveBinding.inflate(inflater, container, false)
        rvData()
        db = DBhelper(requireContext())
        savaList = db.getQuotes()
        return bindingSaveFragment.root
    }
    private fun rvData() {
        var adapter = Save_Adapter(requireContext(), savaList)
        var lm = LinearLayoutManager(requireContext(),RecyclerView.VERTICAL,false)
        bindingSaveFragment.rvData.layoutManager = lm
        bindingSaveFragment.rvData.adapter = adapter
    }



}