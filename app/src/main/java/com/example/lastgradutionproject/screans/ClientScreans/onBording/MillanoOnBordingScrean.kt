package com.example.lastgradutionproject.screans.ClientScreans.onBording

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
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
fun OnBording(navController: NavController){
    val scale= remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 = true){
        /*scale.animateTo(targetValue = 0.9f,
            animationSpec = tween(durationMillis = 800,
                easing = {
                    OvershootInterpolator(8f).getInterpolation(it)
                })
        )*/
        delay(2000L)
        navController.navigate(MillanoScreans.StartScrean.name)

    }


    Card (modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .fillMaxSize(),
        colors = CardDefaults.cardColors(colorResource(id = R.color.Brown))
    ){
        Image(modifier = Modifier
            .fillMaxWidth()
            .size(500.dp)
            .padding(1.dp, bottom = 30.dp),
            painter = painterResource(id = R.drawable.imd3), contentDescription ="" )
        Column(
            modifier = Modifier.padding(top = 60.dp, start = 9.dp),
            verticalArrangement = Arrangement.Bottom) {
            Text(text = "Explor", fontSize = 26.sp, fontWeight = FontWeight.Bold,
                color = Color.White)
            Text(text = "Modern Clothes", fontSize = 26.sp, fontWeight = FontWeight.Bold,
                color = Color.White)
            Spacer(modifier = Modifier.height(15.dp))

            Card (modifier = Modifier
                .width(107.dp)
                .height(8.dp),
                shape = RoundedCornerShape(4.dp)

            ){

            }
            Spacer(modifier = Modifier.height(15.dp))

            Text(text = "Discover Your Style", fontSize = 19.sp, fontWeight = FontWeight.SemiBold,
                color = Color.White)


        }


    }
}