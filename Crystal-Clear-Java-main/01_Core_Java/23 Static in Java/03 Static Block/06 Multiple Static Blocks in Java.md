# 🧒 Multiple Static Blocks in Java

Java allows us to write **more than one static block** inside a class.

The important rule is:

> **Multiple static blocks execute from top to bottom, in the order in which they are written, before `main()` executes.**

---

## 1. Example

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

### Output

```text
Static Block 1
Static Block 2
Main Method
```

---

# 2. Why This Order?

Look at how the blocks are written:

```text
Static Block 1
       ↓
Static Block 2
       ↓
main()
```

Java executes the static blocks **in textual order**.

That means:

```text
First → Static Block 1
Second → Static Block 2
Third → main()
```

---

# 3. Think Like a Fifth-Class Student 🧒

Imagine your teacher gives you three instructions:

```text
1. Open your book
2. Read page 1
3. Start writing
```

You normally follow them in order:

```text
Open book
   ↓
Read page 1
   ↓
Start writing
```

Java's static blocks work similarly.

If you write:

```java
static {
    System.out.println("A");
}

static {
    System.out.println("B");
}
```

Java follows:

```text
A
↓
B
```

Then `main()` runs.

---

# 4. Three Static Blocks

You can even have three or more:

```java
class Demo {

    static {
        System.out.println("Static Block 1");
    }

    static {
        System.out.println("Static Block 2");
    }

    static {
        System.out.println("Static Block 3");
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
Static Block 3
Main Method
```

So:

```text
Block 1
   ↓
Block 2
   ↓
Block 3
   ↓
main()
```

---

# 5. What If `main()` Is Written First?

Don't think Java simply executes code from the first line of the source file.

For example:

```java
class Demo {

    public static void main(String[] args) {

        System.out.println("Main Method");
    }

    static {
        System.out.println("Static Block");
    }
}
```

The output is still:

```text
Static Block
Main Method
```

The static block executes during class initialization before the JVM invokes `main()`.

---

# 6. Multiple Static Blocks + Static Variables

Consider:

```java
class Demo {

    static int x = 10;

    static {
        System.out.println("Static Block 1");
    }

    static int y = 20;

    static {
        System.out.println("Static Block 2");
    }

    public static void main(String[] args) {

        System.out.println("Main Method");
    }
}
```

The class initialization proceeds in **textual order**:

```text
x = 10
   ↓
Static Block 1
   ↓
y = 20
   ↓
Static Block 2
   ↓
main()
```

The variable assignments don't produce output here, but they still happen in that order.

---

# 🧠 Important Rule

### Multiple static blocks:

```java
static {
    // Block 1
}

static {
    // Block 2
}

static {
    // Block 3
}
```

Execution:

```text
Block 1
   ↓
Block 2
   ↓
Block 3
   ↓
main()
```

---

# ⭐ Golden Rule

> **Static blocks execute automatically during class initialization, in the order they appear in the class, before `main()` is invoked.**

### 🧠 Remember:

```text
STATIC BLOCK 1
      ↓
STATIC BLOCK 2
      ↓
STATIC BLOCK 3
      ↓
MAIN METHOD
```

**Top to bottom. First written → first executed.**
