package com.senne.guests.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.senne.guests.service.model.GuestModel
import com.senne.guests.service.repository.GuestRepository

class GuestFormViewModel(application: Application) : AndroidViewModel(application) {

    private val mContext = application
    private val mGuestRepository: GuestRepository =
            GuestRepository.getInstance(mContext)

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest : LiveData<Boolean> = mSaveGuest

    private var mUpdateGuest = MutableLiveData<GuestModel>()
    val updateGuest : LiveData<GuestModel> = mUpdateGuest

    fun save(id: Int, name: String, presence: Boolean) {
        val guest = GuestModel(id, name,  presence)

        if(id == 0) {
            mSaveGuest.value = mGuestRepository.save(guest)
        }else {
            mSaveGuest.value = mGuestRepository.update(guest)
        }
    }

    fun load(id: Int) {
        mUpdateGuest.value = mGuestRepository.get(id)
    }
}