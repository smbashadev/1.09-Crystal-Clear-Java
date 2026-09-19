# 🧒 2.2 Program Without Exception

Your notes:

* Array size
* Array creation
* Array length
* Normal execution

The purpose of this program is to understand a situation where we work with an array **without causing any exception**.

---

# 1️⃣ Start From ZERO

An **array** is like a row of boxes where we can store multiple values of the same type.

Imagine:

```text
Array
┌────┬────┬────┬────┬────┐
│ 10 │ 20 │ 30 │ 40 │ 50 │
└────┴────┴────┴────┴────┘
  0    1    2    3    4
```

Here:

* Array size = `5`
* Array length = `5`
* Valid indexes = `0` to `4`

---

# 2️⃣ Array Size

When creating an array, we specify how many elements it should contain.

Example:

```java
int[] numbers = new int[5];
```

Here:

```text
5 → Array size
```

Java creates space for **5 integers**.

---

# 3️⃣ Array Creation

The basic syntax is:

```java
dataType[] arrayName = new dataType[size];
```

Example:

```java
int[] numbers = new int[5];
```

This creates:

```text
numbers
   ↓
┌────┬────┬────┬────┬────┐
│  0 │  0 │  0 │  0 │  0 │
└────┴────┴────┴────┴────┘
  0    1    2    3    4
```

For an `int` array, the elements initially contain `0`.

---

# 4️⃣ Array Length

Java provides the `length` property to determine the number of elements in an array.

Syntax:

```java
arrayName.length
```

Example:

```java
numbers.length
```

If:

```java
int[] numbers = new int[5];
```

then:

```java
numbers.length
```

returns:

```text
5
```

---

# 5️⃣ Important: `length` Is a Property

For arrays, we use:

```java
array.length
```

There are **no parentheses**.

Correct:

```java
numbers.length
```

Not:

```java
numbers.length()
```

`length()` is not the syntax for an array.

---

# 6️⃣ Simple Program

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Program Starts");

        int[] numbers = new int[5];

        System.out.println("Array Size = 5");
        System.out.println("Array Length = " + numbers.length);

        System.out.println("Program Ends");
    }
}
```

---

# 7️⃣ Output

```text
Program Starts
Array Size = 5
Array Length = 5
Program Ends
```

Everything executes normally.

Therefore:

> **No exception occurs in this program.**

---

# 8️⃣ Execution Flow

```text
Program Starts
      ↓
Create array
      ↓
Array size = 5
      ↓
Array created successfully
      ↓
Check array.length
      ↓
length = 5
      ↓
Program Ends
```

---

# 9️⃣ Array Size vs Array Length

In this example:

```java
int[] numbers = new int[5];
```

we requested:

```text
Size = 5
```

After creation:

```java
numbers.length
```

gives:

```text
Length = 5
```

So:

```text
Array creation size
       ↓
       5
       ↓
Array length
       ↓
       5
```

---

# 🔟 Visual Understanding 🧒

Suppose you order a box containing five compartments.

```text
int[] numbers = new int[5];
```

Java gives you:

```text
┌───────┬───────┬───────┬───────┬───────┐
│ Box 0 │ Box 1 │ Box 2 │ Box 3 │ Box 4 │
└───────┴───────┴───────┴───────┴───────┘
```

There are:

```text
5 boxes
```

Therefore:

```java
numbers.length
```

returns:

```text
5
```

---

# 1️⃣1️⃣ Array Index

The array indexes start from `0`.

For an array of length `5`:

```text
Index:
  0    1    2    3    4
  ↓    ↓    ↓    ↓    ↓
┌────┬────┬────┬────┬────┐
│    │    │    │    │    │
└────┴────┴────┴────┴────┘
```

Therefore:

```text
First index = 0
Last index  = length - 1
```

For length `5`:

```text
Last index = 5 - 1 = 4
```

---

# 1️⃣2️⃣ Why Is This Program "Without Exception"?

Because we are performing valid operations.

```java
int[] numbers = new int[5];
```

Valid array creation.

And:

```java
numbers.length
```

is also valid.

Therefore:

```text
No exception
     ↓
