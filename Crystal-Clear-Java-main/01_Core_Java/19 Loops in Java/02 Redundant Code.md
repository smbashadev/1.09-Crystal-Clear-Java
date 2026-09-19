## 🧒 Redundant Code

**Redundant code** means **unnecessary repeated code**.

In simple words:

> If you write the **same code again and again** when you could avoid the repetition, that code is redundant.

---

### ❌ Example: Repeated `println()`

Suppose you want to print `"Hello!"` 5 times:

```java
System.out.println("Hello!");
System.out.println("Hello!");
System.out.println("Hello!");
System.out.println("Hello!");
System.out.println("Hello!");
```

The same statement is repeated **5 times**.

```text
System.out.println("Hello!");
          ↓
      repeated
          ↓
      repeated
          ↓
      repeated
```

This is **redundant code**.

---

### ✅ Use a Loop Instead

```java
for (int i = 1; i <= 5; i++) {
    System.out.println("Hello!");
}
```

Now the `println()` statement is written **only once**, but Java executes it 5 times.

Output:

```text
Hello!
Hello!
Hello!
Hello!
Hello!
```

---

### 🧠 Easy Analogy

Imagine someone asks you to say:

> "Hello!" five times.

You could write it five times:

```text
Hello!
Hello!
Hello!
Hello!
Hello!
```

Or tell a robot:

> **"Repeat Hello 5 times."** 🤖

That's what a **loop** does.

---

### 🔑 Memory Trick

> **Redundant code = unnecessary repetition of code.**

```text
Repeated code
     ↓
Redundant code
     ↓
Use a loop
     ↓
Write once + repeat automatically
```

### ⭐ Interview Answer

> **Redundant code is unnecessary or repeated code that can be reduced or avoided. For example, repeatedly writing `System.out.println("Hello!");` can be replaced with a loop.**
