# 🧒 15. Exception Rules During Method Overriding — Rule 3: Checked / Non-Runtime Exception

### 1. Basic Idea

When the parent method declares a **checked exception**, the child method that overrides it cannot freely choose any other checked exception.

The child exception must be **compatible with the exception declared by the parent**.

The main idea is:

```text
Parent exception
      ↓
Child exception must be compatible
```

---

### 2. What Is a Checked Exception?

A checked exception is an exception that Java checks at **compile time**.

For example:

```java
IOException
SQLException
```

These are checked exceptions.

They are not subclasses of `RuntimeException`.

---

### 3. Parent Method

Suppose the parent method is:

```java
class Parent {

    void fun() throws IOException {
        System.out.println("Parent method");
    }
}
```

Here the parent declares:

```java
throws IOException
```

So the parent method says:

> "This method may throw `IOException`."

---

### 4. Child Method Rule

When the child overrides this method, the checked exception declared by the child must be compatible with the parent's exception.

For example:

```text
Parent → IOException
Child  → IOException
```

This is valid.

---

### 5. Same Exception

The simplest compatible case is using the **same exception**.

Parent:

```java
void fun() throws IOException
```

Child:

```java
void fun() throws IOException
```

This is valid.

The child is declaring exactly the same checked exception as the parent.

---

### 6. What Does "Compatible" Mean?

For checked exceptions during overriding, the child exception must have an appropriate **Is-A relationship** with the parent's declared exception.

In simple terms:

```text
Child exception
      ↓
Is-A
      ↓
Parent exception
```

The child exception must fit within the exception type allowed by the parent.

---

### 7. What Is an "Is-A" Relationship?

"Is-A" means inheritance.

For example:

```text
ChildException IS-A ParentException
```

because the child exception class extends the parent exception class.

The same idea applies to exception classes.

If:

```java
class ChildException extends ParentException
```

then:

```text
ChildException IS-A ParentException
```

---

### 8. Simple Real-World Analogy

Imagine a parent says:

> "I allow problems from the vehicle category."

The child can say:

> "My problem is specifically a car problem."

A car is a vehicle.

So:

```text
Car
 ↓
IS-A
 ↓
Vehicle
```

This is compatible.

But if the child says:

> "My problem is a completely unrelated food problem."

that does not fit the parent's category.

The same basic idea applies to checked exceptions.

---

### 9. Valid Example — Same Exception

Parent:

```java
class Parent {

    void fun() throws IOException {

        System.out.println("Parent");

    }
}
```

Child:

```java
class Child extends Parent {

    @Override
    void fun() throws IOException {

        System.out.println("Child");

    }
}
```

This is valid.

---

### 10. Complete Valid Program

```java
import java.io.IOException;

class Parent {

    void fun() throws IOException {

        System.out.println("Parent method");

    }
}

class Child extends Parent {

    @Override
    void fun() throws IOException {

        System.out.println("Child method");

    }
}

class Demo {

    public static void main(String[] args) throws IOException {

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

### 11. Why Is This Valid?

The parent says:

```text
IOException
```

The child also says:

```text
IOException
```

So there is no conflict.

```text
Parent → IOException
Child  → IOException
             ↓
           Same
             ↓
           VALID
```

---

### 12. Another Compatible Situation

Suppose the parent declares a more general checked exception:

```java
throws Exception
```

and the child declares:

```java
throws IOException
```

This is compatible because:

```text
IOException
    ↓
Exception
```

`IOException` is an `Exception`.

So:

```text
Parent → Exception
Child  → IOException
```

can be valid.

---

### 13. Why Does the Is-A Relationship Matter?

Suppose the parent says:

```java
void fun() throws Exception
```

The caller is prepared for an `Exception`.

If the child throws:

```java
IOException
```

the caller's preparation for `Exception` is already broad enough to cover `IOException`.

Because:

```text
IOException IS-A Exception
```

Therefore, it is compatible.

---

### 14. Invalid Example

Now consider:

```text
Parent → IOException
Child  → SQLException
```

This is invalid.

Why?

Because `SQLException` is not a subclass of `IOException`.

There is no:

```text
SQLException IS-A IOException
```

relationship.

---

### 15. Invalid Program

```java
import java.io.IOException;
import java.sql.SQLException;

