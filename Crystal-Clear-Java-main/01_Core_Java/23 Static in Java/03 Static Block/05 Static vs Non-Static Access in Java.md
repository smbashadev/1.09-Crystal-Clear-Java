# 🧒 Static vs Non-Static Access in Java

This topic is **very important for understanding Java's static and non-static concepts**.

The easiest rule to remember is:

> **Static members can be directly accessed from both static and non-static contexts. But non-static members need an object, so they cannot be directly accessed from a static context.**

Let's understand it step by step.

---

# 1. First Understand the Two Types

## Static Variable

```java
static int x = 10;
```

It belongs to the **class**.

Think:

```text
Class
  ↓
static x
  ↓
Common to objects
```

---

## Non-Static Variable

```java
int y = 20;
```

It belongs to an **object**.

Think:

```text
Object
  ↓
non-static y
  ↓
Each object has its own copy
```

---

# 2. Static Variable from Static Block ✅

A static block can directly access a static variable.

```java
class Demo {

    static int x = 10;

    static {
        System.out.println(x);
    }

    public static void main(String[] args) {
    }
}
```

Output:

```text
10
```

Why?

Both are associated with the class:

```text
static variable
      ↓
static block
```

So this is allowed.

### Remember:

```text
STATIC → STATIC ✅
```

---

# 3. Static Variable from Static Method ✅

A static method can directly access a static variable.

```java
class Demo {

    static int x = 10;

    static void display() {
        System.out.println(x);
    }

    public static void main(String[] args) {

        Demo.display();
    }
}
```

Output:

```text
10
```

Both belong to the class.

```text
static variable
      ↑
static method
```

So:

```text
STATIC → STATIC ✅
```

---

# 4. Static Variable from Non-Static Block ✅

A non-static block can also access a static variable directly.

```java
class Demo {

    static int x = 10;

    {
        System.out.println(x);
    }

    public static void main(String[] args) {

        Demo d = new Demo();
    }
}
```

Output:

```text
10
```

Why?

A non-static block has access to the object's context, and it can also access class-level static members.

So:

```text
STATIC variable
       ↑
NON-STATIC block
```

is allowed.

### Remember:

```text
NON-STATIC → STATIC ✅
```

---

# 5. Static Variable from Non-Static Method ✅

A non-static method can also directly access a static variable.

```java
class Demo {

    static int x = 10;

    void display() {
        System.out.println(x);
    }

    public static void main(String[] args) {

        Demo d = new Demo();

        d.display();
    }
}
```

Output:

```text
10
```

Again:

```text
Non-static method
       ↓
can access
       ↓
Static variable
```

So this is allowed.

---

# 6. Non-Static Variable from Non-Static Block ✅

Now:

```java
class Demo {

    int y = 20;

    {
        System.out.println(y);
    }

    public static void main(String[] args) {

        Demo d = new Demo();
    }
}
```

Output:

```text
20
```

Why does this work?

Because the non-static block executes as part of **object initialization**.

The object exists, and `y` belongs to that object.

Think:

```text
Object
  ↓
y
  ↓
Non-static block
```

So:

```text
NON-STATIC → NON-STATIC ✅
```

---

# 7. Non-Static Variable from Non-Static Method ✅

This is also allowed.

```java
class Demo {

    int y = 20;

    void display() {

        System.out.println(y);
    }

    public static void main(String[] args) {

        Demo d = new Demo();

        d.display();
    }
}
```

Output:

```text
20
```

The method is being called using an object:

```java
d.display();
```

Therefore, Java knows which object's `y` should be used.

```text
d
 ↓
y = 20
 ↓
display()
```

---

# 8. Non-Static Variable Directly Inside Static Block ❌

This is where beginners commonly get confused.

Consider:

```java
class Demo {

    int y = 20;

    static {

        System.out.println(y);
    }

}
```

This produces a **compile-time error**.

Why?

Because the static block belongs to the class.

But:

```java
int y = 20;
```

belongs to an object.

There may be many objects:

```text
Object 1 → y = 10
Object 2 → y = 20
Object 3 → y = 30
```

If the static block says:

```java
System.out.println(y);
```

Java asks:

> **"Which object's `y` do you mean?"**

There is no object reference.

Therefore:

```text
STATIC BLOCK
     ↓
NON-STATIC VARIABLE
     ↓
❌ Compile-time error
```

---

# 9. How Can a Static Block Access a Non-Static Variable?

It needs an object.

For example:

```java
class Demo {

    int y = 20;

    static {

        Demo d = new Demo();

        System.out.println(d.y);
    }

    public static void main(String[] args) {
    }
}
```

Now it works because we explicitly created an object:

```text
static block
     ↓
create object
     ↓
d
     ↓
d.y
```

The important difference is:

```java
System.out.println(y);   // ❌
```

versus:

```java
System.out.println(d.y); // ✅
```

---

# 10. Non-Static Variable Directly Inside Static Method ❌

Same problem.

```java
class Demo {

    int y = 20;

    static void display() {

        System.out.println(y);
    }

}
```

Compile-time error.

Why?

`display()` is static:

```text
static method
     ↓
belongs to class
```

But `y` is:

```text
non-static variable
     ↓
belongs to object
```

No object has been specified.

---

# 11. How to Access It Correctly

Create an object:

```java
class Demo {

    int y = 20;

    static void display() {

        Demo d = new Demo();

        System.out.println(d.y);
    }

    public static void main(String[] args) {

        Demo.display();
    }
}
```

Now:

```text
static method
      ↓
create object
      ↓
d
      ↓
d.y
```

Therefore it works.

---

# 🧠 The BIG Rule

Look at this:

```text
                 WHAT ARE YOU ACCESSING?
                         │
             ┌───────────┴───────────┐
             ↓                       ↓
          STATIC                 NON-STATIC
             │                       │
             │                       │
       Easy to access          Needs an object
       from anywhere           from static context
```

More specifically:

```text
STATIC VARIABLE
   ↓
Static block       ✅
Static method      ✅
Non-static block   ✅
Non-static method  ✅
```

But:

```text
NON-STATIC VARIABLE
   ↓
Non-static block   ✅
Non-static method  ✅
Static block       ❌ directly
Static method      ❌ directly
```

---

# 📊 Complete Table

| Variable                | Static Block | Static Method | Non-Static Block | Non-Static Method |
| ----------------------- | -----------: | ------------: | ---------------: | ----------------: |
| **Static variable**     |            ✅ |             ✅ |                ✅ |                 ✅ |
| **Non-static variable** |   ❌ directly |    ❌ directly |                ✅ |                 ✅ |

For static contexts, a non-static variable can still be accessed **through an object reference**:

```java
Demo d = new Demo();
System.out.println(d.y);
```

---

# 🎯 Why Is This Rule Necessary?

Think about a classroom.

### Static

The school has:

```text
School name = ABC School
```

There is one common school name.

A class-level operation can directly use it.

```text
Class → schoolName
```

### Non-static

Every student has a different name:

```text
Student 1 → Basha
Student 2 → Ravi
Student 3 → Kumar
```

If a class-level method simply says:

```text
name
```

Java doesn't know which student you mean.

You must say:

```text
Student 1's name
```

In Java, that means using an object reference:

```java
student1.name
```

---

# ⭐ Golden Rule

## Remember these two sentences:

> **Static can directly access static.**

```text
static → static ✅
```

> **Non-static can access both static and non-static.**

```text
non-static → static     ✅
non-static → non-static ✅
```

But:

> **Static cannot directly access non-static because non-static data belongs to an object.**

```text
static → non-static ❌
```

Unless you provide an object:

```java
Demo d = new Demo();
d.y;
```

---

# 🧠 Life-Time Memory Trick

Imagine **STATIC = CLASS** and **NON-STATIC = OBJECT**.

```text
        CLASS
          ↓
       STATIC
          ↓
   "I don't need a
      particular object"
```

```text
        OBJECT
          ↓
     NON-STATIC
          ↓
   "I belong to a
      particular object"
```

Therefore:

```text
STATIC → STATIC       ✅
STATIC → NON-STATIC   ❌ directly

NON-STATIC → STATIC   ✅
NON-STATIC → NON-STATIC ✅
```

### 🔥 Final shortcut

> **If Java is in a static context and you want an instance variable, give Java an object.**

```java
System.out.println(y);    // ❌

Demo d = new Demo();
System.out.println(d.y);  // ✅
```

That is the core idea behind **static vs non-static access**.
