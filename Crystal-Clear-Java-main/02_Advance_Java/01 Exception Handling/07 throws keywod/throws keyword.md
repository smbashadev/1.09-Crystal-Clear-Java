# 🧒 7. `throws` Keyword

Before learning `throws`, remember the idea from the previous topic:

```text
throw
   ↓
Actually throws an exception object

throws
   ↓
Declares/warns that a method may throw an exception
```

The easiest way to remember it is:

> **`throw` = Do it**
> **`throws` = Tell about it**

---

# 🧒 7.1 What Is the `throws` Keyword?

`throws` is a Java keyword used in a **method declaration**.

It tells the caller:

> "This method may produce or pass an exception. You should be prepared to handle it."

Example:

```java
void transaction() throws Exception {
}
```

Here:

```text
transaction()
      ↓
may throw Exception
      ↓
caller should be prepared
```

The `throws` keyword itself **does not throw an exception**.

It only declares that an exception may come out of the method.

---

# 🧒 7.2 Why Do We Need `throws`?

Imagine you ask your friend to carry a glass.

Your friend says:

> "Be careful. This glass may break."

Your friend is **warning you**.

Similarly:

```java
void transaction() throws Exception
```

is like the method saying:

> "Caller, be careful. An exception may come out of me."

So:

```text
Method
   ↓
throws Exception
   ↓
Warning to caller
```

---

# 🧒 7.3 What Is the Caller?

A **caller** is the method that calls another method.

Example:

```java
main() {
    transaction();
}
```

Here:

```text
main()
   ↓ calls
transaction()
```

Therefore:

```text
transaction() = called method
main()       = caller
```

If `transaction()` says:

```java
void transaction() throws Exception
```

then it is warning:

```text
transaction()
      ↓
"main(), I may pass an exception to you."
```

---

# 🧒 7.4 Simple Caller Example

Consider:

```java
class Demo {

    static void fun() throws Exception {

        System.out.println("Inside fun()");
    }

    public static void main(String[] args) throws Exception {

        fun();
    }
}
```

The relationship is:

```text
main()
  ↓
fun()
```

`fun()` declares:

```java
throws Exception
```

Therefore, `fun()` is saying:

> "The caller of `fun()` should be prepared for an `Exception`."

Here the caller is:

```text
main()
```

---

# 🧒 7.5 `throws` Does Not Mean an Exception Definitely Occurs

This is very important.

Suppose:

```java
void fun() throws Exception {
    System.out.println("Hello");
}
```

The declaration says:

```text
Exception MAY occur/pass
```

It does **not** mean:

```text
Exception WILL definitely occur
```

Think of it as a warning sign.

A warning sign saying:

```text
⚠️ Road may be slippery
```

does not mean the road is definitely slippery.

Similarly:

```java
throws Exception
```

means the method is declaring an exception possibility/propagation responsibility.

---

# 🧒 7.6 Where Is `throws` Written?

`throws` appears in the **method declaration**, after the method parameter list and before the method body.

Example:

```java
void fun() throws Exception {
}
```

The order is:

```text
void
  ↓
fun
  ↓
()
  ↓
throws Exception
  ↓
{
}
```

Another example:

```java
void transaction() throws Exception {
}
```

---

# 🧒 7.7 Understanding Every Part

Look at:

```java
void transaction() throws Exception {
}
```

### `void`

The method does not return a value.

### `transaction`

The method name.

### `()`

The method currently accepts no parameters.

### `throws`

Declares that an exception may be passed out.

### `Exception`

The type of exception being declared.

### `{ }`

The method body.

So the complete statement means:

> "There is a method named `transaction`. It does not return a value, and it declares that it may pass an `Exception` to its caller."

---

# 🧒 7.8 `throws` With Multiple Exceptions

A method can declare more than one exception.

Example:

```java
void fun() throws IOException, SQLException {
}
```

This means the method may throw/pass either of those exception types.

Conceptually:

```text
fun()
 ↓
may pass IOException
or
may pass SQLException
```

Multiple exceptions are separated by commas:

```java
throws IOException, SQLException
```

---

# 🧒 7.9 Method Does Not Want to Handle the Exception

Sometimes a method encounters an exception but does not want to handle it itself.

Instead, it allows the caller to handle it.

For example:

```java
void transaction() throws Exception {

    throw new Exception("Transaction failed");
}
```

The method is effectively saying:

> "I am not handling this exception here. Caller, you deal with it."

