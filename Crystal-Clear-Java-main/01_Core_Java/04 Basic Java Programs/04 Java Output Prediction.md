# 🧒 Java Output Prediction

This topic teaches you how to **look at a Java program and predict what it will print** without running it.

The biggest thing to understand here is:

> **The `+` operator can mean either addition or String concatenation.**

And **parentheses can change what gets calculated first**.

---

# 1. Result1, Result2, Result3

Let's take a simple program:

```java
int n1 = 10;
int n2 = 20;

int result1 = n1 + n2;
String result2 = "Sum = " + n1 + n2;
String result3 = "Sum = " + (n1 + n2);

System.out.println(result1);
System.out.println(result2);
System.out.println(result3);
```

Let's predict the output step by step.

---

# 2. `result1` — Arithmetic Addition ➕

```java
int result1 = n1 + n2;
```

We have:

```text
n1 = 10
n2 = 20
```

Both are integers.

Therefore:

```text
10 + 20
   ↓
30
```

So:

```text
result1 = 30
```

Output:

```text
30
```

---

# 3. `result2` — String Concatenation 🔗

Now look carefully:

```java
String result2 = "Sum = " + n1 + n2;
```

At first:

```text
"Sum = " + n1
```

There is already a **String** on the left.

Therefore `+` performs **String concatenation**.

```text
"Sum = " + 10
      ↓
"Sum = 10"
```

Then:

```text
"Sum = 10" + 20
```

Again, because a String is involved:

```text
"Sum = 1020"
```

Therefore:

```text
result2 = "Sum = 1020"
```

### Output:

```text
Sum = 1020
```

⚠️ **It does NOT produce `Sum = 30`.**

---

# 4. `result3` — Parentheses Change Everything

Now:

```java
String result3 = "Sum = " + (n1 + n2);
```

First Java evaluates what's inside the parentheses:

```text
(n1 + n2)
```

So:

```text
(10 + 20)
     ↓
   30
```

Then:

```text
"Sum = " + 30
```

Now concatenation happens:

```text
"Sum = 30"
```

Therefore:

```text
result3 = "Sum = 30"
```

Output:

```text
Sum = 30
```

---

# 5. The Big Difference

Compare these:

### Without parentheses

```java
"Sum = " + n1 + n2
```

Result:

```text
"Sum = 1020"
```

### With parentheses

```java
"Sum = " + (n1 + n2)
```

Result:

```text
"Sum = 30"
```

This is one of the most important things to understand.

---

# 6. Why Does This Happen?

Java evaluates expressions according to **operator precedence and associativity**.

The `+` operator is evaluated **left to right** when the operators have the same precedence.

Look at:

```java
"Sum = " + n1 + n2
```

Java effectively processes it like:

```text
("Sum = " + n1) + n2
```

With:

```text
n1 = 10
n2 = 20
```

we get:

```text
("Sum = " + 10) + 20
          ↓
     "Sum = 10" + 20
          ↓
      "Sum = 1020"
```

---

# 7. Understanding `n1 + n2`

Suppose:

```java
int n1 = 10;
int n2 = 20;
```

Then:

```java
n1 + n2
```

means:

```text
10 + 20
   ↓
  30
```

Because both operands are integers.

So:

```java
System.out.println(n1 + n2);
```

Output:

```text
30
```

---

# 8. Understanding `(n1 + n2)`

Now:

```java
(n1 + n2)
```

The parentheses explicitly say:

> **Calculate this part first.**

So:

```text
(n1 + n2)
     ↓
(10 + 20)
     ↓
30
```

The parentheses don't change the mathematical answer here.

```text
n1 + n2     → 30
(n1 + n2)   → 30
```

But parentheses become **very important when combined with a String**.

---

# 9. `n1 + n2` vs `(n1 + n2)`

Consider:

```java
System.out.println("Result = " + n1 + n2);
```

Output:

```text
Result = 1020
```

But:

```java
System.out.println("Result = " + (n1 + n2));
```

Output:

```text
Result = 30
```

### Why?

Without parentheses:

```text
"Result = " + 10 + 20
       ↓
"Result = 10" + 20
       ↓
"Result = 1020"
```

With parentheses:

```text
"Result = " + (10 + 20)
       ↓
"Result = " + 30
       ↓
"Result = 30"
```

---

# 10. Very Important Rule ⭐

Remember this rule:

> **If one side of `+` is a String, `+` performs String concatenation for that operation.**

Example:

```java
System.out.println("Hello " + 10);
```

Output:

```text
Hello 10
```

And:

```java
System.out.println("Hello " + 10 + 20);
```

Output:

```text
Hello 1020
```

But:

```java
System.out.println("Hello " + (10 + 20));
```

Output:

```text
Hello 30
```

---

# 11. Another Example

Suppose:

```java
int n1 = 5;
int n2 = 3;
```

### Example 1

```java
System.out.println(n1 + n2);
```

Output:

```text
8
```

### Example 2

```java
System.out.println("" + n1 + n2);
```

Output:

```text
53
```

Why?

```text
"" + 5
 ↓
"5"

"5" + 3
 ↓
"53"
```

### Example 3

```java
System.out.println("" + (n1 + n2));
```

Output:

```text
8
```

Because:

```text
(n1 + n2)
    ↓
5 + 3
    ↓
8

"" + 8
 ↓
"8"
```

---

# 12. Output Prediction Trick 🧠

When you see `+`, **don't immediately assume addition**.

Ask:

### Step 1

> **Is there a String?**

If **no**:

```text
10 + 20
   ↓
30
```

It's arithmetic addition.

If **yes**:

```text
"10" + 20
   ↓
"1020"
```

It's concatenation.

### Step 2

> **Are there parentheses?**

If you see:

```java
(n1 + n2)
```

calculate that part first.

---

# 🎯 Complete Prediction Program

```java
class Prediction {
    public static void main(String[] args) {

        int n1 = 10;
        int n2 = 20;

        String result1 = "" + n1 + n2;
        String result2 = "" + (n1 + n2);
        int result3 = n1 + n2;

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }
}
```

Let's predict:

### `result1`

```text
"" + 10 + 20
   ↓
"10" + 20
   ↓
"1020"
```

### `result2`

```text
"" + (10 + 20)
      ↓
      30
   ↓
"30"
```

### `result3`

```text
10 + 20
   ↓
30
```

### Final output

```text
1020
30
30
```

---

# 🔥 Golden Rule for Output Prediction

Whenever you see `+`, remember:

```text
                    +
                   / \
                  /   \
             Numbers  String
                ↓       ↓
            Addition  Concatenation
```

And:

```text
n1 + n2
   ↓
Addition

(n1 + n2)
   ↓
Calculate first

"Text" + n1 + n2
   ↓
Left-to-right concatenation

"Text" + (n1 + n2)
   ↓
Calculate n1 + n2 first
   ↓
Then concatenate
```

### ⭐ One sentence to memorize

> **`n1 + n2` performs arithmetic addition when both are numeric, while `"text" + n1 + n2` performs left-to-right String concatenation; `(n1 + n2)` forces the numeric addition to happen first.**
