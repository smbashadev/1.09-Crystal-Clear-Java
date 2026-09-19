# 🧒 3.5 Java Program Using `try-catch`

# 1️⃣ Start From ZERO

Suppose we want to create an array:

```java
int[] a = new int[5];
```

This is valid:

```text
Array size = 5
      ↓
Array created
```

But what if:

```java
int[] a = new int[-5];
```

Java cannot create an array with a negative size.

So an exception occurs:

```text
Negative size
     ↓
NegativeArraySizeException
```

---

# 2️⃣ What Is Happening?

Without `try-catch`:

```text
Array creation
      ↓
NegativeArraySizeException
      ↓
Uncaught exception
      ↓
Program terminates
```

With `try-catch`:

```text
Array creation
      ↓
NegativeArraySizeException
      ↓
catch(Exception e)
      ↓
Exception handled
      ↓
Program Ends
```

---

# 3️⃣ Real-World Analogy 🧒

Imagine you ask someone:

> "Please give me a box with **-5 items**."

That's impossible.

The person says:

> "That's not possible. Here's the problem."

Instead of the entire process stopping, you deal with the problem and finish properly.

Java works similarly:

```text
Invalid array size
       ↓
Exception
       ↓
Catch it
       ↓
Display problem
       ↓
Program Ends
```

---

# 4️⃣ Simple Definition

> **This program demonstrates how `try-catch` handles `NegativeArraySizeException` produced while creating an array with a negative size.**

---

# 5️⃣ Basic Syntax

```java
try {
    int[] a = new int[-5];
}
catch (Exception e) {
    System.out.println(e.getMessage());
}
```

Here:

```text
try
 ↓
Array creation
 ↓
Exception
 ↓
catch(Exception e)
 ↓
Handle exception
```

---

# 6️⃣ Complete Program

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Program Starts");

        try {

            int[] a = new int[-5];

        }
        catch (Exception e) {

            System.out.println(e.getMessage());
        }

        System.out.println("Program Ends");
    }
}
```

---

# 7️⃣ Output

The exact message can be JVM-dependent, but it will indicate the negative array size, for example:

```text
Program Starts
-5
Program Ends
```

The important point is:

```text
Program Ends
```

is reached because the exception was handled.

---

# 8️⃣ Execution Flow

```text
Program Starts
      ↓
try block
      ↓
new int[-5]
      ↓
NegativeArraySizeException
      ↓
Exception object created
      ↓
catch(Exception e)
      ↓
e refers to exception object
      ↓
e.getMessage()
      ↓
Exception message printed
      ↓
