## 🧒 Immutable Strings

### 1. What does “Immutable” mean?

**Immutable** simply means:

> **Cannot be changed.**

Think about writing something on a **stone**.

If you write:

```text
JAVA
```

you cannot simply change the existing stone from:

```text
JAVA
```

to:

```text
PYTHON
```

Instead, you would need another stone.

Java's `String` works with a similar idea.

---

## 2. String Values Cannot Be Changed After Initialization

Suppose we create a String:

```java
String language = "Java";
```

Initially:

```text
language
   ↓
"Java"
```

Now imagine we do:

```java
language = "Python";
```

A beginner might think:

> "`Java` was changed into `Python`."

That's **not the correct way to think about String immutability**.

The important idea is:

```text
"Java"  → cannot be modified
```

The variable `language` can instead be made to refer to another String value:

```text
Before:

language
   ↓
"Java"


After:

language
   ↓
"Python"
```

So:

> **The String value/object itself is immutable, but a String reference variable can be reassigned.**

This distinction is **very important**.

---

## 3. Simple Example

```java
class StringDemo {

    public static void main(String[] args) {

        String name = "Basha";

        name = "Mahaboob";

        System.out.println(name);
    }
}
```

### Output

```text
Mahaboob
```

Did `"Basha"` change into `"Mahaboob"`?

**No.**

The variable `name` was reassigned.

Think:

```text
name → "Basha"

        ↓ reassignment

name → "Mahaboob"
```

The original String `"Basha"` was not modified.

---

# 4. String Class

`String` is a **class in Java**.

That means String provides functionality for working with text.

For example:

```java
String name = "Basha";
```

Here:

* `String` → class/type
* `name` → reference variable
* `"Basha"` → String value/object

You can use String methods to work with text.

For example:

```java
String name = "Basha";

System.out.println(name.toUpperCase());
```

Output:

```text
BASHA
```

The `toUpperCase()` operation does **not** modify the original String.

It produces another String result.

---

# 5. Very Important Example

Look carefully:

```java
class ImmutableString {

    public static void main(String[] args) {

        String s = "Java";

        s.concat(" Programming");

        System.out.println(s);
    }
}
```

### Output

```text
Java
```

Why didn't we get:

```text
Java Programming
```

?

Because:

```java
s.concat(" Programming");
```

doesn't modify the existing String `"Java"`.

It produces a new String.

If we want to keep that result:

```java
s = s.concat(" Programming");
```

Now:

```java
class ImmutableString {

    public static void main(String[] args) {

        String s = "Java";

        s = s.concat(" Programming");

        System.out.println(s);
    }
}
```

### Output

```text
Java Programming
```

---

# 🧠 Remember It Like This

Imagine:

### String = 🪨 Stone

```text
"Java"
```

You cannot modify the existing String.

But your variable can point somewhere else:

```text
s → "Java"

s = "Python"

s → "Python"
```

Therefore:

> **String is immutable, but the reference variable can be reassigned.**

---

## ⭐ The two points you gave me

### String values cannot be changed after initialization

Once a String object has been created, its contents cannot be modified.

### String class

`String` is a Java class used to represent and manipulate text.

---

## 🎯 Interview Answer

**Q: What is an immutable String in Java?**

> A String is immutable because once a String object is created, its contents cannot be changed. String is a Java class used to represent text. Operations that appear to modify a String actually produce a new String rather than changing the existing one.

### 🧠 One-line memory trick

> **String = Text + Class + Immutable**
