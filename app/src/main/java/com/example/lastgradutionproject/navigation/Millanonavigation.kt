package com.example.lastgradutionproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lastgradutionproject.profile.profile
import com.example.lastgradutionproject.screans.ClientScreans.Edit.Edit
import com.example.lastgradutionproject.screans.ClientScreans.Fav.favourite
import com.example.lastgradutionproject.screans.ClientScreans.History.HistoryScrean
import com.example.lastgradutionproject.screans.ClientScreans.HomeScrean.Home
import com.example.lastgradutionproject.screans.ClientScreans.Login.LoginScrean
import com.example.lastgradutionproject.screans.ClientScreans.Men.menScrean
import com.example.lastgradutionproject.screans.ClientScreans.OrderScrean.Order
import com.example.lastgradutionproject.screans.ClientScreans.Report.Report
import com.example.lastgradutionproject.screans.ClientScreans.Shipped.Shipping
import com.example.lastgradutionproject.screans.ClientScreans.SignUp.SignUp
import com.example.lastgradutionproject.screans.ClientScreans.Women.womenScrean
import com.example.lastgradutionproject.screans.ClientScreans.kids.kidsScrean
import com.example.lastgradutionproject.screans.ClientScreans.onBording.OnBording
import com.example.lastgradutionproject.screans.ClientScreans.prossing.prossing
import com.example.lastgradutionproject.screans.ClientScreans.shoses.shosesScreans
import com.example.lastgradutionproject.screans.MillanoSplashScrean
import com.example.lastgradutionproject.screans.mangerScreen.control.ControlScreen
import com.example.lastgradutionproject.screans.startScrean.StartScrean

@Composable
fun MillanoNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MillanoScreans.ControlScreen.name) {
        composable(MillanoScreans.SplashScrean.name){
            MillanoSplashScrean(navController=navController)
        }
        composable(MillanoScreans.OnBordingScrean.name){
            OnBording(navController=navController)
        }
        composable(MillanoScreans.StartScrean.name){
            StartScrean(navController=navController)
        }
        composable(MillanoScreans.LoginScrean.name){
            LoginScrean(navController=navController)
        }
        composable(MillanoScreans.SignUpScrean.name){
            SignUp(navController=navController)
        }
        composable(MillanoScreans.HomeScrean.name){
            Home(navController=navController)
        }
        composable(MillanoScreans.OrderScrean.name){
            Order(navController=navController)

        }

        composable(MillanoScreans.WomenScrean.name){
            womenScrean(navController=navController)
        }

        composable(MillanoScreans.MenScrean.name){
            menScrean(navController=navController)
        }
        composable(MillanoScreans.KidsScrean.name){
            kidsScrean(navController=navController)
        }
        composable(MillanoScreans.ShosesScrean.name){
            shosesScreans(navController=navController)
        }
        composable(MillanoScreans.Historyscrean.name){
            HistoryScrean(navController=navController)
        }
        composable(MillanoScreans.prossingscrean.name){
            prossing(navController=navController)
        }
        composable(MillanoScreans.shipingscrean.name){
            Shipping(navController=navController)
        }
        composable(MillanoScreans.favouritescrean.name){
            favourite(navController=navController)
        }
        composable(MillanoScreans.profilescrean.name){
            profile(navController=navController)
        }
        composable(MillanoScreans.editprofile.name){
            Edit(navController=navController)
        }
        composable(MillanoScreans.reportscrean.name){
            Report(navController=navController)
        }
        composable(MillanoScreans.ControlScreen.name){
            ControlScreen(navController=navController)
        }















    }

}