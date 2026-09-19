## 🧒 Explicit Type Casting Program

**Explicit type casting** means:

> We **manually tell Java** to convert a value from one data type to another using `(targetType)`.

Here we are going:

```text
double → long → int
```

This is called **narrowing conversion**.

### 📦 Think of it like this

Imagine:

```text
Big box → Smaller box
```

A `double` can hold decimal values, but `long` cannot hold the fractional part.

So when we convert:

```text
double → long
```

the **fractional part is lost**.

---

### 💻 Program

```java
class ExplicitCasting {
    public static void main(String[] args) {

        double d = 123.45;

        long l = (long) d;   // double → long
        int i = (int) l;     // long → int

        System.out.println("double = " + d);
        System.out.println("long   = " + l);
        System.out.println("int    = " + i);
    }
}
```

### Output

```text
double = 123.45
long   = 123
int    = 123
```

### 🔍 Step-by-step

**1. Store a decimal value:**

```java
double d = 123.45;
```

Value:

```text
123.45
```

**2. Convert double → long:**

```java
long l = (long) d;
```

Java removes the fractional part:

```text
123.45
 ↓
 123
```

So:

```text
l = 123
```

**3. Convert long → int:**

```java
int i = (int) l;
```

`123` can fit inside `int`, so:

```text
123
 ↓
123
```

---

### ⚠️ Fractional Part Loss

For example:

```java
double d = 99.99;
long l = (long) d;
```

Result:

```text
99.99 → 99
```

It does **not round** to `100`.

Similarly:

```java
double d = 99.999;
long l = (long) d;
```

Result:

```text
99
```

For negative numbers:

```java
double d = -99.99;
long l = (long) d;
```

Result:

```text
-99
```

The fractional part is **discarded toward zero**.

---

### 🧠 Remember

```text
double → long → int
   ↓       ↓
 manual  manual
   ↓       ↓
 narrowing conversion
   ↓
fractional part can be lost
```

**Golden rule:**

> **Explicit = Programmer tells Java using `(type)` = Narrowing = Data loss may occur.**
