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

@Composable
fun RescueChannelScreen(
    onBack: () -> Unit
) {
    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        TextButton(onClick = onBack) { Text("← Geri") }

        ScreenHeader(
            title = "Local Rescue Channel",
            subtitle = "Genel chat değil; kısa olay koordinasyonu için mock ekran."
        )
        MockOnlyBanner()

        MockData.rescueMessages.forEach { item ->
            HorizontalDivider()
            KeyValueRow(item.type.name, item.timeLabel)
            Text(item.senderLabel, style = MaterialTheme.typography.labelMedium)
            Text(item.text)
        }

        OutlinedTextField(
            value = message,
            onValueChange = { message = it.take(160) },
            label = { Text("Kısa olay mesajı") },
            supportingText = { Text("${message.length}/160") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { message = "" },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Mock gönder")
        }
    }
}