class Parent {

    void fun() throws IOException {

        System.out.println("Parent");

    }
}

class Child extends Parent {

    @Override
    void fun() throws SQLException {

        System.out.println("Child");

    }
}
```

This produces a compilation error.

---

### 16. Why Does It Fail?

The parent says:

```text
IOException
```

The child says:

```text
SQLException
```

Java asks whether:

```text
SQLException IS-A IOException
```

The answer is:

```text
NO
```

Therefore, the child cannot introduce `SQLException` here.

---

### 17. Compare the Two Cases

**Valid:**

```text
Parent → IOException
Child  → IOException
```

Same exception.

```text
Parent → Exception
Child  → IOException
```

Compatible because:

```text
IOException IS-A Exception
```

**Invalid:**

```text
Parent → IOException
Child  → SQLException
```

Because:

```text
SQLException IS-A IOException
```

is false.

---

### 18. Simple Hierarchy

The important relationship is:

```text
Exception
   ├── IOException
   └── SQLException
```

They are both exceptions, but they are separate branches.

Therefore:

```text
IOException
   ↓
SQLException
```

is not an inheritance relationship.

And:

```text
SQLException
   ↓
IOException
```

is also not an inheritance relationship.

---

### 19. Why Can't the Child Use `SQLException`?

Imagine the parent contract says:

```text
"I may throw IOException."
```

The caller prepares for `IOException`.

The child suddenly says:

```text
"I may throw SQLException."
```

The caller was not promised that type of checked exception by the parent contract.

Therefore, Java rejects it.

---

### 20. Important Concept — Parent Contract

The parent's checked exception declaration becomes part of what the caller must be prepared for.

The child overriding method must respect that contract.

So:

```text
Parent contract
      ↓
Child must follow it
      ↓
Compatible checked exceptions only
```

---

### 21. Valid Relationship Example

Suppose:

```text
Parent → Exception
Child  → IOException
```

The hierarchy is:

```text
Exception
   ↑
IOException
```

Therefore:

```text
IOException IS-A Exception
```

So the child exception is compatible with the parent exception.

---

### 22. Invalid Relationship Example

Suppose:

```text
Parent → IOException
Child  → SQLException
```

The hierarchy is:

```text
Exception
   ├── IOException
   └── SQLException
```

They are siblings.

Therefore:

```text
SQLException IS-A IOException
```

is false.

So the child declaration is invalid.

---

### 23. Real-World Analogy

Think about categories:

```text
Animal
 ├── Dog
 └── Cat
```

If someone says:

> "Give me an Animal."

giving a Dog is fine because:

```text
Dog IS-A Animal
```

But if someone specifically says:

> "Give me a Dog."

giving a Cat is not valid because:

```text
Cat IS-A Dog
```

is false.

The same idea applies to checked exceptions.

---

### 24. Java Example With a Child Exception

Suppose we have:

```java
class MyException extends IOException {
}
```

Then:

```text
MyException
     ↓
IOException
```

Therefore:

```text
MyException IS-A IOException
```

If the parent declares:

```java
throws IOException
```

the child can declare:

```java
throws MyException
```

because it is compatible.

---

### 25. Important Difference From `RuntimeException`

Do not mix Rule 1 and Rule 3.

For `RuntimeException` and its subclasses, Java does not impose the same checked-exception restriction.

But for checked exceptions:

```text
Parent checked exception
        ↓
Child checked exception
        ↓
Must be compatible
```

This is the important Rule 3.

---

### 26. Three Cases to Remember

```text
CASE 1
Parent → IOException
Child  → IOException
        ↓
      VALID
```

```text
CASE 2
Parent → Exception
Child  → IOException
        ↓
      VALID
```

because:

```text
IOException IS-A Exception
```

```text
CASE 3
Parent → IOException
Child  → SQLException
        ↓
      INVALID
```

because:

```text
SQLException IS-A IOException
```

is false.

---

### 27. Common Confusion

Do not think:

> "Both `IOException` and `SQLException` are exceptions, so they are compatible."

Being under the same parent does **not** automatically make two checked exceptions compatible for overriding.

They must have the required inheritance relationship.

```text
Exception
 ├── IOException
 └── SQLException
