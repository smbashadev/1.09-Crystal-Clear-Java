# 🧒 String Pool in Java

To understand the **String Pool**, first remember one simple idea:

> 🧠 **Java tries not to create unnecessary duplicate String objects when the same String literal is used.**

Imagine a school has a **common cupboard**.

If 10 students need the same book called **"Java"**, the school doesn't necessarily keep 10 identical books in the common cupboard. It can keep one copy and let everyone use it.

The **String Pool** works with a similar idea for String literals.

---

# 1. What is the String Pool?

The **String Pool** is a special area associated with the **heap** where Java keeps String literals so that identical literals can be reused.

For example:

```java
String s1 = "Java";
String s2 = "Java";
```

Both use the same String literal:

```text
"Java"
```

Java can keep one `"Java"` String in the String Pool and have both references refer to it.

Conceptually:

```text
        String Pool
       ┌───────────┐
s1 ───→│  "Java"   │←─── s2
       └───────────┘
```

There is no need for two separate pooled `"Java"` objects.

---

# 2. String Pool Is in the Heap

A very important point:

> **The String Pool is part of the heap memory area.**

Conceptually:

```text
                 Heap
        ┌─────────────────────┐
        │                     │
        │    String Pool      │
        │                     │
        │      "Java"         │
        │                     │
        ├─────────────────────┤
        │                     │
        │ Other Heap Objects  │
        │                     │
        └─────────────────────┘
```

So don't imagine the String Pool as a completely separate memory area outside the heap.

---

# 3. What Is a String Literal?

When you write text directly inside double quotes:

```java
"Java"
```

that is called a **String literal**.

Examples:

```java
"Java"
"Hello"
"India"
"Basha"
"Welcome"
```

These literals can be stored in the String Pool.

For example:

```java
String s1 = "Java";
```

The `"Java"` is a String literal.

---

# 4. Duplicate String Literals

Suppose we write:

```java
String s1 = "Java";
String s2 = "Java";
String s3 = "Java";
```

We used `"Java"` three times.

Does Java need three identical String objects in the pool?

**No.**

The String Pool is designed to reuse the same literal.

Conceptually:

```text
String Pool

       "Java"
          ↑
     ┌────┼────┐
     │    │    │
    s1   s2   s3
```

All three reference the same pooled String.

---

# 5. Why Avoid Duplicate Strings?

Imagine this:

```text
"Java"
"Java"
"Java"
"Java"
"Java"
```

If Java created a separate identical object for every literal, it could waste memory.

Instead:

```text
"Java"
 ↑
 │
s1
s2
s3
s4
s5
```

One pooled String can be shared.

### 🧠 Memory trick

> **Same literal → reuse the pooled String.**

---

# 6. Simple Program

```java
class StringPoolDemo {

    public static void main(String[] args) {

        String s1 = "Java";
        String s2 = "Java";

        System.out.println(s1);
        System.out.println(s2);
    }
}
```

### Output

```text
Java
Java
```

Both variables contain `"Java"`.

Conceptually:

```text
s1 ──┐
     ↓
   "Java"
     ↑
s2 ──┘
```

---

# 7. How Can We Check Whether They Refer to the Same Object?

We can use the `==` operator to compare references.

```java
class StringPoolDemo {

    public static void main(String[] args) {

        String s1 = "Java";
        String s2 = "Java";

        System.out.println(s1 == s2);
    }
}
```

### Output

```text
true
```

Why?

Because both references can refer to the same pooled `"Java"` object.

```text
s1 ─────┐
        ↓
      "Java"
        ↑
s2 ─────┘
```

⚠️ Remember:

`==` checks whether the references refer to the same object.

For comparing String **contents**, normally use:

```java
s1.equals(s2)
```

---

# 8. What Happens With `new String("Java")`?

Now we reach an important difference.

Consider:

```java
String s1 = "Java";
String s2 = new String("Java");
```

There are two things to understand.

### First:

```java
"Java"
```

is a String literal and can exist in the **String Pool**.

### Second:

```java
new String("Java")
```

explicitly creates a **new String object outside the pool**.

Conceptually:

