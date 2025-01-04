# Scala Future Unhandled Exception

This example demonstrates a common error in Scala when using Futures: unhandled exceptions.  The `IllegalArgumentException` thrown inside the Future is not caught, leading to silent failure.  The solution demonstrates how to properly handle the exception using `recover` or `recoverWith`. This is important for robust error handling in asynchronous operations.