# 🧒 Implicit Type Casting

## 🔹 What is Implicit Type Casting?

**Implicit type casting means Java automatically converts a value from one compatible type to another without you writing the cast.**

Your main idea is:

> **Smaller/Lower type → Larger/Higher type = Widening**

For example:

```java
int number = 100;
double value = number;
```

You didn't write `(double)`, but Java automatically converts `100` into a `double` value.

```text
int 100
  ↓
Java automatically converts
  ↓
double 100.0
```

---

# 1️⃣ Smaller Type → Larger Type

The common numeric widening sequence is:

```text
byte
  ↓
short
  ↓
int
  ↓
long
  ↓
float
  ↓
double
```

So Java can automatically perform conversions such as:

```text
byte → short
short → int
int → long
long → float
float → double
```

---

# 2️⃣ Automatic Conversion 🤖

### Example: `byte → short`

```java
byte b = 10;
short s = b;
```

Java automatically converts:

```text
10 (byte)
    ↓
10 (short)
```

No cast is required.

---

### Example: `short → int`

```java
short s = 100;
int i = s;
```

```text
100 (short)
    ↓
100 (int)
```

---

### Example: `int → long`

```java
int i = 1000;
long l = i;
```

```text
1000 (int)
     ↓
1000 (long)
```

---

### Example: `long → float`

```java
long l = 1000;
float f = l;
```

Java allows this conversion automatically.

⚠️ **Important:** `long → float` is widening in Java's conversion rules, but `float` cannot represent every `long` value exactly. So **widening does not always mean zero precision loss**.

---

### Example: `float → double`

```java
float f = 10.5f;
double d = f;
```

```text
10.5 (float)
      ↓
10.5 (double)
```

---

# 🧒 Real-Life Analogy

Imagine containers:

```text
🥤 byte
   ↓
🫙 short
   ↓
🪣 int
   ↓
🛢️ long
```

You are moving something from a smaller container to a larger container.

The larger container can accommodate the smaller value.

That's why Java can usually do it automatically.

---

# 3️⃣ Why is it Called Widening?

Because the **target type has a wider range/representation than the source type** according to Java's numeric conversion rules.

Example:

```text
byte → short
```

```text
byte:
-128 to 127

short:
-32,768 to 32,767
```

So:

```text
byte
  ↓
short
```

The target type can represent the entire range of the source type.

---

# 💻 Complete Example

```java
class Demo {
    public static void main(String[] args) {

        byte b = 10;
        short s = b;
        int i = s;
        long l = i;
        float f = l;
        double d = f;

        System.out.println(b);
        System.out.println(s);
        System.out.println(i);
        System.out.println(l);
        System.out.println(f);
        System.out.println(d);
    }
}
```

### Output

```text
10
10
10
10
10.0
10.0
```

Notice:

> **We never wrote `(short)`, `(int)`, `(long)`, etc.**

Java performed the conversions automatically.

---

# 🔥 Implicit vs Explicit

```text
             Type Casting
                  ↓
          ┌───────┴────────┐
          ↓                ↓
      Implicit          Explicit
          ↓                ↓
     Automatic           Manual
          ↓                ↓
      Widening          Narrowing*
          ↓                ↓
  byte → short       double → int
```

`*` Narrowing conversions commonly require explicit casting.

---

## ⚠️ One Important Correction

Your notes call this:

> **Smaller/lower type → larger/higher type**

That's a good beginner shortcut, but don't think "larger" only means **more bytes**.

For example:

```text
long → float
```

is a widening primitive conversion in Java even though both use 64 bits.

Why?

Because the conversion is considered **widening by Java's type-conversion rules**, although `float` has less integer precision than `long`.

---

# 🎯 Interview Answer

> **Implicit type casting, also called widening conversion, is the automatic conversion of a value from one compatible numeric type to another wider type without explicitly writing a cast. Examples include `byte → short`, `short → int`, `int → long`, `long → float`, and `float → double`.**

### 🧠 Easy Memory Trick

```text
byte → short → int → long → float → double
```

> **Implicit = Automatic 🤖**
> **Widening = Moving to a wider compatible type ➡️**
