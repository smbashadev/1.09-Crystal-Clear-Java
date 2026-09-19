# 🧒 10.4 Output Scenarios

### 1. Understanding the Output Scenarios

The three scenarios show how a Java program can face **different input or array-related problems** and provide a suitable message to the user instead of allowing the program to terminate abruptly.

The three situations are:

```text
Scenario 1 → Negative array size
Scenario 2 → Invalid input type
Scenario 3 → Invalid array index
```

Each situation needs a different explanation and output.

---

### 2. Scenario 1 — User Enters `-5`

Suppose the program asks the user to enter an array size:

```text
Enter array size:
-5
```

The user has entered:

```text
-5
```

A negative value cannot be used as an array size.

---

### 3. Why `-5` Is Invalid

An array size represents **how many elements the array should contain**.

For example:

```text
5 → 5 elements
10 → 10 elements
3 → 3 elements
```

But:

```text
-5 → negative number of elements
```

does not make sense.

Therefore, the program should not allow a negative array size.

---

### 4. Exception Behind Scenario 1

If Java tries:

```java
int[] arr = new int[-5];
```

Java produces:

```text
NegativeArraySizeException
```

The problem happens while **creating the array**.

```text
-5
 ↓
Array creation
 ↓
Invalid negative size
 ↓
NegativeArraySizeException
```

---

### 5. Suitable User Message

Instead of allowing an exception message to confuse the user, the program can display:

```text
Please enter positive number
```

This tells the user what needs to be corrected.

The flow becomes:

```text
User enters -5
       ↓
Invalid array size
       ↓
Handle exception
       ↓
Please enter positive number
```

---

### 6. Scenario 1 Example

```java
try {

    int size = sc.nextInt();

    int[] arr = new int[size];

}
catch (NegativeArraySizeException e) {

    System.out.println("Please enter positive number");

}
```

Here, the risky array creation is inside `try`.

If the user enters `-5`, the `catch` block handles the exception.

---

### 7. Scenario 1 Output

Input:

```text
-5
```

Output:

```text
Please enter positive number
```

The important idea is:

```text
Negative size
      ↓
NegativeArraySizeException
      ↓
Please enter positive number
```

---

### 8. Scenario 2 — User Enters `ten`

Now consider another situation.

The program asks:

```text
Enter a number:
```

The program expects a numeric value.

But the user enters:

```text
ten
```

The word `ten` is not an integer value that `nextInt()` can read.

---

### 9. Why `ten` Is Invalid

Suppose the program contains:

```java
int number = sc.nextInt();
```

`nextInt()` expects an integer.

Valid examples:

```text
10
25
100
-5
```

But:

```text
ten
one
three
```

are words, not integer input.

Therefore, the input does not match what `nextInt()` expects.

---

### 10. Exception Behind Scenario 2

When incompatible input is supplied to `nextInt()`, Java can produce:

```text
InputMismatchException
```

The flow is:

```text
Program expects number
        ↓
User enters "ten"
        ↓
Input type does not match
        ↓
InputMismatchException
```

---

### 11. Suitable User Message

Instead of displaying a technical exception name, the program can tell the user:

```text
Please enter numeric value
```

This is easier for an ordinary user to understand.

---

### 12. Scenario 2 Example

```java
try {

    int number = sc.nextInt();

}
catch (InputMismatchException e) {

    System.out.println("Please enter numeric value");

}
```

If the user enters:

```text
ten
```

the `catch` block handles the exception.

---

### 13. Scenario 2 Output

Input:

```text
ten
```

Output:

```text
Please enter numeric value
```

The complete flow is:

```text
ten
 ↓
nextInt()
 ↓
InputMismatchException
 ↓
catch block
 ↓
Please enter numeric value
```

---

### 14. Scenario 3 — Array Size `3`

Now consider an array.

The user enters:

```text
Array size = 3
```

The program creates:

```java
int[] arr = new int[3];
```

The array contains three positions.

---

### 15. Understanding Array Length

When:

```java
int[] arr = new int[3];
```

is created, the array length is:

```text
3
```

Therefore:

```java
arr.length
```

returns:

```text
3
```

So:

```text
Array size = 3
Array length = 3
```

---