Then the caller can handle it:

```java
try {

    transaction();

}
catch (Exception e) {

    System.out.println("Exception handled");
}
```

Flow:

```text
transaction()
      ↓
Exception
      ↓
caller
      ↓
catch
      ↓
handled
```

---

# 🧒 7.10 The Idea of "Duck/Avoid Exception"

You may hear the phrase:

> **Duck an exception**

This is an informal way of describing the situation where a method does not handle an exception itself and instead declares it with `throws`, allowing responsibility to move to the caller.

For example:

```java
void fun() throws Exception {
}
```

The method is essentially saying:

> "I am leaving the handling responsibility to whoever calls me."

So:

```text
Method
  ↓
doesn't handle here
  ↓
throws
  ↓
caller takes responsibility
```

This is commonly discussed especially with **checked exceptions**.

---

# 🧒 7.11 `throws` Does Not Handle an Exception

This is a very common confusion.

Look at:

```java
void fun() throws Exception {
}
```

Some beginners think:

> "`throws` handles the exception."

No.

`throws` does **not** handle the exception.

Instead:

```text
try-catch
   ↓
handles exception

throws
   ↓
declares exception possibility/propagation
```

---

# 🧒 7.12 `try-catch` vs `throws`

### Using `try-catch`

```java
void fun() {

    try {

        // risky code

    }
    catch (Exception e) {

        // handling
    }
}
```

The method handles the exception itself.

### Using `throws`

```java
void fun() throws Exception {

    // risky code
}
```

The method does not handle it there; it declares the exception so the caller can take responsibility.

Think:

```text
try-catch
    ↓
"I will handle it."

throws
    ↓
"Caller, you may need to handle it."
```

---

# 🧒 7.13 Simple Example Without `throws`

Suppose:

```java
static void fun() {

    try {

        int result = 10 / 0;

    }
    catch (Exception e) {

        System.out.println("Handled");
    }
}
```

Here:

```text
fun()
 ↓
exception
 ↓
catch inside fun()
 ↓
handled
```

The exception does not need to be passed to the caller because `fun()` handled it.

---

# 🧒 7.14 Simple Example With `throws`

Now imagine:

```java
static void fun() throws Exception {

    throw new Exception("Problem");
}
```

There is no `catch` inside `fun()`.

The method declares:

```java
throws Exception
```

Therefore, the caller must take responsibility for the exception.

For example:

```java
public static void main(String[] args) {

    try {

        fun();

    }
    catch (Exception e) {

        System.out.println("Handled in main()");
    }
}
```

Flow:

```text
main()
 ↓
fun()
 ↓
exception
 ↓
caller
 ↓
catch
```

---

# 🧒 7.15 Understanding `throw` Again

Now compare:

```java
throw new Exception("Problem");
```

and:

```java
throws Exception
```

The first one is an **action**.

The second one is a **declaration**.

```text
throw
 ↓
Actually throws

throws
 ↓
Declares
```

---

# 🧒 7.16 `throw` vs `throws` — Basic Table

| `throw`                             | `throws`                                 |
| ----------------------------------- | ---------------------------------------- |
| Used to actually throw an exception | Used to declare exceptions               |
| Used inside method/block code       | Used in method declaration               |
| Works with an exception object      | Works with exception type(s)             |
| Can explicitly throw/rethrow        | Warns/delegates responsibility to caller |
| Example: `throw e;`                 | Example: `void fun() throws Exception`   |

Memory trick:

> **`throw` throws. `throws` tells.**

---

# 🧒 7.17 Understanding `throw e`

Suppose:

```java
catch (Exception e) {

    throw e;
}
```

The variable `e` refers to an exception object.

Therefore:

```java
throw e;
```

means:

> "Throw this exception object again."

This is called **rethrowing**.

---

# 🧒 7.18 Combining `throw` and `throws`

The two keywords can appear together.

Example:

```java
void fun() throws Exception {

    throw new Exception("Problem");
}
```

Here:

```text
throws Exception
       ↓
declares that Exception may leave fun()

throw new Exception(...)
       ↓
actually creates and throws the exception
```

So:

```text
throws = declaration
throw  = action
```

---

# 🧒 7.19 ATM Example — The Real-Life Situation

Let's return to the ATM.

We have:

```text
BankApp
   ↓
Bank
   ↓
ATM
```

Methods:

```text
BankApp
   main()

Bank
   connect()

ATM
   transaction()
```

Suppose the ATM finds a problem.

