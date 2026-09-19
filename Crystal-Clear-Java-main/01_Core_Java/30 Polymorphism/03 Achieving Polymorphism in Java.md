# 🧒 Achieving Polymorphism in Java

**Polymorphism** can be achieved using a very important combination:

```text
Parent class reference
        +
Child class object
        +
Overridden method
        ↓
Runtime Polymorphism
```

Let's understand this using **Army, Navy, and AirForce**.

---

# 1. Create the Parent Class

Let's create a common parent class called `DefenseForce`.

```java
class DefenseForce {

    void attack() {
        System.out.println("Defense force attacks");
    }

    void defend() {
        System.out.println("Defense force defends");
    }
}
```

The parent has two common methods:

```text
DefenseForce
   ├── attack()
   └── defend()
```

---

# 2. Create the Army Class

`Army` extends `DefenseForce`.

```java
class Army extends DefenseForce {

    @Override
    void attack() {
        System.out.println("Army attacks using ground forces");
    }

    @Override
    void defend() {
        System.out.println("Army defends the land");
    }
}
```

Army provides its own implementation of:

```text
attack()
defend()
```

---

# 3. Create the Navy Class

```java
class Navy extends DefenseForce {

    @Override
    void attack() {
        System.out.println("Navy attacks using naval forces");
    }

    @Override
    void defend() {
        System.out.println("Navy defends the sea");
    }
}
```

Again, `Navy` overrides:

```text
attack()
defend()
```

---

# 4. Create the AirForce Class

```java
class AirForce extends DefenseForce {

    @Override
    void attack() {
        System.out.println("AirForce attacks using aircraft");
    }

    @Override
    void defend() {
        System.out.println("AirForce defends the air");
    }
}
```

Now all three child classes have their own implementations.

```text
                 DefenseForce
                 /     |      \
                /      |       \
             Army     Navy    AirForce
              ↓        ↓         ↓
           attack()  attack()  attack()
           defend()  defend()  defend()
```

---

# 5. The Most Important Part ⭐

Now we use a **parent class reference** to hold different child objects.

```java
DefenseForce force;

force = new Army();
force.attack();
force.defend();
```

Here:

```text
Reference → DefenseForce
Object    → Army
```

Output:

```text
Army attacks using ground forces
Army defends the land
```

---

Now we change only the object:

```java
force = new Navy();

force.attack();
force.defend();
```

Output:

```text
Navy attacks using naval forces
Navy defends the sea
```

Again:

```text
Reference → DefenseForce
Object    → Navy
```

---

Now:

```java
force = new AirForce();

force.attack();
force.defend();
```

Output:

```text
AirForce attacks using aircraft
AirForce defends the air
```

So the **same parent reference** can refer to different child objects.

---

# 6. Complete Program

```java
class DefenseForce {

    void attack() {
        System.out.println("Defense force attacks");
    }

    void defend() {
        System.out.println("Defense force defends");
    }
}

class Army extends DefenseForce {

    @Override
    void attack() {
        System.out.println("Army attacks using ground forces");
    }

    @Override
    void defend() {
        System.out.println("Army defends the land");
    }
}

class Navy extends DefenseForce {

    @Override
    void attack() {
        System.out.println("Navy attacks using naval forces");
    }

    @Override
    void defend() {
        System.out.println("Navy defends the sea");
    }
}

class AirForce extends DefenseForce {

    @Override
    void attack() {
        System.out.println("AirForce attacks using aircraft");
    }

    @Override
    void defend() {
        System.out.println("AirForce defends the air");
    }
}

class Demo {

    public static void main(String[] args) {

        DefenseForce force;

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
Army defends the land

Navy attacks using naval forces
Navy defends the sea

AirForce attacks using aircraft
AirForce defends the air
```

---

# 7. Where Is the Polymorphism?

Look carefully:

```java
DefenseForce force;
```

This is the **parent reference**.

Then:

```java
force = new Army();
```

The reference points to an **Army object**.

Then:

```java
force = new Navy();
```

The same reference points to a **Navy object**.

Then:

```java
force = new AirForce();
```

The same reference points to an **AirForce object**.

So:

```text
             DefenseForce force
                    │
       ┌────────────┼────────────┐
       ↓            ↓            ↓
   new Army()   new Navy()   new AirForce()
       ↓            ↓            ↓
    attack()     attack()     attack()
    defend()     defend()     defend()
```

One parent reference can represent **multiple child forms**.

That's polymorphism.

---

# 8. Runtime Decision

Consider:

```java
force = new Army();
force.attack();
```

Java sees the actual object:

```text
Army
```

So:

```text
force.attack()
      ↓
Army.attack()
```

Then:

```java
force = new Navy();
force.attack();
```

The actual object is now:

```text
Navy
```

So:

```text
force.attack()
      ↓
Navy.attack()
```

And:

```java
force = new AirForce();
force.attack();
```

becomes:

```text
force.attack()
      ↓
AirForce.attack()
```

The decision about the overridden method implementation happens at **runtime**.

---

# 🧠 Easy Real-Life Understanding

Suppose a commander gives one common order:

> **"Attack!"**

The order is the same.

But different forces perform it differently:

```text
"Attack!"
    ↓
Army     → Ground attack
Navy     → Naval attack
AirForce → Air attack
```

Similarly:

```text
force.attack();
```

is the same method call.

But the behavior changes according to the actual object.

---

# ⭐ Remember Forever

### Formula

```text
Parent Reference
        +
Child Object
        +
Overridden Method
        ↓
Runtime Polymorphism
```

### Your example

```text
             DefenseForce
              reference
                  ↓
       ┌──────────┼──────────┐
       ↓          ↓          ↓
     Army        Navy      AirForce
       ↓          ↓          ↓
    attack()   attack()   attack()
    defend()   defend()   defend()
```

### 🔥 Golden Rule

> **One parent reference can refer to different child objects, and the overridden method that executes depends on the actual child object at runtime.**

So:

```java
DefenseForce force = new Army();
```

means:

```text
Parent reference → Child object
```

and:

```java
force.attack();
```

means:

```text
Runtime decides → Army.attack()
```

This is how **runtime polymorphism is achieved in Java**.
