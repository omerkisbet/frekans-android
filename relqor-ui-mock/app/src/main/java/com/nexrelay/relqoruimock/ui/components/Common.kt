package com.nexrelay.relqoruimock.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.nexrelay.relqoruimock.ui.theme.*

@Composable
fun MockOnlyBanner() {
    Surface(
        color = RelqorSurfaceSoft,
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "UI MOCK • gerçek ağ / backend / relay yok",
            style = MaterialTheme.typography.labelMedium,
            color = RelqorTextSoft,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
        )
    }
}

@Composable
fun ScreenHeader(
    title: String,
    subtitle: String? = null
) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        if (!subtitle.isNullOrBlank()) {
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = RelqorTextSoft
            )
        }
    }
}

@Composable
fun KeyValueRow(
    key: String,
    value: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 7.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(key, color = RelqorTextSoft)
        Spacer(Modifier.width(16.dp))
        Text(
            text = value,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun StateBadge(
    label: String,
    positive: Boolean? = null
) {
    val container = when (positive) {
        true -> RelqorSuccess.copy(alpha = 0.10f)
        false -> RelqorDanger.copy(alpha = 0.10f)
        null -> RelqorSurfaceSoft
    }
    val textColor = when (positive) {
        true -> RelqorSuccess
        false -> RelqorDanger
        null -> RelqorText
    }

    Surface(
        color = container,
        shape = RoundedCornerShape(999.dp)
    ) {
        Text(
            text = label,
            color = textColor,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 7.dp)
        )
    }
}

@Composable
fun SimpleSection(
    title: String,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            title,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        content()
    }
}
