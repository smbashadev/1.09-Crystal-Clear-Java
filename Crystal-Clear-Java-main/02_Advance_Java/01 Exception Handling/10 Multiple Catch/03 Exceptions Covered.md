# 🧒 10.3 Exceptions Covered

### 1. The Basic Idea

Java has many different types of exceptions.

Each exception describes a particular kind of problem.

In this topic, we are focusing on three important exceptions:

```text
NegativeArraySizeException
InputMismatchException
ArrayIndexOutOfBoundsException
```

They happen in different situations, so understanding the difference between them is very important.

---

### 2. What Is `NegativeArraySizeException`?

`NegativeArraySizeException` occurs when we try to create an array with a **negative size**.

For example:

```java
int[] numbers = new int[-5];
```

An array cannot have:

```text
-5 elements
```

because the size of an array must be a valid non-negative size.

Java therefore produces:

```text
NegativeArraySizeException
```

---

### 3. Simple Real-World Example

Imagine asking a shopkeeper:

> "Give me a box containing -5 chocolates."

That does not make sense.

A box can contain:

```text
0 chocolates
5 chocolates
10 chocolates
```

but not:

```text
-5 chocolates
```

Similarly, Java cannot create an array containing a negative number of elements.

---

### 4. Simple Java Example

```java
class Demo {

    public static void main(String[] args) {

        int[] numbers = new int[-5];

        System.out.println("Array created");

    }
}
```

The program reaches:

```java
new int[-5]
```

Java cannot create this array.

Therefore:

```text
NegativeArraySizeException
```

occurs.

---

### 5. Understanding Array Size

Suppose:

```java
int[] numbers = new int[5];
```

This creates an array with 5 positions.

The positions are:

```text
Index:   0   1   2   3   4
         ↓   ↓   ↓   ↓   ↓
Elements  _   _   _   _   _
```

The size is `5`.

But:

```java
int[] numbers = new int[-5];
```

asks Java to create an array with a negative size.

That is invalid.

---

### 6. What Is `InputMismatchException`?

`InputMismatchException` can occur when we use `Scanner` to read a particular type of input, but the user provides an incompatible type.

For example:

```java
int number = sc.nextInt();
```

Here Java expects an integer.

If the user enters:

```text
ten
```

the input does not match the expected integer type.

Java can produce:

```text
InputMismatchException
```

---

### 7. Simple Real-World Example

Imagine a form asking:

```text
Enter your age:
```

The computer expects:

```text
25
```

But someone enters:

```text
twenty five
```

If the system is specifically expecting a numeric value, it cannot directly treat that text as an integer.

This is similar to what happens with `Scanner.nextInt()`.

---

### 8. Simple Java Example

```java
import java.util.Scanner;

class Demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");

        int number = sc.nextInt();

        System.out.println("Number = " + number);

    }
}
```

If the user enters:

```text
25
```

the input is valid.

If the user enters:

```text
ten
```

an `InputMismatchException` can occur.

---

### 9. Understanding `Scanner`

`Scanner` is used to receive input.

For example:

```java
Scanner sc = new Scanner(System.in);
```

creates a Scanner object.

Then:

```java
sc.nextInt();
```

asks the Scanner to read an integer.

The important point is:

```text
nextInt()
   ↓
expects integer input
```

So:

```text
25 → valid
10 → valid
-5 → valid integer
ten → mismatch
```

---

### 10. What Is `ArrayIndexOutOfBoundsException`?

`ArrayIndexOutOfBoundsException` occurs when we try to access an array using an index that does not exist.

For example:

```java
int[] numbers = {10, 20, 30};
```

This array has three elements.

Its valid indexes are:

```text
0
1
2
```

If we try:

```java
numbers[5]
```

index `5` does not exist.

Java therefore produces:

```text
ArrayIndexOutOfBoundsException
```

---

### 11. Simple Real-World Example

Imagine a classroom with three students sitting in seats:

```text
Seat 0 → Student A
Seat 1 → Student B
Seat 2 → Student C
```

If someone says:

> "Bring the student sitting in seat 5."

There is no seat 5 in this classroom.

The requested position does not exist.

An array works similarly.

---

### 12. Simple Java Example

```java
class Demo {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30};

        System.out.println(numbers[5]);

    }
}
```

The array contains:

```text
Index 0 → 10
Index 1 → 20
Index 2 → 30
```

But the program asks for:

```java
numbers[5]
```

There is no index `5`.

Therefore:

```text
ArrayIndexOutOfBoundsException
```

occurs.

---

### 13. Understanding the Three Exceptions

Now compare the three problems.

```text
NegativeArraySizeException
        ↓
Trying to CREATE an array with negative size
```

```text
InputMismatchException
        ↓
Providing input that does not match the expected type
```

```text
ArrayIndexOutOfBoundsException
        ↓
Trying to ACCESS an invalid array index
```

