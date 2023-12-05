package com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation

import android.util.Log
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.R
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.components.DrinkshopAppbar
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.SKUs
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.viewmodel.DrinkViewModel
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.viewmodel.SharedViewModel

@Composable
fun ProductDetailScreen(navController: NavController, sharedViewModel: SharedViewModel) {


    Log.e("data", sharedViewModel.data.value.toString())

    val drinkViewModel: DrinkViewModel = hiltViewModel()

    drinkViewModel.getSkuById(sharedViewModel.data.value!!.skus[0].code.toInt())

    val stock: State<SKUs?> = drinkViewModel.stock.observeAsState()


    Scaffold(
        topBar = {
            Surface(shadowElevation = 0.dp) {
                DrinkshopAppbar("Detail", false, navController, onClick = {})
            }
        }
    ) {
        Box(Modifier.padding(it)) {

            Image(
                painter = rememberAsyncImagePainter("https://www.ifocustec.com/drinkshop/${sharedViewModel.data.value?.image}"),
                contentDescription = "login_bg",
                contentScale = ContentScale.Inside,
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .size(200.dp),
            )

            Surface(
                color = Color.Gray.copy(alpha = 0.1f),
                shape = RoundedCornerShape(40.dp).copy(
                    bottomStart = ZeroCornerSize,
                    bottomEnd = ZeroCornerSize
                ),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 220.dp)

            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column() {
                            Text(
                                text = "${sharedViewModel.data.value?.brand}",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Origin ${sharedViewModel.data.value?.origin} | Stock ${stock.value?.stock}",
                                color = Color.Gray,
                                fontSize = 12.sp
                            )
                        }

                        Text(
                            text = "\$${
                                String.format(
                                    "%.2f", (stock.value?.price?.toDouble()
                                        ?.div(100.00))
                                )
                            }",
                            fontSize = 16.sp,
                            color = Color(0xFFF07E1B),
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Description",
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "${sharedViewModel.data.value?.information}",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Normal
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Size",
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )

                    LazyRow {
                        items(sharedViewModel.data.value?.skus?.size!!) {
                            OutlinedButton(modifier = Modifier.padding(6.dp),
                                border = BorderStroke(width = 1.dp, Color(0xFFF07E1B)),
                                onClick = {

                                    drinkViewModel.getSkuById(sharedViewModel.data.value!!.skus[it].code.toInt())


                                }) {
                                Text(
                                    text = "${sharedViewModel.data.value?.skus?.get(it)?.name}",
                                    fontSize = 12.sp,
                                    color = Color(0xFFF07E1B)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {

                        OutlinedButton(onClick = { /*TODO*/ }) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_cart),
                                contentDescription = ""
                            )
                        }

                        Spacer(modifier = Modifier.width(20.dp))
                        Button(onClick = {

                        }) {
                            Text(text = "    Add to Cart    ", color = Color.White)
                        }
                    }

                }

            }
        }
    }
}