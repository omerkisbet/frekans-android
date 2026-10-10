package com.nexrelay.relqoruimock.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nexrelay.relqoruimock.mock.MockData
import com.nexrelay.relqoruimock.ui.components.*
import com.nexrelay.relqoruimock.ui.model.DeliveryStageUi
import com.nexrelay.relqoruimock.ui.model.SosTypeUi

@Composable
fun SosScreen() {
    var selected by remember { mutableStateOf(MockData.sos.selectedType) }
    var peopleCount by remember { mutableIntStateOf(MockData.sos.peopleCount) }
    var note by remember { mutableStateOf(MockData.sos.note) }
    var stage by remember { mutableStateOf(MockData.sos.deliveryStage) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        ScreenHeader(
            title = "SOS",
            subtitle = "Tasarımı sıfırdan değiştirilebilir; davranış yalnız mock state'tir."
        )
        MockOnlyBanner()

        SimpleSection("Acil durum") {
            SosTypeUi.entries.chunked(2).forEach { rowItems ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    rowItems.forEach { type ->
                        if (selected == type) {
                            Button(
                                onClick = { selected = type },
                                modifier = Modifier.weight(1f)
                            ) { Text(type.label) }
                        } else {
                            OutlinedButton(
                                onClick = { selected = type },
                                modifier = Modifier.weight(1f)
                            ) { Text(type.label) }
                        }
                    }
                    if (rowItems.size == 1) Spacer(Modifier.weight(1f))
                }
            }
        }

        SimpleSection("Kişi sayısı") {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedButton(
                    onClick = { if (peopleCount > 1) peopleCount-- }
                ) { Text("−") }
                StateBadge("$peopleCount kişi")
                OutlinedButton(onClick = { peopleCount++ }) { Text("+") }
            }
        }

        OutlinedTextField(
            value = note,
            onValueChange = { note = it.take(160) },
            label = { Text("Kısa not") },
            supportingText = { Text("${note.length}/160") },
            modifier = Modifier.fillMaxWidth(),
            minLines = 3
        )

        KeyValueRow(
            "Konum",
            if (MockData.sos.locationReady) "Hazır" else "Hazır değil"
        )
        KeyValueRow(
            "Relay",
            if (MockData.sos.relayActive) "Aktif" else "Kapalı"
        )

        Button(
            onClick = { stage = DeliveryStageUi.QUEUED },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Mock SOS oluştur")
        }

        StateBadge(stage.label, positive = stage != DeliveryStageUi.FAILED)
    }
}
