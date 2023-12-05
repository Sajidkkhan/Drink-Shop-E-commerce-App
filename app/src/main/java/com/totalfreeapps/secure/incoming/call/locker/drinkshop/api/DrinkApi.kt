package com.totalfreeapps.secure.incoming.call.locker.drinkshop.api

import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.DrinksModel
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.SKUs
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.StockPriceModel
import retrofit2.Response
import retrofit2.http.GET

interface DrinkApi {

    @GET("/drinkshop/product.json")
    suspend fun getDringList(): Response<List<DrinksModel>>

    @GET("/drinkshop/stockprice.json")
    suspend fun getStockPrice(): Response<List<SKUs>>
}