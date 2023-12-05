package com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.clickapps.offline.englishdictionary.ui.theme.SpaceSize
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.R
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.components.DashboardAppbar
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.components.PopularItems
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.components.TitleView
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.DrinksModel
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.viewmodel.DrinkViewModel
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.viewmodel.SharedViewModel

data class category(val id: Int, val name: String, val image: Int)

@Composable
fun DashboardScreen(navController: NavHostController, sharedViewModel: SharedViewModel) {

    val drinkViewModel: DrinkViewModel = hiltViewModel()

    drinkViewModel.getDrinkList()

    drinkViewModel.getStockPrice()

    val drinks: State<List<DrinksModel>?> = drinkViewModel.drinkList.observeAsState(listOf())

    val listItem = listOf<category>(
        category(0, "All  ", R.drawable.beer),
        category(1, "Beer ", R.drawable.beer),
        category(2, "Wine ", R.drawable.wine)
    )

    Scaffold(
        topBar = {
            Surface(shadowElevation = 0.dp) {
                DashboardAppbar()
            }
        }
    ) {
        Box(Modifier.padding(it)) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(SpaceSize.Small)
            ) {

                Spacer(modifier = Modifier.height(0.dp))

                TitleView(title = "Drink Category")

                LazyRow(modifier = Modifier.fillMaxWidth()) {
                    items(listItem) {
                        if (it.id == 1) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                            ) {
                                Card(
                                    colors = CardDefaults.cardColors(
                                        containerColor = Color(0xFFF07E1B).copy(alpha = 0.5f)
                                    )

                                ) {

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceEvenly
                                    ) {

                                        if (it.id == 0)
                                        else Image(
                                            painter = painterResource(id = it.image),
                                            modifier = Modifier.size(24.dp),
                                            contentDescription = ""
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Text(text = it.name, color = Color.White)
                                    }


                                }
                            }
                        } else {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                            ) {
                                Card(

                                ) {

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .padding(10.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.SpaceEvenly
                                    ) {

                                        if (it.id == 0)
                                        else Image(
                                            painter = painterResource(id = it.image),
                                            modifier = Modifier.size(24.dp),
                                            contentDescription = ""
                                        )
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Text(text = it.name)
                                    }


                                }
                            }
                        }
                    }
                }

                TitleView(title = "Popular")

                if (drinks.value?.size!! == 0) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(text = "Loading data...")
                    }
                } else {
                    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
                        drinks.value?.let { it1 ->

                            items(it1.size) {

                                PopularItems(
                                    drinks.value!![it],
                                    navController,
                                    sharedViewModel,
                                    drinkViewModel
                                )
                            }
                        }
                    }
                }

            }
        }
    }
}