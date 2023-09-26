import com.github.michaelbull.result.onFailure
import com.github.michaelbull.result.onSuccess


val applicantWaitingRoom = ApplicantWaitingRoom()
val rejectionReasonStore = RejectionReasonStore()
fun main(args: Array<String>) {
    val applicant: Applicant =
        Applicant.notPassed(
            name = "sungwonkim",
            phone = "010-8300-5047",
            email = "sungwonkim@doodlin.co.kr"
        )

    ApplicantContactValidator.validate(
        applicant = applicant
    ).onSuccess { applicantWaitingRoom.register(applicant = it) }
        .onFailure { rejectionReasonStore.save(reason = it.message) }
}
