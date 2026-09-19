# 🧒 Strings in Java

## 21.1 String Basics

### 1. What is a String?

Imagine you want to store **text** in a Java program.

For example:

```text
Hello
Java
Basha
India
Welcome
```

All of these are **strings**.

A **String** is a sequence of characters.

For example:

```text
"Java"
```

contains four characters:

```text
J   a   v   a
```

So you can remember:

> 🧠 **String = group/sequence of characters used to represent text.**

---

# 2. What is a Character?

Before understanding String, understand **character**.

A character is a **single symbol**.

Examples:

```text
'A'
'B'
'7'
'@'
'#'
```

In Java, we normally represent a single character using the `char` data type:

```java
char ch = 'A';
```

Notice:

```java
'A'
```

uses **single quotes**.

---

# 3. Character Array Concept

Now imagine that instead of keeping one character, we want to keep many characters.

We can use a character array:

```java
char[] letters = {'J', 'a', 'v', 'a'};
```

Visually:

```text
Index:     0    1    2    3
           ↓    ↓    ↓    ↓
          'J'  'a'  'v'  'a'
```

Together these characters represent:

```text
Java
```

So we can think of a String as:

> **A sequence of characters.**

A character array and a String are **not exactly the same thing**, but the character-array idea is a very useful way for a beginner to understand what text contains.

---

# 4. String Examples

Here are some simple Strings:

```java
String name = "Basha";
String language = "Java";
String country = "India";
String message = "Hello World";
```

Each variable contains text.

### Example

```java
class StringExample {
    public static void main(String[] args) {

        String name = "Basha";
        String language = "Java";

        System.out.println(name);
        System.out.println(language);
    }
}
```

### Output

```text
Basha
Java
```

### What happened?

First:

```java
String name = "Basha";
```

Java creates a String value containing:

```text
Basha
```

and the variable `name` refers to that String.

Then:

```java
System.out.println(name);
```

prints the text.

---

# 5. String Uses Double Quotes

This is very important.

A String is normally written using **double quotes**:

```java
String name = "Basha";
```

A single character uses **single quotes**:

```java
char ch = 'B';
```

### Remember

| Value                    | Java representation |
| ------------------------ | ------------------- |
| One character            | `'A'`               |
| Multiple characters/text | `"ABC"`             |
| One word                 | `"Java"`            |
| Sentence                 | `"Java is easy"`    |

So:

```java
char ch = 'A';       // character
String s = "A";      // String
```

They are different.

---

# 6. String Is a Class

This is an important Java concept.

You may already know primitive types such as:

```java
int
double
char
boolean
```

But:

```java
String
```

is a **class** in Java.

That means String is an object-oriented type.

For example:

```java
String name = "Basha";
```

The value `"Basha"` is a String object/value, and `name` is a reference variable referring to it.

You don't need to memorize the internal details immediately.

For now remember:

> 🧠 **String is a Java class used to work with text.**

---

# 7. Why Do We Need Strings?

Imagine a student application.

We may need to store:

```text
Student name
College name
Address
Email
Course name
City
```

These are all text.

For example:

```java
String studentName = "Basha";
String college = "ABC College";
String city = "Hyderabad";
```

Without Strings, working with text would be extremely inconvenient.

So:

> **String is used whenever our program needs to work with text.**

---

# 8. Strings and Immutability

Now we reach one of the **most important String concepts**.

### What does immutable mean?

**Immutable means: cannot be changed after it is created.**

Think about writing your name on a stone:

```text
Basha
```

Once the name is carved into the stone, you don't directly change the existing stone into something else.

You create another representation instead.

A Java String behaves similarly.

---

# 9. Example of String Immutability

Consider:

```java
String s = "Java";
```

Initially:

```text
s
↓
"Java"
```

Now suppose we write:

```java
s = "Python";
```

A beginner may think:

> "The String `Java` changed into `Python`."

That is **not the correct mental model**.

The original String object/value `"Java"` is not modified.

Instead, `s` is made to refer to another String:

```text
Before:

s
↓
"Java"


After:

s
↓
"Python"
```

The original `"Java"` String remains unchanged.

So remember:

> 🧠 **String objects are immutable — their contents cannot be changed after creation.**

---

# 10. Very Important Example

```java
class ImmutableExample {
    public static void main(String[] args) {

        String s = "Java";

        s.concat(" Programming");

        System.out.println(s);
    }
}
```

What do you think the output is?

```text
Java
```

Why?

Because:

```java
s.concat(" Programming");
```

does not modify the existing String.

A new String can be produced, but we did not store that result anywhere.

---

# 11. Correct Way to Store the New String

```java
class ImmutableExample {
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

What happened?

Initially:

```text
s
↓
"Java"
```

The `concat()` operation produces another String:

```text
"Java Programming"
```

Then:

```java
s = ...
```

makes `s` refer to that new String.

Conceptually:

```text
Before:

s → "Java"


After:

s → "Java Programming"
```

The important point is:

> The original String was not modified.

---

# 12. Another Easy Example

```java
String name = "Basha";

name.toUpperCase();

System.out.println(name);
```

Output:

```text
Basha
```

Why?

Because `toUpperCase()` produces a String result; it does not change the original String.

To use the new result:

```java
String name = "Basha";

