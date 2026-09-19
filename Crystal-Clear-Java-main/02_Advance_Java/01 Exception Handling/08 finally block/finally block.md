# 🧒 8. `finally` Block

The `finally` block is used for **code that should execute after `try`/`catch` processing, whether an exception occurs or not**.

The basic structure is:

```java
try {
    // risky code
}
catch (Exception e) {
    // exception handling
}
finally {
    // code that must be executed
}
```

Think of it like this:

```text
try
 ↓
Something happens
 ↓
 ┌───────────────────────┐
 │ Exception?             │
 │                        │
 │ YES → catch            │
 │ NO  → continue         │
 └───────────────────────┘
 ↓
finally
 ↓
Continue
```

---

# 🧒 8.1 Purpose of `finally`

## What is `finally`?

`finally` is a Java keyword.

It is used with exception-handling statements such as:

```java
try
catch
finally
```

The main purpose of `finally` is to place statements that should execute **regardless of whether an exception occurs or does not occur**.

For example:

```java
try {
    System.out.println("Try");
}
catch (Exception e) {
    System.out.println("Catch");
}
finally {
    System.out.println("Finally");
}
```

The important idea is:

```text
Exception occurs
       ↓
catch
       ↓
finally
```

and:

```text
No exception
       ↓
finally
```

---

# 🧒 8.1.1 Why Do We Need `finally`?

Imagine you are using an ATM.

A transaction starts:

```text
Transaction Started
```

Something may go wrong:

```text
Invalid PIN
```

The ATM handles the problem.

But whether the transaction succeeds or fails, the ATM still needs to perform some final action, such as completing its transaction-ending procedure.

That final action can be placed inside `finally`.

```text
Transaction Started
       ↓
Try transaction
       ↓
Problem?
   ↙       ↘
 YES       NO
  ↓         ↓
catch     continue
   ↘       ↙
    finally
       ↓
Transaction Completed
```

---

# 🧒 8.1.2 Exception Occurs

Consider:

```java
try {
    int result = 10 / 0;
}
catch (Exception e) {
    System.out.println("Exception handled");
}
finally {
    System.out.println("Finally executed");
}
```

`10 / 0` causes an exception.

Flow:

```text
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
finally
 ↓
Finally executed
```

Output:

```text
Exception handled
Finally executed
```

---

# 🧒 8.1.3 Exception Does Not Occur

Now:

```java
try {
    int result = 10 / 2;
    System.out.println(result);
}
catch (Exception e) {
    System.out.println("Exception handled");
}
finally {
    System.out.println("Finally executed");
}
```

Here:

```text
10 / 2
 ↓
5
```

No exception occurs.

Therefore, the `catch` block is skipped.

But `finally` executes.

Flow:

```text
try
 ↓
10 / 2
 ↓
No exception
 ↓
finally
```

Output:

```text
5
Finally executed
```

---

# 🧒 8.1.4 Main Rule of `finally`

Remember:

> **`finally` is used for code that needs to execute after exception handling, whether the `try` code succeeds or an exception is handled.**

So:

```text
Exception occurs:
try → catch → finally
```

and:

```text
No exception:
try → finally
```

---

# 🧒 8.1.5 `finally` Does Not Catch Exceptions

This is very important.

Beginners may think:

```text
finally = exception handler
```

That is incorrect.

`catch` is the exception handler.

```text
try     → risky code
catch   → handles exception
finally → final code
```

For example:

```java
try {
    // risky operation
}
catch (Exception e) {
    // handles exception
}
finally {
    // final operation
}
```

---

# 🧒 8.1.6 `finally` and `catch` Have Different Jobs

| Block     | Main purpose                                           |
| --------- | ------------------------------------------------------ |
| `try`     | Contains code where an exception may occur             |
| `catch`   | Handles the exception                                  |
| `finally` | Executes final code after the `try`/`catch` processing |

Memory trick:

```text
TRY    → Try the work
CATCH  → Catch the problem
FINALLY → Finish the final work
```

---

# 🧒 8.1.7 `finally` With No Exception

Program:

```java
class Demo {

    public static void main(String[] args) {

        try {

            System.out.println("Transaction Started");

        }
        catch (Exception e) {

            System.out.println("Exception handled");

        }
        finally {

            System.out.println("Transaction Completed");
        }
    }
}
```

Execution:

```text
main()
 ↓
try
 ↓
Transaction Started
 ↓
No exception
 ↓
catch skipped
 ↓
finally
 ↓
Transaction Completed
```

Output:

```text
Transaction Started
Transaction Completed
```

---

# 🧒 8.1.8 `finally` With an Exception

Program:

```java
class Demo {

    public static void main(String[] args) {

        try {

            int result = 10 / 0;

        }
        catch (Exception e) {

            System.out.println("Exception handled");

        }
        finally {

            System.out.println("Transaction Completed");
        }
    }
}
```

