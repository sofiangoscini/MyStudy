package sofiaangscini.mystudy.data.sync

import sofiaangscini.mystudy.domain.model.AccountScope
import sofiaangscini.mystudy.domain.model.SyncState

interface StudySyncCoordinator {
    suspend fun sync(accountScope: AccountScope): SyncState
}
