# 🧒 5. ATM–Bank Exception Handling

## 1️⃣ Start From ZERO — What Are We Trying to Understand?

Imagine you go to an ATM to withdraw money.

A real ATM transaction involves several activities:

1. You start the banking application.
2. The application contacts the Bank.
3. The Bank establishes a connection with the ATM.
4. The ATM starts the transaction.
5. The ATM asks for your PIN.
6. You enter the PIN.
7. The ATM checks whether the PIN is correct.
8. The transaction continues.
9. If something unexpected happens, the exception must be handled.
10. The transaction finishes.
11. The connection with the ATM is terminated.
12. Control finally returns to the application.

We can represent this in Java using three classes:

```text
BankApp
   ↓
Bank
   ↓
ATM
```

The important methods are:

```text
BankApp
   main()

Bank
   connect()

ATM
   transaction()
```

So the complete basic relationship is:

```text
BankApp.main()
       ↓
Bank.connect()
       ↓
ATM.transaction()
```

This example is mainly used to understand **method calling, exception handling, exception propagation, callers, and `throws Exception`**.

---

# 2️⃣ Understand the Three Classes

We have three classes:

```text
┌──────────────┐
│   BankApp    │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│     Bank     │
└──────┬───────┘
       │
       ▼
┌──────────────┐
│     ATM      │
└──────────────┘
```

Each class has a different responsibility.

### `BankApp`

This is the application that starts the whole process.

It contains:

```java
main()
```

### `Bank`

The Bank is responsible for establishing communication with the ATM.

It contains:

```java
connect()
```

### `ATM`

The ATM performs the actual transaction.

It contains:

```java
transaction()
```

So remember:

```text
BankApp → Starts
Bank    → Connects
ATM     → Transacts
```

---

# 3️⃣ What Is a Class?

Before understanding the program, we must understand `class`.

Example:

```java
class ATM {
}
```

A **class** is like a blueprint.

Imagine an architect wants to construct a house.

The architect first prepares a blueprint.

The blueprint is not the actual house.

Similarly:

```text
Class     = Blueprint
Object    = Actual thing created from blueprint
```

For example:

```java
class ATM {
}
```

means:

> "Create a blueprint called `ATM`."

We can later create an ATM object from that class.

---

# 4️⃣ What Is an Object?

An object is an actual instance created from a class.

Suppose:

```java
class ATM {
}
```

is the blueprint.

We can create an object:

```java
ATM atm = new ATM();
```

Think:

```text
ATM class
   ↓
Blueprint
   ↓
new ATM()
   ↓
Actual ATM object
```

The object allows us to use the methods and variables defined by the class.

For example:

```java
atm.transaction();
```

means:

> "Use the ATM object and perform its transaction operation."

---

# 5️⃣ Understanding `BankApp`

We can create:

```java
public class BankApp {
}
```

Let's understand every part.

### `public`

`public` means the class can be accessed from outside its package.

For our beginner understanding, think:

> `public` means "available for access."

### `class`

`class` tells Java that we are defining a class.

### `BankApp`

This is the name of our class.

Therefore:

```java
public class BankApp
```

means:

> "Create a publicly accessible Java class named `BankApp`."

---

# 6️⃣ Understanding `main()`

Java needs a starting point for executing a normal standalone application.

That starting point is:

```java
public static void main(String[] args)
```

Let's break it apart.

### `public`

The method is accessible to the JVM from outside the class.

### `static`

The JVM can call the method without first creating a `BankApp` object.

### `void`

The method does not return a value.

### `main`

This is the specially recognized method name where Java application execution begins.

### `String[] args`

This represents an array of command-line arguments.

So:

```java
public static void main(String[] args)
```

is the standard entry point of the application.

---

# 7️⃣ Why Does `BankApp` Have `main()`?

Because our application needs a starting point.

Think about switching on a television.

There must be a button that starts the television.

Similarly, Java needs an entry point.

```text
Program starts
      ↓
main()
      ↓
Bank object
      ↓
connect()
```

Therefore:

```text
main() = Starting point of the application
```

---

# 8️⃣ Creating the Bank Object

Inside `main()` we can write:

```java
Bank bank = new Bank();
```

This statement contains several important concepts.

### `Bank`

The class type.

### `bank`

The reference variable.

### `=`

Assignment operator.

### `new`

Creates a new object.

### `Bank()`

Calls the constructor while creating the object.

So:

```java
Bank bank = new Bank();
```

means:

> "Create a new Bank object and store a reference to it in the variable `bank`."

Think:

