# 🧒 `compareTo()` in Java

`compareTo()` is a String method used to **compare two Strings character by character**.

But unlike `equals()`, it doesn't simply say:

```text
true / false
```

Instead, it returns an **integer (`int`) value**:

* **`0`** → both Strings are equal
* **Positive value** → first String is greater
* **Negative value** → first String is smaller

---

# 1. What does `compareTo()` do?

Suppose we have:

```java
String s1 = "Java";
String s2 = "Java";
```

We can write:

```java
System.out.println(s1.compareTo(s2));
```

Output:

```text
0
```

Why?

Because both Strings contain exactly the same characters.

```text
Java
Java
```

So:

```text
compareTo() → 0
```

---

# 2. Character-by-Character Comparison

`compareTo()` compares Strings from **left to right**.

For example:

```text
Java
Jawa
```

Java compares:

```text
J → J
```

They are equal.

Then:

```text
a → a
```

Equal.

Then:

```text
v → w
```

Different!

Java stops at the **first different character**.

So we only need to understand:

```text
v
w
```

---

# 3. Unicode Values

Characters have numeric **Unicode values**.

For example:

```text
'A' → 65
'B' → 66
'C' → 67
```

and:

```text
'a' → 97
'b' → 98
'c' → 99
```

So:

```text
'A' < 'B'
```

because:

```text
65 < 66
```

Similarly:

```text
'a' < 'b'
```

because:

```text
97 < 98
```

`compareTo()` uses these character values to determine the ordering.

---

# 4. Positive Value

Suppose:

```java
String s1 = "B";
String s2 = "A";

System.out.println(s1.compareTo(s2));
```

Unicode values:

```text
B → 66
A → 65
```

Therefore:

```text
66 - 65 = 1
```

Result:

```text
1
```

So the result is **positive**.

```text
"B".compareTo("A")
        ↓
     positive
```

### 🧠 Meaning

> The first String comes **after/greater than** the second String in lexicographical ordering.

---

# 5. Negative Value

Now reverse them:

```java
String s1 = "A";
String s2 = "B";

System.out.println(s1.compareTo(s2));
```

Unicode values:

```text
A → 65
B → 66
```

Therefore:

```text
65 - 66 = -1
```

Result:

```text
-1
```

So the result is **negative**.

```text
"A".compareTo("B")
        ↓
     negative
```

### 🧠 Meaning

> The first String comes **before/smaller than** the second String.

---

# 6. Zero

If both Strings are equal:

```java
String s1 = "Java";
String s2 = "Java";

System.out.println(s1.compareTo(s2));
```

Output:

```text
0
```

Meaning:

> Both Strings are equal in lexicographical comparison.

---

# 7. Important Point About Positive and Negative Values

Do **not** memorize that `compareTo()` must return exactly:

```text
+1
```

or:

```text
-1
```

The important thing is the **sign**:

```text
Positive → greater
Negative → smaller
Zero     → equal
```

For example:

```text
5
10
100
```

could all be positive results depending on the Strings being compared.

So in programs, we normally write:

```java
if (result > 0)
```

rather than:

```java
if (result == 1)
```

---

# 8. Example — `"Apple"` vs `"Banana"`

```java
String s1 = "Apple";
String s2 = "Banana";

System.out.println(s1.compareTo(s2));
```

First characters:

```text
A
B
```

Unicode:

```text
A → 65
B → 66
```

Therefore the result is negative.

```text
"Apple".compareTo("Banana")
              ↓
           negative
```

---

# 9. Example — `"Banana"` vs `"Apple"`

```java
System.out.println("Banana".compareTo("Apple"));
```

First characters:

```text
B
A
```

Since:

```text
B > A
```

the result is positive.

```text
"Banana".compareTo("Apple")
              ↓
           positive
```

---

# 10. Example — Same First Characters

Consider:

```text
Java
Jaxb
```

Compare from left to right:

```text
J → J  ✅
a → a  ✅
v → x  ❌
```

The comparison stops at:

```text
v vs x
```

Unicode:

```text
v → 118
x → 120
```

Therefore:

```text
118 - 120 = -2
```

So the result is negative.

```text
"Java".compareTo("Jaxb")
          ↓
       negative
```

---

# 11. Example — One String Is a Prefix

Consider:

```text
Java
Java Programming
```

The characters of `"Java"` match the beginning of `"Java Programming"`.

```text
Java
Java Programming
```

After matching `"Java"`, the first String ends.

Therefore the shorter String is considered smaller.

```java
System.out.println("Java".compareTo("Java Programming"));
```

The result is negative.

---

# 12. Complete Program

```java
class CompareToDemo {

    public static void main(String[] args) {

        String s1 = "Apple";
        String s2 = "Banana";
        String s3 = "Apple";

        int result1 = s1.compareTo(s2);
        int result2 = s2.compareTo(s1);
        int result3 = s1.compareTo(s3);

        System.out.println("Apple vs Banana: " + result1);
        System.out.println("Banana vs Apple: " + result2);
        System.out.println("Apple vs Apple: " + result3);
    }
}
```

The exact positive/negative numbers depend on the first differing characters, but the signs will be:

```text
Apple vs Banana → negative
Banana vs Apple → positive
Apple vs Apple → 0
```

---

# 13. Using `if-else`

This is a very common way to use `compareTo()`.

```java
class CompareToDemo {

    public static void main(String[] args) {

        String s1 = "Apple";
        String s2 = "Banana";

        int result = s1.compareTo(s2);

        if (result == 0) {
            System.out.println("Both Strings are equal");
        }
        else if (result < 0) {
            System.out.println("First String is smaller");
        }
        else {
            System.out.println("First String is greater");
        }
    }
}
```

Output:

```text
First String is smaller
```

---

# 14. `compareTo()` vs `equals()`

This is important for interviews.

| Method        | What it does                           | Return type |
| ------------- | -------------------------------------- | ----------- |
| `equals()`    | Checks whether String values are equal | `boolean`   |
| `compareTo()` | Compares String ordering               | `int`       |

Example:

```java
"Java".equals("Java")
```

Result:

```text
true
```

But:

```java
"Java".compareTo("Java")
```

Result:

```text
0
```

So:

```text
equals()
   ↓
true / false
```

while:

```text
compareTo()
   ↓
negative / zero / positive
```

---

# 🧠 15. Easy Real-Life Example

Imagine students standing in **alphabetical order**:

```text
Apple
Banana
Cat
Dog
```

If you compare:

```text
Apple vs Banana
```

Apple comes before Banana:

```text
negative
```

Compare:

```text
Banana vs Apple
```

Banana comes after Apple:

```text
positive
```

Compare:

```text
Apple vs Apple
```

Same:

```text
zero
```

That's the basic idea behind `compareTo()`.

---

# 🎯 Remember Forever

```text
String 1.compareTo(String 2)
```

Think:

```text
        Compare
           ↓
 Character by character
           ↓
      Unicode values
           ↓
   ┌───────┼────────┐
   ↓       ↓        ↓
Negative  Zero   Positive
   ↓       ↓        ↓
Smaller  Equal   Greater
```

### ⭐ Golden Rule

> **`compareTo()` compares Strings character by character and returns an `int`: negative if the first String is smaller, `0` if they are equal, and positive if the first String is greater.**

### 🧠 Super-short memory trick

```text
<  → Negative
=  → Zero
>  → Positive
```

And:

> **`equals()` asks “Are they equal?” → `true/false`**
> **`compareTo()` asks “Which one comes first?” → negative/0/positive**
