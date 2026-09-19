# 🧒 3.1 Program With Exception: Negative Array Size

Your notes contain:

* **Negative array size**
* **NegativeArraySizeException**

The main idea is:

> **Java arrays cannot have a negative size. If a program tries to create an array using a negative size, Java throws `NegativeArraySizeException` at runtime.**

---

# 1️⃣ Start From ZERO

When we create an array, we specify its size.

For example:

```java
int[] numbers = new int[5];
```

This means:

> "Java, create an array that can hold 5 integers."

That's perfectly valid.

```text
Size = 5
   ↓
Array created ✅
```

But what if we write:

```java
int[] numbers = new int[-5];
```

Now we are asking Java:

> "Create an array with -5 elements."

That doesn't make sense.

An array cannot have a negative number of elements.

Therefore Java throws:

```text
NegativeArraySizeException
```

---

# 2️⃣ What Is `NegativeArraySizeException`?

`NegativeArraySizeException` is a runtime exception that occurs when Java tries to create an array with a **negative size**.

Example:

```java
int[] numbers = new int[-5];
```

Result:

```text
NegativeArraySizeException
```

---

# 3️⃣ Real-World Analogy 🧒

Imagine you tell a shopkeeper:

> "Give me a box that contains **5 items**."

That's possible:

```text
5 items ✅
```

You then say:

> "Give me a box that contains **-5 items**."

The shopkeeper would say:

> "That doesn't make sense!"

Similarly, Java says:

```text
Negative array size ❌
```

and throws:

```text
NegativeArraySizeException
```

---

# 4️⃣ Simple Program

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Program Starts");

        int[] numbers = new int[-5];

        System.out.println("Array Created");

        System.out.println("Program Ends");
    }
}
```

The important statement is:

```java
int[] numbers = new int[-5];
```

---

# 5️⃣ What Happens?

Java reaches:

```java
new int[-5]
```

It checks the requested array size.

```text
Requested size
      ↓
     -5
      ↓
Is negative?
      ↓
    YES ❌
      ↓
NegativeArraySizeException
```

---

# 6️⃣ Output

You may see something similar to:

```text
Program Starts
Exception in thread "main" java.lang.NegativeArraySizeException: -5
    at Demo.main(Demo.java:...)
```

The exact line number depends on your program.

Notice:

```text
Array Created
Program Ends
```

are not printed.

Why?

Because the exception occurs while creating the array.

---

# 7️⃣ Execution Flow

```text
Program Starts
      ↓
Create array
      ↓
Requested size = -5
      ↓
Invalid size
      ↓
NegativeArraySizeException
      ↓
Normal flow interrupted
      ↓
If uncaught → main thread terminates
```

---

# 8️⃣ Valid vs Invalid Array Size

### ✅ Valid

```java
int[] numbers = new int[5];
```

```text
5
↓
Valid
↓
Array created
```

### ❌ Invalid

```java
int[] numbers = new int[-5];
```

```text
-5
 ↓
Negative size
 ↓
NegativeArraySizeException
```

---

# 9️⃣ Important Point

The problem is **not** the declaration:

```java
int[] numbers;
```

This only declares an array reference.

No array has been created yet.

The exception occurs here:

```java
new int[-5]
```

because this statement actually attempts to create the array.

---

# 🔟 Declaration vs Creation

### Declaration

```java
int[] numbers;
```

Means:

> "I have a reference variable that can refer to an integer array."

No array is created here.

---

### Creation

```java
numbers = new int[-5];
```

Now Java attempts to create an array.

The size is negative.

Therefore:

```text
NegativeArraySizeException ❌
```

---

# 1️⃣1️⃣ Runtime Exception

Consider:

```java
int size = -5;

int[] numbers = new int[size];
```

The compiler doesn't necessarily know what value `size` will have at runtime.

The program runs:

```text
size = -5
    ↓
new int[size]
    ↓
new int[-5]
    ↓
NegativeArraySizeException
```

So this is a **runtime exception**.

---

# 1️⃣2️⃣ User Input Example

The size can also come from the user.

```java
import java.util.Scanner;

class Demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int size = sc.nextInt();

        int[] numbers = new int[size];

        System.out.println("Array created successfully");
    }
}
```

Suppose the user enters:

```text
5
```

Then:

```text
new int[5]
```

works.

But if the user enters:

```text
-5
```

then:

```text
new int[-5]
```

causes:

```text
NegativeArraySizeException
```

---

# 1️⃣3️⃣ Why Does Java Throw an Exception?

Java needs a meaningful size for an array.

Valid examples:

```text
0
1
5
100
```

Negative values don't represent a valid number of array elements.

So:

```text
Negative size
     ↓
