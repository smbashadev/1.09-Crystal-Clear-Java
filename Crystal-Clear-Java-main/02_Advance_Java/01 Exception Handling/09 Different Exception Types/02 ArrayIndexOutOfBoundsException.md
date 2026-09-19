# 🧒 9.2 ArrayIndexOutOfBoundsException

## 1. What Is an Array Index?

An **index** is the position number used to identify an element inside an array.

Consider:

```java
int[] numbers = new int[5];
```

This creates 5 elements.

Java gives them index numbers starting from **0**:

```text
Index:     0    1    2    3    4
           ↓    ↓    ↓    ↓    ↓
Array:    [10] [20] [30] [40] [50]
```

So the valid indexes are:

```text
0
1
2
3
4
```

There is no index `5`.

---

## 2. Why Does Java Start From 0?

Java uses **zero-based indexing**.

That means the first element is at index:

```text
0
```

The second element is at:

```text
1
```

The third element is at:

```text
2
```

Therefore, for an array of size 5:

```text
First element  → index 0
Second element → index 1
Third element  → index 2
Fourth element → index 3
Fifth element  → index 4
```

A simple formula is:

```text
Last valid index = array length - 1
```

For:

```text
length = 5
```

the last valid index is:

```text
5 - 1 = 4
```

---

# 🧒 3. What Is `ArrayIndexOutOfBoundsException`?

`ArrayIndexOutOfBoundsException` is a runtime exception that occurs when a Java program tries to access an array using an **invalid index**.

For example:

```java
int[] numbers = new int[5];

System.out.println(numbers[5]);
```

The array has indexes:

```text
0  1  2  3  4
```

but the program asks for:

```text
5
```

Therefore Java throws:

```text
ArrayIndexOutOfBoundsException
```

---

# 🧒 4. Understanding "Invalid Array Index"

Your note says:

> **Invalid array index**

An index is invalid when it does not exist in that particular array.

For example:

```java
int[] numbers = new int[5];
```

Valid:

```text
0
1
2
3
4
```

Invalid:

```text
5
6
7
10
-1
```

So both of these can cause the exception:

```java
numbers[5];
```

and:

```java
numbers[-1];
```

---

# 🧒 5. Array Size and Index Are Different

This is extremely important.

Suppose:

```java
int[] numbers = new int[5];
```

Here:

```text
Array size = 5
```

But the indexes are:

```text
0 to 4
```

So:

```text
Size       → 5
Last index → 4
```

Do not think that the last index is equal to the size.

Remember:

```text
Last index = size - 1
```

---

# 🧒 6. Simple Example

```java
class Demo {

    public static void main(String[] args) {

        int[] numbers = new int[5];

        System.out.println(numbers[5]);
    }
}
```

The array contains 5 positions:

```text
0  1  2  3  4
```

The program requests:

```text
5
```

Index `5` does not exist.

Therefore:

```text
ArrayIndexOutOfBoundsException
```

occurs.

---

# 🧒 7. Visualizing the Problem

Imagine five boxes:

```text
┌────┬────┬────┬────┬────┐
│ 10 │ 20 │ 30 │ 40 │ 50 │
└────┴────┴────┴────┴────┘
   0    1    2    3    4
```

If you ask Java:

```text
"Give me the value at index 3."
```

Java can find it:

```text
Index 3 → 40
```

But if you ask:

```text
"Give me the value at index 5."
```

Java checks:

```text
0 1 2 3 4
```

There is no `5`.

Therefore:

```text
Invalid index
      ↓
ArrayIndexOutOfBoundsException
```

---

# 🧒 8. Runtime Flow

When an invalid index is used:

```text
main()
  ↓
Array created
  ↓
Array index requested
  ↓
Java checks the index
  ↓
Index is invalid
  ↓
ArrayIndexOutOfBoundsException
  ↓
Exception object
  ↓
Runtime System
```

If there is a handler:

```text
Runtime System
      ↓
catch
      ↓
Exception handled
```

If there is no handler:

```text
Runtime System
      ↓
Default Exception Handler
      ↓
Program terminates abnormally
```

---

# 🧒 9. Valid Index Example

