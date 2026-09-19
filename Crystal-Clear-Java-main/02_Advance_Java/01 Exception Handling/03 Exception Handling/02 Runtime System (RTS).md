# 🧒 3.2 Runtime System (RTS)

# 1️⃣ Start From ZERO

First, understand one simple thing:

When Java is running your program, sometimes something unexpected happens.

For example:

```java
int a = 10;
int b = 0;

int result = a / b;
```

Java reaches:

```text
10 / 0
```

For integer division, this causes:

```text
ArithmeticException
```

At that moment, Java needs to decide:

> **"Who is going to handle this exception?"**

This is where the **Runtime System (RTS)** becomes important.

---

# 2️⃣ What Is Runtime System (RTS)?

In simple words:

> **Runtime System is the part of the Java execution environment that manages what happens while the program is running, including the process of handling exceptions.**

For your exception topic, think of RTS as a **manager**.

```text
Exception occurs
       ↓
RTS
       ↓
"Let me find someone who can handle this."
```

---

# 3️⃣ Real-World Analogy 🧒

Imagine an employee is working in a company.

Suddenly, the employee faces a problem.

The employee reports:

```text
Problem
  ↓
Manager
```

The manager checks:

> "Does this employee's team have someone who can solve this?"

If yes:

```text
Manager
   ↓
Responsible person
   ↓
Problem solved
```

If no:

```text
Manager
   ↓
Higher authority
```

Similarly:

```text
Exception
   ↓
Runtime System
   ↓
Search for handler
```

---

# 4️⃣ Simple Definition

### Runtime System — ELI5 Definition

> **RTS is involved at runtime when an exception occurs and searches for an appropriate exception handler.**

In your notes:

```text
Exception
   ↓
Exception Object
   ↓
Runtime System
   ↓
Exception Handler
```

---

# 5️⃣ Basic Structure

The basic exception flow is:

```text
try
 ↓
Statement
 ↓
Exception occurs
 ↓
Exception object
 ↓
Runtime System
 ↓
Search handler
 ↓
catch
```

If there is no handler:

```text
Runtime System
      ↓
No handler
      ↓
Default Exception Handler
```

---

# 6️⃣ Simple Program

Let's use a very simple example:

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Program Starts");

        try {

            int a = 10;
            int b = 0;

            int result = a / b;

            System.out.println("Result = " + result);
        }
        catch (ArithmeticException e) {

            System.out.println("Cannot divide by zero");
        }

        System.out.println("Program Ends");
    }
}
```

---

# 7️⃣ Output

Output:

```text
Program Starts
Cannot divide by zero
Program Ends
```

Notice something important:

```text
Program Ends
```

is printed.

Why?

Because the exception was handled by the `catch` block.

---

# 8️⃣ Execution Flow

Let's follow it:

```text
Program Starts
      ↓
a = 10
      ↓
b = 0
      ↓
10 / 0
      ↓
ArithmeticException occurs
      ↓
Exception object created
      ↓
Object handed to Runtime System
      ↓
RTS checks for handler
      ↓
ArithmeticException handler found
      ↓
Exception object given to catch
      ↓
catch executes
      ↓
Remaining program executes
      ↓
