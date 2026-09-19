# 🧒 13. Exception Rules During Method Overriding — Rule 1: `RuntimeException`

### 1. Basic Idea

When a child class **overrides** a method of the parent class, Java has special rules about exceptions.

For **unchecked exceptions**, such as `RuntimeException` and its subclasses, the child method has more freedom.

The child method can throw:

```text
RuntimeException
```

or one of its subclasses, even when the parent method declares a different exception such as:

```java
throws Exception
```

---

### 2. First Understand Method Overriding

Suppose the parent has:

```java
class Parent {

    void fun() {
        System.out.println("Parent fun");
    }
}
```

and the child provides its own version:

```java
class Child extends Parent {

    void fun() {
        System.out.println("Child fun");
    }
}
```

The child method is **overriding** the parent method.

The method name and parameters must match appropriately for overriding.

---

### 3. What Is `RuntimeException`?

`RuntimeException` is a class in Java's exception hierarchy.

It belongs to:

```text
Throwable
   ↓
Exception
   ↓
RuntimeException
```

Examples of its subclasses include:

```text
ArithmeticException
NullPointerException
ArrayIndexOutOfBoundsException
NegativeArraySizeException
```

These are called **unchecked exceptions**.

---

### 4. Why Is `RuntimeException` Special?

Java does not impose the same overriding restriction on unchecked exceptions that it imposes on checked exceptions.

Therefore, a child method can introduce a `RuntimeException` or a subclass of it.

For example:

```text
Parent → throws Exception
Child  → throws ArithmeticException
```

This is allowed.

---

### 5. Parent Method

Consider:

```java
class Parent {

    void fun() throws Exception {
        System.out.println("Parent method");
    }
}
```

The parent method declares:

```java
throws Exception
```

This means the parent method says that it may pass an exception to its caller.

---

### 6. Child Method

Now the child overrides the method:

```java
class Child extends Parent {

    @Override
    void fun() throws ArithmeticException {
        System.out.println("Child method");
    }
}
```

The child declares:

```java
throws ArithmeticException
```

This is valid.

Why?

Because `ArithmeticException` is a subclass of `RuntimeException`.

---

### 7. Exception Relationship

The relationship is:

```text
Exception
   ↓
RuntimeException
   ↓
ArithmeticException
```

Therefore:

```text
ArithmeticException
        ↓
RuntimeException
        ↓
Exception
```

`ArithmeticException` is an unchecked exception.

---

### 8. Complete Program

```java
class Parent {

    void fun() throws Exception {

        System.out.println("Parent method");

    }
}

class Child extends Parent {

    @Override
    void fun() throws ArithmeticException {

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

### 9. Understanding the Parent Code

The parent contains:

```java
void fun() throws Exception
```

Here:

```text
fun()
 ↓
Parent method
 ↓
declares Exception
```

The parent is allowed to declare `Exception`.

---

### 10. Understanding the Child Code

The child contains:

```java
void fun() throws ArithmeticException
```

This method overrides the parent's `fun()`.

The child chooses to declare:

```text
ArithmeticException
```

instead of:

```text
Exception
```

This is allowed because `ArithmeticException` is an unchecked exception.

---

### 11. What Does `@Override` Mean?

The annotation:

```java
@Override
```

tells Java:

> "This method is intended to override a method from the parent class."

It helps the compiler check that the child method really overrides the parent method.

---

### 12. What Does `throws` Mean Here?

The keyword:

```java
throws
```

is used in the method declaration.

Example:

```java
void fun() throws ArithmeticException
```

It indicates that the method may throw that exception.

It is different from:

```java
throw
```

which is used to actually throw an exception object.

---

### 13. Important Point About `RuntimeException`

The parent declaring:

```java
throws Exception
```

does **not prevent** the child from declaring:

```java
throws ArithmeticException
```

The child is not required to repeat exactly:

```java
throws Exception
```

when dealing with an unchecked exception.

---

### 14. Real-World Analogy

Imagine a parent says:

> "This machine may have a problem."

The child says:

> "In my version, the specific problem I may have is an overheating problem."

The child is describing a more specific kind of problem.

Similarly:

```text
Parent:
Exception

