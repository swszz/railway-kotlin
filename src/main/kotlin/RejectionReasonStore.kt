import java.util.concurrent.LinkedBlockingQueue

class RejectionReasonStore : LinkedBlockingQueue<String>() {
    fun save(reason: String?): Boolean {
        return this.add(element = convertNotNull(reason = reason))
    }

    private fun convertNotNull(reason: String?): String {
        return reason ?: ""
    }
}