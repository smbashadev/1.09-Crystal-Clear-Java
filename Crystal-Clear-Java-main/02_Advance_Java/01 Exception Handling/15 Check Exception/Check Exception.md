# 🧒 15. Check Exception

## 15.1 `Thread.sleep()`

### 1. Basic Idea

`Thread.sleep(3000)` tells the currently running thread to **pause for 3000 milliseconds**.

```java
Thread.sleep(3000);
```

Here:

```text
Thread → currently executing thread
sleep  → temporarily pause execution
3000   → time in milliseconds
```

---

### 2. Understanding Milliseconds

Java measures the sleep time in **milliseconds**.

```text
1000 milliseconds = 1 second
3000 milliseconds = 3 seconds
```

Therefore:

```java
Thread.sleep(3000);
```

means:

> Pause the current thread for approximately **3 seconds**.

---

### 3. Simple Real-World Analogy

Imagine a person walking:

```text
Walk
 ↓
Stop for 3 seconds
 ↓
Walk again
```

`Thread.sleep(3000)` does something similar to the program:

```text
Program running
 ↓
Pause
 ↓
Approximately 3 seconds
 ↓
Continue
```

---

### 4. Why Does `Thread.sleep()` Produce an Exception?

`Thread.sleep()` can be interrupted while it is sleeping.

Java therefore requires the programmer to deal with:

```text
InterruptedException
```

`InterruptedException` is a **checked exception**.

---

### 5. What Is a Checked Exception?

A checked exception is an exception that Java requires the programmer to **handle or declare** before the program can compile.

For example:

```java
Thread.sleep(3000);
```

cannot simply be written without dealing with its checked exception.

Java compiler warns us that:

```text
InterruptedException
```

must be handled or declared.

---

### 6. Simple Structure

```java
try {

    Thread.sleep(3000);

}
catch (InterruptedException e) {

    // handle exception

}
```

Here:

```text
try     → contains Thread.sleep()
catch   → handles InterruptedException
```

---

## 15.2 Handling Checked Exception

### 7. Using `try-catch`

The easiest way to handle `InterruptedException` is:

```java
try {

    Thread.sleep(3000);

}
catch (InterruptedException e) {

    System.out.println(e);

}
```

The `try` block contains the statement that may produce the checked exception.

The `catch` block handles it.

---

### 8. Understanding `InterruptedException`

The name itself gives us an idea:

```text
Interrupted
     +
Exception
```

It represents an interruption of a sleeping/waiting thread.

For this topic, remember:

```text
Thread.sleep()
      ↓
InterruptedException
      ↓
Checked Exception
```

---

### 9. Why Is `try-catch` Needed?

Suppose we write:

```java
Thread.sleep(3000);
```

without handling the checked exception.

Java's compiler does not allow the program to compile normally because the checked exception has not been handled or declared.

So we write:

```java
try {

    Thread.sleep(3000);

}
catch (InterruptedException e) {

    // handling

}
```

Now the checked exception is handled.

---

### 10. The `catch` Statement

The important line is:

```java
catch (InterruptedException e)
```

It has two important parts:

```text
InterruptedException → exception type
e                   → reference to exception object
```

So Java is being told:

> If an `InterruptedException` occurs, execute this `catch` block.

---

### 11. Exception Message

Inside the catch block we can print information about the exception.

```java
catch (InterruptedException e) {

    System.out.println(e.getMessage());

}
```

`e` refers to the exception object.

`getMessage()` obtains the message associated with that exception.

---

### 12. Loop From 1 to 5

Now combine exception handling with a loop:

```java
for (int i = 1; i <= 5; i++) {

    System.out.println(i);

    Thread.sleep(3000);
}
```

The loop starts at:

```text
1
```

and continues through:

```text
5
```

---

### 13. Understanding the `for` Loop

The loop has three parts:

```java
for (int i = 1; i <= 5; i++)
```

**Initialization:**

```java
int i = 1;
```

The counter starts at `1`.

**Condition:**

```java
i <= 5
```

The loop continues while `i` is less than or equal to `5`.

**Increment:**

```java
i++
```

After each iteration, `i` increases by `1`.

---

### 14. Loop Values

The values of `i` are:

```text
1
2
3
4
5
```

After `i` becomes:

```text
6
```

the condition:

```java
i <= 5
```

becomes false.

The loop stops.

---

### 15. Complete Program

```java
class Demo {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            System.out.println(i);

            try {

                Thread.sleep(3000);

            }
            catch (InterruptedException e) {

                System.out.println(e.getMessage());

            }

        }

    }
}
```

---

### 16. What Happens First?

The program enters:

```java
for (int i = 1; i <= 5; i++)
```

Initially:

```text
i = 1
```

Then:

```java
System.out.println(i);
```

prints:

```text
1
```

---

### 17. What Happens After Printing `1`?

The program executes:

```java
Thread.sleep(3000);
```

The current thread pauses for approximately:

```text
3 seconds
```

Then execution continues.

---

### 18. Second Iteration

After the first iteration:

```java
i++
```

changes:

```text
i = 1
```

to:

```text
i = 2
```

The condition is checked:

```java
2 <= 5
```

This is true.

So:

```text
2
```

is printed.

Then the thread sleeps again.

---

### 19. Complete Loop Flow

```text
i = 1
 ↓
Print 1
 ↓
Sleep 3 seconds
 ↓
i++
 ↓
i = 2
 ↓
Print 2
 ↓
Sleep 3 seconds
 ↓
i++
 ↓
i = 3
 ↓
Print 3
 ↓
Sleep 3 seconds
 ↓
i++
 ↓
i = 4
 ↓
Print 4
 ↓
Sleep 3 seconds
 ↓
i++
 ↓
i = 5
 ↓
Print 5
 ↓
Sleep 3 seconds
 ↓
i++
 ↓
i = 6
 ↓
Condition false
 ↓
Loop ends
```