Normal execution
```

---

# 1️⃣3️⃣ Adding Values

We can also store values:

```java
class Demo {

    public static void main(String[] args) {

        int[] numbers = new int[5];

        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;

        System.out.println("Array Length = " + numbers.length);
    }
}
```

Output:

```text
Array Length = 5
```

Again, normal execution occurs.

---

# 1️⃣4️⃣ Why Does `numbers[4]` Work?

Because:

```text
length = 5
```

and valid indexes are:

```text
0 1 2 3 4
```

So:

```java
numbers[4]
```

is valid.

---

# 1️⃣5️⃣ Valid Array Access

For:

```java
int[] numbers = new int[5];
```

these are valid:

```java
numbers[0];
numbers[1];
numbers[2];
numbers[3];
numbers[4];
```

Because all these indexes exist.

---

# 1️⃣6️⃣ The Connection to Exceptions

This topic is preparing you for the next idea.

A valid operation:

```java
numbers[4]
```

works normally.

But an invalid operation such as:

```java
numbers[5]
```

will cause an exception because index `5` doesn't exist.

So:

```text
Valid index
   ↓
Normal execution
```

while:

```text
Invalid index
   ↓
Exception
```

---

# 1️⃣7️⃣ Program Flow

For the **without-exception** case:

```text
          Demo
           ↓
         main()
           ↓
      Create array
           ↓
     int[5] created
           ↓
     Check length
           ↓
        length = 5
           ↓
    Normal execution
           ↓
       Program Ends
```

---

# 1️⃣8️⃣ Array Length Is Fixed

Once you create:

```java
int[] numbers = new int[5];
```

the array has a fixed length:

```text
5
```

You cannot increase the same array's length to `6`.

You would need to create another array.

For example:

```java
int[] numbers = new int[6];
```

creates a different array with length `6`.

---

# 1️⃣9️⃣ Common Confusion

### ❌ `length()` for array

Wrong:

```java
numbers.length()
```

### ✅ `length` for array

Correct:

```java
numbers.length
```

Remember:

```text
Array → length
String → length()
```

For example:

```java
numbers.length
```

but:

```java
"Hello".length()
```

---

# 2️⃣0️⃣ Common Confusion

### ❓ Is array size the same as array length?

For a newly created Java array:

```java
int[] numbers = new int[5];
```

the requested size is `5`, and the resulting array's `length` is `5`.

So for this example:

```text
Size   = 5
Length = 5
```

---

# 2️⃣1️⃣ Common Confusion

### ❓ Does `length` mean the last index?

No.

For:

```java
int[] numbers = new int[5];
```

```text
length = 5
last index = 4
```

Because:

```text
last index = length - 1
```

---

# 2️⃣2️⃣ Important Formula 🧠

Remember:

```text
First index = 0

Last index = length - 1
```

Example:

```text
length = 5

last index = 5 - 1
           = 4
```

---

# 2️⃣3️⃣ Another Example

```java
int[] marks = new int[10];
```

Then:

```text
Array size   = 10
Array length = 10
First index  = 0
Last index   = 9
```

Visual:

```text
0  1  2  3  4  5  6  7  8  9
└─────────────────────────────┘
             10 elements
```

---

# 2️⃣4️⃣ Runtime Understanding

When Java executes:

```java
int[] numbers = new int[5];
```

the JVM creates an array object with a fixed length.

Conceptually:

```text
JVM
 ↓
Create array object
 ↓
Length = 5
 ↓
Array exists
```

Then:

```java
numbers.length
```

retrieves that array's length.

---

# 2️⃣5️⃣ What Does Normal Execution Mean?

**Normal execution** means the program executes its statements according to the expected flow without an exception interrupting it.

Example:

```text
Start
 ↓
Create array
 ↓
Check length
 ↓
Print length
 ↓
End
```

No unexpected interruption occurs.

---

# 2️⃣6️⃣ Compare With Exception Situation

### Without exception:

```text
Create array
     ↓
Access valid information
     ↓
Print length
     ↓
Program Ends
```

### With exception:

```text
Create array
     ↓
Invalid array access
     ↓
