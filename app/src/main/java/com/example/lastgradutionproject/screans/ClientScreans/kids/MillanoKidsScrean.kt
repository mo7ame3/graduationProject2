package com.example.lastgradutionproject.screans.ClientScreans.kids

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.navigation.MillanoScreans
import com.example.lastgradutionproject.womenshop

@Composable
fun kidsScrean(navController: NavController){
    Surface {
        Card (modifier = Modifier
            .fillMaxWidth()
            // .height(80.dp),
            .padding(top = 1.dp, bottom = 735.dp) ,
            colors = CardDefaults.cardColors(colorResource(id = R.color.Brown))){
            Row {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow back",
                    tint = Color.White,
                    modifier = Modifier
                        .size(45.dp)
                        .padding(start = 15.dp, top = 8.dp)
                        .clickable {
                            navController.navigate(MillanoScreans.LoginScrean.name)
                        }



                )
                Spacer(modifier = Modifier.width(65.dp))
                Text(text = " Shop Kids",
                    fontWeight = FontWeight.SemiBold, fontSize = 24.sp,
                    modifier = Modifier.padding(top = 9.dp))

            }

        }

    }
    Row (modifier = Modifier.padding(top = 70.dp, start = 8.dp)){
        Column {
            Card (
                shape = CircleShape,
                modifier = Modifier.size(80.dp),
                colors = CardDefaults.cardColors(colorResource(id = R.color.white))

            ){

            }
            Text(text = "Women", fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(start = 11.dp)
                    .clickable {
                        navController.navigate(MillanoScreans.WomenScrean.name)
                    })

        }
        Spacer(modifier = Modifier.width(10.dp))
        Column {
            Card (
                shape = CircleShape,
                modifier = Modifier.size(80.dp),
                colors = CardDefaults.cardColors(colorResource(id = R.color.white))

            ){

            }
            Text(text = "Men", fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(start = 17.dp)
                    .clickable {

                    })

        }
        Spacer(modifier = Modifier.width(10.dp))

        Column {
            Card (
                shape = CircleShape,
                modifier = Modifier.size(80.dp),
                colors = CardDefaults.cardColors(colorResource(id = R.color.white))

            ){

            }
            Text(text = "Kids", fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(start = 17.dp)
                    .clickable {

                    })

        }
        Spacer(modifier = Modifier.width(10.dp))

        Column {
            Card (
                shape = CircleShape,
                modifier = Modifier.size(80.dp),
                colors = CardDefaults.cardColors(colorResource(id = R.color.white))

            ){

            }
            Text(text = "Shoses", fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(start = 13.dp)
                    .clickable {

                    })

        }


    }
    Column (modifier = Modifier.padding(top = 200.dp)){
        LazyVerticalGrid(modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(vertical = 16.dp),
            columns = GridCells.Fixed(2)
        ){
            itemsIndexed(womenshop.womenitems){ index: Int, item ->

                com.example.lastgradutionproject.screans.ClientScreans.Women.GridItem(item =item)
                Spacer(modifier = Modifier.height(8.dp))




            }

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
                        .size(35.dp),
                    tint = Color.Black
                )
                Icon(imageVector = Icons.Filled.FavoriteBorder, contentDescription = "",
                    modifier = Modifier
                        .padding(start = 60.dp, top = 5.dp)
                        .size(35.dp),
                    tint = Color.Black
                )
                Icon(imageVector = Icons.Filled.Person, contentDescription = "",
                    modifier = Modifier
                        .padding(start = 60.dp, top = 5.dp)
                        .size(35.dp),
                    tint = Color.Black
                )

            }

        }


    }


}
@Composable
fun GridItem(item: womenshop){
    Column (modifier = Modifier
        .height(250.dp)
        .width(200.dp)
        .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(modifier = Modifier
            .size(200.dp)
            .clip(RoundedCornerShape(30.dp)),
            //.height(300.dp),
            painter = painterResource(id = item.Image), contentDescription = item.Title,
            contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.Title, fontWeight = FontWeight.SemiBold)
    }

}