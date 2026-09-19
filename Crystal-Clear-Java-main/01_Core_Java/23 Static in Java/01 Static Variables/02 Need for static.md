# 🧒 Need for `static`

Now we know that an **instance variable** gives every object its own copy.

But sometimes we have a value that is **the same for every object**.

In that situation, creating a separate copy for every object is unnecessary.

That's why we need **`static`**.

---

## 1. Same Value Shared by Objects

Let's take our `Circle` example.

Every circle has:

```text
Radius → Different
Pi     → Same
```

For example:

```text
Circle 1 → radius = 5,  pi = 3.14
Circle 2 → radius = 10, pi = 3.14
Circle 3 → radius = 20, pi = 3.14
```

Look carefully:

```text
radius → 5, 10, 20
```

Different objects have different values.

But:

```text
pi → 3.14, 3.14, 3.14
```

The value is the same.

So we don't really need:

```text
Circle 1 → own copy of pi
Circle 2 → own copy of pi
Circle 3 → own copy of pi
```

We want one common `pi`.

---

# 2. Common Variable

A variable whose value is **common to all objects** is a good candidate for `static`.

Without `static`:

```java
class Circle {

    double r;
    double pi = 3.14;
}
```

Conceptually:

```text
Circle 1
 ├── r
 └── pi

Circle 2
 ├── r
 └── pi

Circle 3
 ├── r
 └── pi
```

There are three copies of `pi`.

With `static`:

```java
class Circle {

    double r;
    static double pi = 3.14;
}
```

Conceptually:

```text
             static pi
               3.14
                 ↑
        ┌────────┼────────┐
        ↑        ↑        ↑
     Circle 1  Circle 2  Circle 3
        │        │        │
       r=5     r=10     r=20
```

Now `pi` is associated with the **class**, rather than being separately stored as an instance variable in every object.

---

# 3. Why Do We Need This?

Imagine creating:

```java
Circle c1 = new Circle();
Circle c2 = new Circle();
Circle c3 = new Circle();
```

Then:

```text
c1 → pi = 3.14
c2 → pi = 3.14
c3 → pi = 3.14
```

If we create 1,000 circles, the common value is still:

```text
3.14
```

There is no reason for each object to conceptually own its own copy of the same class-level data.

`static` allows us to represent that **one common value**.

---

# 4. Memory Efficiency

This is one reason `static` is useful.

### Without `static`

Suppose we have 3 objects:

```text
Object 1 → pi
Object 2 → pi
Object 3 → pi
```

Each object has its own instance copy.

### With `static`

```text
One common pi
      ↓
3 objects can use it
```

So:

> **When data is genuinely common to all objects, keeping one shared class-level copy avoids unnecessary per-object duplication.**

---

# 5. Complete Program

```java
class Circle {

    double radius;
    static double pi = 3.14;

    public static void main(String[] args) {

        Circle c1 = new Circle();
        Circle c2 = new Circle();

        c1.radius = 5;
        c2.radius = 10;

        System.out.println("Circle 1 Radius: " + c1.radius);
        System.out.println("Circle 2 Radius: " + c2.radius);

        System.out.println("Pi: " + Circle.pi);
    }
}
```

### Output

```text
Circle 1 Radius: 5.0
Circle 2 Radius: 10.0
Pi: 3.14
```

Notice:

```java
Circle.pi
```

We can access `pi` using the **class name** because it is `static`.

---

# 6. What Should Be `static`?

Ask this simple question:

> **"Is this value different for every object, or common to all objects?"**

### Different → Instance Variable

```text
Circle 1 → radius = 5
Circle 2 → radius = 10
Circle 3 → radius = 20
```

So:

```java
double radius;
```

### Common → Static Variable

```text
Circle 1 → pi = 3.14
Circle 2 → pi = 3.14
Circle 3 → pi = 3.14
```

So:

```java
static double pi = 3.14;
```

---

# 🧒 Real-Life Example

Imagine a school.

Every student has a:

```text
Name
Age
Roll Number
```

These are different for each student.

```text
Student 1 → Basha, 20
Student 2 → Ravi, 21
Student 3 → Kumar, 20
```

But suppose all students belong to:

```text
ABC School
```

The school name is common.

Instead of thinking:

```text
Student 1 → ABC School
Student 2 → ABC School
Student 3 → ABC School
...
```

as separate student-specific data, we can model it as common class-level information.

---

# 🎯 Instance vs Static

| Instance Variable            | Static Variable                      |
| ---------------------------- | ------------------------------------ |
| Belongs to an object         | Belongs to the class                 |
| Each object has its own copy | One common class-level variable      |
| Can have different values    | Common value can be shared           |
| Example: `radius`            | Example: `pi`                        |
| Accessed through object      | Commonly accessed through class name |

---

# 🧠 Remember Forever

```text
INSTANCE
   ↓
Individual
   ↓
Each object gets its own copy
   ↓
Example: radius
```

```text
STATIC
   ↓
Common
   ↓
One class-level variable shared by objects
   ↓
Example: pi
```

### ⭐ Golden Memory Trick

> **Different object → instance variable.**
> **Common to all objects → static variable.**

For our Circle:

```text
Circle
 ├── radius → different → instance
 │
 └── pi     → common    → static
```

And the main reason for `static` here is:

> **Don't create separate per-object copies of data that is logically common to all objects.**
