package com.senne.guests.service.repository

import com.senne.guests.service.model.GuestModel

class GuestRepository {

    fun getAll (): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list

    }

    fun getPresents (): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list

    }

    fun getAbsents (): List<GuestModel> {
        val list: MutableList<GuestModel> = ArrayList()
        return list

    }

    fun save (guest: GuestModel) {

    }

    fun update (guest: GuestModel) {

    }

    fun delete (guest: GuestModel) {

    }
}