```text
Bank class
    ↓
new Bank()
    ↓
Bank object
    ↓
bank reference
```

---

# 9️⃣ What Is a Reference Variable?

Consider:

```java
Bank bank = new Bank();
```

The first `Bank` tells Java the type.

The second part:

```java
bank
```

is a reference variable.

It allows us to access the object.

Think of an object as a house.

The reference variable is like the **address written on a piece of paper**.

```text
Object
  ↑
Reference variable
```

The reference lets Java know which object we want to work with.

Therefore:

```java
bank.connect();
```

means:

> "Use the Bank object referred to by `bank` and call its `connect()` method."

---

# 🔟 Understanding `new`

The keyword:

```java
new
```

is extremely important.

Example:

```java
new Bank()
```

It tells Java to create a new object.

Without creating an object, an ordinary non-static instance method cannot be called through an object reference.

So:

```java
Bank bank = new Bank();
```

creates the Bank object.

Then:

```java
bank.connect();
```

uses that object.

Think:

```text
new Bank()
     ↓
Creates object

bank
     ↓
Refers to object

bank.connect()
     ↓
Calls method
```

---

# 1️⃣1️⃣ Understanding `connect()`

The Bank class contains:

```java
void connect() {
}
```

Here:

```text
connect = method name
```

A method is a block of code designed to perform a particular task.

In our example, the task is:

> Establishing a connection with the ATM and then allowing the ATM transaction to happen.

Therefore:

```java
bank.connect();
```

calls the `connect()` method.

---

# 1️⃣2️⃣ What Is a Method?

A method is like a **job or action**.

Think about a person:

```text
Person
 ├── eat()
 ├── sleep()
 ├── study()
 └── work()
```

Each method represents an action.

Similarly:

```text
Bank
 └── connect()

ATM
 └── transaction()
```

The Bank's job:

```text
connect()
```

The ATM's job:

```text
transaction()
```

---

# 1️⃣3️⃣ Understanding `transaction()`

The ATM contains:

```java
void transaction() {
}
```

This method represents the transaction performed by the ATM.

Inside it we can have:

```text
Transaction Started
       ↓
PIN input
       ↓
PIN checking
       ↓
Transaction processing
       ↓
Exception handling if required
       ↓
Transaction completed
```

So:

```text
transaction() = ATM's transaction operation
```

---

# 1️⃣4️⃣ Complete Normal Method Flow

Suppose we have:

```java
public static void main(String[] args) {

    Bank bank = new Bank();

    bank.connect();
}
```

The program starts here:

```text
main()
```

Then:

```text
Bank object created
```

Then:

```text
bank.connect()
```

is called.

Inside `connect()`:

```text
ATM object created
```

Then:

```text
atm.transaction()
```

is called.

Therefore:

```text
main()
 ↓
connect()
 ↓
transaction()
```

This is our method-call hierarchy.

---

# 1️⃣5️⃣ ATM — Transaction Started

Inside the ATM:

```java
System.out.println("Transaction Started");
```

`System.out.println()` prints text on the screen.

Let's understand it:

### `System`

Java's `System` class.

### `out`

Represents the standard output stream.

### `println()`

Prints something and moves the cursor to the next line.

Therefore:

```java
System.out.println("Transaction Started");
```

prints:

```text
Transaction Started
```

---

# 1️⃣6️⃣ PIN Input

An ATM needs a PIN before allowing a transaction.

For example:

```text
Enter PIN: 1234
```

Suppose the correct PIN is:

```text
1234
```

The user enters:

```text
1234
```

The ATM receives the input.

Conceptually:

```text
ATM
 ↓
Ask PIN
 ↓
User enters 1234
 ↓
ATM receives 1234
```

The program can then check whether the entered PIN is correct.

---

# 1️⃣7️⃣ What Is `Scanner`?

If we want to take input from the keyboard, Java provides the `Scanner` class.

Example:

```java
Scanner sc = new Scanner(System.in);
```

Let's understand it.

### `Scanner`

A Java class used to read input.

### `sc`

A reference variable.

We could name it anything:

```java
Scanner scanner
```

or:

```java
Scanner input
```

`sc` is simply a common short name.

### `new Scanner(System.in)`

Creates a Scanner object connected to standard input.

### `System.in`

Represents standard input, normally the keyboard.

So:

```java
Scanner sc = new Scanner(System.in);
```

means:

> "Create a Scanner that can read input from the keyboard."

---

# 1️⃣8️⃣ Reading the PIN

For example:

```java
int pin = sc.nextInt();
```

`nextInt()` means:

