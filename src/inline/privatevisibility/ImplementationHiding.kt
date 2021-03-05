package inline.privatevisibility

/**
 * The public inline functions cannot access private functions, so they cannot be used for
 * implementation hiding.
 */
inline fun doSomething() {
//  doItPrivately()  // Error: Public-API inline function cannot access non-public API fun
}

private fun doItPrivately() { }