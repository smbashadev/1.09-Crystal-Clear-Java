## 🧒 Shadowing Problem in Constructor

A **shadowing problem** happens when a constructor's **parameters have the same names as the instance variables**.

The local parameter temporarily **hides/shadows** the instance variable when you use that name inside the constructor.

---

# 1️⃣ Instance Variables

Suppose we have:

```java id="q4m8kx"
class Student {
    String name;
    int age;
}
```

Here:

```text id="t7p2va"
name → Instance variable
age  → Instance variable
```

Initially, because they are instance variables:

```text id="x3n9mc"
name = null
age  = 0
```

---

# 2️⃣ Constructor Has Same Names

Now we write:

```java id="k8v5zr"
Student(String name, int age) {
    name = name;
    age = age;
}
```

Look carefully.

There are **two `name`s**:

```text id="b6q2wp"
String name;       → instance variable

Student(String name, int age)
                  ↑
             local parameters
```

Inside the constructor:

```java id="m2x7kc"
name = name;
```

Java sees the nearest/local `name` first.

So both sides refer to the **parameter**.

```text id="w9p4zn"
name = name;
 ↑       ↑
local   local
```

The instance variable is **not being changed**.

---

# 3️⃣ Why Is This a Problem?

Consider:

```java id="f3k8qa"
class Student {

    String name;
    int age;

    Student(String name, int age) {
        name = name;
        age = age;
    }

    public static void main(String[] args) {

        Student s = new Student("Basha", 26);

        System.out.println(s.name);
        System.out.println(s.age);
    }
}
```

You might expect:

```text id="j6v2mc"
Basha
26
```

But the output is:

```text id="r8k4wp"
null
0
```

Why?

Because:

```java id="e5q9vn"
name = name;
age = age;
```

doesn't assign the parameters to the object's fields.

The instance variables keep their default values.

```text id="p2m7xa"
Parameter "Basha"
       ↓
     name
       ↓
name = name
       ↓
Parameter gets assigned to itself
       ↓
Instance name remains null
```

Similarly:

```text id="a8v3ky"
Parameter 26
    ↓
  age
    ↓
age = age
    ↓
Instance age remains 0
```

---

# 4️⃣ This Is Called Shadowing

The parameter:

```java id="v5q2mx"
String name
```

**shadows** the instance variable:

```java id="n8k4pz"
String name;
```

because they have the same name.

Think of it like two people named **Basha** standing in the same room. 😄

```text id="7x3mqa"
name
 ├── Instance variable
 └── Constructor parameter
```

Inside the constructor, the **local parameter gets priority**.

---

# 5️⃣ How to Solve the Shadowing Problem

Use the `this` keyword.

```java id="w4n9kc"
Student(String name, int age) {
    this.name = name;
    this.age = age;
}
```

Now Java can clearly distinguish them.

```text id="m7p3qx"
this.name
   ↑
instance variable

name
   ↑
constructor parameter
```

So:

```java id="s5k8va"
this.name = name;
```

means:

> **Put the parameter `name` into this object's instance variable `name`.**

And:

```java id="z2q6mw"
this.age = age;
```

means:

> **Put the parameter `age` into this object's instance variable `age`.**

---

# 6️⃣ Correct Program

```java id="n3v8kp"
class Student {

    String name;
    int age;

    Student(String name, int age) {

        // Solving shadowing using this
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {

        Student s = new Student("Basha", 26);

        System.out.println(s.name);
        System.out.println(s.age);
    }
}
```

Output:

```text id="c7m2xa"
Basha
26
```

---

# 🧠 Visual Comparison

### ❌ Shadowing Problem

```java id="x8q4mz"
name = name;
```

```text
local name ───→ local name
                   ✕
             instance variable
             remains null
```

### ✅ Using `this`

```java id="k5p9vn"
this.name = name;
```

```text
parameter name ─────────→ this.name
"Basha"                    instance variable
                              ↓
                           "Basha"
```

---

# 🔑 Memory Trick

Whenever you see:

```java id="m8r2qx"
String name;

Student(String name) {
    name = name;
}
```

think:

> 🚨 **SHADOWING!**

Fix it:

```java id="q4n7kp"
this.name = name;
```

Remember:

> **`this.name` = instance variable**

> **`name` = constructor parameter**

---

### ⭐ Interview Answer

> **Shadowing occurs when a constructor parameter has the same name as an instance variable. The local parameter takes precedence inside the constructor, so simply writing `name = name` assigns the parameter to itself and leaves the instance variable unchanged at its default value. The `this` keyword is used to explicitly refer to the current object's instance variable, for example `this.name = name`.**
