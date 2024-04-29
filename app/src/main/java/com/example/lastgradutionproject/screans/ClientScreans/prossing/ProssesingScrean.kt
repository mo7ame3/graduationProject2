package com.example.lastgradutionproject.screans.ClientScreans.prossing

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.navigation.MillanoScreans
import com.example.lastgradutionproject.tabs

@Composable
fun prossing(navController: NavController){
    Surface (color = Color.White){


        Row {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow back",
                tint = Color.Black,
                modifier = Modifier
                    .size(45.dp)
                    .padding(start = 15.dp, top = 8.dp)
                    .clickable {
                        navController.navigate(MillanoScreans.HomeScrean.name)
                    }


            )
            Spacer(modifier = Modifier.width(65.dp))
            Text(
                text = " Myorder",
                fontWeight = FontWeight.Bold, fontSize = 24.sp,
                modifier = Modifier.padding()
            )


        }




        Column(verticalArrangement = Arrangement.Top, modifier = Modifier.padding(top = 110.dp)) {
            TabsComponent(navController = navController)

        }
    }

}
@Composable
fun TabsComponent(navController: NavController){
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    TabRow(selectedTabIndex = selectedIndex,
        modifier = Modifier.fillMaxWidth(),
        contentColor = Color.DarkGray,
        containerColor = Color.White,
       // colorResource(id = R.color.Brown)

    ) {
        tabs.forEachIndexed { index, tobeData ->

            Tab(selected = index == selectedIndex,
                onClick = {
                selectedIndex =index
            },
            ) {
                Text(text = tobeData.mytitle)

            }
        }

    }

}