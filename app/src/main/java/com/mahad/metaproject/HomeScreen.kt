package com.mahad.metaproject

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mahad.metaproject.ui.theme.PurpleGrey40


@Composable
fun HomeScreen(navController: NavController) {
    Column() {
        //Use navController to navigate
        UpperPanel(navController)
        Divider(color = Color.Black, thickness = 2.dp)
        LowerPanel(navController)
    }
}



//@Preview
@Composable
fun UpperPanel(navController:NavController) {
    val context = LocalContext.current
    var alfaimage by remember {
        mutableStateOf(0f)
    }
    val animatealfaimg by animateFloatAsState(targetValue = alfaimage, animationSpec = tween(1000))
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxWidth()
            .background(BakeryColor.pink)
    ) {
        Text(
            text = "Mahad's Bakery",
            modifier = Modifier.padding(start = 20.dp, top = 20.dp),
            style = TextStyle(
                fontSize = 24.sp,
                color = Color.White,
//                shadow = Shadow(color = Color.Black,
//                    offset = Offset(8f, 8f),
//                    blurRadius = 4f)
            )
        )
        Text(
            text = "Pakistan",
            fontSize = 24.sp,
            modifier = Modifier.padding(start = 20.dp),
            style = TextStyle(
                fontSize = 24.sp,
                color = Color.Black,
//                shadow = Shadow(color = Color.Black,
//                    offset = Offset(8f, 8f),
//                    blurRadius = 4f)
            )
        )
        Row(
            Modifier
                .padding(20.dp)
                /*.clickable { alfaimage += 1f }*/, horizontalArrangement = Arrangement.Start
        ) {
            Text(text = "Welcome to Mahad's Bakery Worlds best know bakery!!!",
                Modifier.width(200.dp),
                color = Color.DarkGray,
                fontSize = 21.sp)
            Image(painter = painterResource(id = R.drawable.images),
                contentDescription = "Some Image",
                Modifier
                    .size(130.dp)
                    .clip(RoundedCornerShape(10))
//                    .alpha(alpha = animatealfaimg),
                ,contentScale = ContentScale.FillWidth
            )
        }
        Button(
            onClick = {
                navController.navigate(MenuDetail.route)
            },
            shape = RoundedCornerShape(50),
            modifier = Modifier.padding(horizontal = 20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = PurpleGrey40),
        ) {
            Text(text = "Order Take Away", color = Color.White)
        }
    }
//    Row(
//        horizontalArrangement = Arrangement.Center
//    ) {
//        val counter = remember {
//            mutableStateOf(0)
//        }
//        Text(
//            text = "Clicks: ${counter.value}",
//            modifier = Modifier.clickable { counter.value += 1 },
//            color = Color.Black
//        )
//}
}
@Composable
private fun LowerPanel(navController: NavController) {
    Column {
        LazyRow(state = rememberLazyListState()) {
            items(Categories){category->
                MenuCategory(category)
            }
        }
        Divider(color = Color.Black, thickness = 2.dp)
        MenuDish(navController)
    }
}
@Composable
fun MenuCategory(category: String) {
    Button(
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(PurpleGrey40),
        shape = RoundedCornerShape(40),
        modifier = Modifier.padding(5.dp)
    ) {
        Text(
            text = category
        )
    }
}


@Composable
fun MenuDish(navController: NavController) {
    LazyColumn {
        items(Dishes) { Dish ->
            MenuDishhh(Dish ,navController)
        }
    }
}
