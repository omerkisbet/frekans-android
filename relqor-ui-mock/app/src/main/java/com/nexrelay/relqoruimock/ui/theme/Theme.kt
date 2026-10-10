package com.nexrelay.relqoruimock.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val RelqorLightScheme = lightColorScheme(
    primary = RelqorNavy,
    secondary = RelqorTeal,
    background = RelqorBackground,
    surface = RelqorSurface,
    surfaceVariant = RelqorSurfaceSoft,
    outline = RelqorOutline,
    onPrimary = RelqorSurface,
    onSecondary = RelqorText,
    onBackground = RelqorText,
    onSurface = RelqorText,
    onSurfaceVariant = RelqorTextSoft,
    error = RelqorDanger
)

@Composable
fun RelqorUiMockTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = RelqorLightScheme,
        content = content
    )
}
