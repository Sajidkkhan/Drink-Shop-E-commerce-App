package com.totalfreeapps.secure.incoming.call.locker.drinkshop.model

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.PrimaryKey
import androidx.room.Query

@Entity(tableName = "sku")
data class SKUs(
    @PrimaryKey val id: Int,
    val stock: Int,
    val price: Int,
)

@Dao
interface SKUDao {
    @Query("SELECT * FROM sku WHERE id = :id")
    fun getSKUById(id: Int): SKUs

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertItems(getSkuResponse: List<SKUs>)
}


//val skus = listOf<String>(
//    "2865","2940","3518","3518"
//)

