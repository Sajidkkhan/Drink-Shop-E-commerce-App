package com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.R
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.navigation.BottomNavHost
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.navigation.BottomNavIcon
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.navigation.BottomNavigationBar

@Composable
fun MainScreen(
    mainNavController: NavHostController,
) {

    val provideBottomNavItems = listOf(
        BottomNavIcon(
            "Home",
            AppScreens.Dashboard.name,
            R.drawable.ic_home
        ),

        BottomNavIcon(
            "List",
            AppScreens.ProductList.name,
            R.drawable.ic_list
        ),

        BottomNavIcon(
            "Cart",
            AppScreens.Cart.name,
            R.drawable.ic_cart
        ),

        BottomNavIcon(
            "Setting",
            AppScreens.Setting.name,
            R.drawable.ic_setting
        )
    )


    // This is the inner navController for the search,saved,home,setting screens
    // different navController for different navHosts
    val navController = rememberNavController()

    val showBottomBar =
        navController.currentBackStackEntryAsState().value?.destination?.route in provideBottomNavItems.map { it.route }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomNavigationBar(
                    navController = navController,
                    items = provideBottomNavItems
                )
            }
        }) {

        BottomNavHost(
            navController = navController,
            modifier = Modifier.padding(it)
        )
    }


}

