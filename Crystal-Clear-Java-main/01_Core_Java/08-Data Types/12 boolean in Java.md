# 🧒 `boolean` in Java

### 🔹 What is `boolean`?

`boolean` is a **primitive data type** used to store only **two logical values**:

```text
true
false
```

Think of `boolean` as an **ON/OFF switch** 🔘.

---

# 1️⃣ Logical Values

A logical value answers a question such as:

> Is the person eligible?

The answer can be:

```text
YES → true
NO  → false
```

In Java:

```java
boolean eligible = true;
```

---

# 2️⃣ `true`

`true` means:

> **The condition is correct / yes / enabled.**

Example:

```java
boolean isJavaEasy = true;
```

Conceptually:

```text
isJavaEasy
    ↓
  true
    ↓
   YES ✅
```

---

# 3️⃣ `false`

`false` means:

> **The condition is not correct / no / disabled.**

Example:

```java
boolean isRaining = false;
```

Conceptually:

```text
isRaining
    ↓
  false
    ↓
    NO ❌
```

---

# 4️⃣ `boolean` Keyword

`boolean` is the **keyword** used to declare a boolean variable.

### Syntax

```java
boolean variableName = true;
```

or:

```java
boolean variableName = false;
```

Example:

```java
boolean passed = true;
boolean married = false;
```

---

# 🧒 Real-Life Example

Imagine a light switch:

```text
💡 ON  → true
💡 OFF → false
```

A boolean works similarly:

```java
boolean lightOn = true;
```

If you turn it off:

```java
lightOn = false;
```

Only two values are possible:

```text
true ↔ false
```

---

# 💻 Example Program

```java
class Demo {
    public static void main(String[] args) {

        boolean isJavaEasy = true;
        boolean isRaining = false;

        System.out.println(isJavaEasy);
        System.out.println(isRaining);
    }
}
```

### Output

```text
true
false
```

---

# 🔥 Boolean with Conditions

Boolean values are especially useful when checking conditions.

```java
int age = 25;

boolean eligible = age >= 18;

System.out.println(eligible);
```

Output:

```text
true
```

Why?

```text
age = 25
     ↓
25 >= 18
     ↓
true
```

If:

```java
int age = 15;
```

then:

```text
15 >= 18
     ↓
false
```

---

# 🧠 Important Point

Java's boolean has only:

```text
true
false
```

It is **not**:

```text
1 = true
0 = false
```

as a general Java language rule. Java does not allow assigning `1` or `0` directly to a `boolean`.

For example:

```java
boolean result = 1;  // ❌
```

Correct:

```java
boolean result = true;  // ✅
```

---

# 📊 Quick Summary

| Feature    | `boolean`                      |
| ---------- | ------------------------------ |
| Purpose    | Store logical values           |
| Values     | `true`, `false`                |
| Keyword    | `boolean`                      |
| Example    | `boolean passed = true;`       |
| Common use | Conditions and decision-making |

### 🎯 Interview Answer

> **`boolean` is a primitive data type in Java used to represent a logical value. It can have only two values: `true` or `false`.**

### 🧠 Easy Memory Trick

> **boolean = YES or NO**

```text
true  → YES ✅
false → NO  ❌
```

**Think: `boolean` = ON/OFF switch.** 🔘
