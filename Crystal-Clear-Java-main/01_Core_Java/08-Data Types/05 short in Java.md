# 🧒 `short` in Java

### 🔹 What is `short`?

`short` is a **primitive integer data type** in Java used to store **whole numbers** that are larger than the range of `byte`.

Think of it as a **bigger box for numbers** 📦.

---

## 1️⃣ 16-bit

A `short` uses **16 bits** of memory.

```text
16 bits = 2 bytes
```

Compare:

```text
byte  → 8 bits  → 1 byte
short → 16 bits → 2 bytes
```

So `short` can store more values than `byte`.

---

## 2️⃣ Range: `-32768` to `+32767`

A Java `short` can store values from:

```text
-32,768 → +32,767
```

That's **65,536 different values**.

### ✅ Valid values

```java
short age = 25;
short marks = 30000;
short temperature = -100;
```

### ❌ Invalid values

```java
short number = 40000;
```

Why?

Because `40000` is greater than the maximum:

```text
32,767
```

---

## 3️⃣ `short` Keyword

`short` is the **keyword** used to declare a short variable.

### Syntax

```java
short variableName = value;
```

### Example

```java
short marks = 30000;
```

Here:

```text
short  → Data type
marks  → Variable
30000  → Value
```

---

# 💻 Example Program

```java
class Demo {
    public static void main(String[] args) {

        short age = 25;
        short marks = 30000;
        short temperature = -100;

        System.out.println(age);
        System.out.println(marks);
        System.out.println(temperature);
    }
}
```

### Output

```text
25
30000
-100
```

---

# 🧒 Simple Box Analogy

Think of `byte` and `short` as two boxes:

```text
byte box
┌────────────────┐
│ -128 to +127   │
└────────────────┘

short box
┌────────────────────────┐
│ -32768 to +32767       │
└────────────────────────┘
```

The `short` box is bigger, so it can hold a **larger range of whole numbers**.

---

## 📊 `byte` vs `short`

| Data Type |              Size |             Range |
| --------- | ----------------: | ----------------: |
| `byte`    |   8 bits / 1 byte |       -128 to 127 |
| `short`   | 16 bits / 2 bytes | -32,768 to 32,767 |

### 🧠 Easy Memory Trick

> **short = 16 bits = 2 bytes = -32,768 to +32,767**

Remember the sequence:

```text
byte  → 8 bits  → 1 byte
short → 16 bits → 2 bytes
```

**More bits → Bigger range.**
