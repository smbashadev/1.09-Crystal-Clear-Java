# 🧒 Explicit Type Casting

## 🔹 What is Explicit Type Casting?

**Explicit type casting means manually converting a value from one data type to another by telling Java exactly which type you want.**

Your notes describe the common case:

> **Higher type → Lower type = Narrowing**

Unlike implicit casting, **Java does not automatically do this conversion** when data could be lost.

---

# 1️⃣ Higher Type → Lower Type

Imagine you have a **big box** and want to put its contents into a **smaller box**.

```text
Big Box
  ↓
Smaller Box
```

In Java:

```text
double → int
long   → int
int    → short
short  → byte
```

Because the target type has a smaller range or representation, Java generally requires you to explicitly cast.

---

# 2️⃣ Manual Conversion

Suppose:

```java
double price = 99.99;
```

You want an `int`.

You must tell Java:

```java
int value = (int) price;
```

You are manually saying:

> **"Convert this value to `int`."**

```text id="3wyx3j"
99.99
  ↓
(int)
  ↓
99
```

The `.99` is discarded.

---

# 3️⃣ Type Casting Operator

The syntax:

```text
(targetType)
```

is called the **cast operator**.

Example:

```java
int number = (int) 10.75;
```

Here:

```text
(int) → cast operator
```

It tells Java to convert `10.75` to `int`.

Result:

```text
10
```

---

# 4️⃣ Possible Data Loss ⚠️

This is the biggest thing to remember about narrowing.

Example:

```java
double number = 25.75;

int result = (int) number;
```

Result:

```text
25
```

The fractional part:

```text
.75
```

is lost.

```text
25.75
  ↓
(int)
  ↓
25
```

So:

> **Narrowing can cause data loss.**

---

# 🧒 Real-Life Analogy

Imagine you have a large bucket containing:

```text
🪣 10.75 liters
```

and you want to store it in a container that only records whole liters:

```text
🥤 10 liters
```

You are losing the `.75`.

Similarly:

```text
double 10.75
       ↓
     (int)
       ↓
int 10
```

---

# 💻 Example 1: `double → int`

```java
class Demo {
    public static void main(String[] args) {

        double number = 10.75;

        int result = (int) number;

        System.out.println(result);
    }
}
```

### Output

```text
10
```

---

# 💻 Example 2: `int → short`

```java
int number = 100;

short result = (short) number;

System.out.println(result);
```

Output:

```text
100
```

Here no information is lost because `100` fits within the `short` range.

---

# 💻 Example 3: Data Loss

```java
int number = 130;

byte result = (byte) number;

System.out.println(result);
```

This is allowed, but the result is **not 130**, because `130` is outside the `byte` range (`-128` to `127`).

For Java's signed 8-bit `byte`, the result wraps according to narrowing conversion rules:

```text
130 → -126
```

This is a good example of why narrowing can be dangerous.

---

# 🔄 Widening vs Narrowing

```text id="f6e4uo"
WIDENING
byte → short → int → long → float → double
       Automatic
       Usually safer
```

```text id="m3rv7p"
NARROWING
double → float → long → int → short → byte
             Manual cast
             Possible data loss
```

⚠️ The exact conversion rules matter; this arrow is a **memory shortcut**, not a statement that every reverse pair is always a valid conversion in every situation.

---

# 📊 Quick Comparison

| Feature          | Explicit Type Casting                 |
| ---------------- | ------------------------------------- |
| Direction        | Usually higher/wider → lower/narrower |
| Who performs it? | **Programmer**                        |
| Automatic?       | ❌ No                                  |
| Operator         | `(targetType)`                        |
| Also called      | **Narrowing conversion**              |
| Data loss        | **Possible**                          |

---

# 🧠 Super Simple Formula

Remember:

```text
Higher Type
     ↓
  (lower)
     ↓
Lower Type
```

Example:

```java
double d = 99.99;
int i = (int) d;
```

```text
double 99.99
     ↓
   (int)
     ↓
int 99
```

### 🎯 Interview Answer

> **Explicit type casting is the manual conversion of a value from one compatible data type to another, commonly from a wider numeric type to a narrower type. It uses the cast operator `(type)` and may result in data loss.**

### 🧠 Easy Memory Trick

> **Explicit = I explicitly tell Java 🧑‍💻**
> **Narrowing = Big type → Smaller type ⬇️**
> **Cast operator = `(type)`**
> **Possible data loss = ⚠️**

**Example:**

```java
int x = (int) 10.75;
```

**`10.75 → 10`** because the fractional part is discarded.
