package com.senne.guests.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.senne.guests.R
import com.senne.guests.view.adapter.GuestAdapter
import com.senne.guests.viewModel.AllViewModel

class AllFragment : Fragment() {

    private lateinit var allViewModel: AllViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        allViewModel =
                ViewModelProvider(this).get(AllViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_all, container, false)

        var recycler: RecyclerView = root.findViewById(R.id.recycler_all_guests)

        recycler.layoutManager = LinearLayoutManager(context)

        recycler.adapter = GuestAdapter()

        return root
    }
}