package com.senne.guests.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.senne.guests.service.constants.GuestConstants
import com.senne.guests.service.model.GuestModel
import com.senne.guests.service.repository.GuestRepository

class AllViewModel(application: Application) : AndroidViewModel(application) {

    private val mGuestRepository = GuestRepository.getInstance(application.applicationContext)

    private val mGuestList = MutableLiveData<List<GuestModel>>()
    val guestList: LiveData<List<GuestModel>> = mGuestList

    fun load(filter: Int) {

        if(filter == GuestConstants.FILTER.empty) {
            mGuestList.value = mGuestRepository.getAll()
        }else if(filter == GuestConstants.FILTER.present) {
            mGuestList.value = mGuestRepository.getPresents()
        }else if(filter == GuestConstants.FILTER.absent) {
            mGuestList.value = mGuestRepository.getAbsents()
        }




    }

    fun delete(id: Int) {
        mGuestRepository.delete(id)
    }
}

