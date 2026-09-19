# 🧒 10.1 Multiple Catch

### 1. The Basic Idea

A Java program can face different problems while it is running.

For example:

```text
10 / 0
```

can cause an `ArithmeticException`.

If a program asks for a number:

```text
Enter number: ten
```

it can cause an `InputMismatchException`.

If a program tries:

```text
numbers[10]
```

when the array has only 3 elements, it can cause an `ArrayIndexOutOfBoundsException`.

These are **different problems**, so Java allows us to handle them separately using **multiple `catch` blocks**.

---

### 2. Understanding an Exception

An **exception** is a problem that occurs while a Java program is running and disturbs the normal flow of the program.

For example:

```java
int result = 10 / 0;
```

Java cannot perform integer division by zero.

So Java creates an exception object representing the problem.

```text
Normal execution
       ↓
10 / 0
       ↓
Problem occurs
       ↓
ArithmeticException
```

---

### 3. Why Do We Need Exception Handling?

Without exception handling, an exception can cause abnormal termination of the program.

For example:

```java
int a = 10;
int b = 0;

int result = a / b;

System.out.println("Program Ends");
```

The division causes an exception.

The statement:

```java
System.out.println("Program Ends");
```

will not be reached normally.

Exception handling allows us to deal with the problem and continue the program in a controlled way.

---

### 4. A Simple Real-World Example

Imagine a school office.

Different problems are handled by different people:

```text
Fee problem
    ↓
Accounts section
```

```text
ID card problem
    ↓
Administration section
```

```text
Exam problem
    ↓
Examination section
```

The problems are different, so the person handling each problem is also different.

Java works similarly:

```text
ArithmeticException
        ↓
ArithmeticException catch
```

```text
InputMismatchException
        ↓
InputMismatchException catch
```

This is the basic idea of **Multiple Catch**.

---

### 5. Connecting the Real World to Java

In Java:

```text
Problem
   ↓
Exception
   ↓
Find suitable handler
   ↓
Handle the problem
```

With multiple catch blocks:

```text
                 Exception
                     ↓
          ┌──────────┼──────────┐
          ↓          ↓          ↓
     Arithmetic    Input      Array
     Exception    Mismatch   Exception
          ↓          ↓          ↓
       catch 1     catch 2    catch 3
```

Each `catch` block is prepared for a particular type of exception.

---

### 6. What Is Multiple Catch?

**Multiple Catch** means using **more than one `catch` block with a `try` block**.

Example:

```java
try {
    // risky code
}
catch (ArithmeticException e) {
    // arithmetic problem
}
catch (InputMismatchException e) {
    // input problem
}
```

Here there are:

```text
1 try block
2 catch blocks
2 different exception types
```

Therefore, it is called **Multiple Catch**.

---

### 7. Understanding the `try` Block

`try` is a Java keyword.

We place code that may produce an exception inside the `try` block.

Example:

```java
try {
    int result = 10 / 0;
}
```

The risky statement is:

```java
int result = 10 / 0;
```

Because this statement can produce an exception, it is placed inside `try`.

Think of `try` as saying:

> "Java, try to execute this code. If a problem happens, look for a suitable handler."

---

### 8. Understanding the `catch` Block

`catch` is another Java keyword.

It is used to handle an exception.

Example:

```java
catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
```

This tells Java:

> "If the exception is an `ArithmeticException`, use this handler."

The code inside the catch block is executed when that exception is matched.

---

### 9. Understanding the Exception Class

Look at:

```java
catch (ArithmeticException e)
```

There are two important parts:

```text
ArithmeticException
        ↓
Exception class/type
```

and:

```text
e
↓
Reference variable
```

`ArithmeticException` tells Java what kind of exception this catch block is prepared to handle.

---

### 10. Understanding the `e` Reference

In:

```java
catch (ArithmeticException e)
```

`e` is a reference variable.

When Java catches an exception object, `e` refers to that object.

For example:

```java
catch (ArithmeticException e) {
    System.out.println(e);
}
```

The exception object contains information about the exception.

We can also use:

```java
e.getMessage()
```

to obtain the exception's message when one is available.

---

### 11. Basic Multiple Catch Syntax

The general syntax is:

```java
try {

    // code that may produce an exception

}
catch (ExceptionType1 e) {

    // handling code for ExceptionType1

}
catch (ExceptionType2 e) {

    // handling code for ExceptionType2

}
catch (ExceptionType3 e) {

    // handling code for ExceptionType3

}
```

There can be multiple catch blocks.

Each one can be designed for a different exception type.

---

### 12. Different Exception Classes

Some common exception classes are:

#### `ArithmeticException`

Related to invalid arithmetic operations.

Example:

```java
int result = 10 / 0;
```

#### `InputMismatchException`

Can occur when `Scanner` receives input that does not match the expected type.

Example:

```java
int number = sc.nextInt();
```

and the user enters:

```text
ten
```

#### `ArrayIndexOutOfBoundsException`

Occurs when an invalid array index is accessed.

Example:

```java
int[] numbers = {10, 20, 30};

System.out.println(numbers[5]);
```

These exceptions describe different types of problems.

---

### 13. Why Different Exception Messages Are Useful

Suppose every exception produces:

```text
Exception was handled
```

The user does not know what actually happened.

Instead, we can give specific messages:

```text
Cannot divide by zero
```

or:

```text
Please enter numbers only
```

or:

```text
Invalid array index
```

This makes the program much easier to understand.

---

### 14. Simple Java Program

```java
import java.util.InputMismatchException;
import java.util.Scanner;

class Demo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.println("Enter first number:");
            int first = sc.nextInt();

            System.out.println("Enter second number:");
            int second = sc.nextInt();

            int result = first / second;

            System.out.println("Result = " + result);

        }
        catch (InputMismatchException e) {

            System.out.println("Please enter numbers only");

        }
        catch (ArithmeticException e) {

            System.out.println("Second number cannot be zero");

        }

        System.out.println("Program Ends");
    }
}
```

---

### 15. Understanding the Import Statements

The first statement is:

```java
import java.util.InputMismatchException;
```

It makes `InputMismatchException` available to the program.

The second statement is:

```java
import java.util.Scanner;
```

It makes the `Scanner` class available.

`Scanner` helps the program read input from the keyboard.

---

### 16. Understanding the Scanner Object

This statement:

```java
Scanner sc = new Scanner(System.in);
```

has several parts.

```text
Scanner
   ↓
Class name
```

```text
sc
↓
Reference variable
```

```text
new Scanner(System.in)
        ↓
Creates Scanner object
```

`System.in` represents standard input, commonly the keyboard.

Therefore:

```java
Scanner sc = new Scanner(System.in);
```

means that we create a Scanner object and use `sc` to read input.

---

### 17. Understanding `nextInt()`

This statement:

```java
int first = sc.nextInt();
```

asks the Scanner to read an integer.

For example:

```text
25
```

is valid integer input.

The value is stored in:

```text
first
```

Similarly:

```java
int second = sc.nextInt();
```

reads another integer.

---

### 18. The Division Operation

This statement performs division:

```java
int result = first / second;
```

Suppose:

```text
first  = 20
second = 5
```

Then:

```text
20 / 5
 ↓
4
```

So:

```text
result = 4
```

But if:

```text
first  = 20
second = 0
```

then:

```text
20 / 0
 ↓
ArithmeticException
```

This is one possible exception that the program needs to handle.

---

### 19. First Catch Block

The first catch block is:

```java
catch (InputMismatchException e) {

    System.out.println("Please enter numbers only");

}
```

This is responsible for an input-type problem.

For example, if:

```java
sc.nextInt();
```

expects a number but the user enters:

```text
ten
```

the Scanner can produce an `InputMismatchException`.

Java then finds this matching catch block.

The message:

```text
Please enter numbers only
```

is displayed.

---

### 20. Second Catch Block

The second catch block is:

```java
catch (ArithmeticException e) {

    System.out.println("Second number cannot be zero");

}
```

This handles an `ArithmeticException`.

If the user enters:

```text
20
0
```

the division becomes:

```text
20 / 0
```

and Java produces an `ArithmeticException`.

The matching catch block then displays:

```text
Second number cannot be zero
```

---

### 21. Execution With Correct Input

Suppose the user enters:

```text
20
5
```

The execution is:

```text
main()
   ↓
Create Scanner
   ↓
Read first = 20
   ↓
Read second = 5
   ↓
20 / 5
   ↓
result = 4
   ↓
Print Result = 4
   ↓
Print Program Ends
```

Output:

```text
Enter first number:
20
Enter second number:
5
Result = 4
Program Ends
```

No exception occurs.

Therefore, neither catch block executes.

---

### 22. Execution With Invalid Input

Suppose the user enters:

```text
ten
```

The program reaches:

```java
int first = sc.nextInt();
```

But `nextInt()` expects an integer.

The input is text:

```text
ten
```

Therefore:

```text
InputMismatchException
```

occurs.

Java checks the catch blocks.

The matching catch is:

```java
catch (InputMismatchException e)
```

So it executes:

```java
System.out.println("Please enter numbers only");
```

The output becomes:

```text
Please enter numbers only
Program Ends
```

---

### 23. Execution With Division by Zero

Suppose the user enters:

```text
20
0
```

The first input is accepted.

The second input is accepted.

Then:

```text
20 / 0
```

causes:

```text
ArithmeticException
```

Java checks the catch blocks.

First:

```text
InputMismatchException?
```

No.

Next:

```text
ArithmeticException?
```

Yes.

So this executes:

```java
System.out.println("Second number cannot be zero");
```

Output:

```text
Second number cannot be zero
Program Ends
```

---

### 24. How Java Searches for a Matching Catch

When an exception occurs, Java does not randomly select a catch block.

It checks them in order.

For example:

```text
Exception occurs
      ↓
Check catch 1
      ↓
Does it match?
   ↓         ↓
 Yes         No
  ↓           ↓
Handle     Check catch 2
              ↓
          Does it match?
```

It continues until a compatible handler is found.

---

### 25. Only the Matching Catch Executes

Suppose:

```java
try {
    int x = 10 / 0;
}
catch (ArithmeticException e) {
    System.out.println("Arithmetic problem");
}
catch (InputMismatchException e) {
    System.out.println("Input problem");
}
```

The exception is:

```text
ArithmeticException
```

Therefore only:

```text
Arithmetic problem
```

is printed.

The second catch does not execute.

The program does **not** execute every catch block.

---

### 26. More Than Two Catch Blocks

Multiple catch does not mean only two catch blocks.

We can have three or more.

Example:

```java
try {

    // risky code

}
catch (ArithmeticException e) {

    System.out.println("Arithmetic problem");

}
catch (InputMismatchException e) {

    System.out.println("Invalid input");

}
catch (ArrayIndexOutOfBoundsException e) {

    System.out.println("Invalid array index");

}
```

Here:

```text
1 try block
3 catch blocks
3 different exception types
```

---

### 27. Array Example

Consider:

```java
int[] numbers = {10, 20, 30};

System.out.println(numbers[5]);
```

The array contains:

```text
Index 0 → 10
Index 1 → 20
Index 2 → 30
```

There is no index `5`.

Therefore:

```text
numbers[5]
   ↓
Invalid index
   ↓
ArrayIndexOutOfBoundsException
```

We can handle it separately:

```java
catch (ArrayIndexOutOfBoundsException e) {

    System.out.println("Invalid array index");

}
```

---

### 28. Specific Messages Make Programs Clear

Compare these two programs.

Generic handling:

```java
catch (Exception e) {
    System.out.println("Exception was handled");
}
```

Specific handling:

```java
catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}

catch (InputMismatchException e) {
    System.out.println("Please enter numbers only");
}
```

The second approach tells the user what kind of problem occurred.

This is especially useful in real applications.

---

### 29. Real-World Application Example

Imagine an ATM application.

Different problems might occur:

```text
Wrong PIN
   ↓
Show "Incorrect PIN"
```

```text
Invalid amount
   ↓
Show "Enter a valid amount"
```

```text
Insufficient balance
   ↓
Show "Insufficient balance"
```

The application should not give the same message for every problem.

Similarly, Java's multiple catch mechanism allows different exception types to receive appropriate handling.

---

### 30. Important Catch Ordering Rule

Catch blocks are checked from top to bottom.

When exception classes have an inheritance relationship, the **specific exception should come before the general exception**.

Correct:

```java
catch (ArithmeticException e) {

}

catch (Exception e) {

}
```

