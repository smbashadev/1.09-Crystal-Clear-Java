# 4.4 InputMismatchException Example

## 1️⃣ Start From ZERO

Imagine Java asks you:

```text
Enter a number:
```

Java expects something like:

```text
10
```

But you enter:

```text
ten
```

Java cannot treat `"ten"` as an integer.

So an **InputMismatchException** occurs.

---

## 2️⃣ What Is InputMismatchException?

> **InputMismatchException occurs when the input received by `Scanner` does not match the type of input expected by the program.**

Example:

```text
Expected → number
Received → ten
```

---

## 3️⃣ Real-World Analogy 🧒

Imagine someone asks:

> "Give me your age as a number."

You answer:

> "Twenty."

The person expected:

```text
20
```

but received:

```text
Twenty
```

Java's `Scanner` faces a similar problem.

---

## 4️⃣ Simple Definition

> **InputMismatchException is a runtime exception that occurs when `Scanner` receives input that does not match the expected data type.**

---

## 5️⃣ Why Does It Occur?

Suppose the program contains:

```java
int n = sc.nextInt();
```

This means:

> "Scanner, give me an integer."

If the user enters:

```text
10
```

Everything is fine.

If the user enters:

```text
ten
```

the input does not match `int`.

Therefore:

```text
InputMismatchException
```

---

## 6️⃣ Simple Program

```java
import java.util.Scanner;

class Demo {

    public static void main(String[] args) {

        fun3();
    }

    static void fun3() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");

        int n = sc.nextInt();

        System.out.println("Number = " + n);
    }
}
```

---

## 7️⃣ Normal Input

Suppose the user enters:

```text
10
```

Execution:

```text
Scanner
   ↓
10
   ↓
nextInt()
   ↓
Integer accepted
   ↓
Program continues
```

Output:

```text
Enter a number: 10
Number = 10
```

---

## 8️⃣ Invalid Input

Suppose the user enters:

```text
ten
```

The program expects:

```text
int
```

but receives:

```text
ten
```

So:

```text
Scanner
   ↓
"ten"
   ↓
nextInt()
   ↓
InputMismatchException
```

---

## 9️⃣ Execution Flow

```text
main()
 ↓
fun3()
 ↓
Scanner created
 ↓
Numeric input expected
 ↓
User enters "ten"
 ↓
InputMismatchException
```

---

## 🔟 What Happens Internally?

When `nextInt()` tries to read:

```text
ten
```

it cannot convert that input into an integer.

Therefore, Java creates an exception object:

```text
InputMismatchException object
```

---

## 1️⃣1️⃣ Exception Object

Conceptually:

```text
Invalid input
     ↓
InputMismatchException object
```

The object represents the problem that occurred while reading the input.

---

## 1️⃣2️⃣ RTS Receives the Exception

The exception object is handed to the **Runtime System (RTS)**.

```text
InputMismatchException
        ↓
Exception object
        ↓
RTS
```

The RTS determines whether the exception can be handled.

---

## 1️⃣3️⃣ RTS Checks `fun3()`

The exception occurred in:

```text
fun3()
```

So the RTS first checks whether `fun3()` has a suitable exception handler.

If there is no handler:

```text
fun3()
 ↓
No handler
```

the exception can propagate to the caller.

---

## 1️⃣4️⃣ Propagation to `main()`

Our hierarchy is:

```text
main()
 ↓
fun3()
```

The exception occurs in `fun3()`.

If `fun3()` doesn't handle it:

```text
fun3()
 ↑
main()
```

The RTS checks `main()` for a suitable handler.

---

## 1️⃣5️⃣ No Handler

If neither method contains a suitable handler:

```text
fun3()
 ↓
Exception
 ↓
No handler
 ↓
main()
 ↓
No handler
```

The exception reaches the default exception handler.

---

## 1️⃣6️⃣ Default Exception Handler

If the exception remains unhandled:

