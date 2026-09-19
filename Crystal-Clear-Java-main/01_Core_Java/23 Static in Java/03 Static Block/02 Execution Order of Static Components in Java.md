# 🧒 Execution Order of Static Components in Java

When a Java program starts, Java does **not immediately jump into `main()`**.

First, Java prepares the class and its static components.

Think of it like preparing a school before students enter:

```text
Prepare everything
      ↓
Start the main work
```

For Java, the basic order is:

```text
Static components loaded
        ↓
Static variables initialized
        ↓
Static blocks executed
        ↓
JVM calls main()
        ↓
Main execution
```

---

## 1. Static Components Are Loaded

Suppose we have:

```java
class Demo {

    static int x = 10;

    static {
        System.out.println("Static Block");
    }

    public static void main(String[] args) {
        System.out.println("Main");
    }
}
```

When Java starts using this class, its **static-related class information is prepared during class initialization**.

Think:

```text
Demo class
   ↓
Static components
   ↓
Prepare them
```

---

## 2. Static Variables Are Initialized

Consider:

```java
static int x = 10;
```

Java initializes the static variable:

```text
x = 10
```

So conceptually:

```text
Static variable
      ↓
x = 10
```

If a static variable has an explicit value, that value is assigned during class initialization.

---

## 3. Static Blocks Are Executed

After static initialization reaches the static block, the block executes according to its position in the class.

Example:

```java
static {
    System.out.println("Static Block");
}
```

It prints:

```text
Static Block
```

So:

```text
Static variable initialization
          ↓
Static block execution
```

For multiple static fields and blocks, Java processes them in **textual order** during class initialization.

---

# 4. JVM Calls `main()`

After the class has been initialized successfully, the JVM invokes:

```java
public static void main(String[] args)
```

Now the main method starts.

Example:

```java
public static void main(String[] args) {
    System.out.println("Main");
}
```

Output:

```text
Main
```

---

# 5. Complete Program

Let's see the complete execution order.

```java
class Demo {

    static int x = 10;

    static {
        System.out.println("Static Block");
    }

    public static void main(String[] args) {

        System.out.println("Main Method");
        System.out.println("x = " + x);
    }
}
```

### Execution flow

```text
Class initialization
       ↓
x is initialized to 10
       ↓
Static block executes
       ↓
JVM invokes main()
       ↓
Main method executes
```

### Output

```text
Static Block
Main Method
x = 10
```

---

# 6. Multiple Static Variables and Blocks

This makes the order even easier to see.

```java
class Demo {

    static int a = 10;

    static {
        System.out.println("Static Block 1");
    }

    static int b = 20;

    static {
        System.out.println("Static Block 2");
    }

    public static void main(String[] args) {

        System.out.println("Main Method");
    }
}
```

### Output

```text
Static Block 1
Static Block 2
Main Method
```

The static field initializations themselves don't print anything, but they happen in the same textual order relative to the static blocks.

Conceptually:

```text
a = 10
   ↓
Static Block 1
   ↓
b = 20
   ↓
Static Block 2
   ↓
main()
```

---

# 🧠 Real-Life Example

Imagine a restaurant opening.

Before customers enter:

```text
1. Open restaurant
       ↓
2. Prepare kitchen
       ↓
3. Turn on equipment
       ↓
4. Staff gets ready
       ↓
5. Customers enter
```

Java is similar:

```text
1. Class initialization begins
       ↓
2. Static variables initialized
       ↓
3. Static blocks executed
       ↓
4. JVM calls main()
       ↓
5. Main program executes
```

---

# 🎯 Remember Forever

### The important order:

```text
┌────────────────────────────┐
│ Class initialization       │
└─────────────┬──────────────┘
              ↓
    Static variables
      initialized
              ↓
      Static blocks
       executed
              ↓
       JVM calls
          main()
              ↓
      Main execution
```

### ⭐ Golden Rule

> **Before `main()` begins, Java initializes the class's static state. Static field initializers and static blocks execute in textual order during class initialization. After successful class initialization, the JVM invokes `main()`.**

### 🧠 One-line memory trick

> **Static preparation → Static execution → `main()` → Program execution.**
