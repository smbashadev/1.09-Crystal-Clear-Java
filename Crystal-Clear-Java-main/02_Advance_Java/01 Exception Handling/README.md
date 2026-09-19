# ☕ Java Exception Handling — Crystal Clear Java

<p align="center">
  <img src="https://img.shields.io/badge/Java-Exception%20Handling-orange?style=for-the-badge&logo=openjdk" alt="Java Exception Handling">
  <img src="https://img.shields.io/badge/Language-Java-red?style=for-the-badge&logo=java" alt="Java">
  <img src="https://img.shields.io/badge/Level-Beginner%20to%20Intermediate-blue?style=for-the-badge" alt="Level">
  <img src="https://img.shields.io/badge/Content-49%20Study%20Files-green?style=for-the-badge" alt="Content">
  <img src="https://img.shields.io/badge/Focus-Concepts%20%7C%20Programs%20%7C%20Examples-purple?style=for-the-badge" alt="Focus">
</p>

<p align="center">
  <b>A structured Java study module covering exception handling from basic runtime problems through custom exceptions, exception propagation, and StackOverflowError.</b>
</p>

---

## 📌 About This Folder

`01 Exception Handling` is a dedicated Java learning module inside the **Crystal-Clear-Java** repository.

The folder is organized into numbered topics and subtopics so that exception handling can be studied progressively—from understanding what an exception is, to handling exceptions, propagating them across methods, using `throw` / `throws`, working with `finally`, multiple and nested `try-catch` structures, exception hierarchy, overriding rules, and custom exceptions.

The material is primarily provided as Markdown study notes and includes practical Java examples and programs.

---

## 🗂️ Module Coverage

| #  | Topic                                    | Main Coverage                                                                                                                        |
| -- | ---------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------ |
| 01 | Exception                                | Normal execution, exception definition, languages with/without exception handlers                                                    |
| 02 | Java Program With Exception              | Division by zero, program without exception, default exception handler                                                               |
| 03 | Exception Handling                       | Program with exception, Runtime System (RTS), definition, `try-catch`, handling program                                              |
| 04 | Exception in Multiple Method Hierarchy   | Method hierarchy, normal exception, exception propagation, `InputMismatchException`, handling in `fun3()`                            |
| 05 | ATM–Bank Exception Handling              | ATM/bank-oriented exception handling example                                                                                         |
| 06 | `throw` Keyword                          | Explicitly throwing an exception                                                                                                     |
| 07 | `throws` Keyword                         | Declaring/propagating exceptions with `throws`                                                                                       |
| 08 | `finally` Block                          | `finally` block and its role in exception handling                                                                                   |
| 09 | Different Exception Types                | `NegativeArraySizeException`, `ArrayIndexOutOfBoundsException`, `InputMismatchException`, generic-message problem, specific messages |
| 10 | Multiple Catch                           | Multiple exception handlers, catch ordering, covered exceptions, output scenarios                                                    |
| 11 | Exception Hierarchy                      | Exception hierarchy and relationship to `Error`                                                                                      |
| 12 | StackOverflowError                       | Recursive `fun()` call, stack frames, stack exhaustion, `StackOverflowError`                                                         |
| 13 | Exception Rules During Method Overriding | RuntimeException rule, no-exception rule, checked/non-runtime exception compatibility                                                |
| 14 | Valid Syntax of `try-catch-finally`      | `try+catch`, `try+finally`, `try+catch+finally`, nested forms, invalid syntax                                                        |
| 15 | Checked Exception                        | `Thread.sleep()`, `InterruptedException`, handling checked exception                                                                 |
| 16 | Ducking / Avoiding an Exception          | `throws`, handling vs ducking, exception flow, Test3/Test4 programs                                                                  |
| 17 | Nested `try-catch`                       | ATM example, first/second PIN attempts, account blocking scenario                                                                    |
| 18 | Custom Exception                         | Programmer-created exceptions, `InvalidPinException`, `throw`, `throws`, custom messages                                             |

---

## 🧭 Learning Path

```text
Exception
   ↓
Java Program With Exception
   ↓
Exception Handling
   ↓
Exception Propagation
   ↓
ATM–Bank Exception Handling
   ↓
throw
   ↓
throws
   ↓
finally
   ↓
Different Exception Types
   ↓
Multiple Catch
   ↓
Exception Hierarchy
   ↓
StackOverflowError
   ↓
Exception Rules During Method Overriding
   ↓
try-catch-finally Syntax
   ↓
Checked Exception
   ↓
Ducking / Avoiding Exception
   ↓
Nested try-catch
   ↓
Custom Exception
```