```java
class Demo {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println(numbers[0]);
        System.out.println(numbers[2]);
        System.out.println(numbers[4]);
    }
}
```

Output:

```text
10
30
50
```

Why?

Because:

```text
numbers[0] → 10
numbers[2] → 30
numbers[4] → 50
```

All three indexes exist.

---

# 🧒 10. Invalid Index Example

```java
class Demo {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println(numbers[5]);
    }
}
```

The array has:

```text
Index:  0   1   2   3   4
Value: 10  20  30  40  50
```

The program asks for:

```text
numbers[5]
```

But index `5` does not exist.

Therefore:

```text
ArrayIndexOutOfBoundsException
```

---

# 🧒 11. Negative Index

An index can also be invalid because it is negative.

Example:

```java
class Demo {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println(numbers[-1]);
    }
}
```

The valid indexes are:

```text
0 1 2 3 4
```

There is no:

```text
-1
```

Therefore Java throws:

```text
ArrayIndexOutOfBoundsException
```

---

# 🧒 12. Why Can't We Use `-1`?

The array is arranged like:

```text
Index:
 0   1   2   3   4
 ↓   ↓   ↓   ↓   ↓
[10][20][30][40][50]
```

There is no position before index `0` that Java can access using `-1`.

Therefore:

```java
numbers[-1]
```

is invalid.

---

# 🧒 13. Understanding Array Access Syntax

Consider:

```java
numbers[3]
```

It contains three important parts:

```text
numbers
   ↓
array reference

[
   ↓
opening square bracket

3
   ↓
index

]
   ↓
closing square bracket
```

The complete meaning is:

> Access the element stored at index 3 of the array referred to by `numbers`.

---

# 🧒 14. Understanding `numbers`

Suppose:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

`numbers` is the reference variable that refers to the array.

Conceptually:

```text
numbers
   ↓
┌────┬────┬────┬────┬────┐
│ 10 │ 20 │ 30 │ 40 │ 50 │
└────┴────┴────┴────┴────┘
  0    1    2    3    4
```

When you write:

```java
numbers[2]
```

Java goes to index `2` and gets:

```text
30
```

---

# 🧒 15. `length` Helps Find the Valid Range

Every array has a `length` property.

Example:

```java
int[] numbers = new int[5];

System.out.println(numbers.length);
```

Output:

```text
5
```

So:

```text
length = 5
```

The valid indexes are:

```text
0 through 4
```

because:

```text
last index = length - 1
```

Therefore:

```text
5 - 1 = 4
```

---

# 🧒 16. Very Important Relationship

Remember this:

```text
Array length = number of elements
```

and:

```text
Last valid index = length - 1
```

Example:

```text
Length = 10
Valid indexes = 0 to 9
```

Example:

```text
Length = 3
Valid indexes = 0 to 2
```

Example:

```text
Length = 1
Valid index = 0
```

---

# 🧒 17. Example Using `length`

```java
class Demo {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println(numbers.length);

        System.out.println(numbers[numbers.length - 1]);
    }
}
```

First:

```java
numbers.length
```

is:

```text
5
```

Then:

```java
numbers.length - 1
```

becomes:

```text
5 - 1
= 4
```

Therefore:

```java
numbers[4]
```

is accessed.

Output:

```text
5
50
```

---

# 🧒 18. Handling the Exception Using `try-catch`

We can handle the exception:

```java
class Demo {

    public static void main(String[] args) {

        try {

            int[] numbers = {10, 20, 30, 40, 50};

            System.out.println(numbers[5]);

        }
        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Invalid array index");
        }

        System.out.println("Program Ends");
    }
}
```

Output:

```text
Invalid array index
Program Ends
```

---

# 🧒 19. Understanding the `try` Block

The risky statement is:

```java
System.out.println(numbers[5]);
```

So we place it inside:

```java
try {
    // risky code
}
```

Java attempts to execute it.

The index is invalid.

Therefore the exception occurs.

---

# 🧒 20. Understanding the `catch` Block

The handler is:

```java
catch (ArrayIndexOutOfBoundsException e)
```

This means:

> If the `try` block produces an `ArrayIndexOutOfBoundsException`, handle it here.

