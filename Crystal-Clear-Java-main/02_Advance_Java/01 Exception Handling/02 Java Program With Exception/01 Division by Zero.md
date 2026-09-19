# 🧒 2.1 Java Program With Exception: Division by Zero

This topic demonstrates a very simple Java program where an **exception actually occurs** because the program attempts to divide an integer by zero.

Your points are:

* `Demo`
* `Scanner` input
* Division
* `ArithmeticException`
* Abrupt termination

---

# 1️⃣ Start From ZERO

Let's first understand the normal operation.

Suppose:

```text
10 ÷ 2 = 5
```

Java can perform this operation normally.

But if the user enters:

```text
10 ÷ 0
```

Java cannot perform integer division by zero.

So Java produces an exception:

```text
ArithmeticException
```

---

# 2️⃣ What Is Happening?

Our program will:

```text
Start
  ↓
Take first number
  ↓
Take second number
  ↓
Divide first by second
  ↓
Exception occurs if second = 0
  ↓
Normal flow is interrupted
```

---

# 3️⃣ Real-World Analogy 🧒

Imagine a calculator.

You ask it:

```text
100 ÷ 5
```

It can answer:

```text
20
```

But:

```text
100 ÷ 0
```

is not a valid integer division operation.

The calculator cannot produce a normal result.

Java similarly encounters an exceptional situation.

---

# 4️⃣ Java Program

```java
import java.util.Scanner;

class Demo {

    public static void main(String[] args) {

        System.out.println("Program Starts");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int first = sc.nextInt();

        System.out.print("Enter second number: ");
        int second = sc.nextInt();

        int result = first / second;

        System.out.println("Result = " + result);

        System.out.println("Program Ends");
    }
}
```

---

# 5️⃣ Example: Valid Input

Suppose the user enters:

```text
Enter first number: 20
Enter second number: 5
```

Java performs:

```text
20 / 5
 ↓
4
```

Output:

```text
Program Starts
Enter first number: 20
Enter second number: 5
Result = 4
Program Ends
```

No exception occurs.

---

# 6️⃣ Example: Division by Zero

Now suppose the user enters:

```text
Enter first number: 20
Enter second number: 0
```

The important statement becomes:

```java
int result = first / second;
```

which means:

```text
20 / 0
```

Java encounters:

```text
ArithmeticException
```

---

# 7️⃣ Why `ArithmeticException`?

`ArithmeticException` is a Java runtime exception used for certain invalid arithmetic operations.

For integer division:

```java
10 / 0
```

causes:

```text
java.lang.ArithmeticException: / by zero
```

---

# 8️⃣ Execution Flow

Let's follow the program step by step.

```text
JVM starts
   ↓
main() starts
   ↓
Print "Program Starts"
   ↓
Create Scanner
   ↓
Read first number
   ↓
Read second number
   ↓
Perform division
   ↓
Division by zero
   ↓
ArithmeticException
```

The program's normal flow is interrupted at the division.

---

# 9️⃣ Line-by-Line Explanation

### Line 1

```java
import java.util.Scanner;
```

Makes the `Scanner` class available.

---

### Line 2

```java
class Demo {
```

Creates the `Demo` class.

---

### Line 3

```java
public static void main(String[] args) {
```

Execution starts from `main()` for this standalone application.

---

### Line 4

```java
Scanner sc = new Scanner(System.in);
```

Creates a `Scanner` to read keyboard input.

---

### Line 5

```java
int first = sc.nextInt();
```

Reads the first integer.

Suppose:

```text
first = 20
```

---

### Line 6

```java
int second = sc.nextInt();
```

Reads the second integer.

Suppose:

```text
second = 0
```

---

### Line 7 ⭐

```java
int result = first / second;
```

Java attempts:

```text
20 / 0
```

This causes:

```text
ArithmeticException
```

---

# 🔟 What Happens After the Exception?

These statements:

```java
System.out.println("Result = " + result);
```

and:

```java
System.out.println("Program Ends");
```

are **not executed normally** because the exception occurs before them.

So the flow is:

```text
Program Starts
      ↓
Read 20
      ↓
Read 0
      ↓
20 / 0
      ↓
ArithmeticException ❌
      ↓
Normal execution interrupted
```

---

# 1️⃣1️⃣ Abrupt Termination

Your notes specifically mention:

> **Abrupt termination**

If the exception remains unhandled, the affected thread terminates.

In this simple program, the exception occurs in the `main` thread, so the program terminates.

Conceptually:

```text
Program
  ↓
Division by zero
  ↓
ArithmeticException
  ↓
No handler
  ↓
Exception remains uncaught
  ↓
main thread terminates
```

---

# 1️⃣2️⃣ What Does "Abrupt" Mean?

**Abrupt = sudden or unexpected.**

The programmer expected:

```text
Division
 ↓
Result
 ↓
Program Ends
```

But instead:

```text
Division
 ↓
Exception ❌
 ↓
Program stops
```

That's why we call it **abrupt termination** when the exception is uncaught.

