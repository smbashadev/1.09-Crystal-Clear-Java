# 🧒 Non-Static Block in Java

A **non-static block** is a block of code that executes **automatically whenever an object is created**.

It is also commonly called an **instance initialization block**.

The basic order is:

```text id="7az8d4"
Object creation
      ↓
Non-static block
      ↓
Constructor
```

So remember:

> **Object created → Non-static block → Constructor**

---

## 1. What Is a Non-Static Block?

It looks like this:

```java id="zj8v0w"
{
    // statements
}
```

Notice that there is **no `static` keyword**.

Example:

```java id="7bxr0y"
class Demo {

    {
        System.out.println("Non-Static Block");
    }

}
```

This block is called a **non-static block**.

---

# 2. When Does It Execute?

The non-static block executes when an **object is created**.

For example:

```java id="j7y5u2"
Demo d = new Demo();
```

When Java creates the object, the non-static block executes automatically.

Conceptually:

```text id="7a3l6h"
new Demo()
    ↓
Object created
    ↓
Non-static block
    ↓
Constructor
```

---

# 3. Complete Program

```java id="n3nqkk"
class Demo {

    {
        System.out.println("Non-Static Block");
    }

    Demo() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {

        Demo d = new Demo();
    }
}
```

### Output

```text id="j4l8jk"
Non-Static Block
Constructor
```

Notice:

```text id="xj5n2e"
Non-Static Block
        ↓
Constructor
```

The block executes **before the constructor body**.

---

# 4. Why Does the Non-Static Block Execute Before the Constructor?

When you write:

```java id="kqzq5s"
Demo d = new Demo();
```

Java has to create and initialize the new object.

A simplified view is:

```text id="8w6q0k"
new Demo()
    ↓
Memory for object is created
    ↓
Instance initialization happens
    ↓
Non-static block executes
    ↓
Constructor executes
```

So the constructor doesn't get the first chance to run.

The non-static initialization block runs first.

---

# 5. Think of It Like a House 🏠

Imagine you're building a house.

Before the owner enters:

```text id="e4j6hy"
Build house
    ↓
Prepare house
    ↓
Owner enters
```

Similarly:

```text id="u6g9z1"
Create object
      ↓
Prepare/initialize object
      ↓
Constructor
```

The non-static block can be used for **common instance initialization logic**.

---

# 6. Multiple Objects

This is very important.

Suppose:

```java id="1z7qkg"
class Demo {

    {
        System.out.println("Non-Static Block");
    }

    Demo() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {

        Demo d1 = new Demo();
        Demo d2 = new Demo();
    }
}
```

### Output

```text id="x1m8gj"
Non-Static Block
Constructor
Non-Static Block
Constructor
```

Why?

Because the block executes **for every object creation**.

```text id="4o5cwf"
d1 = new Demo()
       ↓
Non-static block
       ↓
Constructor

d2 = new Demo()
       ↓
Non-static block
       ↓
Constructor
```

---

# 7. One Object → One Execution

If you create:

```java id="3q6m7j"
Demo d1 = new Demo();
```

The block executes once.

If you create:

```java id="aqp9i5"
Demo d2 = new Demo();
```

It executes again.

If you create:

```java id="p4u0z6"
Demo d3 = new Demo();
```

It executes again.

Therefore:

```text id="z0r0sv"
3 objects
   ↓
3 executions of non-static block
```

---

# 8. Non-Static Block vs Static Block

This is very important because you just learned static blocks.

### Static block

```java id="5wxqg3"
static {
    System.out.println("Static Block");
}
```

It is associated with **class initialization**.

### Non-static block

```java id="6ph5rc"
{
    System.out.println("Non-Static Block");
}
```

It is associated with **object initialization**.

Think:

```text id="xeky5j"
STATIC
  ↓
Class
  ↓
Class initialization
```

```text id="m9z7ce"
NON-STATIC
  ↓
Object
  ↓
Object initialization
```

---

# 9. Static Block + Non-Static Block + Constructor

Now let's put everything together.

```java id="sv0z3m"
class Demo {

    static {
        System.out.println("Static Block");
    }

    {
        System.out.println("Non-Static Block");
    }

    Demo() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {

        System.out.println("Main Started");

        Demo d = new Demo();
    }
}
```

### Output

```text id="7smk9a"
Static Block
Main Started
Non-Static Block
Constructor
```

Let's understand it:

```text id="c5z05s"
Class initialization
       ↓
Static Block
       ↓
main()
       ↓
new Demo()
       ↓
Non-Static Block
       ↓
Constructor
```

---

# 10. Very Important Difference

### Static block

Normally executes when the class is initialized, not once for every object.

```text id="ywx0s3"
Class initialization
       ↓
Static block
```

### Non-static block

Executes as part of initialization of **each newly created object**.

```text id="4x9k0p"
Object 1 → Non-static block
Object 2 → Non-static block
Object 3 → Non-static block
```

---

# 11. Real-Life Example 🏫

Imagine a school.

### Static block

Before the school starts operating:

```text id="y2d7kt"
School setup
   ↓
Common preparation
```

This is class-level thinking.

### Non-static block

Every time a **new student joins**, some student-specific preparation happens:

```text id="c9r4ft"
New Student
    ↓
Student setup
    ↓
Student constructor
```

Each new student gets this initialization.

---

# 🧠 Remember Forever

### Non-static block syntax:

```java id="ppyn0e"
{
    // initialization code
}
```

### Execution:

```text id="fdc4f3"
new Object()
     ↓
Object created
     ↓
Non-static block
     ↓
Constructor
```

### Multiple objects:

```text id="atv2l1"
Object 1 → Block → Constructor

Object 2 → Block → Constructor

Object 3 → Block → Constructor
```

---

# ⭐ Golden Rule

> **A non-static block is an instance initialization block that executes automatically during the initialization of each object, before the constructor body executes.**

### 🧠 Super-short memory trick

```text id="q9q7bf"
STATIC BLOCK
     ↓
CLASS

NON-STATIC BLOCK
     ↓
OBJECT
     ↓
CONSTRUCTOR
```

So whenever you see:

```java id="qv6fkl"
{
    System.out.println("Hello");
}
```

inside a class, think:

> **"This is a non-static block, and it runs when an object is created, before the constructor body."**
