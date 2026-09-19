# 🧒 `intern()` Method in Java

The `intern()` method is used with **Strings** to work with the **String Pool**.

The easiest way to remember it is:

> **`intern()` asks Java: “Is this String value already in the String Pool? If yes, give me the pooled object's reference. If not, put it in the pool and give me its reference.”**

---

## 1. What is `intern()`?

`intern()` is a method of the `String` class.

### Syntax

```java
String result = string.intern();
```

Example:

```java
String s1 = new String("Java");

String s2 = s1.intern();
```

Here `s1` is a String object created using `new`.

`intern()` looks for `"Java"` in the String Pool.

---

# 2. Why Do We Need `intern()`?

Consider:

```java
String s1 = new String("Java");
```

We explicitly used `new`.

So we have a separate String object:

```text
s1
 ↓
"Java"
```

But the String Pool may already contain:

```text
"Java"
```

So conceptually:

```text
HEAP

String Pool
┌────────────┐
│  "Java"    │
└────────────┘

Outside Pool
┌────────────┐
│  "Java"    │ ← s1
└────────────┘
```

There are two objects containing the same value.

This can be considered **duplicate data**.

---

# 3. `intern()` Looks in the String Pool

Now:

```java
String s1 = new String("Java");

String s2 = s1.intern();
```

When Java executes:

```java
s1.intern();
```

it looks for `"Java"` in the String Pool.

Conceptually:

```text
        s1.intern()
             ↓
      Check String Pool
             ↓
       "Java" exists?
          ↙       ↘
        YES        NO
         ↓          ↓
   Return pool    Add String
    reference     to pool
```

---

# 4. If `"Java"` Already Exists

Suppose `"Java"` is already in the String Pool.

Then:

```java
String s2 = s1.intern();
```

does **not** create another `"Java"` in the pool.

Instead, `s2` gets a reference to the **existing pooled object**.

Conceptually:

```text
String Pool

       "Java"
       ↑    ↑
       │    │
      s2    pool reference
```

Meanwhile:

```text
s1 → separate "Java" object
```

So:

```text
s1 → Object A → "Java"

s2 → Object B → "Java"
```

where:

```text
Object B = existing pooled object
```

Therefore:

```java
System.out.println(s1 == s2);
```

prints:

```text
false
```

because `s1` still refers to the separate object.

---

# 5. Complete Program

```java
class InternDemo {

    public static void main(String[] args) {

        String s1 = new String("Java");

        String s2 = s1.intern();

        System.out.println(s1 == s2);
    }
}
```

### Output

```text
false
```

Why?

```text
s1 → new String object

s2 → existing String Pool object
```

They are different objects.

---

# 6. Very Important Example

Now let's create a String literal too:

```java
class InternDemo {

    public static void main(String[] args) {

        String s1 = new String("Java");

        String s2 = "Java";

        String s3 = s1.intern();

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
    }
}
```

### Output

```text
false
true
```

Why?

Conceptually:

```text
             String Pool
                 │
                 ↓
              "Java"
              ↑     ↑
              │     │
             s2     s3


Outside Pool

s1 ─────→ "Java"
```

Therefore:

```text
s1 == s2 → false
s2 == s3 → true
```

`intern()` gave `s3` the reference to the **existing pooled `"Java"` object**.

---

# 7. What If the String Is Not Already in the Pool?

Suppose we have:

```java
String s1 = new String("Python");
```

and assume `"Python"` is not already in the String Pool.

Then:

```java
String s2 = s1.intern();
```

Java checks:

```text
Is "Python" already in the String Pool?
```

Answer:

```text
NO
```

So Java adds the String to the pool and returns the pooled reference.

Conceptually:

```text
Before:

Outside Pool
"Python" ← s1


After intern():

String Pool
"Python" ← s2

Outside Pool
"Python" ← s1
```

Now there are still separate objects, but the pooled representation is available.

---

# 8. `intern()` Does NOT Mean "Move the Same Object"

This is an important correction to a common beginner misunderstanding.

Suppose:

```java
String s1 = new String("Java");
String s2 = s1.intern();
```

It is better **not** to imagine:

```text
s1 object
   ↓
moved into String Pool
```

Instead, think:

```text
s1 → original object

s2 → pooled object
```

`intern()` returns the **canonical pooled reference** for that String value.

So:

