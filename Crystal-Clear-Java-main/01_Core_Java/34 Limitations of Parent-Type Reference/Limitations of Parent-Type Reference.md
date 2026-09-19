# 🧒 Limitations of Parent-Type Reference

This is a **very important point in runtime polymorphism**.

The simple rule is:

> 🧠 **A parent reference can point to a child object, but through that reference you can access only the members available in the parent type.**

---

## 1. Parent Reference + Child Object

Suppose we have:

```java
class Parent {

    void fun() {
        System.out.println("Parent fun()");
    }
}
```

And a child:

```java
class Child extends Parent {

    @Override
    void fun() {
        System.out.println("Child fun()");
    }

    void specialFun() {
        System.out.println("Child special method");
    }
}
```

Here:

```text
Parent
  └── fun()

Child
  ├── fun()          ← overridden
  └── specialFun()   ← child-specific
```

---

# 2. Parent Reference Holds Child Object

Now:

```java
Parent p = new Child();
```

This means:

```text
Reference type → Parent
Actual object  → Child
```

So:

```text
        Parent
          ↑
          │ reference
          │
          p
          │
          ↓
        Child
        object
```

---

# 3. Parent Method Can Be Accessed ✅

We can call:

```java
p.fun();
```

This works because `fun()` exists in the parent.

But because the actual object is `Child`, the child's overridden method executes.

```text
p.fun()
   ↓
Child object
   ↓
Child.fun()
```

Output:

```text
Child fun()
```

This is **runtime polymorphism**.

---

# 4. Child-Specific Method Cannot Be Accessed ❌

Now try:

```java
p.specialFun();
```

This gives:

```text
❌ Compile-time error
```

Why?

Because `specialFun()` is present only in `Child`.

The **reference type** is `Parent`.

```text
Parent
  └── fun()

Child
  ├── fun()
  └── specialFun()
```

The compiler looks at the reference type:

```text
p → Parent
```

and asks:

> "Does `Parent` have `specialFun()`?"

Answer:

```text
NO ❌
```

Therefore:

```java
p.specialFun();   // ❌
```

---

# 5. Complete Program

```java
class Parent {

    void fun() {
        System.out.println("Parent method");
    }
}

class Child extends Parent {

    @Override
    void fun() {
        System.out.println("Child overridden method");
    }

    void specialFun() {
        System.out.println("Child-specific method");
    }
}

class Demo {

    public static void main(String[] args) {

        Parent p = new Child();

        // Parent/inherited method
        p.fun();

        // Child-specific method
        // p.specialFun();   // ❌ Compile-time error
    }
}
```

### Output

```text
Child overridden method
```

---

# 6. Why Is This a Limitation?

The object is actually:

```text
Child
```

So you might think:

> "Why can't I access `specialFun()`?"

Because Java separates:

```text
Reference type
       ↓
What you are allowed to access

Actual object type
       ↓
Which overridden implementation executes
```

This distinction is extremely important.

---

# 7. The Two Rules ⭐

For:

```java
Parent p = new Child();
```

### Rule 1 — Access

The **reference type** determines what methods can be accessed.

```text
Parent reference
      ↓
Can access Parent methods
      ↓
Cannot directly access Child-only methods
```

### Rule 2 — Overridden Method Execution

The **actual object** determines which overridden method executes.

```text
Child object
      ↓
Child's overridden method
```

---

# 8. Visualize It 🧠

```text
                 Parent
             ┌─────────────┐
             │ fun()       │
             └──────┬──────┘
                    ↑
                    │
             Parent p
                    │
                    ↓
                 Child
             ┌─────────────┐
             │ fun()       │ ← overridden
             │ specialFun()│ ← child-specific
             └─────────────┘
```

Through:

```java
p.fun();
```

you can access:

```text
fun() → ✅
```

But:

```java
p.specialFun();
```

is:

```text
specialFun() → ❌
```

---

# 9. How Can We Access the Child-Specific Method?

We can use **downcasting**:

```java
Parent p = new Child();

Child c = (Child) p;

c.specialFun();
```

Now the reference is:

```text
Child c
```

So:

```java
c.specialFun();
```

is accessible.

Output:

```text
Child-specific method
```

But remember: casting should only be done when the object really is compatible with the target type.

---

# ⭐ Easy Real-Life Example

Imagine:

```text
Parent = General Employee
Child  = Developer
```

A parent reference:

```java
Employee e = new Developer();
```

can access things defined by `Employee`.

But if `Developer` has:

```text
writeCode()
```

and `Employee` doesn't define it, then:

```java
e.writeCode();   // ❌
```

The object is a Developer, but the **reference type is Employee**.

---

# 🔥 Golden Rule

For:

```java
Parent ref = new Child();
```

remember:

```text
                 Parent Reference
                       ↓
             What can I ACCESS?
                       ↓
              Parent members only
                       ↓
                 Child-specific
                  members ❌


                 Child Object
                       ↓
       Which overridden method executes?
                       ↓
             Child method ✅
```

### Interview Answer

> **A parent-type reference can refer to a child object and can access the methods available in the parent type, including overridden methods. However, it cannot directly access child-specific or specialized methods that are not declared in the parent class. This is a limitation of using a parent-type reference in polymorphism.**