---

### 20. Why Does `catch` Come Inside the Loop?

In this example:

```java
for (int i = 1; i <= 5; i++) {

    try {

        Thread.sleep(3000);

    }
    catch (InterruptedException e) {

        System.out.println(e.getMessage());

    }

}
```

Each execution of:

```java
Thread.sleep(3000);
```

is protected by the `try-catch`.

So every iteration has exception handling available for the `sleep()` operation.

---

### 21. Output

Under normal execution, the output is:

```text
1
2
3
4
5
```

There is approximately a **3-second pause between each printed number**.

---

## 15.3 Output

### 22. First Output

The first iteration starts with:

```text
i = 1
```

Output:

```text
1
```

Then the thread sleeps for approximately 3 seconds.

---

### 23. Second Output

The second iteration changes:

```text
i = 1 → i = 2
```

Output:

```text
2
```

Then the thread sleeps again.

---

### 24. Third Output

The third iteration:

```text
i = 3
```

Output:

```text
3
```

Again, the thread sleeps.

---

### 25. Fourth Output

The fourth iteration:

```text
i = 4
```

Output:

```text
4
```

Then the thread sleeps.

---

### 26. Fifth Output

The fifth iteration:

```text
i = 5
```

Output:

```text
5
```

Then the loop finishes.

---

### 27. Final Output

Therefore, the visible output is:

```text
1
2
3
4
5
```

The important difference is the **time gap** between the numbers.

Approximately:

```text
1
   ↓ 3 seconds
2
   ↓ 3 seconds
3
   ↓ 3 seconds
4
   ↓ 3 seconds
5
```

---

### 28. Why Does the Program Not Print All Numbers Immediately?

Because:

```java
Thread.sleep(3000);
```

is executed after each number.

Without `sleep()`:

```text
1
2
3
4
5
```

would normally appear very quickly.

With `sleep(3000)`:

```text
1
↓
wait approximately 3 seconds
↓
2
↓
wait approximately 3 seconds
↓
3
```

---

### 29. Checked Exception Flow

The complete exception concept is:

```text
Thread.sleep(3000)
       ↓
May be interrupted
       ↓
InterruptedException
       ↓
Checked Exception
       ↓
Compiler requires handling/declaring it
       ↓
try-catch
       ↓
catch(InterruptedException e)
```

---

### 30. Important Difference From Earlier Exceptions

Earlier examples included exceptions such as:

```text
ArithmeticException
NegativeArraySizeException
ArrayIndexOutOfBoundsException
InputMismatchException
```

Here we are dealing with:

```text
InterruptedException
```

The important point for this topic is that `InterruptedException` is a **checked exception**.

---

### 31. Common Mistake

Do not write:

```java
try {

    Thread.sleep(3000);

}
catch (ArithmeticException e) {

}
```

This is not the appropriate handler for `InterruptedException`.

The expected handler is:

```java
catch (InterruptedException e)
```

---

### 32. Common Confusion About `3000`

Do not think:

```text
3000 = 3000 seconds
```

It means:

```text
3000 milliseconds
```

Therefore:

```text
3000 milliseconds ≈ 3 seconds
```

---

### 33. Common Confusion About `sleep()`

`Thread.sleep(3000)` does not mean:

> Stop the entire computer for 3 seconds.

It pauses the **currently executing thread**.

For this beginner example, you can remember:

```text
Current thread
      ↓
sleep
      ↓
approximately 3 seconds
      ↓
continue
```

---

### 34. Important Rules

* `Thread.sleep()` temporarily pauses the current thread.
* The argument is measured in milliseconds.
* `3000` milliseconds is approximately 3 seconds.
* `Thread.sleep()` can throw `InterruptedException`.
* `InterruptedException` is a checked exception.
* A checked exception must be handled or declared.
* `try-catch` is one way to handle it.
* `catch (InterruptedException e)` is used to handle this exception.
* `for` loop values in this example are `1` through `5`.
* `i++` increases the value of `i` by `1`.
* The condition `i <= 5` controls when the loop stops.

---

### 35. Memory Trick

Remember this chain:

```text
sleep()
   ↓
3000 milliseconds
   ↓
approximately 3 seconds
   ↓
InterruptedException
   ↓
Checked Exception
   ↓
try-catch
```

And remember the loop:

```text
1 → sleep → 2 → sleep → 3 → sleep → 4 → sleep → 5
```

---

### 36. Complete Lifetime Understanding

```text
                         main()
                           ↓
                     for loop starts
                           ↓
                        i = 1
                           ↓
                       print 1
                           ↓
                 Thread.sleep(3000)
                           ↓
              InterruptedException?
                    ↙            ↘
                  NO              YES
                   ↓                ↓
             Continue          catch handles
                   ↓                ↓
                   └───────┬────────┘
                           ↓
                          i++
                           ↓
                        i = 2
                           ↓
                       print 2
                           ↓
                 Thread.sleep(3000)
                           ↓
                          ...
                           ↓
                        i = 5
                           ↓
                       print 5
                           ↓
                       i++
                           ↓
                        i = 6
                           ↓
                      6 <= 5 ?
                           ↓
                          NO
                           ↓
                      Loop ends
                           ↓
                    Program completes
```

**Core memory rule:**

> **`Thread.sleep(3000)` pauses the current thread for approximately 3 seconds and can produce the checked `InterruptedException`, so Java requires the programmer to handle or declare that exception.**
