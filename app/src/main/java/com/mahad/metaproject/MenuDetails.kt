package com.mahad.metaproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mahad.metaproject.ui.theme.Pink80

//State hoisting
//@Composable
//fun ItemOrder(count: Int, OnIncrement: () -> Unit, OnDecrement: () -> Unit) {
//
//    Column(horizontalAlignment = Alignment.CenterHorizontally){
//        Text(text = "Greek Salad", fontSize = 30.sp)
//        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
//            IconButton(onClick = { OnDecrement() }) {
//                Icon(Icons.Default.Delete, contentDescription = "Remove")
//            }
//            Text(
//                text = "$count",
//                fontSize = 28.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.padding(8.dp)
//            )
//            IconButton(onClick = { OnIncrement() }) {
//                Icon(Icons.Default.Add, contentDescription = "Add")
//            }
//        }
//
//    }
//}
////@Preview
//@Composable
//fun OrderCount(navController: NavController) {
//    var count by rememberSaveable {
//        mutableStateOf(0)
//    }
//    ItemOrder(count, {count++}, {count--})
//}


@Composable
fun MenuListScreen(navController: NavController) {
    LowerPanelll(navController)
}


@Composable
fun MenuDishhh(Dish: Dish, navController: NavController) {
    Card(
        modifier = Modifier.clickable {
            navController.navigate(ItemDetail.route)
        },
        colors = CardDefaults.cardColors(Pink80)
        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {

            Column(){
                Text(text = Dish.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = Dish.description,
                    fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black, modifier = Modifier
                        .padding(top = 5.dp, bottom = 5.dp)
                        .fillMaxWidth(.75f))
                Text(text = Dish.price, color = Color.Black, fontWeight = FontWeight.Bold)
            }
            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "An image")
        }
    }
    Divider(color = Color.Black,
        thickness = 1.dp)
}
@Composable
fun LowerPanelll(navController: NavController) {
    Column {
        LazyColumn(state = rememberLazyListState()) {
            items(Dishes) { Dish ->
                MenuDishhh(Dish, navController)
            }
        }
    }
}


val Categories = listOf(
    "Lunch",
    "Dessert",
    "A La Carte",
    "Mains",
    "Specials"
)

data class Dish(
    val name: String,
    val price: String,
    val description: String,
    val image: Int
)

val Dishes = listOf(
    Dish(
        "Greek Salad",
        "$12.99",
        "The famous greek salad of crispy lettuce, peppers, olives and our Chicago...",
        R.drawable.images
    ),
    Dish(
        "Bruschetta",
        "$5.99",
        "Our Bruschetta is made from grilled bread that has been smeared with garlic...",
        R.drawable.images
    ),
    Dish(
        "Lemon Dessert",
        "$9.99",
        "This comes straight from grandma recipe book, every last ingredient has...",
        R.drawable.images
    ),
)