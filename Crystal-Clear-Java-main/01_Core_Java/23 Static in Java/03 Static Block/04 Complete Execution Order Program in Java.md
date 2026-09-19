# 🧒 Complete Execution Order Program in Java

Now let's put **everything together**:

* Static block
* Main method
* Non-static block
* Constructor
* Static method
* Non-static method

The most important thing to understand is:

> **Java does NOT execute methods simply because they are written inside the class. A method executes only when it is called.**

So we need to carefully look at **what happens automatically** and **what happens only when we call it**.

---

# 1. Complete Program

```java
class Demo {

    // 1. Static Block
    static {
        System.out.println("1. Static Block");
    }

    // 2. Non-Static Block
    {
        System.out.println("3. Non-Static Block");
    }

    // 3. Constructor
    Demo() {
        System.out.println("4. Constructor");
    }

    // 4. Static Method
    static void staticMethod() {
        System.out.println("5. Static Method");
    }

    // 5. Non-Static Method
    void nonStaticMethod() {
        System.out.println("6. Non-Static Method");
    }

    // Main Method
    public static void main(String[] args) {

        System.out.println("2. Main Method");

        // Calling static method
        staticMethod();

        // Creating object
        Demo d = new Demo();

        // Calling non-static method
        d.nonStaticMethod();
    }
}
```

---

# 2. Output

```text
1. Static Block
2. Main Method
5. Static Method
3. Non-Static Block
4. Constructor
6. Non-Static Method
```

Notice something very important.

The order is **not simply**:

```text
Static Block
Main
Non-static Block
Constructor
Static Method
Non-static Method
```

Why?

Because the **static method is called inside `main()` before the object is created**.

Therefore it executes before the non-static block and constructor.

---

# 3. Let's Follow Java Step-by-Step

## Step 1 — Static Block

Java initializes the class.

The static block executes:

```java
static {
    System.out.println("1. Static Block");
}
```

Output:

```text
1. Static Block
```

Think:

```text
Class initialization
       ↓
Static Block
```

---

# 4. Step 2 — JVM Calls `main()`

After class initialization, the JVM calls:

```java
public static void main(String[] args)
```

The first statement inside `main()` is:

```java
System.out.println("2. Main Method");
```

Output:

```text
2. Main Method
```

So far:

```text
Static Block
     ↓
Main Method
```

---

# 5. Step 3 — Static Method Is Called

Inside `main()` we have:

```java
staticMethod();
```

This calls:

```java
static void staticMethod() {
    System.out.println("5. Static Method");
}
```

So:

```text
main()
  ↓
staticMethod()
  ↓
Static Method executes
```

Output:

```text
5. Static Method
```

### Important

A static method does **not automatically execute just because it is declared**.

It executes when you call it.

For example:

```java
staticMethod();
```

---

# 6. Step 4 — Object Is Created

Next:

```java
Demo d = new Demo();
```

Now Java starts creating the object.

This is where the **non-static block** and **constructor** become important.

---

# 7. Step 5 — Non-Static Block

During initialization of the newly created object, the non-static block executes:

```java
{
    System.out.println("3. Non-Static Block");
}
```

Output:

```text
3. Non-Static Block
```

So:

```text
new Demo()
    ↓
Non-static block
```

---

# 8. Step 6 — Constructor

After the non-static initialization, the constructor body executes:

```java
Demo() {
    System.out.println("4. Constructor");
}
```

Output:

```text
4. Constructor
```

Therefore:

```text
new Demo()
    ↓
Non-static Block
    ↓
Constructor
```

---

# 9. Step 7 — Non-Static Method

Finally:

```java
d.nonStaticMethod();
```

calls:

```java
void nonStaticMethod() {
    System.out.println("6. Non-Static Method");
}
```

Output:

```text
6. Non-Static Method
```

A non-static method needs an object reference:

```java
d.nonStaticMethod();
```

because `d` refers to the newly created `Demo` object.

---

# 🧠 Complete Flow

Now put everything together:

```text
             Java starts
                 ↓
          Class initialization
                 ↓
           Static Block
                 ↓
          JVM calls main()
                 ↓
           Main Method
                 ↓
        staticMethod() called
                 ↓
          Static Method
                 ↓
          new Demo()
                 ↓
       Non-Static Block
                 ↓
           Constructor
                 ↓
    d.nonStaticMethod() called
                 ↓
       Non-Static Method
```

---

# 10. Very Important Concept

There are **two different categories** here.

### Automatically executed during initialization

```text
Static Block
Non-Static Block
Constructor
```

Their execution is connected to class/object initialization.

### Executed only when called

```text
Static Method
Non-Static Method
```

Methods do not execute merely because they exist.

They need to be invoked.

---

# 11. Static Method vs Non-Static Method

### Static method

```java
static void display() {
    System.out.println("Static");
}
```

Can be called using:

```java
Demo.display();
```

or from another static context in the same class:

```java
display();
```

No object is required merely to invoke the static method.

---

### Non-static method

```java
void display() {
    System.out.println("Non-Static");
}
```

Normally called through an object:

```java
Demo d = new Demo();

d.display();
```

---

# 12. What Happens If We Change the Order?

Suppose we write:

```java
public static void main(String[] args) {

    Demo d = new Demo();

    staticMethod();

    d.nonStaticMethod();
}
```

Then the output becomes:

```text
Static Block
Non-Static Block
Constructor
Static Method
Non-Static Method
```

Why?

Because the object was created **before** the static method was called.

This teaches us something very important:

> **The actual execution order depends on when the methods and object creation are encountered in the running code.**

---

# 🎯 The Four Most Important Things

### 1. Static Block

```java
static {
}
```

Runs during **class initialization**.

---

### 2. Main Method

```java
public static void main(String[] args)
```

The JVM invokes `main()` after the class has been initialized successfully.

---

### 3. Non-Static Block + Constructor

When:

```java
new Demo();
```

creates an object:

```text
Non-static block
       ↓
Constructor
```

---

### 4. Methods

Methods execute **when called**.

```text
static method
     ↓
call it

non-static method
     ↓
call it using object
```

---

# ⭐ Golden Rule

Remember this sequence:

```text
CLASS INITIALIZATION
       ↓
STATIC BLOCK
       ↓
MAIN()
       ↓
whatever MAIN calls
       ↓
OBJECT CREATION
       ↓
NON-STATIC BLOCK
       ↓
CONSTRUCTOR
       ↓
NON-STATIC METHOD when called
```

But don't memorize a fixed position for static/non-static methods.

### 🧠 The real rule is:

> **Blocks and constructors are tied to initialization; methods run only when they are called.**

That one rule will help you solve almost every **Java execution-order interview question**.
