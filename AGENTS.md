# Repository Guidelines

## Project Structure & Module Organization
This repository contains a single Android application in `AndroidApp/`.
- `AndroidApp/app/src/main/` holds production code, manifests, and resources.
- `AndroidApp/app/src/test/` contains local JVM unit tests.
- `AndroidApp/app/src/androidTest/` contains instrumented tests.
- `AndroidApp/app/src/main/java/sofiaangscini/mystudy/ui/theme/` contains Compose theme code.
- Generated build output lives under `AndroidApp/app/build/` and should not be edited directly.

## Build, Test, and Development Commands
Run commands from `AndroidApp/`.
- `./gradlew assembleDebug` builds the debug APK.
- `./gradlew test` runs local unit tests in `app/src/test/`.
- `./gradlew connectedAndroidTest` runs instrumented tests on a device or emulator.
- `./gradlew lint` runs Android lint checks.
- `./gradlew clean` removes build artifacts when the cache needs a reset.

## Coding Style & Naming Conventions
Use Kotlin with the project-wide style set to `official` and 4-space indentation. Keep package names lowercase, classes and composables in `PascalCase`, and functions/variables in `camelCase`. Match existing Compose patterns such as `MainActivity`, `Greeting`, and `MyStudyTheme`. Prefer descriptive file names that match the primary class or composable in the file, for example `MainActivity.kt` or `Theme.kt`.

## Testing Guidelines
Use JUnit for local unit tests and AndroidX/JUnit4 for instrumented tests. Name unit tests with the `*Test.kt` suffix and place them under `app/src/test/java/`. Use `*InstrumentedTest.kt` under `app/src/androidTest/java/` for device-based checks. Keep tests focused on observable behavior; for Compose UI, prefer assertion-based tests over manual inspection.
Follow a strict TDD workflow for changes: write the test first, verify it fails for the right reason, implement only enough production code to make it pass, and confirm the test exercises real production behavior rather than a stubbed shortcut. Do not cheat: the test must fail before the fix and must verify the actual production code path.

## Commit & Pull Request Guidelines
The current history is brief, with commits like `scaffold android app` and `compile files`. Keep future commit messages short, imperative, and specific, such as `add theme colors` or `fix greeting preview`. Pull requests should include a clear summary, the commands used to verify the change, and screenshots or screen recordings for UI updates. Link related issues when available.

## Configuration Notes
Do not commit local build outputs, IDE caches, or Gradle state. If you need to inspect the app structure, start in `AndroidApp/app/src/main/` and keep changes consistent with the existing Compose and AndroidX setup.