Execution:

```text
main()
 ↓
try
 ↓
10 / 0
 ↓
ArithmeticException
 ↓
catch
 ↓
Exception handled
 ↓
finally
 ↓
Transaction Completed
```

Output:

```text
Exception handled
Transaction Completed
```

---

# 🧒 8.1.9 Why `finally` Is Useful in Real Programs

Suppose a program opens a resource.

For example:

```text
File
Database
Network connection
Scanner/resource
```

After using the resource, the program may need to perform cleanup.

The final operation can traditionally be placed in `finally`.

For example:

```java
try {

    // use resource

}
catch (Exception e) {

    // handle problem

}
finally {

    // cleanup/final action

}
```

The important idea is:

```text
Use resource
    ↓
Something goes wrong or doesn't go wrong
    ↓
Perform required final operation
```

---

# 🧒 8.2 ATM Transaction Example

Now let's connect everything we learned:

```text
ATM
 ↓
transaction()
 ↓
try
 ↓
exception may occur
 ↓
catch
 ↓
throw
 ↓
Bank
 ↓
finally
 ↓
Transaction Completed
```

The three important keywords are:

```text
try
catch
finally
```

And from the previous topic:

```text
throw
```

can be used to rethrow the exception.

---

# 🧒 8.2.1 ATM Transaction Flow

Imagine:

```text
BankApp
   ↓
Bank
   ↓
ATM
   ↓
transaction()
```

The ATM starts the transaction:

```text
Transaction Started
```

Then the transaction is attempted inside `try`.

If something goes wrong:

```text
Exception
```

the ATM catches it:

```text
catch
```

The ATM may then rethrow the exception:

```java
throw e;
```

But the `finally` block can still perform the final transaction operation.

Conceptually:

```text
ATM transaction()
       ↓
      try
       ↓
 exception occurs
       ↓
     catch
       ↓
    throw e
       ↓
    finally
       ↓
Transaction Completed
```

---

# 🧒 8.2.2 Important Relationship Between `catch`, `throw`, and `finally`

Suppose:

```java
try {

    // risky operation

}
catch (Exception e) {

    // handle exception

    throw e;

}
finally {

    // final operation
}
```

There are three different actions:

### `catch`

Receives the exception.

### `throw e`

Rethrows the exception.

### `finally`

Executes its final code before control leaves the current method because of that exception.

So:

```text
catch → handles/processes
throw → propagates
finally → performs final action
```

---

# 🧒 8.2.3 ATM Example Program

```java
class ATM {

    void transaction() throws Exception {

        System.out.println("Transaction Started");

        try {

            throw new Exception("Transaction failed");

        }
        catch (Exception e) {

            System.out.println("Exception handled by ATM");

            throw e;

        }
        finally {

            System.out.println("Transaction Completed");
        }
    }
}
```

Let's understand every important part.

---

# 🧒 8.2.4 `void transaction()`

```java
void transaction()
```

This declares a method named:

```text
transaction
```

`void` means the method does not return a value.

---

# 🧒 8.2.5 `throws Exception`

```java
void transaction() throws Exception
```

This tells the caller:

> "`transaction()` may pass an `Exception` to you."

The ATM is therefore warning its caller.

```text
ATM.transaction()
       ↓
throws Exception
       ↓
caller must be prepared
```

---

# 🧒 8.2.6 Transaction Started

```java
System.out.println("Transaction Started");
```

This displays:

```text
Transaction Started
```

It tells us that the ATM transaction has begun.

---

# 🧒 8.2.7 Exception Inside `try`

```java
try {

    throw new Exception("Transaction failed");

}
```

Here:

```java
throw new Exception("Transaction failed");
```

creates an exception object and throws it.

Conceptually:

```text
new Exception(...)
       ↓
Exception object
       ↓
throw
       ↓
exception occurs
```

---

# 🧒 8.2.8 ATM `catch`

The exception reaches:

```java
catch (Exception e)
```

The ATM receives the exception object through:

```text
e
```

Then:

```java
System.out.println("Exception handled by ATM");
```

prints:

```text
Exception handled by ATM
```

---

# 🧒 8.2.9 ATM Rethrows Exception

Next:

```java
throw e;
```

The ATM rethrows the exception.

So the exception can move to the caller.

```text
ATM
 ↓
catch
 ↓
throw e
 ↓
caller
```

But before the method's control leaves because of the exception, the `finally` block executes.

---

# 🧒 8.2.10 `finally`

The ATM has:

```java
finally {

    System.out.println("Transaction Completed");
}
```

This prints:

```text
Transaction Completed
```

So even though an exception was thrown and rethrown, the final action is performed.

