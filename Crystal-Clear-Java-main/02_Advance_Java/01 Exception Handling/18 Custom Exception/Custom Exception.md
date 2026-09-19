# 🧒 18. Custom Exception

### 1. Basic Idea

A **custom exception** is an exception created by the programmer for a specific situation in an application.

Java already provides many predefined exceptions such as:

```text
ArithmeticException
InputMismatchException
ArrayIndexOutOfBoundsException
```

But sometimes an application needs its **own meaningful exception**.

For example, an ATM application may need:

```text
InvalidPinException
```

This clearly tells us what went wrong.

---

### 2. Why Custom Exceptions Are Needed

Suppose an ATM receives an incorrect PIN.

A general exception message might say:

```text
Exception occurred
```

That does not clearly describe the problem.

A custom exception can say:

```text
Invalid PIN
```

Now the exception itself has a meaningful name and message.

---

### 3. Real-World Example

Imagine an ATM with:

```text
Correct PIN → Transaction successful

Wrong PIN → InvalidPinException
```

The programmer creates a special exception for the ATM's PIN problem.

```text
ATM
 ↓
PIN entered
 ↓
Compare PIN
 ↓
Wrong?
 ↓
InvalidPinException
```

---

### 4. What Is a User-Defined Exception?

A **user-defined exception** is an exception class created by the programmer.

It is also called a:

* Custom exception
* User-defined exception
* Programmer-created exception

All three terms describe the same basic idea.

---

### 5. Creating a Custom Exception

To create one, the programmer creates a class.

For example:

```java
class InvalidPinException extends Exception {
    
}
```

Here:

```text
InvalidPinException → our custom class
extends             → inheritance keyword
Exception            → predefined Java exception class
```

---

### 6. Why Extend `Exception`?

The custom exception should behave like a Java exception.

Therefore, it is created by extending an existing exception class.

```text
Exception
   ↑
   |
InvalidPinException
```

Because `InvalidPinException` extends `Exception`, Java recognizes it as an exception type.

---

### 7. `InvalidPinException`

The custom class can be:

```java
class InvalidPinException extends Exception {

}
```

The name:

```text
InvalidPinException
```

is chosen by the programmer.

It describes the particular problem that the application wants to represent.

---

### 8. Custom Exception Naming

A custom exception class normally ends with:

```text
Exception
```

For example:

```text
InvalidPinException
InsufficientBalanceException
InvalidAgeException
InvalidPasswordException
```

This makes it immediately clear that the class represents an exception.

---

### 9. `getMessage()`

A custom exception can provide its own message by overriding:

```java
getMessage()
```

For example:

```java
@Override
public String getMessage() {

    return "Invalid PIN";

}
```

Now the exception can provide a specific message.

---

### 10. Why Override `getMessage()`?

The purpose is to provide a **customized exception message**.

Instead of a generic message:

```text
Exception occurred
```

the custom exception can provide:

```text
Invalid PIN
```

This makes the error easier to understand.

---

### 11. Basic Custom Exception Class

```java
class InvalidPinException extends Exception {

    @Override
    public String getMessage() {

        return "Invalid PIN";

    }
}
```

This creates a custom exception called:

```text
InvalidPinException
```

and gives it the message:

```text
Invalid PIN
```

---

### 12. Understanding `@Override`

The annotation:

```java
@Override
```

tells Java that the programmer intends to override a method inherited from the parent class.

Here the method is:

```java
getMessage()
```

So:

```text
Exception
   ↓
getMessage()
   ↓
InvalidPinException
   ↓
overrides getMessage()
```

---

### 13. Understanding `return`

Inside:

```java
public String getMessage() {

    return "Invalid PIN";

}
```

the statement:

```java
return "Invalid PIN";
```

sends the custom message back to the code that asks for the exception message.

---

### 14. Complete `InvalidPinException`

```java
class InvalidPinException extends Exception {

    @Override
    public String getMessage() {

        return "Invalid PIN";

    }
}
```

The important structure is:

```text
Custom exception class
        ↓
extends Exception
        ↓
getMessage()
        ↓
custom message
```

---

## 18.4 ATM1 / ATMM Program

### 15. ATM Program Idea

Now the custom exception is used in an ATM program.

The program will:

```text
1. Ask for PIN
2. Read PIN using Scanner
3. Compare entered PIN
4. If correct → success
5. If incorrect → create InvalidPinException
6. throw the exception
7. Caller handles it
```

---

### 16. `Scanner`

The ATM needs to receive the PIN from the user.

```java
Scanner sc = new Scanner(System.in);
```

`Scanner` allows the program to read keyboard input.

---

### 17. Importing `Scanner`

We need:

```java
import java.util.Scanner;
```

This makes the `Scanner` class available.

---

### 18. Correct PIN

Suppose the ATM's correct PIN is:

```text
1234
```

The program can store it:

```java
int correctPin = 1234;
```

Then the user enters a PIN.

```java
int pin = sc.nextInt();
```

---

### 19. Comparing the PIN

The program compares:

```java
if (pin == correctPin)
```

If they are equal:

