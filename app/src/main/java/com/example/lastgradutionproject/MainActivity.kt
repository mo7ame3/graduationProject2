package com.example.lastgradutionproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lastgradutionproject.navigation.MillanoNavigation
import com.example.lastgradutionproject.ui.theme.LastGradutionProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class MainActivity : ComponentActivity() {
    companion object{
    val items:List<Item> = listOf(
        Item(
            title="item1",
            image =R.drawable.img_8
        ),
        Item(
            title="item1",
            image =R.drawable.img_9
        ),
        Item(
            title="item1",
            image =R.drawable.img_10
        ),


        )}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LastGradutionProjectTheme {
                MillanoApp()

                // A surface container using the 'background' color from the theme
            }
        }
    }
}
@Composable
fun MillanoApp(){
    Surface(
        // contentColor = colorResource(id = R.color.sky)

        modifier = Modifier.fillMaxSize(),
        // color = MaterialTheme.colorScheme.background
    ) {
        MillanoNavigation()

    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LastGradutionProjectTheme {
    }
}