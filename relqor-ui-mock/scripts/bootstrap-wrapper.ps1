$ErrorActionPreference = "Stop"

if (-not (Get-Command gradle -ErrorAction SilentlyContinue)) {
    throw "Local Gradle bulunamadi. Android Studio'dan Gradle 9.3.1 kullanin veya Gradle kurun."
}

gradle wrapper --gradle-version 9.3.1
Write-Host "Gradle wrapper created."