---

# 📚 Detailed Topic Index

## 01. Exception

Introduces the idea of an exception by first showing normal Java program execution and then explaining how an exceptional condition interrupts normal flow.

### Files

* `01 Exception/01 Exception.md`
* `01 Exception/02 Exception — Definition.md`
* `01 Exception/03 Languages Without Exception Handlers.md`
* `01 Exception/04 Languages With Exception Handlers.md`

### Concepts Covered

* Normal program execution
* What an exception means
* Exception as an interruption of normal program flow
* Languages without exception handlers
* Languages with exception handlers

---

## 02. Java Program With Exception

Demonstrates a Java program where an exception occurs and contrasts it with execution without an exception.

### Files

* `02 Java Program With Exception/01 Division by Zero.md`
* `02 Java Program With Exception/02 Program Without Exception.md`
* `02 Java Program With Exception/03 Default Exception Handler.md`

### Concepts Covered

* Division by zero
* Normal execution
* Runtime exception behavior
* Default exception handler
* Difference between normal and exceptional flow

---

## 03. Exception Handling

Introduces exception handling and the `try-catch` mechanism, including the Runtime System (RTS).

### Files

* `03 Exception Handling/01 Program With Exception.md`
* `03 Exception Handling/02 Runtime System (RTS).md`
* `03 Exception Handling/03 Exception Handling Definition.md`
* `03 Exception Handling/04 try_catch.md`
* `03 Exception Handling/05 Java Program Using try-catch.md`

### Concepts Covered

* Program with an exception
* Runtime System (RTS)
* Definition of exception handling
* `try`
* `catch`
* Handling an exception using `try-catch`

---

## 04. Exception in Multiple Method Hierarchy

Shows how an exception can move through multiple method calls until an appropriate handler is found.

### Files

* `04 Exception in Multiple Method Hierarchy/01 Multiple Method Hierarchy.md`
* `04 Exception in Multiple Method Hierarchy/02 Normal Exception.md`
* `04 Exception in Multiple Method Hierarchy/03 Exception Propagation.md`
* `04 Exception in Multiple Method Hierarchy/04 InputMismatchException Example.md`
* `04 Exception in Multiple Method Hierarchy/05 Handling Exception in fun3().md`

### Concepts Covered

* Multiple method hierarchy
* Normal exception flow
* Exception propagation
* `InputMismatchException`
* Handling an exception in `fun3()`

---

## 05. ATM–Bank Exception Handling

A practical ATM/bank-oriented example used to connect exception handling with a real-world programming scenario.

### File

* `05 ATM–Bank Exception Handling/ATM–Bank Exception Handling.md`

---

## 06. `throw` Keyword

Focuses on explicitly throwing an exception from Java code.

### File

* `06 throw Keyword/throw keyword.md`

### Key Concept

```java
throw exceptionObject;
```

`throw` is used when program logic explicitly wants to generate or raise a particular exception object.

---

## 07. `throws` Keyword

Introduces `throws` for declaring that a method may pass an exception to its caller instead of handling it locally.

### File

* `07 throws keywod/throws keyword.md`

### Key Concept

```java
returnType methodName() throws ExceptionType {
    // method body
}
```

---

## 08. `finally` Block

Covers the `finally` block used with exception-handling structures.

### File

* `08 finally block/finally block.md`

---

## 09. Different Exception Types

Introduces several specific exception types and the need for meaningful exception-specific messages.

### Files

* `09 Different Exception Types/01 NegativeArraySizeException.md`
* `09 Different Exception Types/02 ArrayIndexOutOfBoundsException.md`
* `09 Different Exception Types/03 InputMismatchException.md`
* `09 Different Exception Types/04 Same Generic Exception Message Problem.md`
* `09 Different Exception Types/05 Need for Specific Messages.md`

### Exceptions Covered

#### `NegativeArraySizeException`

Occurs when code attempts to create an array with a negative size.

#### `ArrayIndexOutOfBoundsException`

Occurs when an array is accessed using an invalid index.

#### `InputMismatchException`

Relevant to invalid input types when reading input using `Scanner`.

### Message Handling

The notes demonstrate the problem with using one generic exception message for different failures and the need for specific messages that tell the user what actually went wrong.

---

## 10. Multiple Catch Blocks

Demonstrates handling different exception classes using multiple `catch` blocks.

