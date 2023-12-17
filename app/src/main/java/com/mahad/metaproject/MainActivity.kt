package com.mahad.metaproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mahad.metaproject.ui.theme.MetaProjectTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MetaProjectTheme {
                MyApp()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val navController = rememberNavController()
    //Used to make top and bottom bar
    Scaffold(
        bottomBar = {  BottomNav(navController = navController) },
        topBar = {
            TopAppBar(text = "Bakery")
        }
    ) {contentPadding->
        Column(modifier = Modifier.padding(contentPadding)) {
            //For Navigation
            NavHost(
                navController = navController,
                startDestination = Home.route,
                modifier = Modifier.padding()
            ) {
                composable(Homebottom.route) {
                    HomeScreen(navController = navController)
                }
                composable(SettingB.route) {
                    SettingsScreen()
                }
                composable(ItemDetail.route) {
                    DishDetailsNoPara()
                }
                composable(MenuDetail.route){
                    MenuListScreen(navController = navController)
                }
            }
        }
    }
}
//
//@Composable
//fun Nav() {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = Homebottom.route, modifier = Modifier.padding()){
//        composable(Homebottom.route){
//            HomeScreen(navController = navController)
//        }
//        composable(MenuList.route){
//         MenuListScreen(navController)
//        }
//        composable(SettingB.route){
//            SettingsScreen()
//        }
//    }
//}

@Composable
fun BottomNav(navController: NavController) {
    val destinationList = listOf<DestinationBottom>(
        Homebottom,
        SettingB
    )
    val selectedIndex = rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar {
        destinationList.forEachIndexed{index, destinationBottom ->  
            NavigationBarItem(selected = index == selectedIndex.value,
                onClick = { selectedIndex.value = index
                    navController.navigate(destinationList[index].route){
                        popUpTo(Homebottom.route)
                        launchSingleTop = true
                    }
                          },
                icon = { Icon(imageVector = destinationBottom.icon, contentDescription = null)},
                label = { Text(text = destinationBottom.title)})
        }
    }
}

@Composable
private fun DishDetailsNoPara(){
    Column {
        val Dish:Dish
        DishDetails(Dish = Dish("","","",0))
    }

}