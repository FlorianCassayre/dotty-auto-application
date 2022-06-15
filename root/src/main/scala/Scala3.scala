object Scala3 {
  class A[T] {
    def m(): T = ???
  }

  object B
  class C

  locally {
    val a2 = new Scala2.A[B.type]
    a2.m                 // ok
    a2.m: (() => B.type) // ok
    a2.m: B.type         // error

    val a3 = new Scala3.A[B.type]
    a3.m                 // error
    a3.m: (() => B.type) // ok
    a3.m: B.type         // error
  }

  locally {
    val a2 = new Scala2.A[C]
    a2.m                 // ok
    a2.m: (() => C)      // ok
    a2.m: C              // ok

    val a3 = new Scala3.A[C]
    a3.m                 // error
    a3.m: (() => C)      // ok
    a3.m: C              // error
  }
}
