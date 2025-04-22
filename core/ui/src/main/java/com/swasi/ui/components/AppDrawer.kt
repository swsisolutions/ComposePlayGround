package com.swasi.ui.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun AppDrawer(
    drawerItems: List<DrawerItem>,
    onDrawerItemClicked: (String) -> Unit
) {
    Log.e("Siba", "TopDrawerContent()....")
    val selectedRoute = remember { mutableStateOf("") }
    drawerItems.forEachIndexed { index, drawerItem ->
        DrawerListItem(
            drawerItem = drawerItem,
            selectedRoute = selectedRoute,
            showDivider = drawerItems.size > 1 && index % 2 == 0,
        ) { route ->
            selectedRoute.value = route
            onDrawerItemClicked.invoke(route)
        }
    }
}

@Composable
private fun DrawerListItem(
    drawerItem: DrawerItem,
    selectedRoute: MutableState<String>,
    showDivider: Boolean = false,
    onDrawerItemClicked: (String) -> Unit
) {
    Log.e("TINTIN", "DrawerListItem()....")
    Column(Modifier.fillMaxWidth()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .clickable {
                    selectedRoute.value = drawerItem.route
                    onDrawerItemClicked.invoke(drawerItem.route)
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            val tintColor =
                if (selectedRoute.value == drawerItem.route)
                    MaterialTheme.colorScheme.primary else Color.Black

            if (drawerItem.icon != null) {
                Icon(
                    imageVector = drawerItem.icon,
                    contentDescription = "Localized description",
                    tint = tintColor
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
            Column(horizontalAlignment = Alignment.Start) {
                AppText(
                    text = drawerItem.title
                )
                Spacer(modifier = Modifier.width(8.dp))
                AppText(
                    text = drawerItem.subTitle
                )
            }

        }
        if (showDivider) Divider()
    }
}

data class DrawerItem(
    val title: String,
    val icon: ImageVector? = null,
    val subTitle: String = "",
    val route: String = ""
)