---

# 1️⃣3️⃣ Normal vs Exceptional Flow

### Normal

```text
20 / 5
   ↓
4
   ↓
Print Result
   ↓
Program Ends
```

### Exceptional

```text
20 / 0
   ↓
ArithmeticException
   ↓
Normal flow interrupted
   ↓
main thread terminates if uncaught
```

---

# 1️⃣4️⃣ Scanner's Role

The `Scanner` itself isn't causing the arithmetic exception.

It only obtains the values.

```java
int first = sc.nextInt();
int second = sc.nextInt();
```

For example:

```text
first = 20
second = 0
```

The exception occurs later:

```java
first / second
```

So:

```text
Scanner
   ↓
Provides input
   ↓
20 and 0
   ↓
Division operation
   ↓
ArithmeticException
```

---

# 1️⃣5️⃣ Important Concept

The exception doesn't happen simply because the user entered `0`.

Entering zero is perfectly valid for an integer variable:

```java
int second = 0;
```

This is valid.

The problem occurs when zero is used as the divisor:

```java
20 / 0
```

Therefore:

> **Zero itself is not the exception; integer division by zero is the exceptional operation.**

---

# 1️⃣6️⃣ Very Important Difference

This is valid:

```java
int x = 0;
```

No exception.

This is also valid:

```java
int x = 20;
int y = 0;
```

No exception yet.

The exception occurs when Java executes:

```java
int result = x / y;
```

---

# 1️⃣7️⃣ Runtime Nature

Consider:

```java
int second = sc.nextInt();
```

The compiler doesn't know what the user will enter.

The user might enter:

```text
5
```

or:

```text
0
```

Therefore the exceptional condition is discovered during execution.

```text
Compile
   ↓
Successful
   ↓
Run
   ↓
User enters 0
   ↓
Division
   ↓
ArithmeticException
```

---

# 1️⃣8️⃣ Why Is This an Exception?

Because the program expected to perform:

```text
first / second
```

but the runtime values resulted in an invalid arithmetic operation for integer division.

Therefore:

```text
Unexpected runtime condition
        ↓
ArithmeticException
```

---

# 1️⃣9️⃣ What Happens Internally at a High Level?

You don't need JVM internals yet, but understand the basic flow:

```text
Java bytecode
     ↓
JVM executes division
     ↓
Divisor is zero
     ↓
JVM detects exceptional condition
     ↓
ArithmeticException object is thrown
     ↓
JVM searches for handler
```

If no appropriate handler is found:

```text
Exception propagates
      ↓
No handler
      ↓
Uncaught exception
      ↓
Thread terminates
```

---

# 2️⃣0️⃣ What Is the Exception Object?

Java represents an exception using an **object**.

Conceptually:

```text
ArithmeticException object
        ↓
contains information about
the exceptional condition
```

For example, you may see:

```text
java.lang.ArithmeticException: / by zero
```

---

# 2️⃣1️⃣ What Does `/ by zero` Mean?

The JVM may report something similar to:

```text
java.lang.ArithmeticException: / by zero
```

It means:

> An integer division operation attempted to use zero as the divisor.

---

# 2️⃣2️⃣ Stack Trace

When an exception is uncaught, Java normally prints a **stack trace**.

For example:

```text
Exception in thread "main" java.lang.ArithmeticException: / by zero
    at Demo.main(Demo.java:...)
```

The exact line number depends on your source file.

The stack trace helps identify:

```text
Exception type
     ↓
Message
     ↓
Method where it occurred
     ↓
Source location
```

---

# 2️⃣3️⃣ Default Uncaught-Exception Behavior

Because our program has no:

```java
try
catch
```

the exception is not handled by our application code.

It propagates until it becomes uncaught.

Then Java's default uncaught-exception behavior reports the exception and stack trace.

```text
ArithmeticException
       ↓
No application handler
       ↓
Uncaught
       ↓
Default handling
       ↓
main thread terminates
```

---

# 2️⃣4️⃣ What If We Add `try-catch`?

Now let's handle it.

```java
import java.util.Scanner;

class Demo {

    public static void main(String[] args) {

        System.out.println("Program Starts");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int first = sc.nextInt();

        System.out.print("Enter second number: ");
        int second = sc.nextInt();

        try {
            int result = first / second;
            System.out.println("Result = " + result);
        }
        catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }

        System.out.println("Program Ends");
    }
}
```

Now if the user enters:

```text
20
0
```

the output can be:

```text
Program Starts
Enter first number: 20
Enter second number: 0
Cannot divide by zero
Program Ends
```

The exception is handled.

---

# 2️⃣5️⃣ Compare Both Programs

### ❌ Without handler

```text
20 / 0
 ↓
ArithmeticException
 ↓
No handler
 ↓
Uncaught exception
 ↓
main thread terminates
```

### ✅ With handler

```text
20 / 0
 ↓
ArithmeticException
 ↓
catch
 ↓
"Cannot divide by zero"
 ↓
Program Ends
```

---

