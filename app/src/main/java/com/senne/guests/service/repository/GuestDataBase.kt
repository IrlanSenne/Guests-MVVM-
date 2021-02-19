package com.senne.guests.service.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.senne.guests.service.model.GuestModel

@Database(entities = arrayOf(GuestModel::class), version = 1)
abstract class GuestDataBase: RoomDatabase() {

    abstract fun guestDAO(): GuestDAO

    companion object {
        private lateinit var INSTANCE: GuestDataBase
        fun getDataBase(context: Context): GuestDataBase {
            if(!::INSTANCE.isInitialized) {
                synchronized(GuestDataBase::class){
                    INSTANCE = Room.databaseBuilder(context,GuestDataBase::class.java,"guestDB")
                            .allowMainThreadQueries()
                            .build()
                }

            }
                return INSTANCE
        }
    }
}