# 🧒 Exception

## 1.1 Java Program Where Exception Doesn't Occur

Before learning **what an exception is**, it is important to understand what happens when a Java program runs **normally without any exception**.

---

# 1️⃣ Start From ZERO

Imagine you are doing a simple division:

```text
10 ÷ 2 = 5
```

Everything is correct:

* You entered a valid first number.
* You entered a valid second number.
* The second number is not zero.
* Division can be performed.
* Java gets the result.
* The program reaches the end normally.

This is called **normal program execution**.

---

# 2️⃣ What Is an Exception?

An **exception** is an unexpected problem that occurs while a program is running and interrupts its normal flow.

For example:

```text
10 ÷ 2
```

works normally.

But:

```text
10 ÷ 0
```

causes a problem in integer arithmetic.

So we can think of:

```text
Normal situation
      ↓
Program continues
      ↓
Program ends normally
```

versus:

```text
Problem occurs
      ↓
Exception
      ↓
Normal flow is interrupted
```

---

# 3️⃣ Our Program

Your notes describe a program containing:

* `Demo` class
* `main()` method
* `Scanner`
* First number
* Second number
* Division
* Result
* Program starts
* Program ends

Let's create a simple program.

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

Suppose the user enters:

```text
Enter first number: 10
Enter second number: 2
```

Output:

```text
Program Starts
Enter first number: 10
Enter second number: 2
Result = 5
Program Ends
```

There is **no exception** in this execution.

---

# 4️⃣ Real-World Analogy 🧒

Imagine going to a shop.

```text
You enter shop
      ↓
Ask for product
      ↓
Pay money
      ↓
Receive product
      ↓
Leave shop
```

Everything happens successfully.

There is no problem.

A Java program can work in exactly the same way:

```text
Program starts
      ↓
Input
      ↓
Processing
      ↓
Output
      ↓
Program ends
```

That's **normal execution**.

---

# 5️⃣ Why Are We Studying a Program With No Exception?

Because you need to first understand **normal flow**.

Later, when we study exceptions, you'll see what happens when something goes wrong.

### Normal execution

```text
Start
 ↓
Input
 ↓
Division
 ↓
Result
 ↓
End
```

### Exception execution

```text
Start
 ↓
Input
 ↓
Problem
 ↓
Exception
 ↓
Normal flow interrupted
```

Understanding the first flow makes the second one much easier.

---

# 6️⃣ Technical Meaning

In Java, an exception is an event that occurs during program execution that **disrupts the normal flow of instructions**.

In our current example:

```java
int result = first / second;
```

If:

```text
first = 10
second = 2
```

then:

```text
10 / 2
 ↓
5
```

No exception occurs.

The next statement executes:

```java
System.out.println("Result = " + result);
```

Then:

```java
System.out.println("Program Ends");
```

executes.

---

# 7️⃣ Understanding the `Demo` Class

```java
class Demo {
```

This creates a class called `Demo`.

Think of a class as a **container that holds Java code**.

```text
Demo
 ↓
Contains main()
```

---

# 8️⃣ Understanding `main()`

```java
public static void main(String[] args) {
```

The `main()` method is the **starting point of this standalone Java application**.

You can think:

```text
JVM
 ↓
main()
 ↓
Program execution
```

---

# 9️⃣ Understanding Scanner

We use:

```java
import java.util.Scanner;
```

and:

```java
Scanner sc = new Scanner(System.in);
```

`Scanner` helps us receive input from the keyboard.

For example:

```java
int first = sc.nextInt();
```

means:

> Read an integer entered by the user and store it in `first`.

---

# 🔟 First Number

```java
int first = sc.nextInt();
```

Suppose the user enters:

```text
10
```

Then:

```text
first = 10
```

---

# 1️⃣1️⃣ Second Number

```java
int second = sc.nextInt();
```

Suppose the user enters:

```text
2
```

Then:

```text
second = 2
```

---

# 1️⃣2️⃣ Division

Now Java executes:

```java
int result = first / second;
```

The values are:

```text
first  = 10
second = 2
```

Therefore:

```text
result = 10 / 2
       = 5
```

---

# 1️⃣3️⃣ Result

Then:

```java
System.out.println("Result = " + result);
```

prints:

```text
Result = 5
```

---

# 1️⃣4️⃣ Program Starts

At the beginning:

```java
System.out.println("Program Starts");
```

Output:

```text
Program Starts
```

