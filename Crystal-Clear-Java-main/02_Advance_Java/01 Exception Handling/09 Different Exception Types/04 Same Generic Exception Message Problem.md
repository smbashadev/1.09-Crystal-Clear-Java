# 🧒 9.4 Same Generic Exception Message Problem

## 1. What Is the Problem?

Suppose our Java program handles different types of exceptions.

For example:

```text
NegativeArraySizeException
ArrayIndexOutOfBoundsException
InputMismatchException
```

If we use the **same message** for every exception:

```text
Exception was handled
```

then the program tells us only that:

> "Some exception occurred and I handled it."

But it does **not tell us which exception actually occurred**.

---

## 2. Example of the Problem

Imagine we have:

```java
try {

    // Some risky code

}
catch (Exception e) {

    System.out.println("Exception was handled");

}
```

The `catch` block catches the exception using:

```java
Exception e
```

and prints:

```text
Exception was handled
```

No matter what exception occurs, the output can remain:

```text
Exception was handled
```

---

## 3. Different Exceptions, Same Message

Suppose the program produces:

```text
NegativeArraySizeException
```

Output:

```text
Exception was handled
```

Suppose another program produces:

```text
ArrayIndexOutOfBoundsException
```

Output:

```text
Exception was handled
```

Suppose another program produces:

```text
InputMismatchException
```

Output:

```text
Exception was handled
```

So we get:

```text
Exception 1 → Exception was handled
Exception 2 → Exception was handled
Exception 3 → Exception was handled
```

The message is the same.

---

# 🧒 4. Why Is This a Problem?

Imagine three students tell a teacher:

```text
Student 1 → I have a problem.
Student 2 → I have a problem.
Student 3 → I have a problem.
```

The teacher knows that there are problems, but does not know **what the problems are**.

Similarly:

```text
Exception was handled
```

only tells us:

```text
An exception occurred.
It was handled.
```

It does not tell us:

```text
Which exception?
Why did it happen?
Where did it happen?
```

---

# 🧒 5. What Information Do We Want?

Instead of only printing:

```text
Exception was handled
```

we may want information such as:

```text
NegativeArraySizeException
```

or:

```text
ArrayIndexOutOfBoundsException
```

or:

```text
InputMismatchException
```

This makes the program's output much more useful for understanding what happened.

---

# 🧒 6. Understanding `Exception e`

Consider:

```java
catch (Exception e)
```

There are two important parts:

```text
Exception
   ↓
Reference type

e
   ↓
Reference variable
```

`Exception` is the general exception class being used as the catch type.

`e` refers to the exception object that was caught.

Conceptually:

```text
Exception occurs
      ↓
Exception object created
      ↓
catch receives object
      ↓
e refers to that object
```

---

# 🧒 7. The Exception Object Contains Information

The caught exception object contains information about the exception.

For example:

```java
catch (Exception e)
```

The variable:

```text
e
```

can be used to obtain information about the exception.

One useful method is:

```java
e.getClass()
```

which can be used to identify the exception's class.

Another commonly used method is:

```java
e.getMessage()
```

which obtains the exception's message when one is available.

---

# 🧒 8. Identifying the Exception Type

Example:

```java
catch (Exception e) {

    System.out.println(e.getClass());

}
```

If an `InputMismatchException` occurs, the output identifies that exception class.

Conceptually:

```text
Exception occurs
      ↓
catch(Exception e)
      ↓
e refers to exception object
      ↓
e.getClass()
      ↓
Exception's class information
```

This is more informative than:

```text
Exception was handled
```

---

# 🧒 9. Generic Message vs Useful Information

### Generic message

```java
catch (Exception e) {

    System.out.println("Exception was handled");

}
```

Output:

```text
Exception was handled
```

### More informative approach

```java
catch (Exception e) {

    System.out.println(e.getClass());

}
```

Now the output can identify the actual exception class.

So:

```text
Generic message
      ↓
Little information

Exception information
      ↓
More useful information
```

---

# 🧒 10. Example With `InputMismatchException`

```java
import java.util.Scanner;

class Demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            int number = sc.nextInt();

            System.out.println(number);

        }
        catch (Exception e) {

            System.out.println("Exception was handled");

        }
    }
}
```

If the user enters:

```text
ten
```

the exception is handled.

But the output is only:

```text
Exception was handled
```

We don't immediately know from this message that the problem was:

```text
InputMismatchException
```

---

# 🧒 11. Improving the Information

We can instead inspect the caught exception:

```java
catch (Exception e) {

    System.out.println(e.getClass());

}
```

Now the program can tell us the actual exception class.

The basic flow becomes:

```text
Invalid input
      ↓
InputMismatchException
      ↓
Exception object
      ↓
catch(Exception e)
      ↓
e.getClass()
      ↓
Identify exception class
```

---

# 🧒 12. Why Generic Messages Are Not Enough

A message such as:

```text
Exception was handled
```

is useful only for knowing that the exception was handled.

It does not distinguish:

```text
NegativeArraySizeException
```

from:

```text
ArrayIndexOutOfBoundsException
```

or:

```text
InputMismatchException
```

Therefore, when learning, debugging, or diagnosing a program, identifying the actual exception is much more useful.

---

# 🧒 13. Real-Life Example

Imagine a doctor receives three patients.

Patient 1:

```text
Broken arm
```

Patient 2:

```text
Fever
```

Patient 3:

```text
Stomach problem
```

If the doctor writes for all three:

```text
Problem handled
```

the doctor knows the patients were treated, but the record does not explain what each patient had.

Similarly:

```text
Exception was handled
```

doesn't identify the specific exception.

---

# 🧒 14. The Main Idea

The problem in this topic is:

```text
Different exceptions
       ↓
Same catch
       ↓
Same generic message
       ↓
"Exception was handled"
```

The programmer loses useful information about **which exception actually occurred**.

---

# 🧒 15. Important Rules

### Rule 1

Different exceptions can produce the same generic output if the same message is printed from a common catch block.

### Rule 2

```java
catch (Exception e)
```

can catch many exception types because `Exception` is a general exception type.

### Rule 3

The variable:

```text
e
```

refers to the caught exception object.

### Rule 4

Printing only:

```text
Exception was handled
```

does not identify the actual exception type.

### Rule 5

The caught exception object can be inspected to obtain more information.

### Rule 6

`e.getClass()` can be used to identify the exception's class.

### Rule 7

`e.getMessage()` can provide the exception's message when one is available.

---

# 🧒 16. Lifetime Memory Summary

Remember the problem like this:

```text
Exception occurs
      ↓
catch(Exception e)
      ↓
Exception is handled
      ↓
Program prints:
"Exception was handled"
      ↓
Problem:
Which exception occurred?
      ↓
Generic message doesn't tell us
      ↓
Use information from exception object
      ↓
e.getClass()
e.getMessage()
      ↓
Understand what actually happened
```

### 🧠 Remember forever:

> **A generic message such as `"Exception was handled"` tells us that an exception was handled, but it does not tell us which specific exception occurred.**
