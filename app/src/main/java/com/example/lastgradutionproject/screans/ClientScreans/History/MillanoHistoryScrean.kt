package com.example.lastgradutionproject.screans.ClientScreans.History

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.navigation.MillanoScreans

@Composable
fun HistoryScrean(navController: NavController,
                  movieList:List<String> = listOf("Item1","Item2","Item3","Item4","Item5","Item6","Item7")
){
    Surface(color = Color.White) {
        Row (modifier = Modifier.padding(top = 40.dp)){
            Text(
                text = "Order",
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
                modifier = Modifier.padding(start = 10.dp),
               color = Color.Black
            )
            Spacer(modifier = Modifier.width(195.dp))
            Text(
                text = "Clear History",
                fontWeight = FontWeight.Bold,
                fontSize = 19.sp,
                modifier = Modifier,
                color = Color.LightGray
            )



        }
        Column(modifier = Modifier.padding(top = 150.dp)) {
            LazyColumn{
                items(items = movieList){

MovieRow(navController = navController, movie = it)                }

            }






        }
        Column (verticalArrangement = Arrangement.Bottom){
            Card (modifier = Modifier
                .fillMaxWidth()
                .height(45.dp),
                shape = RoundedCornerShape(corner = CornerSize(7.dp)),
                colors = CardDefaults.cardColors(colorResource(id = R.color.white))
            ){
                Row {
                    Icon(imageVector = Icons.Filled.Home, contentDescription = "",
                        modifier = Modifier
                            .padding(start = 30.dp, top = 5.dp)
                            .size(35.dp),
                        tint = Color.Black
                    )
                    // Spacer(modifier = Modifier.width(30.dp))
                    Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "",
                        modifier = Modifier
                            .padding(start = 60.dp, top = 5.dp)
                            .clickable {
                                navController.navigate(MillanoScreans.prossingscrean.name)

                            }
                            .size(35.dp),
                        tint = Color.Black
                    )
                    Icon(imageVector = Icons.Filled.FavoriteBorder, contentDescription = "",
                        modifier = Modifier
                            .padding(start = 60.dp, top = 5.dp)
                            .clickable {
                                navController.navigate(MillanoScreans.favouritescrean.name)
                            }
                            .size(35.dp),
                        tint = Color.Black
                    )
                    Icon(imageVector = Icons.Filled.Person, contentDescription = "",
                        modifier = Modifier
                            .padding(start = 60.dp, top = 5.dp)
                            .clickable {
                                navController.navigate(MillanoScreans.profilescrean.name)
                            }
                            .size(35.dp),
                        tint = Color.Black
                    )

                }

            }


        }


    }
    }
@Composable
fun MovieRow(navController: NavController,
             movie:String){
    Card (modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(100.dp),
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
        

    ){
Text(text = movie)
    }

}