The ATM may handle the problem first.

But the Bank may also need to know.

Therefore:

```text
ATM
 ↓
catch exception
 ↓
do some processing
 ↓
throw exception again
 ↓
Bank
```

The ATM can declare:

```java
void transaction() throws Exception
```

This warns the Bank:

> "My transaction method may pass an exception to you."

---

# 🧒 7.20 ATM Class

Consider:

```java
class ATM {

    void transaction() throws Exception {

        try {

            throw new Exception("Transaction failed");

        }
        catch (Exception e) {

            System.out.println("ATM handled exception");

            throw e;
        }
    }
}
```

Let's understand it carefully.

---

# 🧒 7.21 `transaction() throws Exception`

This line:

```java
void transaction() throws Exception
```

says:

> "`transaction()` may pass an `Exception` to the method that calls it."

The caller in our example will be:

```text
Bank.connect()
```

Therefore:

```text
ATM.transaction()
       ↓
warns
       ↓
Bank.connect()
```

---

# 🧒 7.22 Exception Occurs Inside ATM

Inside:

```java
try {

    throw new Exception("Transaction failed");
}
```

This line:

```java
throw new Exception("Transaction failed");
```

does two things:

### First

Creates an exception object:

```text
Exception object
message = "Transaction failed"
```

### Second

Throws that object.

Flow:

```text
new Exception(...)
       ↓
object created
       ↓
throw
       ↓
exception thrown
```

---

# 🧒 7.23 ATM Catches the Exception

The ATM has:

```java
catch (Exception e)
```

Therefore, the exception reaches this block.

It prints:

```text
ATM handled exception
```

The ATM has now caught the exception.

But it doesn't stop there.

It executes:

```java
throw e;
```

---

# 🧒 7.24 ATM Rethrows the Exception

This:

```java
throw e;
```

rethrows the exception.

Remember:

```text
Exception object
       ↓
       e
       ↓
throw e
```

The ATM says:

> "I processed this exception, but the Bank also needs to know about it."

So the exception moves toward the caller.

```text
ATM.transaction()
       ↓
throw e
       ↓
Bank.connect()
```

---

# 🧒 7.25 Bank Calls ATM

Now consider:

```java
class Bank {

    void connect() throws Exception {

        ATM atm = new ATM();

        atm.transaction();
    }
}
```

Inside `connect()`:

```java
atm.transaction();
```

calls the ATM's transaction method.

Therefore:

```text
Bank.connect()
      ↓
ATM.transaction()
```

But `transaction()` declares:

```java
throws Exception
```

So the Bank must either:

1. Handle the exception, or
2. Declare it onward with `throws`.

---

# 🧒 7.26 Bank Also Uses `throws`

The Bank can write:

```java
void connect() throws Exception
```

This means:

> "I am not handling the exception here either. The caller of `connect()` should be prepared."

The caller of `connect()` is:

```text
BankApp.main()
```

So:

```text
ATM.transaction()
       ↓
Bank.connect()
       ↓
BankApp.main()
```

---

# 🧒 7.27 Exception Movement in the ATM–Bank Example

The complete movement is:

```text
BankApp.main()
       ↓
Bank.connect()
       ↓
ATM.transaction()
       ↓
Exception occurs
       ↓
ATM catch
       ↓
ATM processes exception
       ↓
throw e
       ↓
Bank.connect()
       ↓
throws Exception
       ↓
BankApp.main()
       ↓
catch
```

This is the complete idea of caller responsibility.

---

# 🧒 7.28 BankApp Handles the Exception

The application can finally handle it:

```java
class BankApp {

    public static void main(String[] args) {

        Bank bank = new Bank();

        try {

            bank.connect();

        }
        catch (Exception e) {

            System.out.println("Exception handled in BankApp");
        }
    }
}
```

Now the exception reaches `main()`.

`main()` has a `catch`.

Therefore:

```text
main()
 ↓
catch
 ↓
Exception handled in BankApp
```

---

# 🧒 7.29 Complete ATM–Bank Program

```java
class ATM {

    void transaction() throws Exception {

        System.out.println("Transaction Started");

        try {

            throw new Exception("Transaction failed");

        }
        catch (Exception e) {

            System.out.println("ATM handled exception");

            throw e;
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

            System.out.println("Exception handled in BankApp");
        }

        System.out.println("main() ending");
    }
}
```

---

# 🧒 7.30 Understanding the Program From the Beginning

Execution begins:

