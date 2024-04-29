package com.example.lastgradutionproject.screans.ClientScreans.HomeScrean

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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
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
import com.example.lastgradutionproject.Home
import com.example.lastgradutionproject.MainActivity
import com.example.lastgradutionproject.Item
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.navigation.MillanoScreans

@Composable
fun Home(navController: NavController){
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
                Spacer(modifier = Modifier.width(260.dp))
                Icon(imageVector = Icons.Default.Search, contentDescription = "Arrow back",
                    tint = Color.White,
                    modifier = Modifier
                        .size(45.dp)
                        .padding(top = 8.dp)
                        .clickable {
                            //navController.navigate(MillanoScreans.LoginScrean.name)
                        }



                )


            }

        }

    }
    Row (modifier = Modifier.padding(top = 60.dp, start = 8.dp)){
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
                        navController.navigate(MillanoScreans.MenScrean.name)

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
                        navController.navigate(MillanoScreans.KidsScrean.name)

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
                        navController.navigate(MillanoScreans.ShosesScrean.name)

                    })

        }


    }
    Column (modifier = Modifier.padding(top = 160.dp)){
        Text(text = "Shop Offers",

            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,



            modifier = Modifier
                .padding(start = 15.dp)
        )
        Spacer(modifier = Modifier.height(3.dp))



        LazyRow(modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ){
            itemsIndexed(MainActivity.items){ index: Int, item ->
                Spacer(modifier = Modifier.width(8.dp))

                RowItem(item = item,navController=navController)
                Spacer(modifier = Modifier.width(8.dp))


            }

        }




    }

    Column (modifier = Modifier.padding(top = 94.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "Modern", fontWeight = FontWeight.Bold,
            fontSize = 34.sp,
            //modifier = Modifier.padding(start = 50.dp)

        )
        Spacer(modifier = Modifier.height(3.dp))
        Row {


            Card(
                modifier = Modifier
                    .width(70.dp)
                    .height(5.dp)
                    .padding(),
                shape = RoundedCornerShape(4.dp),
                colors = CardDefaults.cardColors(colorResource(id = R.color.black))


            ) {

            }
            Spacer(modifier = Modifier.width(8.dp))


            Text(
                text = "Clothes", fontWeight = FontWeight.Bold,
                fontSize = 34.sp,


                )
            Spacer(modifier = Modifier.width(8.dp))

            Card(
                modifier = Modifier
                    .width(80.dp)
                    .height(5.dp),
                shape = RoundedCornerShape(4.dp),
                colors = CardDefaults.cardColors(colorResource(id = R.color.black))



            ) {

            }
        }

        Text(text = "Discover your Catagory", fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = Color.LightGray


            )




    }
    Column (modifier = Modifier.padding(top = 485.dp),
       // verticalArrangement = Arrangement.Bottom,
        ){
        Text(text = "New In",

            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,



            modifier = Modifier
                .padding(start = 15.dp)
        )
        Spacer(modifier = Modifier.height(3.dp))

        LazyRow(modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ){
            itemsIndexed(Item.items){ index: Int, item ->
                Spacer(modifier = Modifier.width(8.dp))

                Rowitem(item = item,navController=navController)
                Spacer(modifier = Modifier.width(8.dp))


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
@Composable
fun RowItem(item:Item,
            navController: NavController){
    Column (modifier = Modifier
        .height(170.dp)
        .width(320.dp)){
        Image(modifier = Modifier
            .clickable {
                navController.navigate(MillanoScreans.OrderScrean.name)
            }
            .fillMaxWidth()
            .height(300.dp)
            .clip(RoundedCornerShape(30.dp)),
            painter = painterResource(id = item.image), contentDescription = item.title,
            contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.title, fontWeight = FontWeight.SemiBold)
    }

}
@Composable
fun Rowitem(item: Home,navController: NavController){
    Column (modifier = Modifier
        .clickable {
            navController.navigate(MillanoScreans.OrderScrean.name)
        }
        .height(170.dp)
        .width(320.dp)){
        Image(modifier = Modifier

            .fillMaxWidth()
            .height(300.dp)
            .clip(RoundedCornerShape(30.dp)),
            painter = painterResource(id = item.imag), contentDescription = item.titl,
            contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.titl, fontWeight = FontWeight.SemiBold)
    }

}