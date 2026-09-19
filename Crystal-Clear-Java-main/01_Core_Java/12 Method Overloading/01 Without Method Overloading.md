## 🧒 Without Method Overloading

Imagine we need **5 methods** that all perform a similar task: **accept information**.

Without method overloading, we could create:

```text id="d4q8ks"
acceptInfo1()
acceptInfo2()
acceptInfo3()
acceptInfo4()
acceptInfo5()
```

They all have **different names**, even though their purpose is similar.

---

## 1️⃣ Multiple Methods

Suppose we write:

```java id="x7m2qp"
class Student {

    static void acceptInfo1() {
        System.out.println("Accepting student information 1");
    }

    static void acceptInfo2() {
        System.out.println("Accepting student information 2");
    }

    static void acceptInfo3() {
        System.out.println("Accepting student information 3");
    }

    static void acceptInfo4() {
        System.out.println("Accepting student information 4");
    }

    static void acceptInfo5() {
        System.out.println("Accepting student information 5");
    }

    public static void main(String[] args) {
        acceptInfo1();
        acceptInfo2();
        acceptInfo3();
        acceptInfo4();
        acceptInfo5();
    }
}
```

Here we have **five different methods**.

---

## 2️⃣ Similar Task

Notice something:

```text id="b6x9mz"
acceptInfo1() ─┐
acceptInfo2()  │
acceptInfo3()  ├── Similar task
acceptInfo4()  │
acceptInfo5() ─┘
```

All methods are related to **accepting information**.

But Java sees these as completely different method names:

```text id="n5k8rz"
acceptInfo1
acceptInfo2
acceptInfo3
acceptInfo4
acceptInfo5
```

---

## 3️⃣ Different Method Names

Because the method names are different, we have to remember **which name to call**.

For example:

```java id="q3w7kp"
acceptInfo1();
acceptInfo2();
acceptInfo3();
```

If we want the fourth method:

```java id="v9m2xc"
acceptInfo4();
```

This can become inconvenient when many methods perform related tasks.

---

# 🧠 Why Do We Need Method Overloading?

Instead of creating:

```text id="r5c8ny"
acceptInfo1()
acceptInfo2()
acceptInfo3()
acceptInfo4()
acceptInfo5()
```

we can use **one common method name**:

```text id="h7p3qx"
acceptInfo()
```

and change its **parameters**.

For example:

```java id="w2k6mv"
acceptInfo()
acceptInfo(String name)
acceptInfo(String name, int age)
acceptInfo(String name, int age, String city)
```

Same method name, different parameter lists.

That's **method overloading**.

---

## 🔄 Without vs With Overloading

### ❌ Without Method Overloading

```text id="m8q2vz"
acceptInfo1()
acceptInfo2()
acceptInfo3()
acceptInfo4()
acceptInfo5()
       ↓
Different names
```

### ✅ With Method Overloading

```text id="k4x7ps"
acceptInfo()
acceptInfo(String)
acceptInfo(String, int)
acceptInfo(String, int, String)
       ↓
Same name
Different parameters
```

### 🔑 Memory Trick

> **Without overloading:** Similar task → **different method names**

> **With overloading:** Similar task → **same method name + different parameter list**

```text id="c3n8qa"
WITHOUT OVERLOADING
        ↓
Different Names

WITH OVERLOADING
        ↓
Same Name
+
Different Parameters
```
