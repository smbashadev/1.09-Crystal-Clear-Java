# 🧒 `float` in Java

### 🔹 What is `float`?

`float` is a **primitive floating-point data type** used to store **decimal/fractional numbers**.

For example:

```text
10.5
25.75
99.99
```

Think of `float` as a **box that can store decimal numbers** 📦.

---

## 1️⃣ 32-bit

`float` uses:

```text
32 bits = 4 bytes
```

So:

```text
float → 32 bits → 4 bytes
```

It uses less memory than `double`:

```text
float  → 4 bytes
double → 8 bytes
```

---

# 2️⃣ Range

The approximate range of a Java `float` is:

```text
±1.4 × 10⁻⁴⁵
to
±3.4 × 10³⁸
```

That looks complicated 😵, so for beginner learning, remember:

> **`float` can represent very small and very large floating-point numbers, but with limited precision.**

The range is about **magnitude**, while precision tells us **how accurately digits are represented**.

---

# 3️⃣ Single Precision

`float` is called a **single-precision floating-point type**.

```text
float → Single Precision
double → Double Precision
```

This means `float` generally provides about **6–7 decimal digits of precision**.

Example:

```java
float value = 123.4567f;
```

It can represent this approximately, but it does not provide as much precision as `double`.

---

# 4️⃣ Fractional Values

A **fractional value** is a number that can contain a decimal/fractional part.

Examples:

```text
10.5
25.75
99.99
3.14
```

You can store such values using `float`:

```java
float marks = 85.5f;
float price = 99.99f;
```

---

# 5️⃣ Dollars and Cents Example 💵

Suppose something costs:

```text
$25.50
```

You could represent it as:

```java
float price = 25.50f;
```

Here:

```text
25 → dollars
.50 → cents
```

### ⚠️ Important real-world note

For actual **money calculations**, `float` is generally **not recommended** because binary floating-point numbers can have rounding errors.

For financial applications, Java commonly uses:

```java
BigDecimal
```

But for learning the `float` data type, a price example is perfectly fine.

---

# 6️⃣ `float` Keyword

`float` is the **keyword** used to declare a floating-point variable.

### Syntax

```java
float variableName = value;
```

Example:

```java
float price = 25.50f;
```

Here:

```text
float → Data type
price → Variable
25.50f → Value
```

---

# 7️⃣ `f` / `F` Suffix

This is very important.

A decimal number such as:

```java
25.50
```

is treated as a **`double` literal by default**.

Therefore, when assigning it to a `float`, use `f` or `F`:

```java
float price = 25.50f;
```

or:

```java
float price = 25.50F;
```

Both are valid.

### ❌ Without `f`

```java
float price = 25.50;   // Compile-time error
```

### ✅ With `f`

```java
float price = 25.50f;
```

Think:

> **`f` tells Java: "This decimal value is a float."**

---

# 8️⃣ Integer Value Assigned to `float`

This is an interesting point.

You **can assign an integer value to a `float`**:

```java
float number = 10;
```

This is allowed.

Java converts the integer value to a floating-point value.

Conceptually:

```text
10 (int)
 ↓
10.0 (float)
```

Example:

```java
float number = 10;

System.out.println(number);
```

Output:

```text
10.0
```

### Why is this allowed?

Because an integer like `10` can be represented exactly as a `float`.

---

# 9️⃣ Floating Value Assigned to `float`

A floating-point value can also be assigned to `float`, **but normally you need `f`/`F`**.

```java
float number = 10.5f;
```

### ✅ Correct

```java
float price = 99.99f;
```

### ❌ Incorrect

```java
float price = 99.99;
```

because `99.99` is a `double` literal by default.

---

# 🧪 Complete Example

```java
class Demo {
    public static void main(String[] args) {

        float price = 25.50f;
        float marks = 85.5f;
        float number = 10;

        System.out.println(price);
        System.out.println(marks);
        System.out.println(number);
    }
}
```

### Output

```text
25.5
85.5
10.0
```

---

# 📊 Important Cases

| Code               | Valid? | Why?                                              |
| ------------------ | ------ | ------------------------------------------------- |
| `float a = 10;`    | ✅      | Integer can be converted to float                 |
| `float a = 10.5f;` | ✅      | `f` makes it a float literal                      |
| `float a = 10.5F;` | ✅      | `F` also makes it a float literal                 |
| `float a = 10.5;`  | ❌      | Decimal literal is `double` by default            |
| `float a = 10.5d;` | ❌      | `double` cannot be implicitly narrowed to `float` |

---

# 🧠 Easy Comparison

```text
byte   → 8 bits
short  → 16 bits
int    → 32 bits
long   → 64 bits

float  → 32 bits → decimal → single precision
double → 64 bits → decimal → double precision
```

### 🎯 Interview Answer

> **`float` is a 32-bit, single-precision floating-point primitive data type in Java used to represent fractional values. A floating-point literal assigned to a `float` normally requires the `f` or `F` suffix, while an integer literal can be assigned to a `float` directly if it can be represented.**

### 🧠 Easy Memory Trick

> **float = 32 bits + fractional values + single precision + `f/F` suffix**

```text
10       → float a = 10;       ✅
10.5f    → float a = 10.5f;    ✅
10.5     → float a = 10.5;     ❌
                    ↓
              double by default
```
