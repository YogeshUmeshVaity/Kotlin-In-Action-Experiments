package inline.objectcreation.lockblockexample

/**
The class that is
final class your/package/YourFilenameKt$main$1 extends kotlin/jvm/internal/Lambda implements kotlin/jvm/functions/Function0 { }
In this code, the main$1 is your lock function's class name.
This sometimes doesn't reflect in the decompiled Java code because the decompiler doesn't always
generate a working Java code but it's there in the bytecode. You can look for the code line
mentioned above in the bytecode.

For the class for lock function to generate, you must call it from the main function as shown in the following code:
fun main() {
    lock { println("Inside the block()") }
}

 */
fun lock(block: () -> Unit) {
    try {
        block();
    } finally {
    }
}

fun main() {
    lock {
        println("Inside the block()")
    }
}