This simply helps us see that execution has started.

---

# 1️⃣5️⃣ Program Ends

At the end:

```java
System.out.println("Program Ends");
```

Output:

```text
Program Ends
```

Because no exception occurred, Java reaches this statement normally.

---

# 1️⃣6️⃣ Complete Execution Flow 🔄

```text
JVM starts program
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
Store result
       ↓
Print result
       ↓
Print "Program Ends"
       ↓
main() finishes
       ↓
Program terminates normally
```

---

# 1️⃣7️⃣ Input → Processing → Output

This program follows:

```text
INPUT
  ↓
10, 2
  ↓
PROCESSING
  ↓
10 / 2
  ↓
OUTPUT
  ↓
5
```

---

# 1️⃣8️⃣ What Exactly Makes This a Normal Execution?

The important point is:

```java
int result = first / second;
```

is successfully executed.

For:

```text
first = 10
second = 2
```

Java can perform the operation.

Therefore:

```text
No exception
     ↓
Execution continues
     ↓
Next statement executes
     ↓
Program Ends
```

---

# 1️⃣9️⃣ What If We Enter Zero?

Now suppose:

```text
First number: 10
Second number: 0
```

The program reaches:

```java
int result = first / second;
```

which becomes:

```java
10 / 0
```

For integer division, Java cannot perform this operation normally.

An `ArithmeticException` occurs.

The flow changes:

```text
Program Starts
      ↓
Read 10
      ↓
Read 0
      ↓
10 / 0
      ↓
ArithmeticException
      ↓
Normal flow interrupted
```

The statement:

```java
System.out.println("Program Ends");
```

will **not be reached normally** in this execution because the exception occurs first.

---

# 2️⃣0️⃣ Normal vs Exceptional Execution

| Normal Execution             | Exceptional Execution               |
| ---------------------------- | ----------------------------------- |
| Input is valid               | Problem occurs                      |
| Division succeeds            | Division fails                      |
| Result is produced           | Result isn't produced normally      |
| Next statements execute      | Normal flow is interrupted          |
| Program reaches end normally | Exception propagates unless handled |

---

# 2️⃣1️⃣ Important Rule

> **An exception does not necessarily mean that the Java program failed to compile.**

Our division program can compile successfully.

The problem can occur **while the program is running**.

So:

```text
Compilation
     ↓
Successful
     ↓
Program starts
     ↓
Runtime problem
     ↓
Exception
```

This is why exceptions are primarily associated with **runtime behavior**.

---

# 2️⃣2️⃣ Common Confusion

### ❌ Exception is not the same as a syntax error.

For example:

```java
int x = ;
```

is a syntax/compile-time error.

But:

```java
int x = 10 / 0;
```

for integer division causes an `ArithmeticException` at runtime.

Think:

```text
Syntax problem
     ↓
Compiler
     ↓
Compile-time error
```

```text
Runtime problem
     ↓
JVM execution
     ↓
Exception
```

---

# 2️⃣3️⃣ Another Important Point

The word **exception** basically means:

> Something happened that is outside the normal expected flow.

In our first execution:

```text
10 / 2
```

nothing unusual happens.

Therefore:

```text
No exception
```

---

# 2️⃣4️⃣ Why `Program Ends` Is Important

We intentionally included:

```java
System.out.println("Program Ends");
```

This helps us observe the difference between normal and exceptional execution.

### Valid input

```text
Program Starts
Result = 5
Program Ends
```

### Invalid division

```text
Program Starts
Exception occurs
```

The second execution does not reach the final print statement normally.

---

# 2️⃣5️⃣ Simple Diagram

```text
             Java Program
                  │
                  ↓
             Program Starts
                  │
                  ↓
             Read Numbers
                  │
                  ↓
              Division
                  │
          ┌───────┴────────┐
          ↓                ↓
       Valid             Problem
          ↓                ↓
       Result          Exception
          ↓                ↓
   Program Ends      Flow interrupted
```

---

# 2️⃣6️⃣ Important Rules / Points

* Java programs normally execute sequentially.
* Statements execute from one step to the next.
* An exception can interrupt this normal flow.
* `Scanner` can be used to receive keyboard input.
* Integer division by zero causes `ArithmeticException`.
* If no exception occurs, subsequent statements continue executing.
* If an exception occurs and is not handled, normal execution of the affected flow is interrupted.
* Exceptions are primarily associated with runtime problems.

---

