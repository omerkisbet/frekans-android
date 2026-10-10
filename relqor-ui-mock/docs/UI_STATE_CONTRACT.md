# UI State Contract

Bu dosya UI'nin bilmesi gereken minimum ürün sözleşmesidir.

## 1. Ana mevcut yüzler

- SOS
- Ağ
- Durum
- Hakkında

## 2. SOS türleri

UI demo seçenekleri:

- SIKIŞMA
- TIBBI
- YANGIN
- GUVENDEYIM
- DIGER

UI, type seçimi ile ağ davranışı hakkında varsayım yapmaz.

## 3. Teslim state'leri

```text
IDLE
  |
QUEUED
  |
RELAYED
  |
SERVER_DELIVERED

Her aşamada:
FAILED mümkün
```

Anlamlar:

- `IDLE`: aktif mesaj yok.
- `QUEUED`: mesaj cihaz tarafında gönderim bekliyor.
- `RELAYED`: mesaj en az bir relay adımında ilerledi; merkez teslimi kanıtlanmış değildir.
- `SERVER_DELIVERED`: merkez / backend teslim onayı alınmıştır.
- `FAILED`: ilgili deneme başarısızdır; UI sebebi sade göstermelidir.

### Kritik invariant

`RELAYED != SERVER_DELIVERED`

## 4. Ağ state'i

UI yalnızca aşağıdaki özet alanlarını bilir:

- `internetAvailable: Boolean`
- `relayActive: Boolean`
- `peerCount: Int`
- `batteryPercent: Int`
- `locationReady: Boolean`
- `displayPeerName: String?`

Bu alanların **nasıl hesaplandığı UI concern değildir**.

## 5. Smart SOS / planlanan UI

### Check-In

- SAFE
- HELP_REQUESTED
- NO_RESPONSE
- UNKNOWN

`NO_RESPONSE`:
> Durum teyit edilemedi.

UI:
> Kesin yaralı / enkazda / tehlikede

şeklinde iddia üretmez.

### Emergency Profile

Demo alanlar:

- displayName
- ageRange
- bloodGroup
- allergies
- criticalConditions
- medications
- mobilityConstraints
- emergencyNote
- building
- block
- floor
- room
- visibility

Visibility demo değerleri:

- PUBLIC_EMERGENCY
- RELAY_ONLY
- AUTHORIZED

### Nearby Help

UI sadece mock:

- approximateDistance
- safetyStatus
- lastKnownArea
- allowedEmergencySummary

gösterir.

### Rescue Channel

Kısa olay mesajları:

- STATUS
- RESOURCE
- ACCESS
- NEED
- GATEWAY

Bu ekran genel chat ürünü gibi tasarlanmamalıdır.