Child:
ArithmeticException
```

The child exception is more specific.

---

### 15. Execution Flow

The program works like this:

```text
main()
  ↓
Child object created
  ↓
obj.fun()
  ↓
Child's overridden fun()
  ↓
Child method executes
  ↓
ArithmeticException declaration is allowed
```

No exception is actually thrown in this particular program because the method only prints a message.

---

### 16. Declaring vs Throwing

This is an important distinction.

The child writes:

```java
void fun() throws ArithmeticException
```

This **declares** that the method may throw the exception.

It does not automatically create the exception.

To actually throw an exception, code would need something such as:

```java
throw new ArithmeticException();
```

---

### 17. Example That Actually Throws the Exception

```java
class Parent {

    void fun() throws Exception {

        System.out.println("Parent method");

    }
}

class Child extends Parent {

    @Override
    void fun() throws ArithmeticException {

        throw new ArithmeticException("Division problem");

    }
}

class Demo {

    public static void main(String[] args) {

        Child obj = new Child();

        try {

            obj.fun();

        }
        catch (ArithmeticException e) {

            System.out.println(e.getMessage());

        }
    }
}
```

Output:

```text
Division problem
```

---

### 18. What Happened in This Program?

The child overrides:

```java
void fun() throws Exception
```

with:

```java
void fun() throws ArithmeticException
```

Then the child actually throws:

```java
new ArithmeticException("Division problem")
```

The `catch` block receives that exception.

---

### 19. Exception Flow

```text
main()
   ↓
Child.fun()
   ↓
throw new ArithmeticException(...)
   ↓
ArithmeticException object created
   ↓
Exception propagates to caller
   ↓
catch (ArithmeticException e)
   ↓
Message printed
```

---

### 20. Why Is This Allowed?

The important rule is:

```text
Parent method → Exception
Child method  → RuntimeException subclass
```

This is permitted because `RuntimeException` and its subclasses are unchecked exceptions.

Example:

```text
Parent
throws Exception

Child
throws ArithmeticException
```

is valid.

---

### 21. Another Example

Parent:

```java
class Parent {

    void display() throws Exception {

    }
}
```

Child:

```java
class Child extends Parent {

    @Override
    void display() throws NullPointerException {

    }
}
```

This is also allowed because:

```text
NullPointerException
        ↓
RuntimeException
```

---

### 22. Another Example With Array Exception

Parent:

```java
class Parent {

    void display() throws Exception {

    }
}
```

Child:

```java
class Child extends Parent {

    @Override
    void display() throws ArrayIndexOutOfBoundsException {

    }
}
```

This is allowed because:

```text
ArrayIndexOutOfBoundsException
        ↓
RuntimeException
```

---

### 23. Important Comparison

These are different:

```text
Exception
```

is a checked exception category.

While:

```text
RuntimeException
```

and its subclasses are unchecked exceptions.

For this rule, the child has freedom to declare unchecked exceptions.

---

### 24. The Child Does Not Have to Throw Anything

There is another important point.

If the parent method declares:

```java
void fun() throws Exception
```

the child can override it without declaring any exception:

```java
@Override
void fun() {

}
```

This is allowed.

So the child can have:

```text
No exception
```

or:

```text
RuntimeException
```

or:

```text
RuntimeException subclass
```

subject to Java's overriding rules.

---

### 25. Example Without `throws`

```java
class Parent {

    void fun() throws Exception {

        System.out.println("Parent");

    }
}

class Child extends Parent {

    @Override
    void fun() {

        System.out.println("Child");

    }
}
```

This is valid.

The child does not need to repeat the parent's `throws Exception`.

---

### 26. Why This Rule Is Useful

Suppose the parent provides a general method contract:

```text
Parent
 ↓
may have Exception
```

The child implementation may encounter a specific unchecked problem.

For example:

```text
Child
 ↓
