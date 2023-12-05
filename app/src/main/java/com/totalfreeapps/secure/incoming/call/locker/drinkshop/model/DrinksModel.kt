package com.totalfreeapps.secure.incoming.call.locker.drinkshop.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DrinksModel(
    val abv: String,
    val brand: String,
    val id: Int,
    val image: String,
    val information: String,
    val origin: String,
    val skus: List<Sku>,
    val style: String,
    val substyle: String
) : Parcelable {
    @Parcelize
    data class Sku(
        val code: String,
        val name: String
    ): Parcelable
}