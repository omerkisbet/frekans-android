package com.nexrelay.relqoruimock.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nexrelay.relqoruimock.mock.MockData
import com.nexrelay.relqoruimock.ui.components.*

@Composable
fun NetworkScreen() {
    val state = MockData.network

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        ScreenHeader(
            title = "Ağ",
            subtitle = "UI yalnız özet state görür; transport ve routing implementasyonu bu repo'da yoktur."
        )
        MockOnlyBanner()

        StateBadge(
            label = if (state.relayActive) "Relay aktif" else "Relay kapalı",
            positive = state.relayActive
        )

        KeyValueRow("Yakın cihaz", "${state.peerCount}")
        KeyValueRow(
            "İnternet",
            if (state.internetAvailable) "Bağlı" else "Çevrimdışı"
        )
        KeyValueRow("Batarya", "%${state.batteryPercent}")
        KeyValueRow(
            "Konum",
            if (state.locationReady) "Hazır" else "Hazır değil"
        )
        KeyValueRow(
            "Gösterim adı",
            state.displayPeerName ?: "—"
        )

        HorizontalDivider()

        Text(
            text = "Not: peer discovery, bağlantı seçimi ve relay policy UI'nin sorumluluğu değildir.",
            style = MaterialTheme.typography.bodySmall
        )
    }
}