### 16. Understanding the Indexes

Although the array length is `3`, the indexes start from `0`.

Therefore:

```text
Index 0
Index 1
Index 2
```

are valid.

There is no:

```text
Index 3
Index 4
Index 5
```

for this array.

The important rule is:

```text
Array length = 3
Highest valid index = 2
```

---

### 17. Why `arr[5]` Is Invalid

Suppose:

```java
int[] arr = new int[3];
```

Then:

```java
arr[5]
```

asks Java:

> "Give me the element stored at index 5."

But the array only has:

```text
0
1
2
```

Therefore, index `5` does not exist.

---

### 18. Exception Behind Scenario 3

Trying to access:

```java
arr[5]
```

when the array has length `3` can produce:

```text
ArrayIndexOutOfBoundsException
```

The flow is:

```text
Array length = 3
       ↓
Valid indexes = 0, 1, 2
       ↓
Program accesses arr[5]
       ↓
Index 5 does not exist
       ↓
ArrayIndexOutOfBoundsException
```

---

### 19. Suitable User Message

Instead of allowing the exception to terminate the program, the program can display:

```text
Please enter size >= 6
```

This tells the user that if they want to access:

```java
arr[5]
```

the array needs to have at least six positions.

---

### 20. Why Does Size Need to Be at Least `6`?

This is a very important point.

If we want:

```java
arr[5]
```

to be valid, the array must have indexes:

```text
0
1
2
3
4
5
```

That requires:

```text
6 elements
```

Therefore:

```text
arr[5]
 ↓
Required minimum length = 6
```

So:

```text
size >= 6
```

is required.

---

### 21. Scenario 3 Example

```java
try {

    int[] arr = new int[3];

    System.out.println(arr[5]);

}
catch (ArrayIndexOutOfBoundsException e) {

    System.out.println("Please enter size >= 6");

}
```

The array length is `3`.

The program tries to access index `5`.

The index does not exist.

Therefore, the catch block executes.

---

### 22. Scenario 3 Output

The program has:

```text
Array size = 3
Array length = 3
```

Then it tries:

```text
arr[5]
```

The result is:

```text
Please enter size >= 6
```

---

### 23. Understanding the Relationship Between Size and Index

For an array:

```java
int[] arr = new int[size];
```

the valid indexes are:

```text
0 through size - 1
```

For size `3`:

```text
0 through 2
```

For size `6`:

```text
0 through 5
```

Therefore, to access index `5`, the size must be at least `6`.

---

### 24. Scenario 3 With Size `6`

If:

```java
int[] arr = new int[6];
```

then:

```text
Index 0 → valid
Index 1 → valid
Index 2 → valid
Index 3 → valid
Index 4 → valid
Index 5 → valid
```

Therefore:

```java
arr[5]
```

works correctly.

There is no `ArrayIndexOutOfBoundsException` for that access.

---

### 25. Comparing All Three Scenarios

The three scenarios represent three different problems:

```text
Scenario 1
-5
 ↓
Negative array size
```

```text
Scenario 2
ten
 ↓
Wrong input type
```

```text
Scenario 3
arr[5] with length 3
 ↓
Invalid array index
```

Each requires different handling.

---

### 26. Exception-to-Message Relationship

```text
NegativeArraySizeException
        ↓
"Please enter positive number"
```

```text
InputMismatchException
        ↓
"Please enter numeric value"
```

```text
ArrayIndexOutOfBoundsException
        ↓
"Please enter size >= 6"
```

This is the main purpose of these output scenarios.

---

### 27. Complete Multiple Catch Example

```java
try {

    // risky code

}
catch (NegativeArraySizeException e) {

    System.out.println("Please enter positive number");

}
catch (InputMismatchException e) {

    System.out.println("Please enter numeric value");

}
catch (ArrayIndexOutOfBoundsException e) {

    System.out.println("Please enter size >= 6");

}
catch (Exception e) {

    System.out.println("Some other exception occurred");

}
```

Each exception has its own message.

The general `Exception` handler is kept at the end.

---

### 28. Why User-Friendly Messages Are Important

Technical names such as:

```text
NegativeArraySizeException
InputMismatchException
ArrayIndexOutOfBoundsException
```

