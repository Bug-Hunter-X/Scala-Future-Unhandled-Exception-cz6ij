```scala
import scala.concurrent.{ExecutionContext, Future}

class MyClass(implicit ec: ExecutionContext) {
  def myMethod(a: Int, b: Int): Future[Int] = Future {
    if (a == 0) throw new IllegalArgumentException("a cannot be 0")
    a + b 
  }
}
```