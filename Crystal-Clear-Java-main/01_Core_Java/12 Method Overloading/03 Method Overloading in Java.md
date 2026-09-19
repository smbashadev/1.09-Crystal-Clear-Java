## 🧒 Method Overloading in Java

**Method overloading** means:

> **Having multiple methods with the same name in the same class, but with different parameter lists.**

It allows us to use **one meaningful method name for related tasks**.

---

# 1️⃣ Multiple Methods

We create more than one method:

```java id="u8m4q1"
static void add(int a, int b) {
    System.out.println(a + b);
}

static void add(int a, int b, int c) {
    System.out.println(a + b + c);
}
```

There are two `add()` methods.

```text id="n3k7xp"
add()
add()
```

---

# 2️⃣ Same Class

Both methods are inside the **same class**:

```java id="q5v9mz"
class Calculator {

    static void add(int a, int b) {
        System.out.println(a + b);
    }

    static void add(int a, int b, int c) {
        System.out.println(a + b + c);
    }
}
```

---

# 3️⃣ Same Method Name

Notice both methods are called:

```text id="c7p2ks"
add()
add()
```

We don't need:

```text id="f4x8qm"
addTwoNumbers()
addThreeNumbers()
```

We can simply use:

```text id="z6m3qa"
add()
```

---

# 4️⃣ Different Parameters

This is the **most important rule**.

The methods must have different **parameter lists**.

### Example 1

```java id="w3k8pv"
add(int a, int b)
```

Two parameters.

### Example 2

```java id="r7m2xz"
add(int a, int b, int c)
```

Three parameters.

Therefore Java can distinguish them.

```text id="d8q4ns"
add(int, int)
      ≠
add(int, int, int)
```

---

# 5️⃣ Calling the Methods

```java id="m5x9kc"
add(10, 20);
```

Java chooses:

```text id="y7p3qa"
add(int, int)
```

Result:

```text id="n2k6vz"
30
```

If we call:

```java id="c4w8rm"
add(10, 20, 30);
```

Java chooses:

```text id="p9x5ks"
add(int, int, int)
```

Result:

```text id="h3m7qa"
60
```

---

# 6️⃣ Improved Usability

Imagine you have many related operations.

### Without overloading:

```text id="q6v2mx"
addTwoNumbers()
addThreeNumbers()
addFourNumbers()
```

You have to remember different names.

### With overloading:

```text id="k8p4zs"
add()
add()
add()
```

You use the same meaningful name and provide the required number/type of inputs.

```text id="w7n3qa"
add(10, 20)
      ↓
2 parameters

add(10, 20, 30)
      ↓
3 parameters
```

This improves **usability and readability** for related operations.

---

# 💻 Complete Program

```java id="e4q8xm"
class Calculator {

    static void add(int a, int b) {
        System.out.println("Sum = " + (a + b));
    }

    static void add(int a, int b, int c) {
        System.out.println("Sum = " + (a + b + c));
    }

    public static void main(String[] args) {

        add(10, 20);

        add(10, 20, 30);
    }
}
```

Output:

```text id="z5k7pn"
Sum = 30
Sum = 60
```

---

## 🧠 Easy Memory Trick

```text id="a8m3qx"
METHOD OVERLOADING

Multiple methods
      ↓
Same class
      ↓
Same method name
      ↓
Different parameter list
      ↓
Related tasks
      ↓
Better usability/readability
```

### ⭐ Interview Definition

> **Method overloading is a feature in Java where multiple methods in the same class have the same name but different parameter lists. It provides compile-time polymorphism and allows related operations to be performed using a common method name.**

### ⚠️ Important

**Changing only the return type does NOT create method overloading.**

❌ Not valid overloading:

```java id="s2p7vx"
int add(int a, int b)
double add(int a, int b)
```

The parameter list is identical, so Java cannot distinguish them.
