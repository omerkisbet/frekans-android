package com.nexrelay.relqoruimock.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nexrelay.relqoruimock.ui.screens.*
import com.nexrelay.relqoruimock.ui.theme.RelqorBackground

private enum class AppScreen(val label: String) {
    HOME("Önizleme"),
    SOS("SOS"),
    NETWORK("Ağ"),
    STATUS("Durum"),
    MORE("Daha")
}

@Composable
fun RelqorUiMockApp() {
    var screenName by rememberSaveable { mutableStateOf(AppScreen.HOME.name) }
    var subScreen by rememberSaveable { mutableStateOf<String?>(null) }

    val screen = AppScreen.valueOf(screenName)

    Scaffold(
        containerColor = RelqorBackground,
        bottomBar = {
            NavigationBar {
                AppScreen.entries.forEach { item ->
                    NavigationBarItem(
                        selected = item == screen && subScreen == null,
                        onClick = {
                            screenName = item.name
                            subScreen = null
                        },
                        icon = { Text("•") },
                        label = { Text(item.label) }
                    )
                }
            }
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            when (subScreen) {
                "profile" -> EmergencyProfileScreen(onBack = { subScreen = null })
                "checkin" -> CheckInScreen(onBack = { subScreen = null })
                "nearby" -> NearbyHelpScreen(onBack = { subScreen = null })
                "rescue" -> RescueChannelScreen(onBack = { subScreen = null })
                "about" -> AboutScreen(onBack = { subScreen = null })
                else -> when (screen) {
                    AppScreen.HOME -> PreviewHomeScreen(
                        openSos = { screenName = AppScreen.SOS.name },
                        openNetwork = { screenName = AppScreen.NETWORK.name },
                        openStatus = { screenName = AppScreen.STATUS.name },
                        openProfile = { subScreen = "profile" },
                        openCheckIn = { subScreen = "checkin" },
                        openNearby = { subScreen = "nearby" },
                        openRescue = { subScreen = "rescue" },
                        openAbout = { subScreen = "about" }
                    )
                    AppScreen.SOS -> SosScreen()
                    AppScreen.NETWORK -> NetworkScreen()
                    AppScreen.STATUS -> DeliveryStatusScreen()
                    AppScreen.MORE -> MoreScreen(
                        openProfile = { subScreen = "profile" },
                        openCheckIn = { subScreen = "checkin" },
                        openNearby = { subScreen = "nearby" },
                        openRescue = { subScreen = "rescue" },
                        openAbout = { subScreen = "about" }
                    )
                }
            }
        }
    }
}
