import java.util.concurrent.LinkedBlockingQueue

class ApplicantWaitingRoom : LinkedBlockingQueue<Applicant>() {
    fun register(applicant: Applicant) = this.add(element = applicant)
}