Invalid array creation
     ↓
NegativeArraySizeException
```

---

# 1️⃣4️⃣ Is Zero a Negative Size?

No.

This is important.

```java
int[] numbers = new int[0];
```

has a size of zero.

That's different from:

```java
int[] numbers = new int[-1];
```

The first is a zero-length array; the second attempts an invalid negative length.

So:

```text
0   → not negative
-1  → negative
```

---

# 1️⃣5️⃣ Zero-Length Array

This is valid:

```java
int[] numbers = new int[0];

System.out.println(numbers.length);
```

Output:

```text
0
```

So:

```text
new int[0]  → valid
new int[-1] → NegativeArraySizeException
```

---

# 1️⃣6️⃣ Exception Flow

```text
              Array Creation
                    ↓
             new int[size]
                    ↓
             Check size
              /        \
           >= 0         < 0
            ↓             ↓
       Array created   Exception
            ↓             ↓
       Normal flow   NegativeArraySizeException
```

---

# 1️⃣7️⃣ What If We Handle It?

We can handle the exception using `try-catch`.

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

Output:

```text
Program Starts
Array size cannot be negative
Program Ends
```

Now the exception has been handled.

---

# 1️⃣8️⃣ Without Exception Handling

```text
new int[-5]
     ↓
NegativeArraySizeException
     ↓
No handler
     ↓
Uncaught exception
     ↓
main thread terminates
```

---

# 1️⃣9️⃣ With Exception Handling

```text
new int[-5]
     ↓
NegativeArraySizeException
     ↓
catch
     ↓
Handle exception
     ↓
Program continues
     ↓
Program Ends
```

---

# 2️⃣0️⃣ Real-World Meaning

Think of the array size as the number of chairs you want to place in a classroom.

```text
10 chairs → possible
5 chairs  → possible
0 chairs  → possible
-5 chairs → impossible
```

Java similarly says:

```text
Array size = -5
       ↓
Impossible
       ↓
NegativeArraySizeException
```

---

# 2️⃣1️⃣ Common Confusion

### ❌ "NegativeArraySizeException occurs when accessing a negative index."

Not necessarily.

These are two different concepts.

Creating:

```java
new int[-5]
```

causes:

```text
NegativeArraySizeException
```

But accessing something like:

```java
numbers[-1]
```

in an existing array is an **invalid index access** and results in an `ArrayIndexOutOfBoundsException`.

Remember:

```text
Negative SIZE
      ↓
NegativeArraySizeException

Invalid INDEX
      ↓
ArrayIndexOutOfBoundsException
```

---

# 2️⃣2️⃣ Size vs Index

This distinction is extremely important.

### Size

```java
new int[-5]
```

Problem:

```text
Array size is negative
```

Exception:

```text
NegativeArraySizeException
```

### Index

```java
numbers[-1]
```

Problem:

```text
Index is invalid
```

Exception:

```text
ArrayIndexOutOfBoundsException
```

---

# 2️⃣3️⃣ Common Confusion

### ❓ Does declaring an array with a negative size cause a compile-time error?

When the negative value is supplied dynamically:

```java
int size = -5;
int[] numbers = new int[size];
```

the exception occurs at runtime.

The key point for this topic is:

> **`NegativeArraySizeException` is a runtime exception caused when array creation is attempted with a negative size.**

---

# 2️⃣4️⃣ Stack Trace

When the exception is uncaught, Java typically prints information similar to:

```text
Exception in thread "main"
java.lang.NegativeArraySizeException: -5
    at Demo.main(Demo.java:...)
```

This gives you:

```text
Exception type
       ↓
NegativeArraySizeException

Message
       ↓
-5

Location
       ↓
Demo.main(...)
```

---

# 2️⃣5️⃣ Exception Hierarchy

At a simplified level:

```text
Throwable
    ↓
  Exception
    ↓
RuntimeException
    ↓
NegativeArraySizeException
```

So `NegativeArraySizeException` is an **unchecked/runtime exception**.

---

# 2️⃣6️⃣ Why Is It Called "NegativeArraySizeException"?

Break the name into three pieces:

```text
Negative + Array + Size + Exception
```

Meaning:

```text
Negative
   ↓
