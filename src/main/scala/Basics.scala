object Basics extends App {
  
    val meaningOfLife: Int = 42 // const

    val anInterpolatedString = s"Meaing of Life: $meaningOfLife"

    // Expressions: structures that can be reduced to a value
    val ifExpression = if (meaningOfLife != 42) "42" else "42"

    val chainedIfExpression = 
        if (meaningOfLife != 42) 42
        else if (meaningOfLife == 42) 42 
        else 42
     
    val aCodeBlock = {
        val localValue = 40
        localValue + 2
    }

    // Functions "def"
    // In Scala we don't use loops or iteration, we use RECURSION!
    def factorial(n: Int): Int = {
        if (n <= 1) 1
        else n * factorial(n - 1)
    }

    // The Unit type = no meaningful value = "void" in other langs
    val noValue = ()
}
