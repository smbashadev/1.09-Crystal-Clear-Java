# 🧒 Multiple Inheritance in Java

**Multiple Inheritance** means:

> 🧠 **One child class tries to inherit from more than one parent class.**

The structure would look like this:

```text
        Parent1          Parent2
           \              /
            \            /
                 Child
```

For example:

```text
Parent1
   ↓
  Child
   ↑
Parent2
```

Java **does not allow multiple inheritance through classes**.

The main reason is **ambiguity**, especially the **Diamond Problem**.

---

# 1. What Does Multiple Inheritance Mean?

Imagine we have two parent classes:

```java
class Parent1 {

    int x = 10;
}
```

and:

```java
class Parent2 {

    int x = 20;
}
```

Now imagine we try to create:

```java
class Child extends Parent1, Parent2 {
}
```

We might want:

```text
Parent1
   │
   ├── x = 10
   │
   └──────┐
          ↓
        Child
          ↑
   ┌──────┘
   │
Parent2
   │
   └── x = 20
```

But now there is a problem.

---

# 2. The Ambiguity Problem 🤔

Suppose we have:

```java
class Parent1 {

    int x = 10;
}

class Parent2 {

    int x = 20;
}
```

If `Child` inherited from both, what would this mean?

```java
System.out.println(x);
```

Should Java use:

```text
Parent1.x → 10
```

or:

```text
Parent2.x → 20
```

Java would have two possible answers.

```text
x
├── Parent1.x = 10
└── Parent2.x = 20
```

This is **ambiguity**.

---

# 3. The Diamond Problem 💎

The classic problem can be represented like this:

```text
             GrandParent
              /       \
             ↓         ↓
         Parent1     Parent2
             \         /
              \       /
                Child
```

It looks like a **diamond** ♦️.

That's why it is called the:

> **Diamond Problem**

The child receives the same member through two different paths.

---

# 4. Simple Example

Imagine:

```text
             Parent
            /      \
           ↓        ↓
       Parent1    Parent2
           \        /
            \      /
              Child
```

Suppose:

```java
Parent1 → int x = 10
Parent2 → int x = 20
```

Then the child asks:

```java
System.out.println(x);
```

Which `x` should it use?

```text
Parent1.x → 10 ❓
Parent2.x → 20 ❓
```

There is no single obvious answer.

That's the ambiguity Java wants to avoid.

---

# 5. Java Does NOT Allow This ❌

Java does not permit a class to extend two classes.

This is invalid:

```java
class Child extends Parent1, Parent2 {
}
```

❌ Compilation error.

Java's class inheritance syntax allows only **one direct superclass**.

So:

```text
❌ Child extends Parent1, Parent2
```

is not allowed.

But:

```text
✅ Child extends Parent1
```

is allowed.

---

# 6. Why Did Java Choose This?

Java wants inheritance to be clear and predictable.

If two parents provide the same member:

```text
Parent1
   ↓
   x = 10

Parent2
   ↓
   x = 20
```

and the child inherits both:

```text
Child
  ↓
Which x?
```

This creates confusion.

So Java says:

> **A class can extend only one class.**

---

# 7. Visual Comparison

### Single Inheritance ✅

```text
       Parent
          ↓
        Child
```

Clear.

---

### Multiple Inheritance ❌ Through Classes

```text
       Parent1       Parent2
           \           /
            \         /
              Child
```

Potential ambiguity.

---

# 8. Your `Parent1` and `Parent2` Example

Let's imagine what we **would** want:

```java
class Parent1 {

    int value = 10;
}
```

```java
class Parent2 {

    int value = 20;
}
```

Now:

```text
Parent1
 value = 10
     \
      \
      Child
      /
     /
Parent2
 value = 20
```

The Child has two possible `value` variables.

```text
Child
  ↓
value
  ├── Parent1 → 10
  └── Parent2 → 20
```

Therefore:

> ⚠️ **Ambiguity occurs because the child has two possible sources for the same member.**

---

# 9. Important: Java Supports Multiple Inheritance Through Interfaces

There is an important Java concept to remember.

Java doesn't allow:

```text
Multiple inheritance through classes ❌
```

But Java does allow a class to implement multiple interfaces:

```text
Interface1       Interface2
     \              /
      \            /
          Child
```

For example:

```java
interface Parent1 {

    void show();
}

interface Parent2 {

    void display();
}

class Child implements Parent1, Parent2 {

    public void show() {
        System.out.println("Parent1 method");
    }

    public void display() {
        System.out.println("Parent2 method");
    }
}
```

Here:

```java
class Child implements Parent1, Parent2
```

is allowed.

So remember:

```text
Multiple inheritance through classes     ❌
Multiple inheritance through interfaces ✅
```

---

# ⭐ Remember Forever

### Multiple Inheritance

```text
One Child
   ↑
Two Parents
```

### Problem

```text
Parent1 → x = 10
Parent2 → x = 20
             ↓
           Child
             ↓
        Which x?
```

This creates **ambiguity**.

### Diamond Problem

```text
             GrandParent
              /       \
             ↓         ↓
         Parent1     Parent2
             \         /
              \       /
                Child
```

### Java Rule

> **Java does not support multiple inheritance through classes because it can create ambiguity and the diamond problem.**

But:

> **Java supports multiple inheritance of type through interfaces using `implements`.**

### 🧠 One-Line Memory Trick

```text
1 Parent + 1 Child       → Single Inheritance ✅
1 Parent + Many Children → Hierarchical ✅
Parent → Child → Child   → Multilevel ✅
2 Classes → 1 Child     → Multiple ❌
```

### 🔥 Interview Answer

> **Multiple inheritance means a child class inherits from more than one parent class. Java does not support multiple inheritance through classes because it can create ambiguity, especially when both parent classes contain the same member. This is commonly known as the Diamond Problem. Java can achieve multiple inheritance of type through interfaces.**
