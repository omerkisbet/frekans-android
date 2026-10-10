#!/usr/bin/env bash
set -euo pipefail

if ! command -v gradle >/dev/null 2>&1; then
  echo "Local Gradle bulunamadi. Android Studio'dan Gradle 9.3.1 kullanin veya Gradle kurun."
  exit 1
fi

gradle wrapper --gradle-version 9.3.1
echo "Gradle wrapper created."
