# 🧒 Hybrid Inheritance in Java

**Hybrid Inheritance** means:

> 🧠 **A combination of two or more types of inheritance.**

In your example, we can combine **hierarchical inheritance** with **multilevel inheritance**.

---

# 1. Start with `Animal`

`Animal` is our common parent class.

```java
class Animal {

    void breathe() {
        System.out.println("Animal is breathing");
    }
}
```

So:

```text
Animal
 └── breathe()
```

---

# 2. Create Different Types of Animals

We can divide animals into:

* 🌱 `Herbivorous`
* 🥩 `Carnivorous`
* 🍎🥩 `Omnivorous`

For example:

```java
class Herbivorous extends Animal {

    void eatPlants() {
        System.out.println("Herbivorous animal eats plants");
    }
}
```

```java
class Carnivorous extends Animal {

    void eatMeat() {
        System.out.println("Carnivorous animal eats meat");
    }
}
```

```java
class Omnivorous extends Animal {

    void eatPlantsAndMeat() {
        System.out.println("Omnivorous animal eats plants and meat");
    }
}
```

Now we have:

```text
                  Animal
                 /  |  \
                ↓   ↓   ↓
        Herbivorous Carnivorous Omnivorous
```

This part is **Hierarchical Inheritance**:

> One parent → multiple children.

---

# 3. Create `Cow`

A cow is a herbivorous animal.

```java
class Cow extends Herbivorous {

    void giveMilk() {
        System.out.println("Cow gives milk");
    }
}
```

Now:

```text
Animal
   ↓
Herbivorous
   ↓
Cow
```

This is **Multilevel Inheritance**.

---

# 4. Create `Tiger`

A tiger is a carnivorous animal.

```java
class Tiger extends Carnivorous {

    void hunt() {
        System.out.println("Tiger is hunting");
    }
}
```

Now:

```text
Animal
   ↓
Carnivorous
   ↓
Tiger
```

Again, this is **Multilevel Inheritance**.

---

# 5. What About `Dog`?

A dog is commonly modeled as an **omnivorous animal** in this simple example.

```java
class Dog extends Omnivorous {

    void bark() {
        System.out.println("Dog is barking");
    }
}
```

So:

```text
Animal
   ↓
Omnivorous
   ↓
Dog
```

---

# 6. Complete Structure

Now put everything together:

```text
                         Animal
                       /    |    \
                      /     |     \
                     ↓      ↓      ↓
            Herbivorous  Carnivorous  Omnivorous
                 ↓           ↓           ↓
                Cow         Tiger        Dog
```

This structure contains **different inheritance patterns together**.

### Hierarchical part:

```text
              Animal
             /   |   \
            ↓    ↓    ↓
     Herbivorous Carnivorous Omnivorous
```

One parent has multiple children.

### Multilevel parts:

```text
Animal
  ↓
Herbivorous
  ↓
Cow
```

```text
Animal
  ↓
Carnivorous
  ↓
Tiger
```

```text
Animal
  ↓
Omnivorous
  ↓
Dog
```

Therefore, this is a **combination of inheritance types**.

---

# 7. Complete Program

```java
class Animal {

    void breathe() {
        System.out.println("Animal is breathing");
    }
}

class Herbivorous extends Animal {

    void eatPlants() {
        System.out.println("Herbivorous animal eats plants");
    }
}

class Carnivorous extends Animal {

    void eatMeat() {
        System.out.println("Carnivorous animal eats meat");
    }
}

class Omnivorous extends Animal {

    void eatPlantsAndMeat() {
        System.out.println("Omnivorous animal eats plants and meat");
    }
}

class Cow extends Herbivorous {

    void giveMilk() {
        System.out.println("Cow gives milk");
    }
}

class Tiger extends Carnivorous {

    void hunt() {
        System.out.println("Tiger is hunting");
    }
}

class Dog extends Omnivorous {

    void bark() {
        System.out.println("Dog is barking");
    }
}

class Demo {

    public static void main(String[] args) {

        Cow cow = new Cow();

        cow.breathe();
        cow.eatPlants();
        cow.giveMilk();

        Tiger tiger = new Tiger();

        tiger.breathe();
        tiger.eatMeat();
        tiger.hunt();

        Dog dog = new Dog();

        dog.breathe();
        dog.eatPlantsAndMeat();
        dog.bark();
    }
}
```

### Output

```text
Animal is breathing
Herbivorous animal eats plants
Cow gives milk

Animal is breathing
Carnivorous animal eats meat
Tiger is hunting

Animal is breathing
Omnivorous animal eats plants and meat
Dog is barking
```

---

# 8. What Does Each Animal Get? 🧠

### 🐄 Cow

```text
Cow
 ↓
Herbivorous
 ↓
Animal
```

So Cow can access:

```text
breathe()      ← Animal
eatPlants()    ← Herbivorous
giveMilk()     ← Cow
```

---

### 🐅 Tiger

```text
Tiger
 ↓
Carnivorous
 ↓
Animal
```

So Tiger can access:

```text
breathe()      ← Animal
eatMeat()      ← Carnivorous
hunt()         ← Tiger
```

---

### 🐕 Dog

```text
Dog
 ↓
Omnivorous
 ↓
Animal
```

So Dog can access:

```text
breathe()              ← Animal
eatPlantsAndMeat()     ← Omnivorous
bark()                 ← Dog
```

---

# 🧒 Why Is It Called Hybrid?

Think about mixing two LEGO structures. 🧱

One structure is:

```text
       Animal
      /   |   \
     A    B    C
```

That's **Hierarchical**.

Another structure is:

```text
Animal
  ↓
Herbivorous
  ↓
Cow
```

That's **Multilevel**.

When these patterns are combined:

```text
                         Animal
                       /    |    \
                      ↓     ↓     ↓
                     Herb  Carn  Omni
                      ↓     ↓     ↓
                     Cow   Tiger  Dog
```

we call the overall structure **Hybrid Inheritance**.

---

# ⭐ Remember Forever

```text
Hybrid Inheritance
       ↓
Combination of inheritance types
       ↓
Hierarchical + Multilevel
       ↓
             Animal
            /   |   \
           ↓    ↓    ↓
        Herb   Carn  Omni
          ↓     ↓     ↓
         Cow   Tiger  Dog
```

### 🔥 Interview Answer

> **Hybrid inheritance is a combination of two or more types of inheritance. In the given example, `Animal` is inherited by `Herbivorous`, `Carnivorous`, and `Omnivorous`, forming hierarchical inheritance, while `Cow`, `Tiger`, and `Dog` extend those classes, forming multilevel inheritance. The combination forms a hybrid inheritance structure.**

**Important Java note:** Java does **not** support hybrid inheritance involving multiple inheritance of classes, because a class cannot extend multiple classes. The structure above is a hybrid combination that can be represented using single, hierarchical, and multilevel class inheritance.
