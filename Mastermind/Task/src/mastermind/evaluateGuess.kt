package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    val rightPosition = secret.zip(guess).count { it.first == it.second }
    val commonLetters = "ABCDEF".sumBy { ch ->
        Math.min(secret.count { it == ch }, guess.count { it == ch })
    }
    val wrongPosition = commonLetters - rightPosition
    return Evaluation(rightPosition, wrongPosition)
}
