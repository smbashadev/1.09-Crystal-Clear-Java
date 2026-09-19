# 🧒 Duplicate Strings Inside the String Pool

This is the **opposite situation** from the previous topic.

Previously:

```java
new String("Java")
```

could create **separate String objects**.

Now we are talking about:

```java
"Java"
```

which is a **String literal**.

The important idea is:

> 🧠 **When the same String literal is used again, Java can reuse the existing String object from the String Pool.**

---

# 1. String Literal `"Java"`

Look at:

```java
String s1 = "Java";
```

Here:

```text
"Java"
```

is a **String literal**.

Java stores String literals in the **String Pool**.

Conceptually:

```text
              Heap
        ┌───────────────┐
        │ String Pool   │
        │               │
        │    "Java"     │
        └───────────────┘
```

And `s1` refers to that pooled String:

```text
s1 ─────────→ "Java"
```

---

# 2. What Happens If We Write `"Java"` Again?

Now:

```java
String s1 = "Java";
String s2 = "Java";
```

We used `"Java"` twice.

Does Java create two `"Java"` objects in the String Pool?

### ❌ No.

Java checks the String Pool for an existing `"Java"`.

Because `"Java"` is already there, Java can **reuse it**.

Conceptually:

```text
              String Pool

                 "Java"
                ↗      ↖
              s1        s2
```

So:

```text
s1 ──┐
     ↓
   "Java"
     ↑
s2 ──┘
```

Both references point to the **same object**.

---

# 3. Same Reference

Because both `s1` and `s2` refer to the same pooled String:

```java
String s1 = "Java";
String s2 = "Java";
```

we can say:

```text
s1 → "Java"
s2 → "Java"
```

and both refer to the same object.

Therefore:

```java
s1 == s2
```

produces:

```text
true
```

---

# 4. Same Address / Same Reference

For beginner understanding, you can think:

```text
s1 → Address A → "Java"

s2 → Address A → "Java"
```

Both references point to the same object.

So:

```text
Same reference
      ↓
Same object
      ↓
Same address/reference
```

A more precise Java term is:

> `==` checks whether the two references refer to the same object.

---

# 5. Same Value

Obviously:

```java
String s1 = "Java";
String s2 = "Java";
```

both contain:

```text
Java
```

So they have:

```text
Same value
```

And because the same pooled object is reused:

```text
Same reference
Same object
Same value
```

---

# 6. JVM Checks the String Pool First

This is the important process to remember.

Suppose Java encounters:

```java
String s2 = "Java";
```

Java conceptually checks:

```text
"Do I already have "Java"
 in the String Pool?"
```

### If `"Java"` already exists:

```text
       String Pool
            ↓
          "Java"
            ↑
            │
           s2
```

Java can reuse the existing pooled String.

### If it doesn't exist:

Java creates/adds the required pooled String.

So the simplified process is:

```text
String literal
      ↓
Check String Pool
      ↓
Already exists?
   ↙          ↘
 YES           NO
 ↓              ↓
Reuse       Create/store
existing    pooled String
String
```

---

# 7. Complete Program

```java
class StringPoolDemo {

    public static void main(String[] args) {

        String s1 = "Java";
        String s2 = "Java";

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
```

### Output

```text
true
true
```

### Why?

`==`:

```text
Same object/reference?
        ↓
       YES
        ↓
      true
```

`.equals()`:

```text
Same value?
    ↓
   YES
    ↓
  true
```

---

# 8. Compare With `new String()`

This comparison is extremely important.

### String literals

```java
String s1 = "Java";
String s2 = "Java";
```

Conceptually:

```text
s1 ──┐
     ↓
   "Java"   ← one pooled object
     ↑
s2 ──┘
```

Therefore:

```java
s1 == s2
```

```text
true
```

---

### Using `new`

```java
String s1 = new String("Java");
String s2 = new String("Java");
```

Conceptually:

```text
s1 → "Java"   ← Object 1

s2 → "Java"   ← Object 2
```

Therefore:

```java
s1 == s2
```

```text
false
```

But:

```java
s1.equals(s2)
```

is:

```text
true
```

because the values are the same.

---

# 9. Side-by-Side Picture

```text
STRING LITERALS
────────────────────────

String s1 = "Java";
String s2 = "Java";

             String Pool
                  │
                  ↓
              ┌────────┐
       s1 ───→│ "Java" │←─── s2
              └────────┘

Same object
Same reference
Same value

s1 == s2 → true
```

Whereas:

```text
USING new
────────────────────────

String s1 = new String("Java");
String s2 = new String("Java");

       ┌────────┐
s1 ───→│ "Java" │
       └────────┘

       ┌────────┐
s2 ───→│ "Java" │
       └────────┘

Different objects
Different references
Same value

s1 == s2 → false
s1.equals(s2) → true
```

---

# 🧠 10. Real-Life Example

Imagine a **school library**.

There is one common book:

```text
📘 Java
```

Student A asks for the Java book:

```text
A → 📘 Java
```

Student B asks for the same Java book:

```text
B → 📘 Java
```

The library doesn't need to create another identical book just because another student asks for the same book.

They can use the existing one.

That's the basic idea behind the String Pool.

---

# ⭐ Your Points — Simplified

### `"Java"`

A String literal.

```java
String s = "Java";
```

### Same reference

```java
String s1 = "Java";
String s2 = "Java";
```

Both can refer to the same pooled String object.

### Same address

Both references refer to the same object.

For beginner understanding:

```text
s1 → Address A
s2 → Address A
```

### Same value

Both contain:

```text
"Java"
```

### JVM checks String Pool first

For String literals, Java uses the String Pool so that an existing matching literal can be reused instead of creating another pooled object.

---

# 🎯 Remember This Forever

```text
             "Java"
                ↓
         String Literal
                ↓
        Check String Pool
                ↓
      "Java" already there?
          ↙          ↘
        YES           NO
         ↓             ↓
       Reuse        Create/store
         ↓             ↓
    Same object     New pooled
                    String
```

## 🧠 Golden Rule

> **Same String literal → String Pool → existing pooled String can be reused → same reference/object → `==` can be `true`.**

And compare this with your previous topic:

```text
"Java" + "Java"
      ↓
String Pool
      ↓
Can share one object

new String("Java") + new String("Java")
      ↓
Explicit new objects
      ↓
Two separate objects
```

**That is the key difference between duplicate Strings inside the String Pool and duplicate String objects created outside the pool.**
