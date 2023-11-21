package com.example.lab4.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4.R
import com.example.lab4.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

       //val textView: TextView = binding.textDashboard
        //dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
        //    textView.text = it
       // })
        var recyclerView: RecyclerView? = null
        var foods = arrayOf(
            "Almight",
            "Isawa Sensei",
            "Midoriya",
            "Todoroki"
        )
        var arrImg = arrayOf<Int>(
            R.drawable.alm,
            R.drawable.isaa,
            R.drawable.mido,
            R.drawable.t,

            )
        recyclerView = root.findViewById(R.id.recyclerView) as RecyclerView
        recyclerView!!.layoutManager = LinearLayoutManager(root.context)
        var linearRadio = root.findViewById(R.id.linear_layout_rb) as RadioButton
        linearRadio.setOnClickListener {
            recyclerView!!.layoutManager = LinearLayoutManager(root.context) }
        var gridRadio = root.findViewById<RadioButton>(R.id.grid_layout_rb)
        gridRadio.setOnClickListener {
            recyclerView!!.setLayoutManager(GridLayoutManager(root.context, 2)) }
        val myAdapter = MyAdapter(foods,arrImg)
        recyclerView!!.adapter = myAdapter
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}