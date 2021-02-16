package com.senne.guests.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.senne.guests.R
import com.senne.guests.service.constants.GuestConstants
import com.senne.guests.view.adapter.GuestAdapter
import com.senne.guests.view.listener.GuestListener
import com.senne.guests.viewModel.AllViewModel

class AllFragment : Fragment() {

    private lateinit var allViewModel: AllViewModel
    private val mAdapter: GuestAdapter = GuestAdapter()
    private lateinit var mListener: GuestListener

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

        recycler.adapter = mAdapter

        mListener = object : GuestListener{
            override fun onClick(id: Int) {

                val intent =  Intent(context, GuestFromActivity::class.java)

                val bundle = Bundle()
                bundle.putInt(GuestConstants.GUESTID, id)

                intent.putExtras(bundle)
                startActivity(intent)
            }
           override fun onDelete(id: Int) {
               allViewModel.delete(id)
                allViewModel.load(GuestConstants.FILTER.empty)
            }
        }
        mAdapter.attachListener(mListener)
        observer()

        return root
    }

    override fun onResume() {
        super.onResume()
        allViewModel.load(GuestConstants.FILTER.empty)

    }

    private fun observer() {
        allViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuests(it)
        })
    }
}