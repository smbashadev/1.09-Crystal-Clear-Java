# 🧒 Interface Inheritance

Here we have **two interfaces**:

```text
Calculate1
     ↑
     │ extends
     │
Calculate2
     ↑
     │ implements
     │
   Finds
```

The important point is:

> **An interface can extend another interface, and a class can implement the child interface.**

---

## 1️⃣ `Calculate1` Interface

```java
interface Calculate1 {

    void add();
}
```

`Calculate1` declares:

```text
add()
```

---

## 2️⃣ `Calculate2 extends Calculate1`

```java
interface Calculate2 extends Calculate1 {

    void subtract();
}
```

Now `Calculate2` gets the contract of `Calculate1`.

So `Calculate2` effectively has:

```text
add()
subtract()
```

Hierarchy:

```text
Calculate1
   │
   │ extends
   ↓
Calculate2
```

---

## 3️⃣ `Finds implements Calculate2`

Now a class can implement `Calculate2`:

```java
class Finds implements Calculate2 {

    public void add() {
        System.out.println("Addition");
    }

    public void subtract() {
        System.out.println("Subtraction");
    }
}
```

Because `Calculate2` extends `Calculate1`, `Finds` must implement **both** methods:

```text
Calculate1
   │
   └── add()
        ↓
Calculate2
   │
   └── subtract()
        ↓
Finds
   ├── add()       ← inherited contract
   └── subtract()  ← Calculate2 contract
```

---

# 4️⃣ Complete Program

```java
interface Calculate1 {

    void add();
}

interface Calculate2 extends Calculate1 {

    void subtract();
}

class Finds implements Calculate2 {

    @Override
    public void add() {
        System.out.println("Addition");
    }

    @Override
    public void subtract() {
        System.out.println("Subtraction");
    }
}

class Demo {

    public static void main(String[] args) {

        Finds f = new Finds();

        f.add();
        f.subtract();
    }
}
```

### Output

```text
Addition
Subtraction
```

---

# ⭐ Key Concept

Notice the keywords:

```java
interface Calculate2 extends Calculate1
```

Because:

```text
Interface → Interface
```

we use **`extends`**.

Then:

```java
class Finds implements Calculate2
```

Because:

```text
Class → Interface
```

we use **`implements`**.

---

## 🔥 Golden Rule

```text
Calculate1
    │
    │ extends
    ↓
Calculate2
    │
    │ implements
    ↓
  Finds
```

Therefore:

> **`Calculate2` inherits the methods of `Calculate1`, and `Finds` implements `Calculate2`, so `Finds` must provide implementations for the abstract methods inherited from both interfaces.**