### Files

* `10 Multiple Catch/01 Multiple Catch.md`
* `10 Multiple Catch/02 Catch Block Order.md`
* `10 Multiple Catch/03 Exceptions Covered.md`
* `10 Multiple Catch/04 Output Scenarios.md`

### Concepts Covered

* Multiple `catch` blocks
* Different exception classes
* Different exception messages
* Catch-block ordering
* Specific exception handler before general handler
* `NegativeArraySizeException`
* `InputMismatchException`
* `ArrayIndexOutOfBoundsException`
* Output scenarios for invalid input and array access

### Catch Ordering Principle

A more specific exception handler must appear before a more general compatible handler.

```text
Specific exception
       ↓
General Exception
```

---

## 11. Exception Hierarchy

Introduces the exception hierarchy and connects exceptions with the broader `Throwable` hierarchy.

### File

* `11 Exception Hierarchy/Exception Hierarchy.md`

### Related Concepts

* `Exception` hierarchy
* `Error` hierarchy
* `StackOverflowError`

---

## 12. StackOverflowError

Demonstrates how uncontrolled recursion can exhaust the call stack.

### File

* `12 Program for StackOverflowError/Program for StackOverflowError`

### Core Example

```java
class TestError {

    static void fun() {
        fun();
    }

    public static void main(String[] args) {
        fun();
    }
}
```

### Execution Idea

```text
main()
  ↓
fun()
  ↓
fun()
  ↓
fun()
  ↓
...
  ↓
More stack frames
  ↓
Stack exhaustion
  ↓
StackOverflowError
```

### Concepts Covered

* Recursive method call
* Method calling itself repeatedly
* No terminating condition
* Stack frames
* Stack segment becoming full
* Endless recursion
* `StackOverflowError`

---

## 13. Exception Rules During Method Overriding

Explains the rules related to exceptions thrown by overridden methods.

### File

* `13 Exception Rules During Method Overriding/Exception Rules During Method Overriding.md`

### Rule 1 — RuntimeException

An overridden child method may throw a `RuntimeException` even when the parent method declares an exception such as `Exception`.

Example:

```text
Parent → throws Exception
Child  → throws ArithmeticException
```

### Rule 2 — No Exception

A child method may choose not to throw any exception even if the parent method declares one.

Example:

```text
Parent → IOException
Child  → no exception
```

### Rule 3 — Checked / Non-Runtime Exception

A checked exception thrown by the child must be compatible with the parent method's declared exception.

Valid:

```text
Parent → IOException
Child  → IOException
```

Invalid:

```text
Parent → IOException
Child  → SQLException
```

---

## 14. Valid Syntax of `try-catch-finally`

Covers valid combinations of `try`, `catch`, and `finally`, including nested structures and invalid syntax.

### File

* `14 Valid Syntax of try-catch-finally/Valid Syntax of try-catch-finally.md`

### Structures Covered

#### `try + catch`

```java
try {
    // code
}
catch (Exception e) {
    // handling code
}
```

#### `try + finally`

```java
try {
    // code
}
finally {
    // final code
}
```

#### `try + catch + finally`

```java
try {
    // code
}
catch (Exception e) {
    // handling code
}
finally {
    // final code
}
```

### Nested `try-catch`

* `try` inside `try`
* Inner `catch`
* Outer `catch`

### Invalid Syntax

The notes also demonstrate incorrect `try-catch-finally` arrangements.

---

## 15. Checked Exception

Demonstrates a checked exception using `Thread.sleep()`.

### File

* `15 Check Exception/Check Exception.md`

### Concepts Covered

* `Thread.sleep(3000)`
* Checked exception
* `InterruptedException`
* `try`
* `catch(InterruptedException e)`
* Exception message
* Loop from 1 to 5
* Expected output:

  * `1`
  * `2`
  * `3`
  * `4`
  * `5`

---

## 16. Ducking / Avoiding an Exception

Explains how a method can handle an exception itself or pass responsibility to its caller using `throws`.

### Files

* `16 Ducking or Avoiding an Exception/01 throws for Ducking.md`
* `16 Ducking or Avoiding an Exception/02 Two Options for a Method.md`
* `16 Ducking or Avoiding an Exception/03 Exception Flow.md`
* `16 Ducking or Avoiding an Exception/04 Test3 Program.md`
* `16 Ducking or Avoiding an Exception/05 Test4 Program.md`

### Two Options

```text
Method
 ├── Handle exception → try-catch
 └── Duck exception    → throws
```

