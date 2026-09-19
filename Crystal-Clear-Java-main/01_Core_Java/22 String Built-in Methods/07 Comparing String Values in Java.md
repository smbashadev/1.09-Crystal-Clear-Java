# 🧒 Comparing String Values in Java

When we have two Strings, sometimes we want to know:

> **“Do these two Strings contain the same value?”**

For example:

```java
String s1 = "Java";
String s2 = "Java";
```

We want to check whether:

```text
Java = Java
```

Java provides two important methods:

1. `equals()`
2. `equalsIgnoreCase()`

Both return a **boolean** value:

```text
true
```

or

```text
false
```

---

# 1. `equals()`

## 🧠 What does `equals()` do?

`equals()` compares the **values/content** of two Strings.

### Syntax

```java
string1.equals(string2)
```

Example:

```java
String s1 = "Java";
String s2 = "Java";

System.out.println(s1.equals(s2));
```

Output:

```text
true
```

Because both contain:

```text
Java
```

---

# 2. `equals()` Is Case-Sensitive

**Case-sensitive** means Java treats uppercase and lowercase letters as different.

For example:

```text
Java
java
JAVA
JaVa
```

These are different String values when using `equals()`.

Example:

```java
String s1 = "Java";
String s2 = "java";

System.out.println(s1.equals(s2));
```

Output:

```text
false
```

Why?

```text
Java
↑
J is uppercase
```

and:

```text
java
↑
j is lowercase
```

Java considers them different.

---

# 3. More `equals()` Examples

```java
System.out.println("Java".equals("Java"));
```

Output:

```text
true
```

---

```java
System.out.println("Java".equals("java"));
```

Output:

```text
false
```

---

```java
System.out.println("JAVA".equals("Java"));
```

Output:

```text
false
```

---

```java
System.out.println("Hello".equals("Hello"));
```

Output:

```text
true
```

---

# 4. `equalsIgnoreCase()`

Sometimes we don't care about uppercase or lowercase.

For example, we want:

```text
Java
JAVA
java
JaVa
```

to be considered the **same**.

That's when we use:

```java
equalsIgnoreCase()
```

### Syntax

```java
string1.equalsIgnoreCase(string2)
```

Example:

```java
String s1 = "Java";
String s2 = "java";

System.out.println(s1.equalsIgnoreCase(s2));
```

Output:

```text
true
```

Java ignores the difference between:

```text
J
```

and:

```text
j
```

---

# 5. Case-Insensitive Comparison

**Case-insensitive** means:

> Uppercase and lowercase differences are ignored while comparing.

For example:

```java
System.out.println("JAVA".equalsIgnoreCase("java"));
```

Output:

```text
true
```

And:

```java
System.out.println("JaVa".equalsIgnoreCase("JAVA"));
```

Output:

```text
true
```

All of these are considered equal:

```text
Java
JAVA
java
JaVa
jAvA
```

---

# 6. Complete Program

```java
class StringComparison {

    public static void main(String[] args) {

        String s1 = "Java";
        String s2 = "Java";
        String s3 = "java";

        System.out.println(s1.equals(s2));

        System.out.println(s1.equals(s3));

        System.out.println(s1.equalsIgnoreCase(s3));
    }
}
```

### Output

```text
true
false
true
```

### Why?

First:

```java
s1.equals(s2)
```

means:

```text
"Java" == "Java"
```

Same value:

```text
true
```

Second:

```java
s1.equals(s3)
```

means:

```text
"Java" == "java"
```

Different case:

```text
false
```

Third:

```java
s1.equalsIgnoreCase(s3)
```

means:

```text
"Java" == "java"
```

but case differences are ignored:

```text
true
```

---

# 7. Boolean Return Type

Both methods return a:

```java
boolean
```

A `boolean` can contain only two values:

```text
true
false
```

For example:

```java
boolean result = "Java".equals("Java");
```

Now:

```text
result
  ↓
true
```

Another example:

```java
boolean result = "Java".equals("Python");
```

Now:

```text
result
  ↓
false
```

---

# 8. Using `if`

Because `equals()` returns a boolean, we can directly use it in an `if` statement.

```java
class StringComparison {

    public static void main(String[] args) {

        String username = "Basha";

        if (username.equals("Basha")) {
            System.out.println("Name matched");
        } else {
            System.out.println("Name did not match");
        }
    }
}
```

### Output

```text
Name matched
```

---

# 9. `equalsIgnoreCase()` With `if`

```java
class StringComparison {

    public static void main(String[] args) {

        String language = "JAVA";

        if (language.equalsIgnoreCase("java")) {
            System.out.println("Java selected");
        } else {
            System.out.println("Different language");
        }
    }
}
```

Output:

```text
Java selected
```

Even though:

```text
JAVA
```

and:

```text
java
```

have different cases, `equalsIgnoreCase()` treats them as equal.

---

# 🆚 10. `equals()` vs `equalsIgnoreCase()`

| Method               | Comparison    | Case-sensitive? | Example                           | Result  |
| -------------------- | ------------- | --------------- | --------------------------------- | ------- |
| `equals()`           | String values | Yes             | `"Java".equals("Java")`           | `true`  |
| `equals()`           | String values | Yes             | `"Java".equals("java")`           | `false` |
| `equalsIgnoreCase()` | String values | No              | `"Java".equalsIgnoreCase("java")` | `true`  |
| `equalsIgnoreCase()` | String values | No              | `"JAVA".equalsIgnoreCase("java")` | `true`  |

---

# 🧠 Real-Life Example

Imagine a teacher asks:

> "Is your answer **YES**?"

If we use `equals()`:

```text
YES
yes
Yes
```

Java treats them as different because the capitalization is different.

But with:

```java
equalsIgnoreCase()
```

Java says:

> "I don't care about uppercase or lowercase. I only care about the letters."

So:

```text
YES
yes
Yes
yEs
```

are all accepted as the same value.

---

# ⚠️ `==` vs `equals()`

This is a very important String concept.

For Strings:

```java
==
```

and:

```java
.equals()
```

do different jobs.

### `==`

Checks whether two references refer to the **same object**.

### `equals()`

Checks whether two Strings contain the **same value**.

Example:

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1 == s2);
System.out.println(s1.equals(s2));
```

Output:

```text
false
true
```

Why?

```text
s1 → Object 1 → "Java"

s2 → Object 2 → "Java"
```

Different objects:

```text
s1 == s2
   ↓
false
```

Same String value:

```text
s1.equals(s2)
      ↓
    true
```

---

# 🎯 Remember Forever

```text
equals()
    ↓
Compare String values
    ↓
Case-sensitive
    ↓
Returns boolean
    ↓
true / false
```

```text
equalsIgnoreCase()
    ↓
Compare String values
    ↓
Case-insensitive
    ↓
Returns boolean
    ↓
true / false
```

### ⭐ Golden Memory Trick

> **`equals()` cares about case. `equalsIgnoreCase()` doesn't care about case.**

```text
"Java".equals("Java")
       ↓
     true

"Java".equals("java")
       ↓
     false

"Java".equalsIgnoreCase("java")
       ↓
     true
```

And remember:

> **For comparing String values, use `.equals()` or `.equalsIgnoreCase()` — not `==`.**
