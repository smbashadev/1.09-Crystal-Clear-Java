## 🧒 `this` Keyword in Java

The **`this` keyword** is a special keyword that refers to the **current object**.

Think of `this` as saying:

> **"This object — the object currently being worked on."**

---

# 1️⃣ `this` = Current Object Reference

Suppose:

```java
class Car {
    String brand;
    String color;
    int price;
}
```

Create an object:

```java
Car c1 = new Car();
```

When working inside that object's constructor or instance method, `this` refers to `c1`.

Conceptually:

```text
c1
 ↓
┌──────────────────┐
│ Car Object       │
│ brand            │
│ color            │
│ price            │
└──────────────────┘
        ↑
       this
```

So:

> **`this` refers to the current object.**

---

# 2️⃣ `this` as a Temporary Reference

You can think of `this` as a **temporary reference available inside an instance context** that points to the current object.

For example:

```java
class Car {

    String brand;

    void show() {
        System.out.println(this.brand);
    }
}
```

If:

```java
Car c1 = new Car();
c1.brand = "Audi";
c1.show();
```

then during `show()`:

```text
this
 ↓
c1 object
 ↓
brand = "Audi"
```

So:

```java
this.brand
```

means:

> **The `brand` belonging to the current object.**

⚠️ More technically, `this` is a **reference to the current object**, not a new object and not a separately created reference variable.

---

# 3️⃣ `this.brand`

Suppose:

```java
class Car {

    String brand;

    Car(String brand) {
        this.brand = brand;
    }
}
```

There are two `brand`s:

```text
this.brand → instance variable
brand      → constructor parameter
```

Therefore:

```java
this.brand = brand;
```

means:

> **Put the constructor parameter `brand` into the current object's `brand` variable.**

---

# 4️⃣ `this.color`

Similarly:

```java
this.color = color;
```

means:

```text
this.color
    ↓
Current object's color

color
    ↓
Constructor parameter
```

---

# 5️⃣ `this.price`

And:

```java
this.price = price;
```

means:

```text
Current object's price = parameter price
```

---

# 6️⃣ Solving the Shadowing Problem

This is the most important use for you right now.

Suppose:

```java
class Car {

    String brand;
    String color;
    int price;

    Car(String brand, String color, int price) {
        brand = brand;
        color = color;
        price = price;
    }
}
```

🚨 **Shadowing problem!**

The constructor parameters have the same names as the instance variables.

Inside:

```java
brand = brand;
```

Java chooses the local parameter `brand`.

So the instance variable doesn't receive the value.

The object keeps:

```text
brand = null
color = null
price = 0
```

---

# 7️⃣ Use `this` to Fix It

Write:

```java
class Car {

    String brand;
    String color;
    int price;

    Car(String brand, String color, int price) {

        this.brand = brand;
        this.color = color;
        this.price = price;
    }
}
```

Now there is no confusion.

```text
this.brand = brand
     ↑         ↑
     │         │
     │         └── Constructor parameter
     │
     └── Current object's instance variable
```

---

# 8️⃣ Complete Program

```java
class Car {

    String brand;
    String color;
    int price;

    // Parameterized constructor
    Car(String brand, String color, int price) {

        this.brand = brand;
        this.color = color;
        this.price = price;
    }

    public static void main(String[] args) {

        Car audi = new Car("Audi", "Black", 5000000);

        System.out.println("Brand = " + audi.brand);
        System.out.println("Color = " + audi.color);
        System.out.println("Price = " + audi.price);
    }
}
```

### Output

```text
Brand = Audi
Color = Black
Price = 5000000
```

---

# 🧠 How It Works

When this executes:

```java
Car audi = new Car("Audi", "Black", 5000000);
```

the constructor receives:

```text
brand → "Audi"
color → "Black"
price → 5000000
```

Then:

```java
this.brand = brand;
this.color = color;
this.price = price;
```

stores them in the object:

```text
             this
              ↓
┌─────────────────────────┐
│       Car Object        │
│                         │
│ brand = "Audi"          │
│ color = "Black"         │
│ price = 5000000         │
└─────────────────────────┘
```

---

# 🔑 Memory Trick

Whenever you see:

```java
this.x = x;
```

remember:

```text
this.x → Object's variable
x     → Local parameter
```

### One-line formula:

> **`this` = current object**

And for shadowing:

> **`this.variable = parameter;`**

### ⭐ Interview Answer

> **`this` is a reference that refers to the current object. It is commonly used to distinguish instance variables from local variables or constructor parameters when they have the same name. For example, `this.brand = brand` assigns the constructor parameter `brand` to the current object's instance variable `brand`.**
