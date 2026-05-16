## Context

The repository currently contains only a scaffolded Android Compose app with no persistence, auth, or sync implementation. The product direction is a study calendar app that must integrate with Google Calendar, but it also needs app-specific data that does not fit cleanly into calendar events.

The key constraint is that the app should feel tied to the user's Google identity without forcing the entire domain model into Google Calendar fields. The design therefore needs to separate schedule data, study metadata, and offline state while keeping them synchronized.

## Goals / Non-Goals

**Goals:**
- Use Google Calendar as the scheduling surface.
- Let users sign in with their Google account.
- Persist study-specific data in a cloud backend that supports user-scoped documents.
- Keep the app usable offline with local caching and deferred writes.
- Define a stable mapping between calendar events and study records.

**Non-Goals:**
- Building a custom collaboration system.
- Supporting non-Google calendar providers in this change.
- Creating a fully generalized note-taking backend.
- Optimizing for multi-user shared editing beyond the signed-in user's account.

## Decisions

### Use Firebase Authentication for user identity
Firebase Authentication will be the app's identity layer, with Google sign-in as the provider.

Rationale:
- The app needs Google-account sign-in, and Firebase Auth provides a straightforward way to bind the user's Google identity to a stable app user ID.
- Firestore security rules can be written against that user ID, which keeps the data model simple.

Alternatives considered:
- Direct Google OAuth without Firebase: viable for Calendar access, but it leaves the app to build its own user/session model.
- Drive `appDataFolder`: good for hidden per-user storage, but weaker for structured querying and sync across richer study data.

### Use Firestore for app-specific study data
Firestore will store study metadata, progress, notes, mappings, and sync state.

Rationale:
- The app needs structured documents, not hidden blobs.
- Firestore supports per-user data partitioning, indexed queries, and multi-device sync semantics that fit this domain better than raw Drive files.

Alternatives considered:
- Drive `appDataFolder`: stronger Google-native feel, but less suitable for queryable records and relationships.
- Calendar extended properties: useful for event-scoped metadata, but too limited for the broader study domain.

### Use Google Calendar as the source of truth for scheduled time
Calendar events will represent when study happens, while Firestore holds app-specific meaning around those events.

Rationale:
- Calendar already owns time, recurrence, reminders, and user-visible scheduling.
- The app should not duplicate scheduling state in Firestore unless it needs a local projection for sync.

Alternatives considered:
- Firestore-only schedule storage: easier internally, but it would require duplicating calendar semantics and would break the primary Google Calendar use case.

### Add a local cache and outbox in Room
Room will cache the latest calendar projection, study documents, and pending writes.

Rationale:
- Offline support requires a durable local layer.
- A local outbox makes sync retries and conflict handling explicit.

Alternatives considered:
- DataStore only: too limited for relational mapping and pending-write queues.
- No local persistence: unacceptable for a calendar-oriented app that users will expect to work while traveling or with poor connectivity.

### Keep event mapping explicit
Each linked calendar event will have a stable app-side identifier and a calendar event reference stored in the local cache and Firestore.

Rationale:
- The app needs to avoid duplicate study records when syncing the same event repeatedly.
- Explicit mapping simplifies updates, deletions, and conflict detection.

## Risks / Trade-offs

- [Two sources of truth] -> Calendar and Firestore can drift if sync fails; mitigate with a clear sync queue, timestamps, and recovery on startup.
- [Firestore cost growth] -> Frequent sync writes can increase usage; mitigate with batching, selective document updates, and local coalescing.
- [Offline conflict complexity] -> Two devices may edit the same study record; mitigate with simple merge rules and explicit conflict markers if needed later.
- [Google API setup overhead] -> Calendar access and Google sign-in require console configuration; mitigate with a narrow initial scope and a focused MVP auth flow.
