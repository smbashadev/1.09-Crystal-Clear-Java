# 🧒 14. Exception Rules During Method Overriding — Rule 2: No Exception

### 1. Basic Idea

When a child class overrides a parent method, the child method **does not have to throw an exception**, even when the parent method declares an exception.

For example:

```text
Parent → throws IOException
Child  → no exception
```

This is completely valid.

---

### 2. What Is Method Overriding?

Method overriding happens when a child class provides its own implementation of a method that already exists in the parent class.

Example:

```java
class Parent {

    void fun() throws IOException {
        System.out.println("Parent");
    }
}
```

The child can provide its own `fun()` method.

---

### 3. Parent Method

Our parent method is:

```java
void fun() throws IOException
```

The important part is:

```java
throws IOException
```

This tells the caller that the parent method may throw an `IOException`.

---

### 4. What Is `IOException`?

`IOException` means **Input/Output Exception**.

It is commonly associated with problems while working with input or output operations, such as reading from or writing to files.

Its simplified hierarchy is:

```text
Throwable
   ↓
Exception
   ↓
IOException
```

`IOException` is a **checked exception**.

---

### 5. Child Method

The child overrides the parent's method:

```java
class Child extends Parent {

    @Override
    void fun() {
        System.out.println("Child");
    }
}
```

Notice that the child does **not** write:

```java
throws IOException
```

That is allowed.

---

### 6. Complete Program

```java
import java.io.IOException;

class Parent {

    void fun() throws IOException {

        System.out.println("Parent method");

    }
}

class Child extends Parent {

    @Override
    void fun() {

        System.out.println("Child method");

    }
}

class Demo {

    public static void main(String[] args) {

        Child obj = new Child();

        obj.fun();

    }
}
```

Output:

```text
Child method
```

---

### 7. What Happened?

The parent says:

```java
void fun() throws IOException
```

So the parent method **may throw** `IOException`.

But the child says:

```java
void fun()
```

The child method does not declare any exception.

This is valid.

---

### 8. Why Is This Allowed?

Think of the parent as giving a warning:

> "My version of this method may have an IOException."

The child says:

> "My version does not have that problem."

There is no problem with the child giving **less exception responsibility** to the caller.

---

### 9. Simple Real-World Analogy

Imagine a parent says:

> "When I travel, I might need an umbrella because it may rain."

The child says:

> "For my trip, I don't need an umbrella."

There is nothing wrong with the child having **fewer problems** than the parent.

Similarly:

```text
Parent → may throw IOException
Child  → throws nothing
```

is valid.

---

### 10. Important Principle

In method overriding, the child method cannot introduce a **new broader checked-exception requirement** than the parent method.

But the child can choose to throw **no exception**.

Therefore:

```text
Parent → IOException
Child  → No exception
```

is valid.

---

### 11. Understanding `throws`

In:

```java
void fun() throws IOException
```

`throws` is part of the method declaration.

It tells the caller:

```text
"This method may throw IOException."
```

The child removes that declaration:

```java
void fun()
```

Now the child method does not declare an exception.

---

### 12. The Child Method Is Still Overriding

Removing `throws IOException` does **not** stop overriding.

These methods still have the same method name and parameter list:

```java
Parent:
void fun() throws IOException
```

```java
Child:
void fun()
```

The `throws IOException` part does not have to be repeated for the child to override the method.

---

### 13. Method Signature Understanding

For overriding, focus on:

```java
void fun()
```

The child has:

```java
void fun()
```

So the child provides its own implementation of the parent's method.

The exception declaration does not require the child to repeat the parent's checked exception.

---

### 14. Execution Flow

The execution is:

```text
main()
  ↓
Child object created
  ↓
obj.fun()
  ↓
Child's overridden fun()
  ↓
"Child method" printed
  ↓
Program continues normally
```

No `IOException` is declared by the child method.

---

### 15. Parent and Child Comparison

```text
Parent
  ↓
fun()
  ↓
throws IOException
```

Child:

```text
Child
  ↓
fun()
  ↓
no exception
```

Therefore:

```text
Parent → IOException
Child  → No exception
         ↓
       VALID
```

---

### 16. Another Example

Parent:

```java
class Parent {

    void read() throws IOException {

        System.out.println("Reading");

    }
}
```

Child:

```java
class Child extends Parent {

    @Override
    void read() {

        System.out.println("Child reading");

    }
}
```

This is valid.

The child has removed the checked exception declaration.

---

### 17. Why This Is Useful

Suppose the parent method performs an operation that can cause an `IOException`.

The child may provide a different implementation that does not perform that operation.

Therefore, the child may not need to declare `IOException`.

For example:

```text
Parent → reads from file → IOException possible
Child  → uses fixed data → IOException not needed
```

---

### 18. Checked Exception Connection

`IOException` is a checked exception.

Checked exceptions are important during overriding.

If the parent declares:

```java
throws IOException
```

the child cannot simply introduce an unrelated broader checked exception.

But the child can:

```text
1. Throw no exception
2. Throw an appropriate narrower checked exception
3. Throw an unchecked RuntimeException
```

For this rule, we are focusing on:

```text
Parent → IOException
Child  → No exception
```

---

### 19. Compare With Rule 1

**Rule 1:**

```text
Parent → Exception
Child  → ArithmeticException
```

Allowed because `ArithmeticException` is an unchecked exception.

**Rule 2:**

```text
Parent → IOException
Child  → No exception
```

Allowed because the child can choose not to declare the parent's checked exception.

---

### 20. What the Caller Experiences

Suppose a reference is:

```java
Parent obj = new Child();
```

