# 🧒 16.4 Test3 Program

### 1. Basic Idea

This program demonstrates **exception ducking through multiple methods**.

There are three important methods:

```text
main()
  ↓
beta()
  ↓
alpha()
```

The exception occurs in one method, but that method does not handle it. Instead, it uses `throws` to pass the responsibility upward.

---

### 2. Method Hierarchy

The calling relationship is:

```text
main()
  ↓
beta()
  ↓
alpha()
```

So:

* `main()` calls `beta()`
* `beta()` calls `alpha()`
* `alpha()` performs the operation that may produce the exception

---

### 3. `alpha()` Method

`alpha()` is declared as:

```java
static void alpha() throws Exception
```

The important part is:

```java
throws Exception
```

It means `alpha()` is **not handling the exception itself**.

It is telling its caller:

> "`alpha()` may produce an exception; the caller is responsible for it."

---

### 4. `Scanner`

The program uses `Scanner` to receive input from the keyboard.

```java
Scanner sc = new Scanner(System.in);
```

Here:

```text
Scanner → Java class used to receive input
sc      → reference variable
System.in → standard keyboard input
```

---

### 5. Importing Scanner

Before using `Scanner`, we normally write:

```java
import java.util.Scanner;
```

This makes the `Scanner` class available to the program.

---

### 6. Reading Numeric Input

For example:

```java
int n = sc.nextInt();
```

`nextInt()` expects the user to enter an **integer**.

Valid examples:

```text
10
25
100
```

Invalid examples:

```text
ten
one
three
```

---

### 7. `InputMismatchException`

If the program expects an integer:

```java
int n = sc.nextInt();
```

but the user enters:

```text
ten
```

the input does not match the expected type.

Java can produce:

```text
InputMismatchException
```

---

### 8. Why Does It Happen?

The program says:

```text
"I need an integer."
```

The user provides:

```text
"ten"
```

But `"ten"` is text, not an integer value.

Therefore:

```text
Expected → integer
Received → text
             ↓
InputMismatchException
```

---

### 9. Complete Example

```java
import java.util.Scanner;

class Test3 {

    static void alpha() throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");

        int n = sc.nextInt();

        System.out.println("Number = " + n);
    }

    static void beta() throws Exception {

        alpha();

    }

    public static void main(String[] args) throws Exception {

        beta();

    }
}
```

---

### 10. Understanding `alpha()`

Inside `alpha()`:

```java
int n = sc.nextInt();
```

The program waits for keyboard input.

For example:

```text
Enter a number:
```

The user enters:

```text
10
```

The value is successfully stored in:

```text
n = 10
```

---

### 11. Valid Input

If the user enters:

```text
10
```

then:

```java
int n = sc.nextInt();
```

works correctly.

The output is:

```text
Enter a number:
10
Number = 10
```

No `InputMismatchException` occurs.

---

### 12. Invalid Input

If the user enters:

```text
ten
```

then:

```java
int n = sc.nextInt();
```

cannot convert that input into an integer.

Therefore:

```text
InputMismatchException
```

occurs.

---

### 13. Exception Object

When the exception occurs, Java creates an exception object.

Conceptually:

```text
sc.nextInt()
     ↓
Invalid input: "ten"
     ↓
InputMismatchException
     ↓
Exception object
     ↓
Runtime System
```

---

### 14. RTS Checks `alpha()`

The exception occurs inside:

```text
alpha()
```

The Runtime System checks whether `alpha()` contains an appropriate handler.

There is no `try-catch` in `alpha()`.

Instead, `alpha()` has:

```java
throws Exception
```

Therefore, the exception is passed toward its caller.

```text
alpha()
   ↓
beta()
```

---

### 15. `beta()` Also Ducks

`beta()` is declared:

```java
static void beta() throws Exception
```

and calls:

```java
alpha();
```

Since `beta()` does not handle the exception, it also ducks it.

The exception continues upward:

```text
alpha()
   ↓
beta()
```

---

### 16. `main()` Also Ducks

The `main()` method is declared:

```java
public static void main(String[] args) throws Exception
```

Therefore, `main()` also does not handle the exception.

The flow becomes:

```text
alpha()
   ↓
beta()
   ↓
main()
```

---

### 17. Complete Exception Flow

```text
main()
  ↓
beta()
  ↓
alpha()
  ↓
Scanner input
  ↓
User enters "ten"
  ↓
InputMismatchException
  ↓
RTS
  ↓
alpha() → no handler
  ↓
throws
  ↓
beta() → no handler
  ↓
throws
  ↓
main() → no handler
  ↓
throws
  ↓
Default Exception Handler
```

---

### 18. Why Is This Called Ducking?

Because every method avoids handling the exception.

```text
alpha()
  ↓
throws

beta()
  ↓
throws

main()
  ↓
throws
```

Nobody uses:

```java
catch (...)
```

So the exception continues upward.

---

### 19. `throws Exception` in `alpha()`

```java
static void alpha() throws Exception
```

This tells the caller:

```text
alpha()
 ↓
"I may produce an exception."
 ↓
"Caller, be prepared."
```

---

### 20. `throws Exception` in `beta()`

```java
static void beta() throws Exception
```

This tells its caller:

```text
beta()
 ↓
"I may receive/pass an exception from alpha()."
 ↓
"Caller, be prepared."
```

---

### 21. `throws Exception` in `main()`

```java
public static void main(String[] args) throws Exception
```

Here `main()` is also not handling the exception.

Therefore, the exception can reach the JVM's default exception handling mechanism.

---

### 22. Important Difference From Previous Example

Previously, the caller eventually used:

