package com.totalfreeapps.secure.incoming.call.locker.drinkshop.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.totalfreeapps.secure.incoming.call.locker.drinkshop.R

@Composable
fun DashboardAppbar(
    modifier: Modifier = Modifier,
) {

    Column (modifier.padding(10.dp)){
        Row(
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = { }) {
                Icon(Icons.Default.Menu, "Go Back")
            }

            Surface(
                modifier = Modifier
                    .size(45.dp)
                    .padding(5.dp),
                shape = CircleShape,
                border = BorderStroke(0.5.dp, Color.LightGray),
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "profile image",
                    modifier = modifier.size(35.dp),
                    contentScale = ContentScale.Crop
                )

            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        
        Column {
            Text(text = "Hi. Mr Michael,", color = Color.Gray)
            Text(text = "Welcome Back!", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(10.dp))

        DrinkSearchbar()
    }

}


@Preview(showBackground = true)
@Composable
fun DashboardAppbarPreview() {
    val navController = rememberNavController()
    DashboardAppbar(
        modifier = Modifier
    )

}