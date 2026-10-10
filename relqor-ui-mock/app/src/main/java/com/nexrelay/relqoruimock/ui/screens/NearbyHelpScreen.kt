package com.nexrelay.relqoruimock.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nexrelay.relqoruimock.mock.MockData
import com.nexrelay.relqoruimock.ui.components.*

@Composable
fun NearbyHelpScreen(
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextButton(onClick = onBack) { Text("← Geri") }
        ScreenHeader(
            title = "Yakındaki Yardım",
            subtitle = "Yalnız izin verilen acil özetleri gösteren mock liste."
        )
        MockOnlyBanner()

        MockData.nearbyHelp.forEach { item ->
            HorizontalDivider()
            StateBadge(item.safetyStatus.label)
            KeyValueRow("Yaklaşık mesafe", item.approximateDistance)
            KeyValueRow("Son bilinen alan", item.lastKnownArea)
            Text(item.emergencySummary)

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedButton(onClick = { }) { Text("Yakınımdayım") }
                Button(onClick = { }) { Text("Yardım edebilirim") }
            }
        }
    }
}
