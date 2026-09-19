# 🧒 Duplicate Strings Outside the String Pool

This topic is very closely connected to the **String Pool** and **`==` vs `.equals()`**.

The main idea is:

> **Using `new String("Java")` can create a new String object outside the String Pool, even if `"Java"` already exists in the pool.**

---

## 1. `new String("Java")`

Look at:

```java
String s1 = new String("Java");
```

Here, we are explicitly using:

```java
new String(...)
```

The `new` keyword tells Java:

> **“Create a new String object.”**

So `s1` refers to that newly created object.

Conceptually:

```text
s1
 ↓
┌─────────┐
│ "Java"  │
└─────────┘
 Object 1
```

---

# 2. Creating Two Objects

Now look at this:

```java
String s1 = new String("Java");
String s2 = new String("Java");
```

There are **two `new` operations**.

Therefore, Java creates **two separate String objects**.

Conceptually:

```text
s1 ─────→ ┌─────────┐
          │ "Java"  │
          └─────────┘
           Object 1


s2 ─────→ ┌─────────┐
          │ "Java"  │
          └─────────┘
           Object 2
```

Notice:

```text
Object 1 ≠ Object 2
```

They are separate objects.

---

# 3. Different Addresses / References

Because they are two different objects, their references are different.

Think of it like two houses:

```text
House 1 → "Java"
House 2 → "Java"
```

The houses are different, even though the people inside both houses have the same name.

Similarly:

```text
s1 → Object 1 → "Java"

s2 → Object 2 → "Java"
```

So:

```java
s1 == s2
```

is:

```text
false
```

because `==` checks whether both references refer to the **same object**.

---

# 4. Same Values

Even though the objects are different, both contain:

```text
Java
```

So:

```java
s1.equals(s2)
```

returns:

```text
true
```

because `.equals()` for String compares the **contents**.

Therefore:

```text
Different objects
       +
Same String value
       ↓
==        → false
.equals() → true
```

---

# 5. Complete Program

```java
class DuplicateStringDemo {

    public static void main(String[] args) {

        String s1 = new String("Java");
        String s2 = new String("Java");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
```

### Output

```text
false
true
```

---

# 6. Why Is This Called a Duplicate String?

We have:

```text
Object 1 → "Java"

Object 2 → "Java"
```

Both objects contain exactly the same characters:

```text
J a v a
```

So we have **duplicate String objects containing the same value**.

The important distinction is:

> The **objects are different**, but their **values are the same**.

---

# 7. What About the String Pool?

Now let's connect this with the previous topic.

When Java sees:

```java
new String("Java")
```

there is a String literal:

```text
"Java"
```

which can be present in the String Pool.

But `new String("Java")` also explicitly creates a **new String object**.

Conceptually:

```text
                    HEAP
        ┌──────────────────────────┐
        │      String Pool         │
        │                          │
        │       "Java"             │
        │                          │
        ├──────────────────────────┤
        │                          │
        │  Other String Objects    │
        │                          │
        │       "Java" ← s1        │
        │       "Java" ← s2        │
        │                          │
        └──────────────────────────┘
```

So the same text can appear in:

* the pooled String
* separately created String objects

---

# 8. Very Important Program

```java
class DuplicateStringDemo {

    public static void main(String[] args) {

        String s1 = new String("Java");
        String s2 = new String("Java");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
```

Remember:

```text
s1 → Object 1 → "Java"
s2 → Object 2 → "Java"
```

### `==`

```java
s1 == s2
```

Asks:

> "Are Object 1 and Object 2 the same object?"

❌ No.

```text
false
```

### `.equals()`

```java
s1.equals(s2)
```

Asks:

> "Do Object 1 and Object 2 contain the same String value?"

✅ Yes.

```text
true
```

---

# 🧠 Real-Life Example

Imagine two identical books.

### Book 1

```text
Address: House A
Title: Java
```

### Book 2

```text
Address: House B
Title: Java
```

The books have:

✅ Same title
❌ Different physical books

That's exactly the idea here.

```text
==        → Same physical book?
.equals() → Same contents/title?
```

---

# ⭐ Your Four Points

### `new String("Java")`

Explicitly creates a new String object.

### Two objects

```java
String s1 = new String("Java");
String s2 = new String("Java");
```

creates two separate objects.

### Different addresses

` s1` and `s2` refer to different objects, so `s1 == s2` is `false`.

### Same values

Both objects contain:

```text
"Java"
```

so:

```java
s1.equals(s2)
```

is `true`.

---

# 🎯 Final Memory Trick

```text
new String("Java")
        ↓
   New Object
        ↓
   Do it again
        ↓
   New Object
        ↓
 ┌──────────────┐
 │ Object 1     │ → "Java"
 │ Object 2     │ → "Java"
 └──────────────┘
       ↓
Different objects
Same value
```

### 🧠 Golden Rule

> **`new String("Java")` can create separate String objects containing the same value. Therefore, two such objects can have different references but equal String contents: `==` is `false`, while `.equals()` is `true`.**
