# 🧒 11.1 Exception Hierarchy

### 1. The Basic Idea

Java does not keep all exceptions in one random list.

Java organizes exceptions and errors in a **hierarchical structure**.

This structure is called the **Exception Hierarchy**.

It helps Java understand the relationship between different problems.

The basic structure is:

```text
Object
   ↓
Throwable
   ↓
 ┌───────────────┐
 ↓               ↓
Error         Exception
```

---

### 2. What Is a Hierarchy?

A hierarchy means arranging things from **higher level to lower level** according to their relationship.

For example:

```text
Animal
  ↓
Mammal
  ↓
Dog
```

A dog is a mammal, and a mammal is an animal.

Java uses a similar relationship for throwable problems.

```text
Throwable
   ↓
Error / Exception
```

---

### 3. What Is `Throwable`?

`Throwable` is the main parent class for things that can be **thrown** and handled by Java's exception mechanism.

Under `Throwable`, Java mainly has two important branches:

```text
Throwable
   ├── Error
   └── Exception
```

This is the starting point for understanding the hierarchy.

---

### 4. `Error` Branch

`Error` represents serious problems that generally indicate something is wrong with the Java runtime environment or resources.

For example:

```text
StackOverflowError
OutOfMemoryError
```

These are not ordinary application exceptions.

---

### 5. `Exception` Branch

`Exception` represents conditions that applications commonly need to deal with.

Examples include:

```text
ArithmeticException
InputMismatchException
NegativeArraySizeException
ArrayIndexOutOfBoundsException
```

These can often be handled using:

```java
try
catch
```

---

### 6. Simple Picture

Think of `Throwable` as a large family:

```text
                    Throwable
                       ↓
             ┌─────────┴─────────┐
             ↓                   ↓
           Error             Exception
             ↓                   ↓
      Serious problems     Application problems
```

This is why `Error` and `Exception` should not be treated as exactly the same thing.

---

### 7. Connecting With Previous Topics

We already saw:

```text
NegativeArraySizeException
InputMismatchException
ArrayIndexOutOfBoundsException
```

These belong to the `Exception` side of the hierarchy.

Conceptually:

```text
Throwable
    ↓
Exception
    ↓
RuntimeException
    ↓
Specific Runtime Exceptions
```

For example:

```text
ArithmeticException
ArrayIndexOutOfBoundsException
NegativeArraySizeException
```

---

### 8. Why Does Java Need a Hierarchy?

The hierarchy allows Java to understand **specific and general types**.

For example:

```java
catch (ArithmeticException e)
```

is more specific than:

```java
catch (Exception e)
```

So we learned the rule:

```text
Specific
   ↓
General
```

The hierarchy helps us understand why that rule exists.

---

### 9. Real-World Analogy

Imagine a school:

```text
School
  ↓
Department
  ↓
Class
  ↓
Student
```

A student belongs to a class.

A class belongs to a department.

A department belongs to the school.

Similarly, Java's throwable objects belong to categories:

```text
Throwable
   ↓
Exception / Error
   ↓
More specific types
```

---

### 10. Simple Java Example

```java
class Demo {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        }
        catch (ArithmeticException e) {

            System.out.println("Cannot divide by zero");

        }
    }
}
```

The exception produced is:

```text
ArithmeticException
```

It belongs to the `Exception` branch of the hierarchy.

---

### 11. Understanding the Example

This statement:

```java
int result = 10 / 0;
```

attempts to divide a number by zero.

Java detects the problem and creates an `ArithmeticException`.

The exception is then matched against the available handler:

```java
catch (ArithmeticException e)
```

The matching handler executes.

---

### 12. Hierarchy of This Example

Conceptually:

```text
Object
  ↓
Throwable
  ↓
Exception
  ↓
RuntimeException
  ↓
ArithmeticException
```

So `ArithmeticException` is a specific type within the larger hierarchy.

---

### 13. General Handler

We can also write:

```java
catch (Exception e) {

    System.out.println("Exception handled");

}
```

Here, `Exception` is more general.

Therefore:

```text
ArithmeticException
       ↓
Specific

Exception
       ↓
General
```

This is why a specific catch block should come before the general one.

---

### 14. Error Is Different From Exception

This distinction is important.

```text
Throwable
   ├── Error
   └── Exception
```

An `Exception` commonly represents a condition an application may handle.

An `Error` generally represents a serious problem that applications typically should not try to recover from.

---

### 15. 11.2 Error Example — `StackOverflowError`

`StackOverflowError` is an example from the `Error` branch.

