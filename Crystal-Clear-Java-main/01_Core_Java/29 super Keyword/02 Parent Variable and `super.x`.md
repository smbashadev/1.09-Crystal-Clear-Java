# 🧒 Parent Variable and `super.x`

When the **parent class and child class have variables with the same name**, the child can use `super.x` to specifically access the **parent's variable**.

---

## 1. Parent Has `x`

```java
class Parent {

    int x = 10;
}
```

Here:

```text
Parent
  ↓
x = 10
```

---

## 2. Child Also Has `x`

```java
class Child extends Parent {

    int x = 20;
}
```

Now there are **two different `x` variables**:

```text
Parent → x = 10
Child  → x = 20
```

They belong to different classes.

---

## 3. What Does `x` Mean in Child?

Inside the child class:

```java
System.out.println(x);
```

normally refers to the **child's `x`**.

So:

```java
class Child extends Parent {

    int x = 20;

    void display() {
        System.out.println(x);
    }
}
```

Output:

```text
20
```

---

## 4. What Does `super.x` Mean?

If we want the **parent's `x`**, we use:

```java
super.x
```

Example:

```java
class Parent {

    int x = 10;
}

class Child extends Parent {

    int x = 20;

    void display() {

        System.out.println(x);
        System.out.println(super.x);
    }
}
```

Output:

```text
20
10
```

### Why?

```text
x
↓
Child's x
↓
20
```

and:

```text
super.x
↓
Parent's x
↓
10
```

---

# 5. Complete Program

```java
class Parent {

    int x = 10;
}

class Child extends Parent {

    int x = 20;

    void display() {

        System.out.println("Child x = " + x);

        System.out.println("Parent x = " + super.x);
    }
}

class Demo {

    public static void main(String[] args) {

        Child c = new Child();

        c.display();
    }
}
```

### Output

```text
Child x = 20
Parent x = 10
```

---

# 🧠 Visual Memory

```text
             Parent
               │
             x = 10
               ↑
            super.x
               │
              Child
               │
             x = 20
               ↑
               x
```

So:

```text
x       → Child's x → 20

super.x → Parent's x → 10
```

---

## ⭐ Remember Forever

> **When parent and child both have a variable named `x`, use `super.x` to access the parent's `x`.**

### Golden formula:

```text
x       = current/child class variable
super.x = immediate parent class variable
```

This is especially useful when the **same variable name exists in both parent and child classes**.
