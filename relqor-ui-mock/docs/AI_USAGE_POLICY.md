# AI Usage Policy

Bu repo özellikle UI çalışması için sanitize edilmiştir.

## SERBEST

Aşağıdaki işlerde AI kullanılabilir:

- generic Jetpack Compose syntax
- spacing / typography / responsive layout
- accessibility önerileri
- preview oluşturma
- reusable UI component refactor
- generic form validation UX
- renk kontrastı analizi
- test amaçlı sahte/demo metin üretimi

## SINIRLI

Aşağıdaki içerikler AI'ya verilecekse yalnızca bu repo içindeki sanitize edilmiş bilgi kullanılmalıdır:

- yayımlanmamış Smart SOS ekran isimleri
- ürün metinleri / microcopy
- `UI_STATE_CONTRACT.md`
- marka asset'leri
- gelecekteki ekran akışları

Tam repo yüklemek yerine mümkün olduğunca ilgili küçük UI snippet'i paylaşın.

## YASAK

AI aracına **başka Relqor repository'lerinden** şu içerikler gönderilmez:

- relay / routing kodu
- Nearby / BLE / Wi-Fi transport kodu
- crypto / signature / key management
- PQC / R&D dokümanları veya kodu
- backend secrets / env
- production URL / credentials
- gerçek kullanıcı sağlık, konum veya iletişim bilgisi
- private test vectors / security reports

Kural basit:
**AI UI yazabilir; core architecture ve sensitive implementation AI input'u değildir.**
