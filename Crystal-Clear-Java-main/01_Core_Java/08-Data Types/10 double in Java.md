# 🧒 `double` in Java

### 🔹 What is `double`?

`double` is a **primitive floating-point data type** used to store **decimal/fractional numbers**.

Examples:

```text
10.5
99.99
3.14159
```

Think of `double` as a **bigger decimal-number box** than `float`. 📦

---

## 1️⃣ 64-bit

`double` uses:

```text
64 bits = 8 bytes
```

Compare:

```text
float  → 32 bits → 4 bytes
double → 64 bits → 8 bytes
```

So `double` has more storage space for representing floating-point numbers.

---

## 2️⃣ Range

The approximate range of a Java `double` is:

```text
±4.9 × 10⁻³²⁴
to
±1.8 × 10³⁰⁸
```

😵 Don't worry about memorizing those numbers for basic learning.

Just remember:

> **`double` can represent extremely small and extremely large floating-point values.**

---

## 3️⃣ Higher Precision Than `float`

This is one of the most important differences.

```text
float  → Single precision
double → Double precision
```

Typically:

```text
float  → about 6–7 decimal digits of precision
double → about 15–16 decimal digits of precision
```

For example:

```java
float f = 3.1415926f;
double d = 3.141592653589793;
```

`double` can represent more significant digits than `float`.

---

# 4️⃣ Decimal Accuracy

`double` gives **more precision than `float`**, so it is generally preferred for ordinary decimal calculations.

Example:

```java
double pi = 3.141592653589793;
```

However, **more precision does not mean perfect decimal accuracy**.

For example:

```java
double result = 0.1 + 0.2;
System.out.println(result);
```

You may get:

```text
0.30000000000000004
```

Why?

Because `double` uses **binary floating-point representation**, and some decimal fractions cannot be represented exactly.

So remember:

> **double = higher precision, but not exact decimal arithmetic.**

For exact financial/decimal calculations, Java commonly uses `BigDecimal`.

---

# 5️⃣ `double` Keyword

`double` is the **keyword** used to declare a double variable.

### Syntax

```java
double variableName = value;
```

Example:

```java
double salary = 45678.75;
```

Here:

```text
double  → Data type
salary  → Variable
45678.75 → Value
```

---

# ⭐ No `d` Required

A decimal literal in Java is **`double` by default**.

So this is perfectly valid:

```java
double price = 99.99;
```

You can also write:

```java
double price = 99.99d;
```

or:

```java
double price = 99.99D;
```

But the `d/D` is usually unnecessary.

---

# 💻 Example Program

```java
class Demo {
    public static void main(String[] args) {

        double price = 99.99;
        double pi = 3.141592653589793;
        double distance = 123456.789;

        System.out.println(price);
        System.out.println(pi);
        System.out.println(distance);
    }
}
```

### Output

```text
99.99
3.141592653589793
123456.789
```

---

# 📊 `float` vs `double`

| Feature         |                         `float` |                        `double` |
| --------------- | ------------------------------: | ------------------------------: |
| Size            |                         32 bits |                     **64 bits** |
| Bytes           |                               4 |                           **8** |
| Precision       |                     ~6–7 digits |               **~15–16 digits** |
| Precision type  |                          Single |                      **Double** |
| Decimal literal |                     Needs `f/F` |                     **Default** |
| Common choice   | Specific memory-sensitive cases | **Normal decimal calculations** |

---

## 🧒 Easy Box Analogy

```text
float
┌────────────────────┐
│ Decimal numbers    │
│ 32 bits            │
│ Less precision     │
└────────────────────┘

double
┌────────────────────────────┐
│ Decimal numbers            │
│ 64 bits                    │
│ Higher precision           │
└────────────────────────────┘
```

### 🧠 Easy Memory Trick

> **double = 64 bits + 8 bytes + higher precision + decimal values**

```text
float  → 32 bits → ~6–7 digits
double → 64 bits → ~15–16 digits
```

### 🎯 Interview Answer

> **`double` is a 64-bit double-precision floating-point primitive data type in Java. It occupies 8 bytes and provides approximately 15–16 decimal digits of precision, making it the usual choice for general floating-point calculations.**