name = name.toUpperCase();

System.out.println(name);
```

Output:

```text
BASHA
```

---

# 13. Why Are Strings Immutable?

At beginner level, remember these important reasons:

### 1. Security

Strings are commonly used for sensitive textual information such as:

```text
URLs
file paths
class names
configuration information
```

Having immutable text makes it safer to reason about the value after it has been created.

### 2. String Pool

Java can reuse certain String objects through the **String pool**.

Immutability makes this sharing safe because one piece of code cannot simply modify a shared String's contents.

### 3. Thread safety

Because a String cannot be modified after creation, multiple threads can safely read the same String without one thread changing the String's contents.

For your first learning stage, remember:

> **Immutable Strings are easier and safer to share because their contents cannot be changed.**

---

# 14. Mutable Strings

Now compare that with **mutable strings**.

Mutable means:

> **The object can be changed after it is created.**

Java provides classes such as:

```java
StringBuilder
StringBuffer
```

for mutable text operations.

For example:

```java
StringBuilder sb = new StringBuilder("Java");

sb.append(" Programming");

System.out.println(sb);
```

Output:

```text
Java Programming
```

Here, the same `StringBuilder` object can be modified.

Conceptually:

```text
Before:

sb → "Java"


After append():

sb → "Java Programming"
```

The object itself can change.

---

# 15. String vs Mutable String

| Feature                                | String      | StringBuilder               |
| -------------------------------------- | ----------- | --------------------------- |
| Type                                   | Class       | Class                       |
| Stores text                            | Yes         | Yes                         |
| Mutable?                               | ❌ No        | ✅ Yes                       |
| Can change existing object's contents? | No          | Yes                         |
| Example                                | `"Java"`    | `new StringBuilder("Java")` |
| Common use                             | Normal text | Frequent text modifications |

---

# 16. Simple Real-World Analogy

Imagine two notebooks.

### 📕 String

You write:

```text
Java
```

The page is treated as **unchangeable**.

If you want:

```text
Java Programming
```

you create/use another page.

That's like an immutable String.

---

### 📗 StringBuilder

You write:

```text
Java
```

Then you add:

```text
 Programming
```

to the same editable page.

That's like a mutable StringBuilder.

---

# 17. Complete Comparison Program

```java
class StringMutabilityDemo {

    public static void main(String[] args) {

        String s = "Java";

        s.concat(" Programming");

        System.out.println("String: " + s);


        StringBuilder sb = new StringBuilder("Java");

        sb.append(" Programming");

        System.out.println("StringBuilder: " + sb);
    }
}
```

### Output

```text
String: Java
StringBuilder: Java Programming
```

### Why are the outputs different?

For String:

```java
s.concat(" Programming");
```

creates a new String, but we don't store it.

For StringBuilder:

```java
sb.append(" Programming");
```

changes the existing mutable object.

---

# 🧠 The Most Important Difference

Remember this picture:

```text
STRING
------

"Java"

       concat()
          ↓
"Java Programming"

New String
```

Whereas:

```text
STRINGBUILDER
-------------

"Java"

       append()
          ↓
"Java Programming"

Same mutable object is changed
```

---

# ⚠️ Common Beginner Mistakes

### Mistake 1: Using single quotes for a String

❌ Wrong:

```java
String name = 'Basha';
```

✅ Correct:

```java
String name = "Basha";
```

---

### Mistake 2: Thinking String methods modify the original String

❌ Wrong mental model:

```java
String s = "java";
s.toUpperCase();
```

and expecting `s` to become `"JAVA"`.

✅ Correct:

```java
s = s.toUpperCase();
```

---

### Mistake 3: Thinking `String` and `char[]` are identical

They are related because both can represent sequences of characters, but they are **different Java types**.

```java
String s = "Java";

char[] arr = {'J', 'a', 'v', 'a'};
```

They are not interchangeable simply because they contain similar characters.

---

# 🎯 Interview Questions

### Q1. What is a String?

A String is a sequence of characters used to represent text. In Java, `String` is a class.

### Q2. Is String mutable or immutable?

**String is immutable.**

### Q3. What does immutable mean?

It means that once a String object is created, its contents cannot be modified.

### Q4. Is `String` a primitive data type?

No.

`String` is a **class/reference type**.

### Q5. How do you represent a String?

Using double quotes:

```java
String s = "Java";
```

### Q6. How do you represent a single character?

Using `char` and single quotes:

```java
char c = 'J';
```

### Q7. What are mutable alternatives to String?

Commonly:

```java
StringBuilder
StringBuffer
```

---

# 🧠 Lifetime Memory Trick

Remember this story:

> **String = text.**
>
> **String = sequence of characters.**
>
> **String is immutable.**
>
> **StringBuilder/StringBuffer = mutable text.**

Or simply:

```text
String
  ↓
Text
  ↓
Characters
  ↓
Immutable
```

and:

```text
StringBuilder
  ↓
Text
  ↓
Mutable
```

## ⭐ One-line revision

> **A Java String represents text as a sequence of characters, and String objects are immutable; when you need to modify text repeatedly, mutable classes such as StringBuilder or StringBuffer are available.**