```text
InputMismatchException
       ↓
Default Exception Handler
```

The default handler prints information about the exception and the affected thread terminates.

---

## 1️⃣7️⃣ Complete Flow

```text
main()
 ↓
fun3()
 ↓
Scanner
 ↓
nextInt()
 ↓
User enters "ten"
 ↓
InputMismatchException object created
 ↓
RTS receives object
 ↓
Check fun3()
 ↓
No handler
 ↓
Check main()
 ↓
No handler
 ↓
Default Exception Handler
```

---

## 1️⃣8️⃣ Why Is `"ten"` Invalid?

Because:

```java
sc.nextInt();
```

expects an integer.

Valid examples:

```text
10
25
100
-5
```

Invalid examples:

```text
ten
hello
abc
```

For these non-integer inputs, `nextInt()` can throw `InputMismatchException`.

---

## 1️⃣9️⃣ Numeric Input vs Invalid Input

| Input   | `nextInt()` |
| ------- | ----------- |
| `10`    | Accepted    |
| `25`    | Accepted    |
| `-5`    | Accepted    |
| `ten`   | Exception   |
| `hello` | Exception   |
| `abc`   | Exception   |

---

## 2️⃣0️⃣ Method Hierarchy

The method hierarchy is:

```text
main()
 ↓
fun3()
```

The exception starts here:

```text
fun3()
 ↓
InputMismatchException
```

If not handled:

```text
fun3()
 ↑
main()
```

---

## 2️⃣1️⃣ Connection With Exception Propagation

This example demonstrates exception propagation.

```text
fun3()
 ↓
Exception
 ↑
main()
```

The exception moves from the method where it occurs toward its caller.

---

## 2️⃣2️⃣ What If `fun3()` Handles It?

We can add:

```java
try {
    int n = sc.nextInt();
}
catch (InputMismatchException e) {
    System.out.println("Invalid input");
}
```

Now:

```text
fun3()
 ↓
Exception
 ↓
Handler found
 ↓
catch executes
```

Propagation stops inside `fun3()`.

---

## 2️⃣3️⃣ Program With Handler

```java
import java.util.Scanner;
import java.util.InputMismatchException;

class Demo {

    public static void main(String[] args) {

        fun3();

        System.out.println("Program Ends");
    }

    static void fun3() {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Enter a number: ");

            int n = sc.nextInt();

            System.out.println("Number = " + n);
        }
        catch (InputMismatchException e) {

            System.out.println("Invalid numeric input");
        }
    }
}
```

---

## 2️⃣4️⃣ Output With Invalid Input

Input:

```text
ten
```

Output:

```text
Enter a number: ten
Invalid numeric input
Program Ends
```

The program reaches:

```text
Program Ends
```

because the exception was handled.

---

## 2️⃣5️⃣ Handler vs Default Handler

### Without handler

```text
Invalid input
 ↓
InputMismatchException
 ↓
RTS
 ↓
No handler
 ↓
Default Exception Handler
 ↓
Abnormal termination
```

### With handler

```text
Invalid input
 ↓
InputMismatchException
 ↓
RTS
 ↓
Handler found
 ↓
catch executes
 ↓
Program continues
```

---

## 2️⃣6️⃣ Important Concept

The important difference is:

```text
No handler
   ↓
Default Exception Handler
   ↓
Affected thread terminates
```

versus:

```text
Handler found
   ↓
catch executes
   ↓
Program continues normally
```

---

## 2️⃣7️⃣ Why Does RTS Matter?

RTS is responsible for dealing with the exception after it occurs.

Conceptually:

```text
Exception occurs
      ↓
Exception object
      ↓
RTS
      ↓
Search for handler
      ↓
Handler found?
```

If yes:

```text
catch
```

If no:

```text
Default Exception Handler
```

---

## 2️⃣8️⃣ Important Rules