---

# 🧒 8.2.11 Complete ATM Flow

```text
ATM.transaction()
       ↓
Transaction Started
       ↓
try
       ↓
Exception occurs
       ↓
catch
       ↓
Exception handled by ATM
       ↓
throw e
       ↓
finally
       ↓
Transaction Completed
       ↓
Exception continues toward caller
```

This is the key flow.

---

# 🧒 8.3 Execution

Now let's connect the ATM with the Bank and BankApp.

The structure is:

```text
BankApp
   ↓
Bank
   ↓
ATM
```

The methods are:

```text
BankApp
   main()

Bank
   connect()

ATM
   transaction()
```

---

# 🧒 8.3.1 BankApp Calls Bank

Suppose:

```java
public class BankApp {

    public static void main(String[] args) {

        Bank bank = new Bank();

        try {

            bank.connect();

        }
        catch (Exception e) {

            System.out.println("Exception handled by BankApp");
        }

        System.out.println("Main completed");
    }
}
```

The first important operation is:

```java
Bank bank = new Bank();
```

A Bank object is created.

Then:

```java
bank.connect();
```

calls the Bank's `connect()` method.

Flow:

```text
main()
 ↓
connect()
```

---

# 🧒 8.3.2 Bank Connects With ATM

Suppose:

```java
class Bank {

    void connect() throws Exception {

        System.out.println("Connection with ATM established");

        ATM atm = new ATM();

        atm.transaction();

        System.out.println("Connection terminated");
    }
}
```

The Bank prints:

```text
Connection with ATM established
```

Then creates an ATM object:

```java
ATM atm = new ATM();
```

Then:

```java
atm.transaction();
```

calls the ATM transaction.

---

# 🧒 8.3.3 Complete Program

```java
class ATM {

    void transaction() throws Exception {

        System.out.println("Transaction Started");

        try {

            throw new Exception("Transaction failed");

        }
        catch (Exception e) {

            System.out.println("Exception handled by ATM");

            throw e;

        }
        finally {

            System.out.println("Transaction Completed");
        }
    }
}


class Bank {

    void connect() throws Exception {

        System.out.println("Connection with ATM established");

        ATM atm = new ATM();

        atm.transaction();

        System.out.println("Connection terminated");
    }
}


public class BankApp {

    public static void main(String[] args) {

        Bank bank = new Bank();

        try {

            bank.connect();

        }
        catch (Exception e) {

            System.out.println("Exception handled by BankApp");
        }

        System.out.println("Main completed");
    }
}
```

---

# 🧒 8.3.4 Step-by-Step Execution

Java starts at:

```java
public static void main(String[] args)
```

So:

```text
main()
```

starts first.

Then:

```java
Bank bank = new Bank();
```

creates a Bank object.

Then:

```java
bank.connect();
```

calls Bank's `connect()` method.

---

# 🧒 8.3.5 Connection Established

Inside `connect()`:

```java
System.out.println("Connection with ATM established");
```

Output:

```text
Connection with ATM established
```

Then:

```java
ATM atm = new ATM();
```

creates the ATM object.

Then:

```java
atm.transaction();
```

calls:

```text
ATM.transaction()
```

---

# 🧒 8.3.6 Transaction Started

ATM executes:

```java
System.out.println("Transaction Started");
```

Output:

```text
Transaction Started
```

Then execution enters:

```java
try
```

---

# 🧒 8.3.7 Exception Occurs

The following executes:

```java
throw new Exception("Transaction failed");
```

An exception object is created.

Then it is thrown.

```text
Exception object
       ↓
throw
       ↓
catch
```

---

# 🧒 8.3.8 ATM Handles Exception

The exception reaches:

```java
catch (Exception e)
```

ATM prints:

```text
Exception handled by ATM
```

The ATM has processed the exception.

Then:

```java
throw e;
```

rethrows the exception.

---

# 🧒 8.3.9 `finally` Executes

Before the exception leaves the ATM method, the `finally` block executes:

```java
System.out.println("Transaction Completed");
```

Output:

```text
Transaction Completed
```

This is the major point of this topic.

The exception did not prevent the `finally` block from executing in this normal rethrow flow.

---

# 🧒 8.3.10 Exception Reaches Bank

The ATM's method declares:

```java
throws Exception
```

The exception is therefore passed toward its caller:

```text
ATM.transaction()
       ↓
Bank.connect()
```

But Bank's method also declares:

```java
void connect() throws Exception
```

So the Bank does not handle it there.

It passes the exception toward its caller:

```text
Bank.connect()
       ↓
BankApp.main()
```

---

# 🧒 8.3.11 Does `Connection terminated` Execute?

Look at:

```java
atm.transaction();

System.out.println("Connection terminated");
```

The exception is rethrown by `atm.transaction()`.

