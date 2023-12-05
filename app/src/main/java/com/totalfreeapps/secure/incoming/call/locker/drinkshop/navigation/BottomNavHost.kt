package com.totalfreeapps.secure.incoming.call.locker.drinkshop.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.google.gson.Gson
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.DrinksModel
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation.AppScreens
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation.CartScreen
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation.DashboardScreen
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation.ProductDetailScreen
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation.ProductListScreen
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation.SettingScreen
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.viewmodel.DrinkViewModel
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.viewmodel.SharedViewModel

@Composable
fun BottomNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    
    val sharedViewModel: SharedViewModel = viewModel()



    NavHost(
        navController = navController,
        startDestination = AppScreens.Dashboard.name,
        modifier = modifier
    ) {

        composable(AppScreens.Dashboard.name) {
            DashboardScreen(navController = navController, sharedViewModel)
        }
        composable(AppScreens.ProductList.name) {
            ProductListScreen(navController = navController)
        }
        composable(AppScreens.Cart.name) {
            CartScreen(navController = navController)
        }
        composable(AppScreens.Setting.name) {
            SettingScreen(navController = navController)
        }

        navigation(
            startDestination = AppScreens.Dashboard.name,
            route = AppGraphs.Secondary.name
        ) {


            composable(AppScreens.ProductDetail.name){

                val result = navController.previousBackStackEntry?.savedStateHandle?.get<DrinksModel>("drink")
                ProductDetailScreen(navController = navController, sharedViewModel = sharedViewModel)
            }

//            composable(
//                "${AppScreens.ProductDetail.name}/{drink}",
//                arguments = listOf(navArgument("drink") {
//                    type = NavType.StringType
//                })
//            ) { backStackEntry ->
//                backStackEntry?.arguments?.getString("drink")?.let { json ->
//                    val user =
//                        Gson().fromJson(json, DrinksModel::class.java)
//                    ProductDetailScreen(navController = navController, drinksModel = user!!)
//                }
//            }
        }
    }
}