### Exception Flow

```text
Method ducks exception
        ↓
Runtime System looks in caller
        ↓
Caller handles it
        OR
Caller also ducks it
        ↓
Exception continues upward
```

### Test3

* `alpha()` throws `Exception`
* `beta()` throws `Exception`
* `main()` throws `Exception`
* `Scanner`
* `InputMismatchException`

### Test4

* `beta()` throws `Exception`
* `alpha()` throws `Exception`
* `main()` handles using `try-catch`
* Exception handled in `main()`
* `printStackTrace()`

---

## 17. Nested `try-catch` — ATM Example

Uses an ATM PIN example to demonstrate nested exception handling and multiple attempts.

### File

* `17 Nested try-catch/Nested try-catch — ATM Example.md`

### Scenario Flow

```text
First PIN attempt
      ↓
Correct → Success
      OR
Wrong → Ask again
      ↓
Second PIN attempt
      ↓
Correct → Success
      OR
Wrong → Account blocked for 24 hours
```

### Outputs Covered

1. Correct PIN on the first attempt.
2. Wrong first input followed by correct second input.
3. Wrong first input followed by wrong second input and account blocking for 24 hours.

---

## 18. Custom Exception

Introduces programmer-created exceptions for application-specific situations.

### File

* `18 Custom Exception/Custom Exception.md`

### Custom Exception Concept

A custom exception is a programmer-created exception designed for a specific programming scenario.

### Creating a Custom Exception

The material covers:

* Creating a class
* Extending a predefined exception class
* Customizing the exception message
* `getMessage()`

### `InvalidPinException`

The notes use an `InvalidPinException` example that extends `Exception` and provides a customized message.

### ATM Flow

```text
User enters PIN
      ↓
Compare PIN
      ↓
Correct ─────→ Success
      ↓
Incorrect
      ↓
InvalidPinException
      ↓
Custom exception message
```

The ATM/ATMM example covers `Scanner`, correct/incorrect PIN handling, `throw`, and `throws InvalidPinException`.

---

# 🧩 Core Java Exception Concepts Covered

```text
Exception
├── Exception definition
├── Normal vs exceptional execution
├── Runtime System (RTS)
├── Exception handling
├── try
├── catch
├── finally
├── Multiple catch
├── Nested try-catch
├── throw
├── throws
├── Exception propagation
├── Exception ducking
├── Checked exceptions
├── Exception hierarchy
├── Exception rules during method overriding
├── Specific exception messages
├── Custom exceptions
└── StackOverflowError
```

---

# 🧪 Exception Types Covered in the Notes

| Exception / Error                | Context in this module                           |
| -------------------------------- | ------------------------------------------------ |
| `ArithmeticException`            | Division by zero and overriding-rule example     |
| `NegativeArraySizeException`     | Negative array size                              |
| `InputMismatchException`         | Invalid `Scanner` input                          |
| `ArrayIndexOutOfBoundsException` | Invalid array index                              |
| `InterruptedException`           | `Thread.sleep()` checked exception               |
| `StackOverflowError`             | Endless recursion / stack exhaustion             |
| `InvalidPinException`            | User-defined/custom ATM exception                |
| `IOException`                    | Method overriding and checked-exception examples |
| `SQLException`                   | Invalid checked-exception overriding example     |

---

# 🔄 Exception Flow at a Glance

```text
             Exception occurs
                    ↓
              Current method
                    ↓
             Is it handled here?
              /             \
            YES              NO
             ↓                ↓
       catch executes     Propagation
                              ↓
                           Caller
                              ↓
                    Is it handled there?
                       /          \
                     YES          NO
                      ↓            ↓
                 catch executes  Continue upward
```

---

# 🛡️ Handling vs Ducking

| Approach              | Meaning                                                        | Main Keyword / Structure |
| --------------------- | -------------------------------------------------------------- | ------------------------ |
| Handling              | Method takes responsibility for the exception                  | `try-catch`              |
| Ducking               | Method passes responsibility to its caller                     | `throws`                 |
| Explicit throwing     | Program explicitly raises a particular exception               | `throw`                  |
| Final execution block | Block associated with completion of `try` / `catch` processing | `finally`                |

---

# 🧠 Key Learning Points