It can occur when the program uses the call stack excessively.

A common way to demonstrate it is through **uncontrolled recursion**.

---

### 16. What Is Recursion?

Recursion means a method calls itself.

For example:

```java
static void fun() {

    fun();

}
```

Inside `fun()`:

```java
fun();
```

calls `fun()` again.

The new call again calls `fun()`.

Then another call happens.

This continues repeatedly.

---

### 17. Simple Real-World Analogy

Imagine two people standing in front of mirrors facing each other.

You can see:

```text
Person
 ↓
Reflection
 ↓
Reflection
 ↓
Reflection
 ↓
...
```

The reflection appears to continue.

Recursion can behave similarly when a method keeps calling itself without a proper stopping condition.

---

### 18. Why Does the Stack Matter?

Whenever a method is called, Java needs to keep information about that method call.

This information is maintained using the **call stack**.

Imagine a stack of plates:

```text
     ┌─────────┐
     │ fun()   │
     ├─────────┤
     │ fun()   │
     ├─────────┤
     │ fun()   │
     ├─────────┤
     │ fun()   │
     ├─────────┤
     │   ...   │
     └─────────┘
```

Every new method call adds another frame.

---

### 19. What Happens With Infinite Recursion?

Consider:

```java
static void fun() {

    fun();

}
```

The method never stops calling itself.

The stack keeps receiving more method calls:

```text
fun()
 ↓
fun()
 ↓
fun()
 ↓
fun()
 ↓
fun()
 ↓
...
```

Eventually, the available stack space is exhausted.

Java can then produce:

```text
StackOverflowError
```

---

### 20. Simple Program

```java
class Demo {

    static void fun() {

        fun();

    }

    public static void main(String[] args) {

        fun();

    }
}
```

The execution begins with:

```java
fun();
```

inside `main()`.

Then `fun()` calls itself repeatedly.

---

### 21. Code Explanation

The method:

```java
static void fun()
```

defines a method named `fun`.

Inside it:

```java
fun();
```

means:

> Call the same method again.

There is no stopping condition.

Therefore:

```text
fun()
 ↓
fun()
 ↓
fun()
 ↓
fun()
 ↓
...
```

continues until the stack space is exhausted.

---

### 22. Execution Flow

The complete flow is:

```text
main()
  ↓
fun()
  ↓
fun()
  ↓
fun()
  ↓
fun()
  ↓
fun()
  ↓
...
  ↓
Stack space becomes insufficient
  ↓
StackOverflowError
```

---

### 23. Why Is It Called `StackOverflowError`?

Break the name into two parts:

```text
Stack
+
Overflow
```

**Stack** refers to the method-call stack.

**Overflow** means the available space has been exceeded.

Therefore:

```text
StackOverflowError
```

means the call stack has exceeded its available capacity.

---

### 24. Error vs Exception in This Example

`StackOverflowError` is:

```text
Throwable
   ↓
Error
   ↓
StackOverflowError
```

It is **not** an `Exception`.

This is an important distinction.

Compare:

```text
ArithmeticException
       ↓
Exception branch
```

with:

```text
StackOverflowError
       ↓
Error branch
```

---

### 25. Complete Hierarchy Picture

A simplified hierarchy is:

```text
Object
   ↓
Throwable
   ├──────────────────────┐
   ↓                      ↓
 Error                 Exception
   ↓                      ↓
StackOverflowError   RuntimeException
OutOfMemoryError          ↓
                     ArithmeticException
                     InputMismatchException
                     NegativeArraySizeException
                     ArrayIndexOutOfBoundsException
```

This is a simplified learning view of the hierarchy.

---

### 26. Understanding the Difference

| Type                 | Branch            | Example               | General Meaning                               |
| -------------------- | ----------------- | --------------------- | --------------------------------------------- |
| `Throwable`          | Root              | —                     | Parent of errors and exceptions               |
| `Error`              | `Throwable` child | `StackOverflowError`  | Serious runtime/resource problem              |
| `Exception`          | `Throwable` child | `ArithmeticException` | Exceptional condition applications may handle |
| `StackOverflowError` | `Error` child     | Infinite recursion    | Call stack exhausted                          |

---

### 27. Common Confusion

Do not think:

```text
Error = Exception
```

They are related because both come under:

```text
Throwable
```

but they are different branches.

Correct:

```text
Throwable
   ├── Error
   └── Exception
```

So:

```text
StackOverflowError → Error
ArithmeticException → Exception
```

---

### 28. Common Confusion About `StackOverflowError`

