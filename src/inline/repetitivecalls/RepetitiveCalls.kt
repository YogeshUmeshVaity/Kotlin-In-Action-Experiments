package inline.repetitivecalls

/**
 Results in:

 public static final void doSomething() {
     System.out.println("Doing something");
 }
 */
inline fun doSomething() {
    println("Doing something")
}

/**
Results in:

public static final void doSomethingAgain() {
    System.out.println("Doing something");
    System.out.println("Doing something");
}

 Code grows at 2 raised to 1
 */
inline fun doSomethingAgain() {
    doSomething()
    doSomething()
}

/**
 Results in:

 public static final void doSomethingAgainAndAgain() {
     System.out.println("Doing something");
     System.out.println("Doing something");
     System.out.println("Doing something");
     System.out.println("Doing something");
 }

 Code grows at 2 raised to 2
 */

inline fun doSomethingAgainAndAgain() {
    doSomethingAgain()
    doSomethingAgain()
}

/**
 Results in:

 public static final void doSomethingAgainAndAgainAndAgain() {
     System.out.println("Doing something");
     System.out.println("Doing something");
     System.out.println("Doing something");
     System.out.println("Doing something");
     System.out.println("Doing something");
     System.out.println("Doing something");
     System.out.println("Doing something");
     System.out.println("Doing something");
 }

 Code grows at 2 raised to 3
 */
inline fun doSomethingAgainAndAgainAndAgain() {
    doSomethingAgainAndAgain()
    doSomethingAgainAndAgain()
}

/**
 * The number 2 is the number of times the function is called at each abstraction. As you can see
 * the code grows exponentially not only at the last level but also at every level,
 * so that's 16 + 8 + 4 + 2 lines. I have shown only 2 calls and 3 abstraction levels here to keep
 * it concise but imagine how much code will be generated for more calls and more abstraction levels.
 * This increases the size of your app. This is another reason why you shouldn't inline each and
 * every function in your app.
*/