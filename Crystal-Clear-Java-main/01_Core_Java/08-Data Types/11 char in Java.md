# 🧒 `char` in Java

## 🔹 What is `char`?

`char` is a **primitive data type in Java used to store a single character**.

Examples:

```text
'A'
'B'
'7'
'$'
'@'
```

Think of `char` as a **small box that holds one character** 📦.

```java
char grade = 'A';
```

Here:

```text
char  → Data type
grade → Variable
'A'   → Character value
```

---

# 1️⃣ Single Character

A `char` stores **one character only**.

### ✅ Correct

```java
char ch = 'A';
char grade = 'A';
char symbol = '#';
```

### ❌ Incorrect

```java
char name = 'Basha';
```

because `"Basha"` contains multiple characters.

If you want multiple characters, use `String`:

```java
String name = "Basha";
```

### 🧠 Remember

```text
char   → one character
String → multiple characters
```

---

# 2️⃣ Java `char`

In Java, `char` is a **primitive data type**.

```java
char letter = 'A';
```

Java uses **single quotes** for a character:

```java
'A'
```

Whereas a String uses double quotes:

```java
"A"
```

```text
'A'  → char
"A"  → String
```

---

# 3️⃣ Difference from C/C++

This is an important point.

In **Java**, `char` is:

> **16-bit and represents a UTF-16 code unit.**

In traditional C, the size of `char` is **1 byte**.

C++ also defines `char` as a 1-byte type, while also providing other character types such as `wchar_t`, `char16_t`, and `char32_t`.

So don't simply say:

> "`char` is always 16-bit in C/C++." ❌

For Java:

```text
Java char → 16 bits
```

---

# 4️⃣ Unicode 🌍

Java `char` is based on **Unicode/UTF-16**.

Unicode gives characters numeric code points so computers can represent characters from many writing systems.

For example:

```text
A → U+0041
B → U+0042
a → U+0061
```

This allows Java to work with characters from many languages.

### ⚠️ Important Unicode detail

A Java `char` is **16 bits**, but not every Unicode character fits into one `char`.

Characters whose Unicode code point is above `U+FFFF` are represented using **two `char` values** (a surrogate pair).

For basic Java learning, you can remember:

> **`char` uses UTF-16 and can directly represent a single 16-bit code unit.**

---

# 5️⃣ 16-bit

Java `char` uses:

```text
16 bits = 2 bytes
```

So:

```text
char → 16 bits → 2 bytes
```

---

# 6️⃣ Range: `0–65535`

Because Java `char` is a **16-bit unsigned type**, its numeric range is:

```text
0 → 65,535
```

Notice something important:

> There are **no negative `char` values**.

---

# 7️⃣ No Negative Characters

Unlike `byte`, `short`, `int`, and `long`, Java `char` is **unsigned**.

For example:

```java
char ch = -1;   // ❌
```

This is not allowed.

But:

```java
char ch = 65;   // ✅
```

is allowed because `65` is within:

```text
0 → 65535
```

---

# 8️⃣ `char` Keyword

`char` is the keyword used to declare a character variable.

### Syntax

```java
char variableName = 'character';
```

Example:

```java
char letter = 'A';
```

---

# 9️⃣ Integer-to-Character Conversion

This is one of the interesting features of Java.

A `char` has a numeric value associated with it.

For example:

```text
'A' → 65
'B' → 66
'C' → 67
```

So you can convert an integer to a `char`.

```java
char ch = (char) 65;
```

Now:

```text
65 → 'A'
```

---

# 🔥 ASCII Character Corresponding to Integer Value

For the basic English characters, Java's character values match **ASCII**.

For example:

```text
65 → A
66 → B
67 → C

97 → a
98 → b
99 → c
```

Example:

```java
class Demo {
    public static void main(String[] args) {

        char ch = (char) 65;

        System.out.println(ch);
    }
}
```

### Output

```text
A
```

---

# 🧒 Why Does This Work?

Think of characters as having **number labels**.

```text
┌──────────────┐
│ Character    │
├──────────────┤
│ A → 65       │
│ B → 66       │
│ C → 67       │
└──────────────┘
```

When you say:

```java
char ch = (char) 65;
```

you're telling Java:

> "Take the numeric value 65 and interpret it as the corresponding `char`."

So:

```text
65
 ↓
'A'
```

---

# 💻 More Examples

```java
class Demo {
    public static void main(String[] args) {

        char ch1 = 'A';
        char ch2 = 'B';

        char ch3 = (char) 67;
        char ch4 = (char) 97;

        System.out.println(ch1);
        System.out.println(ch2);
        System.out.println(ch3);
        System.out.println(ch4);
    }
}
```

### Output

```text
A
B
C
a
```

---

# ⭐ Character-to-Integer Also Works

You can go in the opposite direction.

```java
char ch = 'A';

int number = ch;

System.out.println(number);
```

Output:

```text
65
```

So:

```text
'A' → 65
65  → 'A'
```

For ASCII characters, this is particularly easy to remember.

---

# 🧠 Important: `char` Arithmetic

Because `char` is an integral primitive type, you can perform arithmetic with it.

Example:

```java
char ch = 'A';

System.out.println(ch + 1);
```

Output:

```text
66
```

Why?

```text
'A' → 65
65 + 1 → 66
```

If you want the resulting character:

```java
char next = (char) (ch + 1);

System.out.println(next);
```

Output:

```text
B
```

---

# 📊 `char` Quick Summary

| Feature             | Java `char`                                               |
| ------------------- | --------------------------------------------------------- |
| Purpose             | Single character / UTF-16 code unit                       |
| Size                | **16 bits**                                               |
| Bytes               | **2 bytes**                                               |
| Range               | **0–65,535**                                              |
| Negative values     | ❌ No                                                      |
| Keyword             | `char`                                                    |
| Literal             | `'A'`                                                     |
| Character encoding  | UTF-16                                                    |
| ASCII compatibility | Basic ASCII characters have their standard numeric values |

---

# 🔄 Easy Flow

```text
Character
   ↓
Unicode / UTF-16 value
   ↓
16-bit char
```

For ASCII characters:

```text
'A'
 ↓
65
```

And conversion back:

```text
65
 ↓
(char)
 ↓
'A'
```

---

## 🎯 Interview Answer

> **`char` is a 16-bit unsigned primitive data type in Java used to represent a UTF-16 code unit. It has a range of 0 to 65,535 and cannot store negative values. For basic ASCII characters, the numeric values correspond to their ASCII codes; for example, `(char)65` gives `'A'`.**

### 🧠 Easy Memory Trick

> **char = 1 character + 16 bits + 2 bytes + 0 to 65,535**

And remember:

```text
'A' → 65
'B' → 66
'C' → 67

65 → (char) → 'A'
```

**`char` = Character ↔ Numeric value** 🔤🔢
