# 🧒 Three Ways to Create Strings in Java

In Java, there are **three common ways** to create a String.

Think of a String as a **box containing text**.

For example:

```text
"Java"
```

We can create that String box in different ways.

---

# 🟢 Way 1 — Using `new String("Java")`

We can explicitly create a String object using the `new` keyword.

### Syntax

```java
String s = new String("Java");
```

Break it into small pieces:

```text
String
  ↓
data type / class

s
  ↓
reference variable

new
  ↓
creates a new object

String("Java")
  ↓
String constructor
```

So:

```java
String s = new String("Java");
```

means:

> **Create a new String object containing `"Java"` and make `s` refer to it.**

### Complete program

```java
class StringWay1 {
    public static void main(String[] args) {

        String s = new String("Java");

        System.out.println(s);
    }
}
```

### Output

```text
Java
```

### 🧠 Remember

```text
new String("Java")
        ↓
Creates a String object explicitly
```

---

# 🟡 Way 2 — Using a Character Array

Remember what we discussed earlier:

A String is a sequence of characters.

We can first create a `char` array:

```java
char[] letters = {'J', 'a', 'v', 'a'};
```

It looks like:

```text
Index:    0    1    2    3
          ↓    ↓    ↓    ↓
         'J'  'a'  'v'  'a'
```

Now Java provides a String constructor that can take this character array:

```java
new String(char[])
```

So:

```java
String s = new String(letters);
```

creates a String from those characters.

---

## Complete Program

```java
class StringWay2 {
    public static void main(String[] args) {

        char[] letters = {'J', 'a', 'v', 'a'};

        String s = new String(letters);

        System.out.println(s);
    }
}
```

### Output

```text
Java
```

### What happened?

First:

```java
char[] letters = {'J', 'a', 'v', 'a'};
```

We created:

```text
J a v a
```

Then:

```java
String s = new String(letters);
```

Java uses those characters to create the String:

```text
"Java"
```

So the flow is:

```text
Character Array
      ↓
{'J','a','v','a'}
      ↓
new String(char[])
      ↓
"Java"
```

### 🧠 Memory trick

> **char[] → String**

---

# 🔵 Way 3 — String Literal / Direct Assignment

This is the **simplest and most commonly used way**.

Simply assign text directly:

```java
String s = "Java";
```

This is called a **String literal**.

There is no need to write:

```java
new String()
```

You directly write:

```java
"Java"
```

and assign it to the reference variable.

---

## Complete Program

```java
class StringWay3 {
    public static void main(String[] args) {

        String s = "Java";

        System.out.println(s);
    }
}
```

### Output

```text
Java
```

So:

```java
String s = "Java";
```

means:

> **Create/use the String represented by the literal `"Java"` and make `s` refer to it.**

---

# 🧠 All Three Ways Together

```java
class ThreeStringWays {

    public static void main(String[] args) {

        // Way 1
        String s1 = new String("Java");

        // Way 2
        char[] letters = {'J', 'a', 'v', 'a'};
        String s2 = new String(letters);

        // Way 3
        String s3 = "Java";

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
```

### Output

```text
Java
Java
Java
```

All three produce the text:

```text
Java
```

But **the way Java creates/handles the String is different**.

---

# 📊 Three Ways — Simple Comparison

| Way       | How we write it      | Main idea                          |
| --------- | -------------------- | ---------------------------------- |
| **Way 1** | `new String("Java")` | Explicitly create a String object  |
| **Way 2** | `new String(char[])` | Create String from characters      |
| **Way 3** | `"Java"`             | String literal / direct assignment |

---

# ⭐ Way 1 vs Way 3 — Important Difference

Compare:

```java
String s1 = new String("Java");
```

and:

```java
String s2 = "Java";
```

Both contain:

```text
Java
```

But they are **not created in exactly the same way**.

### Way 1

```java
new String("Java")
```

uses the `new` keyword and explicitly creates a new String object.

### Way 3

```java
"Java"
```

is a **String literal**. Java can use the **String pool** to reuse an existing matching literal.

For example:

```java
String a = "Java";
String b = "Java";
```

Java can have both references point to the same pooled String:

```text
a ─────┐
       ↓
     "Java"
       ↑
       └───── b
```

This is one reason String literals are commonly preferred.

---

# ⚠️ Beginner Mistake

Don't confuse:

```java
String s = "Java";
```

with:

```java
char s = 'J';
```

The first stores a **String**:

```text
"Java"
```

The second stores a **single character**:

```text
'J'
```

Remember:

```text
'J'       → char
"Java"    → String
```

---

# 🧠 ELI5 Memory Story

Imagine you want to make a **Java word card**.

### 🟥 Way 1

You say:

> "Make me a brand-new card containing Java."

```java
new String("Java")
```

### 🟨 Way 2

You have individual letters:

```text
J → a → v → a
```

You tell Java:

> "Put these letters together into a String."

```java
new String(charArray)
```

### 🟦 Way 3

You simply hand Java the ready-made word:

```java
"Java"
```

That's a String literal.

---

# 🎯 Final Memory Formula

```text
THREE WAYS TO CREATE STRING
          ↓
────────────────────────────
1. new String("Java")
          ↓
Explicit object creation

2. new String(char[])
          ↓
Character array → String

3. "Java"
          ↓
String literal / direct assignment
```

### ⭐ Remember in one sentence:

> **A String can commonly be created using `new String("Java")`, from a character array using `new String(char[])`, or directly using a String literal such as `"Java"`.**
