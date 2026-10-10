package com.nexrelay.relqoruimock.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nexrelay.relqoruimock.ui.components.MockOnlyBanner
import com.nexrelay.relqoruimock.ui.components.ScreenHeader

@Composable
fun MoreScreen(
    openProfile: () -> Unit,
    openCheckIn: () -> Unit,
    openNearby: () -> Unit,
    openRescue: () -> Unit,
    openAbout: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ScreenHeader("Daha", "Mock feature ekranları")
        MockOnlyBanner()

        OutlinedButton(onClick = openProfile, modifier = Modifier.fillMaxWidth()) {
            Text("Emergency Profile")
        }
        OutlinedButton(onClick = openCheckIn, modifier = Modifier.fillMaxWidth()) {
            Text("İyi misin? Check-In")
        }
        OutlinedButton(onClick = openNearby, modifier = Modifier.fillMaxWidth()) {
            Text("Yakındaki Yardım")
        }
        OutlinedButton(onClick = openRescue, modifier = Modifier.fillMaxWidth()) {
            Text("Local Rescue Channel")
        }
        OutlinedButton(onClick = openAbout, modifier = Modifier.fillMaxWidth()) {
            Text("Hakkında")
        }
    }
}