Each exception describes a different mistake.

---

### 14. Creation vs Access

This difference is extremely important.

With:

```java
int[] numbers = new int[-5];
```

the problem occurs while **creating the array**.

Therefore:

```text
NegativeArraySizeException
```

With:

```java
numbers[5]
```

the problem occurs while **accessing the array**.

Therefore:

```text
ArrayIndexOutOfBoundsException
```

Remember:

```text
Negative size → Array creation problem
Invalid index → Array access problem
```

---

### 15. Input Example

Consider:

```java
Scanner sc = new Scanner(System.in);

int number = sc.nextInt();
```

The program expects:

```text
integer
```

If the user enters:

```text
100
```

Java can store it in the integer variable.

If the user enters:

```text
one hundred
```

the input does not match the expected integer format.

This can result in:

```text
InputMismatchException
```

---

### 16. Multiple Catch Example

These exceptions can be handled separately.

```java
try {

    // risky code

}
catch (NegativeArraySizeException e) {

    System.out.println("Array size cannot be negative");

}
catch (InputMismatchException e) {

    System.out.println("Please enter the correct input type");

}
catch (ArrayIndexOutOfBoundsException e) {

    System.out.println("Invalid array index");

}
catch (Exception e) {

    System.out.println("Some other exception occurred");

}
```

Here we have:

```text
3 specific exception handlers
        ↓
1 general exception handler
```

---

### 17. Why Separate Catch Blocks?

Suppose the user makes an array-size mistake.

We want to say:

```text
Array size cannot be negative
```

If the user enters invalid input:

```text
Please enter the correct input type
```

If the user accesses an invalid index:

```text
Invalid array index
```

Each message explains the actual problem.

This is much better than displaying the same message for every exception.

---

### 18. Catch Block Order

The specific exception handlers are placed before the general handler.

Correct:

```java
catch (NegativeArraySizeException e) {

}

catch (InputMismatchException e) {

}

catch (ArrayIndexOutOfBoundsException e) {

}

catch (Exception e) {

}
```

The general:

```java
catch (Exception e)
```

comes at the end.

---

### 19. Why `Exception` Comes Last

`Exception` is a general type.

The other three are more specific exception types.

Think of:

```text
Exception
   ↓
Large category
```

while:

```text
NegativeArraySizeException
InputMismatchException
ArrayIndexOutOfBoundsException
```

represent more specific problems.

Therefore:

```text
Specific handlers
       ↓
General handler
```

---

### 20. Exception 1 — Negative Array Size Flow

Consider:

```java
int[] numbers = new int[-5];
```

Execution:

```text
Program starts
      ↓
Array creation requested
      ↓
Size = -5
      ↓
Invalid array size
      ↓
NegativeArraySizeException
      ↓
Matching catch block
      ↓
Error message displayed
```

The problem happens during **array creation**.

---

### 21. Exception 2 — Input Mismatch Flow

Consider:

```java
int number = sc.nextInt();
```

User enters:

```text
ten
```

Execution:

```text
Program starts
      ↓
Scanner asks for integer
      ↓
User enters "ten"
      ↓
Input does not match integer
      ↓
InputMismatchException
      ↓
Matching catch block
      ↓
Input error message
```

The problem happens during **input reading**.

---

### 22. Exception 3 — Invalid Array Index Flow

Consider:

```java
int[] numbers = {10, 20, 30};

System.out.println(numbers[5]);
```

Execution:

```text
Array created
      ↓
Valid indexes = 0, 1, 2
      ↓
Program requests index 5
      ↓
Index 5 does not exist
      ↓
ArrayIndexOutOfBoundsException
      ↓
Matching catch block
      ↓
Error message
```

The problem happens during **array access**.

---

### 23. Understanding Valid and Invalid Array Indexes

For:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

there are five elements.

Valid indexes:

```text
0
1
2
3
4
```

Invalid indexes include:

```text
5
6
10
-1
```

Trying to access an invalid index can produce an array-index exception.

---

### 24. Array Size and Index Are Different

Do not confuse:

```text
array size
```

with:

```text
array index
```

For:

```java
int[] numbers = new int[5];
```

the:

```text
size = 5
```

but the highest valid index is:

```text
4
```

because indexes begin at `0`.

Therefore:

```text
Size = 5
Highest index = 4
```

This is an important Java rule.

---

### 25. Negative Size vs Negative Index

These are different situations.

Array creation:

```java
new int[-5]
```

can cause:

```text
NegativeArraySizeException
```

Array access:

```java
numbers[-1]
```

can cause:

```text
ArrayIndexOutOfBoundsException
```

So remember:

```text
Negative size
     ↓
NegativeArraySizeException
```

```text
Invalid index
     ↓
ArrayIndexOutOfBoundsException
```

---

### 26. Understanding the Word "Mismatch"

The word **mismatch** means that two things do not agree.

For example:

```text
Expected → integer
Received → text
```