are useful for programmers.

But an ordinary user may not understand them.

Therefore, applications usually provide messages such as:

```text
Please enter positive number
```

```text
Please enter numeric value
```

```text
Please enter size >= 6
```

The message tells the user what action to take.

---

### 29. Scenario 1 — Complete Flow

```text
User
 ↓
Enters -5
 ↓
Program tries to create array
 ↓
Negative size detected
 ↓
NegativeArraySizeException
 ↓
Matching catch block
 ↓
Please enter positive number
```

The user now knows that the entered size needs to be corrected.

---

### 30. Scenario 2 — Complete Flow

```text
User
 ↓
Enters "ten"
 ↓
Scanner expects integer
 ↓
Input type mismatch
 ↓
InputMismatchException
 ↓
Matching catch block
 ↓
Please enter numeric value
```

The user understands that a number must be entered.

---

### 31. Scenario 3 — Complete Flow

```text
Array size = 3
       ↓
Array length = 3
       ↓
Valid indexes = 0, 1, 2
       ↓
Program accesses arr[5]
       ↓
Index 5 is unavailable
       ↓
ArrayIndexOutOfBoundsException
       ↓
Matching catch block
       ↓
Please enter size >= 6
```

The user understands why the array size must be increased.

---

### 32. Important Rules

Remember these rules:

* An array size cannot be negative.
* `new int[-5]` can cause `NegativeArraySizeException`.
* `nextInt()` expects integer input.
* Incompatible input can cause `InputMismatchException`.
* Array indexes start from `0`.
* An array of length `3` has indexes `0`, `1`, and `2`.
* `arr[5]` requires an array length of at least `6`.
* Invalid array access can cause `ArrayIndexOutOfBoundsException`.
* Different exceptions can have different user-friendly messages.

---

### 33. Common Confusion

Do not confuse:

```text
Array size
```

with:

```text
Array index
```

For example:

```java
int[] arr = new int[3];
```

means:

```text
Size = 3
```

but:

```text
Valid indexes = 0, 1, 2
```

It does **not** mean that index `3` is valid.

Therefore:

```text
Size 3 → highest index 2
Size 6 → highest index 5
```

---

### 34. Quick Comparison

| Scenario | Input/Operation           | Problem               | Exception                        | User Message                 |
| -------- | ------------------------- | --------------------- | -------------------------------- | ---------------------------- |
| 1        | `-5`                      | Negative array size   | `NegativeArraySizeException`     | Please enter positive number |
| 2        | `ten`                     | Invalid numeric input | `InputMismatchException`         | Please enter numeric value   |
| 3        | Size `3`, access `arr[5]` | Invalid index         | `ArrayIndexOutOfBoundsException` | Please enter size >= 6       |

---

### 35. Memory Trick

Remember the three scenarios using:

```text
SIZE → INPUT → INDEX
```

```text
-5
 ↓
Wrong SIZE
 ↓
NegativeArraySizeException
```

```text
ten
 ↓
Wrong INPUT
 ↓
InputMismatchException
```

```text
arr[5] with size 3
 ↓
Wrong INDEX
 ↓
ArrayIndexOutOfBoundsException
```

And remember:

> **To access index 5, the array needs at least 6 positions.**

---

### 36. Complete Lifetime Understanding

The complete idea is:

```text
                 USER INPUT / OPERATION
                         ↓
              ┌──────────┼──────────┐
              ↓          ↓          ↓
             -5         ten       arr[5]
              ↓          ↓          ↓
         Wrong size  Wrong input  Wrong index
              ↓          ↓          ↓
       NegativeArray  Input       ArrayIndex
       SizeException  Mismatch    OutOfBounds
                      Exception    Exception
              ↓          ↓          ↓
       "Please enter  "Please enter  "Please enter
        positive       numeric        size >= 6"
        number"        value"
```

The three output scenarios teach an important exception-handling principle:

> **Do not simply tell the user that an exception happened. Give the user a clear message explaining what went wrong and, when possible, what they should do to correct it.**

For this topic, remember the three outputs exactly:

```text
-5
→ Please enter positive number

ten
→ Please enter numeric value

Array size 3 + arr[5]
→ Please enter size >= 6
```
