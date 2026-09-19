# 🧒 Types of Type Casting in Java

There are **two common types of type casting/conversion** you need to know:

```text
1️⃣ Implicit Type Casting
2️⃣ Explicit Type Casting
```

The easiest way to remember them is:

> **Implicit = Java does it automatically 🤖**
> **Explicit = Programmer tells Java to do it 🧑‍💻**

---

# 1️⃣ Implicit Type Casting

### 🔹 What is it?

**Implicit type casting happens automatically when Java converts a value from a smaller compatible numeric type to a larger compatible type.**

You don't write the cast yourself.

### Example

```java
int number = 100;

double value = number;
```

Java automatically converts:

```text
int
100
 ↓
Java automatically converts
 ↓
double
100.0
```

You don't need:

```java
(double) number
```

---

## 🧒 Real-Life Example

Imagine you have:

```text
🥤 Small glass → 🪣 Big bucket
```

The bucket is large enough to hold everything from the glass.

Similarly:

```text
int → double
```

The larger type can represent the integer value.

---

## 🔄 Common Widening Conversions

```text
byte → short → int → long → float → double
```

For example:

```java
byte b = 10;
int i = b;
double d = i;
```

Java can perform these conversions automatically.

### 🎯 Example

```java
class Demo {
    public static void main(String[] args) {

        int number = 25;
        double value = number;

        System.out.println(number);
        System.out.println(value);
    }
}
```

Output:

```text
25
25.0
```

---

# 2️⃣ Explicit Type Casting

### 🔹 What is it?

**Explicit type casting means the programmer manually tells Java to convert a value to another type.**

You use the **cast operator**:

```text
(targetType)
```

### Example

```java
double price = 99.99;

int value = (int) price;
```

Here:

```text
double
99.99
 ↓
(int)
 ↓
int
99
```

The decimal part is discarded.

---

## 🧒 Real-Life Example

Imagine you have a:

```text
🪣 Big bucket
```

and want to put its contents into:

```text
🥤 Small glass
```

You need to consciously tell Java:

> "I know the smaller container may not hold everything; convert it anyway."

That's explicit casting.

---

# 🔥 Why Is Explicit Casting Needed?

Because the conversion may cause **data loss**.

Example:

```java
double number = 10.75;

int result = (int) number;
```

Output:

```text
10
```

The `.75` is lost.

```text
10.75
 ↓
(int)
 ↓
10
```

So Java doesn't normally do this automatically.

---

# 📊 Implicit vs Explicit

| Feature                  | Implicit               | Explicit                        |
| ------------------------ | ---------------------- | ------------------------------- |
| Who performs conversion? | **Java automatically** | **Programmer**                  |
| Also called              | Widening conversion    | Narrowing conversion (commonly) |
| Cast syntax required?    | ❌ Usually no           | ✅ Yes                           |
| Risk of data loss        | Generally lower        | **Possible**                    |
| Example                  | `int → double`         | `double → int`                  |

---

# 🧠 Super Simple Example

### Implicit

```java
int a = 10;
double b = a;
```

Think:

```text
10
 ↓
Java automatically
 ↓
10.0
```

### Explicit

```java
double a = 10.5;
int b = (int) a;
```

Think:

```text
10.5
 ↓
Programmer says "(int)"
 ↓
10
```

---

# ⚠️ Important Technical Point

Don't memorize that **every** implicit conversion follows the simple "small → big" rule.

Java has specific conversion rules, and some conversions can lose information even when they are widening—for example, `long` to `float` can lose precision.

For your basic notes, the main pattern is:

```text
Widening → usually automatic
Narrowing → usually explicit
```

---

# 🔄 Complete Picture

```text
             Type Casting
                  │
          ┌───────┴────────┐
          ↓                ↓
      Implicit          Explicit
       🤖                  🧑‍💻
     Automatic            Manual
          ↓                ↓
      Widening           Narrowing
          ↓                ↓
    int → double      double → int
```

### 🎯 Interview Answer

> **Implicit type casting is the automatic conversion of a compatible value by Java, commonly from a narrower numeric type to a wider type. Explicit type casting is when the programmer manually specifies the target type using the cast operator, commonly for narrowing conversions.**

### 🧠 Easy Memory Trick

> **Implicit = I didn't write the cast → Java does it.**
> **Explicit = I explicitly wrote the cast → Programmer does it.**

```text
Implicit → Automatic 🤖
Explicit → Manual 🧑‍💻
```
