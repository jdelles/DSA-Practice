package Chapter3

fun main() {
    countdown(5)
    greet("James")
    println("Factorial of 5: ${fact(5)}")
    println("Factorial of 10: ${fact(10)}")
}

fun countdown(x: Int) {
    println("Countdown: $x")
    when {
        x <= 0 -> return
        else -> countdown(x - 1)
    }
}

fun greet(name: String) {
    println("hello, $name!")
    greet2(name)
    println("getting ready to say bye...")
    bye()
}

fun greet2(name: String) = println("how are you, $name?")

fun bye() = println("ok bye!")

fun fact(x: Int): Int = when (x) {
    1 -> 1
    else -> x * fact(x - 1)
}

/**
 * Exercises
 *
 * 3.1:
 *
 * 3.1: You get an OOM error, maybe crash
 */