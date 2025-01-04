```scala
import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

class MyClass(implicit ec: ExecutionContext) {
  def myMethod(a: Int, b: Int): Future[Int] = Future {
    if (a == 0) throw new IllegalArgumentException("a cannot be 0")
    a + b 
  }.recover { 
    case e: IllegalArgumentException => 0 // Handle the exception, return a default value
  }

  //Alternative solution using recoverWith
  def myMethodWithRecoverWith(a: Int, b: Int): Future[Int] = Future {
    if (a == 0) throw new IllegalArgumentException("a cannot be 0")
    a + b 
  }.recoverWith { 
    case e: IllegalArgumentException => Future.successful(0) //Handle Exception and return a Future
  }

  def myMethodWithCallback(a: Int, b: Int): Unit = {
    Future {
      if (a == 0) throw new IllegalArgumentException("a cannot be 0")
      a + b
    }.onComplete { 
       case Success(result) => println(s"Success: $result")
       case Failure(exception) => println(s"Failure: ${exception.getMessage}")
    }
  }
}
```