# 2️⃣6️⃣ Exception vs Error

Don't confuse:

```text
ArithmeticException
```

with:

```text
Error
```

`ArithmeticException` belongs to Java's exception hierarchy.

At a high level:

```text
Throwable
   ├── Error
   └── Exception
          └── RuntimeException
                 └── ArithmeticException
```

This hierarchy becomes important when we study checked and unchecked exceptions.

---

# 2️⃣7️⃣ Common Confusions

### ❌ "Scanner causes ArithmeticException."

No.

`Scanner` only obtains the input.

The division operation causes it.

---

### ❌ "Entering zero causes ArithmeticException."

Not by itself.

```java
int x = 0;
```

is valid.

The problem is:

```java
10 / 0
```

---

### ❌ "The compiler catches division by zero."

For a runtime input such as:

```java
int second = sc.nextInt();
```

the compiler cannot know what value will be entered.

The exceptional condition is encountered during execution.

---

# 2️⃣8️⃣ Another Important Exception

Be careful about integer vs floating-point division.

For integer types:

```java
int x = 10 / 0;
```

causes:

```text
ArithmeticException
```

But floating-point arithmetic has different IEEE 754 behavior.

For example:

```java
double x = 10.0 / 0.0;
```

produces positive infinity rather than an `ArithmeticException`.

So the precise rule is:

> **Integer division by zero causes `ArithmeticException`; floating-point division follows different rules.**

---

# 2️⃣9️⃣ Important Rules

Remember these:

1. `0` is a valid integer value.
2. Assigning `0` to an integer variable does not cause an exception.
3. Integer division by zero causes `ArithmeticException`.
4. The exception occurs during runtime.
5. An uncaught exception interrupts normal execution.
6. The affected thread terminates if the exception remains uncaught.
7. In a simple standalone program, an uncaught exception in `main` causes the program to terminate.
8. `try-catch` can be used to handle the exception.
9. `Scanner` provides input; it doesn't itself cause the arithmetic exception.
10. Floating-point division by zero behaves differently from integer division.

---

# 3️⃣0️⃣ Memory Trick 🧠

Remember:

### **ZERO → DIVISION → EXCEPTION**

```text
0
 ↓
Used as divisor
 ↓
Integer division
 ↓
ArithmeticException
```

And:

### **UNCaught → TERMINATE**

```text
Exception
 ↓
No handler
 ↓
Uncaught
 ↓
Thread terminates
```

---

# 3️⃣1️⃣ Interview Question

### ❓ What exception occurs when we divide an integer by zero?

Answer:

> **`ArithmeticException` occurs when an integer division operation attempts to divide by zero.**

Example:

```java
int result = 10 / 0;
```

---

# 3️⃣2️⃣ Interview Question

### ❓ Does assigning zero to an integer cause an exception?

Answer:

> **No. Zero is a valid integer value. `ArithmeticException` occurs when zero is used as the divisor in an integer division operation.**

---

# 3️⃣3️⃣ Interview Question

### ❓ What happens if `ArithmeticException` is not handled?

Answer:

> The exception propagates through the call stack. If it remains uncaught, Java's default uncaught-exception behavior reports the exception and the affected thread terminates. In a simple application where it occurs in `main`, the program terminates.

---

# 3️⃣4️⃣ Complete Flow

```text
             Demo
               ↓
             main()
               ↓
            Scanner
               ↓
        ┌──────┴──────┐
        ↓             ↓
   First number   Second number
        ↓             ↓
       20             0
        └──────┬──────┘
               ↓
            Division
               ↓
             20 / 0
               ↓
       ArithmeticException
               ↓
        Is it handled?
          /       \
        YES        NO
         ↓          ↓
      catch      Propagation
         ↓          ↓
     Handle      Uncaught
      problem       ↓
                 Default
                  handling
                    ↓
              main thread
                terminates
```

---

# 3️⃣5️⃣ One-Line Definition

> **When a Java program attempts to perform integer division by zero, the JVM throws an `ArithmeticException`, which interrupts normal execution and, if uncaught, causes the affected thread to terminate.**

---

# 3️⃣6️⃣ Final `/eli5` Understanding 🎯

Imagine Java is a calculator.

You tell it:

```text
First number  = 20
Second number = 5
```

It happily calculates:

```text
20 ÷ 5 = 4
```

But then:

```text
First number  = 20
Second number = 0
```

Java reaches:

```text
20 ÷ 0
```

and says, essentially:

```text
❌ I cannot perform this integer division.
```

Java represents this exceptional situation as:

```text
ArithmeticException
```

The complete idea is:

```text
Scanner Input
     ↓
20 and 0
     ↓
20 / 0
     ↓
ArithmeticException
     ↓
Normal flow interrupted
     ↓
No handler?
     ↓
Uncaught exception
     ↓
main thread terminates
```

### ⭐ Remember this sentence:

> **Division by zero is the first classic example of an exception: the operation creates an `ArithmeticException`, which disturbs normal program flow and, when uncaught, causes the affected thread to terminate.**
