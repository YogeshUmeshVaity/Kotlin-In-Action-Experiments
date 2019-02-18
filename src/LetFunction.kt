fun sendEmailTo(email: String) {
    println("Email sent to $email")
}

fun main() {
    val email: String? = "xyz@ymail.com"

    // Cannot call a function that accepts non-null argument with a nullable argument
    /* sendEmail(email) // Type mismatch */

    // This doesn't work either
    /* sendEmail(email?.) */

    // Convert nullable value to a non-null and use it in lambda
    // let() turns the object on which it is called, into a parameter of lambda
    email?.let { it -> sendEmailTo(it) } // 'it' means email object
    /* email?.let { sendEmailTo(it) } */

    // The let() will be called only if the email value is non-null
}