Array
   ↓
Size
   ↓
Exception
```

In simple English:

> **"You tried to create an array with a negative size."**

---

# 2️⃣7️⃣ Important Rules

Remember these:

1. An array needs a valid size when it is created.
2. The array size cannot be negative.
3. `new int[-5]` attempts to create an array with negative size.
4. Java throws `NegativeArraySizeException`.
5. It is a runtime exception.
6. The exception occurs during array creation.
7. Declaring an array reference does not create the array.
8. A zero-length array is valid.
9. Negative size and negative index are different concepts.
10. An uncaught exception interrupts normal execution.
11. `try-catch` can handle the exception.

---

# 2️⃣8️⃣ Memory Trick 🧠

Remember:

```text
SIZE = NEGATIVE
       ↓
ARRAY CREATION
       ↓
NegativeArraySizeException
```

Or simply:

> **Negative SIZE → NegativeArraySizeException**

---

# 2️⃣9️⃣ Interview Question

### ❓ What is `NegativeArraySizeException`?

**Answer:**

> `NegativeArraySizeException` is a runtime exception thrown when a Java program attempts to create an array with a negative size.

Example:

```java
int[] numbers = new int[-5];
```

---

# 3️⃣0️⃣ Interview Question

### ❓ When does `NegativeArraySizeException` occur?

**Answer:**

> It occurs during array creation when the specified array size is negative.

---

# 3️⃣1️⃣ Interview Question

### ❓ Is `new int[0]` valid?

**Answer:**

> Yes. Java allows a zero-length array. The problem is a **negative** array size.

Example:

```java
int[] numbers = new int[0];

System.out.println(numbers.length);
```

Output:

```text
0
```

---

# 3️⃣2️⃣ Interview Question

### ❓ What is the difference between negative array size and negative array index?

| Situation           | Example       | Exception                        |
| ------------------- | ------------- | -------------------------------- |
| Negative array size | `new int[-5]` | `NegativeArraySizeException`     |
| Invalid array index | `numbers[-1]` | `ArrayIndexOutOfBoundsException` |

This distinction is very important.

---

# 3️⃣3️⃣ Complete Example

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Program Starts");

        int size = -5;

        System.out.println("Array size = " + size);

        int[] numbers = new int[size];

        System.out.println("Array Created");

        System.out.println("Program Ends");
    }
}
```

Flow:

```text
Program Starts
      ↓
size = -5
      ↓
new int[-5]
      ↓
NegativeArraySizeException
      ↓
Normal execution interrupted
      ↓
Array Created ❌
      ↓
Program Ends ❌
```

---

# 3️⃣4️⃣ Your Notes Mapped Directly

### **Negative array size**

```java
int[] numbers = new int[-5];
```

The program requests an array with a negative number of elements.

### **NegativeArraySizeException**

Java detects the invalid size during array creation and throws:

```text
NegativeArraySizeException
```

If it is not handled:

```text
Exception
   ↓
Uncaught
   ↓
main thread terminates
```

---

# 3️⃣5️⃣ Super-Simple Mental Model 🧒

Imagine asking Java:

> "Give me a box with `5` spaces."

```text
5 spaces
↓
✅ Sure!
```

Then:

> "Give me a box with `-5` spaces."

```text
-5 spaces
↓
❌ Impossible!
↓
NegativeArraySizeException
```

So:

```text
Positive size
     ↓
Array created ✅

Zero size
     ↓
Zero-length array ✅

Negative size
     ↓
NegativeArraySizeException ❌
```

---

# 3️⃣6️⃣ Final `/eli5` Understanding 🎯

Suppose we write:

```java
int size = -5;

int[] numbers = new int[size];
```

Java evaluates:

```text
size
 ↓
-5
 ↓
new int[-5]
 ↓
"An array cannot have a negative size!"
 ↓
NegativeArraySizeException
```

If there is no handler:

```text
NegativeArraySizeException
        ↓
No suitable handler
        ↓
Exception becomes uncaught
        ↓
Default uncaught-exception handling
        ↓
main thread terminates
        ↓
Program terminates abnormally
```

If we handle it:

```text
NegativeArraySizeException
        ↓
catch
        ↓
Display meaningful message
        ↓
Program continues
        ↓
Program Ends ✅
```

### ⭐ Remember this exact line:

> **Negative array size → `NegativeArraySizeException` → runtime exception → normal flow is interrupted unless it is handled.**
