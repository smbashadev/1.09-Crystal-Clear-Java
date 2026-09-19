# 🧒 Mutable Strings in Java

Normally, a Java `String` is **immutable**.

That means:

> Once a String object is created, its value cannot be changed.

But sometimes we need to build or modify text many times.

For example:

```text
Hello
Hello Java
Hello Java Programming
Hello Java Programming Language
```

Creating a new `String` object every time can be unnecessary.

For this purpose, Java provides:

1. **`StringBuffer`**
2. **`StringBuilder`**

Both are **mutable**, meaning their contents can be changed.

---

# 1. What Does Mutable Mean?

**Mutable** simply means:

> **Can be changed.**

Imagine a notebook 📒.

You write:

```text
Hello
```

Then you can add:

```text
Hello Java
```

Then:

```text
Hello Java Programming
```

You are modifying the same notebook.

That's the basic idea of a mutable String object.

---

# 2. `StringBuffer`

`StringBuffer` is a Java class used to create **mutable character sequences**.

Example:

```java
StringBuffer sb = new StringBuffer("Hello");
```

Now we can change its contents.

```java
sb.append(" Java");
```

The contents become:

```text
Hello Java
```

---

# 3. `append()`

The most commonly used method with `StringBuffer` and `StringBuilder` is:

```java
append()
```

It means:

> **Add something to the end.**

Example:

```java
StringBuffer sb = new StringBuffer("Hello");

sb.append(" Java");

System.out.println(sb);
```

Output:

```text
Hello Java
```

---

# 4. Complete StringBuffer Program

```java
class StringBufferDemo {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("Hello");

        sb.append(" Java");
        sb.append(" Programming");

        System.out.println(sb);
    }
}
```

### Output

```text
Hello Java Programming
```

Notice what happened:

```text
Initially:
Hello

After append():
Hello Java

After another append():
Hello Java Programming
```

The `StringBuffer` object is being modified.

---

# 5. `StringBuilder`

`StringBuilder` works very similarly.

It is also used for **mutable Strings**.

Example:

```java
StringBuilder sb = new StringBuilder("Hello");

sb.append(" Java");

System.out.println(sb);
```

Output:

```text
Hello Java
```

---

# 6. Complete StringBuilder Program

```java
class StringBuilderDemo {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Hello");

        sb.append(" Java");
        sb.append(" Programming");

        System.out.println(sb);
    }
}
```

Output:

```text
Hello Java Programming
```

---

# 7. Why Are They Called Mutable?

Consider:

```java
StringBuilder sb = new StringBuilder("Hello");
```

Then:

```java
sb.append(" Java");
```

Then:

```java
sb.append(" Programming");
```

The contents change:

```text
Hello
  ↓
Hello Java
  ↓
Hello Java Programming
```

So the object is **mutable**.

---

# 8. `String` vs `StringBuilder`

Remember what happens with a normal String:

```java
String s = "Hello";

s = s.concat(" Java");
```

A new String value/object is produced because `String` is immutable.

With `StringBuilder`:

```java
StringBuilder sb = new StringBuilder("Hello");

sb.append(" Java");
```

The existing `StringBuilder` object is modified.

Think:

```text
String
  ↓
Cannot change existing String object

StringBuilder
  ↓
Can change existing object
```

---

# 9. StringBuffer vs StringBuilder

Both are mutable.

The biggest difference is **thread safety**.

| Feature         | StringBuffer                       | StringBuilder                                   |
| --------------- | ---------------------------------- | ----------------------------------------------- |
| Mutable         | ✅ Yes                              | ✅ Yes                                           |
| `append()`      | ✅ Yes                              | ✅ Yes                                           |
| Thread-safe     | ✅ Yes                              | ❌ No                                            |
| Synchronization | Synchronized                       | Not synchronized                                |
| Multi-threading | Safer when shared                  | Not designed for shared concurrent modification |
| Speed           | Usually slower                     | Usually faster                                  |
| Best use        | Shared mutable text across threads | Single-threaded/local text building             |

---

# 10. What Is Thread Safety?

This can sound scary, but the basic idea is simple.

Imagine several people are writing in the **same notebook at the same time**.

```text
Person A ──┐
Person B ──┼──→ Same notebook
Person C ──┘
```

If everybody writes at the same time without coordination, the data could become difficult to manage.

In Java, these people can be thought of as **threads**.

---

# 11. What Is a Thread?

A **thread** is like a worker doing a task.

Imagine:

```text
Thread 1 → Worker 1
Thread 2 → Worker 2
Thread 3 → Worker 3
```

If multiple threads access the same mutable object, we need to think about **thread safety**.

---

# 12. Why Is StringBuffer Thread-Safe?

`StringBuffer` has synchronized methods for its mutable operations.