> **`intern()` does not simply move your existing object into the pool.**

---

# 9. Memory Utilization

Why can `intern()` be useful?

Imagine we have many duplicate String values:

```text
"Java"
"Java"
"Java"
"Java"
"Java"
```

If every String is stored as a separate object, there can be unnecessary duplication.

The String Pool allows identical pooled Strings to be shared.

Conceptually:

```text
Without sharing:

"Java"   "Java"   "Java"   "Java"


With pooling:

             "Java"
            ↙  ↓  ↘
          ref ref ref
```

So pooling can help reduce duplicate String objects in appropriate situations.

⚠️ However, don't assume `intern()` is always a memory optimization. Interning has its own memory and performance costs, and excessive use can be counterproductive.

---

# 10. Pool Lookup

The basic process is:

```text
                 intern()
                    ↓
             Get String value
                    ↓
           Search String Pool
                    ↓
             ┌──────┴──────┐
             ↓             ↓
          Exists?        Absent?
             ↓             ↓
            YES            NO
             ↓             ↓
      Return existing    Add to pool
       pooled object         ↓
             ↓          Return pooled
             ↓             reference
```

---

# 11. Existing Object Address

Suppose:

```java
String s1 = new String("Java");
String s2 = "Java";

String s3 = s1.intern();
```

The pool already has `"Java"` because of:

```java
String s2 = "Java";
```

So:

```text
String Pool
────────────────
"Java" ← s2
   ↑
   │
  s3
```

Therefore:

```java
s2 == s3
```

is:

```text
true
```

Because both references refer to the **same pooled object**.

---

# 12. Complete Interview Program

```java
class InternDemo {

    public static void main(String[] args) {

        String s1 = new String("Java");

        String s2 = "Java";

        String s3 = s1.intern();

        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s1.equals(s2));
    }
}
```

### Output

```text
false
true
true
```

### Why?

```text
s1 → separate object → "Java"

s2 ──────┐
         ↓
      pooled "Java"
         ↑
         │
s3 ──────┘
```

Therefore:

```text
s1 == s2
   ↓
 false
```

Different objects.

```text
s2 == s3
   ↓
 true
```

Same pooled object.

```text
s1.equals(s2)
       ↓
     true
```

Same String value.

---

# 🧠 Real-Life Example

Imagine a school has a **common dictionary**.

Many students have their own copies of the word:

```text
Java
```

Instead of keeping another copy, they can refer to the **one official dictionary entry**.

`intern()` is roughly like saying:

> “Give me the official shared entry for this word.”

If the entry already exists:

```text
Use existing entry
```

If it doesn't:

```text
Create/add the entry
```

---

# ⭐ Your Points

### `intern()`

Gets the canonical String from the String Pool.

```java
s.intern();
```

### Moving/copying data to String Pool

For beginner understanding, think of `intern()` as making the String value available in the pool, but technically it **doesn't simply move the original object**.

### Duplicate data

If the same String value exists both as a separately created object and in the pool, there can be duplicate String objects containing the same characters.

### Memory utilization

String pooling can allow identical String values to share a pooled object, potentially reducing duplication.

### Pool lookup

`intern()` checks whether the String value already has a pooled representation.

### Existing object reference

If the value already exists in the pool:

> `intern()` returns the reference to that existing pooled String.

### New pooled object if absent

If the value isn't already pooled:

> Java adds a pooled String for that value and returns its pooled reference.

---

# 🎯 Remember Forever

```text
String s1 = new String("Java");
                 ↓
          Separate object
                 ↓
           s1.intern()
                 ↓
       Check String Pool
            ↙       ↘
       "Java"      "Java"
       exists      absent
          ↓           ↓
    Return pool    Add to pool
     reference        ↓
                  Return pool
                   reference
```

### 🧠 Golden Rule

> **`intern()` checks the String Pool for the same String value. If it already exists, it returns the existing pooled object's reference; if it doesn't exist, the value is added to the pool and its pooled reference is returned.**

The most important interview example to remember is:

```java
String s1 = new String("Java");
String s2 = "Java";
String s3 = s1.intern();

System.out.println(s1 == s2); // false
System.out.println(s2 == s3); // true
System.out.println(s1.equals(s2)); // true
```

**`==` → same object?**
**`.equals()` → same value?**
**`intern()` → give me the pooled reference for this value.**