and we call:

```java
obj.fun();
```

Because the reference type is `Parent`, the compiler considers the parent's declaration:

```java
throws IOException
```

So the caller may still need to handle or declare `IOException` based on the **reference type**.

This is an important practical point.

---

### 21. Example With Parent Reference

```java
import java.io.IOException;

class Parent {

    void fun() throws IOException {

        System.out.println("Parent");

    }
}

class Child extends Parent {

    @Override
    void fun() {

        System.out.println("Child");

    }
}

class Demo {

    public static void main(String[] args) throws IOException {

        Parent obj = new Child();

        obj.fun();

    }
}
```

Output:

```text
Child
```

Even though the child method does not declare `IOException`, the caller is using a `Parent` reference.

Therefore, the compiler uses the parent's declared checked exception when checking this call.

---

### 22. Why Does the Child Still Execute?

This is because of **runtime polymorphism**.

The reference is:

```java
Parent obj
```

but the actual object is:

```java
new Child()
```

Therefore:

```text
Parent reference
      ↓
Child object
      ↓
Child's overridden method executes
```

---

### 23. Important Distinction

There are two different questions:

**What does the compiler know about the method?**

```text
Reference type
```

**Which overridden method actually runs?**

```text
Actual object
```

In:

```java
Parent obj = new Child();
```

the reference type is `Parent`, but the actual object is `Child`.

Therefore the child implementation runs.

---

### 24. Simple Analogy

Imagine a remote control labeled:

```text
PARENT
```

but the actual machine connected to it is:

```text
CHILD
```

The control follows the parent's available instructions, but when the command is executed, the child's implementation performs the action.

Similarly:

```text
Parent reference
        ↓
Child object
        ↓
Child method executes
```

---

### 25. Common Confusion

Do not think:

> "If the parent throws `IOException`, the child must also write `throws IOException`."

Incorrect.

The child can simply write:

```java
void fun()
```

This is valid.

---

### 26. Common Mistake

Do not confuse:

```java
void fun() throws IOException
```

with:

```java
void fun() throws RuntimeException
```

`IOException` is a checked exception.

`RuntimeException` is unchecked.

They follow different overriding rules.

---

### 27. Common Mistake — "No Exception Means No Overriding"

This is also incorrect.

The following is still overriding:

```java
Parent:
void fun() throws IOException
```

```java
Child:
void fun()
```

The child does not need to repeat the exception declaration.

---

### 28. Important Rules

Remember:

* A parent method may declare a checked exception.
* The child overriding method may declare **no exception**.
* The child does not have to repeat `throws IOException`.
* `IOException` is a checked exception.
* Removing the exception declaration does not prevent overriding.
* The child method can provide a simpler implementation.
* When using a parent reference, the caller may still have to satisfy the parent's checked-exception declaration.
* The actual child method can execute through runtime polymorphism.

---

### 29. Rule in One Line

The rule is:

```text
Parent → throws IOException
Child  → no exception
        ↓
      VALID
```

The child is allowed to provide an overriding method that throws **nothing**.

---

### 30. Comparison Table

| Parent Method        | Child Method                        | Valid? |
| -------------------- | ----------------------------------- | ------ |
| `throws IOException` | No exception                        | ✅ Yes  |
| `throws Exception`   | No exception                        | ✅ Yes  |
| `throws IOException` | `throws IOException`                | ✅ Yes  |
| `throws IOException` | `throws RuntimeException`           | ✅ Yes  |
| `throws IOException` | Broader unrelated checked exception | ❌ No   |

---

### 31. Real-World Understanding

Think of a parent employee saying:

> "This task may create a paperwork problem."

The child employee performs a simpler version of the task and says:

> "My version creates no paperwork problem."

The child is reducing the problem, not increasing it.

Similarly:

```text
Parent → IOException possible
Child  → IOException not declared
```

is allowed.

---

### 32. Interview Understanding

A good interview answer is:

> **In method overriding, an overriding child method is allowed to throw no exception even if the parent method declares an exception such as `IOException`. The child is not required to repeat the parent's exception declaration.**

Example:

```java
class Parent {
    void fun() throws IOException { }
}

class Child extends Parent {
    @Override
    void fun() { }
}
```

This is valid.

---

### 33. Easy Way to Remember

Think:

```text
Parent
   ↓
More responsibility

Child
   ↓
Less responsibility
```

For checked exceptions:

```text
Parent → IOException
Child  → Nothing
```

**Less exception responsibility is allowed.**

---

### 34. Connection With Rule 1

Keep both rules together:

```text
RULE 1
Parent → Exception
Child  → RuntimeException
          ↓
        Allowed

RULE 2
Parent → IOException
Child  → Nothing
          ↓
        Allowed
```

So far, the important idea is:

> **The child should not create a broader checked-exception burden for callers.**

---

### 35. Memory Trick

Remember:

> **"Parent may throw, child may choose not to."**

Or simply:

```text
PARENT
IOException
   ↓
CHILD
No Exception
   ↓
VALID ✅
```

---

### 36. Complete Lifetime Understanding

```text
                    Parent
                       ↓
                  void fun()
                       ↓
               throws IOException
                       ↓
                 Child Override
                       ↓
                  void fun()
                       ↓
                 No Exception
                       ↓
                    VALID
                       ↓
       Child does not need to repeat
             IOException
                       ↓
          Child implementation runs
                       ↓
              Program continues
```

**Core memory rule:**

> **If a parent method declares a checked exception such as `IOException`, the child overriding method can declare no exception at all. The child is allowed to remove the parent's exception declaration.**
