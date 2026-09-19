# 🧒 9.1 NegativeArraySizeException

## 1. What Is an Exception?

An **exception** is a problem that occurs while a Java program is running and disturbs the normal flow of the program.

For example:

```java
int result = 10 / 0;
```

Java cannot divide an integer by zero, so an exception occurs.

Similarly, Java cannot create an array with a negative size.

---

## 2. What Is an Array?

An **array** is a container that stores multiple values of the same data type.

Example:

```java
int[] numbers = new int[5];
```

This creates space for **5 integer values**.

Conceptually:

```text
numbers
   ↓
┌────┬────┬────┬────┬────┐
│    │    │    │    │    │
└────┴────┴────┴────┴────┘
  0    1    2    3    4
```

The array has:

```text
Size = 5
```

---

## 3. What Is Array Size?

The array size tells Java **how many elements the array should contain**.

Example:

```java
new int[5]
```

means:

> Create an integer array capable of holding 5 elements.

Other valid examples:

```java
new int[1]
new int[10]
new int[100]
```

---

## 4. Can an Array Have a Negative Size?

No.

Consider:

```java
new int[-5]
```

This asks Java to create an array with:

```text
-5 elements
```

That is impossible.

You can have:

```text
0 elements
1 element
5 elements
100 elements
```

but you cannot have:

```text
-5 elements
```

Therefore Java generates an exception.

---

## 5. What Is `NegativeArraySizeException`?

`NegativeArraySizeException` is an exception that occurs when a program tries to create an array with a **negative size**.

Example:

```java
int[] numbers = new int[-5];
```

Here `-5` is the array size.

Therefore:

```text
Negative size
      ↓
NegativeArraySizeException
```

---

## 6. Understanding the Example `-5`

Your example is:

```text
-5
```

The minus sign means the number is negative.

So:

```text
5
```

means five.

But:

```text
-5
```

means negative five.

When Java sees:

```java
new int[-5]
```

it interprets `-5` as the requested array size.

Since an array cannot have a negative size, Java throws:

```text
NegativeArraySizeException
```

---

## 7. Understanding `int[]`

Consider:

```java
int[] numbers;
```

Break it into parts.

### `int`

`int` represents an integer data type.

Examples of integer values:

```text
10
20
100
-5
0
```

### `[]`

The square brackets indicate that `numbers` is an array reference.

### `numbers`

This is the variable name.

So:

```java
int[] numbers;
```

means:

> `numbers` can refer to an integer array.

---

## 8. Understanding `new`

Consider:

```java
new int[5]
```

The keyword:

```java
new
```

is used to create something in memory.

For an array:

```java
new int[5]
```

means:

> Create an integer array with space for 5 elements.

Therefore:

```java
int[] numbers = new int[5];
```

creates the array and stores its reference in `numbers`.

---

## 9. Understanding the Complete Statement

Consider:

```java
int[] numbers = new int[-5];
```

Let's read it from left to right.

```text
int[]
 ↓
integer array type

numbers
 ↓
reference variable

=
 ↓
assignment

new
 ↓
create array

int
 ↓
array element type

[-5]
 ↓
requested array size
```

The complete meaning is:

> Create an integer array with a size of negative five and assign its reference to `numbers`.

But the requested size is invalid.

Therefore:

```text
NegativeArraySizeException
```

occurs.

---

# 🧒 10. What Exactly Goes Wrong?

Suppose Java receives:

```java
new int[-5]
```

Java needs to create memory for the array.

It first needs to know:

```text
How many elements?
```

The answer provided by the program is:

```text
-5
```

Java recognizes that this is invalid.

So the array is **not successfully created**.

Instead, Java creates an exception object representing the problem and throws it.

Conceptually:

```text
new int[-5]
     ↓
Check array size
     ↓
Size = -5
     ↓
Negative size
     ↓
Create NegativeArraySizeException object
     ↓
Throw exception
```

---

# 🧒 11. Exception Object

When an exception occurs, Java represents the exception as an **object**.

For this problem, the object is associated with:

```text
NegativeArraySizeException
```

Conceptually:

```text
Exception occurs
      ↓
Exception object created
      ↓
Runtime System receives it
      ↓
Handler searched
```

The object contains information about the exception.

---

# 🧒 12. Runtime System

When the exception occurs, Java's **Runtime System** becomes involved in managing the exception.

The simplified flow is:

```text
Program
   ↓
new int[-5]
   ↓
Exception occurs
   ↓
Exception object
   ↓
Runtime System
   ↓
Search for handler
```

If a suitable `catch` block exists, the exception can be handled there.

If no handler exists, the default exception handling mechanism takes over.

---

# 🧒 13. Program Without Exception Handling

Consider:

```java
class Demo {

    public static void main(String[] args) {

        int[] numbers = new int[-5];

        System.out.println("Program Ends");
    }
}
```

The important statement is:

```java
int[] numbers = new int[-5];
```

The array creation fails.

Therefore the next statement:

```java
System.out.println("Program Ends");
```

is not reached through normal execution.

---

# 🧒 14. Execution Without `try-catch`

The flow is:

```text
Program Starts
      ↓
main()
      ↓
Create array
      ↓
Array size = -5
      ↓
NegativeArraySizeException
      ↓
No handler
      ↓
Default exception handler
      ↓
Program terminates abnormally
```

---

# 🧒 15. Default Exception Handler

If the program does not provide a suitable exception handler, Java's default exception-handling mechanism handles the uncaught exception.

For example:

```java
class Demo {

    public static void main(String[] args) {

        int[] numbers = new int[-5];

        System.out.println("Program Ends");
    }
}
```

There is no:

```java
catch
```

for the exception.

So the exception remains unhandled.

The program terminates abnormally.

---

# 🧒 16. Why Doesn't `Program Ends` Print?

Look at:

```java
int[] numbers = new int[-5];

System.out.println("Program Ends");
```

Execution reaches:

```java
new int[-5]
```

An exception occurs there.

Normal execution is interrupted.

Therefore Java does not simply continue to:

```java
System.out.println("Program Ends");
```

Instead, control moves into exception processing.

So:

```text
new int[-5]
     ↓
Exception
     ↓
Normal flow interrupted
```

---

# 🧒 17. Handling the Exception With `try-catch`

We can handle it:

```java
class Demo {

    public static void main(String[] args) {

        try {

            int[] numbers = new int[-5];

        }
        catch (NegativeArraySizeException e) {

            System.out.println("Array size cannot be negative");
        }

        System.out.println("Program Ends");
    }
}
```

Now the exception has a handler.

The handler is:

```java
catch (NegativeArraySizeException e)
```

---

# 🧒 18. Understanding `try`

The `try` block contains code that may produce an exception.

Here:

```java
try {

    int[] numbers = new int[-5];

}
```

we place the risky operation inside `try`.

The risky operation is:

```java
new int[-5]
```

So:

```text
try
 ↓
risky array creation
```

---

# 🧒 19. Understanding `catch`

The `catch` block is used to handle an exception.

```java
catch (NegativeArraySizeException e)
```

means:

> If a `NegativeArraySizeException` occurs in the associated `try` block, this `catch` can receive it.

---

# 🧒 20. Understanding `e`

In:

```java
catch (NegativeArraySizeException e)
```

`e` is a reference variable.

It refers to the exception object that was thrown.

Conceptually:

```text
NegativeArraySizeException object
              ↓
              e
```

So we can use `e` to obtain information about the exception.

---

# 🧒 21. Printing the Exception Message

We can write:

```java
catch (NegativeArraySizeException e) {

    System.out.println(e.getMessage());
}
```

`getMessage()` obtains the message associated with the exception object.

However, the exact message produced for a particular Java runtime can vary, so the most reliable beginner-friendly demonstration is to print our own message:

```java
System.out.println("Array size cannot be negative");
```

---

# 🧒 22. Complete Handling Flow

With `try-catch`:

```text
main()
  ↓
try
  ↓
new int[-5]
  ↓
NegativeArraySizeException
  ↓
catch
  ↓
Exception handled
  ↓
Program Ends
```

This is different from the unhandled version.

Without handling:

```text
Exception
   ↓
Default handler
   ↓
Abnormal termination
```

