# 🧒 Static Block in Java

A **static block** is a special block of code that Java executes **automatically when the class is loaded**, before `main()` is executed.

Think of it like:

> **"Before you start the main work, do this preparation first."**

---

# 1. What Is a Static Block?

A static block is written using the keyword:

```java
static
```

followed by `{ }`.

### Syntax

```java
static {
    // statements
}
```

That's it.

There is:

* no method name
* no `()`
* no return type

Example:

```java
static {
    System.out.println("Static Block");
}
```

---

# 2. When Does a Static Block Execute?

Consider:

```java
class Demo {

    static {
        System.out.println("Static Block");
    }

    public static void main(String[] args) {
        System.out.println("Main Method");
    }
}
```

Output:

```text
Static Block
Main Method
```

Notice the order:

```text
Class loaded
     ↓
Static block executes
     ↓
main() executes
```

So the static block executes **before `main()`** when the class is initialized.

---

# 3. Why Does It Execute Before `main()`?

Java first needs to initialize the class.

A simple way to imagine the process is:

```text
Java starts
    ↓
Loads the class
    ↓
Initializes static members
    ↓
Executes static block
    ↓
Calls main()
```

Therefore:

```text
static block → first
main()       → later
```

---

# 4. Complete Program

```java
class Demo {

    static {
        System.out.println("Hello from Static Block");
    }

    public static void main(String[] args) {

        System.out.println("Hello from Main Method");
    }
}
```

### Output

```text
Hello from Static Block
Hello from Main Method
```

---

# 5. Static Block for Static Initialization

A static block is commonly used when we need to perform **initialization related to the class**.

For example:

```java
class Student {

    static int count;

    static {
        count = 100;
        System.out.println("Static initialization completed");
    }

    public static void main(String[] args) {

        System.out.println(count);
    }
}
```

Output:

```text
Static initialization completed
100
```

Here:

```java
static int count;
```

is a static variable.

And:

```java
static {
    count = 100;
}
```

initializes it.

---

# 6. Real-Life Example 🏫

Imagine a school opens in the morning.

Before students start their classes, the school might:

```text
Open school
    ↓
Turn on electricity
    ↓
Prepare classrooms
    ↓
Start classes
```

The preparation happens first.

Similarly:

```text
Class loading
      ↓
Static initialization
      ↓
main()
```

The static block can be thought of as part of that **class initialization/preparation**.

---

# 7. Multiple Static Blocks

You can have more than one static block.

Example:

```java
class Demo {

    static {
        System.out.println("Static Block 1");
    }

    static {
        System.out.println("Static Block 2");
    }

    public static void main(String[] args) {

        System.out.println("Main Method");
    }
}
```

Output:

```text
Static Block 1
Static Block 2
Main Method
```

They execute **in the order they appear** in the class.

```text
Static Block 1
       ↓
Static Block 2
       ↓
main()
```

---

# 8. Does a Static Block Need an Object?

No.

You don't write:

```java
Demo d = new Demo();
```

to make the static block execute.

The static block is associated with **class initialization**, not object creation.

---

# 9. Static Block vs Static Method

Don't confuse these two.

### Static method

```java
static void display() {
    System.out.println("Hello");
}
```

It needs to be **called**:

```java
Demo.display();
```

### Static block

```java
static {
    System.out.println("Hello");
}
```

It executes automatically as part of class initialization.

You don't write:

```java
Demo.static();
```

There is no such call.

---

# 🆚 Static Block vs Static Method

| Static Block                            | Static Method                          |
| --------------------------------------- | -------------------------------------- |
| `static { }`                            | `static void method()`                 |
| No method name                          | Has a method name                      |
| No `()`                                 | Has `()`                               |
| Executes during class initialization    | Executes when invoked                  |
| Commonly used for static initialization | Used for reusable class-level behavior |

---

# 🧠 Remember Forever

Think:

```text
STATIC BLOCK
     ↓
Class preparation
     ↓
Static initialization
     ↓
main()
```

### Syntax

```java
static {
    // static initialization code
}
```

### ⭐ Golden Rule

> **A static block is executed automatically during class initialization, before `main()` is executed, and is commonly used for static initialization.**

### 🧠 Super-short memory trick

```text
static { }
    ↓
Automatic
    ↓
Class initialization
    ↓
Before main()
```

So whenever you see:

```java
static {
    System.out.println("Hello");
}
```

think:

> **"Java will execute this block automatically during class initialization, before `main()`."**
