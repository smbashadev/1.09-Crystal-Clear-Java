# 🧒 Type Casting in Java

## 🔹 What is Type Casting?

**Type casting means converting a value from one data type to another data type.**

Your note says:

> **Storing one data type into another data type**

That's a useful beginner idea, but technically:

> **Type casting = converting a value from one type to another compatible type.**

---

## 🥤 Simple Real-Life Example

Imagine you have:

```text
🥛 Glass of water
```

and you pour the water into:

```text
🪣 Bucket
```

The **container changes**, but the basic thing (water) remains.

Similarly, in Java, we can convert a value from one data type to another.

```text
One Data Type
      ↓
 Type Casting
      ↓
Another Data Type
```

---

# 💻 Simple Example

Suppose:

```java
int number = 10;
```

`number` is an `int`.

We can convert it to `double`:

```java
double value = (double) number;
```

Conceptually:

```text
int
10
 ↓
casting
 ↓
double
10.0
```

---

# 🔹 Why Do We Need Type Casting?

Different data types have different capabilities.

For example:

```java
int a = 10;
double b = 3.5;
```

If you want to treat `a` as a `double`:

```java
double result = (double) a;
```

Now:

```text
a = 10
 ↓
double
 ↓
10.0
```

---

# 🧠 Two Main Types of Type Casting

Java broadly has two kinds of primitive numeric conversion:

```text
1. Widening Casting
2. Narrowing Casting
```

### 1️⃣ Widening

Smaller-range numeric type → larger-range numeric type.

```text
byte → short → int → long → float → double
```

Example:

```java
int number = 10;
double value = number;
```

This can happen automatically.

```text
10 (int)
    ↓
10.0 (double)
```

---

### 2️⃣ Narrowing

Larger type → smaller type.

Example:

```java
double number = 10.5;
int value = (int) number;
```

Here you explicitly tell Java:

> "Convert this `double` to `int`."

Result:

```text
10.5
 ↓
int
 ↓
10
```

The `.5` is discarded.

---

# 🔥 Important

Type casting does **not always mean simply putting the same value into a different box**.

Sometimes information can be lost.

Example:

```java
double x = 10.99;
int y = (int) x;
```

Result:

```text
y = 10
```

The decimal part is lost.

---

# 📊 Simple Example

```java
class Demo {
    public static void main(String[] args) {

        int number = 10;

        // Widening
        double d = number;

        // Narrowing
        double price = 25.75;
        int p = (int) price;

        System.out.println(d);
        System.out.println(p);
    }
}
```

Output:

```text
10.0
25
```

---

# 🧠 Easy Memory Trick

> **Type Casting = Change the type of a value**

```text
int → double
10  → 10.0
```

and:

```text
double → int
10.75  → 10
```

### 🎯 Interview Answer

> **Type casting is the process of converting a value from one compatible data type to another. In Java, numeric conversions can be widening conversions, which are generally automatic, or narrowing conversions, which usually require explicit casting.**
