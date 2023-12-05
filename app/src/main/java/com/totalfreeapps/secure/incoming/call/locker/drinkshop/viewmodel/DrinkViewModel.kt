package com.totalfreeapps.secure.incoming.call.locker.drinkshop.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.DrinksModel
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.SKUs
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.repository.DrinkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.Objects
import javax.inject.Inject

@HiltViewModel
class DrinkViewModel @Inject constructor(private val drinkRepository: DrinkRepository) :
    ViewModel() {

    val drinkList: LiveData<List<DrinksModel>> = drinkRepository.drinkList

    fun getDrinkList() {
        viewModelScope.launch {
            drinkRepository.getDrinkList()
        }
    }

//    val stockList: LiveData<List<SKUs>> = drinkRepository.stockList

    fun getStockPrice() {
        viewModelScope.launch {
            drinkRepository.getStockPrice()
        }
    }

    val stock: LiveData<SKUs> = drinkRepository.stockDetail

    fun getSkuById(id: Int) {
        viewModelScope.launch {
            drinkRepository.getStockPriceById(id)
        }
    }

}