Program Ends
```

---

# 9️⃣ Line-by-Line Explanation

### Line 1

```java
class Demo {
```

Creates the `Demo` class.

---

### Line 2

```java
public static void main(String[] args) {
```

Program execution starts from `main()`.

---

### Line 3

```java
System.out.println("Program Starts");
```

Prints:

```text
Program Starts
```

---

### Inside `try`

```java
int a = 10;
int b = 0;
```

Values become:

```text
a = 10
b = 0
```

---

### Division

```java
int result = a / b;
```

Java attempts:

```text
10 / 0
```

This causes:

```text
ArithmeticException
```

---

### `catch`

```java
catch (ArithmeticException e)
```

This catch block is capable of handling the exception.

The exception object is assigned to:

```text
e
```

---

### Remaining program

After the `catch` completes:

```java
System.out.println("Program Ends");
```

executes normally.

---

# 🔟 What Happens Internally?

At a high level:

```text
10 / 0
   ↓
Exception condition detected
   ↓
ArithmeticException object created
   ↓
Runtime System receives/handles the exception flow
   ↓
RTS looks for suitable handler
   ↓
catch (ArithmeticException e)
   ↓
Handler found
   ↓
Exception object supplied to catch parameter
```

This is the core idea in your notes.

---

# 1️⃣1️⃣ Why Is an Exception Object Created?

Java needs an object to represent the exceptional situation.

For example:

```text
ArithmeticException object
```

contains information associated with the exception.

Conceptually:

```text
Exception Object
      ↓
"What went wrong?"
      ↓
ArithmeticException
```

That object can then be passed to the handler.

---

# 1️⃣2️⃣ Step-by-Step RTS Flow

Your seven steps can be visualized like this:

```text
1. Exception occurs
        ↓
2. Exception object created
        ↓
3. Object handed to Runtime System
        ↓
4. RTS goes to method that threw exception
        ↓
5. RTS checks for handler
        ↓
     ┌───────────────┐
     │ Handler found?│
     └───────────────┘
       ↓           ↓
      YES          NO
       ↓           ↓
6. Object       Default
   given to      Exception
   catch         Handler
       ↓
7. Remaining program
   executes normally
```

---

# 1️⃣3️⃣ Visual Understanding

Think of RTS as a **traffic controller**.

```text
                 Exception
                     ↓
              Exception Object
                     ↓
                    RTS
                     ↓
             Check the method
                     ↓
             Search for handler
                  /      \
                YES       NO
                 ↓         ↓
               catch    Default
                 ↓       Handler
                 ↓
          Remaining code
              executes
```

---

# 1️⃣4️⃣ Important Concept

The most important point is:

> **RTS doesn't simply stop at the moment an exception occurs. It participates in finding the appropriate handler.**

So:

```text
Exception occurs
      ≠
Immediately stop everything
```

Instead:

```text
Exception occurs
      ↓
Search for handler
      ↓
Handler found?
```

If found:

```text
catch
 ↓
handle exception
 ↓
continue according to exception-handling flow
```

---

# 1️⃣5️⃣ Valid Example

This is a valid exception-handling program:

```java
try {
    int result = 10 / 0;
}
catch (ArithmeticException e) {
    System.out.println("Handled");
}
```

Flow:

```text
Exception
   ↓
RTS
   ↓
Handler found
   ↓
catch
   ↓
Handled
```

---

# 1️⃣6️⃣ Invalid / No-Handler Example

Consider:

```java
class Demo {

    public static void main(String[] args) {

        int result = 10 / 0;

        System.out.println("Program Ends");
    }
}
```

There is no suitable `catch`.

So:

```text
Exception
   ↓
RTS
   ↓
No handler found
   ↓
Default uncaught-exception handling
   ↓
main thread terminates
```

The `"Program Ends"` statement is not reached.

---

# 1️⃣7️⃣ Comparison

| Handler Exists              | Handler Doesn't Exist                       |
| --------------------------- | ------------------------------------------- |
| Exception occurs            | Exception occurs                            |
| Exception object created    | Exception object created                    |
| RTS searches for handler    | RTS searches for handler                    |
| Handler found               | No handler found                            |
| Object given to `catch`     | Goes to default uncaught-exception handling |
| Exception handled           | Exception remains uncaught                  |
| Remaining flow can continue | Affected thread terminates                  |

---

# 1️⃣8️⃣ Connection With Previous Topic

Previously we learned:

### 3.1 Negative Array Size

```java
int[] numbers = new int[-5];
```

causes:

```text
NegativeArraySizeException
```

Now we are asking:

> **What happens after the exception occurs?**

The flow becomes:

```text
Negative array size
       ↓
NegativeArraySizeException
       ↓
Exception object
       ↓
Runtime System
       ↓
Search for handler
```

So **3.2 explains the journey of the exception after it occurs.**

---

# 1️⃣9️⃣ Runtime Understanding

Why is RTS involved?

Because the problem happens while the program is **running**.

Example:

```java
int size = sc.nextInt();

int[] numbers = new int[size];
```

The value might be:

```text
5
```

or:

```text
-5
```

The actual situation is determined during execution.

Therefore:

```text
Run program
    ↓
Exception occurs
    ↓
Runtime System
    ↓
Handler search
```

---

# 2️⃣0️⃣ Behind-the-Scenes Explanation

Consider:

```java
try {
    int x = 10 / 0;
}
catch (ArithmeticException e) {
    System.out.println("Handled");
}
```

Conceptually:

```text
JVM executes bytecode
       ↓
Division instruction
       ↓
Exceptional condition detected
       ↓
ArithmeticException created/thrown
       ↓
Exception handling machinery searches
       ↓
Matching catch found
       ↓
Catch executes
```

This is why exception handling is primarily a **runtime process**.

---

# 2️⃣1️⃣ Important Technical Point

One correction to keep in mind for precise Java terminology:

The **Runtime System is not a Java class named `RTS`** that you instantiate.

You don't write:

```java
RTS r = new RTS();
```

Instead, `RTS` in your notes refers to the **runtime environment/mechanism involved in executing the program and processing the exception**.

Think:

```text
RTS = Runtime System
```

not:

```text
RTS = a class we create
```

---

# 2️⃣2️⃣ Common Confusion

### ❓ Does the exception object go directly to `catch`?

Conceptually, your notes describe:

```text
Exception
 ↓
Exception object
 ↓
Runtime System
 ↓
Handler search
 ↓
catch
```

So don't think that the program directly jumps blindly into every `catch`.

The runtime determines whether a handler is appropriate.

---

# 2️⃣3️⃣ Another Common Confusion

### ❓ Does `catch` execute for every exception?

No.

The `catch` must be capable of handling the thrown exception.

For example:

```java
catch (ArithmeticException e)
```

can handle an `ArithmeticException`.

But an unrelated exception type may require a different handler.

Conceptually:

```text
Exception type
      ↓
Find compatible handler
      ↓
Matching handler
```

---

# 2️⃣4️⃣ Exception Flow

### Handler exists

```text
Exception occurs
      ↓
Object created
      ↓
RTS
      ↓
Handler search
      ↓
Handler found
      ↓
Object → catch
      ↓
Catch executes
      ↓
Remaining program executes
```

### Handler absent

```text
Exception occurs
      ↓
Object created
      ↓
RTS
      ↓
Handler search
      ↓
No handler
      ↓
Default uncaught-exception handling
      ↓
Affected thread terminates
```

---

# 2️⃣5️⃣ Hierarchy / Relationship

For this topic, remember the relationship:

```text
Exception
    ↓
Exception Object
    ↓
Runtime System
    ↓
Exception Handler
    ↓
catch block
```

For an example:

```text
ArithmeticException
       ↓
ArithmeticException object
       ↓
Runtime handling
       ↓
catch (ArithmeticException e)
```

---

# 2️⃣6️⃣ Why Is It Called Runtime System?

Break the name apart:

```text
Runtime + System
```

### Runtime

Means:

> While the program is executing.

### System

Means:

> The execution environment and mechanisms responsible for running the program.

Therefore:

> **Runtime System = mechanisms involved while the Java program is executing.**

For exceptions, it participates in exception propagation and handler selection.

---

# 2️⃣7️⃣ Important Rules

Remember these:

1. Exceptions occur during program execution.
2. Java represents an exception using an exception object.
3. The runtime system participates in processing the exception.
4. The runtime searches for an appropriate exception handler.
5. The search begins in the method where the exception occurs.
6. If an appropriate handler is found, the exception object is supplied to the handler.
7. The `catch` block handles the exception.
8. If no suitable handler is found, the exception remains uncaught.
9. An uncaught exception reaches the default uncaught-exception handling mechanism.
10. An uncaught exception causes the affected thread to terminate.
11. In a simple application, an uncaught exception in `main` causes the program to terminate.
12. `RTS` is a conceptual term here, not a class that you create.

---

# 2️⃣8️⃣ Memory Trick 🧠

Remember:

## **O → R → C → D**

```text
O = Object created
R = Runtime System
C = Check for handler
D = Default handler if absent
```

Or remember your exact seven-step chain:

```text
Exception
   ↓
Object
   ↓
RTS
   ↓
Method
   ↓
Handler?
 ↙       ↘
YES       NO
 ↓         ↓
catch    Default
 ↓
Continue
```

---

# 2️⃣9️⃣ Interview Question

### ❓ What happens when an exception occurs in Java?

**Answer:**

> When an exception occurs, Java creates an exception object and the runtime exception-handling mechanism searches for an appropriate handler. If a suitable handler is found, the exception object is passed to the `catch` block; otherwise, the exception remains uncaught and default uncaught-exception handling occurs.

---

# 3️⃣0️⃣ Interview Question

### ❓ What is the role of the Runtime System in exception handling?

**Answer:**

> The Runtime System participates in exception processing by locating the method where the exception occurred and searching for an appropriate exception handler. If a matching handler is found, the exception object is passed to it.

---

# 3️⃣1️⃣ Interview Question

### ❓ What happens if the Runtime System doesn't find an exception handler?

**Answer:**

> The exception continues to propagate through the call stack. If no suitable handler is found, it becomes uncaught and Java's default uncaught-exception handling reports it, after which the affected thread terminates.

---

# 3️⃣2️⃣ Interview Question

### ❓ Why can the remaining program execute after an exception?

**Answer:**

> If a suitable `catch` block handles the exception, execution can continue after the exception-handling construct according to Java's control-flow rules. The exception does not remain uncaught.

Example:

```java
try {
    int x = 10 / 0;
}
catch (ArithmeticException e) {
    System.out.println("Handled");
}

System.out.println("Program Continues");
```

Output:

```text
Handled
Program Continues
```

---

# 3️⃣3️⃣ Complete Example

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Program Starts");

        try {

            int a = 10;
            int b = 0;

            System.out.println("Before Division");

            int result = a / b;

            System.out.println("Result = " + result);
        }
        catch (ArithmeticException e) {

            System.out.println("Exception Handled");
        }

        System.out.println("Remaining Program Executes");

        System.out.println("Program Ends");
    }
}
```

### Flow

```text
Program Starts
      ↓
Before Division
      ↓
10 / 0
      ↓
ArithmeticException object
      ↓
Runtime System
      ↓
Search handler
      ↓
catch found
      ↓
Exception Handled
      ↓
Remaining Program Executes
      ↓
Program Ends
```

---

# 3️⃣4️⃣ Your Notes Mapped Directly

Your first point:

### **1. Exception object is created**

```text
Exception occurs
      ↓
Exception object created
```

Example:

```text
ArithmeticException object
```

---

### **2. Object is handed to Runtime System**

```text
Exception object
      ↓
Runtime System
```

The runtime exception-handling mechanism takes over the handling process.

---

### **3. RTS goes to method that threw exception**

The runtime begins exception-handler searching from the method where the exception occurred.

```text
method()
   ↓
Exception
   ↓
Start handler search
```

---

### **4. RTS checks for exception handler**

It checks whether there is an appropriate handler.

```text
Handler available?
```

---

### **5. If handler is absent**

```text
No suitable handler
      ↓
Exception propagates
      ↓
Eventually default uncaught-exception handling
```

---

### **6. If handler exists**

```text
Handler found
      ↓
Exception object
      ↓
catch parameter
```

Example:

```java
catch (ArithmeticException e)
```

Here:

```text
e
↓
reference to the thrown exception object
```

---

### **7. Remaining program executes normally**

After the exception is handled:

```text
catch
 ↓
exception handled
 ↓
execution continues after try-catch
```

Example:

```java
System.out.println("Program Ends");
```

can then execute.

---

# 3️⃣5️⃣ Super-Simple Mental Model 🧒

Imagine a school.

A student has a problem:

```text
Student
   ↓
Problem
```

The student goes to the class teacher:

```text
Problem
   ↓
Teacher
```

Teacher checks:

> "Can I handle this?"

### YES:

```text
Teacher
   ↓
Handles problem
   ↓
Student continues
```

### NO:

```text
Teacher
   ↓
Higher authority
```

Java works similarly:

```text
Exception
   ↓
Exception Object
   ↓
Runtime System
   ↓
Check handler
   ↓
     ┌───────────┐
     │           │
    YES          NO
     ↓           ↓
   catch      Propagate
     ↓           ↓
 Handle       Default
     ↓         Handler
 Continue        ↓
              Thread
             terminates
```

---

# 3️⃣6️⃣ Final `/eli5` Understanding 🎯

When an exception happens, Java doesn't simply say:

> **"Stop!"**

Instead, think of it as a problem being reported to a manager:

```text
Exception occurs
       ↓
Exception object created
       ↓
Runtime System receives the exception-handling task
       ↓
RTS starts from the method where the exception occurred
       ↓
RTS searches for a suitable handler
       ↓
       ┌──────────────┐
       │ Handler found│
       └──────┬───────┘
          YES│     NO
             ↓       ↓
          catch    Propagate
             ↓       ↓
       Exception     No handler
       handled          ↓
             ↓       Default
       Remaining      handling
       program           ↓
       executes       Thread
       normally       terminates
```

### ⭐ Your complete 3.2 rule:

> **Exception occurs → Exception object is created → Runtime System processes it → RTS starts searching from the method where it occurred → suitable handler found → exception object is passed to `catch` → exception is handled → execution continues after the exception-handling construct. If no suitable handler is found, the exception propagates and eventually reaches the default uncaught-exception handling mechanism.**
