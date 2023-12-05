package com.totalfreeapps.secure.incoming.call.locker.drinkshop.components

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrinkshopAppbar(
    title: String,
    isMainScreen: Boolean,
    navController: NavController,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(
                title, fontWeight = FontWeight.Bold,
            )
        },
        navigationIcon = {
            if (!isMainScreen) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Default.ArrowBack, "Go Back")
                }
            }
        },
        actions = {
            IconButton(onClick = {  }) {
                Image(painter = painterResource(id = R.drawable.ic_actionmenu), contentDescription = "action menu")
            }

        },
        modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun DrinkshopAppbarPreview() {
    val navController = rememberNavController()
    DrinkshopAppbar(
        "Dictionary",
        true,
        navController = navController,
        modifier = Modifier
    )

}