The exception object is represented by:

```text
e
```

Then:

```java
System.out.println("Invalid array index");
```

prints a friendly message.

---

# 🧒 21. Complete Execution With `try-catch`

```text
Program Starts
      ↓
Create array
      ↓
Valid indexes = 0,1,2,3,4
      ↓
Try numbers[5]
      ↓
Index 5 does not exist
      ↓
ArrayIndexOutOfBoundsException
      ↓
catch
      ↓
Invalid array index
      ↓
Program Ends
```

The program can therefore continue after the exception has been handled.

---

# 🧒 22. What Happens Without `try-catch`?

```java
class Demo {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println(numbers[5]);

        System.out.println("Program Ends");
    }
}
```

The exception occurs here:

```java
numbers[5]
```

There is no handler.

So:

```text
Exception
   ↓
Default Exception Handler
   ↓
Abnormal termination
```

The statement:

```java
System.out.println("Program Ends");
```

is not reached normally.

---

# 🧒 23. Exception Object

When Java detects the invalid index, an exception object is created for the problem.

Conceptually:

```text
numbers[5]
    ↓
Invalid index
    ↓
Create exception object
    ↓
ArrayIndexOutOfBoundsException
    ↓
Runtime System
```

The object can be received by:

```java
catch (ArrayIndexOutOfBoundsException e)
```

---

# 🧒 24. Runtime System and Handler Search

The simplified exception process is:

```text
1. Invalid index occurs
        ↓
2. Exception object created
        ↓
3. Runtime System receives it
        ↓
4. Runtime System checks for handler
        ↓
5. Matching catch found
        ↓
6. catch receives exception object
        ↓
7. Program continues after catch
```

If no handler exists:

```text
Runtime System
      ↓
No suitable handler
      ↓
Default Exception Handler
      ↓
Abnormal termination
```

---

# 🧒 25. `ArrayIndexOutOfBoundsException` vs `NegativeArraySizeException`

These two exceptions are easy to confuse.

### `NegativeArraySizeException`

Problem occurs while **creating** the array.

```java
new int[-5]
```

Meaning:

> Create an array with negative size.

---

### `ArrayIndexOutOfBoundsException`

Problem occurs while **accessing** the array.

```java
int[] a = new int[5];

a[5];
```

Meaning:

> Access index 5, but the valid indexes are only 0 through 4.

---

# 🧒 26. Comparison

| Exception                        | Problem             | Example                 |
| -------------------------------- | ------------------- | ----------------------- |
| `NegativeArraySizeException`     | Negative array size | `new int[-5]`           |
| `ArrayIndexOutOfBoundsException` | Invalid array index | `a[5]` when length is 5 |

Memory trick:

```text
CREATE wrong
   ↓
NegativeArraySizeException
```

```text
ACCESS wrong
   ↓
ArrayIndexOutOfBoundsException
```

---

# 🧒 27. Real-Life Example

Imagine a classroom has 5 students sitting in seats numbered:

```text
0  1  2  3  4
```

You can ask:

```text
"Who is sitting in seat 2?"
```

There is a student.

But if you ask:

```text
"Who is sitting in seat 5?"
```

there is no seat 5.

That's similar to:

```java
students[5]
```

Java says:

> "That position doesn't exist."

and throws:

```text
ArrayIndexOutOfBoundsException
```

---

# 🧒 28. Another Real-Life Example

Imagine five lockers:

```text
Locker 0
Locker 1
Locker 2
Locker 3
Locker 4
```

If you request locker `3`, it exists.

If you request locker `5`, it does not exist.

Similarly:

```java
lockers[3]
```

is valid.

But:

```java
lockers[5]
```

is invalid if the array has length 5.

---

# 🧒 29. Loop Example

This exception can commonly happen because of a loop.

Consider:

```java
class Demo {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        for (int i = 0; i <= numbers.length; i++) {

            System.out.println(numbers[i]);
        }
    }
}
```

There is a problem here:

```java
i <= numbers.length
```

The length is:

```text
5
```

So the loop allows:

```text
i = 0
1
2
3
4
5
```

But index `5` is invalid.

Therefore the exception occurs when:

```text
i = 5
```

---

# 🧒 30. Correct Loop

Usually, to access every array element:

```java
for (int i = 0; i < numbers.length; i++)
```

Why `<` instead of `<=`?

Because:

```text
length = 5
```

and valid indexes are:

```text
0 1 2 3 4
```

The condition:

```text
i < 5
```

allows:

```text
0
1
2
3
4
```

but not:

```text
5
```

So it is safe.

---

# 🧒 31. Wrong vs Correct Loop

### Wrong

```java
for (int i = 0; i <= numbers.length; i++)
```

Possible indexes:

```text
0 1 2 3 4 5
```

Index `5` causes:

```text
ArrayIndexOutOfBoundsException
```

### Correct

```java
for (int i = 0; i < numbers.length; i++)
```

Indexes:

```text
0 1 2 3 4
```

All are valid.

---

# 🧒 32. Complete Loop Program

```java
class Demo {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        try {

            for (int i = 0; i <= numbers.length; i++) {

                System.out.println(numbers[i]);
            }

        }
        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Invalid array index");
        }

        System.out.println("Program Ends");
    }
}
```

Output:

```text
10
20
30
40
50
Invalid array index
Program Ends
```

Why?

The loop successfully accesses:

```text
numbers[0]
numbers[1]
numbers[2]
numbers[3]
numbers[4]
```

Then:

```text
i = 5
```

The program attempts:

```text
numbers[5]
```

and the exception occurs.

---

# 🧒 33. Common Mistakes

### Mistake 1

Thinking:

```text
Array size = 5
```

means:

```text
Indexes = 1 to 5
```

Wrong.

Java uses:

```text
0 to 4
```

---

### Mistake 2

Using:

```java
i <= array.length
```

when accessing array indexes.

Usually use:

```java
i < array.length
```

---

### Mistake 3

Thinking index `5` exists because the array length is `5`.

Remember:

```text
length = 5
last index = 4
```

---

### Mistake 4

Thinking negative values cause this exception.

This is valid:

```java
int[] a = {-10, -20};
```

The values are negative, but the indexes are valid.

---

# 🧒 34. Important Rules

Remember these rules:

### Rule 1

Array indexes start from `0`.

### Rule 2

The last valid index is:

```text
array.length - 1
```

### Rule 3

An index equal to `array.length` is invalid.

For example:

```text
length = 5
index = 5
```

is invalid.

### Rule 4

A negative index is invalid.

Example:

```java
array[-1]
```

### Rule 5

Accessing an invalid index can cause:

```text
ArrayIndexOutOfBoundsException
```

### Rule 6

The exception is a runtime exception.

### Rule 7

`try-catch` can be used to handle it.

---

# 🧒 35. Complete Mental Picture

Suppose:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

Think:

```text
                    numbers
                       ↓
        ┌────┬────┬────┬────┬────┐
        │ 10 │ 20 │ 30 │ 40 │ 50 │
        └────┴────┴────┴────┴────┘
          0    1    2    3    4
          ↑                   ↑
       first              last valid
       index                 index
```

If you request:

```text
numbers[0]
```

✅ Valid

```text
numbers[2]
```

✅ Valid

```text
numbers[4]
```

✅ Valid

```text
numbers[5]
```

❌ Invalid

```text
numbers[-1]
```

❌ Invalid

---

# 🧒 36. Lifetime Memory Summary

Remember this story:

```text
Create an array
      ↓
int[] numbers = new int[5]
      ↓
Array has 5 elements
      ↓
Indexes start at 0
      ↓
Valid indexes are 0, 1, 2, 3, 4
      ↓
Try to access an invalid index
      ↓
Example: numbers[5]
      ↓
Index 5 does not exist
      ↓
ArrayIndexOutOfBoundsException
      ↓
Exception object created
      ↓
Runtime System receives it
      ↓
Handler searched
      ↓
If catch exists → catch handles it
      ↓
Program can continue
```

### 🧠 The one sentence to remember forever:

> **`ArrayIndexOutOfBoundsException` occurs when we try to access an array using an index that does not exist, such as accessing index `5` in an array whose valid indexes are `0` to `4`.**
