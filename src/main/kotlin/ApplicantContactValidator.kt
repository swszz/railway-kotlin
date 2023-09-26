import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.github.michaelbull.result.andThen
import java.util.regex.Pattern

object ApplicantContactValidator {

    private const val PHONE_REGEXP: String = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})\$"
    private const val EMAIL_REGEXP: String = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"

    private val PHONE_PATTERN: Pattern = Pattern.compile(PHONE_REGEXP)
    private val EMAIL_PATTERN: Pattern = Pattern.compile(EMAIL_REGEXP)

    fun validate(applicant: Applicant): Result<Applicant, Throwable> {
        return validateName(applicant = applicant)
            .andThen { validatePhone(applicant = it) }
            .andThen { validateEmail(applicant = it) }
    }

    private fun validatePhone(applicant: Applicant): Result<Applicant, Throwable> {
        return when (PHONE_PATTERN.matcher(applicant.phone).find()) {
            true -> Ok(applicant)
            false -> Err(IllegalStateException("${applicant.phone} is not valid format."))
        }
    }

    private fun validateEmail(applicant: Applicant): Result<Applicant, Throwable> {
        return when (EMAIL_PATTERN.matcher(applicant.email).find()) {
            true -> Ok(applicant)
            false -> Err(IllegalStateException("${applicant.email} is not valid format."))
        }
    }

    private fun validateName(applicant: Applicant): Result<Applicant, Throwable> {
        return when (applicant.name.isNotEmpty()) {
            true -> Ok(applicant)
            false -> Err(IllegalStateException("applicant's name is empty."))
        }
    }
}