package com.mahad.metaproject

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mahad.metaproject.ui.theme.Pink80
import com.mahad.metaproject.ui.theme.Purple80
import com.mahad.metaproject.ui.theme.PurpleGrey80

@Composable
fun MenuContent(paddingValues: PaddingValues, navController: NavController) {
    Surface(modifier = Modifier.padding(paddingValues)) {
        val menuPadding = 8.dp
        val configuration = LocalConfiguration.current
        when (configuration.orientation) {
            Configuration.ORIENTATION_LANDSCAPE -> {
                Column{
                    Row(modifier = Modifier.weight(0.5f))
                    {
                        Text(
                            "Appetizers",
                            modifier = Modifier
                                .weight(0.25f)
                                .background(Purple80)
                                .padding(menuPadding)
                                .fillMaxSize()
                        )
                        Text(
                            "Salads",
                            modifier = Modifier
                                .weight(0.25f)
                                .padding(menuPadding)
                                .fillMaxSize()
                        )
                    }
                    Row(modifier = Modifier.weight(0.5f))
                    {
                        Text(
                            "Drinks",
                            modifier = Modifier
                                .weight(0.25f)
                                .background(Pink80)
                                .padding(menuPadding)
                                .fillMaxSize()
                        )
                        Text(
                            "Mains",
                            modifier = Modifier
                                .weight(0.25f)
                                .background(PurpleGrey80)
                                .padding(menuPadding)
                                .fillMaxSize()
                        )
                    }
                }
            }
            else ->{
                Column {
                    Text(
                        "Appetizers",
                        modifier = Modifier
                            .weight(0.25f)
                            .background(Purple80)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                    Text(
                        "Salads",
                        modifier = Modifier
                            .weight(0.25f)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                    Text(
                        "Drinks",
                        modifier = Modifier
                            .weight(0.25f)
                            .background(Pink80)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                    Text(
                        "Mains",
                        modifier = Modifier
                            .weight(0.25f)
                            .background(PurpleGrey80)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}