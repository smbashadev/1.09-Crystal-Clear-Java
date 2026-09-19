## 🧒 `float` `f/F` Suffix in Java

The main thing to remember is:

> **In Java, a decimal number like `3.14` is treated as a `double` by default.**

So Java sees:

```java
3.14
```

as:

```text
double
```

---

### 1️⃣ `3.14` → `double`

```java
double d = 3.14;
```

✅ Valid.

Because `3.14` is already a `double`.

Think:

```text
3.14
 ↓
Java says: "This is double."
 ↓
double d = 3.14; ✅
```

---

### 2️⃣ Why do we need `f`?

Suppose we write:

```java
float f = 3.14;
```

❌ **Compilation error**

Why?

Because:

```text
3.14 → double
```

but you're trying to put it into:

```text
float
```

That would be a **narrowing conversion**, so Java does not do it automatically.

You must tell Java:

> "I know this value should be a float."

Use `f` or `F`:

```java
float f1 = 3.14f;
float f2 = 3.14F;
```

✅ Both are valid.

---

### 3️⃣ What does `f` / `F` mean?

```java
3.14f
```

means:

> **Treat `3.14` as a `float` literal.**

Similarly:

```java
3.14F
```

also means:

> **Treat `3.14` as a `float` literal.**

`f` and `F` mean the same thing.

```text
3.14   → double
3.14f  → float
3.14F  → float
```

---

## 4️⃣ Explicit casting using `(float)`

You can also convert the default `double` to `float` manually:

```java
float f = (float) 3.14;
```

✅ Valid.

Here:

```text
3.14
 ↓
double
 ↓  (float)
float
```

The `(float)` is called the **cast operator**.

---

## 5️⃣ Complete program

```java
class FloatDemo {
    public static void main(String[] args) {

        double d = 3.14;

        float f1 = 3.14f;
        float f2 = 3.14F;
        float f3 = (float) 3.14;

        System.out.println("double = " + d);
        System.out.println("float  = " + f1);
        System.out.println("float  = " + f2);
        System.out.println("float  = " + f3);
    }
}
```

### Output

```text
double = 3.14
float  = 3.14
float  = 3.14
float  = 3.14
```

---

## 🧠 Easy comparison

| Code                      | What Java treats it as | Valid? |
| ------------------------- | ---------------------- | ------ |
| `double d = 3.14;`        | `double`               | ✅      |
| `float f = 3.14;`         | `double → float`       | ❌      |
| `float f = 3.14f;`        | `float`                | ✅      |
| `float f = 3.14F;`        | `float`                | ✅      |
| `float f = (float) 3.14;` | explicit conversion    | ✅      |

### 🔑 Memory Trick

```text
3.14
 ↓
DOUBLE by default

3.14f
 ↓
FLOAT

3.14F
 ↓
FLOAT

(float) 3.14
 ↓
FLOAT by explicit casting
```

**Interview answer:**

> In Java, floating-point literals are `double` by default. To assign a decimal literal directly to a `float`, we use the `f` or `F` suffix. Alternatively, we can explicitly cast the `double` value using `(float)`.
