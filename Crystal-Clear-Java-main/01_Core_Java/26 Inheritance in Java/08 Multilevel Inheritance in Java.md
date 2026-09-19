# 🧒 Multilevel Inheritance in Java

**Multilevel Inheritance** means inheritance happens in **levels**.

The easiest way to remember it is:

> 🧠 **Parent → Child → Grandchild**

In your example:

```text
Animal
   ↓
Carnivorous
   ↓
Tiger
```

So:

* `Animal` → Parent
* `Carnivorous` → Child of `Animal`
* `Tiger` → Grandchild of `Animal`

---

# 1. Level 1 — `Animal`

Let's create the top-level parent class:

```java
class Animal {

    void breathe() {
        System.out.println("Animal is breathing");
    }
}
```

`Animal` has a common behavior:

```text
breathe()
```

---

# 2. Level 2 — `Carnivorous`

Now create a child of `Animal`:

```java
class Carnivorous extends Animal {

    void eatMeat() {
        System.out.println("Carnivorous animal eats meat");
    }
}
```

Here:

```java
class Carnivorous extends Animal
```

means:

> `Carnivorous` inherits from `Animal`.

So `Carnivorous` can use:

```text
breathe()   ← inherited
```

and has its own:

```text
eatMeat()   ← own method
```

---

# 3. Level 3 — `Tiger`

Now create another child:

```java
class Tiger extends Carnivorous {

    void hunt() {
        System.out.println("Tiger is hunting");
    }
}
```

Here:

```java
class Tiger extends Carnivorous
```

means:

> `Tiger` inherits from `Carnivorous`.

Since `Carnivorous` itself inherits from `Animal`, `Tiger` can access the accessible inherited members from both levels.

---

# 4. Complete Program

```java
class Animal {

    void breathe() {
        System.out.println("Animal is breathing");
    }
}

class Carnivorous extends Animal {

    void eatMeat() {
        System.out.println("Carnivorous animal eats meat");
    }
}

class Tiger extends Carnivorous {

    void hunt() {
        System.out.println("Tiger is hunting");
    }
}

class Demo {

    public static void main(String[] args) {

        Tiger t = new Tiger();

        t.breathe();
        t.eatMeat();
        t.hunt();
    }
}
```

### Output

```text
Animal is breathing
Carnivorous animal eats meat
Tiger is hunting
```

---

# 5. Where Did `breathe()` Come From?

We wrote:

```java
t.breathe();
```

But `breathe()` isn't inside `Tiger`.

It is inside:

```text
Animal
```

How can Tiger use it?

Because:

```text
Tiger
  ↓
Carnivorous
  ↓
Animal
```

So the inheritance chain allows `Tiger` to access the inherited method.

---

# 6. Where Did `eatMeat()` Come From?

We wrote:

```java
t.eatMeat();
```

This method belongs to:

```text
Carnivorous
```

Since:

```java
class Tiger extends Carnivorous
```

Tiger can access it.

---

# 7. What Belongs to Tiger?

Tiger has its own method:

```java
void hunt() {
    System.out.println("Tiger is hunting");
}
```

So a `Tiger` object can access:

```text
Tiger
 ├── breathe()  ← from Animal
 ├── eatMeat()  ← from Carnivorous
 └── hunt()     ← Tiger's own
```

---

# 🧠 8. The Complete Hierarchy

```text
                 Animal
              Parent / Level 1
                   │
                extends
                   ↓
              Carnivorous
              Child / Level 2
                   │
                extends
                   ↓
                 Tiger
           Grandchild / Level 3
```

Or simply:

```text
Animal
   ↓
Carnivorous
   ↓
Tiger
```

This is **Multilevel Inheritance**.

---

# 9. Why "Multi-Level"?

Because there are **multiple levels of inheritance**.

```text
Level 1 → Animal
             ↓
Level 2 → Carnivorous
             ↓
Level 3 → Tiger
```

It's not about having multiple parents.

It's about having **multiple inheritance levels in a chain**.

---

# 10. Very Important Difference

Don't confuse:

### Hierarchical inheritance

```text
        Animal
       /      \
     Tiger    Lion
```

One parent → multiple children.

### Multilevel inheritance

```text
Animal
   ↓
Carnivorous
   ↓
Tiger
```

Parent → Child → Grandchild.

---

# 🧒 Real-Life Example

Think about a family tree:

```text
Grandparent
    ↓
 Parent
    ↓
 Child
```

The child belongs to the family through multiple levels.

Java's multilevel inheritance works similarly:

```text
Animal
   ↓
Carnivorous
   ↓
Tiger
```

`Tiger` gets the accessible functionality along the inheritance chain.

---

# ⭐ Remember Forever

### Formula

```text
Parent
   ↓
Child
   ↓
Grandchild
```

= **Multilevel Inheritance**

### Your Example

```text
Animal
   ↓
Carnivorous
   ↓
Tiger
```

### 🔥 Interview Answer

> **Multilevel inheritance is a type of inheritance in which a class inherits from another class, and a third class inherits from that child class, forming a chain such as Parent → Child → Grandchild. For example, `Carnivorous extends Animal` and `Tiger extends Carnivorous`.**
