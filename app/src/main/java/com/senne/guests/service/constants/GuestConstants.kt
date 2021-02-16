package com.senne.guests.service.constants

class GuestConstants  private constructor(){
    companion object {
        const val GUESTID = "guestID"


    }
    object FILTER {
        const val empty = 0
        const val present = 1
        const val absent = 2
    }
}