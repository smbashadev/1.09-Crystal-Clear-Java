# 🧒 Floating-Point Data Types in Java

### 🔹 What are Floating-Point Data Types?

**Floating-point data types are used to store numbers that can have decimal values.**

For example:

```text
10.5
3.14
99.99
-25.75
```

Java has **two floating-point primitive data types**:

```text
float
double
```

Think of them as **boxes for decimal numbers** 📦.

---

# 1️⃣ `float`

`float` is used to store decimal numbers with **single precision**.

### Size

```text
32 bits = 4 bytes
```

### Example

```java
float price = 99.50f;
```

Notice the **`f`** at the end:

```text
99.50f
     ↑
   float
```

Without `f`:

```java
float price = 99.50;   // ❌
```

Java treats a decimal literal like `99.50` as a `double` by default, so you normally write:

```java
float price = 99.50f;  // ✅
```

---

# 2️⃣ `double`

`double` is used to store decimal numbers with **double precision**.

### Size

```text
64 bits = 8 bytes
```

Example:

```java
double price = 99.50;
```

No `d` is normally required because decimal literals are `double` by default.

---

# 🧒 Simple Box Analogy

Imagine you have two boxes for decimal numbers:

```text
float
┌─────────────────┐
│ Decimal values  │
│ 32 bits         │
└─────────────────┘

double
┌────────────────────────┐
│ Decimal values         │
│ 64 bits                │
│ More precision         │
└────────────────────────┘
```

`double` has **more precision** than `float`.

---

# 📊 `float` vs `double`

| Feature         |                                              `float` |                         `double` |
| --------------- | ---------------------------------------------------: | -------------------------------: |
| Size            |                                              32 bits |                          64 bits |
| Bytes           |                                              4 bytes |                          8 bytes |
| Precision       |                                               Single |                           Double |
| Decimal literal |                                    Usually needs `f` |                          Default |
| Common use      | When memory matters and precision needs are moderate | **General decimal calculations** |

---

# 💻 Example Program

```java
class Demo {
    public static void main(String[] args) {

        float price = 99.50f;
        double salary = 45678.75;

        System.out.println(price);
        System.out.println(salary);
    }
}
```

### Output

```text
99.5
45678.75
```

---

# 🔥 Important: `double` is Usually Preferred

In normal Java programs, **`double` is generally preferred over `float`** when you need ordinary floating-point calculations because it provides more precision.

For example:

```java
double average = 85.75;
```

---

## ⚠️ One Important Point About Decimal Accuracy

`float` and `double` use **binary floating-point representation**, so some decimal values cannot be represented exactly.

For example:

```java
double result = 0.1 + 0.2;
System.out.println(result);
```

You may see something like:

```text
0.30000000000000004
```

So for applications requiring **exact decimal arithmetic**, such as financial calculations, Java commonly uses `BigDecimal` rather than relying on `float` or `double`.

---

# 🧠 Easy Memory Trick

Remember:

```text
float  → 32 bits → 4 bytes → less precision
double → 64 bits → 8 bytes → more precision
```

> **`float` = smaller decimal box**
> **`double` = bigger, more precise decimal box**

### 🎯 Interview Answer

> **Java provides two floating-point primitive data types: `float` and `double`. `float` is 32-bit single precision, while `double` is 64-bit double precision and is generally preferred for ordinary decimal calculations.**