```java
try {
    ...
}
catch (Exception e) {
    ...
}
```

So the exception was handled.

In this `Test3` program:

```text
alpha() → throws
beta()  → throws
main()  → throws
```

There is no `catch` block.

Therefore, the exception is not handled by the program.

---

### 23. Invalid Input Example

Input:

```text
ten
```

Expected:

```text
integer
```

Result:

```text
InputMismatchException
```

The important relationship is:

```text
nextInt()
   ↓
expects integer
   ↓
"ten"
   ↓
InputMismatchException
```

---

### 24. Another Invalid Input

Input:

```text
one
```

Again:

```text
nextInt()
   ↓
expects integer
   ↓
"one"
   ↓
InputMismatchException
```

The same happens with:

```text
three
```

---

### 25. Valid vs Invalid Input

| User input | `nextInt()` result       |
| ---------- | ------------------------ |
| `10`       | Valid                    |
| `25`       | Valid                    |
| `100`      | Valid                    |
| `ten`      | `InputMismatchException` |
| `one`      | `InputMismatchException` |
| `three`    | `InputMismatchException` |

---

### 26. Method Call Flow

Normal method calling:

```text
main()
 ↓
beta()
 ↓
alpha()
 ↓
Scanner
```

Exception flow is in the opposite direction:

```text
alpha()
 ↓
beta()
 ↓
main()
 ↓
Default Exception Handler
```

This is a very important idea.

---

### 27. Why Does the Exception Move Upward?

The method where the exception occurred did not handle it.

So the Runtime System searches the caller.

```text
Exception occurs in alpha()
          ↓
alpha() has no handler
          ↓
check beta()
          ↓
beta() has no handler
          ↓
check main()
          ↓
main() has no handler
```

---

### 28. Common Confusion

Do not think:

```text
throws Exception
      ↓
exception handled
```

That is incorrect.

Correct:

```text
throws Exception
      ↓
exception responsibility is passed upward
```

---

### 29. Common Confusion

Do not think:

```text
throws Exception
      ↓
exception disappears
```

The exception does not disappear.

It continues through the caller hierarchy until a handler is found or the default handler takes over.

---

### 30. Important Rules

* `Scanner` is used to read keyboard input.
* `nextInt()` expects integer input.
* Invalid input such as `ten` can produce `InputMismatchException`.
* `alpha()` uses `throws Exception`.
* `beta()` uses `throws Exception`.
* `main()` uses `throws Exception`.
* None of these methods handles the exception with `catch`.
* The Runtime System searches the caller hierarchy.
* The exception continues upward when no handler is found.
* If no handler exists, the default exception handler handles the uncaught exception.
* The program terminates abnormally when the exception remains uncaught.

---

### 31. Memory Flow

```text
Scanner
  ↓
Invalid numeric input
  ↓
InputMismatchException
  ↓
alpha()
  ↓
throws
  ↓
beta()
  ↓
throws
  ↓
main()
  ↓
throws
  ↓
Default Exception Handler
```

---

### 32. Simple Memory Example

Think of:

```text
alpha() = worker
beta()  = manager
main()  = head
```

A problem occurs with the worker.

```text
worker
  ↓
"I won't handle it."
  ↓
manager
  ↓
"I won't handle it."
  ↓
head
```

If nobody handles the problem, it reaches the final authority.

That is similar to exception propagation.

---

### 33. Interview Understanding

The `Test3` program demonstrates **exception ducking through multiple methods**. `alpha()` reads integer input using `Scanner` and may produce `InputMismatchException`. `alpha()` declares `throws Exception`, `beta()` also declares `throws Exception`, and `main()` declares `throws Exception`. Since none of them contains a suitable `catch` block, the exception continues upward until the default exception handler handles the uncaught exception.

---

### 34. One Important Observation

There are two different flows to remember:

**Method-call flow:**

```text
main()
 ↓
beta()
 ↓
alpha()
```

**Exception-propagation flow:**

```text
alpha()
 ↓
beta()
 ↓
main()
 ↓
Default Handler
```

---

### 35. Memory Trick

Remember:

```text
CALL DOWN
main → beta → alpha

EXCEPTION UP
alpha → beta → main
```

And:

```text
No catch
   ↓
throws
   ↓
Caller
   ↓
throws again
   ↓
Next caller
```

---

### 36. Complete Lifetime Understanding

```text
                         main()
                           ↓
                 main() calls beta()
                           ↓
                         beta()
                           ↓
                beta() calls alpha()
                           ↓
                        alpha()
                           ↓
                    Create Scanner
                           ↓
                    Ask for number
                           ↓
                   User enters input
                           ↓
                 ┌─────────┴─────────┐
                 ↓                   ↓
              Valid                Invalid
                 ↓                   ↓
               10                 "ten"
                 ↓                   ↓
        Number = 10          InputMismatchException
                                     ↓
                              Exception object
                                     ↓
                                    RTS
                                     ↓
                            Check alpha()
                                     ↓
                             No catch found
                                     ↓
                                  throws
                                     ↓
                            Check beta()
                                     ↓
                             No catch found
                                     ↓
                                  throws
                                     ↓
                            Check main()
                                     ↓
                             No catch found
                                     ↓
                                  throws
                                     ↓
                       Default Exception Handler
                                     ↓
                         Exception information
                                     ↓
                       Abnormal program termination
```

**Core memory rule:**

> **In `Test3`, `alpha()` may produce `InputMismatchException`, but `alpha()`, `beta()`, and `main()` all duck the exception using `throws Exception`. The exception therefore propagates upward through the method hierarchy until the default exception handler receives the uncaught exception.**
