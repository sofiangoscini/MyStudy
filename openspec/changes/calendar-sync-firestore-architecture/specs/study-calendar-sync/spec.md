## ADDED Requirements

### Requirement: Google account connection
The system MUST allow a user to connect a Google account and authorize access needed for calendar synchronization and app-specific cloud storage.

#### Scenario: User grants access
- **WHEN** the user signs in with Google and approves the requested access
- **THEN** the system SHALL establish a user session and associate that session with the user's synced study data

#### Scenario: User denies access
- **WHEN** the user cancels or denies authorization
- **THEN** the system SHALL leave the app in an unsigned-in state and SHALL NOT create cloud-backed study data

### Requirement: Calendar-backed study events
The system MUST synchronize study schedule items with Google Calendar events so the user can manage study time in their calendar.

#### Scenario: Calendar event imported
- **WHEN** the system finds a calendar event that matches a synced study item
- **THEN** the system SHALL present that item as part of the user's study schedule

#### Scenario: Calendar event updated externally
- **WHEN** a linked calendar event changes on Google Calendar
- **THEN** the system SHALL refresh the corresponding study item to reflect the latest calendar state

### Requirement: Separate study data storage
The system MUST store study-specific data that does not belong in Calendar in a separate cloud data store tied to the signed-in user.

#### Scenario: User adds study metadata
- **WHEN** the user adds notes, tags, progress, or similar study-specific information
- **THEN** the system SHALL persist that information outside of Google Calendar event fields

#### Scenario: Study data available on another device
- **WHEN** the user signs in on a second device with the same Google account
- **THEN** the system SHALL restore the same study-specific data from the cloud store

### Requirement: Offline cache and deferred sync
The system MUST keep a local cache of synced calendar and study data and MUST preserve user changes when the device is offline.

#### Scenario: Network unavailable
- **WHEN** the device is offline and the user updates study data
- **THEN** the system SHALL store the change locally and SHALL mark it for later synchronization

#### Scenario: Connectivity restored
- **WHEN** network access returns
- **THEN** the system SHALL synchronize pending changes with the cloud and refresh the local cache

### Requirement: Stable event-to-study mapping
The system MUST maintain a stable mapping between a Google Calendar event and the corresponding study record.

#### Scenario: Event remapped after sync
- **WHEN** the system syncs a previously seen calendar event again
- **THEN** the system SHALL match it to the existing study record instead of creating a duplicate

#### Scenario: Calendar event deleted
- **WHEN** a linked calendar event is deleted from Google Calendar
- **THEN** the system SHALL preserve the study record until the user removes it or the app determines it can be safely archived
