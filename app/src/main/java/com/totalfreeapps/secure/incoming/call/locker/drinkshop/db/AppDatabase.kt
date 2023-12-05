package com.totalfreeapps.secure.incoming.call.locker.drinkshop.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.SKUDao
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.SKUs

@Database(entities = [SKUs::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun skuDao(): SKUDao
}