```java
public static void main(String[] args)
```

Then:

```java
Bank bank = new Bank();
```

creates a Bank object.

Then:

```java
bank.connect();
```

calls:

```text
Bank.connect()
```

---

# 🧒 7.31 Bank Establishes Connection

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

creates an ATM object.

Then:

```java
atm.transaction();
```

calls the ATM transaction.

Flow:

```text
main()
 ↓
connect()
 ↓
transaction()
```

---

# 🧒 7.32 ATM Starts Transaction

The ATM prints:

```text
Transaction Started
```

Then:

```java
throw new Exception("Transaction failed");
```

creates and throws an exception.

Flow:

```text
Transaction Started
       ↓
Exception created
       ↓
Exception thrown
```

---

# 🧒 7.33 ATM Handles and Rethrows

The exception enters:

```java
catch (Exception e)
```

The ATM prints:

```text
ATM handled exception
```

Then:

```java
throw e;
```

rethrows the exception.

So the exception now leaves `transaction()`.

```text
ATM.transaction()
       ↓
catch
       ↓
throw e
       ↓
Bank.connect()
```

---

# 🧒 7.34 Bank Passes Responsibility to Main

The Bank has:

```java
void connect() throws Exception
```

The Bank therefore does not handle the exception.

The exception travels to the caller:

```text
BankApp.main()
```

`main()` has:

```java
catch (Exception e)
```

So `main()` handles it.

Output:

```text
Exception handled in BankApp
```

---

# 🧒 7.35 What About `Connection terminated`?

Look carefully:

```java
atm.transaction();

System.out.println("Connection terminated");
```

The exception was rethrown from:

```java
atm.transaction();
```

Therefore normal execution does **not** continue directly to:

```java
System.out.println("Connection terminated");
```

inside `connect()`.

Instead, the exception leaves `connect()` and moves to its caller.

Therefore:

```text
Connection terminated
```

will **not** be printed in this particular program.

This is an important effect of exception propagation.

---

# 🧒 7.36 Final Complete Understanding

The entire concept can now be remembered as one story.

```text
                 BankApp
                    │
                  main()
                    │
                    │ calls
                    ▼
                  Bank
                    │
                connect()
                    │
                    │ calls
                    ▼
                  ATM
                    │
              transaction()
                    │
                    ▼
             Exception occurs
                    │
                    ▼
             catch(Exception e)
                    │
                    │
              ATM handles it
                    │
                    ▼
                 throw e
                    │
                    ▼
             Bank.connect()
                    │
              throws Exception
                    │
                    ▼
             BankApp.main()
                    │
                    ▼
             catch(Exception e)
                    │
                    ▼
             Exception handled
                    │
                    ▼
              main() ending
```

## 🧠 Lifetime Memory Rules

### Rule 1

```text
throw
```

**Actually throws an exception object.**

---

### Rule 2

```text
throws
```

**Declares that a method may throw/pass an exception to its caller.**

---

### Rule 3

```text
throw e;
```

means:

> Throw/rethrow the exception object referred to by `e`.

---

### Rule 4

```java
void fun() throws Exception
```

does **not** mean an exception definitely occurs.

It declares that an `Exception` may be thrown/passed from that method.

---

### Rule 5

`throws` does not handle an exception.

```text
try-catch → handles
throws    → declares/delegates
```

---

### Rule 6

A method using `throws` can leave exception-handling responsibility to its caller.

```text
Method
   ↓
throws Exception
   ↓
Caller
   ↓
handles exception
```

---

### Rule 7

`throw` and `throws` can be used together.

```java
void fun() throws Exception {

    throw new Exception("Problem");
}
```

Here:

```text
throws → declaration
throw  → actual throwing
```

---

### Rule 8

For rethrowing:

```java
catch (Exception e) {

    throw e;
}
```

means:

```text
Catch exception
      ↓
Do something with it
      ↓
Throw same exception again
      ↓
Caller receives it
```

---

## 🧠 The Ultimate Memory Trick

```text
┌─────────────────────────────────────────┐
│                 throw                   │
│                                         │
│       "I am throwing it NOW."           │
└─────────────────────────────────────────┘

                    VS

┌─────────────────────────────────────────┐
│                throws                   │
│                                         │
│ "I am warning my CALLER about it."      │
└─────────────────────────────────────────┘
```

### One sentence to remember forever:

> **`throw` is the action of throwing an exception; `throws` is the warning/declaration that a method may pass an exception to its caller.**