`StackOverflowError` does not necessarily mean that your computer's entire memory has been exhausted.

It specifically relates to the **call stack** becoming exhausted.

For example, uncontrolled recursion can continuously create method calls until the stack cannot hold another call.

---

### 29. Common Mistake — Recursion Without a Stop

This is dangerous:

```java
static void fun() {

    fun();

}
```

There is no condition that tells the method when to stop.

A recursive method normally needs a **base condition**.

For example:

```java
static void fun(int n) {

    if (n == 0) {
        return;
    }

    fun(n - 1);
}
```

Here recursion has a stopping point.

---

### 30. Safe Recursion Example

```java
class Demo {

    static void fun(int n) {

        if (n == 0) {
            return;
        }

        System.out.println(n);

        fun(n - 1);
    }

    public static void main(String[] args) {

        fun(3);

    }
}
```

Flow:

```text
fun(3)
 ↓
fun(2)
 ↓
fun(1)
 ↓
fun(0)
 ↓
return
```

The recursion stops.

Therefore, this controlled example does not continuously fill the stack.

---

### 31. Important Rules

Remember:

* `Throwable` is the main parent of `Error` and `Exception`.
* `Error` and `Exception` are different branches.
* `StackOverflowError` belongs to `Error`.
* `ArithmeticException` belongs to `Exception`.
* Recursive method calls use the call stack.
* Uncontrolled recursion can exhaust the call stack.
* A base condition can stop recursion.
* `StackOverflowError` is different from `StackOverflowException`—there is no standard Java class called `StackOverflowException`.

---

### 32. Exception Hierarchy and Catch Blocks

The hierarchy also explains catch-block ordering.

For example:

```java
catch (ArithmeticException e) {

}
catch (Exception e) {

}
```

is valid because:

```text
ArithmeticException
       ↓
Exception
```

The first is specific and the second is general.

But placing the general handler first can make the specific handler unreachable.

---

### 33. Error Hierarchy Example

For `StackOverflowError`:

```text
Object
   ↓
Throwable
   ↓
Error
   ↓
StackOverflowError
```

The important point is that `StackOverflowError` belongs to the `Error` branch.

It is therefore not one of the ordinary exception classes we studied earlier.

---

### 34. Real-World Understanding

Think of a building.

```text
Building
   ↓
Two major sections
   ↓
┌──────────────┬──────────────┐
│ Emergency    │ Regular      │
│ Problems     │ Problems     │
└──────────────┴──────────────┘
```

The Java hierarchy similarly separates:

```text
Throwable
   ↓
Error       → serious runtime problems
Exception   → exceptional conditions commonly handled by programs
```

This classification helps programmers understand what kind of problem has occurred.

---

### 35. Memory Trick

Remember:

```text
Throwable
   ↓
E + E
```

Meaning:

```text
Throwable
   ↓
Error
Exception
```

Then remember:

```text
StackOverflowError
        ↓
Error
```

and:

```text
ArithmeticException
InputMismatchException
NegativeArraySizeException
ArrayIndexOutOfBoundsException
        ↓
Exception
```

The easiest memory sentence is:

> **Error and Exception are two branches under Throwable. StackOverflowError belongs to Error; the exceptions we studied belong to Exception.**

---

### 36. Complete Lifetime Understanding

The complete concept can be remembered like this:

```text
                         Object
                            ↓
                        Throwable
                            ↓
                 ┌──────────┴──────────┐
                 ↓                     ↓
               Error               Exception
                 ↓                     ↓
      StackOverflowError       RuntimeException
      OutOfMemoryError                ↓
                               Specific Exceptions
                                      ↓
                ┌─────────────────────┼───────────────────┐
                ↓                     ↓                   ↓
       ArithmeticException    InputMismatchException   ArrayIndex...
```

For `StackOverflowError`:

```text
main()
  ↓
fun()
  ↓
fun()
  ↓
fun()
  ↓
fun()
  ↓
...
  ↓
Call stack becomes full
  ↓
StackOverflowError
  ↓
Error branch
```

For the exceptions studied earlier:

```text
Invalid situation
      ↓
Exception object
      ↓
Throwable hierarchy
      ↓
Exception branch
      ↓
Specific exception type
      ↓
Matching handler
```

**Lifetime memory:**

> **`Throwable` is the main family. It has two major branches: `Error` and `Exception`. `StackOverflowError` belongs to `Error`, while `ArithmeticException`, `InputMismatchException`, `NegativeArraySizeException`, and `ArrayIndexOutOfBoundsException` belong to the `Exception` side.**
