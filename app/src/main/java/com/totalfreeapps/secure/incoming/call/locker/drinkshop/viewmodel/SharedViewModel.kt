package com.totalfreeapps.secure.incoming.call.locker.drinkshop.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.DrinksModel
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.SKUs
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.StockPriceModel

class SharedViewModel : ViewModel(){

    var data = mutableStateOf<DrinksModel?>(null)
        private set

    fun setData(drinksModel: DrinksModel){
        data.value = drinksModel
    }

    var stock = mutableStateOf<SKUs?>(null)
        private set

    fun setStockData(stockPriceModel: SKUs){
        stock.value = stockPriceModel
    }

}