```text
Entered PIN = Correct PIN
       ↓
Transaction successful
```

If they are different:

```text
Entered PIN ≠ Correct PIN
       ↓
InvalidPinException
```

---

### 20. `throw` Keyword

When the PIN is incorrect, the programmer explicitly creates and throws the custom exception.

```java
throw new InvalidPinException();
```

Here:

```text
throw → explicitly sends an exception
new   → creates an object
InvalidPinException() → custom exception object
```

---

### 21. Creating the Exception Object

This:

```java
new InvalidPinException()
```

creates an object of:

```text
InvalidPinException
```

Conceptually:

```text
new InvalidPinException()
        ↓
Custom exception object
```

---

### 22. Throwing the Object

Then:

```java
throw new InvalidPinException();
```

sends that exception into Java's exception-handling mechanism.

```text
Invalid PIN
     ↓
Create InvalidPinException object
     ↓
throw
     ↓
Exception handling system
```

---

### 23. `throws InvalidPinException`

The method can declare:

```java
static void transaction() throws InvalidPinException
```

This tells the caller that `transaction()` may produce:

```text
InvalidPinException
```

The caller must be prepared to handle it or pass it further.

---

### 24. Complete ATM Program

```java
import java.util.Scanner;

class InvalidPinException extends Exception {

    @Override
    public String getMessage() {

        return "Invalid PIN";

    }
}

class ATMM {

    static void transaction() throws InvalidPinException {

        Scanner sc = new Scanner(System.in);

        int correctPin = 1234;

        System.out.println("Enter PIN:");

        int pin = sc.nextInt();

        if (pin == correctPin) {

            System.out.println("Correct PIN");
            System.out.println("Transaction Successful");

        }
        else {

            throw new InvalidPinException();

        }
    }

    public static void main(String[] args) {

        try {

            transaction();

        }
        catch (InvalidPinException e) {

            System.out.println(e.getMessage());

        }

        System.out.println("Program Ends");
    }
}
```

---

### 25. Program Structure

There are two classes of interest:

```text
InvalidPinException
        ↓
Custom exception

ATMM
        ↓
ATM application
```

The ATM application uses the custom exception.

---

### 26. Correct PIN Execution

Suppose:

```text
Correct PIN = 1234
```

User enters:

```text
1234
```

The condition:

```java
if (pin == correctPin)
```

becomes:

```text
1234 == 1234
```

which is true.

Therefore:

```text
Correct PIN
Transaction Successful
```

is printed.

---

### 27. Incorrect PIN Execution

Suppose the user enters:

```text
1111
```

The comparison becomes:

```text
1111 == 1234
```

which is false.

Therefore the `else` block executes:

```java
throw new InvalidPinException();
```

---

### 28. Exception Creation Flow

The statement:

```java
throw new InvalidPinException();
```

does two important things:

```text
new InvalidPinException()
        ↓
Creates custom exception object
        ↓
throw
        ↓
Throws the object
```

---

### 29. Where Does the Exception Go?

The exception is thrown from:

```text
transaction()
```

The `main()` method called:

```java
transaction();
```

inside:

```java
try {

    transaction();

}
```

Therefore, `main()` has the opportunity to handle it.

---

### 30. `catch` Receives the Exception

The handler is:

```java
catch (InvalidPinException e) {

    System.out.println(e.getMessage());

}
```

Here:

```text
InvalidPinException → exception type
e                   → reference to exception object
```

The object thrown by:

```java
throw new InvalidPinException();
```

is received by:

```java
catch (InvalidPinException e)
```

---

### 31. `getMessage()` Is Called

The catch block executes:

```java
e.getMessage()
```

Because `e` refers to the `InvalidPinException` object, Java calls the custom:

```java
getMessage()
```

method.

It returns:

```text
Invalid PIN
```

So the output is:

```text
Invalid PIN
```

---

### 32. Complete Invalid PIN Flow

```text
User enters PIN
       ↓
Compare with correct PIN
       ↓
PIN incorrect
       ↓
new InvalidPinException()
       ↓
Exception object created
       ↓
throw
       ↓
transaction() does not handle
       ↓
main() receives exception
       ↓
catch(InvalidPinException e)
       ↓
e.getMessage()
       ↓
"Invalid PIN"
       ↓
Program Ends
```

---

## 18.5 Custom Exception Flow

### 33. User Enters PIN

The user provides a PIN through:

```java
int pin = sc.nextInt();
```

For example:

```text
Enter PIN:
1111
```

---

### 34. PIN Comparison

The program compares:

```text
1111
with
1234
```

They are different.

Therefore:

```text
PIN is incorrect
```

---

### 35. Correct PIN Flow

If the user enters:

```text
1234
```

then:

```text
1234 == 1234
```

is true.

The program follows:

```text
Correct PIN
   ↓
Transaction Successful
```

No custom exception is created.

---

### 36. Incorrect PIN Flow

If the user enters:

```text
1111
```

then:

```text
1111 != 1234
```

The program follows:

```text
Invalid PIN
   ↓
Create InvalidPinException
   ↓
throw
   ↓
catch
   ↓
getMessage()
   ↓
Invalid PIN
```

