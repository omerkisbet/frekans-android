package com.nexrelay.relqoruimock.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.nexrelay.relqoruimock.R
import com.nexrelay.relqoruimock.ui.components.MockOnlyBanner
import com.nexrelay.relqoruimock.ui.components.ScreenHeader

@Composable
fun AboutScreen(
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
            title = "Hakkında",
            subtitle = "Relqor UI mock workspace"
        )
        MockOnlyBanner()

        Image(
            painter = painterResource(R.drawable.relqor_logo),
            contentDescription = "Relqor",
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp),
            contentScale = ContentScale.Fit
        )

        Text(
            text = "Kesintili ağlarda iletişim sürekliliği için.",
            style = MaterialTheme.typography.titleMedium
        )

        Text(
            text = "Bu repository yalnızca arayüz tasarımı içindir. Gerçek relay, ağ, backend ve security implementasyonu içermez."
        )

        Image(
            painter = painterResource(R.drawable.nexrelay_logo),
            contentDescription = "NexRelay Technologies",
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentScale = ContentScale.Fit
        )
    }
}
