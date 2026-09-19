# 🧒 Static Variables in Java

Before understanding **static variables**, let's first understand what happens **without `static`**.

Suppose we are creating a program for **circles**.

Every circle has:

* A radius `r`
* The value of π (`pi`)

The important question is:

> **Should every Circle object have its own separate copy of `pi`?**

Let's understand.

---

# 1. Circle Class

Imagine a `Circle` class:

```java
class Circle {

    double r;
    double pi = 3.14;
}
```

Here:

```text
r  → radius
pi → value of π
```

Both are **instance variables** because we have not used `static`.

---

# 2. Creating One Circle Object

Suppose:

```java
Circle c1 = new Circle();
```

Java creates a Circle object in the heap.

That object contains:

```text
c1
 ↓
┌─────────────────┐
│ r  = 0.0        │
│ pi = 3.14       │
└─────────────────┘
```

So `c1` has its own copy of:

```text
r
pi
```

---

# 3. Creating a Second Circle

Now:

```java
Circle c2 = new Circle();
```

Java creates another object.

```text
c1
 ↓
┌─────────────────┐
│ r  = 0.0        │
│ pi = 3.14       │
└─────────────────┘

c2
 ↓
┌─────────────────┐
│ r  = 0.0        │
│ pi = 3.14       │
└─────────────────┘
```

Now there are **two copies of `r`** and **two copies of `pi`**.

---

# 4. Giving Different Radii

Let's give the circles different radii:

```java
c1.r = 5;
c2.r = 10;
```

Now:

```text
c1
 ↓
┌─────────────────┐
│ r  = 5          │
│ pi = 3.14       │
└─────────────────┘

c2
 ↓
┌─────────────────┐
│ r  = 10         │
│ pi = 3.14       │
└─────────────────┘
```

This is perfectly reasonable for `r`.

Why?

Because each circle can have a **different radius**.

```text
Circle 1 → radius 5
Circle 2 → radius 10
Circle 3 → radius 20
```

---

# 5. But What About `pi`?

Here's the problem.

We have:

```java
double pi = 3.14;
```

Every Circle object gets its own copy:

```text
Circle 1 → pi = 3.14
Circle 2 → pi = 3.14
Circle 3 → pi = 3.14
Circle 4 → pi = 3.14
```

But do we really need a separate `pi` for every circle?

**No.**

The value of π is common to all circles.

It doesn't matter whether we have:

```text
Circle 1
Circle 2
Circle 3
Circle 100
```

The value is still:

```text
3.14
```

So creating a separate copy for every object is unnecessary.

This is the problem that `static` helps solve.

---

# 6. Complete Program Without `static`

```java
class Circle {

    double r;
    double pi = 3.14;

    public static void main(String[] args) {

        Circle c1 = new Circle();
        Circle c2 = new Circle();

        c1.r = 5;
        c2.r = 10;

        System.out.println("Circle 1 radius: " + c1.r);
        System.out.println("Circle 1 pi: " + c1.pi);

        System.out.println("Circle 2 radius: " + c2.r);
        System.out.println("Circle 2 pi: " + c2.pi);
    }
}
```

### Output

```text
Circle 1 radius: 5.0
Circle 1 pi: 3.14
Circle 2 radius: 10.0
Circle 2 pi: 3.14
```

---

# 7. What Is Happening in Memory?

When we write:

```java
Circle c1 = new Circle();
Circle c2 = new Circle();
```

two separate objects are created.

Conceptually:

```text
                Heap
                 │
       ┌─────────┴─────────┐
       ↓                   ↓
   Circle Object 1     Circle Object 2
   ┌──────────────┐    ┌──────────────┐
   │ r = 5        │    │ r = 10       │
   │ pi = 3.14    │    │ pi = 3.14    │
   └──────────────┘    └──────────────┘
```

Notice:

```text
r
```

is different for each object.

But:

```text
pi
```

is unnecessarily duplicated.

---

# 8. Instance Variable Means Individual Copy

A variable without `static` is an **instance variable** when declared at class level.

For example:

```java
class Circle {

    double r;
    double pi = 3.14;
}
```

When objects are created:

```text
Object 1 → own r + own pi
Object 2 → own r + own pi
Object 3 → own r + own pi
```

So:

> **Instance variables belong to individual objects.**

---

# 9. Why `r` Should Be an Instance Variable

Consider:

```java
Circle c1 = new Circle();
Circle c2 = new Circle();
```

We can have:

```text
c1.r = 5
c2.r = 10
```

That's exactly what we want.

Each Circle needs its own radius.

```text
Circle 1 → 5
Circle 2 → 10
Circle 3 → 15
```

So:

```java
double r;
```

should be an **instance variable**.

---

# 10. Why `pi` Is Different

All circles use the same value:

```text
pi = 3.14
```

We don't need:

```text
Circle 1 → pi = 3.14
Circle 2 → pi = 3.14
Circle 3 → pi = 3.14
Circle 4 → pi = 3.14
```

Instead, conceptually, we want:

```text
                 pi = 3.14
                    ↑
          ┌─────────┼─────────┐
          ↑         ↑         ↑
       Circle 1  Circle 2  Circle 3
```

One common value can be shared.

That's where we will introduce:

```java
static
```

---

# 🧠 Real-Life Example

Imagine a classroom with 30 students.

Every student has:

```text
Name
Age
Roll Number
```

These are different for every student.

```text
Student 1 → Age 20
Student 2 → Age 21
Student 3 → Age 20
```

So these are like **instance variables**.

But suppose the school name is:

```text
ABC College
```

Every student belongs to the same college.

Do we need to store:

```text
Student 1 → ABC College
Student 2 → ABC College
Student 3 → ABC College
...
Student 1000 → ABC College
```

as separate copies?

Conceptually, no.

The school name is **common**.

That's the basic idea behind a static variable.

---

# 🎯 Important Difference

| Variable         | Without `static`                          |
| ---------------- | ----------------------------------------- |
| `r`              | Each Circle object gets its own copy      |
| `pi`             | Each Circle object also gets its own copy |
| Ownership        | Object                                    |
| Number of copies | One per object                            |

So with:

```java
double r;
double pi = 3.14;
```

and three objects:

```text
3 Circle objects
        ↓
3 copies of r
3 copies of pi
```

---

# ⭐ Why Are We Learning This?

The whole purpose of this example is to identify **common data**.

Ask yourself:

> **Does this value change from object to object?**

### `r`

```text
Circle 1 → 5
Circle 2 → 10
Circle 3 → 15
```

Yes, it can change.

➡️ **Instance variable**

### `pi`

```text
Circle 1 → 3.14
Circle 2 → 3.14
Circle 3 → 3.14
```

It is common.

➡️ This is a good candidate for a **static variable**.

---

# 🧠 Remember Forever

```text
Without static:

Object 1
 ├── r
 └── pi

Object 2
 ├── r
 └── pi

Object 3
 ├── r
 └── pi
```

Every object gets its **own copy** of instance variables.

### Golden Rule

> **An instance variable belongs to each individual object, so every object gets its own copy.**

For our Circle:

```text
r  → individual → instance variable
pi → common     → candidate for static variable
```

The next step is to see how changing:

```java
double pi = 3.14;
```

to:

```java
static double pi = 3.14;
```

changes the memory model and allows all Circle objects to share the **same class-level variable**.
