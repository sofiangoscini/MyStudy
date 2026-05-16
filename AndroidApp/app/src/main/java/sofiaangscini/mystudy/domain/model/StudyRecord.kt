package sofiaangscini.mystudy.domain.model

data class StudyRecord(
    val id: String,
    val accountScope: AccountScope,
    val title: String,
    val notes: String? = null,
)
