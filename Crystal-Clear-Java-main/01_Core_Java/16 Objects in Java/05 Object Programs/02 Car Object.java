## 🧒 Car Object

Let's understand **objects, default values, multiple objects, different states, and common behavior** using a `Car`.

The main idea is:

> **One class can create many objects, and each object can have different state but share the same behavior.**

---

# 1️⃣ Car Object

First, create a `Car` class:

```java
class Car {
    String brand;
    String color;
    int price;

    void drive() {
        System.out.println(brand + " is driving");
    }
}
```

Now create a Car object:

```java
Car c1 = new Car();
```

Here:

```text
Car      → Class
c1       → Reference variable
new Car() → Object
```

---

# 2️⃣ Car Default Values

When we create:

```java
Car c1 = new Car();
```

we haven't given values to the instance variables.

Java automatically gives them **default values**.

```text
┌────────────────────┐
│     Car Object     │
├────────────────────┤
│ brand = null       │
│ color = null       │
│ price = 0          │
└────────────────────┘
```

Because:

```text
String → null
int    → 0
```

So:

```java
System.out.println(c1.brand); // null
System.out.println(c1.color); // null
System.out.println(c1.price); // 0
```

---

# 3️⃣ Multiple Car Objects

One class can create **many objects**.

```java
Car c1 = new Car();
Car c2 = new Car();
Car c3 = new Car();
```

Think of the class as a **car factory blueprint** 🏭.

```text
             Car Class
          (Common Blueprint)
                 │
       ┌─────────┼─────────┐
       ↓         ↓         ↓
      c1         c2        c3
     Car        Car       Car
    Object     Object    Object
```

Each object is a separate instance.

---

# 4️⃣ Audi and Benz

Let's create two cars:

```java
Car audi = new Car();
Car benz = new Car();
```

Give them different values:

```java
audi.brand = "Audi";
audi.color = "Black";
audi.price = 5000000;

benz.brand = "Benz";
benz.color = "White";
benz.price = 6000000;
```

Now:

```text
Audi Object                 Benz Object
┌───────────────┐           ┌───────────────┐
│ brand = Audi  │           │ brand = Benz  │
│ color = Black │           │ color = White │
│ price = 50L   │           │ price = 60L   │
└───────────────┘           └───────────────┘
```

---

# 5️⃣ Different Object States

This is very important.

Both objects belong to the **same class**:

```java
Car
```

But their values are different.

```text
Audi
brand = Audi
color = Black
price = 50L

Benz
brand = Benz
color = White
price = 60L
```

Therefore:

> **Different objects of the same class can have different states.**

### State = current values of instance variables.

```text
Car Object
    │
    ├── brand
    ├── color
    └── price
```

For Audi:

```text
Audi → Black → 50L
```

For Benz:

```text
Benz → White → 60L
```

---

# 6️⃣ Common Behavior

Although Audi and Benz have different states, they can have the **same behavior** because both are `Car` objects.

For example:

```java
void drive() {
    System.out.println(brand + " is driving");
}
```

Both can use it:

```java
audi.drive();
benz.drive();
```

Output:

```text
Audi is driving
Benz is driving
```

So:

```text
             Car Class
          ┌──────────────┐
          │ State        │
          │ brand        │
          │ color        │
          │ price        │
          │              │
          │ Behavior     │
          │ drive()      │
          └──────┬───────┘
                 │
          ┌──────┴───────┐
          ↓              ↓
       Audi Object    Benz Object
       Different      Different
       State          State
          │              │
          └──────┬───────┘
                 ↓
          Common Behavior
             drive()
```

---

# 7️⃣ Complete Program

```java
class Car {

    // State
    String brand;
    String color;
    int price;

    // Common behavior
    void drive() {
        System.out.println(brand + " is driving");
    }

    public static void main(String[] args) {

        // Multiple objects
        Car audi = new Car();
        Car benz = new Car();

        // Audi state
        audi.brand = "Audi";
        audi.color = "Black";
        audi.price = 5000000;

        // Benz state
        benz.brand = "Benz";
        benz.color = "White";
        benz.price = 6000000;

        // Display states
        System.out.println("Audi: " + audi.brand + ", "
                + audi.color + ", " + audi.price);

        System.out.println("Benz: " + benz.brand + ", "
                + benz.color + ", " + benz.price);

        // Common behavior
        audi.drive();
        benz.drive();
    }
}
```

### Output

```text
Audi: Audi, Black, 5000000
Benz: Benz, White, 6000000
Audi is driving
Benz is driving
```

---

# 🧠 The Big Picture

```text
                 CLASS
                  Car
                   │
        ┌──────────┴──────────┐
        ↓                     ↓
      STATE                 BEHAVIOR
   brand/color/price          drive()
        │                     │
        │                     │
   ┌────┴────┐                │
   ↓         ↓                │
 Audi       Benz              │
 Object     Object            │
   │         │                │
Different  Different          │
 states    states             │
   │         │                │
   └─────────┴────────────────┘
             Common
            behavior
```

### 🔑 Memory Trick

> **Same Class → Multiple Objects → Different States → Common Behavior**

Or simply:

> **Class = Blueprint**
> **Object = Real Car**
> **State = What the car has**
> **Behavior = What the car does**

### ⭐ Interview Answer

> **A class can be used to create multiple objects. Each object has its own instance-variable values, so objects of the same class can have different states. However, they share the behavior defined by the class's methods. For example, Audi and Benz can be different Car objects with different brands, colors, and prices, while both can perform the common `drive()` behavior.**
