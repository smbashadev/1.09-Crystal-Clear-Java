# 🧒 9.3 InputMismatchException

## 1. What Is `InputMismatchException`?

`InputMismatchException` is a runtime exception that occurs when a program expects **one type of input**, but the user provides **another type of input that does not match what the program is expecting**.

For example, suppose Java expects an integer:

```java
int number = sc.nextInt();
```

The program expects something like:

```text
10
20
100
```

But the user enters:

```text
ten
```

`ten` is not an integer.

Therefore Java throws:

```text
InputMismatchException
```

---

# 🧒 2. What Does "Input" Mean?

**Input** means information given to a program.

For example, if a program asks:

```text
Enter your age:
```

and you type:

```text
25
```

then `25` is the input.

Another program might ask:

```text
Enter your name:
```

and you type:

```text
Basha
```

Here:

```text
Basha
```

is the input.

So:

```text
User
 ↓
Provides data
 ↓
Program receives data
```

---

# 🧒 3. What Does "Mismatch" Mean?

**Mismatch** means:

> Two things do not match.

For example:

```text
Expected → number
Received → word
```

They do not match.

Therefore:

```text
Expected input type
        ≠
Actual input type
```

This is called a **mismatch**.

---

# 🧒 4. Understanding Your Examples

Your notes contain:

```text
ten
one
three
```

These are words.

For example:

```text
ten
```

is not an integer written in numeric form.

The numeric form is:

```text
10
```

Similarly:

```text
one
```

is a word.

The numeric form is:

```text
1
```

And:

```text
three
```

is a word.

The numeric form is:

```text
3
```

If Java is expecting an integer using `nextInt()`, entering these words causes a mismatch.

---

# 🧒 5. `Scanner`

To receive keyboard input in Java, we commonly use the `Scanner` class.

Example:

```java
Scanner sc = new Scanner(System.in);
```

Here:

```text
Scanner
   ↓
Java class used to read input

sc
   ↓
Reference variable

System.in
   ↓
Keyboard input
```

---

# 🧒 6. Understanding `System.in`

Consider:

```java
Scanner sc = new Scanner(System.in);
```

`System` is a Java class.

`in` represents the standard input stream.

For beginner understanding:

```text
Keyboard
   ↓
System.in
   ↓
Scanner
   ↓
Your program
```

So when you type something on the keyboard, `Scanner` can read it.

---

# 🧒 7. Understanding `nextInt()`

Consider:

```java
int number = sc.nextInt();
```

`nextInt()` tells `Scanner`:

> "Read the next input as an integer."

For example, if the user enters:

```text
10
```

Java can read it as an integer.

```text
10
 ↓
nextInt()
 ↓
int
 ↓
number
```

---

# 🧒 8. Valid Input

Suppose we write:

```java
int number = sc.nextInt();
```

Valid integer inputs include:

```text
1
10
25
100
-5
0
```

These are numeric integer values.

For example:

```text
User enters → 10
Expected    → integer
Result      → successful
```

No `InputMismatchException` occurs.

---

# 🧒 9. Invalid Input

Now suppose:

```java
int number = sc.nextInt();
```

and the user enters:

```text
ten
```

The program is expecting:

```text
integer
```

but receives:

```text
word
```

Therefore:

```text
Expected → integer
Received → ten
           ↓
       Mismatch
           ↓
InputMismatchException
```

---

# 🧒 10. Simple Example

```java
import java.util.Scanner;

class Demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");

        int number = sc.nextInt();

        System.out.println("You entered: " + number);
    }
}
```

Suppose the user enters:

```text
10
```

Output:

```text
Enter a number:
10
You entered: 10
```

This is normal execution.

---

# 🧒 11. What If the User Enters `ten`?

The same program:

```java
import java.util.Scanner;

class Demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");

        int number = sc.nextInt();

        System.out.println("You entered: " + number);
    }
}
```

User enters:

```text
ten
```

But:

```java
sc.nextInt()
```

expects an integer.

Therefore:

```text
ten
 ↓
not a valid integer for nextInt()
 ↓
InputMismatchException
```

---

# 🧒 12. Why Does the Exception Occur?

Let's look carefully:

```java
int number = sc.nextInt();
```

The variable:

```text
number
```

