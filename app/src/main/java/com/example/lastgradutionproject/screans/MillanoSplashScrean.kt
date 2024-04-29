package com.example.lastgradutionproject.screans

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.navigation.MillanoScreans
import kotlinx.coroutines.delay

@Composable
fun MillanoSplashScrean(navController: NavController){
    val scale= remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true){
        scale.animateTo(targetValue = 0.9f,
            animationSpec = tween(durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f).getInterpolation(it)
                })
        )
        delay(2000L)
        navController.navigate(MillanoScreans.OnBordingScrean.name)

    }
    Card(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(),
        colors = CardDefaults.cardColors(colorResource(id = R.color.sky)),

        //color = contentColorFor(backgroundColor = colorResource(id = R.color.sky))
    ){

    }
    Column(
        modifier = Modifier.padding(top = 60.dp, bottom = 200.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Surface (modifier = Modifier.size(110.dp),
            shape = CircleShape
        ){
            Image(
                modifier = Modifier.size(120.dp),
                painter = painterResource(id = R.drawable.img_1), contentDescription = "")


        }
        Text(text = "MILLANO",
            // modifier = Modifier.size(30.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp, color = Color.White
        )
        Text(text = "Clothing And More",
             modifier = Modifier.padding(start = 20.dp),
            fontWeight = FontWeight.SemiBold,
            fontSize = 21.sp, color = Color.White
        )


    }

}