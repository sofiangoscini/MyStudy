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

<!-- BEGIN BEADS INTEGRATION v:1 profile:minimal hash:7510c1e2 -->
## Beads Issue Tracker

This project uses **bd (beads)** for issue tracking. Run `bd prime` to see full workflow context and commands.

### Quick Reference

```bash
bd ready              # Find available work
bd show <id>          # View issue details
bd update <id> --claim  # Claim work
bd close <id>         # Complete work
```

### Rules

- Use `bd` for ALL task tracking — do NOT use TodoWrite, TaskCreate, or markdown TODO lists
- Run `bd prime` for detailed command reference and session close protocol
- Use `bd remember` for persistent knowledge — do NOT use MEMORY.md files

**Architecture in one line:** issues live in a local Dolt DB; sync uses `refs/dolt/data` on your git remote; `.beads/issues.jsonl` is a passive export. See https://github.com/gastownhall/beads/blob/main/docs/SYNC_CONCEPTS.md for details and anti-patterns.

## Session Completion

**When ending a work session**, you MUST complete ALL steps below. Work is NOT complete until `git push` succeeds.

**MANDATORY WORKFLOW:**

1. **File issues for remaining work** - Create issues for anything that needs follow-up
2. **Run quality gates** (if code changed) - Tests, linters, builds
3. **Update issue status** - Close finished work, update in-progress items
4. **PUSH TO REMOTE** - This is MANDATORY:
   ```bash
   git pull --rebase
   git push
   git status  # MUST show "up to date with origin"
   ```
5. **Clean up** - Clear stashes, prune remote branches
6. **Verify** - All changes committed AND pushed
7. **Hand off** - Provide context for next session

**CRITICAL RULES:**
- Work is NOT complete until `git push` succeeds
- NEVER stop before pushing - that leaves work stranded locally
- NEVER say "ready to push when you are" - YOU must push
- If push fails, resolve and retry until it succeeds
<!-- END BEADS INTEGRATION -->
