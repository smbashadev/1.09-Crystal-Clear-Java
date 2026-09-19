# 🧒 `int` in Java

### 🔹 What is `int`?

`int` is a **primitive integer data type** used to store **whole numbers**.

It is the **most commonly used integer type** in Java.

Think of `int` as a **medium/large box for whole numbers** 📦.

---

## 1️⃣ 32-bit

An `int` uses **32 bits** of memory.

```text
32 bits = 4 bytes
```

Compare:

```text
byte  → 8 bits  → 1 byte
short → 16 bits → 2 bytes
int   → 32 bits → 4 bytes
```

So `int` can store a much larger range than `byte` and `short`.

---

## 2️⃣ Range

An `int` can store values from:

```text
-2,147,483,648
        ↓
+2,147,483,647
```

That's **4,294,967,296 different values**.

### ✅ Valid

```java
int age = 26;
int marks = 95;
int salary = 50000;
int population = 1000000;
```

### ❌ Too large

```java
int number = 3000000000;
```

That value is outside the `int` range.

---

## 3️⃣ `int` Keyword

`int` is the **keyword** used to declare an integer variable.

### Syntax

```java
int variableName = value;
```

Example:

```java
int age = 26;
```

Here:

```text
int → Data type
age → Variable
26  → Value
```

---

# 4️⃣ `int` Used in Control Loops

`int` is very commonly used as a **loop/control variable**, especially with `for` loops.

Example:

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Output:

```text
1
2
3
4
5
```

Here:

```text
i = 1
 ↓
i = 2
 ↓
i = 3
 ↓
i = 4
 ↓
i = 5
```

The variable `i` controls how many times the loop runs.

That's why your notes say:

> **`int` → Used in control loops**

It is **common**, but not a rule that loops must always use `int`.

---

# 💻 Simple Example

```java
class Demo {
    public static void main(String[] args) {

        int age = 26;
        int marks = 95;
        int salary = 50000;

        System.out.println(age);
        System.out.println(marks);
        System.out.println(salary);
    }
}
```

### Output

```text
26
95
50000
```

---

# 🧒 Box Analogy

Imagine three boxes:

```text
byte
┌──────────────┐
│ Small range  │
└──────────────┘

short
┌──────────────────┐
│ Bigger range     │
└──────────────────┘

int
┌────────────────────────────┐
│ Much bigger range          │
└────────────────────────────┘
```

So:

```text
byte → short → int
 8       16      32 bits
```

---

## 📊 Quick Comparison

| Type      |                  Size |                               Range |
| --------- | --------------------: | ----------------------------------: |
| `byte`    |       8 bits / 1 byte |                         -128 to 127 |
| `short`   |     16 bits / 2 bytes |                   -32,768 to 32,767 |
| **`int`** | **32 bits / 4 bytes** | **-2,147,483,648 to 2,147,483,647** |

---

### 🎯 Interview Answer

> **`int` is a 32-bit signed primitive integer data type in Java. It occupies 4 bytes and can store whole-number values from -2,147,483,648 to 2,147,483,647. It is commonly used for integer calculations and loop-control variables.**

### 🧠 Easy Memory Trick

> **int = 32 bits = 4 bytes = about ±2.147 billion**

```text
byte  → 1 byte
short → 2 bytes
int   → 4 bytes
long  → 8 bytes
```

**1 → 2 → 4 → 8 bytes** 🚀