Program Ends
```

---

# 9️⃣ Line-by-Line Explanation

### Program starts

```java
System.out.println("Program Starts");
```

Output:

```text
Program Starts
```

---

### Enter `try`

```java
try {
```

Java starts executing the protected code.

---

### Array creation

```java
int[] a = new int[-5];
```

Java attempts to create an array of size `-5`.

That is invalid.

Therefore:

```text
NegativeArraySizeException
```

occurs.

---

### `catch`

```java
catch (Exception e)
```

The `catch` block handles the exception.

Here:

```text
Exception
```

is the superclass type being used as the handler parameter.

And:

```text
e
```

refers to the exception object.

---

### Exception message

```java
System.out.println(e.getMessage());
```

`getMessage()` obtains the message associated with the exception.

---

### Program ends

```java
System.out.println("Program Ends");
```

After the exception is handled, execution proceeds after the `try-catch`.

Therefore:

```text
Program Ends
```

is printed.

---

# 🔟 What Is `NegativeArraySizeException`?

It is the exception associated with attempting to create an array with a negative size.

Example:

```java
int[] numbers = new int[-10];
```

Conceptually:

```text
-10
 ↓
Invalid array size
 ↓
NegativeArraySizeException
```

---

# 1️⃣1️⃣ Why Does `catch(Exception e)` Work?

Your program uses:

```java
catch (Exception e)
```

`NegativeArraySizeException` is an exception type under Java's exception hierarchy.

Conceptually:

```text
Throwable
   ↓
Exception
   ↓
RuntimeException
   ↓
NegativeArraySizeException
```

Therefore a handler for `Exception` can handle this exception.

```java
catch (Exception e)
```

means, broadly:

> "Catch an exception belonging to the `Exception` hierarchy."

---

# 1️⃣2️⃣ What Does `e` Mean?

In:

```java
catch (Exception e)
```

there are two parts:

```text
Exception → type
e         → reference variable
```

The `e` variable refers to the thrown exception object.

So:

```java
e.getMessage()
```

means:

> Get the message from the exception object.

---

# 1️⃣3️⃣ What Does `getMessage()` Do?

Consider:

```java
System.out.println(e.getMessage());
```

It retrieves the exception's detail message.

For example, depending on the Java runtime, you might see:

```text
-5
```

The exact representation should not be assumed to be identical on every JVM.

The important concept is:

```text
Exception object
       ↓
getMessage()
       ↓
Exception message
```

---

# 1️⃣4️⃣ Visual Understanding

```text
             try
              ↓
       Create array
              ↓
        new int[-5]
              ↓
   NegativeArraySizeException
              ↓
      catch(Exception e)
              ↓
       e = exception object
              ↓
       e.getMessage()
              ↓
       Print message
              ↓
        Program Ends
```

---

# 1️⃣5️⃣ Important Concept

The exception does **not** mean the program has to terminate immediately.

Because we have:

```java
catch (Exception e)
```

the exception is handled.

Therefore:

```text
Exception
   ↓
Handled
   ↓
Program continues
```

---

# 1️⃣6️⃣ Without `try-catch`

Compare:

```java
class Demo {

    public static void main(String[] args) {

        int[] a = new int[-5];

        System.out.println("Program Ends");
    }
}
```

Flow:

```text
new int[-5]
      ↓
NegativeArraySizeException
      ↓
No suitable handler
      ↓
Uncaught exception
      ↓
Thread terminates
```

So:

```text
Program Ends
```

is not reached.

---

# 1️⃣7️⃣ With `try-catch`

```java
class Demo {

    public static void main(String[] args) {

        try {
            int[] a = new int[-5];
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Program Ends");
    }
}
```

Flow:

```text
new int[-5]
      ↓
NegativeArraySizeException
      ↓
catch(Exception e)
      ↓
Handled
      ↓
Message printed
      ↓
Program Ends
```

---

# 1️⃣8️⃣ Comparison

| Without `try-catch`        | With `try-catch`       |
| -------------------------- | ---------------------- |
| Negative size              | Negative size          |
| Exception occurs           | Exception occurs       |
| No handler                 | Handler available      |
| Exception remains uncaught | Exception handled      |
| `Program Ends` not reached | `Program Ends` reached |

---

# 1️⃣9️⃣ Connection With Previous Topics

### 3.2 Runtime System

We learned:

```text
Exception
 ↓
Exception object
 ↓
Runtime handling
 ↓
Search for handler
```

### 3.3 Exception Handling

We learned:

```text
Exception
 ↓
Handle exception
 ↓
Prevent uncontrolled termination
```

### 3.4 `try-catch`

We learned:

```text
try
 ↓
Risky code
 ↓
catch
 ↓
Handler
```

### 3.5 This Program

Now we combine everything:

```text
Array creation
      ↓
NegativeArraySizeException
      ↓
Exception object
      ↓
Runtime handling
      ↓
catch(Exception e)
      ↓
e.getMessage()
      ↓
Program Ends
```

---

# 2️⃣0️⃣ Runtime Understanding

The exception happens while the program is executing:

```java
int[] a = new int[-5];
```

Therefore:

```text
Runtime
   ↓
Array creation attempted
   ↓
Invalid size detected
   ↓
NegativeArraySizeException
```

Then the handler deals with it.

---

# 2️⃣1️⃣ Behind-the-Scenes Explanation

Conceptually:

```text
JVM executes:
        ↓
new int[-5]
        ↓
Invalid size
        ↓
NegativeArraySizeException created
        ↓
Runtime searches for handler
        ↓
catch(Exception e) found
        ↓
e references exception object
        ↓
getMessage()
        ↓
Message displayed
```

---

# 2️⃣2️⃣ Important Technical Point

`catch(Exception e)` is a **broad/general handler**.

It can handle many exception types that derive from `Exception`.

For a specific exception, you can instead write:

```java
catch (NegativeArraySizeException e) {
    System.out.println(e.getMessage());
}
```

This is more specific.

Your program uses:

```java
catch (Exception e)
```

to demonstrate general exception handling.

---

# 2️⃣3️⃣ Common Confusion

### ❌ "`Exception e` means an exception named `e`."

No.

```java
Exception e
```

means:

```text
Exception → data type
e         → reference variable
```

Similar to:

```java
Scanner sc;
```

where:

```text
Scanner → type
sc      → reference variable
```

---

# 2️⃣4️⃣ Another Common Confusion

### ❌ "`getMessage()` creates the exception."

No.

The exception has already occurred.

```text
Exception occurs
      ↓
Exception object
      ↓
e references object
      ↓
e.getMessage()
```

`getMessage()` retrieves the message associated with that object.

---

# 2️⃣5️⃣ Exception Flow

### Complete flow:

```text
Program Starts
      ↓
try block
      ↓
Array creation
      ↓
NegativeArraySizeException
      ↓
Exception object
      ↓
catch(Exception e)
      ↓
e refers to exception object
      ↓
e.getMessage()
      ↓
Message printed
      ↓
Program Ends
```

---

# 2️⃣6️⃣ Hierarchy / Relationship

The relevant exception hierarchy is:

```text
Throwable
   │
   └── Exception
          │
          └── RuntimeException
                 │
                 └── NegativeArraySizeException
```

Therefore:

```java
catch (Exception e)
```

can catch:

```text
NegativeArraySizeException
```

because it is below `Exception` in the hierarchy.

---

# 2️⃣7️⃣ Why Is `catch(Exception e)` Used?

Because it provides a general handler.

Think:

```text
catch(NegativeArraySizeException e)
```

means:

> "I specifically want to handle this exception."

Whereas:

```text
catch(Exception e)
```

means:

> "Handle exceptions covered by the `Exception` hierarchy."

For learning the fundamentals, `catch(Exception e)` is useful for demonstrating general exception handling.

---

# 2️⃣8️⃣ Important Rules

Remember:

1. Array size cannot be negative.
2. Attempting to create an array with a negative size causes `NegativeArraySizeException`.
3. The exception occurs during execution.
4. The exception is represented by an exception object.
5. `catch(Exception e)` can handle this exception.
6. `Exception` is the type of the catch parameter.
7. `e` is a reference to the exception object.
8. `e.getMessage()` retrieves the exception's detail message.
9. Once the exception is handled, execution can continue after the `try-catch`.
10. Therefore `Program Ends` can execute.
11. Without a suitable handler, the exception can remain uncaught and terminate the affected thread.
12. `catch(Exception e)` is more general than catching `NegativeArraySizeException` directly.

---

# 2️⃣9️⃣ Memory Trick 🧠

Remember:

## **NEGATIVE → EXCEPTION → CATCH → MESSAGE → END**

```text
Negative array size
       ↓
NegativeArraySizeException
       ↓
catch(Exception e)
       ↓
e.getMessage()
       ↓
Program Ends
```

---

# 3️⃣0️⃣ Interview Question

### ❓ What exception occurs when an array is created with a negative size?

**Answer:**

> `NegativeArraySizeException` occurs when Java attempts to create an array with a negative size.

Example:

```java
int[] a = new int[-5];
```

---

# 3️⃣1️⃣ Interview Question

### ❓ What does `catch(Exception e)` mean?

**Answer:**

> It declares a general exception handler whose parameter has type `Exception`. The variable `e` refers to the exception object that was thrown.

---

# 3️⃣2️⃣ Interview Question

### ❓ What does `e.getMessage()` do?

**Answer:**

> `e.getMessage()` retrieves the detail message associated with the exception object. The exact message format depends on the particular exception and Java runtime.

---

# 3️⃣3️⃣ Complete Program

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Program Starts");

        try {

            int[] numbers = new int[-5];

            System.out.println("Array Created");

        }
        catch (Exception e) {

            System.out.println("Exception Message: "
                    + e.getMessage());
        }

        System.out.println("Program Ends");
    }
}
```

### Flow:

```text
Program Starts
      ↓
try
      ↓
new int[-5]
      ↓
NegativeArraySizeException
      ↓
catch(Exception e)
      ↓
e.getMessage()
      ↓
Exception message
      ↓
Program Ends
```

---

# 3️⃣4️⃣ Your Notes Mapped Directly

### **Array creation**

```java
int[] numbers = new int[-5];
```

Java attempts to create the array.

---

### **NegativeArraySizeException**

Because:

```text
Array size = -5
```

the operation produces:

```text
NegativeArraySizeException
```

---

### **catch(Exception e)**

```java
catch (Exception e)
```

acts as the exception handler.

```text
Exception → type
e → reference to exception object
```

---

### **Exception message**

```java
System.out.println(e.getMessage());
```

retrieves and prints the exception's detail message.

---

### **Program Ends**

```java
System.out.println("Program Ends");
```

executes after the exception has been handled.

---

# 3️⃣5️⃣ Super-Simple Mental Model 🧒

Imagine you order:

> "Create a box with **-5 items**."

The system says:

```text
Impossible!
```

Instead of crashing the entire process:

```text
Problem
 ↓
Catch the problem
 ↓
Tell user what happened
 ↓
Finish the process
```

Java:

```text
new int[-5]
      ↓
NegativeArraySizeException
      ↓
catch(Exception e)
      ↓
e.getMessage()
      ↓
Program Ends
```

---

# 3️⃣6️⃣ Final `/eli5` Understanding 🎯

This program demonstrates the complete basic `try-catch` flow:

```text
                PROGRAM
                   ↓
             Program Starts
                   ↓
                 try
                   ↓
           Create array with -5
                   ↓
       NegativeArraySizeException
                   ↓
           Exception object
                   ↓
          catch(Exception e)
                   ↓
          e = exception object
                   ↓
            e.getMessage()
                   ↓
          Message is displayed
                   ↓
             Program Ends
```

### ⭐ One-line memory:

> **Negative array size → `NegativeArraySizeException` → `catch(Exception e)` catches it → `getMessage()` displays the message → `Program Ends`.**