---

### 37. `throw` vs `throws` in This Program

Both are used, but they have different jobs.

**`throw`:**

```java
throw new InvalidPinException();
```

Actually throws the exception.

**`throws`:**

```java
static void transaction() throws InvalidPinException
```

Declares that the method may throw that exception.

Remember:

```text
throw  → DO IT
throws → DECLARE IT
```

---

### 38. Custom Exception vs Predefined Exception

Java already has:

```text
InputMismatchException
ArithmeticException
NegativeArraySizeException
```

But the ATM application wants a meaningful:

```text
InvalidPinException
```

So the programmer creates it.

```text
Java
 ↓
Predefined exceptions

Programmer
 ↓
Custom exception
 ↓
InvalidPinException
```

---

### 39. Why This Is Better

Compare:

```text
Exception occurred
```

with:

```text
Invalid PIN
```

The second message immediately tells the user and developer what the problem means.

Custom exceptions make application-specific problems easier to identify and handle.

---

### 40. Important Rules

* A custom exception is created by the programmer.
* It represents a specific application situation.
* A custom exception is normally created as a class.
* The class extends an existing exception class.
* `InvalidPinException` extends `Exception`.
* `getMessage()` can be overridden to provide a custom message.
* `throw` explicitly throws an exception object.
* `throws` declares that a method may throw an exception.
* `Scanner` is used to receive the PIN.
* A correct PIN allows normal execution.
* An incorrect PIN creates and throws `InvalidPinException`.
* The `catch` block can receive the custom exception.
* `e.getMessage()` retrieves the customized message.

---

### 41. Common Confusion

Do not confuse:

```java
throw new InvalidPinException();
```

with:

```java
throws InvalidPinException
```

They are different.

```text
throw
 ↓
Actually throws the exception

throws
 ↓
Declares/warns that the method may throw it
```

---

### 42. Common Confusion

Creating the class:

```java
class InvalidPinException extends Exception
```

does **not** mean the exception has occurred.

It only creates the **exception type**.

The exception actually gets created and thrown when:

```java
throw new InvalidPinException();
```

executes.

---

### 43. Common Confusion

This:

```java
getMessage()
```

does not itself throw the exception.

It retrieves the message associated with the exception object.

In this example:

```text
InvalidPinException object
        ↓
getMessage()
        ↓
"Invalid PIN"
```

---

### 44. Real-World Applications

Custom exceptions can represent many application-specific problems:

```text
ATM
 ↓
InvalidPinException

Bank
 ↓
InsufficientBalanceException

Login
 ↓
InvalidPasswordException

Registration
 ↓
InvalidAgeException
```

The exception name itself communicates the problem.

---

### 45. Complete Mental Model

```text
                 ATM
                  ↓
              Enter PIN
                  ↓
           Compare PIN
             ↙       ↘
        Correct       Wrong
           ↓            ↓
       Success      Create object
                        ↓
               InvalidPinException
                        ↓
                      throw
                        ↓
                  Caller / main()
                        ↓
                      catch
                        ↓
                 getMessage()
                        ↓
                   Invalid PIN
```

---

### 46. Memory Trick

Remember the custom exception process:

```text
CREATE → EXTEND → THROW → CATCH → MESSAGE
```

For the ATM:

```text
Create InvalidPinException
        ↓
extends Exception
        ↓
throw new InvalidPinException()
        ↓
catch(InvalidPinException e)
        ↓
e.getMessage()
        ↓
"Invalid PIN"
```

---

### 47. Interview Understanding

A **custom exception** is a programmer-created exception used to represent a specific application-level problem. In the ATM example, `InvalidPinException` extends `Exception` and overrides `getMessage()` to provide the message `"Invalid PIN"`. When the user enters an incorrect PIN, the program creates and explicitly throws `InvalidPinException`. The caller catches it and obtains the customized message using `e.getMessage()`.

---

### 48. Complete Lifetime Understanding

```text
                         ATM PROGRAM
                              ↓
                     User enters PIN
                              ↓
                     Scanner reads PIN
                              ↓
                    Compare entered PIN
                              ↓
                    Is PIN correct?
                     ↙             ↘
                   YES              NO
                    ↓                ↓
              Correct PIN      Invalid PIN
                    ↓                ↓
          Transaction Success   Create object
                                     ↓
                         new InvalidPinException()
                                     ↓
                              Custom exception
                                     ↓
                                  throw
                                     ↓
                         transaction() does not
                              handle it
                                     ↓
                         Exception goes to caller
                                     ↓
                                  main()
                                     ↓
                         try-catch is present
                                     ↓
                  catch(InvalidPinException e)
                                     ↓
                            Exception handled
                                     ↓
                         e.getMessage()
                                     ↓
                              "Invalid PIN"
                                     ↓
                            Program Ends
```

**Core memory rule:**

> **A custom exception is a programmer-created exception for a specific application problem. In the ATM example, an incorrect PIN causes `InvalidPinException` to be created and thrown, and the caller catches it and displays the customized `"Invalid PIN"` message.**
