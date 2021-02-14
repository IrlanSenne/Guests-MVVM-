package com.senne.guests.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.senne.guests.service.model.GuestModel
import com.senne.guests.service.repository.GuestRepository

class GuestFormViewModel: ViewModel() {

    private val mGuestRepository : GuestRepository =
        GuestRepository()

    private var mSaveGuest = MutableLiveData<Boolean>()
    val saveGuest = mSaveGuest

    fun save(name: String, presence: Boolean) {
        val guest = GuestModel(name, presence)
        mGuestRepository.save(guest)

}
}