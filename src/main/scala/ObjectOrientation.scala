object ObjectOrientation extends App {

    class Animal {        
        def eat() = println("I'm eating...")

        private val meaningOfLife: Int = 42
    } 

    val anAnimal =  new Animal

    object Animal { // companions - companion object
        def ?(animal: Animal): Int = animal.meaningOfLife

        def apply(): Unit = println("I'm an Animal, and i'm using the special method apply()")
    }
    
    
    // Inheritance
    class Dog(val name: String) extends Animal // construtor definition
    val aDog = new Dog("Marcos")

    /* 
        Construtor arguments are not fields: 
        aDog.name => "Cannot resolve the symbol 'name'"

        need to put a 'val' before the constructor argument
    */
    
    
    // Subtype Polymorphism
    val anotherDog: Animal = new Dog("Casio")
    anotherDog.eat() // the most derived method will be called at runtime

    // Abstract Class
    abstract class WalkingAnimal {
        val hasLegs = true // by default public, can restrict by adding 'protected' or 'privatre'
        def walk(): Unit
    }

    // Interface: the ultimate hyper giga overpower abstract type
    trait Carnivore {
        def eat(animal: Animal): Unit
    }

    // Single-class inheritance, Multi-trait "mixing"
    class Crocodile extends Animal with Carnivore {
        override infix def eat(animal: Animal): Unit = println(s"I'm eating you, $animal")
        // infix: scala 3
    }

    val aCroc = new Crocodile
    aCroc.eat(aDog)
    aCroc eat anotherDog

    // Anonymous Class
    val dinosaur = new Carnivore {
        override def eat(animal: Animal): Unit = println(s"I'm Anonymous and i'm eating you, $animal")
        
        /*
            meanwhile, the compiler:

            class AnonymousClass extends Carnivore {
                ...
            }

            val dinosaur = new AnonymousClass
        */
    }
 
    // Case Class: lightweight data structures with some boilerplate

    case class Snake(venomous: Boolean) extends Animal
    val python = Snake(venomous = true)


    // Execeptions

    try {
        val n: String = null
    } catch {
        case exception: Exception => "Exception!?"
    } finally {

    }

    // Generics
    abstract class aList[T] {
        def head: T
        def tail: aList[T]
    }

    val anotherList: List[Int] = List(0, 1, 2, 3) // List.apply(1, 2, 3)
    // in Scala we usually operate with IMMUTABLE values/objects
    val reversedList = anotherList.reverse // returns a NEW list
}
