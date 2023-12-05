package com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.components.DrinkshopAppbar

@Composable
fun CartScreen(navController: NavController) {

    Scaffold(
        topBar = {
            Surface(shadowElevation = 0.dp) {
                DrinkshopAppbar("Cart", false, navController, onClick = {})
            }
        }
    ) {
        Box(Modifier.padding(it)) {

        }
    }
}