Very simply:

> It provides synchronization so that operations on the same `StringBuffer` object can be coordinated when accessed by multiple threads.

Think of a single door 🚪:

```text
Thread 1
   ↓
  🚪
   ↓
Thread 2 waits
```

One thread gets controlled access to the operation before another thread proceeds.

This makes `StringBuffer` safer for certain situations where the **same mutable object is shared between multiple threads**.

---

# 13. Why Is StringBuilder Faster?

`StringBuilder` does not synchronize its methods.

That means it doesn't spend the same synchronization overhead as `StringBuffer`.

So in typical single-threaded situations:

```text
StringBuilder
      ↓
No synchronization overhead
      ↓
Usually faster
```

while:

```text
StringBuffer
      ↓
Synchronization
      ↓
Usually slower
```

---

# 14. Simple Speed Comparison

Think about two workers.

### StringBuffer

Worker has to follow an additional safety procedure:

```text
Work
 ↓
Synchronization
 ↓
Modify
```

### StringBuilder

Worker can directly work:

```text
Work
 ↓
Modify
```

Therefore, `StringBuilder` is generally faster when thread safety isn't required.

---

# 15. Multi-Threading Example Concept

Imagine:

```text
             Shared object
                  ↓
          StringBuffer object
             ↙    ↓    ↘
        Thread 1 Thread 2 Thread 3
```

Multiple threads are accessing the same mutable object.

`StringBuffer` provides synchronization for its methods.

With:

```text
StringBuilder
```

there is no built-in synchronization on its methods.

Therefore, if multiple threads are modifying the same `StringBuilder`, you need to provide appropriate synchronization yourself if the application requires safe coordinated access.

---

# 16. Simple Program Using Both

```java
class MutableStringDemo {

    public static void main(String[] args) {

        StringBuffer buffer = new StringBuffer("Hello");
        buffer.append(" Java");

        StringBuilder builder = new StringBuilder("Hello");
        builder.append(" Java");

        System.out.println(buffer);
        System.out.println(builder);
    }
}
```

### Output

```text
Hello Java
Hello Java
```

Both produce the same result.

The difference is mainly in **how they handle concurrent access**.

---

# 17. Important Interview Question

### ❓ Which is faster: StringBuffer or StringBuilder?

Usually:

> **StringBuilder is faster.**

Why?

Because `StringBuilder` is not synchronized.

```text
StringBuilder
     ↓
No synchronization
     ↓
Less overhead
     ↓
Usually faster
```

---

# 18. Which One Should I Use?

### Use `StringBuilder`

When:

```text
Single thread
      ↓
Building/modifying Strings
      ↓
Need good performance
```

Example:

```java
StringBuilder sb = new StringBuilder();

sb.append("Java");
sb.append(" ");
sb.append("Programming");
```

---

### Use `StringBuffer`

When:

```text
Multiple threads
      ↓
Same mutable object is shared
      ↓
Need synchronized operations
```

Example:

```java
StringBuffer sb = new StringBuffer();

sb.append("Java");
```

The important point is not simply "multi-threading = always use StringBuffer"; what matters is whether **the mutable object is shared and needs synchronized access**.

---

# 🧠 19. Easy Real-Life Example

Imagine two notebooks.

### StringBuffer 📕 — Safety First

There is a rule:

> Only one person should modify the notebook through the controlled writing process at a time.

This represents synchronization.

Safer for shared access, but there is some overhead.

---

### StringBuilder 📗 — Speed First

There is no built-in synchronization.

A single person can write quickly:

```text
Write
 ↓
Write
 ↓
Write
```

So it is generally faster for single-threaded work.

---

# 🎯 Remember Forever

```text
             Mutable Strings
                   ↓
          ┌────────┴────────┐
          ↓                 ↓
    StringBuffer       StringBuilder
          ↓                 ↓
      Mutable            Mutable
          ↓                 ↓
    Synchronized       Not synchronized
          ↓                 ↓
      Thread-safe*        Faster
          ↓                 ↓
      More overhead      Less overhead
```

`*` More precisely, `StringBuffer`'s methods are synchronized; that does not automatically make every larger multi-step operation involving the object atomic.

### ⭐ Golden Rule

> **StringBuffer and StringBuilder are mutable. `StringBuffer` is synchronized and suited to situations where shared mutable access needs that synchronization; `StringBuilder` is not synchronized and is usually faster for single-threaded use.**

### 🧠 Super-short memory trick

```text
StringBuffer
     ↓
Synchronized
     ↓
Safer shared access
     ↓
Usually slower

StringBuilder
     ↓
Not synchronized
     ↓
Usually faster
     ↓
Single-threaded use
```

And remember:

> **`append()` = add something to the end of the mutable String.**
