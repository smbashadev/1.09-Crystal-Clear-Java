# 🧒 Mutable Strings

We already learned:

> **String is immutable** → once a String object is created, its contents cannot be changed.

But sometimes our program needs to **change text again and again**.

For example:

```text
Java
Java Programming
Java Programming Language
Java Programming Language Course
```

Creating a new String every time can be inconvenient.

For this purpose, Java provides **mutable string classes** such as:

* `StringBuffer`
* `StringBuilder`

> 🧠 **Mutable = the existing object's contents can be changed.**

---

# 1. What is StringBuffer?

`StringBuffer` is a Java class used to create and modify **mutable sequences of characters**.

Think of it like an **erasable notebook**.

With a normal String:

```text
"Java"
```

you don't change the existing String.

With `StringBuffer`:

```text
Java
```

you can add, remove, or change characters in the same mutable object.

### Simple memory trick

> **String = cannot change**
>
> **StringBuffer = can change**

---

# 2. Creating a StringBuffer

Syntax:

```java
StringBuffer variableName = new StringBuffer("text");
```

Example:

```java
StringBuffer sb = new StringBuffer("Java");
```

Conceptually:

```text
sb
 ↓
"Java"
```

Now we can modify the contents using methods such as:

```text
append()
insert()
delete()
replace()
reverse()
```

---

# 3. StringBuffer `append()`

Suppose we have:

```java
StringBuffer sb = new StringBuffer("Java");
```

Now:

```java
sb.append(" Programming");
```

The contents become:

```text
Java Programming
```

The important point is:

> The **same StringBuffer object can be modified**.

---

# 4. StringBuffer Complete Program

```java
class StringBufferDemo {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("Java");

        System.out.println("Before: " + sb);

        sb.append(" Programming");

        System.out.println("After: " + sb);
    }
}
```

### Output

```text
Before: Java
After: Java Programming
```

### 🧠 What happened?

First:

```java
StringBuffer sb = new StringBuffer("Java");
```

We created a mutable StringBuffer containing:

```text
Java
```

Then:

```java
sb.append(" Programming");
```

added more characters.

Now the same StringBuffer contains:

```text
Java Programming
```

---

# 5. Another StringBuffer Example

```java
class StringBufferDemo {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("Hello");

        sb.append(" Java");
        sb.append(" World");

        System.out.println(sb);
    }
}
```

### Output

```text
Hello Java World
```

Three stages:

```text
"Hello"

   ↓ append(" Java")

"Hello Java"

   ↓ append(" World")

"Hello Java World"
```

This is why we call it **mutable**.

---

# 6. StringBuilder

`StringBuilder` is another Java class used for **mutable character sequences**.

It works similarly to `StringBuffer`.

Example:

```java
StringBuilder sb = new StringBuilder("Java");
```

Then:

```java
sb.append(" Programming");
```

The contents become:

```text
Java Programming
```

---

# 7. StringBuilder Complete Program

```java
class StringBuilderDemo {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Java");

        System.out.println("Before: " + sb);

        sb.append(" Programming");

        System.out.println("After: " + sb);
    }
}
```

### Output

```text
Before: Java
After: Java Programming
```

Again:

```text
Before → Java

append()

After → Java Programming
```

The `StringBuilder` object can be modified.

---

# 8. StringBuilder Multiple Changes

```java
class StringBuilderDemo {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Java");

        sb.append(" is");
        sb.append(" easy");

        System.out.println(sb);
    }
}
```

### Output

```text
Java is easy
```

The object changes step by step:

```text
Java
 ↓
Java is
 ↓
Java is easy
```

---

# 9. StringBuffer vs StringBuilder

Both are **mutable**.

| Feature                                | StringBuffer   | StringBuilder    |
| -------------------------------------- | -------------- | ---------------- |
| Mutable                                | ✅ Yes          | ✅ Yes            |
| Stores characters/text                 | ✅              | ✅                |
| Can modify existing object             | ✅              | ✅                |
| `append()`                             | ✅              | ✅                |
| `insert()`                             | ✅              | ✅                |
| `delete()`                             | ✅              | ✅                |
| `reverse()`                            | ✅              | ✅                |
| Thread synchronization                 | Synchronized   | Not synchronized |
| General performance                    | Usually slower | Usually faster   |
| Common choice for single-threaded code | Possible       | Often preferred  |

For your beginner understanding, remember:

> **StringBuffer and StringBuilder are both mutable.**

The important difference is that **StringBuffer's methods are synchronized**, while StringBuilder is not.

---

# 10. Why Does StringBuilder Usually Perform Better?

Imagine you want to build a sentence by adding words repeatedly:

```text
Java
Java is
Java is very
Java is very easy
Java is very easy to learn
```

With a mutable builder, the object is designed for repeated modification.

```java
StringBuilder sb = new StringBuilder();

sb.append("Java");
sb.append(" is");
sb.append(" very");
sb.append(" easy");
```

This is one reason `StringBuilder` is commonly preferred when a single thread is repeatedly modifying text.

---

# 11. String vs StringBuffer vs StringBuilder

This is the easiest comparison to remember:

```text
String
  ↓
Immutable
  ↓
Cannot modify existing String


StringBuffer
  ↓
Mutable
  ↓
Can modify
  ↓
Synchronized


StringBuilder
  ↓
Mutable
  ↓
Can modify
  ↓
Not synchronized
```

---

# 12. Very Important Example

### String

```java
String s = "Java";

s.concat(" Programming");

System.out.println(s);
```

Output:

```text
Java
```

The original String wasn't modified.

---

### StringBuffer

```java
StringBuffer sb = new StringBuffer("Java");

sb.append(" Programming");

System.out.println(sb);
```

Output:

```text
Java Programming
```

The StringBuffer was modified.

---

### StringBuilder

```java
StringBuilder sb = new StringBuilder("Java");

sb.append(" Programming");

System.out.println(sb);
```

Output:

```text
Java Programming
```

The StringBuilder was modified.

---

# 🧠 13. The Best Memory Trick

Imagine three notebooks.

### 📕 String

**Stone notebook**

```text
Java
```

Cannot modify the existing text.

### 📘 StringBuffer

**Editable notebook with synchronized access**

```text
Java
 ↓
Java Programming
```

### 📗 StringBuilder

**Editable notebook optimized for ordinary single-threaded modification**

```text
Java
 ↓
Java Programming
 ↓
Java Programming Course
```

So remember:

> 🔴 **String → Immutable**
>
> 🔵 **StringBuffer → Mutable + Synchronized**
>
> 🟢 **StringBuilder → Mutable + Not Synchronized**

---

# ⭐ Final Revision

### StringBuffer

> `StringBuffer` is a **mutable** class that allows the contents of a character sequence to be modified after creation. Its methods are synchronized.

Example:

```java
StringBuffer sb = new StringBuffer("Java");
sb.append(" Programming");

System.out.println(sb);
```

Output:

```text
Java Programming
```

### StringBuilder

> `StringBuilder` is a **mutable** class that allows the contents of a character sequence to be modified after creation. It is not synchronized and is commonly preferred for repeated string modifications in single-threaded code.

Example:

```java
StringBuilder sb = new StringBuilder("Java");
sb.append(" Programming");

System.out.println(sb);
```

Output:

```text
Java Programming
```

### 🧠 Remember forever

```text
STRING
   ↓
IMMUTABLE

STRINGBUFFER
   ↓
MUTABLE
   ↓
SYNCHRONIZED

STRINGBUILDER
   ↓
MUTABLE
   ↓
NOT SYNCHRONIZED
```