is an `int`.

Therefore the program expects an integer.

The method:

```text
nextInt()
```

also expects integer input.

But the user gives:

```text
ten
```

Java cannot convert that input into the required integer through `nextInt()`.

Therefore the input does not match the expected type.

---

# 🧒 13. Runtime Flow

The complete flow is:

```text
Program starts
      ↓
Scanner created
      ↓
Program asks for number
      ↓
User enters input
      ↓
Scanner.nextInt()
      ↓
Java expects integer
      ↓
User enters "ten"
      ↓
Input does not match
      ↓
InputMismatchException
```

---

# 🧒 14. Exception Object

When the mismatch occurs, Java creates an exception object associated with:

```text
InputMismatchException
```

Conceptually:

```text
Invalid input
     ↓
Exception object created
     ↓
Runtime System receives exception
```

The Runtime System then looks for an appropriate exception handler.

---

# 🧒 15. Runtime System

The simplified process is:

```text
Scanner.nextInt()
       ↓
Invalid input
       ↓
InputMismatchException object
       ↓
Runtime System
       ↓
Search for handler
```

If a suitable `catch` exists:

```text
Runtime System
      ↓
catch
      ↓
Exception handled
```

If no handler exists:

```text
Runtime System
      ↓
No handler
      ↓
Default Exception Handler
      ↓
Abnormal termination
```

---

# 🧒 16. Program Without `try-catch`

```java
import java.util.Scanner;

class Demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a number:");

        int number = sc.nextInt();

        System.out.println("Program Ends");
    }
}
```

Suppose the user enters:

```text
ten
```

Flow:

```text
main()
 ↓
Scanner
 ↓
nextInt()
 ↓
Input = ten
 ↓
Expected integer
 ↓
Mismatch
 ↓
InputMismatchException
 ↓
No handler
 ↓
Default Exception Handler
 ↓
Abnormal termination
```

The statement:

```java
System.out.println("Program Ends");
```

is not reached through normal execution.

---

# 🧒 17. Handling `InputMismatchException`

We can handle it using `try-catch`.

```java
import java.util.Scanner;
import java.util.InputMismatchException;

class Demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Enter a number:");

            int number = sc.nextInt();

            System.out.println("You entered: " + number);

        }
        catch (InputMismatchException e) {

            System.out.println("Invalid input. Please enter a number.");
        }

        System.out.println("Program Ends");
    }
}
```

---

# 🧒 18. Understanding the `try` Block

The potentially exception-producing statement is:

```java
int number = sc.nextInt();
```

So we place it inside:

```java
try {

    int number = sc.nextInt();

}
```

The program attempts to read the user's input.

---

# 🧒 19. Understanding the `catch` Block

The handler is:

```java
catch (InputMismatchException e)
```

This means:

> If `InputMismatchException` occurs in the associated `try` block, this `catch` block can handle it.

The exception object is represented by:

```text
e
```

---

# 🧒 20. Valid Input With `try-catch`

Suppose the user enters:

```text
10
```

Flow:

```text
try
 ↓
nextInt()
 ↓
10
 ↓
Valid integer
 ↓
number = 10
 ↓
"You entered: 10"
 ↓
catch skipped
 ↓
Program Ends
```

Output:

```text
Enter a number:
10
You entered: 10
Program Ends
```

---

# 🧒 21. Invalid Input `ten`

Suppose the user enters:

```text
ten
```

Flow:

```text
try
 ↓
nextInt()
 ↓
ten
 ↓
Not an integer
 ↓
InputMismatchException
 ↓
catch
 ↓
Invalid input message
 ↓
Program Ends
```

Output:

```text
Enter a number:
ten
Invalid input. Please enter a number.
Program Ends
```

---

# 🧒 22. Your Example `one`

Suppose the program expects:

```java
int number = sc.nextInt();
```

and the user enters:

```text
one
```

Java sees:

```text
Expected → integer
Received → one
```

Therefore:

```text
one
 ↓
Input mismatch
 ↓
InputMismatchException
```

If the user instead enters:

```text
1
```

then:

```text
Expected → integer
Received → 1
```

They match.

No exception occurs.

---

# 🧒 23. Your Example `three`

Suppose:

```java
int number = sc.nextInt();
```

and the user enters:

```text
three
```

Java expects an integer.

But:

```text
three
```

is a word.

Therefore:

```text
three
 ↓
Does not match integer input
 ↓
InputMismatchException
```

Entering:

```text
3
```

would be valid.

---

# 🧒 24. Word vs Number

This distinction is very important:

| User enters | Meaning | `nextInt()` |
| ----------- | ------- | ----------- |
| `10`        | Integer | ✅ Valid     |
| `1`         | Integer | ✅ Valid     |
| `3`         | Integer | ✅ Valid     |
| `ten`       | Word    | ❌ Mismatch  |
| `one`       | Word    | ❌ Mismatch  |
| `three`     | Word    | ❌ Mismatch  |

The issue is not what the word **means**.

For example:

```text
ten
```

means the number `10` to a human.

But `nextInt()` expects an input written as an integer token, such as:

```text
10
```

So:

```text
ten ≠ 10
```

for `nextInt()` input.

---

# 🧒 25. Complete Program With User Input

```java
import java.util.Scanner;
import java.util.InputMismatchException;

class Demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your first number:");

        try {

            int first = sc.nextInt();

            System.out.println("First number: " + first);

        }
        catch (InputMismatchException e) {

            System.out.println("Invalid input");
        }

        System.out.println("Program Ends");
    }
}
```

If input is:

```text
10
```

output:

```text
Enter your first number:
10
First number: 10
Program Ends
```

If input is:

```text
ten
```

output:

```text
Enter your first number:
ten
Invalid input
Program Ends
```

---

# 🧒 26. Understanding the `Scanner` Object

This statement:

```java
Scanner sc = new Scanner(System.in);
```

has several parts.

```text
Scanner
 ↓
Class name

sc
 ↓
Reference variable

new
 ↓
Creates Scanner object

Scanner(System.in)
 ↓
Scanner receives input from standard input
```

The object is then accessed through:

```text
sc
```

---

# 🧒 27. Understanding `nextInt()`

When we write:

```java
sc.nextInt();
```

we are calling a method of the `Scanner` object.

The method's purpose is to read the next input as an integer.

Think of it as:

```text
Scanner
   ↓
"Give me the next integer."
```

If the input matches:

```text
25
```

it works.

If the input is:

```text
twenty-five
```

the input does not match what `nextInt()` expects.

---

# 🧒 28. Important: InputMismatchException Is Not Only for Words

A mismatch can happen whenever the input does not match the type expected by the Scanner method.

For example:

```java
double value = sc.nextDouble();
```

expects a decimal number.

An incompatible input can cause `InputMismatchException`.

Similarly, different `Scanner` methods expect different input formats.

The important rule is:

```text
Scanner method expectation
          ↓
Compare with input
          ↓
If input doesn't match
          ↓
InputMismatchException
```

---

# 🧒 29. `nextInt()` and Negative Numbers

A negative integer is actually valid input for `nextInt()`.

For example:

```text
-5
```

is an integer.

Therefore:

```java
int number = sc.nextInt();
```

can read:

```text
-5
```

without `InputMismatchException`.

This is different from:

```text
ten
```

because `ten` is not written as an integer.

So:

```text
-5   → valid integer
ten  → mismatch for nextInt()
```

---

# 🧒 30. InputMismatchException vs NegativeArraySizeException

These exceptions represent completely different problems.

### `NegativeArraySizeException`

Problem:

```java
new int[-5]
```

The array size is invalid.

### `InputMismatchException`

Problem:

```java
sc.nextInt();
```

The user provides input that does not match the expected input type/format.

For example:

```text
ten
```

when an integer is expected.

Memory:

```text
Wrong array size
       ↓
NegativeArraySizeException
```

```text
Wrong input type/format
       ↓
InputMismatchException
```

---

# 🧒 31. InputMismatchException Flow With RTS

```text
User
 ↓
Enters "ten"
 ↓
Scanner
 ↓
nextInt()
 ↓
Expects integer
 ↓
Input doesn't match
 ↓
InputMismatchException object
 ↓
Runtime System
 ↓
Checks current method
 ↓
Checks for handler
```

If handler exists:

```text
catch
 ↓
Handle exception
 ↓
Continue program
```

If handler does not exist:

```text
Default Exception Handler
 ↓
Program terminates abnormally
```

---

# 🧒 32. Real-Life Example

Imagine a teacher asks:

> "Tell me your age as a number."

The student says:

> "ten"

A human teacher understands that `ten` means `10`.

But imagine a machine that has been instructed:

> "Accept only digits."

It receives:

```text
ten
```

The input doesn't match the required format.

That's similar to:

```java
sc.nextInt();
```

when the user enters:

```text
ten
```

Java expects an integer input, so the input mismatches.

---

# 🧒 33. Common Beginner Mistakes

### Mistake 1

Thinking:

```text
ten
```

is automatically converted to:

```text
10
```

by `nextInt()`.

It isn't.

---

### Mistake 2

Thinking all negative numbers cause `InputMismatchException`.

They don't.

```text
-5
```

is a valid integer.

---

### Mistake 3

Thinking `Scanner` itself is the exception.

It isn't.

`Scanner` is the class used to read input.

The exception is:

```text
InputMismatchException
```

---

### Mistake 4

Thinking `catch` prevents invalid input from being entered.

The user can still enter invalid input.

`catch` handles the exception **after it occurs**.

---

### Mistake 5

Thinking `InputMismatchException` is a compile-time error.

It is a **runtime exception**.

---

# 🧒 34. Important Rules

### Rule 1

`InputMismatchException` occurs at runtime.

### Rule 2

It is commonly associated with `Scanner` input methods when the supplied input does not match what the method expects.

### Rule 3

`nextInt()` expects integer input.

### Rule 4

Entering:

```text
10
```

for `nextInt()` is valid.

### Rule 5

Entering:

```text
ten
```

for `nextInt()` causes an input mismatch.

### Rule 6

Entering:

```text
one
```

instead of:

```text
1
```

does not make `nextInt()` receive the integer `1`.

### Rule 7

Entering:

```text
three
```

instead of:

```text
3
```

causes a mismatch when `nextInt()` is being used.

### Rule 8

`try-catch` can handle the exception.

### Rule 9

The exception object can be received using:

```java
catch (InputMismatchException e)
```

### Rule 10

After the exception is handled, execution can continue with the statements following the `try-catch`.

---

# 🧒 35. Complete Execution Diagram

```text
                    Program
                       ↓
                  Scanner created
                       ↓
                 Ask for number
                       ↓
                  User enters
                       ↓
                Scanner.nextInt()
                       ↓
              Is input an integer?
                  ↙         ↘
                YES          NO
                 ↓            ↓
             Read input    Exception
                 ↓            ↓
          Normal execution  InputMismatchException
                              ↓
                       Exception object
                              ↓
                       Runtime System
                              ↓
                       Is handler present?
                         ↙           ↘
                       YES            NO
                        ↓              ↓
                      catch       Default Handler
                        ↓              ↓
                  Handle problem   Abnormal
                        ↓          termination
                        ↓
                  Program continues
```

---

# 🧒 36. Lifetime Memory Summary

Remember this simple story:

```text
Program asks:
"Enter a number"
        ↓
Scanner uses nextInt()
        ↓
Java expects an integer
        ↓
User enters:
ten
        ↓
"ten" is not an integer token
        ↓
Input does not match
        ↓
InputMismatchException
        ↓
Exception object created
        ↓
Runtime System receives it
        ↓
Handler searched
        ↓
catch handles exception
        ↓
Program continues
```

Your three examples:

```text
ten
 ↓
Expected integer
 ↓
Mismatch
 ↓
InputMismatchException
```

```text
one
 ↓
Expected integer
 ↓
Mismatch
 ↓
InputMismatchException
```

```text
three
 ↓
Expected integer
 ↓
Mismatch
 ↓
InputMismatchException
```

But:

```text
10
 ↓
Expected integer
 ↓
Matches
 ↓
Normal execution
```

```text
1
 ↓
Expected integer
 ↓
Matches
 ↓
Normal execution
```

```text
3
 ↓
Expected integer
 ↓
Matches
 ↓
Normal execution
```

### 🧠 Remember forever:

> **`InputMismatchException` occurs when the input supplied to a `Scanner` method does not match the type or format that the method expects—for example, entering `ten` when `nextInt()` is expecting an integer such as `10`.**
