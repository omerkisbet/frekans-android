# Relqor UI Mock

UI Developer için hazırlanmış **izole Android / Jetpack Compose mock repository**.

Bu repository'nin amacı Relqor'un arayüzünün sıfırdan yeniden tasarlanabilmesini sağlamaktır.
Gerçek Android uygulamasının ağ, relay, persistence, backend, kriptografi veya cihaz kimliği
implementasyonları burada **yoktur ve eklenmemelidir**.

## Güvenlik sınırı

Bu repo şunları **içermez**:

- Nearby / BLE / Wi-Fi transport implementasyonu
- Relay / routing algoritması
- Room queue ve retry implementasyonu
- Backend URL, token, API secret veya production config
- Device enrollment / key lifecycle
- Digital signature canonicalization
- PQC / R&D kodu
- Telemetry'nin iç çalışma mantığı
- Gerçek kullanıcı verisi

UI yalnızca `UiState` modelleri ve `MockData` üzerinden çalışır.

## UI Developer'ın görevi

`app/src/main/java/com/nexrelay/relqoruimock/ui/` altında:

1. Tasarım sistemini oluştur / iyileştir.
2. SOS ekranını sıfırdan tasarla.
3. Ağ ekranını sıfırdan tasarla.
4. Teslimat / durum ekranını sıfırdan tasarla.
5. Hakkında ekranını tasarla.
6. Smart SOS için Emergency Profile, Check-In, Nearby Help ve Rescue Channel ekranlarını tasarla.
7. Loading / empty / offline / error / delivered gibi durumları mock state'lerle göster.
8. Erişilebilirlik, kontrast ve küçük ekran davranışlarını kontrol et.

## UI truth rules

- `RELAYED`, `SERVER_DELIVERED` değildir.
- Merkez onayı / receipt yoksa kullanıcıya "teslim edildi" gösterilmez.
- Ağ veya konum bilinmiyorsa UI bunu kesinmiş gibi göstermez.
- `NO_RESPONSE`, "kesin tehlikede" anlamına gelmez.
- Sağlık / acil profil verileri tamamen demo veridir.

## Projeyi açma

Önerilen ortam:

- JDK 17+
- Android SDK 36
- Android Studio
- Gradle 9.3.1
- Kotlin 2.2.10
- Jetpack Compose

Repository wrapper binary içermez. İlk makinede bir kez:

```powershell
gradle wrapper --gradle-version 9.3.1
.\gradlew.bat assembleDebug
```

macOS / Linux:

```bash
gradle wrapper --gradle-version 9.3.1
./gradlew assembleDebug
```

Android Studio local Gradle ile de projeyi sync edebilir.

## Package

Bu mock repo production package adını kullanmaz:

`com.nexrelay.relqoruimock`

Production Android kodu buraya kopyalanmamalıdır.

## Handoff

UI tamamlandığında production repo'ya sadece gerekli:

- Compose screen/component kodu
- theme token'ları
- asset'ler
- UI state beklentileri

taşınır. Production data / network katmanını UI Developer bağlamaz.

Önce `docs/SECURITY_BOUNDARY.md`, `docs/UI_STATE_CONTRACT.md` ve
`docs/AI_USAGE_POLICY.md` dosyalarını okuyun.