Here:

```text
ArithmeticException
        ↓
Specific
```

and:

```text
Exception
        ↓
General
```

So the specific handler comes first.

---

### 31. Why General Catch Should Come Later

Consider:

```java
catch (Exception e) {

}

catch (ArithmeticException e) {

}
```

`Exception` is a general superclass that can cover `ArithmeticException`.

Therefore, the later `ArithmeticException` handler becomes unreachable.

Java does not allow this arrangement.

The safe rule is:

```text
Specific exception
        ↓
More general exception
```

---

### 32. Common Confusions and Mistakes

#### Mistake 1: Thinking Every Catch Executes

Wrong idea:

```text
Exception
 ↓
catch 1
 ↓
catch 2
 ↓
catch 3
```

Correct idea:

```text
Exception
 ↓
Find first compatible catch
 ↓
Execute that catch
```

#### Mistake 2: Using an unrelated exception type

If the exception is:

```text
ArithmeticException
```

a catch specifically for:

```text
InputMismatchException
```

does not become a matching handler.

#### Mistake 3: Putting general catch first

Avoid:

```java
catch (Exception e) {
}

catch (ArithmeticException e) {
}
```

Prefer:

```java
catch (ArithmeticException e) {
}

catch (Exception e) {
}
```

---

### 33. Single Catch and Multiple Catch

With a single catch:

```java
try {

}
catch (Exception e) {

}
```

there is only one catch block.

With multiple catch:

```java
try {

}
catch (ArithmeticException e) {

}
catch (InputMismatchException e) {

}
```

there are multiple handlers.

The purpose of multiple catch is to allow different exceptions to be handled differently.

---

### 34. Multiple Catch and Generic Exception Handling

Generic handling:

```java
catch (Exception e) {
    System.out.println("Something went wrong");
}
```

This can handle many exception types because `Exception` is a broad type.

Multiple specific catches:

```java
catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}

catch (InputMismatchException e) {
    System.out.println("Please enter numbers only");
}
```

This provides more detailed handling.

The choice depends on what the application needs to do.

---

### 35. Memory Trick and Complete Flow

Remember this simple sentence:

> **Different problems → Different exceptions → Different catch blocks → Different messages.**

Complete flow:

```text
                  TRY
                   ↓
              Risky code
                   ↓
             Problem occurs
                   ↓
          Exception object created
                   ↓
            Runtime System
                   ↓
          Check catch blocks
                   ↓
       ┌───────────┼───────────┐
       ↓           ↓           ↓
  Arithmetic    Input       Array
  Exception    Mismatch    Exception
       ↓           ↓           ↓
    Catch 1      Catch 2     Catch 3
       ↓           ↓           ↓
   Arithmetic    Input       Array
    message     message      message
       └───────────┼───────────┘
                   ↓
          Matching catch executes
                   ↓
          Remaining program flow
```

The easiest lifetime memory is:

> **One `try` can have many `catch` blocks, and each catch can take care of a different type of exception.**

---

### 36. Complete Understanding

Multiple Catch is Java's way of giving **different problems their own handlers**.

A program first places potentially dangerous code inside:

```java
try
```

If a problem occurs, Java creates an exception object and the Runtime System looks for a suitable handler.

Java checks the `catch` blocks in order:

```java
catch (ArithmeticException e)
```

```java
catch (InputMismatchException e)
```

```java
catch (ArrayIndexOutOfBoundsException e)
```

The first compatible catch block handles the exception.

Different handlers can provide different messages:

```text
Arithmetic problem
        ↓
"Cannot divide by zero"
```

```text
Input problem
        ↓
"Please enter numbers only"
```

```text
Array problem
        ↓
"Invalid array index"
```

So the complete concept can be remembered as:

```text
                 MULTIPLE CATCH
                       ↓
                   One try
                       ↓
               Risky Java code
                       ↓
               Exception occurs
                       ↓
             Identify its type
                       ↓
          Search catch blocks in order
                       ↓
             Find matching catch
                       ↓
              Handle the exception
                       ↓
          Give suitable information
                       ↓
             Continue the program
```

**Core idea:**

> **Multiple Catch allows one `try` block to have multiple `catch` blocks so that different exception types can be handled separately with appropriate handling and messages.**