1. `Scanner` can be used to receive user input.
2. `nextInt()` expects integer input.
3. Numeric input matching `int` is accepted.
4. Invalid input such as `ten` does not match `int`.
5. `InputMismatchException` can occur.
6. An exception object is created when the exception occurs.
7. The Runtime System receives the exception.
8. RTS checks the method where the exception occurred.
9. If no handler exists, the exception can propagate to the caller.
10. The caller is checked for a suitable handler.
11. If no method handles the exception, it reaches the default exception handler.
12. The affected thread terminates when the exception remains uncaught.

---

## 2️⃣9️⃣ Memory Trick 🧠

Remember:

> **`nextInt()` wants a number. Give it `"ten"` → mismatch.**

```text
nextInt()
   ↓
Expected → 10
Received → ten
   ↓
InputMismatchException
```

---

## 3️⃣0️⃣ Interview Question

### ❓ What is InputMismatchException?

> `InputMismatchException` is a runtime exception that occurs when input received through `Scanner` does not match the expected input type.

---

## 3️⃣1️⃣ Interview Question

### ❓ When does `InputMismatchException` occur with `nextInt()`?

> It occurs when `nextInt()` expects an integer but the user provides input that cannot be interpreted as an integer, such as `ten`.

---

## 3️⃣2️⃣ Interview Question

### ❓ What happens if InputMismatchException is not handled?

> The exception propagates through the calling method hierarchy. If no suitable handler is found, it reaches the default exception handler and the affected thread terminates.

---

## 3️⃣3️⃣ Complete Program

```java
import java.util.Scanner;

class Demo {

    public static void main(String[] args) {

        System.out.println("Program Starts");

        fun3();

        System.out.println("Program Ends");
    }

    static void fun3() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");

        int n = sc.nextInt();

        System.out.println("Number = " + n);
    }
}
```

Input:

```text
ten
```

Flow:

```text
main()
 ↓
fun3()
 ↓
Scanner
 ↓
nextInt()
 ↓
"ten"
 ↓
InputMismatchException
 ↓
RTS
 ↓
No handler
 ↓
Default Exception Handler
```

---

## 3️⃣4️⃣ Program With Propagation

```java
import java.util.Scanner;

class Demo {

    public static void main(String[] args) {

        System.out.println("Inside main");

        fun1();

        System.out.println("Program Ends");
    }

    static void fun1() {

        System.out.println("Inside fun1");

        fun3();

        System.out.println("Back to fun1");
    }

    static void fun3() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");

        int n = sc.nextInt();

        System.out.println("Number = " + n);
    }
}
```

Hierarchy:

```text
main()
 ↓
fun1()
 ↓
fun3()
 ↓
InputMismatchException
```

If neither method handles it:

```text
fun3()
 ↑
fun1()
 ↑
main()
 ↑
Default Exception Handler
```

---

## 3️⃣5️⃣ Super-Simple Mental Model 🧒

Think of a machine that only accepts numbers:

```text
Machine → "Enter a number"
```

You enter:

```text
10
```

Machine says:

```text
Okay 👍
```

You enter:

```text
ten
```

Machine says:

```text
Wrong type!
```

Java does the same:

```text
nextInt()
   ↓
"ten"
   ↓
Wrong input type
   ↓
InputMismatchException
```

---

## 3️⃣6️⃣ Final Understanding 🎯

The complete process is:

```text
main()
 ↓
fun3()
 ↓
Scanner
 ↓
nextInt()
 ↓
User enters "ten"
 ↓
InputMismatchException
 ↓
Exception object created
 ↓
RTS receives exception
 ↓
RTS checks fun3()
 ↓
No handler
 ↓
Exception propagates to caller
 ↓
No handler
 ↓
Default Exception Handler
 ↓
Affected thread terminates
```

### ⭐ Remember:

> **When `Scanner.nextInt()` expects a number but receives invalid input such as `"ten"`, an `InputMismatchException` can occur and, if nobody handles it, it propagates through the method hierarchy to the default exception handler.**
