# 🧒 Java — Sum of Two Integers

This program teaches a very simple idea:

> **Store two numbers → Add them → Store the answer → Print the answer.**

---

# 1. Variables 📦

A **variable** is like a box that stores a value.

Suppose we have two numbers:

```java
int a = 10;
int b = 20;
```

Think of them as:

```text
┌─────────┐      ┌─────────┐
│    a    │      │    b    │
│   10    │      │   20    │
└─────────┘      └─────────┘
```

Here:

* `int` → stores whole numbers
* `a` → variable containing `10`
* `b` → variable containing `20`

---

# 2. Addition ➕

Now we add the two variables:

```java
a + b
```

Java calculates:

```text
10 + 20 = 30
```

---

# 3. Result Storage 📦

We can store the answer in another variable:

```java
int result = a + b;
```

Now we have:

```text
┌─────────┐
│    a    │ → 10
└─────────┘

┌─────────┐
│    b    │ → 20
└─────────┘

┌─────────┐
│ result  │ → 30
└─────────┘
```

So:

> **`result` stores the answer obtained from adding `a` and `b`.**

---

# 4. Printing the Result 🖨️

Use:

```java
System.out.println(result);
```

Output:

```text
30
```

---

# 5. Complete Program

```java
class Sum {
    public static void main(String[] args) {

        int a = 10;
        int b = 20;

        int result = a + b;

        System.out.println(result);
    }
}
```

Output:

```text
30
```

---

# 6. Printing a Meaningful Result

Instead of printing only `30`, we can make the output clearer:

```java
System.out.println("Sum = " + result);
```

Output:

```text
Sum = 30
```

Here:

```text
"Sum = " + result
       ↓
"Sum = " + 30
       ↓
"Sum = 30"
```

This is **String concatenation**.

---

# 🔄 Complete Flow

```text
        a = 10
           │
           │
           ├──────┐
           ↓      │
        Addition  │
           ↑      │
           │      │
        b = 20    │
           │      │
           └──────┘
              ↓
        result = 30
              ↓
        System.out.println()
              ↓
             30
```

---

# 🧠 ELI5 Analogy

Imagine two boxes:

```text
Box A → 10 apples
Box B → 20 apples
```

You combine them:

```text
10 + 20 = 30
```

Then put the answer in another box:

```text
Result Box → 30
```

Finally, you show the number:

```text
30
```

That's exactly what the Java program does.

---

# 🎯 Remember

```text
Variables
   ↓
a = 10, b = 20
   ↓
Addition
   ↓
a + b
   ↓
Result Storage
   ↓
result = 30
   ↓
Printing
   ↓
30
```

### ⭐ Interview answer

> **"We declare two integer variables, add their values using the `+` operator, store the result in another integer variable, and print the result using `System.out.println()`."**
