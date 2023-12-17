package com.mahad.metaproject

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

interface Destinations{
    val route: String
}
//For normal navigation
object Home: Destinations{
    override val route: String = "HomeScreen"
}
object MenuDetail: Destinations{
    override val route: String = "Menudetail"
}

object Login: Destinations{
    override val route: String = "loginScreen"
}
object ItemDetail: Destinations{
    override val route: String = "Item detail"
}
//for bottom navigation
interface DestinationBottom{
    val route: String
    val icon:ImageVector
    val title: String
}

object Homebottom: DestinationBottom{
    override val route = "HomeScreen"
    override val icon = Icons.Filled.Home
    override val title = "Home"
}
object SettingB: DestinationBottom{
    override val route = "Setting"
    override val icon = Icons.Filled.Settings
    override val title = "Setting"
}