With handling:

```text
Exception
   ↓
catch
   ↓
Handled
   ↓
Normal continuation
```

---

# 🧒 23. Complete Example

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Program Starts");

        try {

            int[] numbers = new int[-5];

            System.out.println("Array Created");

        }
        catch (NegativeArraySizeException e) {

            System.out.println("Array size cannot be negative");
        }

        System.out.println("Program Ends");
    }
}
```

---

# 🧒 24. Line-by-Line Execution

### Step 1

```java
System.out.println("Program Starts");
```

Output:

```text
Program Starts
```

---

### Step 2

Java enters:

```java
try
```

The program is about to perform the risky operation.

---

### Step 3

Java executes:

```java
int[] numbers = new int[-5];
```

Java tries to create the array.

Requested size:

```text
-5
```

---

### Step 4

Java detects:

```text
Negative array size
```

Therefore:

```text
NegativeArraySizeException
```

occurs.

---

### Step 5

The exception moves to:

```java
catch (NegativeArraySizeException e)
```

The catch block handles it.

---

### Step 6

This executes:

```java
System.out.println("Array size cannot be negative");
```

Output:

```text
Array size cannot be negative
```

---

### Step 7

After the `catch` finishes, execution continues with:

```java
System.out.println("Program Ends");
```

Output:

```text
Program Ends
```

---

# 🧒 25. Complete Output

```text
Program Starts
Array size cannot be negative
Program Ends
```

Notice:

```text
Array Created
```

is not printed.

Why?

Because:

```java
new int[-5]
```

failed before the next statement could execute.

---

# 🧒 26. Exception Flow Visualization

```text
                 main()
                   │
                   ▼
             Program Starts
                   │
                   ▼
                  try
                   │
                   ▼
             new int[-5]
                   │
                   ▼
       NegativeArraySizeException
                   │
                   ▼
                 catch
                   │
                   ▼
     "Array size cannot be negative"
                   │
                   ▼
             Program Ends
```

---

# 🧒 27. Very Important Confusion: Negative Size vs Negative Value

This is one of the most important things to remember.

### This causes an exception:

```java
int[] numbers = new int[-5];
```

because `-5` is the **array size**.

But this is valid:

```java
int[] numbers = {-5};
```

because `-5` is the **value stored inside the array**.

---

# 🧒 28. Understanding the Difference

### Example 1

```java
int[] numbers = new int[-5];
```

Meaning:

> Create an array containing negative five elements.

Impossible.

Result:

```text
NegativeArraySizeException
```

### Example 2

```java
int[] numbers = {-5};
```

Meaning:

> Create an array containing one element whose value is `-5`.

This is valid.

The array is:

```text
Index
  0
  ↓
[-5]
```

Array size:

```text
1
```

Array value:

```text
-5
```

No exception occurs.

---

# 🧒 29. Another Example

```java
int[] numbers = {-5, -10, -15};
```

This is also valid.

Why?

Because the array size is:

```text
3
```

The values are:

```text
-5
-10
-15
```

Negative numbers are perfectly valid **values** in an integer array.

The problem occurs only when the **requested array size** is negative.

---

# 🧒 30. Valid and Invalid Array Sizes

| Code           | Meaning                | Result                       |
| -------------- | ---------------------- | ---------------------------- |
| `new int[0]`   | Array of size 0        | Valid                        |
| `new int[1]`   | Array of size 1        | Valid                        |
| `new int[5]`   | Array of size 5        | Valid                        |
| `new int[100]` | Array of size 100      | Valid                        |
| `new int[-1]`  | Array of negative size | `NegativeArraySizeException` |
| `new int[-5]`  | Array of negative size | `NegativeArraySizeException` |

---

# 🧒 31. Variable Example

The size does not always have to be written directly.

Consider:

```java
int size = -5;

int[] numbers = new int[size];
```

Here:

```text
size = -5
```

Then Java effectively receives:

```java
new int[-5]
```

Therefore:

```text
NegativeArraySizeException
```

occurs.

---

# 🧒 32. User Input Example

The size can also come from the user.

```java
import java.util.Scanner;

class Demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size:");

        int size = sc.nextInt();

        try {

            int[] numbers = new int[size];

            System.out.println("Array Created");

        }
        catch (NegativeArraySizeException e) {

            System.out.println("Array size cannot be negative");
        }

        System.out.println("Program Ends");
    }
}
```

Suppose the user enters:

```text
-5
```

Then:

```text
size = -5
```

and Java executes:

```java
new int[-5]
```

Therefore:

```text
NegativeArraySizeException
```

occurs.

---

# 🧒 33. User Input Flow

```text
User
 ↓
Enters -5
 ↓
Scanner reads -5
 ↓
size = -5
 ↓
new int[size]
 ↓
new int[-5]
 ↓
NegativeArraySizeException
 ↓
catch
 ↓
Array size cannot be negative
 ↓
Program Ends
```

If the user enters:

```text
5
```

then:

```text
size = 5
```

and:

```java
new int[5]
```

is valid.

The array is created successfully.

---

# 🧒 34. Common Beginner Mistakes

### Mistake 1: Thinking negative integer values are illegal in arrays

Wrong:

> "Arrays cannot contain negative numbers."

Correct:

> Arrays can contain negative integer values.

Example:

```java
int[] a = {-5, -10};
```

is valid.

---

### Mistake 2: Thinking `-5` always causes `NegativeArraySizeException`

Not always.

This:

```java
int[] a = {-5};
```

is valid.

This:

```java
int[] a = new int[-5];
```

causes the exception.

The position and meaning of `-5` matter.

---

### Mistake 3: Thinking `catch` creates the exception

It does not.

The exception is caused by the invalid array creation.

`catch` only receives/handles the exception.

```text
new int[-5]
      ↓
exception occurs

catch
      ↓
handles exception
```

---

### Mistake 4: Thinking `throws` handles the exception

It does not.

```text
throws → declares/passes responsibility
catch  → handles
```

---

### Mistake 5: Thinking `finally` causes the exception to disappear

`finally` is for final code execution; it is not what handles the exception.

---

# 🧒 35. Interview-Level Understanding

### Question: What is `NegativeArraySizeException`?

Answer:

> `NegativeArraySizeException` is a runtime exception that occurs when a Java program attempts to create an array with a negative size.

Example:

```java
int[] a = new int[-5];
```

---

### Question: Is `-5` itself an invalid integer value?

No.

`-5` is a valid integer value.

The problem is using `-5` as the **array size**.

---

### Question: Can an array contain negative numbers?

Yes.

Example:

```java
int[] a = {-5, -10, -15};
```

---

### Question: How can we handle `NegativeArraySizeException`?

Using `try-catch`:

```java
try {

    int[] a = new int[-5];

}
catch (NegativeArraySizeException e) {

    System.out.println("Invalid array size");
}
```

---

### Question: Is `NegativeArraySizeException` a compile-time or runtime problem?

It is a **runtime exception**.

The Java compiler can compile code such as:

```java
int[] a = new int[-5];
```

but when the statement executes, the exception occurs.

---

# 🧒 36. Lifetime Memory Summary

Remember this entire topic as one simple story:

```text
                 ARRAY
                   ↓
          Needs a size
                   ↓
          Example: new int[5]
                   ↓
              Size = 5
                   ↓
                Valid
```

But:

```text
                 ARRAY
                   ↓
          Needs a size
                   ↓
          Example: new int[-5]
                   ↓
            Size = -5
                   ↓
              Invalid
                   ↓
     NegativeArraySizeException
```

With handling:

```text
new int[-5]
     ↓
Exception occurs
     ↓
Exception object
     ↓
Runtime System
     ↓
catch
     ↓
Exception handled
     ↓
Program continues
```

Without handling:

```text
new int[-5]
     ↓
Exception occurs
     ↓
Runtime System
     ↓
No suitable handler
     ↓
Default Exception Handler
     ↓
Abnormal termination
```

### 🧠 The one sentence to remember forever:

> **`NegativeArraySizeException` occurs when Java tries to create an array using a negative size, such as `new int[-5]`; negative numbers are perfectly valid as array values, but they cannot be used as the array size.**