```text
                 Heap
 ┌─────────────────────────────────┐
 │                                 │
 │ String Pool                     │
 │                                 │
 │      "Java" ←──── s1            │
 │                                 │
 │                                 │
 │ Other Heap Objects              │
 │                                 │
 │      "Java" ←──── s2            │
 │                                 │
 └─────────────────────────────────┘
```

So there can be **two different String objects containing the same characters**.

---

# 9. Duplicate Objects Outside the Pool

This is exactly where your point:

> **Duplicate objects outside pool**

becomes important.

Consider:

```java
String s1 = new String("Java");
String s2 = new String("Java");
```

Each `new` creates a new String object.

Conceptually:

```text
                 Heap
 ┌─────────────────────────────────┐
 │ String Pool                     │
 │                                 │
 │       "Java"                    │
 │                                 │
 ├─────────────────────────────────┤
 │ Normal Heap Objects              │
 │                                 │
 │       "Java" ←── s1             │
 │                                 │
 │       "Java" ←── s2             │
 │                                 │
 └─────────────────────────────────┘
```

Now there are **two separate objects** outside the pool containing the same text.

That's possible because `new` explicitly asks Java to create a new object.

---

# 10. `==` Example

Look at:

```java
class StringPoolDemo {

    public static void main(String[] args) {

        String s1 = "Java";
        String s2 = "Java";

        String s3 = new String("Java");
        String s4 = new String("Java");

        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
        System.out.println(s1 == s3);
    }
}
```

### Output

```text
true
false
false
```

### Why?

#### `s1 == s2`

```java
String s1 = "Java";
String s2 = "Java";
```

They can refer to the same pooled object.

Therefore:

```text
true
```

---

#### `s3 == s4`

```java
new String("Java")
new String("Java")
```

Each `new` creates a separate object.

Therefore:

```text
false
```

---

#### `s1 == s3`

One refers to the pooled String and the other refers to a separately created object.

Therefore:

```text
false
```

---

# 11. But `.equals()` Gives `true`

Now:

```java
System.out.println(s1.equals(s3));
```

Output:

```text
true
```

Why?

Because both contain the same characters:

```text
Java
```

So remember:

```text
==       → compares references
.equals() → compares String contents
```

---

# 🧠 12. The Complete Picture

Imagine a **common library**.

### String Pool

```text
                 HEAP
        ┌─────────────────────┐
        │   STRING POOL       │
        │                     │
        │      "Java"         │
        │        ↑ ↑          │
        │        │ │          │
        │       s1 s2         │
        │                     │
        ├─────────────────────┤
        │ OTHER HEAP OBJECTS  │
        │                     │
        │      "Java" ← s3    │
        │      "Java" ← s4    │
        │                     │
        └─────────────────────┘
```

### What does this tell us?

```text
"Java" literal
      ↓
String Pool
      ↓
Can be shared
```

Whereas:

```text
new String("Java")
      ↓
new object
      ↓
outside the pool
      ↓
Can create duplicates
```

---

# ⭐ Your Points — Explained Simply

### String Pool area

A special area associated with the heap used for storing/reusing String literals.

### Heap segment

The String Pool is part of the heap.

### String literals

Strings written directly using double quotes:

```java
"Java"
"Hello"
"India"
```

### Duplicate strings

If the same String literal appears multiple times, Java can reuse the same pooled String object.

### No duplicate strings in pool

For the same literal value, Java's String Pool maintains a shared pooled representation rather than creating a new pooled object each time.

### Objects outside pool

Objects explicitly created using:

```java
new String(...)
```

are separate String objects on the heap.

### Duplicate objects outside pool

For example:

```java
new String("Java");
new String("Java");
```

creates separate objects even though both contain `"Java"`.

---

# 🎯 Final Memory Trick

Remember this picture:

```text
String literal
      ↓
   "Java"
      ↓
 String Pool
      ↓
Reuse same object
```

But:

```text
new String("Java")
        ↓
New object
        ↓
Heap outside String Pool
        ↓
Duplicates are possible
```

## 🧠 One-line rule

> **String literals can be shared through the String Pool, while `new String()` explicitly creates a new String object, so multiple duplicate objects can exist outside the pool.**
