# 🧒 Parent Method and `super.fun()`

When a **child class overrides a method of the parent class**, the child normally gets its **own version** of that method.

But sometimes the child also wants to execute the **original parent method**.

For this, we use:

```java
super.fun();
```

> 🧠 **`super.fun()` means: "Call the `fun()` method of my immediate parent class."**

---

# 1. Parent Has a Method

Suppose the parent class has:

```java
class Parent {

    void fun() {
        System.out.println("Parent fun()");
    }
}
```

So:

```text
Parent
  ↓
fun()
```

---

# 2. Child Overrides the Method

Now the child creates its own `fun()` method:

```java
class Child extends Parent {

    @Override
    void fun() {
        System.out.println("Child fun()");
    }
}
```

Now both classes have `fun()`:

```text
Parent → fun()
Child  → fun()
```

The child's `fun()` **overrides** the parent's `fun()`.

---

# 3. What Happens Normally?

```java
Child c = new Child();

c.fun();
```

Output:

```text
Child fun()
```

Why?

Because the child has its own overridden version.

```text
c.fun()
  ↓
Child fun()
```

---

# 4. How Can We Call the Parent Method?

Inside the child method, use:

```java
super.fun();
```

Example:

```java
class Parent {

    void fun() {
        System.out.println("Parent fun()");
    }
}

class Child extends Parent {

    @Override
    void fun() {

        System.out.println("Child fun()");

        super.fun();
    }
}
```

Now:

```java
Child c = new Child();

c.fun();
```

### Output

```text
Child fun()
Parent fun()
```

---

# 5. Understand the Flow

When we call:

```java
c.fun();
```

Java enters the child's overridden method:

```text
Child fun()
```

Then it reaches:

```java
super.fun();
```

This says:

> "Now execute my parent's `fun()`."

So:

```text
Child.fun()
    ↓
super.fun()
    ↓
Parent.fun()
```

---

# 6. Complete Program

```java
class Parent {

    void fun() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {

    @Override
    void fun() {

        System.out.println("Child method");

        super.fun();
    }
}

class Demo {

    public static void main(String[] args) {

        Child c = new Child();

        c.fun();
    }
}
```

### Output

```text
Child method
Parent method
```

---

# 7. Why Do We Use `super.fun()`?

Suppose the parent has some useful functionality:

```java
class Parent {

    void fun() {
        System.out.println("Common parent work");
    }
}
```

The child wants to add something extra:

```java
class Child extends Parent {

    @Override
    void fun() {

        super.fun();

        System.out.println("Additional child work");
    }
}
```

Now the child can **reuse the parent's method** and then add its own behavior.

Output:

```text
Common parent work
Additional child work
```

This is a very common use of `super`.

---

# 8. `fun()` vs `super.fun()`

Inside the child:

```java
fun();
```

refers to the child's method context and can lead to the overridden child implementation.

But:

```java
super.fun();
```

specifically refers to the **immediate parent's implementation**.

Think:

```text
fun()
 ↓
"My method"

super.fun()
 ↓
"My parent's method"
```

---

# 🧠 Simple Real-Life Example

Imagine:

```text
Parent → Cook()
Child  → Cook()
```

The child has learned a new cooking style.

When the child says:

> "I'll cook my way."

That's:

```java
fun();
```

But if the child says:

> "First, let me use my parent's original cooking method, then I'll add my own."

That's:

```java
super.fun();
```

---

# ⭐ Remember Forever

```text
Parent
   │
   └── fun()
          ↑
       super.fun()
          │
        Child
          │
       @Override
          │
         fun()
```

### Golden Rule:

> **`super.fun()` is used inside the child class to call the overridden `fun()` method of the immediate parent class.**

### Easy formula:

```text
Child overridden method
        +
super.fun()
        ↓
Parent method
```

### 🔥 Interview Answer

> **When a child class overrides a parent method, `super.fun()` is used to explicitly invoke the immediate parent's version of that method. It allows the child to reuse the parent's implementation while also providing its own additional behavior.**
