package com.totalfreeapps.secure.incoming.call.locker.drinkshop.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.api.DrinkApi
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.db.AppDatabase
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.DrinksModel
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.SKUDao
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.SKUs
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.StockPriceModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DrinkRepository @Inject constructor(private val drinkApi: DrinkApi, private val skuDao: SKUDao){

     val drinkList = MutableLiveData<List<DrinksModel>>(emptyList())

    private val coroutineScope = CoroutineScope(Dispatchers.IO)


    suspend fun getDrinkList() {
        val response = drinkApi.getDringList()
        if (response.isSuccessful && response.body() != null) {
            drinkList.postValue(response.body()!!)
        }
    }

//    val stockList = MutableLiveData<List<SKUs>>(emptyList())

    suspend fun getStockPrice() {
        val response = drinkApi.getStockPrice()
        if (response.isSuccessful && response.body() != null) {
            coroutineScope.launch {
                skuDao.insertItems(response.body()!!)
//                stockList.postValue(response.body()!!)
            }

        }
    }

    private val stock = MutableLiveData<SKUs>()

    val stockDetail: LiveData<SKUs>
        get() = stock

    suspend fun getStockPriceById(id: Int) {
        coroutineScope.launch {
            stock.postValue(skuDao.getSKUById(id))
        }
    }

    fun insertData(model: List<SKUs>) {
        coroutineScope.launch {
            skuDao.insertItems(model)
        }
    }


}