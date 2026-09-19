# 🧒 Primitive Data Types — Integer Types in Java

### 🔹 What are Primitive Data Types?

**Primitive data types are Java's basic built-in data types used to store simple values directly.**

Java has **8 primitive data types**:

```text
byte
short
int
long
float
double
char
boolean
```

Today we're focusing on the **4 integer primitive data types**:

```text
byte → short → int → long
```

These are used to store **whole numbers**.

---

# 🔢 Integer Primitive Data Types

An **integer** means a whole number without a decimal point.

Examples:

```text
10
-25
0
1000
```

Not integers:

```text
10.5
3.14
```

Java provides four integer types mainly to give you different ranges of whole numbers.

---

## 1️⃣ `byte`

`byte` is used for **small whole numbers**.

```java
byte age = 25;
```

### Size

```text
8 bits = 1 byte
```

### Range

```text
-128 to 127
```

Example:

```java
byte temperature = 30;
byte marks = 100;
```

But:

```java
byte number = 200;  // ❌
```

because `200` is outside the `byte` range.

---

# 2️⃣ `short`

`short` can store **larger whole numbers than byte**.

```java
short salary = 25000;
```

### Size

```text
16 bits = 2 bytes
```

### Range

```text
-32,768 to 32,767
```

Example:

```java
short population = 30000;
```

But:

```java
short number = 40000;  // ❌
```

because `40000` is outside its range.

---

# 3️⃣ `int`

`int` is the **most commonly used integer type** in normal Java programs.

```java
int age = 25;
int salary = 50000;
```

### Size

```text
32 bits = 4 bytes
```

### Range

```text
-2,147,483,648
to
 2,147,483,647
```

For example:

```java
int population = 1000000;
```

For most everyday whole-number calculations, `int` is the normal choice.

---

# 4️⃣ `long`

`long` is used when you need to store **very large whole numbers**.

```java
long population = 8000000000L;
```

### Size

```text
64 bits = 8 bytes
```

### Range

```text
-9,223,372,036,854,775,808
to
 9,223,372,036,854,775,807
```

Notice the `L`:

```java
long number = 8000000000L;
```

The `L` tells Java that the integer literal should be treated as a `long`.

---

# 📊 Quick Comparison

| Type    |    Size | Approximate idea         | Range              |
| ------- | ------: | ------------------------ | ------------------ |
| `byte`  |  8 bits | Very small whole numbers | -128 to 127        |
| `short` | 16 bits | Small whole numbers      | -32,768 to 32,767  |
| `int`   | 32 bits | Normal whole numbers     | -2.147B to 2.147B  |
| `long`  | 64 bits | Very large whole numbers | ~±9.22 quintillion |

---

# 🧒 Easy Box Analogy

Imagine four boxes:

```text
┌──────────┐
│  byte    │  Small box
└──────────┘

┌──────────┐
│  short   │  Bigger box
└──────────┘

┌──────────┐
│   int    │  Much bigger box
└──────────┘

┌──────────┐
│   long   │  Huge box
└──────────┘
```

The bigger the type, the more whole-number values it can represent.

```text
byte
  ↓
short
  ↓
int
  ↓
long
```

**Range increases → Storage size increases**

---

# 🧠 Important Point

Don't think that `long` is automatically "better" than `int`.

Choose based on the value you need.

For example:

```java
int age = 26;
```

is perfectly appropriate.

You don't need:

```java
long age = 26L;
```

for a normal age.

---

# 🎯 Interview Answer

> **Java provides four integer primitive data types: `byte`, `short`, `int`, and `long`. They are used to store whole-number values and differ mainly in their storage size and range.**

### 🧠 Easy Memory Trick

Remember:

> **byte → short → int → long**

And remember the sizes:

```text
byte  = 1 byte
short = 2 bytes
int   = 4 bytes
long  = 8 bytes
```

So:

> **1 → 2 → 4 → 8 bytes** 🚀
