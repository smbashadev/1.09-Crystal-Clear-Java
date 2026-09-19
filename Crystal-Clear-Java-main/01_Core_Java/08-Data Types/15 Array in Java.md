# 🧒 Array in Java

## 🔹 What is an Array?

An **array** is a **non-primitive/reference type** in Java that stores **multiple values of the same type** under one variable name.

Imagine you want to store 5 marks.

Without an array:

```java
int mark1 = 80;
int mark2 = 90;
int mark3 = 75;
int mark4 = 85;
int mark5 = 95;
```

With an array:

```java
int[] marks = {80, 90, 75, 85, 95};
```

Much easier!

> **Array = Collection of similar-type values.**

---

# 1️⃣ Non-Primitive Data Type

Arrays are **reference types** in Java.

Example:

```java
int[] marks = new int[5];
```

Here:

```text
int[]       → Array/reference type
marks       → Reference variable
new int[5]  → Creates an array object
```

Conceptually:

```text
marks
  │
  ↓
┌────┬────┬────┬────┬────┐
│ 0  │ 0  │ 0  │ 0  │ 0  │
└────┴────┴────┴────┴────┘
```

---

# 2️⃣ Collection of Similar Data

An array normally stores elements of **one declared type**.

For example:

```java
int[] numbers = {10, 20, 30, 40};
```

All are `int` values.

Similarly:

```java
String[] names = {"Basha", "Ravi", "Rahul"};
```

All are `String` references.

You cannot do this:

```java
int[] values = {10, "Java", 20}; // ❌
```

because `"Java"` is not an `int`.

### 🧠 Remember

> **One array → One declared element type**

---

# 3️⃣ Elements

The individual values stored inside an array are called **elements**.

Example:

```java
int[] numbers = {10, 20, 30, 40};
```

Here:

```text
┌────┬────┬────┬────┐
│ 10 │ 20 │ 30 │ 40 │
└────┴────┴────┴────┘
  ↑    ↑    ↑    ↑
Element Element Element Element
```

So:

```text
10 → element
20 → element
30 → element
40 → element
```

---

# 4️⃣ Index

Every array element has a position number called an **index**.

Example:

```java
int[] numbers = {10, 20, 30, 40};
```

The indexes are:

```text
Index:     0     1     2     3
           ↓     ↓     ↓     ↓
        ┌────┬────┬────┬────┐
Value:  │ 10 │ 20 │ 30 │ 40 │
        └────┴────┴────┴────┘
```

To access an element:

```java
System.out.println(numbers[0]);
```

Output:

```text
10
```

And:

```java
System.out.println(numbers[2]);
```

Output:

```text
30
```

---

# 5️⃣ Index Starts from `0`

This is **very important**.

Java arrays start indexing from:

```text
0
```

Not:

```text
1
```

For example, if we have:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

then:

```text
Index:      0     1     2     3     4
            ↓     ↓     ↓     ↓     ↓
         ┌────┬────┬────┬────┬────┐
Value:   │ 10 │ 20 │ 30 │ 40 │ 50 │
         └────┴────┴────┴────┴────┘
```

So:

```java
numbers[0]  // 10
numbers[1]  // 20
numbers[2]  // 30
numbers[3]  // 40
numbers[4]  // 50
```

---

# 6️⃣ Last Index = Size − 1

Suppose an array has:

```text
Size = 5
```

Its indexes are:

```text
0, 1, 2, 3, 4
```

Therefore:

```text
Last index = Size - 1

           = 5 - 1

           = 4
```

### 🔥 Formula to memorize

> **Last Index = Array Length − 1**

In Java, we get the array's size using:

```java
numbers.length
```

So the last element can be accessed with:

```java
numbers[numbers.length - 1]
```

Example:

```java
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers[numbers.length - 1]);
```

Output:

```text
50
```

---

# 7️⃣ Fixed Size

Java arrays have a **fixed length after creation**.

Suppose:

```java
int[] numbers = new int[5];
```

You created space for exactly:

```text
5 elements
```

Conceptually:

```text
┌────┬────┬────┬────┬────┐
│    │    │    │    │    │
└────┴────┴────┴────┴────┘
  0    1    2    3    4
```

You cannot later make that **same array object** have 10 elements.

If you need a different size, you create another array.

```java
numbers = new int[10];
```

This makes `numbers` refer to a **new array**.

### 🧠 Remember

> **Array size is fixed after the array is created.**

---

# 8️⃣ Default Values of Array Elements ⭐

This is very important.

When you create an array using `new`, Java automatically gives its elements **default values**.

Example:

```java
int[] numbers = new int[5];
```

You haven't manually stored anything.

But Java initializes the elements:

```text
Index:      0    1    2    3    4
         ┌────┬────┬────┬────┬────┐
Value:   │ 0  │ 0  │ 0  │ 0  │ 0  │
         └────┴────┴────┴────┴────┘
```

So:

```java
System.out.println(numbers[0]);
```

Output:

```text
0
```

---

## 📊 Default Values

| Array Element Type | Default Value |
| ------------------ | ------------- |
| `byte`             | `0`           |
| `short`            | `0`           |
| `int`              | `0`           |
| `long`             | `0L`          |
| `float`            | `0.0f`        |
| `double`           | `0.0d`        |
| `char`             | `'\u0000'`    |
| `boolean`          | `false`       |
| Reference types    | `null`        |

---

# 🔹 Example: `boolean` Array

```java
boolean[] status = new boolean[3];
```

Initially:

```text
┌─────────┬─────────┬─────────┐
│ false   │ false   │ false   │
└─────────┴─────────┴─────────┘
     0         1         2
```

---

# 🔹 Example: String Array

```java
String[] names = new String[3];
```

Initially:

```text
┌──────┬──────┬──────┐
│ null │ null │ null │
└──────┴──────┴──────┘
   0      1      2
```

Why `null`?

Because `String` is a **reference type**, and the elements don't refer to String objects yet.

---

# 💻 Complete Array Program

```java
class ArrayDemo {
    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println(numbers[0]);
        System.out.println(numbers[1]);
        System.out.println(numbers[2]);
        System.out.println(numbers[3]);
        System.out.println(numbers[4]);
    }
}
```

### Output

```text
10
20
30
40
50
```

---

# 🔄 Complete Picture

```text
int[] numbers = {10, 20, 30, 40, 50};

numbers
   │
   ↓
       ARRAY OBJECT

Index      0     1     2     3     4
           ↓     ↓     ↓     ↓     ↓
        ┌────┬────┬────┬────┬────┐
Value   │ 10 │ 20 │ 30 │ 40 │ 50 │
        └────┴────┴────┴────┴────┘

Size = 5

First index = 0

Last index
   ↓
size - 1
   ↓
5 - 1
   ↓
4
```

---

# ⚠️ What If We Use a Wrong Index?

Suppose:

```java
int[] numbers = {10, 20, 30};
```

Valid indexes:

```text
0
1
2
```

If you try:

```java
System.out.println(numbers[3]);
```

Java throws an:

```text
ArrayIndexOutOfBoundsException
```

because index `3` doesn't exist.

---

# 🎯 Interview Answer

> **An array in Java is a reference type used to store a fixed-size collection of elements of the same declared type. Each element is accessed using an index starting from 0, so the last valid index is `length - 1`. When an array is created using `new`, Java automatically initializes its elements with their default values.**

# 🧠 Easy Memory Trick

Remember:

> **Array = Same Type + Multiple Values + Index + Fixed Size**

```text
Array
  ↓
Multiple similar elements
  ↓
Index starts at 0
  ↓
Last index = length - 1
  ↓
Size fixed after creation
  ↓
Elements receive default values
```

### ⭐ Most important formula

> **First Index = `0`**
> **Last Index = `array.length - 1`**