There is a mismatch.

Therefore:

```text
InputMismatchException
```

can occur.

The important idea is:

```text
Expected input type ≠ Actual input type
```

---

### 27. Real-World Application

Imagine a banking application.

The application may ask:

```text
Enter account number:
```

and expect a numeric value.

If the user provides an incompatible input, the application needs to deal with it properly.

Similarly, an application may work with arrays containing customer information.

Trying to access a position that does not exist is another possible programming error.

And trying to create an array with a negative size is also invalid.

Exception handling allows the application to deal with such situations in a controlled manner.

---

### 28. One Program Showing Different Handlers

```java
import java.util.InputMismatchException;
import java.util.Scanner;

class Demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Enter array size:");
            int size = sc.nextInt();

            int[] numbers = new int[size];

            System.out.println("Enter index:");
            int index = sc.nextInt();

            System.out.println(numbers[index]);

        }
        catch (NegativeArraySizeException e) {

            System.out.println("Array size cannot be negative");

        }
        catch (InputMismatchException e) {

            System.out.println("Please enter numbers only");

        }
        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Invalid array index");

        }
        catch (Exception e) {

            System.out.println("Some other exception occurred");

        }

        System.out.println("Program Ends");
    }
}
```

---

### 29. Example Data — Negative Size

Input:

```text
Enter array size:
-5
```

The statement:

```java
int[] numbers = new int[size];
```

becomes:

```java
int[] numbers = new int[-5];
```

This produces:

```text
NegativeArraySizeException
```

The corresponding catch executes:

```text
Array size cannot be negative
```

Then:

```text
Program Ends
```

is displayed.

---

### 30. Example Data — Invalid Input

Suppose the user enters:

```text
Enter array size:
ten
```

The statement:

```java
sc.nextInt()
```

expects an integer.

But the user entered text.

Therefore:

```text
InputMismatchException
```

occurs.

The corresponding catch displays:

```text
Please enter numbers only
```

---

### 31. Example Data — Invalid Index

Suppose:

```text
Enter array size:
3
Enter index:
5
```

The array has:

```text
Index 0
Index 1
Index 2
```

But the program requests:

```text
Index 5
```

Therefore:

```text
ArrayIndexOutOfBoundsException
```

occurs.

The message becomes:

```text
Invalid array index
```

---

### 32. Example Data — Valid Execution

Suppose:

```text
Enter array size:
3
Enter index:
1
```

The array contains three positions:

```text
0
1
2
```

Index `1` is valid.

Therefore, no exception occurs from the array index.

The program continues normally.

---

### 33. Common Confusions

Remember these three questions:

```text
Was the array size negative?
        ↓
NegativeArraySizeException
```

```text
Was the input of the wrong expected type?
        ↓
InputMismatchException
```

```text
Was an invalid array index accessed?
        ↓
ArrayIndexOutOfBoundsException
```

The easiest way to distinguish them is to look at **where the problem happened**.

---

### 34. Quick Comparison

| Exception                        | Problem                            | Example                            |
| -------------------------------- | ---------------------------------- | ---------------------------------- |
| `NegativeArraySizeException`     | Negative array size                | `new int[-5]`                      |
| `InputMismatchException`         | Input does not match expected type | `nextInt()` with `ten`             |
| `ArrayIndexOutOfBoundsException` | Invalid array index                | `numbers[5]` when only `0–2` exist |

---

### 35. Memory Trick

Use this simple memory pattern:

```text
SIZE → NegativeArraySizeException
INPUT → InputMismatchException
INDEX → ArrayIndexOutOfBoundsException
```

Or remember:

> **Wrong SIZE → Negative Array Size**
> **Wrong INPUT → Input Mismatch**
> **Wrong INDEX → Array Index Out of Bounds**

This makes the three exceptions much easier to remember.

---

### 36. Complete Lifetime Understanding

The three exceptions represent three different situations:

```text
                EXCEPTION
                    ↓
          ┌─────────┼─────────┐
          ↓         ↓         ↓
        SIZE      INPUT      INDEX
          ↓         ↓         ↓
     Negative     Wrong     Invalid
       size        type      position
          ↓         ↓         ↓
 NegativeArray  Input       ArrayIndex
 SizeException  Mismatch    OutOfBounds
                Exception    Exception
```

### Final memory picture

```text
new int[-5]
     ↓
NegativeArraySizeException
     ↓
Array creation problem


sc.nextInt()
     ↓
User enters "ten"
     ↓
InputMismatchException
     ↓
Input problem


numbers[5]
     ↓
Index does not exist
     ↓
ArrayIndexOutOfBoundsException
     ↓
Array access problem
```

The core understanding is:

> **NegativeArraySizeException is about creating an array with an invalid negative size. InputMismatchException is about receiving input that does not match what the program expects. ArrayIndexOutOfBoundsException is about accessing an array position that does not exist.**