```

`IOException` and `SQLException` are separate types.

---

### 28. Common Mistake

This is invalid:

```java
class Parent {

    void fun() throws IOException {
    }
}

class Child extends Parent {

    @Override
    void fun() throws SQLException {
    }
}
```

because:

```text
SQLException
```

is not a subtype of:

```text
IOException
```

---

### 29. Important Rules

Remember:

* This rule applies to **checked/non-runtime exceptions**.
* The child exception must be compatible with the parent's declared checked exception.
* The same exception is valid.
* A more specific compatible checked exception can be valid.
* The **Is-A relationship** is important.
* `IOException` → `IOException` is valid.
* `Exception` → `IOException` is valid because `IOException IS-A Exception`.
* `IOException` → `SQLException` is invalid.
* `SQLException` and `IOException` are separate subclasses of `Exception`.

---

### 30. Quick Comparison

| Parent        | Child          | Result    | Reason                        |
| ------------- | -------------- | --------- | ----------------------------- |
| `IOException` | `IOException`  | ✅ Valid   | Same exception                |
| `Exception`   | `IOException`  | ✅ Valid   | `IOException IS-A Exception`  |
| `IOException` | `SQLException` | ❌ Invalid | No `Is-A` relationship        |
| `Exception`   | `SQLException` | ✅ Valid   | `SQLException IS-A Exception` |

---

### 31. Think From Parent to Child

Always start with the parent:

```text
What exception did the parent declare?
```

Then check the child:

```text
Is the child's checked exception the same
or compatible with the parent's exception?
```

For example:

```text
Parent → IOException
Child  → SQLException
```

Check:

```text
SQLException IS-A IOException?
```

No.

Therefore:

```text
INVALID
```

---

### 32. Compiler's Point of View

Java's compiler protects the parent method's contract.

The parent declares:

```java
throws IOException
```

The child cannot change that checked-exception contract to an unrelated checked exception:

```java
throws SQLException
```

Therefore, the compiler reports an error.

---

### 33. Interview Understanding

A strong interview answer is:

> **When a child overrides a method that declares a checked exception, the child can declare the same checked exception or a compatible narrower checked exception. The child cannot declare an unrelated checked exception.**

Example:

```text
Parent → IOException
Child  → IOException
```

Valid.

But:

```text
Parent → IOException
Child  → SQLException
```

Invalid.

---

### 34. Memory Trick

Remember:

> **"Checked exception: Child must stay inside the parent's exception family."**

Visualize:

```text
Parent Exception
       ↑
Child Exception
```

The child must have an **Is-A relationship** with the parent's declared exception.

For example:

```text
Exception
   ↑
IOException
```

is compatible.

But:

```text
IOException     SQLException
      ↑              ↑
      └── separate ──┘
```

is not compatible.

---

### 35. Three Overriding Rules So Far

Keep the three rules together:

```text
RULE 1
Parent → Exception
Child  → RuntimeException
        ↓
      VALID
```

```text
RULE 2
Parent → IOException
Child  → No Exception
        ↓
      VALID
```

```text
RULE 3
Parent → IOException
Child  → IOException
        ↓
      VALID
```

But:

```text
Parent → IOException
Child  → SQLException
        ↓
      INVALID
```

---

### 36. Complete Lifetime Understanding

```text
                  Parent Method
                       ↓
             declares checked exception
                       ↓
                 Child overrides
                       ↓
          Check child's checked exception
                       ↓
              Is it compatible?
                       ↓
              ┌────────┴────────┐
              ↓                 ↓
             YES                NO
              ↓                 ↓
           VALID             INVALID
              ↓                 ↓
       Same exception       Unrelated
       or compatible        checked exception
```

For the exact examples:

```text
Parent → IOException
Child  → IOException
        ↓
      SAME
        ↓
      VALID
```

But:

```text
Parent → IOException
Child  → SQLException
        ↓
SQLException is NOT-A IOException
        ↓
      INVALID
```

**Core memory rule:**

> **For checked exceptions during method overriding, the child cannot introduce an unrelated checked exception. The child exception must be the same as, or compatible with, the exception allowed by the parent.**