ArithmeticException
```

Java permits this because unchecked exceptions do not impose the same compile-time restrictions.

---

### 27. Common Confusion

Do not think:

> "If the parent throws `Exception`, the child must also throw `Exception`."

That is incorrect.

For unchecked exceptions, the child can declare a `RuntimeException` or one of its subclasses.

Example:

```java
Parent:
void fun() throws Exception

Child:
void fun() throws ArithmeticException
```

This is valid.

---

### 28. Common Mistake — Thinking `ArithmeticException` Is Checked

`ArithmeticException` is a subclass of:

```text
RuntimeException
```

Therefore, it is an **unchecked exception**.

Hierarchy:

```text
Throwable
   ↓
Exception
   ↓
RuntimeException
   ↓
ArithmeticException
```

This is why it can be declared by the overriding child method in this situation.

---

### 29. Common Mistake — Confusing `throw` and `throws`

Remember:

```java
throw new ArithmeticException();
```

means:

```text
Actually throw an exception
```

while:

```java
void fun() throws ArithmeticException
```

means:

```text
Declare that the method may throw an exception
```

So:

```text
throw  → action
throws → declaration/warning
```

---

### 30. Important Rules

Remember these rules:

* Method overriding involves a parent method and a child method.
* A child method can override a parent method that declares `Exception`.
* The child may declare a `RuntimeException` or its subclass.
* `ArithmeticException` is a subclass of `RuntimeException`.
* `RuntimeException` is an unchecked exception.
* The parent declaring `Exception` does not restrict the child from declaring `ArithmeticException`.
* The child may also choose not to declare an exception.
* `throw` actually throws an exception.
* `throws` declares that a method may throw an exception.

---

### 31. Parent vs Child

Keep this example in memory:

```text
Parent:

void fun() throws Exception
```

```text
Child:

@Override
void fun() throws ArithmeticException
```

Relationship:

```text
Exception
   ↓
RuntimeException
   ↓
ArithmeticException
```

Therefore, the child declaration is valid.

---

### 32. Quick Comparison

| Parent Method      | Child Method                  | Valid? |
| ------------------ | ----------------------------- | ------ |
| `throws Exception` | `throws ArithmeticException`  | ✅ Yes  |
| `throws Exception` | `throws RuntimeException`     | ✅ Yes  |
| `throws Exception` | no `throws`                   | ✅ Yes  |
| `throws Exception` | `throws NullPointerException` | ✅ Yes  |

The child can use an unchecked exception or no exception.

---

### 33. Real-World Understanding

Think of the parent as giving a broad warning:

```text
Parent:
"There may be an exception."
```

The child gives a more specific unchecked warning:

```text
Child:
"My implementation may have an ArithmeticException."
```

Java allows this because the child is not introducing a checked exception that creates a new compile-time burden for callers.

---

### 34. Interview Understanding

The important answer to remember is:

> **During method overriding, an overriding child method can throw unchecked exceptions (`RuntimeException` and its subclasses) without being restricted by the checked exception declared by the parent.**

Example:

```java
class Parent {
    void fun() throws Exception { }
}

class Child extends Parent {
    @Override
    void fun() throws ArithmeticException { }
}
```

This is valid.

---

### 35. Memory Trick

Remember:

```text
Parent
throws Exception
        ↓
Child
throws RuntimeException
        ↓
Allowed
```

The easiest sentence is:

> **"RuntimeException does not create a checked-exception restriction during overriding."**

And specifically:

```text
Parent → Exception
Child  → ArithmeticException
        ↓
        VALID
```

---

### 36. Complete Lifetime Understanding

```text
                    Parent
                      ↓
              void fun()
              throws Exception
                      ↓
                Method Override
                      ↓
                    Child
                      ↓
              void fun()
       throws ArithmeticException
                      ↓
       ArithmeticException is a
       RuntimeException subclass
                      ↓
             RuntimeException
                is unchecked
                      ↓
        Parent's Exception declaration
        does not restrict this child
                      ↓
                    VALID
```

The complete rule is:

> **When a child class overrides a parent method, the child method may throw `RuntimeException` or any of its subclasses, even if the parent method declares `throws Exception`. This is allowed because `RuntimeException` and its subclasses are unchecked exceptions.**
