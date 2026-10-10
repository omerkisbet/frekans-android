package com.nexrelay.relqoruimock.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nexrelay.relqoruimock.ui.components.MockOnlyBanner
import com.nexrelay.relqoruimock.ui.components.ScreenHeader

@Composable
fun PreviewHomeScreen(
    openSos: () -> Unit,
    openNetwork: () -> Unit,
    openStatus: () -> Unit,
    openProfile: () -> Unit,
    openCheckIn: () -> Unit,
    openNearby: () -> Unit,
    openRescue: () -> Unit,
    openAbout: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        ScreenHeader(
            title = "Relqor UI Preview",
            subtitle = "Bu ekran production navigation değildir. UI Developer'ın tüm mock ekranlara erişmesi içindir."
        )

        MockOnlyBanner()

        Text(
            text = "Mevcut ürün yüzleri",
            style = MaterialTheme.typography.titleMedium
        )

        Button(onClick = openSos, modifier = Modifier.fillMaxWidth()) { Text("SOS") }
        OutlinedButton(onClick = openNetwork, modifier = Modifier.fillMaxWidth()) { Text("Ağ") }
        OutlinedButton(onClick = openStatus, modifier = Modifier.fillMaxWidth()) { Text("Durum") }
        OutlinedButton(onClick = openAbout, modifier = Modifier.fillMaxWidth()) { Text("Hakkında") }

        Spacer(Modifier.height(8.dp))

        Text(
            text = "Smart SOS mock yüzleri",
            style = MaterialTheme.typography.titleMedium
        )

        OutlinedButton(onClick = openProfile, modifier = Modifier.fillMaxWidth()) { Text("Emergency Profile") }
        OutlinedButton(onClick = openCheckIn, modifier = Modifier.fillMaxWidth()) { Text("İyi misin? Check-In") }
        OutlinedButton(onClick = openNearby, modifier = Modifier.fillMaxWidth()) { Text("Yakındaki Yardım") }
        OutlinedButton(onClick = openRescue, modifier = Modifier.fillMaxWidth()) { Text("Local Rescue Channel") }
    }
}
