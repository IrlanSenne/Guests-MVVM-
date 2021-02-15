package com.senne.guests.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.senne.guests.viewModel.GuestFormViewModel
import com.senne.guests.R

class GuestFromActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_from)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListeners()
        observe()
    }

    override fun onClick(view: View) {
        val id = view.id
        if(id == R.id.button_save) {
            var edit_name: EditText = findViewById(R.id.edit_name)
            val name = edit_name.toString()
            var presence: RadioButton = findViewById(R.id.radio_present)

            mViewModel.save(name,presence.isChecked)
        }
    }

    private fun  setListeners() {
        var button_save: Button = findViewById(R.id.button_save)
        button_save.setOnClickListener(this)

    }

    private fun observe() {
        mViewModel.saveGuest.observe(this, Observer {
            if(it) {
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(applicationContext, "Falha", Toast.LENGTH_SHORT).show()
            }
            finish()
        })
    }


}