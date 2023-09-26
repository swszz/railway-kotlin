import java.util.*

data class Applicant(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val phone: String,
    val email: String,
    val passed: Boolean,
) {
    companion object {
        fun notPassed(
            name: String,
            phone: String,
            email: String
        ): Applicant {
            return Applicant(
                name = name,
                phone = phone,
                email = email,
                passed = false
            )
        }

        fun passed(
            name: String,
            phone: String,
            email: String
        ): Applicant {
            return Applicant(
                name = name,
                phone = phone,
                email = email,
                passed = true
            )
        }
    }
}
