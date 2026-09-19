# 🧒Polymorphism in Java

**Polymorphism** is one of the **four major pillars of Object-Oriented Programming (OOP)**.

The word **Polymorphism** comes from:

```text
Poly  = Many
Morphism = Forms
```

So:

> 🧠 **Polymorphism means "one entity having multiple forms."**

---

# 1. What Is an Entity?

An **entity** is simply something we are talking about or using.

For example:

```text
Person
Animal
Vehicle
Shape
```

An entity can behave differently in different situations.

---

# 2. Simple Real-Life Example 🧑

Think about one person named **Arjun**.

The same person can have different roles:

```text
                 Arjun
                   │
       ┌───────────┼───────────┐
       ↓           ↓           ↓
     Son        Student      Player
```

It is still **one person**:

```text
Arjun
```

But he has **multiple forms/roles**:

```text
Son
Student
Player
```

This idea is similar to **polymorphism**.

---

# 3. Another Easy Example 🔘

Think about a **mobile phone**.

The same button can perform different actions depending on the situation.

For example:

```text
One button
    ↓
Multiple behaviors
```

So the idea is:

> **One thing → Multiple forms/behaviors**

---

# 4. Polymorphism in Java

In Java, polymorphism allows one entity—such as a **method, reference, or object relationship**—to represent or exhibit different forms/behaviors depending on the situation.

The two major forms of polymorphism in Java are:

```text
Polymorphism
     │
     ├── Compile-Time Polymorphism
     │      ↓
     │   Method Overloading
     │
     └── Runtime Polymorphism
            ↓
       Method Overriding
```

You will study these separately.

---

# 5. Compile-Time Polymorphism

Suppose we have:

```java id="1i2t9m"
class Calculator {

    void add(int a, int b) {
        System.out.println(a + b);
    }

    void add(int a, int b, int c) {
        System.out.println(a + b + c);
    }
}
```

Here we have multiple versions of:

```text
add()
```

```text
add(int, int)
add(int, int, int)
```

The method name is the same, but the parameter lists are different.

This is **method overloading**.

It is commonly called:

> **Compile-time polymorphism.**

---

# 6. Runtime Polymorphism

Runtime polymorphism is commonly achieved through **method overriding**.

Example:

```java id="8h5q8d"
class Animal {

    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Dog extends Animal {

    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}
```

The parent has:

```text
sound()
```

The child also has:

```text
sound()
```

But the child provides a different implementation.

Therefore:

```text
Same method
      ↓
Different behavior
```

This is **runtime polymorphism**.

---

# 7. The Main Idea

Don't worry about the complicated terminology initially.

Just remember:

```text
ONE
 ↓
MULTIPLE FORMS
```

For example:

```text
Animal
  ↓
sound()

Dog
  ↓
sound() → Bark

Cat
  ↓
sound() → Meow
```

The concept is:

```text
Same general operation
        ↓
Different behavior
```

---

# ⭐ Remember Forever

### Definition

> **Polymorphism is an OOP concept in which one entity can exist or behave in multiple forms.**

### Word meaning:

```text
POLY
 ↓
Many

MORPH
 ↓
Forms
```

Therefore:

```text
POLYMORPHISM
      ↓
ONE ENTITY
      ↓
MULTIPLE FORMS
```

### 🧠 Golden Memory Trick

> **"One thing, many forms."**

That's the simplest way to remember **Polymorphism** for life.
