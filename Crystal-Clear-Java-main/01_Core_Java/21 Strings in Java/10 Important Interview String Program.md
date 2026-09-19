# 🧒 Important Interview String Program

This is a **very important Java String interview program** because it tests whether you really understand **String immutability**, **reassignment**, and **`concat()`**.

---

## 1. The Program

```java
class StringInterview {

    public static void main(String[] args) {

        String s = "Java";

        s.concat(" Programming");

        System.out.println(s);

        s = s.concat(" Programming");

        System.out.println(s);
    }
}
```

### Output

```text
Java
Java Programming
```

---

# 2. Why Is the First Output `Java`?

Look at:

```java
String s = "Java";
```

Initially:

```text
s
↓
"Java"
```

Then we execute:

```java
s.concat(" Programming");
```

`concat()` creates a **new String**:

```text
"Java Programming"
```

But we didn't store that new String anywhere.

So `s` still points to:

```text
s
↓
"Java"
```

Therefore:

```java
System.out.println(s);
```

prints:

```text
Java
```

---

# 3. Why Does the Second Output Change?

Now look at:

```java
s = s.concat(" Programming");
```

This time, `concat()` creates:

```text
"Java Programming"
```

and we assign the result back to `s`.

Before:

```text
s
↓
"Java"
```

After:

```text
s
↓
"Java Programming"
```

Therefore:

```java
System.out.println(s);
```

prints:

```text
Java Programming
```

---

# 4. The Most Important Concept

Look at these two lines carefully:

### ❌ Result not assigned

```java
s.concat(" Programming");
```

The new String is created, but `s` still refers to `"Java"`.

### ✅ Result assigned

```java
s = s.concat(" Programming");
```

The new String is created **and `s` is reassigned to the new String**.

---

# 5. Visual Explanation

### First:

```java
String s = "Java";
```

```text
s ─────────→ "Java"
```

### Then:

```java
s.concat(" Programming");
```

Conceptually:

```text
s ─────────→ "Java"

             concat()
                ↓
       "Java Programming"
       (new String object)
```

But `s` is still pointing to `"Java"`.

---

### Then:

```java
s = s.concat(" Programming");
```

Now:

```text
s ─────────→ "Java"
                │
             concat()
                ↓
       "Java Programming"
                ↑
                │
                s
```

So `s` now refers to the new String.

---

# 6. Why Does This Prove String Is Immutable?

If String were mutable, this:

```java
s.concat(" Programming");
```

would change the original String.

Then:

```java
System.out.println(s);
```

would print:

```text
Java Programming
```

But it actually prints:

```text
Java
```

That tells us:

> **The original String `"Java"` was not changed.**

Instead, `concat()` returned another String.

Therefore:

> **String is immutable.**

---

# 7. Another Very Common Interview Program

```java
class Test {

    public static void main(String[] args) {

        String s = "Hello";

        s.concat(" World");

        System.out.println(s);
    }
}
```

### Output

```text
Hello
```

### Why?

Because:

```java
s.concat(" World");
```

creates:

```text
"Hello World"
```

but the result is not assigned.

---

# 8. If We Assign It

```java
class Test {

    public static void main(String[] args) {

        String s = "Hello";

        s = s.concat(" World");

        System.out.println(s);
    }
}
```

### Output

```text
Hello World
```

Because:

```java
s = s.concat(" World");
```

stores the new String reference in `s`.

---

# 🧠 Real-Life Example

Imagine you have a paper containing:

```text
JAVA
```

Someone makes a **new paper** containing:

```text
JAVA PROGRAMMING
```

Your original paper still says:

```text
JAVA
```

If you don't take the new paper, you still have the old one.

That's like:

```java
s.concat(" Programming");
```

If you take the new paper and replace your old paper:

```java
s = s.concat(" Programming");
```

then `s` refers to the new text.

---

# ⭐ Interview Question

### Q: What is the output?

```java
String s = "Java";

s.concat(" Programming");

System.out.println(s);
```

### Answer:

```text
Java
```

### Reason:

`String` is immutable. `concat()` creates a new String, but its result was not assigned to `s`.

---

# ⭐ Another Interview Question

### Q: What is the output?

```java
String s = "Java";

s = s.concat(" Programming");

System.out.println(s);
```

### Answer:

```text
Java Programming
```

### Reason:

`concat()` creates a new String and the returned reference is assigned back to `s`.

---

# 🎯 Golden Rule

Remember this single formula:

```text
String is IMMUTABLE
        ↓
concat() does NOT modify original String
        ↓
concat() returns a NEW String
        ↓
Want the new String?
        ↓
Assign the result
        ↓
s = s.concat("...");
```

### 🧠 Interview-ready answer

> **In Java, String objects are immutable. Methods such as `concat()` do not modify the existing String. They create and return a new String object. If the returned String is not assigned to a reference variable, the original String remains unchanged.**
