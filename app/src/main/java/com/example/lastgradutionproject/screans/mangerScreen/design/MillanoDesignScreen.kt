package com.example.lastgradutionproject.screans.mangerScreen.design

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.data.Design
import com.example.lastgradutionproject.screans.mangerScreen.control.TextTitle

@Composable
fun DesignScreen(navController: NavController) {
    val listCart = listOf<Design>(
        Design(pic = R.drawable.img_1, designName = "item1", designDescription = "koton 100%"),
        Design(pic = R.drawable.img_2, designName = "item2", designDescription = "koton 95%"),
        Design(pic = R.drawable.img_3, designName = "item3", designDescription = "koton 90%"),
        Design(pic = R.drawable.img_4, designName = "item4", designDescription = "koton 85%"),
        Design(pic = R.drawable.img_5, designName = "item5", designDescription = "koton 80%"),
        Design(pic = R.drawable.img_6, designName = "item6", designDescription = "koton 75%"),
        Design(pic = R.drawable.img_7, designName = "item7", designDescription = "koton 70%"),
        Design(pic = R.drawable.img_8, designName = "item8", designDescription = "koton 65%"),
        Design(pic = R.drawable.img_9, designName = "item9", designDescription = "koton 60%"),
        Design(pic = R.drawable.img_10, designName = "item10", designDescription = "koton 50%"),
        Design(pic = R.drawable.img_11, designName = "item11", designDescription = "koton 40%"),
        Design(pic = R.drawable.img_12, designName = "item12", designDescription = "koton 10%"),
        Design(pic = R.drawable.img_13, designName = "item13", designDescription = "no koton"),
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextTitle(text = "Ready designs...")
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Icon(imageVector = Icons.Default.Person, contentDescription = null)
                Text(
                    text = "Profile",
                    textDecoration = TextDecoration.Underline,
                    modifier = Modifier.clickable { })
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        LazyColumn {
            items(items = listCart) {
                DesignCard(
                    pic = it.pic,
                    designName = it.designName,
                    designDescription = it.designDescription
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}


@Composable
fun DesignCard(pic: Int, designName: String, designDescription: String) {
    Card(
        shape = RoundedCornerShape(15.dp),
        border = BorderStroke(1.dp, Color.Black),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        ),
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopStart) {
            Row {
                Image(
                    painter = painterResource(id = pic),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(90.dp),
                    contentScale = ContentScale.FillHeight
                )

                Column(
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier.padding(start = 10.dp)
                ) {
                    Text(text = designName)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = designDescription)
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 5.dp),
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                        //back end request to post
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black
                    ),
                ) {
                    Text(text = "Accept")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    onClick = {
                        //back end request to delete
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        contentColor = Color.Black,
                    ),
                ) {
                    Text(text = "Cancel")
                }
            }

        }

    }
}