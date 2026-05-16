## Why

The app needs to stay centered on Google Calendar while also storing study-specific data that does not belong in calendar events themselves. Calendar-only storage is too limited for notes, progress, tags, and sync state, so the app needs a separate persistence model that still feels tied to the user's Google account.

## What Changes

- Add Google Calendar integration as the primary source of scheduled events.
- Add Google-based sign-in so the user can connect the app to their existing account.
- Store app-specific study data in Firebase/Firestore instead of embedding everything in calendar events.
- Keep a local offline cache so the app can work when network access is unavailable.
- Introduce sync rules for mapping calendar events to study records and reconciling updates across devices.

## Capabilities

### New Capabilities
- `study-calendar-sync`: Connect Google Calendar events with app-specific study data, sync that data across devices, and preserve offline access.

### Modified Capabilities
- None.

## Impact

- Android app structure and data layer.
- Google authentication and Calendar API integration.
- Firebase project setup, Firestore data model, and security rules.
- Local persistence for cache and pending sync state.
- Future implementation work for sync conflict handling and event-to-record mapping.
