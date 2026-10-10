package com.nexrelay.relqoruimock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.nexrelay.relqoruimock.ui.RelqorUiMockApp
import com.nexrelay.relqoruimock.ui.theme.RelqorUiMockTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            RelqorUiMockTheme {
                RelqorUiMockApp()
            }
        }
    }
}
