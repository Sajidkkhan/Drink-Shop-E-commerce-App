package com.totalfreeapps.secure.incoming.call.locker.drinkshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation.AppScreens
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.navigation.AppGraphs
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation.CartScreen
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation.DashboardScreen
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation.MainScreen
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation.ProductDetailScreen
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation.ProductListScreen
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation.SettingScreen
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.ui.theme.DrinkShopTheme
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.viewmodel.DrinkViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            DrinkShopTheme (darkTheme = false, dynamicColor = false){
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.Gray)
                    ) {
                        AppNavigation()
                    }
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MainScreen.name) {
        composable(AppScreens.MainScreen.name) {
            MainScreen(navController)
        }
    }
}
