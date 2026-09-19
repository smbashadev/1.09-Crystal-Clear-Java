# 🧒 Polymorphism with Code Reduction & Flexibility

One of the biggest advantages of **polymorphism** is that it can help us write **less repeated code** and make our program **more flexible**.

The basic idea is:

```text
Common Parent Reference
        ↓
One Method Call
        ↓
Different Child Objects
        ↓
Different Implementations
```

---

## 1. Without Polymorphism ❌

Suppose we have three classes:

```java
Army army = new Army();
Navy navy = new Navy();
AirForce airForce = new AirForce();

army.attack();
navy.attack();
airForce.attack();
```

We need separate variables for each object:

```text
army.attack()
navy.attack()
airForce.attack()
```

As the number of child classes increases, our code can become repetitive.

---

# 2. With Polymorphism ✅

Suppose `Army`, `Navy`, and `AirForce` all extend:

```java
class DefenseForce
```

and each overrides:

```java
attack()
```

We can use **one common parent reference**:

```java
DefenseForce force;
```

Then:

```java
force = new Army();
force.attack();

force = new Navy();
force.attack();

force = new AirForce();
force.attack();
```

The method call is always:

```java
force.attack();
```

But the object changes.

---

# 3. One Method, Different Objects

Look carefully:

```text
                 DefenseForce
                      │
                force.attack()
                      │
          ┌───────────┼───────────┐
          ↓           ↓           ↓
       Army         Navy       AirForce
          ↓           ↓           ↓
       Army's       Navy's     AirForce's
       attack()     attack()    attack()
```

The **method call remains the same**:

```java
force.attack();
```

But the implementation changes according to the actual child object.

---

# 4. Complete Program

```java
class DefenseForce {

    void attack() {
        System.out.println("Defense force attacks");
    }
}

class Army extends DefenseForce {

    @Override
    void attack() {
        System.out.println("Army attacks");
    }
}

class Navy extends DefenseForce {

    @Override
    void attack() {
        System.out.println("Navy attacks");
    }
}

class AirForce extends DefenseForce {

    @Override
    void attack() {
        System.out.println("AirForce attacks");
    }
}

class Demo {

    public static void main(String[] args) {

        DefenseForce force;

        force = new Army();
        force.attack();

        force = new Navy();
        force.attack();

        force = new AirForce();
        force.attack();
    }
}
```

### Output

```text
Army attacks
Navy attacks
AirForce attacks
```

---

# 5. Where Is Code Reduction?

Notice that we don't need different reference variables:

❌ Instead of:

```java
Army army = new Army();
Navy navy = new Navy();
AirForce airForce = new AirForce();
```

we can use:

```java
DefenseForce force;
```

and reuse it:

```java
force = new Army();
force.attack();

force = new Navy();
force.attack();

force = new AirForce();
force.attack();
```

So a **common parent reference** allows us to work with different child objects through the same interface/reference type.

---

# 6. Flexibility ⭐

Now imagine tomorrow we add:

```java
class CoastGuard extends DefenseForce {

    @Override
    void attack() {
        System.out.println("Coast Guard attacks");
    }
}
```

We can simply do:

```java
force = new CoastGuard();
force.attack();
```

We don't need to change the `DefenseForce` reference type.

This makes the code more **flexible and extensible**.

---

# 🧠 Simple Real-Life Example

Imagine a manager gives the same instruction:

> **"Attack!"**

The manager doesn't need to know exactly how every force performs the attack.

```text
"Attack!"
   ↓
Army       → Army implementation
Navy       → Navy implementation
AirForce   → AirForce implementation
```

Similarly, the program uses:

```java
force.attack();
```

and the actual object determines what happens.

---

# ⭐ Remember Forever

### Polymorphism gives us:

```text
Common Parent Reference
        ↓
One Method Call
        ↓
Different Child Objects
        ↓
Different Implementations
        ↓
Less Repetitive Code
        ↓
More Flexibility
```

### 🔥 Interview Answer

> **Polymorphism allows a common parent reference to work with different child objects through overridden methods. This reduces the need for separate handling of each child type and makes the implementation more flexible and easier to extend.**
