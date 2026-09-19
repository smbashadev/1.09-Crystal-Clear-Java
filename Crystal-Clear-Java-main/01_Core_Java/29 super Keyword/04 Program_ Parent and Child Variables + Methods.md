# 🧒 Program: Parent and Child Variables + Methods

Let's create a simple program with:

* **Parent class**
* **Child/Daughter class**
* **Parent variable**
* **Child variable**
* **Parent method**
* **Child method**

We will also see how the child can access the parent's members.

---

## 1. Parent Class

Let's create a `Parent` class:

```java
class Parent {

    int parentMoney = 1000;

    void parentWork() {
        System.out.println("Parent is working");
    }
}
```

The `Parent` class has:

```text
Parent
 ├── parentMoney = 1000
 └── parentWork()
```

---

# 2. Child/Daughter Class

Now create a child class:

```java
class Daughter extends Parent {

    int daughterMoney = 500;

    void daughterWork() {
        System.out.println("Daughter is working");
    }
}
```

Because:

```java
class Daughter extends Parent
```

`Daughter` inherits the accessible members of `Parent`.

So we have:

```text
             Parent
               │
       ┌───────┴────────┐
       │                │
parentMoney        parentWork()
       │
       ↓
    Daughter
       │
       ├── parentMoney
       ├── parentWork()
       ├── daughterMoney
       └── daughterWork()
```

---

# 3. Complete Program

```java
class Parent {

    int parentMoney = 1000;

    void parentWork() {
        System.out.println("Parent is working");
    }
}

class Daughter extends Parent {

    int daughterMoney = 500;

    void daughterWork() {
        System.out.println("Daughter is working");
    }
}

class Demo {

    public static void main(String[] args) {

        Daughter d = new Daughter();

        System.out.println("Parent variable: " + d.parentMoney);

        System.out.println("Child variable: " + d.daughterMoney);

        d.parentWork();

        d.daughterWork();
    }
}
```

### Output

```text
Parent variable: 1000
Child variable: 500
Parent is working
Daughter is working
```

---

# 4. What Happened Here?

We created:

```java
Daughter d = new Daughter();
```

The object is a **Daughter object**.

Because `Daughter extends Parent`, the daughter can access the inherited `parentMoney` and `parentWork()`.

So this works:

```java
d.parentMoney
```

and:

```java
d.parentWork();
```

The daughter can also access her own members:

```java
d.daughterMoney
```

and:

```java
d.daughterWork();
```

---

# 5. Parent Variable

The variable:

```java
int parentMoney = 1000;
```

belongs to the `Parent` class.

The daughter can access it because of inheritance:

```java
System.out.println(d.parentMoney);
```

Output:

```text
1000
```

---

# 6. Child Variable

The variable:

```java
int daughterMoney = 500;
```

belongs only to `Daughter`.

So:

```java
System.out.println(d.daughterMoney);
```

Output:

```text
500
```

---

# 7. Parent Method

The method:

```java
void parentWork() {
    System.out.println("Parent is working");
}
```

belongs to `Parent`.

The daughter can use it:

```java
d.parentWork();
```

Output:

```text
Parent is working
```

This is an **inherited method**.

---

# 8. Child Method

The method:

```java
void daughterWork() {
    System.out.println("Daughter is working");
}
```

belongs only to `Daughter`.

So:

```java
d.daughterWork();
```

Output:

```text
Daughter is working
```

This is a **specialized method** because it exists only in the child.

---

# 🧠 Visual Memory

```text
                 Parent
              /          \
             /            \
    parentMoney          parentWork()
        1000                 │
             \              /
              \            /
               ↓          ↓
                 Daughter
                    │
            ┌───────┴────────┐
            ↓                ↓
      daughterMoney     daughterWork()
           500
```

### Daughter can access:

```text
Parent members
      +
Daughter members
```

So:

```text
d.parentMoney       → Parent variable
d.daughterMoney     → Child variable

d.parentWork()      → Parent method
d.daughterWork()    → Child method
```

---

# ⭐ Important Point

If the parent and child have **different variable/method names**, there is no confusion.

```text
Parent:
    parentMoney
    parentWork()

Daughter:
    daughterMoney
    daughterWork()
```

The child can use both sets of accessible members.

> **Inheritance allows the child to reuse accessible members of the parent and also define its own members.**
