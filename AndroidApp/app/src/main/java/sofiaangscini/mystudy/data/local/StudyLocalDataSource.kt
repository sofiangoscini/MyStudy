package sofiaangscini.mystudy.data.local

import sofiaangscini.mystudy.domain.model.AccountScope
import sofiaangscini.mystudy.domain.model.StudyRecord

interface StudyLocalDataSource {
    suspend fun getStudyRecords(accountScope: AccountScope): List<StudyRecord>

    suspend fun saveStudyRecord(record: StudyRecord)
}
