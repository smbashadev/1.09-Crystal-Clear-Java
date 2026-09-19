# 🧒 `byte` in Java

### 🔹 What is `byte`?

`byte` is a **primitive integer data type** in Java used to store **small whole numbers**.

Think of it as a **small box for numbers** 📦.

---

## 1️⃣ 8-bit

A `byte` uses **8 bits** of memory.

```text
8 bits = 1 byte
```

A bit can contain either:

```text
0 or 1
```

So a byte has:

```text
8 binary positions
```

Example:

```text
00000000
```

---

## 2️⃣ Range: `-128` to `+127`

A Java `byte` can store:

```text
-128  →  +127
```

That's **256 different values**.

```text
-128 ... -1 ... 0 ... +1 ... 127
```

### ✅ Valid

```java
byte age = 25;
byte temperature = -10;
byte marks = 100;
```

### ❌ Invalid

```java
byte number = 128;
```

Why?

Because `128` is outside the range:

```text
-128 to 127
```

---

## 3️⃣ `byte` Keyword

`byte` is the **keyword** used to declare a byte variable.

Syntax:

```java
byte variableName = value;
```

Example:

```java
byte age = 25;
```

Here:

```text
byte → data type
age  → variable
25   → value
```

---

# 💻 Example Program

```java
class Demo {
    public static void main(String[] args) {

        byte age = 25;
        byte temperature = -10;
        byte marks = 100;

        System.out.println(age);
        System.out.println(temperature);
        System.out.println(marks);
    }
}
```

### Output

```text
25
-10
100
```

---

# 🧒 Simple Box Analogy

Imagine a small box that can hold numbers only between **-128 and 127**:

```text
       byte box
┌─────────────────┐
│ -128 ... 127    │
└─────────────────┘
```

You can put:

```text
25  ✅
100 ✅
-50 ✅
127 ✅
```

But:

```text
128  ❌
200  ❌
-129 ❌
```

---

## 🧠 Why is it called `byte`?

Because it occupies **8 bits = 1 byte**.

```text
1 byte
  ↓
8 bits
  ↓
-128 to 127
```

### 🎯 Interview Answer

> **`byte` is an 8-bit signed primitive integer data type in Java. It occupies 1 byte of memory and can store values from -128 to 127.**

### 🧠 Easy Memory Trick

> **byte = 8 bits = 1 byte = -128 to 127**

```text
byte
 ↓
8 bits
 ↓
1 byte
 ↓
-128 → 127
```
