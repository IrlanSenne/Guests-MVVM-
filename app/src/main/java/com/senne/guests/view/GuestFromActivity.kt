package com.senne.guests.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.senne.guests.viewModel.GuestFormViewModel
import com.senne.guests.R
import com.senne.guests.service.constants.GuestConstants

class GuestFromActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: GuestFormViewModel
    private var mGuestId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_from)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListeners()
        observe()
        loadData()

        val radio_presence : RadioButton = findViewById(R.id.radio_present)
        radio_presence.isChecked = true


    }

    override fun onClick(view: View) {
        val id = view.id
        if(id == R.id.button_save) {
            val edit_name: EditText = findViewById(R.id.edit_name)
            val name = edit_name.text.toString()
            var presence: RadioButton = findViewById(R.id.radio_present)

                mViewModel.save(mGuestId, name, presence.isChecked)
        }
    }

    private fun  loadData() {
        val bundle = intent.extras
        if(bundle != null) {
          mGuestId = bundle.getInt(GuestConstants.GUESTID)
            // load user
            mViewModel.load(mGuestId)
        }
    }

    private fun  setListeners() {
        var button_save: Button = findViewById(R.id.button_save)
        button_save.setOnClickListener(this)

    }

    private fun observe() {
        val radio_presence: RadioButton = findViewById(R.id.radio_present)
        mViewModel.saveGuest.observe(this, Observer {
            if(it) {
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
            }else {
                Toast.makeText(applicationContext, "Falha", Toast.LENGTH_SHORT).show()
            }
            finish()
        })

        mViewModel.updateGuest.observe(this, Observer {
            val edit_name : EditText = findViewById(R.id.edit_name)
            edit_name.setText(it.name)
            if(it.presence == true){
                radio_presence.isChecked = true
            }else {
                radio_presence.isChecked = true
            }
        })
    }


}