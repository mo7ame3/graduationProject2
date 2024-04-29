package com.example.lastgradutionproject.profile

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.navigation.MillanoScreans

@Composable
fun profile(navController: NavController,                loading:Boolean=false,
){

    Surface(color = Color.White) {
        Row {
            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "Arrow back",
                tint = Color.Black,
                modifier = Modifier
                    .size(45.dp)
                    .padding(start = 15.dp, top = 8.dp)
                    .clickable {
                        navController.navigate(MillanoScreans.HomeScrean.name)
                    }



            )
            Spacer(modifier = Modifier.width(65.dp))

        }
        Column(modifier = Modifier.padding(top = 110.dp)) {
            Row (modifier = Modifier.padding(top = 25.dp)){
                Card (modifier = Modifier
                    .fillMaxWidth()
                    .padding(3.dp)
                    .height(110.dp),
                    shape = RectangleShape,
                    colors = CardDefaults.cardColors(colorResource(id = R.color.gray))

                ){
                    Row {


                        Surface(
                            modifier = Modifier
                                .padding(top = 21.dp, start = 15.dp)

                                //.align(alignment = Alignment.CenterHorizontally)
                                .size(70.dp),

                            shape = CircleShape
                        ) {
                            Image(
                                modifier = Modifier.size(80.dp),
                                painter = painterResource(id = R.drawable.img_5),
                                contentDescription = ""
                            )


                        }
                        Text(text = "Ahmed Mohammed", fontWeight = FontWeight.SemiBold, fontSize = 17.sp,
                            color = Color.Black, modifier = Modifier.padding(top = 34.dp, start = 10.dp))
                        Column ( modifier = Modifier.padding(start = 50.dp)){



                            Text(text = "Edit Profile", fontWeight = FontWeight.Bold, fontSize = 14.sp
                                , modifier = Modifier
                                    .padding(top = 38.dp)
                                    .clickable {
                                        navController.navigate(MillanoScreans.editprofile.name)
                                    }, color = Color.Black
                            )
                            Card(
                                modifier = Modifier
                                    .width(74.dp)
                                    .height(3.dp)
                                    .padding(),
                                shape = RoundedCornerShape(4.dp),
                                colors = CardDefaults.cardColors(colorResource(id = R.color.black))


                            ) {
                            }
                        }
                    }
                }



            }

        }
        Column (modifier = Modifier.padding(top = 280.dp)){
            Spacer(modifier = Modifier.height(15.dp))


            Row {
                Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "",
                    modifier = Modifier
                        .padding(start = 25.dp)
                        .clickable {
                             navController.navigate(MillanoScreans.prossingscrean.name)

                        }
                        .size(30.dp),
                    tint = Color.Black
                )
                Text(text = "Shops", fontWeight = FontWeight.SemiBold, fontSize = 17.sp,
                    color = Color.Black, modifier = Modifier.padding( start = 7.dp)
                        .clickable {
                            navController.navigate(MillanoScreans.prossingscrean.name)

                        })


            }
            Spacer(modifier = Modifier.height(15.dp))



            Row {
                Image(modifier = Modifier
                    .size(55.dp)
                    .padding(start = 25.dp)
                    .clickable {
                         navController.navigate(MillanoScreans.Historyscrean.name)

                    },

                    painter = painterResource(id = R.drawable.history),
                     contentDescription = "",
                )
                Text(text = "History", fontWeight = FontWeight.SemiBold, fontSize = 17.sp,
                    color = Color.Black, modifier = Modifier.padding( start = 7.dp, top = 15.dp)
                        .clickable {
                            navController.navigate(MillanoScreans.Historyscrean.name)

                        })

            }
            Spacer(modifier = Modifier.height(16.dp))
            Row {
                Icon(imageVector = Icons.Filled.Favorite, contentDescription = "",
                    modifier = Modifier
                        .padding(start = 25.dp)
                        .clickable {
                            navController.navigate(MillanoScreans.favouritescrean.name)
                        }
                        .size(30.dp),
                    tint = Color.Red
                )
                Text(text = "Favorite", fontWeight = FontWeight.SemiBold, fontSize = 17.sp,
                    color = Color.Black, modifier = Modifier.padding( start = 7.dp)
                        .clickable {
                            navController.navigate(MillanoScreans.favouritescrean.name)

                        })


            }
            Spacer(modifier = Modifier.height(20.dp))

            Column ( modifier = Modifier.padding(start = 50.dp)){
                Text(text = "Logout", fontWeight = FontWeight.Bold, fontSize = 19.sp
                    , modifier = Modifier.padding()
                        .clickable {
                                   navController.navigate(MillanoScreans.LoginScrean.name)
                        }, color = Color.Black
                )
                Spacer(modifier = Modifier.height(1.dp))
               /* Card(
                    modifier = Modifier
                        .width(60.dp)
                        .height(4.dp)
                        .padding(top = 100.dp),
                    shape = RoundedCornerShape(4.dp),
                    colors = CardDefaults.cardColors(colorResource(id = R.color.black))


                ) {
                }*/
            }
            Column (verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally
            , modifier = Modifier.padding(top = 230.dp, start = 34.dp)){
                AddReport(
                    //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
                    loading = loading,
                    //validInputs = valid
                ) {
                   // onDone(Email.value.trim(), password.value.trim())
                    navController.navigate(MillanoScreans.reportscrean.name)

                }

            }



        }


    }
}
@Composable
fun AddReport(loading: Boolean,
               // validInputs: Boolean,
                onClick: () -> Unit) {
    Button(          onClick=onClick,
        modifier = Modifier
            .width(330.dp)
            .height(40.dp)
            .padding(start = 34.dp, end = 34.dp),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        //enabled = !loading && validInputs,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.sky))
    ) {

        Text(text = "Add Report", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)
        if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
    }


}
