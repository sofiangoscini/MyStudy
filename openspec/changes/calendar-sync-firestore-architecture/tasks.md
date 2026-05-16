## 1. Project Setup

- [ ] 1.1 Add Firebase, Credential Manager, Google ID, Calendar API, Room, and coroutine dependencies to the Android app
- [ ] 1.2 Add the required Android manifest and Gradle wiring for Google sign-in and Firebase configuration
- [ ] 1.3 Add any required test fixtures or sample configuration for local development

## 2. Identity and Cloud Access

- [ ] 2.1 Implement Google sign-in entry points using Credential Manager
- [ ] 2.2 Exchange the signed-in Google identity for a Firebase Auth session
- [ ] 2.3 Add sign-out and session restore behavior for the current user

## 3. Local Data Model

- [ ] 3.1 Define Room entities and DAOs for calendar projections, study records, and pending sync operations
- [ ] 3.2 Implement repositories that read from the local cache before hitting the network
- [ ] 3.3 Add mapping fields that bind a Google Calendar event ID to a study record ID

## 4. Cloud Sync

- [ ] 4.1 Create Firestore document models for study metadata, progress, and sync timestamps
- [ ] 4.2 Implement one-way import from Google Calendar into the local projection
- [ ] 4.3 Implement Firestore write-through for user edits to study metadata
- [ ] 4.4 Implement deferred retry handling for offline changes and sync failures

## 5. UI and Verification

- [ ] 5.1 Build the Compose flow for connecting an account and showing sync state
- [ ] 5.2 Add Compose screens for the study schedule, item details, and offline/error states
- [ ] 5.3 Add unit tests for mapping, repository behavior, and sync conflict handling
- [ ] 5.4 Run the Android build and test suite to verify the integration compiles and the new behavior is covered
