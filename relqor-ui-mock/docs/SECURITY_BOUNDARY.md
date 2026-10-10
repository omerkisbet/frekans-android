# Security Boundary

## Bu repo neden var?

UI Developer'ın gerçek Relqor Android codebase'ine erişmeden ekran geliştirebilmesi için.

## Kesinlikle buraya gelmemesi gerekenler

Aşağıdaki sınıf / içerik kategorileri production repo'dan bu workspace'e kopyalanmaz:

- transport adapters
- Nearby callbacks
- peer discovery internals
- route selection / relay policy
- hop / copy policy implementation
- Room entities / DAO'lar
- retry / WorkManager production logic
- Retrofit production interfaces
- backend base URL
- API keys / secrets
- device key enrollment
- keystore signer
- signature payload encoder
- cryptographic verification logic
- PQC / hybrid handshake
- internal R&D telemetry implementation
- private test vectors

UI Developer bu alanlara ihtiyaç duyarsa production kodu istemek yerine
**yeni bir UI state alanı** talep eder.

Örnek:

Yanlış:
> RelayManager kodunu açar mısınız?

Doğru:
> Ekranda "aktif peer sayısı" gösterebilmek için `peerCount: Int` state'i gerekiyor.

## Handoff kuralı

UI -> Core entegrasyonunu core Android geliştiricisi yapar.
