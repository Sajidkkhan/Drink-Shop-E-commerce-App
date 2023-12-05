package com.totalfreeapps.secure.incoming.call.locker.drinkshop.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.DrinksModel
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.model.SKUs
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.presentation.AppScreens
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.viewmodel.DrinkViewModel
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.viewmodel.SharedViewModel

@Composable
fun PopularItems(
    drinkModel: DrinksModel,
    navController: NavController,
    sharedViewModel: SharedViewModel,
    viewModel: DrinkViewModel,
) {

    val stock: State<SKUs?> = viewModel.stock.observeAsState()

    viewModel.getSkuById(drinkModel.skus[0].code.toInt())

    Log.e("stock", " " + stock.value)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .wrapContentHeight()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Gray.copy(alpha = 0.1f))
            .clickable {
                sharedViewModel.setData(drinkModel)
                navController.navigate(AppScreens.ProductDetail.name)
            }
    ) {

        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 5.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White.copy(alpha = 0.8f))
                    .padding(16.dp)
            ) {
                Text(
                    text = drinkModel.brand,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .size(100.dp),
                        painter = rememberAsyncImagePainter("https://www.ifocustec.com/drinkshop${drinkModel.image}"),
                        contentDescription = "",
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Text(
                        text = if (stock.value?.id != 0) "\$${
                            String.format(
                                "%.2f",
                                (stock.value?.price?.toDouble()?.div(100.00))
                            )
                        }"
                        else "Undefine",
                        fontSize = 12.sp,
                        color = Color.Black,
                    )
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFFF07E1B))
                            .padding(4.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "",
                            tint = Color.White,
                            modifier = Modifier
                                .size(32.dp, 32.dp)
                        )
                    }
                }
            }
        }

    }
}
