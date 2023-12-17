package com.mahad.metaproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopAppBar(text: String) {
Column {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Image(
                /*painter = painterResource(id = R.drawable.ic_options)*/
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu Icon",
                modifier = Modifier.size(26.dp)
            )
        }
        Text(text = "Mahad Bakery", fontSize = 24.sp, fontStyle = androidx.compose.ui.text.font.FontStyle.Italic,
            style = TextStyle(
                fontSize = 24.sp,
                color = Color.Magenta,
//                shadow = Shadow(color = Color.LightGray,
//                    offset = Offset(8f, 8f),
//                    blurRadius = 4f)
            )
        )
        IconButton(onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.ic_shoppingbag),
                contentDescription = "Menu Icon",
                modifier = Modifier.size(24.dp)
            )
        }

    }
    Divider(
        thickness = 2.dp, color = Color(0xFFD91304)
    )
}
}


@Preview
@Composable
fun TopAppBarPrev() {
    TopAppBar(text = "Bakery")
}