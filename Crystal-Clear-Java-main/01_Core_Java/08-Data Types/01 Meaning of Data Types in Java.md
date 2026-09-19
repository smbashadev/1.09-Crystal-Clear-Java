# 🧒 Meaning of Data Types in Java

### 🔹 What is a Data Type?

A **data type tells Java what kind of value a variable can store.**

In your notes:

> **Data Type = Classification of values**

Simply:

> 🏷️ **Data type = Label that tells Java what type of data is inside a variable.**

---

## 🧃 Simple Example

Imagine you have different boxes:

```text
📦 Box 1 → 25
📦 Box 2 → "Basha"
📦 Box 3 → 25.5
📦 Box 4 → true
```

Each box contains a different **type of value**.

In Java:

```java
int age = 25;
String name = "Basha";
double salary = 25.5;
boolean passed = true;
```

Here:

| Variable | Value     | Data Type |
| -------- | --------- | --------- |
| `age`    | `25`      | `int`     |
| `name`   | `"Basha"` | `String`  |
| `salary` | `25.5`    | `double`  |
| `passed` | `true`    | `boolean` |

---

# 🔹 "Types of Values a Variable Can Hold"

This is the second point in your notes.

For example:

```java
int age = 25;
```

Here:

* `age` → variable
* `25` → value
* `int` → data type

`int` tells Java:

> "The `age` variable is meant to hold an integer (whole-number) value."

So:

```java
int age = 25;      // ✅
int marks = 100;   // ✅
```

But:

```java
int age = "Basha"; // ❌
```

because `"Basha"` is text, not an integer.

---

# 🧠 Why Do We Need Data Types?

Java needs to know **what kind of data it is dealing with**.

For example:

```java
int a = 10;
int b = 20;

System.out.println(a + b);
```

Java knows these are numbers, so:

```text
10 + 20 = 30
```

But:

```java
String a = "10";
String b = "20";

System.out.println(a + b);
```

These are text values, so:

```text
"10" + "20" = "1020"
```

The data type helps Java understand how the value should be handled.

---

# 🏷️ Easy Analogy

Think about a **label on a container**:

```text
┌─────────────────┐
│  int            │
│  ─────────────  │
│  25             │
└─────────────────┘

┌─────────────────┐
│  String         │
│  ─────────────  │
│  "Basha"        │
└─────────────────┘
```

The label tells Java what kind of value the container is supposed to hold.

---

## 🎯 Interview Answer

> **A data type is a classification of data that specifies what type of value a variable can store and how that value can be used.**

### 🧠 Easy Memory Trick

> **Variable = Box 📦**
> **Value = Thing inside the box**
> **Data Type = Label on the box 🏷️**

```text
Data Type → tells → Variable → what value it can hold
```

**Example:**

```java
int age = 25;
```

**`int` → type, `age` → variable, `25` → value.**
