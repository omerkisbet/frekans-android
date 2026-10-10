package com.nexrelay.relqoruimock.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nexrelay.relqoruimock.mock.MockData
import com.nexrelay.relqoruimock.ui.components.MockOnlyBanner
import com.nexrelay.relqoruimock.ui.components.ScreenHeader

@Composable
fun EmergencyProfileScreen(
    onBack: () -> Unit
) {
    val original = MockData.profile
    var name by remember { mutableStateOf(original.displayName) }
    var blood by remember { mutableStateOf(original.bloodGroup) }
    var allergies by remember { mutableStateOf(original.allergies) }
    var building by remember { mutableStateOf(original.building) }
    var floor by remember { mutableStateOf(original.floor) }
    var room by remember { mutableStateOf(original.room) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        TextButton(onClick = onBack) { Text("← Geri") }

        ScreenHeader(
            title = "Emergency Profile",
            subtitle = "Tüm içerik mock veridir. Production health data bu repo'da tutulmaz."
        )
        MockOnlyBanner()

        OutlinedTextField(name, { name = it }, label = { Text("Ad / gösterim adı") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(blood, { blood = it }, label = { Text("Kan grubu") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(allergies, { allergies = it }, label = { Text("Alerji") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(building, { building = it }, label = { Text("Bina") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(floor, { floor = it }, label = { Text("Kat") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(room, { room = it }, label = { Text("Oda / bölüm") }, modifier = Modifier.fillMaxWidth())

        Text(
            text = "Görünürlük: ${original.visibility.label}",
            style = MaterialTheme.typography.bodyMedium
        )

        Button(onClick = { }, modifier = Modifier.fillMaxWidth()) {
            Text("Mock profili kaydet")
        }
    }
}
