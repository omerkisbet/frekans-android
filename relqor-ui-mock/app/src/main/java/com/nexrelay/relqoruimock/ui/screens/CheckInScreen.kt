package com.nexrelay.relqoruimock.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nexrelay.relqoruimock.mock.MockData
import com.nexrelay.relqoruimock.ui.components.*
import com.nexrelay.relqoruimock.ui.model.SafetyStatusUi

@Composable
fun CheckInScreen(
    onBack: () -> Unit
) {
    var status by remember { mutableStateOf(MockData.checkIn.status) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextButton(onClick = onBack) { Text("← Geri") }

        ScreenHeader(
            title = "İyi misin?",
            subtitle = "Afet / olay sonrası güvenlik kontrolü mock ekranı."
        )
        MockOnlyBanner()

        KeyValueRow("Olay", MockData.checkIn.incidentLabel)
        KeyValueRow("Bölge", MockData.checkIn.areaLabel)
        KeyValueRow("Saat", MockData.checkIn.incidentTimeLabel)

        Button(
            onClick = { status = SafetyStatusUi.SAFE },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Güvendeyim")
        }

        Button(
            onClick = { status = SafetyStatusUi.HELP_REQUESTED },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error
            )
        ) {
            Text("Yardıma ihtiyacım var")
        }

        StateBadge(status.label)

        Text(
            text = "NO_RESPONSE kullanılırsa UI yalnızca \"Durum teyit edilemedi\" der; kesin tehlike iddiası üretmez.",
            style = MaterialTheme.typography.bodySmall
        )
    }
}