> "Read the next input as an integer."

Suppose the user enters:

```text
1234
```

Then:

```text
pin = 1234
```

Now Java can compare it with the correct PIN.

---

# 1️⃣9️⃣ Correct PIN

Suppose:

```java
int correctPin = 1234;
```

and:

```java
int pin = 1234;
```

Then the values match.

Conceptually:

```text
Correct PIN = 1234
Entered PIN = 1234

1234 == 1234

TRUE
```

The transaction can continue.

---

# 2️⃣0️⃣ What Is an Exception?

An exception is an unexpected problem that occurs during program execution.

For example:

```java
int result = 10 / 0;
```

Java cannot perform division by zero for integer arithmetic.

Therefore:

```text
10 / 0
 ↓
ArithmeticException
```

An exception interrupts the normal flow unless it is handled appropriately.

In our ATM example, an exception can represent an unexpected problem during the transaction.

---

# 2️⃣1️⃣ Why Do We Need Exception Handling?

Imagine:

```text
ATM transaction
      ↓
Unexpected problem
      ↓
No handling
      ↓
Transaction stops suddenly
```

That is undesirable.

Instead:

```text
ATM transaction
      ↓
Unexpected problem
      ↓
catch handles it
      ↓
Transaction finishes appropriately
```

Exception handling helps us deal with unexpected situations in a controlled manner.

---

# 2️⃣2️⃣ Understanding `try`

The `try` keyword is used to identify code where an exception may occur.

Example:

```java
try {

    int result = 10 / 0;

}
```

Think of `try` as:

> "Java, watch this code because something unexpected might happen here."

It does not itself handle the exception.

It identifies the code that should be monitored for exceptions.

---

# 2️⃣3️⃣ Understanding `catch`

The `catch` block is used to handle an exception.

Example:

```java
catch (Exception e) {

    System.out.println("Exception handled");

}
```

Think of it as:

> "If an exception occurs in the associated `try` block, come here and handle it."

So:

```text
try
 ↓
Problem occurs
 ↓
catch
 ↓
Handle problem
```

---

# 2️⃣4️⃣ Understanding `Exception e`

Consider:

```java
catch (Exception e)
```

There are two important parts.

### `Exception`

This represents the exception type being caught.

### `e`

This is a reference variable referring to the exception object.

Think:

```text
Exception object
       ↑
       e
```

The variable `e` allows us to access information about the exception.

For example:

```java
System.out.println(e.getMessage());
```

can print the exception message when one is available.

---

# 2️⃣5️⃣ ATM Handles the Exception

Suppose our ATM contains:

```java
void transaction() {

    try {

        int result = 10 / 0;

    }
    catch (Exception e) {

        System.out.println("Exception handled");

    }

    System.out.println("Transaction completed");
}
```

The flow is:

```text
transaction()
      ↓
try
      ↓
10 / 0
      ↓
Exception
      ↓
catch
      ↓
Exception handled
      ↓
Transaction completed
```

The exception is handled inside the ATM.

---

# 2️⃣6️⃣ Does the Exception Propagate?

In this example:

**No.**

Why?

Because the exception is handled inside:

```text
ATM.transaction()
```

The exception doesn't need to travel to the Bank.

Therefore:

```text
ATM.transaction()
       ↓
Exception
       ↓
catch
       ↓
Handled
       ↓
Return to Bank
```

The Bank can continue executing its remaining statements.

---

# 2️⃣7️⃣ What Happens After `catch`?

This is extremely important.

Suppose:

```java
try {
    int result = 10 / 0;
}
catch (Exception e) {
    System.out.println("Exception handled");
}

System.out.println("Transaction completed");
```

When the exception occurs:

```text
10 / 0
 ↓
Exception
```

Java executes:

```java
catch (Exception e)
```

After the `catch` block finishes, execution continues with the statement after the `catch` block.

Therefore:

```text
catch
 ↓
Transaction completed
```

---

# 2️⃣8️⃣ Transaction Completed

After the exception is handled:

```java
System.out.println("Transaction completed");
```

prints:

```text
Transaction completed
```

Then `transaction()` reaches its end.

Control returns to the Bank's `connect()` method.

So:

```text
transaction()
      ↓
Transaction completed
      ↓
return to connect()
```

---

# 2️⃣9️⃣ Returning to `connect()`

Remember:

```text
main()
 ↓
connect()
 ↓
transaction()
```

When `transaction()` finishes:

```text
transaction()
    ↑
connect()
```

Control returns to the next statement in `connect()`.

For example:

```java
System.out.println("Connection terminated");
```

So the flow becomes:

```text
transaction()
 ↓
transaction finishes
 ↓
connect()
 ↓
Connection terminated
```

---

# 3️⃣0️⃣ Connection Terminated

The Bank can now terminate the ATM connection:

```java
System.out.println("Connection terminated");
```

Output:

```text
Connection terminated
```

The Bank's work is complete.

Then control returns to `main()`.

```text
connect()
    ↑
main()
```

---

# 3️⃣1️⃣ `main()` Ending

After:

```java
bank.connect();
```

execution can reach:

```java
System.out.println("main() ending");
```

Output:

```text
main() ending
```

Then `main()` completes.

The application ends normally.

---

# 3️⃣2️⃣ Complete Normal Flow

The complete flow is:

```text
BankApp.main()
      ↓
Bank object created
      ↓
bank.connect()
      ↓
Connection with ATM established
      ↓
ATM object created
      ↓
atm.transaction()
      ↓
Transaction Started
      ↓
PIN input
      ↓
Correct PIN
      ↓
Transaction processing
      ↓
Transaction completed
      ↓
Return to connect()
      ↓
Connection terminated
      ↓
Return to main()
      ↓
main() ending
```

---

# 3️⃣3️⃣ What Is Exception Propagation?

Now let's change the situation.

Suppose `transaction()` does **not** handle the exception.

```text
main()
 ↓
connect()
 ↓
transaction()
 ↓
Exception
```

If `transaction()` has no suitable handler, Java can look at its caller.

The caller is:

```text
connect()
```

So the exception can move upward:

```text
transaction()
      ↑
connect()
      ↑
main()
```

This movement is called **exception propagation**.

---

# 3️⃣4️⃣ Who Is the Caller?

This is another important concept.

Suppose:

```java
bank.connect();
```

is inside `main()`.

Then:

```text
main()
```

is the caller of:

```text
connect()
```

Now suppose:

```java
atm.transaction();
```

is inside `connect()`.

Then:

```text
connect()
```

is the caller of:

```text
transaction()
```

So:

```text
main()
   ↓ calls
connect()
   ↓ calls
transaction()
```

Therefore:

```text
transaction() caller = connect()
connect() caller = main()
```

---

# 3️⃣5️⃣ Understanding `throws Exception`

Now we reach the important keyword from your notes:

```java
throws Exception
```

Suppose:

```java
void transaction() throws Exception {
}
```

This means the method is declaring:

> "This method may produce an exception, and I am not necessarily handling it here."

The responsibility can be passed to the caller.

For example:

```java
void transaction() throws Exception {
    throw new Exception("Transaction failed");
}
```

The caller then has to deal with that possibility.

---

# 3️⃣6️⃣ Complete ATM–Bank Exception Flow

Now let's put everything together.

### Situation 1 — ATM handles the exception

```text
BankApp.main()
       ↓
Bank.connect()
       ↓
ATM.transaction()
       ↓
Exception occurs
       ↓
ATM try-catch
       ↓
Exception handled
       ↓
Transaction completed
       ↓
Return to Bank
       ↓
Connection terminated
       ↓
Return to main()
       ↓
main() ending
```

The exception **does not propagate** because the ATM handled it.

---

### Situation 2 — ATM does not handle the exception

```text
BankApp.main()
       ↓
Bank.connect()
       ↓
ATM.transaction()
       ↓
Exception occurs
       ↓
No handler in transaction()
       ↓
Propagate to connect()
       ↓
No handler in connect()
       ↓
Propagate to main()
       ↓
Handler in main()?
       ↓
Yes → handle
```

If `main()` also does not handle it:

```text
main()
 ↓
Default Exception Handler
 ↓
Affected thread terminates
```

---

### Situation 3 — Using `throws Exception`

```java
class ATM {

    void transaction() throws Exception {

        throw new Exception("Transaction failed");
    }
}
```

Then:

```java
class Bank {

    void connect() throws Exception {

        ATM atm = new ATM();

        atm.transaction();
    }
}
```

Then `main()` can handle it:

```java
public class BankApp {

    public static void main(String[] args) {

        Bank bank = new Bank();

        try {

            bank.connect();

        }
        catch (Exception e) {

            System.out.println("Exception handled in main");
        }
    }
}
```

The complete propagation is:

```text
ATM.transaction()
       ↓
Exception
       ↑
Bank.connect()
       ↑
BankApp.main()
       ↓
catch
       ↓
Exception handled
```

This is the key idea behind the ATM–Bank exception-handling example.