Therefore normal execution does not reach:

```java
System.out.println("Connection terminated");
```

inside `connect()`.

So in this particular program:

```text
Connection terminated
```

is **not printed**.

The exception leaves `connect()` and travels toward `main()`.

---

# 🧒 8.3.12 Main Receives Exception

In `main()`:

```java
try {

    bank.connect();

}
catch (Exception e) {

    System.out.println("Exception handled by BankApp");
}
```

The exception reaches:

```java
catch (Exception e)
```

in `main()`.

The output is:

```text
Exception handled by BankApp
```

---

# 🧒 8.3.13 Main Continues

After the `catch` finishes, the next statement in `main()` is:

```java
System.out.println("Main completed");
```

Therefore:

```text
Main completed
```

is printed.

This demonstrates that the exception was finally handled by the caller.

---

# 🧒 8.3.14 Complete Output

The program produces:

```text
Connection with ATM established
Transaction Started
Exception handled by ATM
Transaction Completed
Exception handled by BankApp
Main completed
```

Notice that:

```text
Connection terminated
```

does not appear because the exception left `connect()` before that statement could execute.

---

# 🧒 8.3.15 Complete Execution Map

```text
BankApp.main()
      │
      │
      ▼
Bank.connect()
      │
      ├── Connection with ATM established
      │
      ▼
ATM.transaction()
      │
      ├── Transaction Started
      │
      ▼
     try
      │
      ▼
Exception occurs
      │
      ▼
    catch
      │
      ├── Exception handled by ATM
      │
      ▼
   throw e
      │
      ▼
  finally
      │
      ├── Transaction Completed
      │
      ▼
Bank.connect()
      │
      │ exception continues
      ▼
BankApp.main()
      │
      ▼
    catch
      │
      ├── Exception handled by BankApp
      │
      ▼
Main completed
```

---

# 🧒 8.3.16 The Three Jobs

The easiest way to remember the entire topic is:

```text
try
 ↓
"Try to perform the risky operation."

catch
 ↓
"Something went wrong. Handle/process it."

finally
 ↓
"Perform the final operation."
```

When rethrowing is involved:

```text
catch
 ↓
throw
 ↓
finally
 ↓
caller
```

---

# 🧒 8.3.17 Exception Occurs vs No Exception

### Case 1 — Exception occurs

```text
try
 ↓
Exception
 ↓
catch
 ↓
finally
```

### Case 2 — No exception

```text
try
 ↓
Normal execution
 ↓
finally
```

The important difference is that `catch` only executes when the corresponding exception occurs, whereas `finally` is intended for the final code that should execute in either path.

---

# 🧒 8.3.18 ATM Mental Model

Imagine an ATM transaction:

```text
START
  ↓
Try transaction
  ↓
Did something go wrong?
  ↓
 ┌─────────────┐
 │             │
YES           NO
 │             │
 ↓             ↓
Handle       Continue
 │             │
 └──────┬──────┘
        ↓
     FINALLY
        ↓
Transaction Completed
```

The `finally` block is like the ATM saying:

> "Whatever happened during the transaction, I must perform my final step."

---

# 🧒 8.3.19 Important Rules to Remember

### Rule 1

`finally` is associated with `try` and is used for final code.

### Rule 2

If an exception occurs and is handled:

```text
try → catch → finally
```

### Rule 3

If no exception occurs:

```text
try → finally
```

### Rule 4

`catch` handles the exception.

### Rule 5

`throw` explicitly throws/rethrows an exception.

### Rule 6

`throws` declares that a method may pass an exception to its caller.

### Rule 7

`finally` is not an exception handler.

### Rule 8

When an exception is rethrown from a `catch`, the `finally` block of that `try` executes before control leaves that method in the normal exception-flow case.

### Rule 9

Statements after a rethrown exception in the same normal execution path are not reached.

Example:

```java
try {
    // ...
}
catch (Exception e) {
    throw e;
}

System.out.println("This is not reached from that throw path");
```

### Rule 10

The caller can finally handle the propagated exception.

---

# 🧒 8.3.20 Final Lifetime Memory

Remember this complete chain:

```text
                 TRY
                  ↓
          Risky operation
                  ↓
          ┌───────┴───────┐
          │               │
      Exception       No Exception
          │               │
          ▼               │
        CATCH             │
          │               │
       handle             │
          │               │
       throw e            │
          │               │
          └───────┬───────┘
                  ↓
               FINALLY
                  ↓
           Final operation
                  ↓
              Caller
                  ↓
              Handler
```

### 🧠 One sentence to remember forever:

> **`try` attempts the work, `catch` deals with the problem, `throw` can send the problem onward, `throws` warns the caller, and `finally` performs the final code regardless of whether the exception occurred.**