# 2️⃣7️⃣ Common Mistakes

### Mistake 1 ❌

Thinking every program produces an exception.

**Correct:** Exceptions occur only when an exceptional condition occurs.

---

### Mistake 2 ❌

Thinking an exception is always a compilation problem.

**Correct:** Many exceptions occur during runtime.

---

### Mistake 3 ❌

Thinking:

```java
10 / 2
```

causes an exception.

**Correct:**

```text
10 / 2 → 5 → Normal
```

But:

```text
10 / 0 → ArithmeticException
```

for integer arithmetic.

---

# 2️⃣8️⃣ Compile Time vs Runtime

```text
Java Source Code
      ↓
Compiler
      ↓
Bytecode
      ↓
JVM
      ↓
Program executes
      ↓
Runtime
```

Our example:

```java
int result = first / second;
```

is valid Java syntax.

Whether the actual division succeeds depends on the **runtime values**.

```text
second = 2
   ↓
10 / 2
   ↓
Success
```

```text
second = 0
   ↓
10 / 0
   ↓
ArithmeticException
```

---

# 2️⃣9️⃣ Who Decides What Happens?

The **runtime execution environment/JVM** encounters the exceptional condition when the division operation is performed.

The compiler doesn't know what number the user will enter at runtime.

For example:

```java
int second = sc.nextInt();
```

The compiler cannot know whether the user will enter:

```text
2
```

or:

```text
0
```

Therefore, the result of the operation depends on runtime input.

---

# 3️⃣0️⃣ Real-World Comparison

Imagine a calculator.

### Normal:

```text
User: 20
User: 4
Calculator: 20 ÷ 4
Calculator: 5
```

Everything works.

### Problem:

```text
User: 20
User: 0
Calculator: 20 ÷ 0
Calculator: ❌ Cannot perform operation
```

Java similarly encounters an exceptional condition.

---

# 3️⃣1️⃣ Why Exception Handling Is Needed

Suppose this is a real application:

```text
User enters 0
       ↓
Division fails
       ↓
Application suddenly stops
```

That's not a good user experience.

Exception handling allows us to say:

```text
Problem occurred
       ↓
Handle the problem
       ↓
Show meaningful message
       ↓
Continue or terminate gracefully
```

This leads to concepts such as:

```text
try
catch
finally
throw
throws
```

which we'll encounter in the exception-handling section.

---

# 3️⃣2️⃣ Memory Trick 🧠

Remember:

```text
NO PROBLEM
   ↓
Normal Flow
   ↓
Start → Input → Process → Output → End
```

And:

```text
PROBLEM
   ↓
Exception
   ↓
Normal Flow Interrupted
```

### One very easy rule:

> **No exception → normal flow continues.**

---

# 3️⃣3️⃣ One-Line Concept

> **Normal program execution means the Java program executes its statements successfully in the expected sequence and reaches the end without an exception interrupting the flow.**

---

# 3️⃣4️⃣ Interview Question

### ❓ What happens when no exception occurs in a Java program?

### Answer:

> When no exception occurs, the Java program follows its normal execution flow. Statements execute sequentially, the required result is produced, subsequent statements continue executing, and the program reaches the end normally.

---

# 3️⃣5️⃣ Interview Example

If the interviewer asks:

### ❓ What happens when `10 / 2` is executed?

Answer:

> Since `10 / 2` is a valid integer division, Java produces `5` and continues normal execution. No `ArithmeticException` occurs.

If they ask:

### ❓ What happens with `10 / 0`?

Answer:

> For integer division, Java throws an `ArithmeticException` because division by zero is not permitted. The normal execution flow is interrupted unless the exception is appropriately handled.

---

# 3️⃣6️⃣ Final `/eli5` Understanding 🎯

Think of a Java program as a person following instructions:

```text
START
  ↓
Get first number
  ↓
Get second number
  ↓
Divide
  ↓
Get result
  ↓
Print result
  ↓
END
```

If everything goes correctly:

```text
✅ Normal Execution
```

Example:

```text
10 ÷ 2
   ↓
5
   ↓
Program Ends
```

If something unexpected happens:

```text
10 ÷ 0
   ↓
❌ Problem
   ↓
ArithmeticException
   ↓
Normal flow interrupted
```

### ⭐ The most important thing to remember

> **An exception is a disruption to the normal flow of a program. If no exception occurs, Java continues executing the statements normally until the program reaches its end.**
