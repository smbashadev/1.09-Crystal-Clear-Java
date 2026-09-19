# 🧒 Abstract Method with Polymorphism

This example combines **three important concepts**:

1. **Abstract class**
2. **Abstract methods**
3. **Runtime polymorphism**

We'll use:

```text
SecurityForce
      ↓
 ┌────┼─────┐
 ↓    ↓     ↓
Army Navy AirForce
```

---

## 1. Abstract `SecurityForce`

`SecurityForce` represents a **general concept**, so we make it abstract.

```java
abstract class SecurityForce {

    abstract void attack();

    abstract void defend();
}
```

Here:

```text
SecurityForce
      │
      ├── attack()  → abstract
      │
      └── defend()  → abstract
```

The parent class says:

> "Every security force must know how to `attack()` and `defend()`, but I won't decide how each force performs these operations."

---

# 2. `Army`

`Army` provides its own implementation.

```java
class Army extends SecurityForce {

    @Override
    void attack() {

        System.out.println("Army attacks using ground forces");
    }

    @Override
    void defend() {

        System.out.println("Army defends the country on land");
    }
}
```

---

# 3. `Navy`

```java
class Navy extends SecurityForce {

    @Override
    void attack() {

        System.out.println("Navy attacks using naval forces");
    }

    @Override
    void defend() {

        System.out.println("Navy defends the country at sea");
    }
}
```

---

# 4. `AirForce`

```java
class AirForce extends SecurityForce {

    @Override
    void attack() {

        System.out.println("AirForce attacks using air forces");
    }

    @Override
    void defend() {

        System.out.println("AirForce defends the country from the air");
    }
}
```

---

# 5. Where Is Polymorphism? ⭐

Now:

```java
SecurityForce force;
```

This is an **abstract class reference**.

We can make it point to different child objects:

```java
force = new Army();
force.attack();
force.defend();

force = new Navy();
force.attack();
force.defend();

force = new AirForce();
force.attack();
force.defend();
```

The same reference:

```text
SecurityForce force
```

points to:

```text
Army object
Navy object
AirForce object
```

This is **runtime polymorphism**.

---

# 6. Complete Program

```java
abstract class SecurityForce {

    abstract void attack();

    abstract void defend();
}

class Army extends SecurityForce {

    @Override
    void attack() {
        System.out.println("Army attacks using ground forces");
    }

    @Override
    void defend() {
        System.out.println("Army defends the country on land");
    }
}

class Navy extends SecurityForce {

    @Override
    void attack() {
        System.out.println("Navy attacks using naval forces");
    }

    @Override
    void defend() {
        System.out.println("Navy defends the country at sea");
    }
}

class AirForce extends SecurityForce {

    @Override
    void attack() {
        System.out.println("AirForce attacks using air forces");
    }

    @Override
    void defend() {
        System.out.println("AirForce defends the country from the air");
    }
}

class Demo {

    public static void main(String[] args) {

        SecurityForce force;

        force = new Army();
        force.attack();
        force.defend();

        force = new Navy();
        force.attack();
        force.defend();

        force = new AirForce();
        force.attack();
        force.defend();
    }
}
```

### Output

```text
Army attacks using ground forces
Army defends the country on land

Navy attacks using naval forces
Navy defends the country at sea

AirForce attacks using air forces
AirForce defends the country from the air
```

---

# 🧠 Understand the Flow

```text
                 SecurityForce
                  (abstract)
                      │
             ┌────────┼────────┐
             ↓        ↓        ↓
           Army      Navy    AirForce
             │        │        │
             ↓        ↓        ↓
          attack()  attack()  attack()
          defend()  defend()  defend()
```

The parent declares:

```java
abstract void attack();
abstract void defend();
```

The children implement:

```text
Army     → attack(), defend()
Navy     → attack(), defend()
AirForce → attack(), defend()
```

---

# 🔥 Why Is This Polymorphism?

Because:

```java
SecurityForce force;
```

is one common parent reference.

It can refer to:

```java
force = new Army();
force = new Navy();
force = new AirForce();
```

And:

```java
force.attack();
```

executes a **different implementation** depending on the actual object.

```text
SecurityForce force
        ↓
   ┌────┼────┐
   ↓    ↓    ↓
 Army Navy AirForce
   ↓    ↓    ↓
attack attack attack
```

### Golden Rule

> **Abstract methods define what the child classes must do; polymorphism allows each child class to decide how it does it.**

So in this example:

```text
Abstract class
      ↓
SecurityForce

Abstract methods
      ↓
attack()
defend()

Child implementations
      ↓
Army / Navy / AirForce

Parent reference + child objects
      ↓
Runtime polymorphism
```
