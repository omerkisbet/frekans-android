package com.nexrelay.relqoruimock.ui.model

enum class SosTypeUi(val label: String) {
    TRAPPED("Sıkışma"),
    MEDICAL("Tıbbi"),
    FIRE("Yangın"),
    SAFE("Güvendeyim"),
    OTHER("Diğer")
}

enum class DeliveryStageUi(val label: String) {
    IDLE("Hazır"),
    QUEUED("Cihazda bekliyor"),
    RELAYED("Ağ üzerinden taşınıyor"),
    SERVER_DELIVERED("Merkeze ulaştı"),
    FAILED("Gönderim başarısız")
}

data class SosUiState(
    val selectedType: SosTypeUi = SosTypeUi.TRAPPED,
    val peopleCount: Int = 1,
    val note: String = "",
    val locationReady: Boolean = true,
    val relayActive: Boolean = true,
    val deliveryStage: DeliveryStageUi = DeliveryStageUi.IDLE
)

data class NetworkUiState(
    val internetAvailable: Boolean,
    val relayActive: Boolean,
    val peerCount: Int,
    val batteryPercent: Int,
    val locationReady: Boolean,
    val displayPeerName: String?
)

data class DeliveryUiState(
    val stage: DeliveryStageUi,
    val shortMessageId: String?,
    val networkSummary: String,
    val localPersisted: Boolean,
    val relayed: Boolean,
    val serverConfirmed: Boolean
)

enum class SafetyStatusUi(val label: String) {
    SAFE("Güvendeyim"),
    HELP_REQUESTED("Yardıma ihtiyacım var"),
    NO_RESPONSE("Durum teyit edilemedi"),
    UNKNOWN("Bilinmiyor")
}

enum class ProfileVisibilityUi(val label: String) {
    PUBLIC_EMERGENCY("Acil durumda sınırlı paylaşım"),
    RELAY_ONLY("Sadece taşı"),
    AUTHORIZED("Yetkili erişim")
}

data class EmergencyProfileUiState(
    val displayName: String,
    val ageRange: String,
    val bloodGroup: String,
    val allergies: String,
    val criticalConditions: String,
    val medications: String,
    val mobilityConstraints: String,
    val emergencyNote: String,
    val building: String,
    val block: String,
    val floor: String,
    val room: String,
    val visibility: ProfileVisibilityUi
)

data class CheckInUiState(
    val incidentLabel: String,
    val incidentTimeLabel: String,
    val areaLabel: String,
    val status: SafetyStatusUi
)

data class NearbyHelpItemUi(
    val id: String,
    val approximateDistance: String,
    val lastKnownArea: String,
    val safetyStatus: SafetyStatusUi,
    val emergencySummary: String
)

enum class RescueMessageTypeUi {
    STATUS,
    RESOURCE,
    ACCESS,
    NEED,
    GATEWAY
}

data class RescueMessageUi(
    val senderLabel: String,
    val type: RescueMessageTypeUi,
    val text: String,
    val timeLabel: String
)