* An exception interrupts the normal flow of program execution.
* Exception handling provides a structured way to deal with exceptional situations.
* `try` contains code where an exception may occur.
* `catch` handles a matching exception.
* Multiple `catch` blocks can handle different exception types.
* More specific handlers should come before general compatible handlers.
* `finally` is used as part of exception-handling control flow.
* Exceptions can propagate through a method-call hierarchy.
* A method can handle an exception or duck it using `throws`.
* `throw` and `throws` have different purposes.
* Checked exceptions must be handled or declared appropriately.
* Exception rules apply when methods are overridden.
* Custom exceptions allow application-specific exception types and messages.
* Uncontrolled recursion can exhaust the call stack and cause `StackOverflowError`.

---

# 💻 Technologies / Concepts

<p>
  <img src="https://img.shields.io/badge/Java-Programming%20Language-orange?style=flat-square&logo=openjdk" alt="Java">
  <img src="https://img.shields.io/badge/OOP-Concepts-blue?style=flat-square" alt="OOP">
  <img src="https://img.shields.io/badge/Scanner-Input%20Handling-green?style=flat-square" alt="Scanner">
  <img src="https://img.shields.io/badge/Exception%20Handling-Core%20Java-purple?style=flat-square" alt="Exception Handling">
</p>

The repository material demonstrates Core Java concepts through explanations, examples, and programs. The source files in this folder are the basis for the topic coverage listed above.

---

# 📁 Folder Structure

```text
01 Exception Handling/
│
├── 01 Exception/
├── 02 Java Program With Exception/
├── 03 Exception Handling/
├── 04 Exception in Multiple Method Hierarchy/
├── 05 ATM–Bank Exception Handling/
├── 06 throw Keyword/
├── 07 throws keywod/
├── 08 finally block/
├── 09 Different Exception Types/
├── 10 Multiple Catch/
├── 11 Exception Hierarchy/
├── 12 Program for StackOverflowError/
├── 13 Exception Rules During Method Overriding/
├── 14 Valid Syntax of try-catch-finally/
├── 15 Check Exception/
├── 16 Ducking or Avoiding an Exception/
├── 17 Nested try-catch/
└── 18 Custom Exception/
```

The folder contains **49 study files** across these 18 numbered learning sections.

---

# 🚀 How to Use This Module

1. Start with **01 Exception**.
2. Follow the numbered folders in order.
3. Read the explanation before studying the associated program.
4. Pay special attention to exception flow and method hierarchy.
5. Practice the different `try-catch-finally` structures.
6. Compare `throw` with `throws`.
7. Study checked exceptions using `Thread.sleep()`.
8. Practice exception propagation and ducking.
9. Study the ATM examples to connect the concepts with practical scenarios.
10. Finish with custom exceptions and review the complete exception hierarchy.

---

# 🎯 Recommended Practice Order

```text
Basic Exception
      ↓
Exception Handling
      ↓
try-catch
      ↓
Exception Propagation
      ↓
throw
      ↓
throws
      ↓
finally
      ↓
Specific Exception Types
      ↓
Multiple Catch
      ↓
Exception Hierarchy
      ↓
Overriding Rules
      ↓
Checked Exceptions
      ↓
Ducking
      ↓
Nested try-catch
      ↓
Custom Exception
```

---

# 🏆 What You Should Be Able to Explain After Completing This Folder

* What an exception is and why exception handling is needed.
* What happens when a Java program encounters an exception.
* How the Runtime System participates in exception propagation.
* How `try`, `catch`, and `finally` work.
* How to handle multiple exception types.
* Why catch-block order matters.
* What `throw` does and how it differs from `throws`.
* How an exception travels through multiple method calls.
* What exception ducking means.
* What checked exceptions are.
* How exception rules work during method overriding.
* What `StackOverflowError` is and how recursion can cause it.
* How nested `try-catch` can be used in an ATM-style workflow.
* How to create and use a custom exception such as `InvalidPinException`.

---

# 📖 Repository

This module belongs to the **Crystal-Clear-Java** Java learning repository and is located under:

```text
02_Advance_Java/
└── 01 Exception Handling/
```

---

# ⭐ Study Philosophy

```text
Understand the problem
        ↓
Understand normal execution
        ↓
Understand the exception
        ↓
Understand why it occurs
        ↓
Understand how Java handles it
        ↓
Practice the program
        ↓
Understand the execution flow
        ↓
Apply the concept to a real-world scenario
```

> **Learn the flow, not just the syntax.**

---

<p align="center">
  <b>☕ Crystal Clear Java • Exception Handling</b><br>
  <sub>Structured learning notes • Java concepts • Practical examples • Exception handling fundamentals</sub>
</p>
