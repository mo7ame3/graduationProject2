package com.example.lastgradutionproject

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun RoundedIcons(
    modifier: Modifier,
    imageVector: ImageVector,
    onClick :() -> Unit,
    tint: Color = Color.Black.copy(alpha = 0.8f),
    background:Color= Color.White,
    elevation: Dp=4.dp
){
    val IconbuttonSizeModifier=Modifier.size(40.dp)
    Card (modifier = Modifier
        .padding(all = 4.dp)
        .clickable { onClick.invoke() }
        .then(IconbuttonSizeModifier),
        shape = CircleShape,
        colors = CardDefaults.cardColors(colorResource(id = R.color.white))
    ){
Icon(imageVector = imageVector, contentDescription = "plus or minus" ,
    tint = tint,


)
    }

}