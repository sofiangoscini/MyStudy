package sofiaangscini.mystudy.data.remote

import sofiaangscini.mystudy.domain.model.StudyRecord

interface StudyRemoteDataSource {
    suspend fun upsertStudyRecord(record: StudyRecord)

    suspend fun deleteStudyRecord(studyRecordId: String)
}
