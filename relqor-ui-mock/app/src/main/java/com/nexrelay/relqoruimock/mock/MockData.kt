package com.nexrelay.relqoruimock.mock

import com.nexrelay.relqoruimock.ui.model.*

object MockData {

    val sos = SosUiState(
        selectedType = SosTypeUi.TRAPPED,
        peopleCount = 2,
        note = "Kısa demo notu",
        locationReady = true,
        relayActive = true,
        deliveryStage = DeliveryStageUi.QUEUED
    )

    val network = NetworkUiState(
        internetAvailable = false,
        relayActive = true,
        peerCount = 2,
        batteryPercent = 78,
        locationReady = true,
        displayPeerName = "Yakın cihaz"
    )

    val delivery = DeliveryUiState(
        stage = DeliveryStageUi.RELAYED,
        shortMessageId = "demo…a72f",
        networkSummary = "Yakındaki cihaz üzerinden ilerliyor",
        localPersisted = true,
        relayed = true,
        serverConfirmed = false
    )

    val profile = EmergencyProfileUiState(
        displayName = "Demo Kullanıcı",
        ageRange = "20-29",
        bloodGroup = "A Rh+",
        allergies = "Demo: penisilin",
        criticalConditions = "Demo: yok",
        medications = "Demo: yok",
        mobilityConstraints = "Demo: yok",
        emergencyNote = "Bu ekrandaki tüm sağlık bilgileri sahtedir.",
        building = "B Blok",
        block = "B",
        floor = "3",
        room = "Salon",
        visibility = ProfileVisibilityUi.AUTHORIZED
    )

    val checkIn = CheckInUiState(
        incidentLabel = "Bölgesel olay kontrolü",
        incidentTimeLabel = "19:42",
        areaLabel = "Demo bölge",
        status = SafetyStatusUi.UNKNOWN
    )

    val nearbyHelp = listOf(
        NearbyHelpItemUi(
            id = "help-1",
            approximateDistance = "~120 m",
            lastKnownArea = "Kuzey blok çevresi",
            safetyStatus = SafetyStatusUi.HELP_REQUESTED,
            emergencySummary = "Hareket kısıtı bildirildi"
        ),
        NearbyHelpItemUi(
            id = "help-2",
            approximateDistance = "~280 m",
            lastKnownArea = "Ana giriş çevresi",
            safetyStatus = SafetyStatusUi.NO_RESPONSE,
            emergencySummary = "Durum teyit edilemedi"
        )
    )

    val rescueMessages = listOf(
        RescueMessageUi(
            senderLabel = "Yakındaki kullanıcı",
            type = RescueMessageTypeUi.STATUS,
            text = "Kişiye ulaştım.",
            timeLabel = "19:45"
        ),
        RescueMessageUi(
            senderLabel = "Saha gönüllüsü",
            type = RescueMessageTypeUi.RESOURCE,
            text = "İlk yardım çantam var.",
            timeLabel = "19:46"
        ),
        RescueMessageUi(
            senderLabel = "Gateway",
            type = RescueMessageTypeUi.GATEWAY,
            text = "İnternet çıkışı mevcut.",
            timeLabel = "19:47"
        )
    )
}