ArrayIndexOutOfBoundsException
     ↓
Normal flow interrupted
```

This is why this simple program is useful before studying array exceptions.

---

# 2️⃣7️⃣ Important Rules

Remember these rules:

1. An array stores multiple values of the same type.
2. Array size is specified when the array is created.
3. Array length is available using `array.length`.
4. Array `length` is a property, not a method.
5. Array indexes start from `0`.
6. The last valid index is `length - 1`.
7. An array's length is fixed after creation.
8. Accessing valid indexes results in normal execution.
9. Accessing an invalid index can cause an exception.
10. Creating a valid array does not itself cause an exception.

---

# 2️⃣8️⃣ Memory Trick 🧠

Remember:

```text
new int[5]
     ↓
5 elements
     ↓
length = 5
     ↓
indexes = 0 to 4
```

So:

```text
SIZE → 5
LENGTH → 5
LAST INDEX → 4
```

---

# 2️⃣9️⃣ Interview Question

### ❓ How do you find the length of an array in Java?

Answer:

> We use the `length` property of the array.

Example:

```java
int[] numbers = new int[5];

System.out.println(numbers.length);
```

Output:

```text
5
```

---

# 3️⃣0️⃣ Interview Question

### ❓ What is the last valid index of an array?

Answer:

> The last valid index is `length - 1`.

Example:

```text
length = 5
last index = 4
```

---

# 3️⃣1️⃣ Interview Question

### ❓ Can we change the length of an existing Java array?

Answer:

> **No.** Java arrays have a fixed length once created. If a different size is required, a new array must be created.

---

# 3️⃣2️⃣ Interview Question

### ❓ Does accessing `array.length` cause an exception?

Normally, no, provided the array reference itself is not `null`.

For a valid array:

```java
int[] numbers = new int[5];

System.out.println(numbers.length);
```

the result is:

```text
5
```

---

# 3️⃣3️⃣ Core Diagram

```text
             ARRAY
               │
               ↓
        new int[5]
               │
               ↓
       ┌───┬───┬───┬───┬───┐
       │   │   │   │   │   │
       └───┴───┴───┴───┴───┘
        0   1   2   3   4
        │               │
      first           last
      index           index
        │               │
        0            length - 1
                         │
                         ↓
                     5 - 1 = 4

             array.length
                   ↓
                   5
```

---

# 3️⃣4️⃣ Your Notes Mapped Directly

### **Array Size**

```java
int[] numbers = new int[5];
```

The array is created with space for `5` elements.

### **Array Creation**

```java
new int[5]
```

creates the array object.

### **Array Length**

```java
numbers.length
```

returns the number of elements in the array.

### **Normal Execution**

When valid array operations are performed, the program executes normally without an exception.

---

# 3️⃣5️⃣ Super-Simple Mental Model

Think of an array as a row of seats:

```text
Seat:    0    1    2    3    4
        ┌───┬───┬───┬───┬───┐
        │   │   │   │   │   │
        └───┴───┴───┴───┴───┘
             5 seats
```

You ask:

```java
numbers.length
```

Java answers:

```text
5
```

Everything is valid.

Therefore:

```text
Array creation
      ↓
Array length
      ↓
Valid operation
      ↓
Normal execution ✅
```

---

# 3️⃣6️⃣ Final `/eli5` Understanding 🎯

Suppose you create:

```java
int[] numbers = new int[5];
```

Think of it as asking Java:

> **"Give me an array with 5 boxes."**

Java creates:

```text
┌────┬────┬────┬────┬────┐
│    │    │    │    │    │
└────┴────┴────┴────┴────┘
  0    1    2    3    4
```

Then:

```java
numbers.length
```

means:

> **"How many boxes are there?"**

Java answers:

```text
5
```

So the complete concept is:

```text
Array Creation
      ↓
new int[5]
      ↓
5 elements created
      ↓
numbers.length
      ↓
5
      ↓
Valid operation
      ↓
Normal execution ✅
```

### ⭐ Remember this:

> **Array size is specified during creation, array length tells us the number of elements, indexes start from 0, and valid array operations execute normally without an exception.**
