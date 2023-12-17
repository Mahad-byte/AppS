package com.mahad.metaproject

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GridCell(numbers: Int) {
    Card(
        elevation = CardDefaults.cardElevation(16.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Box(modifier = Modifier
            .requiredSize(180.dp, 180.dp)
            .padding(8.dp)){
//            Image(painter = painterResource(id = R.drawable.black), contentDescription = null,
//                contentScale = ContentScale.FillBounds)
            Text(
                text = "Greek Salad",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .background(Color.White)
                    .align(Alignment.TopStart)
            )
            Text(
                text = "$12.99",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 4.dp, end = 4.dp)
                    .background(Color.White)
                    .align(Alignment.BottomEnd)
            )
        }
    }
}

@Preview
@Composable
fun MenuGrid() {
//    Column(Modifier.verticalScroll(rememberScrollState())) {
//        repeat(10) {
//            Row(Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceEvenly) {
//                repeat(2) {
//                    GridCell()
//                }
//            }
//        }
//    }
    LazyVerticalGrid(columns = GridCells.Fixed(3)){
        items(count = 500){numbers->
            GridCell(numbers)
        }
    }
}