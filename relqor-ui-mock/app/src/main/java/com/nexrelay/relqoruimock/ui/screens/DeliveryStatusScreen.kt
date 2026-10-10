package com.nexrelay.relqoruimock.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nexrelay.relqoruimock.mock.MockData
import com.nexrelay.relqoruimock.ui.components.*
import com.nexrelay.relqoruimock.ui.theme.RelqorTextSoft

@Composable
fun DeliveryStatusScreen() {
    val state = MockData.delivery

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        ScreenHeader(
            title = "Durum",
            subtitle = "Mesajın gerçek teslim aşaması."
        )
        MockOnlyBanner()

        StateBadge(state.stage.label)

        KeyValueRow(
            "Cihazda kayıt",
            if (state.localPersisted) "Evet" else "Hayır"
        )
        KeyValueRow(
            "Relay",
            if (state.relayed) "Gerçekleşti" else "Bekliyor"
        )
        KeyValueRow(
            "Merkez onayı",
            if (state.serverConfirmed) "Alındı" else "Bekleniyor"
        )
        KeyValueRow(
            "Mesaj",
            state.shortMessageId ?: "—"
        )

        Text(
            text = state.networkSummary,
            style = MaterialTheme.typography.bodyMedium
        )

        HorizontalDivider()

        Text(
            text = "UI KURALI",
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = "Merkez onayı gelmeden mesaj teslim edilmiş sayılmaz. RELAYED ile SERVER_DELIVERED aynı state değildir.",
            color = RelqorTextSoft
        )
    }
}
