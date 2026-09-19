# 🧒 Hierarchical Inheritance in Java

**Hierarchical Inheritance** sounds complicated, but the idea is very simple:

> 🧠 **One parent class → Multiple child classes**

In your example:

```text
             NationalSecurity
             /      |       \
            ↓       ↓        ↓
          Army     Navy    AirForce
```

There is **one common parent** and **multiple children**.

---

# 1. One Parent Class

Let's create the parent:

```java id="u5bq1m"
class NationalSecurity {

    void protectNation() {
        System.out.println("Protecting the nation");
    }
}
```

`NationalSecurity` is the **parent class**.

It contains a common behavior:

```text
protectNation()
```

All three forces have the common purpose of protecting the nation.

---

# 2. Army — Child Class 🪖

```java id="x1s2k8"
class Army extends NationalSecurity {

    void protectLand() {
        System.out.println("Army protects the land");
    }
}
```

`Army` inherits from `NationalSecurity`.

So it gets access to:

```text
protectNation()
```

and has its own specialized behavior:

```text
protectLand()
```

---

# 3. Navy — Child Class ⚓

```java id="a7p3q9"
class Navy extends NationalSecurity {

    void protectSea() {
        System.out.println("Navy protects the sea");
    }
}
```

`Navy` also extends the same parent:

```java id="k4r6t2"
NationalSecurity
```

It gets:

```text
protectNation()
```

and has its own:

```text
protectSea()
```

---

# 4. AirForce — Child Class ✈️

```java id="m8v2c5"
class AirForce extends NationalSecurity {

    void protectAir() {
        System.out.println("AirForce protects the air");
    }
}
```

Again:

```text
NationalSecurity
      ↓
   AirForce
```

`AirForce` gets the common parent behavior and adds its own specialized behavior.

---

# 5. Complete Program

```java id="q3w8n1"
class NationalSecurity {

    void protectNation() {
        System.out.println("Protecting the nation");
    }
}

class Army extends NationalSecurity {

    void protectLand() {
        System.out.println("Army protects the land");
    }
}

class Navy extends NationalSecurity {

    void protectSea() {
        System.out.println("Navy protects the sea");
    }
}

class AirForce extends NationalSecurity {

    void protectAir() {
        System.out.println("AirForce protects the air");
    }
}

class Demo {

    public static void main(String[] args) {

        Army army = new Army();

        army.protectNation();
        army.protectLand();

        Navy navy = new Navy();

        navy.protectNation();
        navy.protectSea();

        AirForce airForce = new AirForce();

        airForce.protectNation();
        airForce.protectAir();
    }
}
```

### Output

```text
Protecting the nation
Army protects the land

Protecting the nation
Navy protects the sea

Protecting the nation
AirForce protects the air
```

---

# 6. Understand the Structure 🧠

The inheritance structure is:

```text
                NationalSecurity
                   ONE PARENT
                       │
          ┌────────────┼────────────┐
          ↓            ↓            ↓
        Army          Navy       AirForce
       CHILD          CHILD        CHILD
```

This is called **Hierarchical Inheritance**.

Why?

Because multiple child classes form a hierarchy under the same parent.

---

# 7. What Is Common?

The parent has:

```java
void protectNation()
```

This is a **common method**.

All children can use it:

```java
army.protectNation();
navy.protectNation();
airForce.protectNation();
```

So we write it **only once** in the parent.

---

# 8. What Is Specialized?

Each child has its own special behavior.

### Army

```java
protectLand()
```

### Navy

```java
protectSea()
```

### AirForce

```java
protectAir()
```

So:

```text
Army
 ├── protectNation() ← inherited
 └── protectLand()   ← own


Navy
 ├── protectNation() ← inherited
 └── protectSea()    ← own


AirForce
 ├── protectNation() ← inherited
 └── protectAir()    ← own
```

---

# 9. Why Not Repeat `protectNation()`?

Without inheritance, we might write:

```text
Army      → protectNation()
Navy      → protectNation()
AirForce  → protectNation()
```

That's duplicate code.

With hierarchical inheritance:

```text
             NationalSecurity
                    │
          protectNation()
                    │
       ┌────────────┼────────────┐
       ↓            ↓            ↓
     Army          Navy       AirForce
```

The common method is written **once**.

That's **code reusability**. ♻️

---

# 🧒 Real-Life Example

Imagine a big family:

```text
              Parent
          NationalSecurity
                  │
       ┌──────────┼──────────┐
       ↓          ↓          ↓
     Army        Navy     AirForce
```

The parent gives them something common:

> **Protect the nation.**

But each child has its own special responsibility:

```text
Army      → Land 🪖
Navy      → Sea ⚓
AirForce  → Air ✈️
```

---

# ⭐ How to Identify Hierarchical Inheritance

Whenever you see:

```text
           One Parent
          /    |    \
         /     |     \
     Child   Child   Child
```

think:

> **Hierarchical Inheritance**

### Formula:

```text
1 Parent
   +
Multiple Children
   ↓
Hierarchical Inheritance
```

---

# 🔥 Interview Answer

> **Hierarchical inheritance is a type of inheritance in which multiple child classes inherit from the same parent class. For example, `Army`, `Navy`, and `AirForce` can extend a common `NationalSecurity` parent class, allowing them to reuse its common functionality while providing their own specialized behaviors.**
