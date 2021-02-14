package com.senne.guests.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.senne.guests.viewModel.GuestFormViewModel
import com.senne.guests.R

class GuestFromActivity : AppCompatActivity(), View.OnClickListener {

    var button_save: Button = findViewById(R.id.button_save)

    private lateinit var mViewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_from)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListeners()
    }

    private fun  setListeners() {
       this.button_save.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        if(id == R.id.button_save) {

        }
    }
}